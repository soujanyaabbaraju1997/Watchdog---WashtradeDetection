package com.unittesting;

import static org.junit.jupiter.api.Assertions.*;


import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.dao.UserDAOImpl;
import com.pojos.User;

class Test_UserDAOImpl {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

//	@Test
//	void testAddUser() {
//		//fail("Not yet implemented");
//	Date date= new Date(2019, 02, 19);
//		User user=new User("dhksnvsk","iiioii","mjyothi",994055994,date);
//		UserDAOImpl dao=new UserDAOImpl();
//		int actual=dao.addUser(user);
//		
//		assertEquals(1, actual);
//		
//		Date date1= new Date(2019, 02, 19);
//		User user1=new User("Soujanya00","iiioii","mjyothi",994055994,date1);
//		UserDAOImpl dao1=new UserDAOImpl();
//		int actual1=dao1.addUser(user1);
//		
//		assertEquals(0, actual1);
//		
//	}
	
	
	

//	@Test
//	void testUpdateEmailId() {
//		//fail("Not yet implemented");
//		UserDAOImpl dao=new UserDAOImpl();
//		boolean actual=dao.updateEmailId("Rupashi", "soujy@.us");
//		assertEquals(true, actual);
//		
//		UserDAOImpl dao1=new UserDAOImpl();
//		boolean actual1=dao1.updateEmailId("iiii", "soujy@.us");
//		assertEquals(false, actual1);
//		
//		
//		
//		
//	}
//
//	@Test
//	void testUpdatePhone() {
////		fail("Not yet implemented");
//	UserDAOImpl dao=new UserDAOImpl();
//	boolean actual=dao.updatePhone("Soujanya",988779899);
//	assertEquals(true, actual);
//	UserDAOImpl dao1=new UserDAOImpl();
//	boolean actual1=dao1.updatePhone("iiii",888888888);
//	assertEquals(false, actual1);
//	
//	}
//
//	@Test
//	void testUpdatePassword() {
//		//fail("Not yet implemented");
//		UserDAOImpl dao=new UserDAOImpl();
//		boolean actual=dao.updatePassword("Rupashi", "uckoff");
//		assertEquals(true, actual);
//		
//		UserDAOImpl dao1=new UserDAOImpl();
//		boolean actual1=dao1.updatePassword("iiii", "hdgkjwe");
//		assertEquals(false, actual1);
//		
//		
//	}
//
	@Test
	void testFindUserByUsername() {
		//fail("Not yet implemented");
		UserDAOImpl dao=new UserDAOImpl();
		User user = new User();
		User actual=new User();
	    java.sql.Date myDate = new java.sql.Date(75,1,19);
		user.setAdmin(1);
		user.setDob(myDate);
		System.out.println(user.getDob());
		user.setUsername("Soujanya");
		user.setPassword("admin1");
		user.setPhone(9027759991l);
		user.setEmailId("hhays78@hotma1l.us");
	    actual=dao.findUserByUsername("Soujanya");
		assertEquals(user.getUsername(), actual.getUsername());
		assertEquals(user.getPassword(), actual.getPassword());
		assertEquals(user.getEmailId(), actual.getEmailId());
		assertEquals(user.getPhone(), actual.getPhone());
		assertEquals(user.getDob(), actual.getDob());
	}
//
//	@Test
//	void testDeleteUser() {
//		//fail("Not yet implemented");
//		UserDAOImpl dao=new UserDAOImpl();
//		User user = new User();
//		User actual=new User();
//		
//		
//			java.sql.Date myDate = new java.sql.Date(75,1,19);
//			user.setDob(myDate);
//		
//		user.setAdmin(1);
//		
//		//System.out.println(user.getDob());
//		user.setUsername("Soujanya");
//		user.setPassword("admin1");
//		user.setPhone(988779899);
//		user.setEmailId("hhays78@hotma1l.us");
//		actual=dao.deleteUser("Soujanya");
//		assertEquals(user.getUsername(), actual.getUsername());
//		assertEquals(user.getPassword(), actual.getPassword());
//		assertEquals(user.getEmailId(), actual.getEmailId());
//		assertEquals(user.getPhone(), actual.getPhone());
//		assertEquals(user.getDob(), actual.getDob());
		
		//negative test case
//		user.setUsername("iiiiii");
//		user.setPassword("admin1");
//		user.setPhone(988779899);
//		user.setEmailId("hhays78@hotma1l.us");
//		actual=dao.deleteUser("Soujanya");
//		assertEquals("DEFAULT", actual.getUsername());
//		assertEquals("DEFAULT", actual.getPassword());
//		assertEquals("DEFAULT", actual.getEmailId());
//		assertEquals(000000000,actual.getPhone());
	  //  assertEquals(2900-02-01, actual.getDob());
		
//	}

}
