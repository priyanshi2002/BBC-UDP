package com.bbc.ubp.BBCUBP.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.bbc.ubp.BBCUBP.entity.Payment;
import com.bbc.ubp.BBCUBP.service.payment.PaymentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("api")
public class PaymentController {

	@Autowired
	PaymentService paymentService;

	// To Get all payments using customer Id
	@GetMapping("getAllPayments/{customerId}")
	public ResponseEntity<Object> getAllPaymentsByCustomerId(@PathVariable int customerId) {
		List<Payment> paymentDB = paymentService.getAllPaymentsByCustomerId(customerId);
		if (paymentDB.isEmpty()) {
			return ResponseEntity.badRequest().body("Payments regarding this customer Id is not available");
		}
		return ResponseEntity.ok(paymentDB);
	}

	
	
	// to get all Payments by billId
	@GetMapping("getPaymentsByBillId/{billId}")
	public ResponseEntity<Object> getPaymentsByBillId(@PathVariable int billId) {
		List<Payment> paymentDB = paymentService.getAllPaymentsByBillId(billId);
		if (paymentDB.isEmpty()) {
			return ResponseEntity.badRequest().body("Payments regarding this bill Id is not available");
		}
		return ResponseEntity.ok(paymentDB);
	}

	
	
	// to get all Payments by payment Id
	@GetMapping("getAllPaymentsByPaymentId/{paymentId}")
	public Payment getAllPayments(@PathVariable int paymentId) {
		return paymentService.getAllPayments(paymentId);
	}

	
	//to add all payments
	@PostMapping("addPayment")
	public Payment addPayments(@RequestBody Payment payment) {
		return paymentService.addPayments(payment);
	}

}
