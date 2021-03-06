package com.pojos;
import java.sql.Date;
//
import java.util.List;
public class Trader extends User
{
	
	
	private String traderId;
	private String traderName;
	private Date dateReg;
	private List<Trade> trades;			//HAS-A relationship. 1:*
	public Trader()
	{
		super();
		this.traderId = "DEFAULT";
		this.traderName = "DEFAULT";
		this.dateReg = new Date(1000, 01, 02) ;
		this.setAdmin(0);
	}
	
	public Trader(String traderId, String traderName, Date dateReg, String username, String password, String emailId, long phone, Date dob) 
	
	{
		super(username, password, emailId, phone, dob);
		this.traderId = traderId;
		this.traderName = traderName;
		this.dateReg = dateReg;
		this.setAdmin(0);
	}
	
//	@Override
//	public String toString() {
//		// TODO Auto-generated method stub
//		return traderId ;
//	}
	
	
	
	@Override
	public String toString() {
		return "Trader [traderId=" + traderId + ", traderName=" + traderName + ", dateReg=" + dateReg + ", trades="
				+ trades + "]";
	}
	
	public String getTraderId() 
	{
		return traderId;
	}
	public void setTraderId(String traderId) 
	{
		this.traderId = traderId;
	}
	public String getTraderName()
	{
		return traderName;
	}
	public void setTraderName(String traderName) 
	{
		this.traderName = traderName;
	}
	public Date getDateReg() 
	{
		return dateReg;
	}
	public void setDateReg(Date dateReg)
	{
		this.dateReg = dateReg;
	}
	public List<Trade> getTrades() 
	{
		return trades;
	}
	public void setTrades(List<Trade> trades) 
	{
		this.trades = trades;
	}

	
}
