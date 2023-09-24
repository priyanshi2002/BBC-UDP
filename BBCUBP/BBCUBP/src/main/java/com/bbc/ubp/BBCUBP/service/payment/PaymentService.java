package com.bbc.ubp.BBCUBP.service.payment;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.bbc.ubp.BBCUBP.entity.Payment;

public interface PaymentService {


	List<Payment> getAllPaymentsByCustomerId(int customerId);

	List<Payment> getAllPaymentsByBillId(int billId);

	Payment getAllPayments(int paymentId);

	Payment addPayments(Payment payment);

//	List<Payment> getByCustomerIdBillId(int customerId, int billId);



}
