package com.pojos;
import java.sql.Date;
import java.util.List;
public class Trader extends User
{
	private int traderId;
	private String traderName;
	private Date dateReg;
<<<<<<< Upstream, based on branch 'master' of https://github.com/soujanyaabbaraju1997/Project_Repo.git
	private List<Trade> trades;			//HAS-A relationship. 1:*
	
	public Trader()
	{
		this.setAdmin(0);
	}
	
	public Trader(int traderId, String traderName, Date dateReg, String username, String password, String emailId, long phone, Date dob) 
=======
	private List<Trade> trades;			//HAS-A relationship. 1:*	
	public Trader(int traderId, String traderName, Date dateReg, List<Trade> trades) 
>>>>>>> a8ecffc Gaurav init
	{
		this.traderId = traderId;
		this.traderName = traderName;
		this.dateReg = dateReg;
		this.setAdmin(0);
		this.setUsername(username);
		this.setPassword(password);
		this.setEmailId(emailId);
		this.setPhone(phone);
		this.setDob(dob);
	}
	public int getTraderId() 
	{
		return traderId;
	}
	public void setTraderId(int traderId) 
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
