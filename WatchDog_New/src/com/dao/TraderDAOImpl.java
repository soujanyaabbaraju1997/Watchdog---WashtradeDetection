package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.pojos.Trader;
import com.pojos.User;

public class TraderDAOImpl implements TraderDAO
{

	Connection openConnection()
	{
		
		Connection conn = null;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("DRIVER LOADED SUCCESSFULLY");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "group8", "trade");
			System.out.println("CONNECTION OBTAINED");
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
		Connection conn = openConnection();
		String INSERT_TRADER = "insert into users values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps;
			
		try
		{
			ps = conn.prepareStatement(INSERT_TRADER);
			ps.setInt(1,trader.getTraderId());
			ps.setString(2,trader.getTraderName());
			ps.setDate(3,trader.getDateReg());
			ps.setString(4,trader.getUsername());
			ps.setString(5, trader.getPassword());
			ps.setString(6, trader.getEmailId());
			ps.setLong(7, trader.getPhone());
			ps.setDate(8, trader.getDob());
			ps.setInt(9, 0);
			
			rows_inserted = ps.executeUpdate();
			
			System.out.println("Rows : "+rows_inserted);
			conn.close();			
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}	
		
		return rows_inserted;
	}

	@Override
	public void ViewLiveMarket() 
	{
		// TODO Auto-generated method stub	
	}

	@Override
	public Trader findTraderById(int traderId) 
	{
		Trader trader = new Trader();
		String FIND_BY_TRADERID = "select * from users where trader_id=?";
		
		Connection conn = openConnection();
		PreparedStatement ps;
		
		try
		{
			ps = conn.prepareStatement(FIND_BY_TRADERID);
			ps.setLong(1, traderId);
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
				trader.setAdmin(0);
			}
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	
		return trader;
	}
}