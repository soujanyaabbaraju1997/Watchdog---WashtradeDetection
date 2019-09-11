package com.pojos;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.dao.BrokerDAO;
import com.dao.BrokerDAOImpl;
import com.dao.FirmDAO;
import com.dao.FirmDAOImpl;
import com.dao.TradeDAO;
import com.dao.TradeDAOImpl;
import com.dao.TraderDAO;
import com.dao.TraderDAOImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
public class Algorithm {
	
	private static List<List<Trade>> answer = null ;
	
	public static void powerSet(List<Trade> list, int index, List<Trade> curr) //index = -1
		{ 
		  int n = list.size(); 
		
		  // base case 
		  if (index == n) 
		  {
			  answer.add(list);
			  return ; 
		  }
		
		  // First print current subset 
		  answer.add(curr) ;
		
		  // Try appending remaining characters 
		  // to current subset 
		  for (int i = index + 1; i < n; i++) { 
		
		      curr.add(list.get(i)); 
		      powerSet(list, i, curr); 
		
		      // Once all subsets beginning with 
		      // initial "curr" are printed, remove 
		      // last character to consider a different 
		      // prefix of subsets. 
		      curr.remove(curr.size() - 1); 
		  } 
		  return ; 
		}	
	public static int sumofSubset(List<Trade> list)
	{
		int sum = 0 ;
		
		for(Trade t : list)
		{
			sum += t.getQty() ;
		}
		return sum;
	}
	
	public static float profit(List<Trade> list)
	{
		float sell = 0 ;
		float buy = 0 ;
		
		for(Trade t : list)
		{
			int type ;
			if(t.isTradeType() == "buy")
				buy += (t.getQty() * t.getDealPrice()) ;
			else
				sell += (t.getQty() * t.getDealPrice()) ;
		}
		return (float)((float)(sell - buy)/(float)buy) ;
	}
	public static void main(String[] args)
	{
		
		
		TraderDAO dao = new TraderDAOImpl();
		TradeDAO tdao = new TradeDAOImpl();
		BrokerDAO bdao = new BrokerDAOImpl();
		FirmDAO fdao = new FirmDAOImpl();
		
		List<String> traders = dao.findAllTraders();
		List<Trade> washTrades = null ;
			
		for(String trader : traders)
		{
			Stream<Trade> trades =  (Stream<Trade>) tdao.findByTraderId(trader) ;
			List<Broker> brokers = bdao.findAllBrokers() ;
			List<Firm> firms = fdao.findAllFirms() ;
			Map<String, Map< Integer , List<Trade>>> map = trades.collect(Collectors.groupingBy(Trade::getBrokerId,Collectors.groupingBy(Trade::getFirmId)));

			for(Broker broker : brokers)
			{
				for(Firm firm : firms)
				{		
					
					//for each set of trader, broker and firm we get the list of total trades 
					
					List<Trade> Total = map.get(broker).get(firm) ;
					
					
					
					List<Trade> Equity = null ;
					List<Trade> Future = null ;
					List<Trade> OptionPut = null ;
					List<Trade> OptionCall = null ;
				
					// now we separate the types of securities into separate lists
					
					for(Trade row : Total)
					{
						if(row.getSecurityId() == 7890) //equity
						{
							if(row.isTradeType()=="buy") //if it is buy)
							{
								Future.add(row) ;
							}
							Equity.add(row);
						}
						else if(row.getSecurityId() == 9811) //futures
						{
							Future.add(row);
						}
						else if(row.getSecurityId() == 1204) //optionput
						{
							OptionPut.add(row);
						}
						else if(row.getSecurityId() == 3030) //optioncall
						{
							OptionCall.add(row);
						}
					}
					
					List<List<Trade>> securities = null ;
					securities.add(Equity) ;
					securities.add(Future) ;
					securities.add(OptionPut) ;
					securities.add(OptionCall) ;
					
					//now we see the intrinsic wash trades for each security and eq buy future sell
					
					
					for(List<Trade> security : securities)
					{
						List<Trade> x = null ;
						answer = null ;
						powerSet(security, -1, x ) ;
						
						for(List<Trade> subset : answer) // for all the subsets of a security
						{
							if(sumofSubset(subset) == 0)
							{
								if(profit(subset) <= 0.005)
								{
									for(Trade t : subset)
									{
										washTrades.add(t) ;
									}
								}
							}
							//profit = (-ves*MKTPR) + (+ves*MKTPR)
						}
					}
								
				}
			}
		}
		
		
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
//		
	}
}
