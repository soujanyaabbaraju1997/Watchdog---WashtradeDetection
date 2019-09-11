package com.pojos;

public class Security 
{
	private int securityId;
	private String securityName;
	private int lotSize;
	
	public Security(int securityId, String securityName, int lotSize) 
	{
		this.securityId = securityId;
		this.securityName = securityName;
		this.lotSize = lotSize;
	}
	
	
	public int getLotSize() {
		return lotSize;
	}


	public void setLotSize(int lotSize) {
		this.lotSize = lotSize;
	}


	public int getSecurityId() 
	{
		return securityId;
	}
	

	@Override
	public String toString() {
		return "Security [securityId=" + securityId + ", securityName=" + securityName + ", lotSize=" + lotSize + "]";
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
