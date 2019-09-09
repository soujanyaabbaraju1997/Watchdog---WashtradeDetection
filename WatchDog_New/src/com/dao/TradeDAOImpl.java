package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import com.pojos.Trade;
import com.pojos.Trader;

public class TradeDAOImpl implements TradeDAO
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
	public int addTrade(Trade trade) 
	{
		int rows_inserted = 0;
		Connection conn = openConnection();
		String INSERT_TRADE = "insert into trades values(?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps;
			
		try
		{
			ps = conn.prepareStatement(INSERT_TRADE);
			
			ps.setInt(1,trade.getTradeId());;
			ps.setObject(2, trade.getTrader().getTraderId());
			ps.setTime(3,trade.getTimeStamp());
			ps.setString(4, trade.isTradeType());
			ps.setInt(5, trade.getSecurityId());
			ps.setInt(6, trade.getQty());
			ps.setFloat(7, trade.getDealPrice());
			ps.setInt(8, trade.getFirmId());
			ps.setString(9, trade.getBrokerId());
			ps.setInt(10, trade.getIsWashTrade());
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
	public Trade findTradeById(int tradeId)
	{
		Trade trade = new Trade();
		
		String FIND_TRADE = "select * from trades where trade_id=?";
		
		Connection conn = openConnection();
		PreparedStatement ps;
		
		try
		{
			ps = conn.prepareStatement(FIND_TRADE);
			ps.setInt(1, tradeId);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				trade.setTradeId(tradeId);
				//trade.setTrader(rs.getObject(columnIndex));
				trade.setTimeStamp(rs.getTime(3));
				trade.setTradeType(rs.getString(4));
				trade.setSecurityId(rs.getInt(5));
				trade.setQty(rs.getInt(6));
				trade.setDealPrice(rs.getFloat(7));
				trade.setFirmId(rs.getInt(8));
				trade.setBrokerId(rs.getString(9));
			}

		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return trade;
	}

	@Override
	public List<Trade> findAllTrades()
	{
		List<Trade> tradelist = new ArrayList<Trade>();
		String FIND_ALL_TRADES = "select * from trades";
		
		Connection conn = openConnection();
		PreparedStatement ps;
		
		try 
		{
			ps = conn.prepareStatement(FIND_ALL_TRADES);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				Trade trade = new Trade();
				
				trade.setTradeId(rs.getInt(1));
				trade.setTrader((Trader)rs.getObject(2));
				trade.setTimeStamp(rs.getTime(3));		
				trade.setTradeType(rs.getString(4));
				trade.setSecurityId(rs.getInt(5));
				trade.setQty(rs.getInt(6));
				trade.setDealPrice(rs.getFloat(7));
				trade.setFirmId(rs.getInt(8));
				trade.setBrokerId(rs.getString(9));
				tradelist.add(trade);				
			}
			
			System.out.println("List Size = "+tradelist.size());
	
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return tradelist;
	}

	@Override
	public List<Trade> findByTraderId(String traderId)
	{
		
		List<Trade> tradeslist = new ArrayList<Trade>();
		String FIND_TRADE = "select * from trades where trader=?";
		
		Connection conn = openConnection();
		PreparedStatement ps;
		
		try
		{
			ps = conn.prepareStatement(FIND_TRADE);
			ps.setString(1, traderId);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				Trade trade = new Trade();
				trade.setTradeId(rs.getInt(1));
				trade.setTrader((Trader)rs.getObject(2));
				trade.setTimeStamp(rs.getTime(3));
				trade.setTradeType(rs.getString(4));
				trade.setSecurityId(rs.getInt(5));
				trade.setQty(rs.getInt(6));
				trade.setDealPrice(rs.getFloat(7));
				trade.setFirmId(rs.getInt(8));
				trade.setBrokerId(rs.getString(9));
				tradeslist.add(trade);
			}

		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return tradeslist;		
	}
	
}
