package com.unittesting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.dao.StockDAOImpl;
import com.pojos.Stock;

class Test_StockDAOImpl {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testOpenConnection() {
		//fail("Not yet implemented");
		// not testing this. 
	}

	@Test
	void testAddRecord() {
		//fail("Not yet implemented");
		
//		StockDAOImpl dao = new StockDAOImpl();
//		
//		// Negative test cases
//		Stock stock = new Stock(101, 1204, 134.5f, 123f, 130.56f);
//		int actual1 = dao.addRecord(stock);
//		assertEquals(0, actual1);
//		
//		Stock stock2 = new Stock(103, 7890, 192.34f, 189.76f, 190.234f);
//		int actual2 = dao.addRecord(stock2);
//		assertEquals(0, actual2);
		
		// Positive test case - (delete the record & run)
		
//		Stock stock3 = new Stock(101, 9811, 190.5377f, 187.1276f, 189.32272752278766f);
//		int actual3 = dao.addRecord(stock3);
//		assertEquals(1, actual3);		
		
	}

	@Test
	void testFindStock() {
		//fail("Not yet implemented");
		
//		StockDAOImpl dao = new StockDAOImpl();
//		Stock stock = new Stock();
//		
//		// Negative test cases
//		stock = dao.findStock(102, 1111);
//		assertEquals(-1, stock.getFirmId());
//		assertEquals(-1, stock.getSecurityId());
//		
//		// Positive test case 	
//		stock = dao.findStock(103, 7890);	
//		assertEquals(103, stock.getFirmId());
//		assertEquals(7890, stock.getSecurityId());
	}

	@Test
	void testDeleteStock() {
		//fail("Not yet implemented");
		
//		StockDAOImpl dao = new StockDAOImpl();
//		Stock stock = new Stock();
//		
//		// Negative test cases
//		stock = dao.deleteStock(100, 3030);
//		assertEquals(-1, stock.getFirmId());
//		assertEquals(-1, stock.getSecurityId());
//		
//		// Positive test case 	
//		stock = dao.deleteStock(102, 3030);	
//		assertEquals(102, stock.getFirmId());
//		assertEquals(3030, stock.getSecurityId());		
	
	}

	@Test
	void testUpdateHighPrice() {
		//fail("Not yet implemented");
		
//		StockDAOImpl dao = new StockDAOImpl();
//		boolean actual;
//		
//		// Negative test cases
//		actual = dao.updateHighPrice(100, 1204);
//		assertEquals(false, actual);
//		
//		// Positive test case 	
//		actual = dao.updateHighPrice(101, 7890);
//		assertEquals(true, actual);
	}

	@Test
	void testUpdateLowPrice() {
		//fail("Not yet implemented");
		

//		StockDAOImpl dao = new StockDAOImpl();
//		boolean actual;
//		
//		// Negative test cases
//		actual = dao.updateLowPrice(105, 1204);
//		assertEquals(false, actual);
//		
//		// Positive test case 	
//		actual = dao.updateLowPrice(103, 7890);
//		assertEquals(true, actual);
	}

	@Test
	void testUpdateLTP() {
		//fail("Not yet implemented");
		
//		StockDAOImpl dao = new StockDAOImpl();
//		boolean actual;
//		
//		// Negative test cases
//		actual = dao.updateLTP(107, 1204);
//		assertEquals(false, actual);
//		
//		// Positive test case 	
//		actual = dao.updateLTP(101, 3030);
//		assertEquals(true, actual);
	}

}
