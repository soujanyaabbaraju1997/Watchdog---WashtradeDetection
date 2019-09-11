package com.database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.util.concurrent.atomic.LongAdder;

import org.fluttercode.datafactory.impl.DataFactory;



public class CreateUsers_Data {

	public static void main(String[] args) {
	
	
	try{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        
        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","group8","trade");  
        System.out.println("Connection made.");
        String sql="insert into users values(?,?,?,?,?,?,?,?,?)"; 
        
        PreparedStatement p = con.prepareStatement(sql);
        DataFactory df = new DataFactory();
    
       java.sql.Date minDate = new java.sql.Date (df.getDate(2019,8,30).getTime());
       java.sql.Date maxDate = new java.sql.Date(0);
   
	for (int i = 0; i < 200; i++) {
		
		
		String name = df.getName();
		java.sql.Date start =  new java.sql.Date( df.getDateBetween(minDate, maxDate).getTime());
		
		String [] parts = name.split(" ");
		String uname = parts[0] + df.getNumberBetween(10, 99);
		String id = (uname.substring(0,3)).toUpperCase() + randomstring.getAlphaNumericString(5); 
		
		String pass =df.getRandomChars(8);
		String email=df.getEmailAddress();
	    long phone1 = 9000000000l;
		long phone2 = df.getNumberBetween(10000000, 99999999);
		long phone= phone1+phone2; 
		java.sql.Date dob=new java.sql.Date( df.getBirthDate().getTime());
		
		p.setString(1, id);
		p.setString(2, name);
		p.setDate(3,start);
		p.setString(4, uname);
		p.setString(5, pass);
		p.setString(6, email);
		p.setLong(7, phone);
		p.setDate(8,dob);
		p.setInt(9, 0);
		
		 p.executeUpdate();
	        
	}
	System.out.println("executed");
}catch(Exception e) {
    System.out.println(e.getMessage()); 
}
}
}
