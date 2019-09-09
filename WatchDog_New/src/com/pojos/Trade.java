package com.pojos;

import java.sql.Time;

public class Trade 
{
	private int tradeId;
	private Trader trader;				//HAS-A relationship. 1:1
	private Time timeStamp;
	private boolean tradeType;
	private int securityId;
	private int qty;
	private float dealPrice;
	private int firmId;
	private int brokerId;
	
	public Trade()
	{
		;
	}

	public Trade(int tradeId, Trader trader, Time timeStamp, boolean tradeType, int securityId, int qty,
			float dealPrice, int firmId, int brokerId) 
	{
		
		this.tradeId = tradeId;
		this.trader = trader;
		this.timeStamp = timeStamp;
		this.tradeType = tradeType;
		this.securityId = securityId;
		this.qty = qty;
		this.dealPrice = dealPrice;
		this.firmId = firmId;
		this.brokerId = brokerId;
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
	}

	public Time getTimeStamp()
	{
		return timeStamp;
	}

	public void setTimeStamp(Time timeStamp)
	{
		this.timeStamp = timeStamp;
	}

	public boolean isTradeType() {
		return tradeType;
	}

	public void setTradeType(boolean tradeType) 
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

	public int getBrokerId()
	{
		return brokerId;
	}

	public void setBrokerId(int brokerId)
	{
		this.brokerId = brokerId;
	}

}
