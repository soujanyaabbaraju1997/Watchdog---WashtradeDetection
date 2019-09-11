package com.dao;
//
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
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
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "group8", "trade");
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
		String INSERT_TRADE = "insert into trades values(?,?,?,?,?,?,?,?,?,?)";
			
		try(Connection conn = openConnection();PreparedStatement ps = conn.prepareStatement(INSERT_TRADE);)
		{
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
		
		try(Connection conn = openConnection();PreparedStatement ps = conn.prepareStatement(FIND_TRADE);)
		{
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
		return trade;
	}

	@Override
	public List<Trade> findAllTrades()
	{
		List<Trade> tradelist = new ArrayList<Trade>();
		String FIND_ALL_TRADES = "select * from trades";
		
		TraderDAO dao = new TraderDAOImpl();
		List<Trader> traderlist = dao.findAllTraders();		
		
		try(Connection conn = openConnection();PreparedStatement ps = conn.prepareStatement(FIND_ALL_TRADES);) 
		{
			ps.setFetchSize(1000);
			ResultSet rs = ps.executeQuery();
			int index = 0 ;
			while(rs.next()) {
				Trade trade = new Trade();
				//System.out.println("List Size = "+tradelist.size());
				String traderID_fromTrades = rs.getString(2);
				
				Trader trader = new Trader();
				trader = filterTraders(traderlist, (t) -> {
					return ( t.getTraderId().equals(traderID_fromTrades) );
				}).get(0);
						
				trade.setTrader(trader);				
				trade.setTradeId(rs.getInt(1));
				trade.setTimeStamp(rs.getTimestamp(3));		
				trade.setTradeType(rs.getString(4));
				trade.setSecurityId(rs.getInt(5));
				trade.setQty(rs.getInt(6));
				trade.setDealPrice(rs.getFloat(7));
				trade.setFirmId(rs.getInt(8));
				trade.setBrokerId(rs.getString(9));
				
				tradelist.add(index, trade);
				index++ ;	
			}
			System.out.println("TradeList: " + tradelist +"\n");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return tradelist;
}

   static public List<Trader> filterTraders(List<Trader> t, Predicate<Trader> predicate){
		
		return t.stream().filter(predicate).collect(Collectors.toList());
	}
	


	@Override
	public List<Trade> findByTraderId(String traderId)
	{
		
		List<Trade> tradeslist = new ArrayList<Trade>();
		String FIND_TRADE = "select * from trades where trader=?";
		

		TraderDAO tdao = new TraderDAOImpl();
		try(Connection conn = openConnection();PreparedStatement ps = conn.prepareStatement(FIND_TRADE);)
		{
			ps.setString(1, traderId);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				Trade trade = new Trade();
				trade.setTradeId(rs.getInt(1));
				Trader t =  tdao.findByTraderID(rs.getString(2));
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
			//
		}
		return tradeslist;		
		//
	}
	
	public static Predicate<Trader> findTrader(String traderId)
	{
	    return p -> p.getTraderId().equals(traderId);
	}
	
}
