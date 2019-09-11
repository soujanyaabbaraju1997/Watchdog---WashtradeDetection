package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;


public class CreateStocks_Data {
	
	private Connection openConnection() {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver loaded successfully");

			// 2. get the connection
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "group8", "trade");
			System.out.println("Connection obtained.");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return con;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CreateStocks_Data obj = new CreateStocks_Data();
		
//		int [] stockID= {1011,1012,1013,1014,1021,1022,1023,1024,1031,1032,1033,1034};
		int [] firmID = new int[3];
		int [] securityID = new int[4];
		double [] max_price = {186.8017, 190.5377, 196.1417, 196.2333, 
								117.96,120.3192,123.858,123.7622,
				               191.36, 195.187, 200.928, 200.054};
		double [] min_price = {183.4585, 187.1276, 192.6314, 192.7823, 
				              115.27, 117.5754, 121.0335, 121.5467,
				              187.94, 191.6988, 197.337, 197.222};
		
		
	try {
		
		Connection con = obj.openConnection();
		Statement st = con.createStatement();
		ResultSet set = st.executeQuery("select * from firms ");
		int t=0;
		while (set.next()) {
			
			firmID[t] = set.getInt("FIRM_ID");
			t++;		
		}
		
		set = st.executeQuery("select * from securities ");
		t=0;
		while (set.next()) {
			
			securityID[t] = set.getInt("SECURITY_ID");
			t++;		
		}
		
			
		 String sql="insert into stocks values(?,?,?,?,?)"; 
		 PreparedStatement p = con.prepareStatement(sql);
	
		 
		 Random r = new Random();
		
		 
		 int s=0;
		 for(int i =0;i<firmID.length;i++){
			 for(int j=0;j<securityID.length;j++) {				 
		   		
			
			double ltp = min_price[s] + r.nextDouble()* (max_price[s]-min_price[s]);
				 	
				//	p.setInt(1, stockID[s]); 
					p.setInt(1, firmID[i]);
					p.setInt(2, securityID[j]);
					p.setDouble(3, max_price[s]); //highest_price
					p.setDouble(4, min_price[s]); //lowest_price					
					p.setDouble(5, ltp); //ltp					
					p.executeUpdate();
					s++; 
					
			 }
			}
		 System.out.println("Done!");
				
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		

  }
}

