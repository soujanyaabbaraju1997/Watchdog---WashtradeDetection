package com.dao;

import java.sql.Date;
import java.sql.Time;
import java.util.Scanner;

import com.pojos.Trade;
import com.pojos.Trader;
import com.pojos.User;

public class CheckImplementations
{

	public static void main(String[] args) 
	{
		
//		================================================================================================================
//											add user		

//		UserDAO udao = new UserDAOImpl();
//		Scanner sc = new Scanner(System.in);
//		
//		System.out.println("Enter username: ");
//		String username = sc.next();
//		System.out.println("Enter password: ");
//		String password = sc.next();
//		System.out.println("Enter email id: ");
//		String email = sc.next();
//		System.out.println("Enter phone: ");
//		long phone = sc.nextLong();
//		System.out.println("Enter year of birth: ");
//		int yr = sc.nextInt();
//		System.out.println("Enter month of birth: ");
//		int mth = sc.nextInt();
//		System.out.println("Enter date of birth: ");
//		int dt = sc.nextInt();
//		Date dob = new Date(yr, mth, dt);
//		
//		User user = new User(username, password, email, phone, dob);
//		
//		int inserted = udao.addUser(user);
//		if(inserted>0)
//		{
//			System.out.println("NEW ADMIN IS INSERTED.");
//		}
//		else
//		{
//			System.out.println("ADMIN NOT INSERTED.");
//		}
		
		
//		================================================================================================================
//												add trader	
		
//	TraderDAO udao = new TraderDAOImpl();
//	Scanner sc = new Scanner(System.in);
//	
//	
//	System.out.println("Enter trader_id: ");
//	int tid = sc.nextInt();
//	System.out.println("Enter trader_name: ");
//	String tname = sc.next();
//	System.out.println("Enter year of reg: ");
//	int yrr = sc.nextInt();
//	System.out.println("Enter month of reg: ");
//	int mthr = sc.nextInt();
//	System.out.println("Enter date of reg: ");
//	int dtr = sc.nextInt();
//	Date dor = new Date(yrr, mthr, dtr);
//	System.out.println("Enter username: ");
//	String username = sc.next();
//	System.out.println("Enter password: ");
//	String password = sc.next();
//	System.out.println("Enter email id: ");
//	String email = sc.next();
//	System.out.println("Enter phone: ");
//	long phone = sc.nextLong();
//	System.out.println("Enter year of birth: ");
//	int yr = sc.nextInt();
//	System.out.println("Enter month of birth: ");
//	int mth = sc.nextInt();
//	System.out.println("Enter date of birth: ");
//	int dt = sc.nextInt();
//	Date dob = new Date(yr, mth, dt);
//	sc.close();
//	
//	Trader trader = new Trader(tid, tname, dor, username, password, email, phone, dob);
//	
//	int inserted = udao.addTrader(trader);
//	if(inserted>0)
//	{
//		System.out.println("NEW TRADER IS INSERTED.");
//	}
//	else
//	{
//		System.out.println("TRADER NOT INSERTED.");
//	}
	
//		================================================================================================================
//										update email
//	UserDAO udao = new UserDAOImpl();
//	Scanner sc = new Scanner(System.in);
//	
//	
//	System.out.println("Enter username: ");
//	String uname = sc.next();
//	System.out.println("Enter new email: ");
//	String email = sc.next();
//	boolean var = udao.updateEmailId(uname, email);
//	if(var==true)
//		System.out.println("UPDATED");
	
		
//=======================================================================================================================
//									update phone
		
//		UserDAO udao = new UserDAOImpl();
//		Scanner sc = new Scanner(System.in);
//	
//		System.out.println("Enter username: ");
//		String uname = sc.next();
//		System.out.println("Enter new phone: ");
//		long phone = sc.nextLong();
//		boolean var = udao.updatePhone(uname, phone);
//		if(var==true)
//			System.out.println("UPDATED");
	


//=======================================================================================================================
//								update password	
		
//		UserDAO udao = new UserDAOImpl();
//		Scanner sc = new Scanner(System.in);
//	
//		System.out.println("Enter username: ");
//		String uname = sc.next();
//		System.out.println("Enter new password: ");
//		String password = sc.next();
//		boolean var = udao.updatePassword(uname, password);
//		if(var==true)
//			System.out.println("UPDATED");	
		

//=========================================================================================================================
//								find by username
		
//		String username = "singhs";
//		UserDAO udao = new UserDAOImpl();
//		System.out.println("USER DETAILS:");
//		User user = udao.findUserByUsername(username);
//		System.out.println(user.toString());
		
//=========================================================================================================================
//								delete user		
		
//		String username = "singhs";
//		UserDAO udao = new UserDAOImpl();
//		User user = udao.deleteUser(username);
//		System.out.println(user);
		
		
//=========================================================================================================================
//								add trade
		TradeDAO tdao = new TradeDAOImpl();
		long millis=System.currentTimeMillis();  
		java.sql.Time time=new java.sql.Time(millis);
		TraderDAO trdao = new TraderDAOImpl();
		Trader t = new Trader();
		t = trdao.findTraderById("BTP5KFB5");
		t.toString();
		Trade trade = new Trade(999999, t, time,"false", 303030, 10, 100.10f, 101111, "JVDEW", 0);

		System.out.println(tdao.addTrade(trade));
		
		
	}
}
