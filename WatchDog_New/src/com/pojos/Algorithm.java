package com.pojos;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import com.dao.TradeDAO;
import com.dao.TradeDAOImpl;
import com.dao.TraderDAO;
import com.dao.TraderDAOImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
public class Algorithm {

//	public static void main(String[] args) {
//		System.out.println(RunAlgo()) ;
//	}
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
	
	public static int volume(List<Trade> set)
	{
		int vol = 0 ;
		
		for(Trade t : set)
		{
			vol+=t.getQty() ;
		}
		return vol;
	}

	public static int volume(Set<Trade> set)
	{
		int vol = 0 ;
		
		for(Trade t : set)
		{
			vol+=t.getQty() ;
		}
		return vol;
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
	public static Set<Set<Trade>> RunAlgo()
	{
		
		TraderDAO dao = new TraderDAOImpl();
		TradeDAO tdao = new TradeDAOImpl();
		List<String> traders = dao.findAllTraderIds();
		Set<Set<Trade>> washTrades = new HashSet<Set<Trade>>() ;


		traders.stream().forEach((trader)->
		{
			System.out.println("Trader : " + trader);
			List<Trade> trades =  tdao.findByTraderId(trader) ;
			if(trades.size() != 0)
			{
//				System.out.println("----------------------------------------------------\n"+ trades);
//				System.out.println("----------------------------------------------------");
				Map<String, Map< Integer , List<Trade>>> map = trades.stream().collect(Collectors.groupingBy(Trade::getBrokerId,Collectors.groupingBy(Trade::getFirmId)));
	
//				System.out.println("MAP: " + map.keySet());
				
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
	
						Total.stream().forEach((row)->
						{
//							System.out.println("each row: "+ row);
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
						
						Map<String , Map<Set<Trade>,Integer>> sumMappingAllSecurities = new HashMap<String , Map<Set<Trade>,Integer>>() ;
						
						securities.forEach((security,groupedBySecurityTrades)->
						{
							Map<Set<Trade>, Integer> sumMappingSecurityWise = new HashMap<Set<Trade>, Integer>();
//							groupedBySecurityTrades.stream().forEach((row)->{System.out.println( security + " " + row);}) ;
							Set<Set<Trade>> answer1  = powerSet(groupedBySecurityTrades) ;
							Set<Set<Trade>> answer = new HashSet<Set<Trade>>() ;
							answer1.forEach((s)->{
								if(s.size()>0)
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
									float prof = profit(subset) ;
									double roundOff = Math.round(prof * 10000.0) / 10000.0;
									if( roundOff <= 0.005 && roundOff >=-0.005)
									{
										System.out.println("*********************************************************\nTrader:" + trader + "\tBroker:" + broker + "\tFirm: " + firm );
										// now we separate the types of securities into separate lists
										System.out.println("*********************************************************");
										
										System.out.println("WashTradesVolume: "+ volume(subset));
										for(Trade t : subset)
										{
											tdao.setWashTrade(t);
											System.out.println(t);
											
										}
										washTrades.add(subset) ;
										System.out.println("Profit: " + roundOff*100 + "%");
										System.out.println("---------------------------------------------");
									}
								}
								else
								{
										if(security.equals("OptionCall"))
											sumMappingSecurityWise.put(subset, -sumOfSubset) ;
										else if(security.equals("OptionPut"))
											sumMappingSecurityWise.put(subset, sumOfSubset) ;
										else if(security.equals("Future"))
											sumMappingSecurityWise.put(subset, sumOfSubset) ;
								}
							}
							if(!security.equals("Equity"))
								sumMappingAllSecurities.put(security, sumMappingSecurityWise);
						});
					// end of detection

						
						sumMappingAllSecurities.get("Future").forEach((subset1,sum1)->
						{

							sumMappingAllSecurities.get("OptionCall").forEach((subset2,sum2)->
							{

								if((int)sum1 == (int)sum2)
								{
									sumMappingAllSecurities.get("OptionPut").forEach((subset3,sum3)->
									{
										if((int)sum2 == (int)sum3)
										{
											Set<Trade> tripletWashTrade = new HashSet<>() ;
											tripletWashTrade.addAll(subset1);
											tripletWashTrade.addAll(subset2);
											tripletWashTrade.addAll(subset3);
											System.out.println("*********************************************************\nTrader:" + trader + "\tBroker:" + broker + "\tFirm: " + firm );
											// now we separate the types of securities into separate lists
											System.out.println("*********************************************************");
											System.out.println("WashTradesVolume: "+ volume(tripletWashTrade));
											tripletWashTrade.stream().forEach((trade)->
											{
												tdao.setWashTrade(trade);
												System.out.println(trade);
											});
											
											washTrades.add(tripletWashTrade) ;
										}
									});
								}
							});
						}); 
				    }
				}
			}
		});
		
		return washTrades ;
	}
}
						
