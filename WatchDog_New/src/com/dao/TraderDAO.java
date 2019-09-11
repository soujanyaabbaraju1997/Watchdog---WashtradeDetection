package com.dao;

import java.util.List;

import com.pojos.Trader;
import com.pojos.User;

public interface TraderDAO
{
	public int addTrader(Trader trader);
	public List<String> findAllTraders();			//string - list of trader ids
	public Trader findByTraderID(String traderId);
}
