package com.pojos;

public class Security 
{
	private int securityId;
	private String securityName;
	
	public Security(int securityId, String securityName) 
	{
		this.securityId = securityId;
		this.securityName = securityName;
	}

	public int getSecurityId() 
	{
		return securityId;
	}

	public void setSecurityId(int securityId)
	{
		this.securityId = securityId;
	}

	public String getSecurityName()
	{
		return securityName;
	}

	public void setSecurityName(String securityName) 
	{
		this.securityName = securityName;
	}
	
	
}
