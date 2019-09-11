package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import com.pojos.Trade;
import com.pojos.Trader;
//
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
			ps.setString(2, trade.getTrader().getTraderId());
			ps.setTimestamp(3,trade.getTimeStamp());
			ps.setString(4, trade.isTradeType());
			ps.setInt(5, trade.getSecurityId());
			ps.setInt(6, trade.getQty());
			ps.setFloat(7, trade.getDealPrice());
			ps.setInt(8, trade.getFirmId());
			ps.setString(9, trade.getBrokerId());
			ps.setInt(10, trade.getIsWashTrade());
			rows_inserted = ps.executeUpdate();
			
			System.out.println("Rows : "+rows_inserted);
			//conn.close();			
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}	
		try {
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
			TraderDAO tdao = new TraderDAOImpl();
			while(rs.next())
			{
				trade.setTradeId(tradeId);
				Trader t = new Trader();
				t = tdao.findByTraderID(rs.getString(2));
				trade.setTrader(t);
				trade.setTimeStamp(rs.getTimestamp(3));
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
		try {
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return trade;
	}

	@Override
	public List<Trade> findAllTrades()
	{
		List<Trade> tradelist = new ArrayList<Trade>();
		String FIND_ALL_TRADES = "select * from trades";
		
		//copy path	
		TraderDAO dao = new TraderDAOImpl();
		List<Trader> traderlist = dao.findAllTraders();
		Connection conn = openConnection();
		
		try(
				PreparedStatement ps = conn.prepareStatement(FIND_ALL_TRADES);){
			ps.setFetchSize(1000);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				System.out.println(rs);
				Trade trade = new Trade();
				
				Optional<Trader> matchingObject = traderlist.stream().filter
						(p -> 
						{
							try 
							{
								return p.getTraderId().equals(rs.getString(2));
							}
							catch (SQLException e) 
							{
								e.printStackTrace();
							}
							return false;
						}).findFirst();
				
				Trader t = matchingObject.orElse(null);
				System.out.println(t);
//				trade.setTradeId(rs.getInt(1));
//				Trader t = traderlist.               
//				Trader t =  tdao.findByTraderID(rs.getString(2));
//				String traderId=rs.getString(2);
//				List<Trader> traders=new ArrayList<>();
//				Trader trader=traders.stream().filter(traderId);
				System.out.println("TRADER OBJECT"+t);
				trade.setTrader(new Trader(t.getTraderId(), t.getTraderName(), t.getDateReg(), t.getUsername(), t.getPassword(), t.getEmailId(), t.getPhone(), t.getDob()));
				trade.setTimeStamp(rs.getTimestamp(3));		
				trade.setTradeType(rs.getString(4));
				trade.setSecurityId(rs.getInt(5));
				trade.setQty(rs.getInt(6));
				trade.setDealPrice(rs.getFloat(7));
				trade.setFirmId(rs.getInt(8));
				trade.setBrokerId(rs.getString(9));
				tradelist.add(trade);	
				System.out.println("List Size = "+tradelist.size());
				System.out.println(trade);
				System.out.println("TRADE ADDED" );
				System.out.println("\n\n");
			}
			
			//System.out.println("List Size = "+tradelist.size());
	
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		try {
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
		TraderDAO tdao = new TraderDAOImpl();
		try
		{
			ps = conn.prepareStatement(FIND_TRADE);
			ps.setString(1, traderId);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				Trade trade = new Trade();
				trade.setTradeId(rs.getInt(1));
				Trader t =  tdao.findByTraderID(rs.getString(2));
				System.out.println("TRADER OBJECT"+t);
				trade.setTrader(new Trader(t.getTraderId(), t.getTraderName(), t.getDateReg(), t.getUsername(), t.getPassword(), t.getEmailId(), t.getPhone(), t.getDob()));
				trade.setTimeStamp(rs.getTimestamp(3));
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
		try {
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tradeslist;		
	}
	
	public static Predicate<Trader> findTrader(String traderId)
	{
	    return p -> p.getTraderId().equals(traderId);
	}
	
}
