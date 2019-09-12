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
import com.dao.TraderDAOImpl;
import com.pojos.Trade;
import com.pojos.Trader;

class Test_TradeDAOImpl {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testAddTrade() {
		//fail("Not yet implemented");
//		TradeDAOImpl dao= new TradeDAOImpl();
//		TraderDAOImpl dao1 = new TraderDAOImpl();
//		
//		Trader trader= dao1.findByTraderID("HARMENON");
//		Timestamp time= new Timestamp(System.currentTimeMillis());
//		
//		//Positive test case
//		
//		Trade trade = new Trade(345634, trader,time,"nonsense",1204,789,567.78f,101,"ZERODHA",0);
//		int actual=dao.addTrade(trade);
//		assertEquals(1, actual);
//		
//		//Negative test case
//		Trade trade1 = new Trade(100138, trader,time,"nonsense",1204,789,567.78f,101,"ZERODHA",0);
//		int actual1=dao.addTrade(trade1);
//		assertEquals(0, actual1);
		
	}

//	@Test
	void testFindTradeById() {
		//fail("Not yet implemented");
		
//		TradeDAOImpl dao= new TradeDAOImpl();
//		
//		//Positive test case
//		Trade trade = new Trade();
//		trade=dao.findTradeById(100405);
//		assertEquals(100405, trade.getTradeId());
//		
//		//Negative test case
//		Trade trade1 = new Trade();
//		trade1=dao.findTradeById(333333);
//		assertEquals(0, trade1.getTradeId());
		
		
	}

//	@Test
//	void testFindAllTrades() {
//		//fail("Not yet implemented");
//		
//		TradeDAOImpl dao= new TradeDAOImpl();
//		List<Trade> tradelist = new ArrayList<Trade>();
//		tradelist=dao.findAllTrades();
//		
//		//System.out.println(tradelist.size());
//		assertEquals(43, tradelist.size());
//	}
	
	@Test
	void testFindByTraderId() {
		//fail("Not yet implemented");
//	TradeDAOImpl dao= new TradeDAOImpl();
//		
//	//Positive test case	
//	List<Trade> tradelist = new ArrayList<Trade>();
//	tradelist=dao.findByTraderId("HARMENON");
//	assertEquals(9, tradelist.size());
//	
//	
//	//Negative test case
//	List<Trade> tradelist1 = new ArrayList<Trade>();
//	tradelist1=dao.findByTraderId("ABCMENON");
//	assertEquals(0, tradelist1.size());
	
	}

	

}
