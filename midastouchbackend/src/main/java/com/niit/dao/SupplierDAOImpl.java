package com.niit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Supplier;

@Repository("supplierDAO")
public class SupplierDAOImpl implements SupplierDAO
{
	@Autowired
	SessionFactory sessionFactory;
     
	@Transactional
	
	public boolean addSupplier(Supplier supplier) 
	{
		try
		   {
			Session session=sessionFactory.getCurrentSession();
			session.save(supplier); 
		    return true;
		   }
		   catch(Exception e)
		   {
			     return false;
	
		   }
	}


	public List<Supplier> retrieveSupplier() {
		// TODO Auto-generated method stub
		return null;
	}


	public boolean deleteSupplier(Supplier supplier) {
		// TODO Auto-generated method stub
		return false;
	}

	public Supplier getSupplier(int SupplierId) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean updateSupplier(Supplier supplier) {
		// TODO Auto-generated method stub
		return false;
	}

}
