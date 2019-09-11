package com.unittesting;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.dao.FirmDAOImpl;
import com.pojos.Firm;

class Test_FirmDAOImpl extends FirmDAOImpl {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testAddfirm() {
	//	fail("Not yet implemented");
		
//		FirmDAOImpl dao= new FirmDAOImpl();
//		Firm firm= new Firm(104,"random");
//		int actual= dao.addfirm(firm);
//		assertEquals(1, actual);
//		
//		//negative testcase
//		FirmDAOImpl dao1= new FirmDAOImpl();
//		Firm firm2= new Firm(101,"random");
//		int actual2= dao1.addfirm(firm2);
//		assertEquals(0, actual2);
//		
	}

	@Test
	void testFindAllFirms() {
		//fail("Not yet implemented");
//		FirmDAOImpl dao= new FirmDAOImpl();
//		List<Firm> firms = new ArrayList<Firm>();
//		List<Firm> firmsactual = new ArrayList<Firm>();
//		
//		Firm firm= new Firm(101,"Facebook");
//		Firm firm1= new Firm(102,"Walmart");
//		Firm firm2= new Firm(103,"Apple");
//		firms.add(firm);
//		firms.add(firm1);
//		firms.add(firm2);
//		firmsactual= dao.findAllFirms();
//		
//		for(int i=0;i<firmsactual.size();i++)
//		{
//			int id=(firmsactual.get(i).getFirmId());
//			String name=firmsactual.get(i).getFirmName();
//			assertEquals(firms.get(i).getFirmId(), id);
//			assertEquals(firms.get(i).getFirmName(), name);
//			
//		}
		
	
		
	}

}
