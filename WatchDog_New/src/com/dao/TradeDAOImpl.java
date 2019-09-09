//package com.dao;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Time;
//import java.util.ArrayList;
//import java.util.List;
//
//import com.pojos.Stock;
//import com.pojos.Trade;
//
//public class TradeDAOImpl implements TradeDAO
//{
//	Connection openConnection()
//	{
//		
//		Connection conn = null;
//		try
//		{
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			System.out.println("DRIVER LOADED SUCCESSFULLY");
//			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "admin");
//			System.out.println("CONNECTION OBTAINED");
//		}
//		catch(ClassNotFoundException | SQLException e)
//		{
//			System.out.println(e);
//		}
//		
//		return conn;
//	}
//	
//	@Override
//	public int addTrade(Trade trade) 
//	{
//		int rows_inserted = 0;
//		Connection conn = openConnection();
//		String INSERT_TRADE = "insert into trade" + " values(?,?,?,?,?,?,?,?,?)";
//		PreparedStatement ps;
//			
//		try
//		{
//			ps = conn.prepareStatement(INSERT_TRADE);
//			
//			ps.setInt(1,trade.getTradeId());
//			//TRY SETTING OBJECT OF TRADER - - ps.setInt(2, stock.getSecurityId());
//			ps.setTime(3,trade.getTimeStamp());
//			ps.setBoolean(4, trade.isTradeType());
//			ps.setInt(5, trade.getSecurityId());
//			ps.setInt(6, trade.getQty());
//			ps.setFloat(7, trade.getDealPrice());
//			ps.setInt(8, trade.getFirmId());
//			ps.setInt(9, trade.getBrokerId());
//		
//			rows_inserted = ps.executeUpdate();
//			
//			System.out.println("Rows : "+rows_inserted);
//			conn.close();			
//		}
//		catch (SQLException e) 
//		{
//			e.printStackTrace();
//		}	
//		
//		return rows_inserted;	
//		
//	}
//
//	@Override
//	public Trade findTradeById(int tradeId)
//	{
//		Trade trade = new Trade();
//		
//		String FIND_TRADE = "select * from trade where tradeId=?";
//		
//		Connection conn = openConnection();
//		PreparedStatement ps;
//		
//		try
//		{
//			ps = conn.prepareStatement(FIND_TRADE);
//			ps.setInt(1, tradeId);
//			ResultSet rs = ps.executeQuery();
//			
//			while(rs.next())
//			{
//				trade.setTradeId(tradeId);
//				//trade.setTrader(rs.getObject(columnIndex));
//				trade.setTimeStamp(rs.getTime(3));
//				trade.setTradeType(rs.getBoolean(4));
//				trade.setSecurityId(rs.getInt(5));
//				trade.setQty(rs.getInt(6));
//				trade.setDealPrice(rs.getFloat(7));
//				trade.setFirmId(rs.getInt(8));
//				trade.setBrokerId(rs.getInt(9));
//			}
//
//		}
//		catch (SQLException e)
//		{
//			e.printStackTrace();
//		}
//		
//		return trade;
//	}
//
//	@Override
//	public List<Trade> findAllTrades()
//	{
//		List<Trade> trades = new ArrayList<Trade>();
//		String FIND_ALL_TRADES = "select * from trade";
//		
//		Connection conn = openConnection();
//		PreparedStatement ps;
//		
//		try 
//		{
//			ps = conn.prepareStatement(FIND_ALL_TRADES);
//			ResultSet rs = ps.executeQuery();
//			
//			while(rs.next())
//			{
//				int roll = rs.getInt(1);
//				String name = rs.getString(2);
//				int marks = rs.getInt(3);
//				
//				int tradeId = rs.getInt(1);
//				//trade.setTrader(rs.getObject(columnIndex));
//				Time time = rs.getTime(3);
//				boolean tradeType = rs.getBoolean(4);
//				int securityId = rs.getInt(5);
//				int qty = rs.getInt(6);
//				float dealPrice = rs.getFloat(7);
//				int firmId = rs.getInt(8);
//				int brokerId = rs.getInt(9);
//		
//				Trade trade = new Trade();
//			}
//			System.out.println("List Size = "+trades.size());
//	
//		} 
//		catch (ClassNotFoundException | SQLException e)
//		{
//			e.printStackTrace();
//		}
//		
//		return trades;
//	}
//	
//}
