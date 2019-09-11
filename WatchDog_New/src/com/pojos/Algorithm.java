package com.pojos;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
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
import java.util.HashMap;
import java.util.HashSet;
public class Algorithm {

	
	public static <T> Set<Set<T>> powerSet(Set<T> originalSet) {
	    Set<Set<T>> sets = new HashSet<Set<T>>();
	    if (originalSet.isEmpty()) {
	        sets.add(new HashSet<T>());
	        return sets;
	    }
	    List<T> list = new ArrayList<T>(originalSet);
	    T head = list.get(0);
	    Set<T> rest = new HashSet<T>(list.subList(1, list.size())); 
	    for (Set<T> set : powerSet(rest)) {
	        Set<T> newSet = new HashSet<T>();
	        newSet.add(head);
	        newSet.addAll(set);
	        sets.add(newSet);
	        sets.add(set);
	    }       
	    return sets;
	}  	
	public static int sumofSubset(Set<Trade> set)
	{
		int sum = 0 ;
		
		for(Trade t : set)
		{
			String type = t.isTradeType() ;
			if(type.equals("buy"))
				sum += t.getQty() ;
			else
				sum -= t.getQty() ;
		}
		return sum;
	}
	
	public static float profit(Set<Trade> set)
	{
		float sell = 0.0f ;
		float buy = 0.0f ;
		
		for(Trade t : set)
		{
			String type =  t.isTradeType();
			if(type.equals("buy"))
				buy += (t.getQty() * t.getDealPrice()) ;
			else
				sell += (t.getQty() * t.getDealPrice()) ;
		}
		return (float)((sell - buy)/buy) ;
	}
	public static void main(String[] args)
	{
		
		TraderDAO dao = new TraderDAOImpl();
		TradeDAO tdao = new TradeDAOImpl();
		BrokerDAO bdao = new BrokerDAOImpl();
		FirmDAO fdao = new FirmDAOImpl();
		
		List<String> traders = dao.findAllTraderIds();
		List<Trade> washTrades = new ArrayList<>() ;

		traders.stream().forEach((trader)->
		{
			System.out.println("Trader : " + trader);
			List<Trade> trades =  tdao.findByTraderId(trader) ;
			if(trades.size() != 0)
			{
				System.out.println(trades);
				
				Map<String, Map< Integer , List<Trade>>> map = trades.stream().collect(Collectors.groupingBy(Trade::getBrokerId,Collectors.groupingBy(Trade::getFirmId)));
	
				System.out.println("MAP: " + map.keySet());
				
				for (Map.Entry<String, Map< Integer , List<Trade>>> eachBrokerTrade : map.entrySet()) 
				{
				    String broker = eachBrokerTrade.getKey();
				    // ...
				    for (Map.Entry<Integer, List<Trade>> eachFirmTrade : eachBrokerTrade.getValue().entrySet()) 
				    {
				        int firm = eachFirmTrade.getKey();
				        List<Trade> Total = eachFirmTrade.getValue();
							
						Set<Trade> Equity = new HashSet<>() ;
						Set<Trade> Future = new HashSet<>() ;
						Set<Trade> OptionPut = new HashSet<>() ;
						Set<Trade> OptionCall = new HashSet<>() ;
					
						
						System.out.println(Total);
						// now we separate the types of securities into separate lists
						
						Total.stream().forEach((row)->
						{
							System.out.println("each row: "+ row);
							if(row.getSecurityId() == 7890) //equity
							{
								String type = row.isTradeType() ;
								if(type.equals("buy")) //if it is buy)
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
						});
						
						Map<String, Set<Trade>> securities = new HashMap<String, Set<Trade>>() ;
						securities.put("Equity", Equity);
						securities.put("Future", Future);
						securities.put("OptionPut", OptionPut);
						securities.put("OptionCall", OptionCall);
						
						//now we see the intrinsic wash trades for each security and eq buy future sell
						
						
						securities.forEach((security,groupedBySecurityTrades)->
						{
//							groupedBySecurityTrades.stream().forEach((row)->{System.out.println( security + " " + row);}) ;
							Set<Set<Trade>> answer1  = powerSet(groupedBySecurityTrades) ;
							Set<Set<Trade>> answer = new HashSet<Set<Trade>>() ;
							answer1.forEach((s)->{
								if(s.size()>1)
								{
									answer.add(s);
								}
							});
//							if(answer.size()> 0)System.out.println("power set: " + answer);
							for(Set<Trade> subset : answer) // for all the subsets of a security
							{
								int sumOfSubset = sumofSubset(subset) ;
								if(sumOfSubset == 0 && subset.size()>1)
								{
									System.out.println("SUBSET SIZE: "+ subset.size());
									System.out.println("sumOfSubset : "+ sumOfSubset + "\nsubset: " + subset);
									float prof = profit(subset) ;
									System.out.println("ProfitOfSubset" + prof);
									if( prof <= 0.005)
									{
										for(Trade t : subset)
										{
											t.setIsWashTrade(1);
											System.out.println("WashTrades : " + t);
											washTrades.add(t) ;
										}
									}
								}
								else
								{
									Map<Set<Trade>, Integer> sumMapping ;
								}
							}
						});
						// end of detection
				    }
				}
			}
		});
	}
}
						
						//for each set of trader, broker and firm we get the list of total trades 
						
//						List<Trade> Total = map.get(broker).get(firm) ;
//						System.out.println("Total trader T-B-F : " + Total);
//						if(Total.size()!=0)
//						{
//							List<Trade> Equity = new ArrayList<>() ;
//							List<Trade> Future = new ArrayList<>() ;
//							List<Trade> OptionPut = new ArrayList<>() ;
//							List<Trade> OptionCall = new ArrayList<>() ;
//						
//							// now we separate the types of securities into separate lists
//							
//							for(Trade row : Total)
//							{
//								if(row.getSecurityId() == 7890) //equity
//								{
//									if(row.isTradeType()=="buy") //if it is buy)
//									{
//										Future.add(row) ;
//									}
//									Equity.add(row);
//								}
//								else if(row.getSecurityId() == 9811) //futures
//								{
//									Future.add(row);
//								}
//								else if(row.getSecurityId() == 1204) //optionput
//								{
//									OptionPut.add(row);
//								}
//								else if(row.getSecurityId() == 3030) //optioncall
//								{
//									OptionCall.add(row);
//								}
//							}
//							
//							List<List<Trade>> securities = new ArrayList<List<Trade>>() ;
//							securities.add(Equity) ;
//							securities.add(Future) ;
//							securities.add(OptionPut) ;
//							securities.add(OptionCall) ;
//							
//							//now we see the intrinsic wash trades for each security and eq buy future sell
//							
//							
//							for(List<Trade> security : securities)
//							{
//								List<Trade> x = new ArrayList<>() ;
//								answer.clear(); ;
//								powerSet(security, -1, x ) ;
//								
//								for(List<Trade> subset : answer) // for all the subsets of a security
//								{
//									if(sumofSubset(subset) == 0)
//									{
//										if(profit(subset) <= 0.005)
//										{
//											for(Trade t : subset)
//											{
//												t.setIsWashTrade(1);
//												System.out.println("WashTrades :\n" + t);
//												washTrades.add(t) ;
//											}
//										}
//									}
//									//profit = (-ves*MKTPR) + (+ves*MKTPR)
//								}
//							}
//						}			
//					}
//				}
//			}
//		}
		
		
		
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

