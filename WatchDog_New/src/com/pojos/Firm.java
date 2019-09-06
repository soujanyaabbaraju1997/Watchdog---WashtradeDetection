package com.pojos;

public class Firm 
{
	private int firmId;
	
	private String firmName;
	
	public Firm(int firmId, String firmName)
	{
		this.firmId = firmId;
		this.firmName = firmName;
	}

	public int getFirmId()
	{
		return firmId;
	}

	public void setFirmId(int firmId)
	{
		this.firmId = firmId;
	}

	public String getFirmName() 
	{
		return firmName;
	}

	public void setFirmName(String firmName)
	{
		this.firmName = firmName;
	}
	
	
}
