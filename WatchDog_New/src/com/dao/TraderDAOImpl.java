package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pojos.Trader;
import com.pojos.User;

public class TraderDAOImpl extends User implements TraderDAO 
{
	Connection openConnection()
	{
		Connection conn = null;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "group8", "trade");
		}
		catch(ClassNotFoundException | SQLException e)
		{
			System.out.println(e);
		}
	
		return conn;
	}	
	@Override
	public int addTrader(Trader trader) 
	{
		int rows_inserted = 0;
		
		String INSERT_TRADER = "insert into users values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try(Connection conn = openConnection();PreparedStatement ps = conn.prepareStatement(INSERT_TRADER);)
		{
			ps.setString(1, trader.getTraderId());
			ps.setString(2, trader.getTraderName());
			ps.setDate(3, trader.getDateReg());
			ps.setString(4, trader.getUsername());
			ps.setString(5, trader.getPassword());
			ps.setString(6, trader.getEmailId());
			ps.setLong(7, trader.getPhone());
			ps.setDate(8, trader.getDob());
			ps.setInt(9, trader.isAdmin());
			rows_inserted = ps.executeUpdate();			
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return rows_inserted;
	}
	@Override
	public List<String> findAllTraderIds()
	{
		List<String> traders = new ArrayList<String>();
		String FIND_ALL_TRADERS = "select * from users where is_admin=0";

		try(Connection conn = openConnection();Statement stmt = conn.createStatement();) 
		{
			ResultSet rs = stmt.executeQuery(FIND_ALL_TRADERS);
			
			while(rs.next())
			{
				String traderId = rs.getString(1);
				traders.add(traderId);
			}
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return traders;
	}
	
	public List<Trader> findAllTraders()
	{
		List<Trader> traders = new ArrayList<Trader>();
		String FIND_ALL_TRADERS = "select * from users where is_admin=0";
		
		Connection conn = openConnection();
		Statement stmt;
		try 
		{
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(FIND_ALL_TRADERS);
			
			while(rs.next())
			{
				String traderId = rs.getString(1);
				String traderName = rs.getString(2);
				Date dateRed = rs.getDate(3);
				String username = rs.getString(4);
				String password = rs.getString(5);
				String emailId = rs.getString(6);
				long phone = rs.getLong(7);
				Date dob = rs.getDate(8);
				
				Trader trader = new Trader(traderId, traderName, dateRed, username, password, emailId, phone, dob);
				traders.add(trader);
			}
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block//..
			e.printStackTrace();
		}
		try {
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return traders;
	}
	
	@Override
	public Trader findByTraderID(String traderId) 
	{
		Trader trader = new Trader();
		String FIND_BY_TRADER_ID = "select * from users where trader_id=?";
		
		try(Connection conn = openConnection();
			PreparedStatement ps = conn.prepareStatement(FIND_BY_TRADER_ID);){
			ps.setFetchSize(1000);
			ps.setString(1, traderId);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				trader.setTraderId(traderId);
				trader.setTraderName(rs.getString(2));
				trader.setDateReg(rs.getDate(3));
				trader.setUsername(rs.getString(4));
				trader.setPassword(rs.getString(5));
				trader.setEmailId(rs.getString(6));
				trader.setPhone(rs.getLong(7));
				trader.setDob(rs.getDate(8));
			}

		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return trader;
	}
	@Override
	public Trader findByUsername(String username) 
	{
		Trader trader = new Trader();
		String FIND_BY_USERNAME = "select * from users where username=?";
		
		try(Connection conn = openConnection();
			PreparedStatement ps = conn.prepareStatement(FIND_BY_USERNAME);){
			ps.setFetchSize(1000);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				trader.setTraderId(rs.getString(1));
				trader.setTraderName(rs.getString(2));
				trader.setDateReg(rs.getDate(3));
				trader.setUsername(username);
				trader.setPassword(rs.getString(5));
				trader.setEmailId(rs.getString(6));
				trader.setPhone(rs.getLong(7));
				trader.setDob(rs.getDate(8));
			}

		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return trader;
	}



}
