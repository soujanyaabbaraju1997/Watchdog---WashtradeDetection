package com.dao;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;
import java.util.Scanner;

import com.pojos.Stock;
import com.pojos.Trade;
import com.pojos.Trader;
import com.pojos.User;

public class CheckImplementations
{

	public static void main(String[] args) 
	{
		//=========================================================================================================================
		//								add stock
//		StockDAO dao = new StockDAOImpl();
//		Stock stock = new Stock (102, 7000, 100, 50, 90);
//		System.out.println(dao.addRecord(stock));
		
		//=========================================================================================================================
		//								find all trades
//		
//		TradeDAO tdao = new TradeDAOImpl();
//		List<Trade> list = tdao.findAllTrades();
//		list.forEach((st)->{
//			System.out.println(st);
//		});		
//		
		//=========================================================================================================================
		//									find trades by trader id
		
//		String traderId = "";
//		TradeDAO dao = new TradeDAOImpl();
//		System.out.println("DETAILS:");
//		List<Trade> list = dao.findByTraderId("JHZ6EH2A");
		//System.out.println(user.toString());		
		
		//=========================================================================================================================
		//									find trade by trade id
		
//		int tradeId = 101010;
//		TradeDAO dao = new TradeDAOImpl();
//		System.out.println("DETAILS:");
//		Trade user = dao.findTradeById(tradeId);
//		System.out.println(user.toString());
		
		
		//=========================================================================================================================
		//								ADD TRADES
		
//		TradeDAO dao = new TradeDAOImpl();
//		Scanner sc = new Scanner(System.in);
//				
//		System.out.println("Enter trade_id: ");
//		int tid = sc.nextInt();
//		System.out.println("Enter trader_id: ");
//		String trid = sc.next();
//		//System.out.println("Enter timestamp: ");
//		//Time time = new Time(15, 20, 00);
//		Timestamp time= new Timestamp(1999, 3, 12, 7, 10, 0, 0);
//		System.out.println("enter type");
//		String type= sc.next();
//		System.out.println("Enter sec id: ");
//		int secid = sc.nextInt();
//		System.out.println("Enter qty: ");
//		int qty = sc.nextInt();
//		System.out.println("Enter deal price: ");
//		Float dp = sc.nextFloat();
//		System.out.println("Enter firm id ");
//		int fid= sc.nextInt();
//		System.out.println("enter broker id");
//		String bid= sc.next();
//		System.out.println("is wash trade?");
//		int wt= sc.nextInt();
//		
//		System.out.println("taken all inputs.");
//		TraderDAO tdao = new TraderDAOImpl();
//		Trader t =  tdao.findByTraderID(trid);
//		Trade trade = new Trade(tid, t, time, type, secid, qty, dp, fid, bid, wt);
//		
//		System.out.println(trade);
//	
//		int inserted = dao.addTrade(trade);
//		if(inserted>0)
//		{
//			System.out.println("NEW TRADE IS INSERTED.");
//		}
//		else
//		{
//			System.out.println("TRADE NOT INSERTED.");
//		}
		
		
		//=========================================================================================================================
		//					find all traders
		
//		TraderDAO tdao = new TraderDAOImpl();
//		List<Trader> list = tdao.findAllTraders();
//		list.forEach((st)->{
//			System.out.println(st);
//		});
		
		
		//=========================================================================================================================
		//			find trader by tradername
//		String traderId = "WSYHBBNS";
//		TraderDAO sdao = new TraderDAOImpl();
//		System.out.println("DETAILS:");
//		Trader stu = sdao.findByTraderID(traderId);
//		
//		System.out.println(stu.getUsername());
//		System.out.println(stu.getPassword());
		
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
////		
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
//		
		
//		================================================================================================================
//												add trader	
		
//	TraderDAO udao = new TraderDAOImpl();
//	Scanner sc = new Scanner(System.in);
//	
//	
//	System.out.println("Enter trader_id: ");
//	String tid = sc.next();
//	System.out.println("Enter trader_name: ");
//	String tname = sc.next();
//	
//	System.out.println("Enter year of reg: ");
//	int yrr = sc.nextInt();
//	System.out.println("Enter month of reg: ");
//	int mthr = sc.nextInt();
//	System.out.println("Enter date of reg: ");
//	int dtr = sc.nextInt();
//	Date dor = new Date(yrr, mthr, dtr);
//	
//	System.out.println("Enter username: ");
//	String username = sc.next();
//	System.out.println("Enter password: ");
//	String password = sc.next();
//	System.out.println("Enter email id: ");
//	String email = sc.next();
//	System.out.println("Enter phone: ");
//	long phone = sc.nextLong();
//	
//	System.out.println("Enter year of birth: ");
//	int yr = sc.nextInt();
//	System.out.println("Enter month of birth: ");
//	int mth = sc.nextInt();
//	System.out.println("Enter date of birth: ");
//	int dt = sc.nextInt();
//	Date dob = new Date(yr, mth, dt);
//	
//	//sc.close();
//	System.out.println("taken all inputs.");
//	Trader trader = new Trader(tid, tname, dor, username, password, email, phone, dob);
//	System.out.println(trader);
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
		
//		String username = "aaaaa";
//		UserDAO udao = new UserDAOImpl();
//		System.out.println("USER DETAILS:");
//		User user = udao.findUserByUsername(username);
//		System.out.println(user.toString());
		
//=====================================================================
		
//		String traderId = "OS7HPJJS";
//		TraderDAO tdao = new TraderDAOImpl();
//		System.out.println("USER DETAILS:");
//		Trader t = tdao.findTraderById(traderId);
//		System.out.println(t);
		
//=========================================================================================================================
//								delete user		
		
//		String username = "aaaaa";
//		UserDAO udao = new UserDAOImpl();
//		User user = udao.deleteUser(username);
//		System.out.println(user);	
		
	}
}
