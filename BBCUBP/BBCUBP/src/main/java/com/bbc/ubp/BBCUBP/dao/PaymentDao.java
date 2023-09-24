package com.bbc.ubp.BBCUBP.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.bbc.ubp.BBCUBP.entity.Bill;
import com.bbc.ubp.BBCUBP.entity.Customer;
import com.bbc.ubp.BBCUBP.entity.Payment;

@Repository
public class PaymentDao {

	@Autowired
	SessionFactory factory;

	@Autowired
	CustomerDao customerDao;

	@Autowired
	BillDao billdao;

	public List<Payment> getAllPaymentsByCustomerId(int customerId) {
		Session session = factory.openSession();
		Customer customerDB = customerDao.getDetailsByCustomerId(customerId);
		if (customerDB == null) {
			return new ArrayList<>();
		}
		Criteria criteria = session.createCriteria(Payment.class);
		criteria.add(Restrictions.eq("customerId", customerId));
		return criteria.list();
	}
	
	

	public List<Payment> getAllPaymentsByBillId(int billId) {
		Session session = factory.openSession();
		Bill billDb = billdao.getBills(billId);
		if (billDb == null) {
			return new ArrayList<>();
		}
		Criteria criteria = session.createCriteria(Payment.class);
		criteria.add(Restrictions.eq("billId", billId));
		return criteria.list();
	}
	
	

	public Payment getAllPayments(int paymentId) {
		Session session = factory.openSession();
		return session.get(Payment.class, paymentId);
	}

	
	public Payment addPayments(Payment payment) {
		Payment paymentDB = null;
		try (Session session = factory.openSession()) {
			session.save(payment);
			session.beginTransaction().commit();
			paymentDB = session.get(Payment.class, payment.getPaymentId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return paymentDB;
	}


}
