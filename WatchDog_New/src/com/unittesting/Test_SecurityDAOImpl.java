package com.unittesting;

import static org.junit.jupiter.api.Assertions.*;

import java.security.Key;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import com.dao.SecurityDAOImpl;
import com.pojos.Security;

class Test_SecurityDAOImpl {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testAddSecurity() {
		//fail("Not yet implemented");		
//		SecurityDAOImpl dao = new SecurityDAOImpl();
//		
//		//Positive test case
//		Security sec = new Security(9999, "abc futures", 1);
//		int actual = dao.addSecurity(sec);
//		assertEquals(1, actual);
//		
//		//negative test case
//		Security sec2 = new Security(3030, "xyz", 1);
//		int actual2 = dao.addSecurity(sec2);
//		assertEquals(0, actual2);
	}
	

	@Test
	void testFindAllSecurity() {
		//fail("Not yet implemented");
		
//		SecurityDAOImpl dao = new SecurityDAOImpl();
//		List<Security> actual_securities  = new ArrayList<Security>();
//		List<Security> expected_securities  = new ArrayList<Security>();
//		
//		expected_securities.add(new Security(7890, "Equity Shares", 1));
//		expected_securities.add(new Security(1204, "Put Option", 1));
//		expected_securities.add(new Security(3030, "Call Option", 1));
//		expected_securities.add(new Security(9811, "Futures", 1));		
//		
//		actual_securities = dao.findAllSecurity();
//		
//		
//		//SORTING 		  
//		Comparator<Security> compareById = (Security a, Security b) -> (a.getSecurityId() - b.getSecurityId());
//		Collections.sort(expected_securities, compareById);
//		Collections.sort(actual_securities, compareById);
//		
//		for(int i=0;i<actual_securities.size();i++)
//		{
//			
//			assertEquals(expected_securities.get(i).getSecurityId(), 
//					      actual_securities.get(i).getSecurityId() );
//			assertEquals(expected_securities.get(i).getSecurityName(), 
//				      actual_securities.get(i).getSecurityName() );
//			assertEquals(expected_securities.get(i).getLotSize(), 
//				      actual_securities.get(i).getLotSize());
//			
//			
//			
//		}
		
		
		
	}

}
