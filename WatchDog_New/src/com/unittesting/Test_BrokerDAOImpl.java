package com.unittesting;
//
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.dao.BrokerDAOImpl;
import com.pojos.Broker;

class Test_BrokerDAOImpl {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testAddBroker() {
		//fail("Not yet implemented");
		
//		BrokerDAOImpl dao = new BrokerDAOImpl();
//		
//		 //Positive test cases
//		Broker broker = new Broker("XYZ");
//		int actual = dao.addBroker(broker);
//		assertEquals(1, actual);
//		
//		//Negative test cases
//		Broker broker1 = new Broker("FYERS");
//		int actual2 = dao.addBroker(broker1);
//		assertEquals(0, actual2);
	}

	@Test
	void testFindAllBrokers() {
		//fail("Not yet implemented");
//		
//		BrokerDAOImpl dao = new BrokerDAOImpl();
//		List<String> expected_brokers = new ArrayList<>(
//					Arrays.asList("ZERODHA", "UPSTOX", "SHAREKHAN", "FYERS",
//							      "ANGEL BROKING", "ICICI DIRECT", "5PAISA", 
//							       "MOTILAL OSWAL") );
//		expected_brokers.sort( Comparator.comparing( String::toString ) );	
//		
//		List<String> actual_brokers = new ArrayList<>();
//		
//		//Positive test case
//		actual_brokers= dao.findAllBrokers();
//		actual_brokers.sort( Comparator.comparing( String::toString ) );	
//		
//		assertArrayEquals(expected_brokers.toArray(), actual_brokers.toArray());
	}

}
