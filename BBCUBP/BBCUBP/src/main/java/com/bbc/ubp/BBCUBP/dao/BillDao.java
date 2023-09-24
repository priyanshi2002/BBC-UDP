package com.bbc.ubp.BBCUBP.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bbc.ubp.BBCUBP.entity.Bill;
import com.bbc.ubp.BBCUBP.entity.Customer;

@Repository
public class BillDao {

	@Autowired
	SessionFactory factory;
	@Autowired
	CustomerDao customerDao;

	public List<Bill> getBillsByCustomerId(int customerId) {
		Session session = factory.openSession();
		Customer customerDB = customerDao.getDetailsByCustomerId(customerId);
		if (customerDB == null) {
			return new ArrayList<>();
		}
		Criteria criteria = session.createCriteria(Bill.class);
		criteria.add(Restrictions.eq("customerId", customerDB.getCustomerId()));
		return criteria.list();
	}

	
	public List<Bill> getUnpaidCustomerBills(int customerId) {
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Bill.class);
		criteria.add(Restrictions.eq("customerId", customerId));
		return criteria.list();
	}

	
	public List<Bill> getPaidCustomerBills(int customerId) {
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Bill.class);
		criteria.add(Restrictions.eq("customerId", customerId));
		return criteria.list();
	}
	

	public Bill getBills(int billId) {
		Session session = factory.openSession();
		return session.get(Bill.class, billId);
	}

}
