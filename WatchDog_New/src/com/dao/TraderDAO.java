package com.dao;

import com.pojos.Trader;

public interface TraderDAO 
{
	int addTrader(Trader trader);
	Trader findTraderById(int traderId);
	void ViewLiveMarket();
}
