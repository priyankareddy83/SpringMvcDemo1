package com.niit.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.model.Address;
import com.niit.model.Cart;
import com.niit.model.Category;
import com.niit.model.Product;
import com.niit.model.Supplier;
import com.niit.model.User;
import com.niit.test.UserDAOTestCase;
import com.niit.test.UserTest;

//import com.niit.model.Supplier;
//import com.DaoImpl.*;
//import com.model.*;
@Configuration
@EnableTransactionManagement
@ComponentScan("com.niit")
public class DBConfig 
{
	//creating a DataSource bean
public DataSource getH2DataSource()
{
	System.out.println("Hibernate initiated.....");
	DriverManagerDataSource driverMgrDataSource = new DriverManagerDataSource();
	driverMgrDataSource.setDriverClassName("org.h2.Driver");
	driverMgrDataSource.setUrl("jdbc:h2:tcp://localhost/~/mdtp");
	driverMgrDataSource.setUsername("sa");
	driverMgrDataSource.setPassword("");
			System.out.println("connection established");
			return driverMgrDataSource;
}
//session factory Bean created
@Bean(name ="sessionFactory")
public SessionFactory getSessionFactory()
{
	Properties hibernateProperties = new Properties();
	
	hibernateProperties.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
	hibernateProperties.setProperty("hibernate.hbm2ddl.auto","update");
	LocalSessionFactoryBuilder  localSessionFacBuilder = new LocalSessionFactoryBuilder(getH2DataSource());
	 localSessionFacBuilder.addProperties(hibernateProperties);
	 localSessionFacBuilder.addAnnotatedClass(Category.class);
	localSessionFacBuilder.addAnnotatedClass(Supplier.class);
		localSessionFacBuilder.addAnnotatedClass(Product.class);
		localSessionFacBuilder.addAnnotatedClass(Cart.class);
		localSessionFacBuilder.addAnnotatedClass(Address.class);
		localSessionFacBuilder.addAnnotatedClass(User.class);
	SessionFactory 	sessionFactory =  localSessionFacBuilder.buildSessionFactory();
System.out.println("session factory object is created");
	return sessionFactory;
}
//transaction bean object
@Bean
public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory)
{
	HibernateTransactionManager hibernateTranMgr = new HibernateTransactionManager(sessionFactory);
			return  hibernateTranMgr;
}

}


