package com.niit.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Address;

@Repository("addressDAO")
@Transactional
public class AddressDAOImpl implements AddressDAO
{
	@Autowired
	private SessionFactory sessionFactory;

	public AddressDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	public boolean save(Address address)
	{
		try {
			sessionFactory.getCurrentSession().save(address);
		} catch (Exception e) {
			// if any exception comes during execute of try block, catch will
			// execute
			e.printStackTrace();
			return false;
		}
		return true;
	}


	public boolean update(Address address) {
		try {
			sessionFactory.getCurrentSession().update(address);
		} catch (Exception e) {
			// if any exception comes during execute of try block, catch will
			// execute
			e.printStackTrace();
			return false;
		}
		return true;

		
	}


	public List<Address> list() {
		return sessionFactory.getCurrentSession().createQuery("from Address").list();

		// TODO Auto-generated method stub
		
	}
public Address get(String id) {
		
		//get method get the date from user table based on primary key i.e., id
		// and set it to Category class
		//like select * from category where id = ?
	  return 	(Address)  sessionFactory.getCurrentSession().get(Address.class, id);
		
	}

	public boolean delete(String id) {
		try {
			sessionFactory.getCurrentSession().delete(getAddressById(id));
		} catch (Exception e) {
			// if any exception comes during execute of try block, catch will
			// execute
			e.printStackTrace();
			return false;
		}
		return true;
		
	}


	public Address getAddressById(String id) {
		return 	(Address)  sessionFactory.getCurrentSession().get(Address.class, id);
		// TODO Auto-generated method stub
		
	}


	public Address getAddressByUserid(String userid) {
		return 	(Address)  sessionFactory.getCurrentSession().createQuery("from Address where user_id = ?").setString(0, userid).uniqueResult();

		// TODO Auto-generated method stub
	}

}
