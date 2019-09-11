package com.unittesting;
//
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.dao.LoginDAO;

class Test_LoginDAO {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testDologin() {
		//fail("Not yet implemented");
		
		LoginDAO dao = new LoginDAO();
		
		//Negative test case
		String actual1 = dao.dologin("Rajesh", "123hs");
		assertEquals("no_user", actual1);
		
		String actual2 = dao.dologin("Rupashii", "admin2");
		assertEquals("no_user", actual2);
		
		String actual3 = dao.dologin("Tuhina", "admin77");
		assertEquals("no_user", actual3);
		
		
		//Positive test case
		String actual4 = dao.dologin("Gaurav", "admin8");
		assertEquals("Gaurav", actual4);
		
		String actual5 = dao.dologin("Pamela", "dvknxxkb");
		assertEquals("Pamela", actual5);
		
		String actual6 = dao.dologin("Autumn", "wvppyffk");
		assertEquals("Autumn", actual6);
		
	}

}
