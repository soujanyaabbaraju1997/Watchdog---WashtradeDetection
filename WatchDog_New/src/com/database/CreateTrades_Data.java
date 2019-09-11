package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Random;

import org.fluttercode.datafactory.impl.DataFactory;

public class CreateTrades_Data {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x =100001;
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");

			        
			        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","group8","trade");  
			        System.out.println("Connection made.");
			        String sql="insert into trades values(?,?,?,?,?,?,?,?,?,?)"; 
			        String []val= new String[200];int j=0;
			        String []val1= new String[4];
			        String []val2= new String[3];
			 
			        String[] type = new String[]{"buy","sell"};
			        String[] brokers = new String[] {"ZERODHA", "UPSTOX", "SHAREKHAN", "FYERS", "ANGEL BROKING", 
			        		             "ICICI DIRECT", "5PAISA", "MOTILAL OSWAL"};
			        PreparedStatement p = con.prepareStatement(sql);
			        
			        Statement stmt=con.createStatement();  
					  
			        DataFactory df = new DataFactory();
			        ResultSet res=stmt.executeQuery("select trader_id from users where is_admin=0"); 
			        while(res.next())  	{	
			        val[j] = res.getString(1);j++;}
			        j=0;
			        ResultSet res1=stmt.executeQuery("select security_id from securities"); 
			        while(res1.next())  	{	
			        val1[j] = res1.getString(1);j++;}
			        j=0;
			        ResultSet res2=stmt.executeQuery("select firm_id from firms"); 
			        while(res2.next())  	{	
			        val2[j] = res2.getString(1);j++;}j=0;
			        

			        java.sql.Timestamp rand_time;
			        Random r = new Random();
			        
			        
			        long offset = Timestamp.valueOf("2019-09-08 00:00:00").getTime();
			        long end = Timestamp.valueOf("2019-09-09 00:00:00").getTime();
			        long diff = end - offset + 1;
			        
			        for (int i = 0; i < 200; i++) {
			        	
//			        	time=System.currentTimeMillis();
//			        	timestamp= new java.sql.Timestamp(time);
			        	
			        	rand_time = new Timestamp(offset + (long)(Math.random() * diff));
			    		
			        	String trader= df.getItem(val);
			    		String broker= df.getItem(brokers);
			    		String buysell=df.getItem(type);
			    		int firmid = Integer.parseInt(df.getItem(val2));
			    		int secid=Integer.parseInt(df.getItem(val1));
			    		int qty =df.getNumberBetween(1, 100000);
			    		int tradeid=x;  x = x+1;
			    		
			    	   
			    		
			    		String sql1 ="select highest_price, lowest_price from stocks where security_id=? and firm_id=?";
			    		PreparedStatement p1 = con.prepareStatement(sql1);
			    		float high =0f, low=0f;
			    		p1.setInt(1, secid);
			    		p1.setInt(2, firmid);
			    		ResultSet set = p1.executeQuery();
			    		while(set.next()) {
			    			high = set.getFloat("HIGHEST_PRICE");
			    			low=set.getFloat("LOWEST_PRICE");
			    			
			    		}
			    		
			    		double price = low + r.nextDouble() * (high - low);
			    	
			    	    
			    	    p.setInt(1,tradeid);
			    	    p.setString(2, trader);
			    	    p.setTimestamp(3, rand_time);
			    	    p.setString(4, buysell);
			    	    p.setInt(5,secid);
			    	    p.setInt(6, qty);
			    	    p.setDouble(7, price);
			    	    p.setInt(8, firmid);
			    	    p.setString(9, broker);
			    	    p.setInt(10, 0);
			    	    p.executeUpdate();
			    		
			    		
			    	} System.out.println("executed\n"+" x = "+x);
			        
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

					// TODO Auto-generated method stub

				}
	}
