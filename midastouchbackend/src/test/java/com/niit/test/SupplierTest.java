package com.niit.test;

import static org.junit.Assert.*;

import org.hibernate.SessionFactory;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.niit.dao.SupplierDAO;
import com.niit.model.Supplier;

public class SupplierTest
{
	static SupplierDAO supplierDAO;

	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext configApplnContext=new AnnotationConfigApplicationContext();
		configApplnContext.scan("com.niit");
		configApplnContext.refresh();
		
		//SessionFactory sessionFactory=(SessionFactory)configApplnContext.getBean("DBConfig.class");
		
		supplierDAO=(SupplierDAO)configApplnContext.getBean("supplierDAO");
	}
	
	@Test
	public void addSupplierTest()
	{
		Supplier supplier=new Supplier();
		supplier.setSupplierId(101);
	    supplier.setSuppName("televisions");
		supplier.setSuppDesc("all kinds of televisionss ");
		
		assertTrue(supplierDAO.addSupplier(supplier));
	}
	
	
}
