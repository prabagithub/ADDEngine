package com.test.db;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.add.db.MongoDBDAO;
import com.add.domain.User;

public class MongoDBDAOTest {

	static User user1;
	static User user2;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		user1 = null;		
		
		
		user2 = new User();
		user2.setPassword("pass");
		user2.setUsername("lakshmipraba");
		
		
		
	}

	@Test
	public void testCheckNullUser() {
		MongoDBDAO mongo = new MongoDBDAO();
		assertEquals(false,mongo.checkUser(user1));
	}

	@Test
	public void testCheckUnRegisteredUser() {
		MongoDBDAO mongo = new MongoDBDAO();
		assertEquals(false,mongo.checkUser(user1));
	}
	

}
