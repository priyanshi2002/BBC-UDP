package com.bbc.ubp.BBCUBP.service.payment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.bbc.ubp.BBCUBP.dao.PaymentDao;
import com.bbc.ubp.BBCUBP.entity.Payment;


@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	PaymentDao paymentDao;

	@Override
	public List<Payment> getAllPaymentsByCustomerId(int customerId) {
		return paymentDao.getAllPaymentsByCustomerId(customerId);
	}

	@Override
	public List<Payment> getAllPaymentsByBillId(int billId) {
		return paymentDao.getAllPaymentsByBillId(billId);
	}

	@Override
	public Payment getAllPayments(int paymentId) {
		return paymentDao.getAllPayments(paymentId);
	}

	@Override
	public Payment addPayments(Payment payment) {
		return paymentDao.addPayments(payment);
	}

//	@Override
//	public ResponseEntity<Object> getByCustomerIdBillId(int customerId, int billId) {
//		return paymentDao.getByCustomerIdBillId(customerId,billId);
//	}

}
