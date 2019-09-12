package com.unittesting;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.dao.TraderDAOImpl;
import com.pojos.Trader;

class Test_tradersDAOImpl {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testAddTrader() {
		//fail("Not yet implemented");
		
//		//Positive
//		TraderDAOImpl dao= new TraderDAOImpl();
//		Date date=new Date(2019, 1, 1);
//		Date dob= new Date(1978,5,5);
//		Trader trader=new Trader("200000","baba ramdev", date,"bjm,j","gfkjwafk","gsjag@dfdds", 995678956l,dob);
//		int actual=dao.addTrader(trader);
//		assertEquals(1, actual);
		
//		//negative test case
//		TraderDAOImpl dao1= new TraderDAOImpl();
//		Date date1=new Date(2019, 1, 1);
//		Date dob1= new Date(1978,5,5);
//		Trader trader1=new Trader("200000","baba ramdev", date1,"Soujanya","gfkjwafk","gsjag@dfdds", 995678956l,dob1);
//		int actual1=dao1.addTrader(trader1);
//		assertEquals(0, actual1);
		
		
		
	}

	@Test
	void testFindAllTraderIds() {
		//fail("Not yet implemented");
		
//		TraderDAOImpl dao= new TraderDAOImpl();
//		List<String> traders = new ArrayList<String>();
//		traders=dao.findAllTraderIds();
//		assertEquals(9, traders.size());
		
		
	}

//	@Test
//	void testFindAllTraders() {
//		//fail("Not yet implemented");
//		
//		TraderDAOImpl dao= new TraderDAOImpl();
//		List<Trader> traders = new ArrayList<Trader>();
//		traders=dao.findAllTraders();
//		assertEquals(9, traders.size());
//		
//		
//	}

	@Test
	void testFindByTraderID() {
		//fail("Not yet implemented");
//		TraderDAOImpl dao= new TraderDAOImpl();
//		
//		//Positive		
//		Trader trader=new Trader();
//		trader = dao.findByTraderID("MANARYUL");
//		assertEquals("MANARYUL", trader.getTraderId());
//		
//		//Negative
//		Trader trader1=new Trader();
//		trader1 = dao.findByTraderID("BLAHHHH");
//		assertEquals("DEFAULT", trader1.getTraderId());
		
		
	}
	@Test
	void testFindByUsername() {
		TraderDAOImpl dao= new TraderDAOImpl();
		
		//Positive		
		Trader trader=new Trader();
		trader = dao.findByUsername("Soujanya");
		assertEquals("Soujanya", trader.getUsername());
		
		//Negative
		Trader trader1=new Trader();
		trader1 = dao.findByTraderID("BLAHHHH");
		assertEquals("DEFAULT", trader1.getUsername());
		
	}

}
