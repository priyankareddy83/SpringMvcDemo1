package com.niit.test;

import static org.junit.Assert.*;

import org.hibernate.SessionFactory;
import org.junit.Test;



import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.AddressDAO;
import com.niit.model.Address;


public class AddressTest {

	@Autowired
	static AnnotationConfigApplicationContext context;

	@Autowired
	static AddressDAO addressDAO;

	@Autowired
	static Address address;

	@BeforeClass
	public static void initialize() {
		AnnotationConfigApplicationContext configApplnContext=new AnnotationConfigApplicationContext();
		configApplnContext.scan("com.niit");
		configApplnContext.refresh();
		
		//SessionFactory sessionFactory=(SessionFactory)configApplnContext.getBean("DBConfig.class");
		
		addressDAO=(AddressDAO)configApplnContext.getBean("addressDAO");
	}
	


	@Test
	public void createAddressTest() {
		address.setId("hi");
		address.setUser_id("Suveen");
		address.setH_no("2-46-11");
		address.setStreet("Villa Vari Street, Venkat Nagar");
		address.setCity("Kakinada");
		address.setCountry("India");
		address.setPin("533003");

		boolean flag = addressDAO.save(address);

		assertEquals("createAddressTest", true, flag);

	}
   @Ignore
	@Test
	public void updateAddressTest() {
		address.setId("SwethaAddress");
		address.setUser_id("Suveen");
		address.setH_no("2-46-11");
		address.setStreet("Villa Vari Street, Venkat Nagar");
		address.setCity("Kakinada");
		address.setCountry("India");
		address.setPin("533003");

		boolean flag = addressDAO.update(address);

		assertEquals("createAddressTestCase", true, flag);

	}
    @Ignore
	@Test
	public void listAllAddressTest() {
		int actualSize = addressDAO.list().size();
		assertEquals(2, actualSize);
	}

}

