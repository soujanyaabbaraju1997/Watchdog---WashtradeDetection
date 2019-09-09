package com.dao;
//
import java.util.List;

import com.pojos.Trade;

public interface TradeDAO 
{
	public int addTrade(Trade t);
	public Trade findTradeById(int tradeId);
	public List<Trade> findAllTrades();
	public List<Trade> findByTraderId(String traderId);
}
