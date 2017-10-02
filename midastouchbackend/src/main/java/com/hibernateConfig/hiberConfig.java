package com.hibernateConfig;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import com.DaoImpl.*;
import com.model.*;
@Configuration
@EnableTransactionManagement
@ComponentScan("com")
public class hiberConfig 
{
@Autowired
@Bean(name="dataSource")
public DataSource getH2()
{
	System.out.println("Hibernate initiated.....");
	DriverManagerDataSource dsource = new DriverManagerDataSource();
			dsource.setDriverClassName("org.h2.driver");
			dsource.setUrl("jdbc:h2:tcp://localhost/~/mdt");
			dsource.setUsername("sa");
			dsource.setPassword("");
			System.out.println("connection established");
			return dsource;
}
private Properties getHiberProps()
{
	Properties p = new Properties();
	p.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
	p.put("hibernate.show_sql","true");
	p.put("hibernate.hbm2ddl.auto","update");
	System.out.println("Data table created in H2");
	return p;
}
@Autowired
@Bean(name = "sessionFactory")
public SessionFactory getSession(DataSource datasource)
{
	LocalSessionFactoryBuilder  lsfb = new LocalSessionFactoryBuilder(datasource);
	lsfb.addProperties(getHiberProps());
	lsfb.addAnnotatedClass(User.class);
	return lsfb.buildSessionFactory();
}


@Autowired
@Bean(name = "UserDaoImpl")
public UserDaoImpl getUserData(SessionFactory sessionFac)
{
	return new UserDaoImpl(sessionFac);
}


@Autowired
@Bean(name ="transactionManager")
public HibernateTransactionManager getTransaction(SessionFactory sessionFac)
{
	HibernateTransactionManager hm = new HibernateTransactionManager(sessionFac);
    return hm;
}

}

