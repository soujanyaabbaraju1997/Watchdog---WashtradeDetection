package com.dao;
//
import java.util.List;
import java.util.stream.Stream;

import com.pojos.Trade;

public interface TradeDAO 
{
	public int addTrade(Trade t);
	public Trade findTradeById(int tradeId);
	public List<Trade> findAllTrades();
	public List<Trade> findByTraderId(String traderId);
	public List<Trade> findWashTrades();
	public void setWashTrade(Trade trade);
	public int getLastTradeID();
}
//

/*
 * set fetch size
 * ps.setfetchsize 850
 * ojdbc driver.
 * 
 * */
 