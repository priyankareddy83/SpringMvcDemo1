package com.niit.test;

import static org.junit.Assert.*;

import org.hibernate.SessionFactory;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.ProductDAO;
import com.niit.model.Product;

public class ProductDAOTest 
{

	static ProductDAO productDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext configApplnContext=new AnnotationConfigApplicationContext();
		configApplnContext.scan("com.niit");
		configApplnContext.refresh();
		
		//SessionFactory sessionFactory=(SessionFactory)configApplnContext.getBean("DBConfig.class");
		
		productDAO=(ProductDAO)configApplnContext.getBean("productDAO");
	}
	
 
	@Test
	public void addProductTest()
	{
		Product product=new Product();
		product.setProductId(1002);
		product.setProductName("Samsung J5");
		product.setProductDesc("Mobile with NFC and 4G");
		product.setStock(10);
		product.setPrice(7000);
		product.setCatId(1001);
		product.setSupplierId(1001);
		
		assertTrue("Problem in Insertion",productDAO.addProduct(product));
		
	}
	
	
}

