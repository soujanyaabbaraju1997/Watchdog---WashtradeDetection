package com.pojos;

public class Stock 
{
	
	private int firmId;
	private int securityId;
	private float highestPrice;
	private float lowestPrice;
	private float ltp;
	
	public Stock()
	{
		;
	}
	
	public Stock(int firmId, int securityId, float highestPrice, float lowestPrice, float ltp) 
	{
		this.firmId = firmId;
		this.securityId = securityId;
		this.highestPrice = highestPrice;
		this.lowestPrice = lowestPrice;
		this.ltp = ltp;
	}

	public int getFirmId()
	{
		return firmId;
	}

	public void setFirmId(int firmId)
	{
		this.firmId = firmId;
	}

	public int getSecurityId() 
	{
		return securityId;
	}

	public void setSecurityId(int securityId) 
	{
		this.securityId = securityId;
	}

	public float getHighestPrice() 
	{
		return highestPrice;
	}

	public void setHighestPrice(float highestPrice)
	{
		this.highestPrice = highestPrice;
	}

	public float getLowestPrice() 
	{
		return lowestPrice;
	}

	public void setLowestPrice(float lowestPrice)
	{
		this.lowestPrice = lowestPrice;
	}

	public float getLtp() 
	{
		return ltp;
	}

	public void setLtp(float ltp)
	{
		this.ltp = ltp;
	}
		
}
