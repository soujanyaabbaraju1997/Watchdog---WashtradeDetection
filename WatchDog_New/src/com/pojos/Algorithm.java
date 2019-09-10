package com.pojos;
import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;
public class Algorithm {
	private static Connection openConnection() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("DRIVER LOADED SUCCESSFULLY");
			//conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "group8", "trade");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "admin");
			System.out.println("CONNECTION OBTAINED");
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
		}

		return conn;
	}


	public static void main(String[] args) {
		
		Connection connection = openConnection();
		
		
		
		Map<String, Map<Integer, List<Trade>>> map = people
			    .collect(Collectors.groupingBy(Person::getName,
			        Collectors.groupingBy(Person::getAge));

//		Trader td1 = new Trader(1, harish, dateReg, trades)
//		Trade t1 = new Trade(0, td1, timeStamp, tradeType, securityId, qty, dealPrice, firmId, brokerId);
//		ArrayList<Trade> SortedTradeList = new ArrayList<>();//sorted by date first and then reverse alphabet
//		ArrayList<Integer> TraderList = new ArrayList<>();//sorted by date first and then reverse alphabet
//		ArrayList<Integer> BrokerList = new ArrayList<>();//sorted by date first and then reverse alphabet
//		ArrayList<Integer> FirmList = new ArrayList<>();//sorted by date first and then reverse alphabet
//		ArrayList<ResultList> resultlist = new ArrayList<>(); 
//		
//		
//		double Quan;
//		int TotalSum = 0;
//		double PB = 0;
//		double PS = 0;
//		int Buy = 0;
//		int sell = 0;
//		
//		
//		for (Integer trader_id : TraderList) {
//			for (Integer Firm_id : FirmList) {
//				for (Integer Broker_id : BrokerList) {
//					for (Trade trade_id : SortedTradeList) {
//						if (securityId == E){
//							if (trade_id.isTradeType()) {
//								Buy += trade_id.getQty(); 
//								PB += trade_id.getQty()*trade_id.getDealPrice();
//							} 
//							else {
//								sell += trade_id.getQty();
//								PS += trade_id.getQty()*trade_id.getDealPrice();
//								}
//						}
//					}
//					
//						Quan += (Buy - sell);
//						if (Quan < 0 ) {
//							break;
//						}
//					int small_buy = 0;
//					int small_sell = 0;
//					
//					for (Trade trade_id : SortedTradeList) {
//						
//						if (securityId == OC){
//							if (trade_id.isTradeType()) {
//								small_buy +=  trade_id.getQty();
//								Buy += trade_id.getQty(); 
//								PB += trade_id.getQty()*trade_id.getDealPrice();
//							} 
//							else {
//								small_sell +=  trade_id.getQty();
//								sell += trade_id.getQty();
//								PS += trade_id.getQty()*trade_id.getDealPrice();
//								}
//						}
//					}	
//						if ((Buy - sell) < 0 || (small_buy - small_sell) < 0) {
//							break;
//						}
//					
//					small_buy = 0;
//					small_sell = 0;
//					
//					for (Trade trade_id : SortedTradeList) {
//								
//						if (securityId == OP){
//							if (trade_id.isTradeType() == false) {
//								Buy += trade_id.getQty(); 
//								PB += trade_id.getQty()*trade_id.getDealPrice();
//							} 
//							else {
//								sell += trade_id.getQty();
//								PS += trade_id.getQty()*trade_id.getDealPrice();
//								}
//						}
//					}
//					
//						if ((Buy - sell) < 0 || (small_buy - small_sell) < 0) {
//							break;
//						}
//						
//					
//					for (Trade trade_id : SortedTradeList) {
//							
//						if (securityId == F){
//							if (trade_id.isTradeType()) {
//								Buy += trade_id.getQty(); 
//								PB += trade_id.getQty()*trade_id.getDealPrice();
//							} 
//							else {
//								sell += trade_id.getQty();
//								PS += trade_id.getQty()*trade_id.getDealPrice();
//								}
//						}
//					}
//					
//					if ((Buy - sell) != 0 ) {
//						break;
//					}
//					else {
//						if ((PS - PB)/ PB > 0.05) {
//							break;
//						}
//						else {
//							ResultList r1 = new ResultList(trader_id, Broker_id, Firm_id);
//							resultlist.add(r1);
//						}
//						}
//	
//					}
//				System.out.println("Suspected trades");
//				System.out.println(resultlist);
//				}
//			}
//		}
//		
		
	}
}
