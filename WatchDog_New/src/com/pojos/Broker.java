package com.pojos;

public class Broker
{
	private String brokerName;
	
	public Broker()
	{
		this.brokerName = "DEFAULT";
	}

	public Broker(String brokerName)
	{
		super();
		this.brokerName = brokerName;
	}

	public String getBrokerName() 
	{
		return brokerName;
	}

	public void setBrokerName(String brokerName)
	{
		this.brokerName = brokerName;
	}
	
	
	
	
}
