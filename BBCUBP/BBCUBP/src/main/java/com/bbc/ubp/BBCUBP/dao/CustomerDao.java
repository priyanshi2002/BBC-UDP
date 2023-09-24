package com.bbc.ubp.BBCUBP.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bbc.ubp.BBCUBP.entity.ContactInfo;
import com.bbc.ubp.BBCUBP.entity.Customer;

@Repository
public class CustomerDao {

	@Autowired
	SessionFactory factory;
	
	public Customer getDetailsByCustomerId(int customerId) {
		Session session = factory.openSession();
		 return session.get(Customer.class,customerId);
		 
	}
 

	public Customer getCustomer(int customerId) {
		Session session = factory.openSession();
		 

		return null;
	}
	
}
