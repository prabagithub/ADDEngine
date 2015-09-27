/**
 * 
 */
package com.test.servlet;

import static org.junit.Assert.*;

import org.junit.Test;

import com.add.db.MongoDBDAO;
import com.add.domain.Client;

/**
 * @author revathi
 *
 */
public class AddServletTest {
	
	

	/**
	 * Test method for {@link com.add.servlet.AddServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}.
	 */
	@Test
	public void testDoPostHttpServletRequestHttpServletResponse() {
		Client client = new Client();
		client.setOrgName("Dominos");
		client.setAddr1("OMR Road");
		client.setAddr2("");
		client.setAddr3("");
		client.setCity("Chennai");
		client.setState("Tamilnadu");
		client.setCountry("India");
		client.setPostalCode("600091");
		client.setAddDesc("Great offer");		
		MongoDBDAO mongoDAO = new MongoDBDAO();
		boolean result = mongoDAO.insertADDDetails(client);
		assertEquals(true, result);
	}

}
