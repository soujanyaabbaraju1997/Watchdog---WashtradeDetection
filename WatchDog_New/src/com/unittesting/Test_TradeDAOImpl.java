package com.unittesting;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.dao.TradeDAOImpl;
import com.pojos.Trade;
import com.pojos.Trader;

class Test_TradeDAOImpl {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

//	@Test
//	void testAddTrade() {
//		//fail("Not yet implemented");
//		TradeDAOImpl dao= new TradeDAOImpl();
//		Trader trader= new Trader();
//		Time time= System.currentTimeMillis();
//		Timestamp time= new Timestamp(System.currentTimeMillis());
//		Trade trade = new Trade(345634, trader,time,"nonsense",1204,789,567.78f,101,"Zerodha",0);
//		int actual=dao.addTrade(trade);
//		assertEquals(1, actual);
//		
//	}

//	@Test
//	void testFindTradeById() {
//		//fail("Not yet implemented");
//		TradeDAOImpl dao= new TradeDAOImpl();
//		Trade trade = new Trade();
//		trade=dao.findTradeById(100405);
//		assertEquals(100405, trade.getTradeId());
//		
//		
//	}
//
//	@Test
//	void testFindAllTrades() {
//		//fail("Not yet implemented");
//		TradeDAOImpl dao= new TradeDAOImpl();
//		List<Trade> tradelist = new ArrayList<Trade>();
//		tradelist=dao.findAllTrades();
//		System.out.println(tradelist.size());
//		assertEquals(800, tradelist.size());
//	}
	
//
//	@Test
//	void testFilterTraders() {
//		fail("Not yet implemented");
//	}
//
	@Test
	void testFindByTraderId() {
		//fail("Not yet implemented");
	TradeDAOImpl dao= new TradeDAOImpl();
	List<Trade> tradelist = new ArrayList<Trade>();
	tradelist=dao.findByTraderId("GAU7P0MO");
	assertEquals(8, tradelist.size());
	}

	

}
