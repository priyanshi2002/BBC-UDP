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
import com.bbc.ubp.BBCUBP.entity.Invoice;

@Repository
public class InvoiceDao {
	
	@Autowired
	SessionFactory factory;
	
	@Autowired
	CustomerDao customerDao;
	
	@Autowired
	BillDao billDao;
	
	public Invoice getAllInvoice(int invoiceId) {
		Session session = factory.openSession();
		return session.get(Invoice.class,invoiceId);
	}

	public List<Invoice> getInvoiceByCusId(int customerId) {
		Session session = factory.openSession();
		Customer customerDB = customerDao.getDetailsByCustomerId(customerId);
		if(customerDB==null) {
			return new ArrayList<>();
		}
		Criteria criteria = session.createCriteria(Invoice.class);
		criteria.add(Restrictions.eq("customerId",customerDB.getCustomerId()));
		return criteria.list();
	}

	public List<Invoice> getInvoiceByBillId(int billId) {
		Session session = factory.openSession();
		Bill billDB= billDao.getBills(billId);
		if(billDB==null) {
			return new ArrayList<>();
		}
		Criteria criteria= session.createCriteria(Invoice.class);
		criteria.add(Restrictions.eq("billId",billDB.getBillId()));
		return criteria.list();
	}

	
}

