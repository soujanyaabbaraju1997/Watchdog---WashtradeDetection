package com.pojos;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
//
public class Trade 
{
	private int tradeId;
	private Trader trader;				//HAS-A relationship. 1:1
	private Timestamp timeStamp;
	private String tradeType;
	private int securityId;
	private int qty;
	private float dealPrice;
	private int firmId;
	private String brokerId;
	private int isWashTrade;
	public Trade()
	{
		super();
		this.isWashTrade=0;
	}

	
	
	public Trade(int tradeId, Trader trader, Timestamp timeStamp, String tradeType, int securityId, int qty,
			float dealPrice, int firmId, String brokerId, int isWashTrade) 
	{
		super();
		this.tradeId = tradeId;
		this.trader = trader;
		this.timeStamp = timeStamp;
		this.tradeType = tradeType;
		this.securityId = securityId;
		this.qty = qty;
		this.dealPrice = dealPrice;
		this.firmId = firmId;
		this.brokerId = brokerId;
		this.isWashTrade = 0;
	}
	

	private Trader deepCopy(Trader trader2) {
		// TODO Auto-generated method stub
		return null;
	}



	public int getIsWashTrade() {
		return isWashTrade;
	}



	public void setIsWashTrade(int isWashTrade) {
		this.isWashTrade = isWashTrade;
	}



	public int getTradeId()
	{
		return tradeId;
	}

	public void setTradeId(int tradeId) 
	{
		this.tradeId = tradeId;
	}
	
	public Trader getTrader() 
	{
		return trader;
	}

	public void setTrader(Trader trader)
	{
		this.trader = trader;
//		this.trader.setTraderId(trader.getTraderId());
//		this.trader.setTraderName(trader.getTraderName());
//		this.trader.setDateReg(trader.getDateReg());
//		this.trader.setTrades(trader.getTrades());
//		this.trader.setDateReg(trader.getDateReg());
	}

	public Timestamp getTimeStamp()
	{
		return timeStamp;
	}

	public void setTimeStamp(Timestamp timeStamp)
	{
		this.timeStamp = timeStamp;
	}

	public String isTradeType() {
		return tradeType;
	}

	public void setTradeType(String tradeType) 
	{
		this.tradeType = tradeType;
	}

	public int getSecurityId()
	{
		return securityId;
	}

	public void setSecurityId(int securityId) 
	{
		this.securityId = securityId;
	}

	public int getQty() 
	{
		return qty;
	}

	public void setQty(int qty) 
	{
		this.qty = qty;
	}

	public float getDealPrice()
	{
		return dealPrice;
	}

	public void setDealPrice(float dealPrice) 
	{
		this.dealPrice = dealPrice;
	}

	public int getFirmId()
	{
		return firmId;
	}

	public void setFirmId(int firmId) 
	{
		this.firmId = firmId;
	}

	public String getBrokerId()
	{
		return brokerId;
	}

	public void setBrokerId(String brokerId)
	{
		this.brokerId = brokerId;
	}



	@Override
	public String toString() {
		return  ""+ tradeId ;
	}

	
		
}
