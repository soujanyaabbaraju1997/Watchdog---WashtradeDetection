//package com.database;
//
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.sql.Timestamp;
//import java.util.Random;
//import java.util.Scanner;
//
//import org.fluttercode.datafactory.impl.DataFactory;
//
//public class Trades_Thread extends Thread {
//	
//	@Override
//	public void run() {
//		//System.out.println("in thread: "+Thread.currentThread().getName());
//		
//		Connection con=openConnection();
//		
//	
//		while(true) {
//			 insert_trade(con);
//			 try {
//				Thread.sleep(5000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		
//	}
//	
//	private Connection openConnection() {
//		Connection con = null;
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			System.out.println("Driver loaded successfully");
//
//			// 2. get the connection
//			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "group8", "trade");
//			System.out.println("Connection obtained.");
//
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			//e.printStackTrace();
//		}
//
//		return con;
//	}
//	 public int getCount(Connection conn) {
//		 int ans=0;
//		//String sql = "select count(*) as total from trades";
//		String sql = "select max(trade_id) as total from trades"; 
//				
//		 
//		 try {
//			Statement stmt=conn.createStatement();
//			ResultSet set = stmt.executeQuery(sql);
//			while(set.next()) {
//				ans=set.getInt("total");
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		 return ans;
//		
//	 }
//	 
//	 
//
//	public int insert_trade(Connection con) {
//		int isInserted=0;
//		Trades_Thread t = new Trades_Thread();
//		int tradeID = t.getCount(con);
//		
//		
//		try {
//			       
//		        //Connection con=openConnection();
//		        //System.out.println("Connection made.");
//		        String sql="insert into trades values(?,?,?,?,?,?,?,?,?,?)"; 
//		        String []val= new String[200];int j=0;
//		        String []val1= new String[4];
//		        String []val2= new String[3];
//		        String[] brokers = {"ZERODHA", "UPSTOX", "SHAREKHAN", "FYERS", "ANGEL BROKING", 
//   		             "ICICI DIRECT", "5PAISA", "MOTILAL OSWAL"};
//		        String[] bool = {"true","false"};
//		        
//		        PreparedStatement p = con.prepareStatement(sql);		        
//		        Statement stmt=con.createStatement();  
//				  
//		        DataFactory df = new DataFactory();
//		        ResultSet res=stmt.executeQuery("select trader_id from users"); 
//		        while(res.next())  	{	
//		        val[j] = res.getString(1);j++;}
//		        j=0;
//		        ResultSet res1=stmt.executeQuery("select security_id from securities"); 
//		        while(res1.next())  	{	
//		        val1[j] = res1.getString(1);j++;}
//		        j=0;
//		        ResultSet res2=stmt.executeQuery("select firm_id from firms"); 
//		        while(res2.next())  	{	
//		        val2[j] = res2.getString(1);j++;}j=0;
//		        
//		     
//		        long time;
//		        Random r = new Random();
//		        
//	       
//		        	
//		        	time=System.currentTimeMillis();
//		        	Timestamp timestamp= new java.sql.Timestamp(time);        	
//		     
//		    		
//		        	String trader= df.getItem(val);
//		    		String broker= df.getItem(brokers);
//		    		String buysell=df.getItem(bool);
//		    		int firmid = Integer.parseInt(df.getItem(val2));
//		    		int secid=Integer.parseInt(df.getItem(val1));
//		    		
//		    		String sql1 ="select highest_price, lowest_price from stocks where security_id=? and firm_id=?";
//		    		PreparedStatement p1 = con.prepareStatement(sql1);
//		    		float high =0f, low=0f;
//		    		p1.setInt(1, secid);
//		    		p1.setInt(2, firmid);
//		    		ResultSet set = p1.executeQuery();
//		    		while(set.next()) {
//		    			high = set.getFloat("HIGHEST_PRICE");
//		    			low=set.getFloat("LOWEST_PRICE");
//		    			
//		    		}
//		    	
//		    		
//		    		double price = low + r.nextDouble() * (high - low);		    		
//		    	    int qty =df.getNumberBetween(1, 100000);
//		    	    
//		    	    tradeID = tradeID+1;
//		    	    p.setInt(1,tradeID); 
//		    	    p.setString(2, trader);
//		    	    p.setTimestamp(3, timestamp);
//		    	    p.setString(4, buysell);
//		    	    p.setInt(5,secid);
//		    	    p.setInt(6, qty);
//		    	    p.setDouble(7, price);
//		    	    p.setInt(8, firmid);
//		    	    p.setString(9, broker);
//		    	    p.setInt(10, 0);
//		    	   isInserted= p.executeUpdate();
//		    	   con.commit();
//		    	   if(isInserted!=0)
//		    	   { System.out.println("Trade inserted"); }
//		    	   else {System.out.println("Trade not inserted.");}
//		    	   System.out.println("No. of records: "+tradeID+"\n");
//		    	
//		        
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//				// TODO Auto-generated method stub
//		
//		return isInserted;
//
//}
//	
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		System.out.println("in thread: "+Thread.currentThread().getName());
//		Trades_Thread thread = new Trades_Thread();
//		thread.start();
//
//	}
//
//}
