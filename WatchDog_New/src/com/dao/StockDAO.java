package com.dao;

import com.pojos.Stock;

public interface StockDAO 
{
	public int addRecord(Stock stock);
	public Stock findStock(int firmId, int securityId);
	public Stock deleteStock(int firmId, int securityId);
	public boolean updateHighPrice(int firmId, int securityId);
	public boolean updateLowPrice(int firmId, int securityId);
	public boolean updateLTP(int firmId, int securityId);
}
