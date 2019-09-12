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
	public void setWashTrade(Trade trade);
}
//

/*
 * set fetch size
 * ps.setfetchsize 850
 * ojdbc driver.
 * 
 * */
 