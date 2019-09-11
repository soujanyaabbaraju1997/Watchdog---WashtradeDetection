package com.dao;

import java.util.List;

import com.pojos.Trader;
import com.pojos.User;

public interface TraderDAO
{
	public int addTrader(Trader trader);
	public List<String> findAllTraderIds();			//string - list of trader ids
	public List<Trader> findAllTraders();
	public Trader findByTraderID(String traderId);
}
