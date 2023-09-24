package com.bbc.ubp.BBCUBP.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bbc.ubp.BBCUBP.entity.Bill;
import com.bbc.ubp.BBCUBP.entity.Customer;
import com.bbc.ubp.BBCUBP.entity.Invoice;
import com.bbc.ubp.BBCUBP.service.invoice.InvoiceService;

@RestController
@RequestMapping("api")
public class InvoiceController {
	@Autowired
	InvoiceService invoiceService;
 
	// @Author:Priyanshi Verma : get invoices by invoiceId 
	@GetMapping("invoice/{invoiceId}")
	public Invoice getInvoice(@PathVariable int invoiceId) {
		return invoiceService.getInvoice(invoiceId);
	}

	
	// @Author:Priyanshi Verma: get invoice by using customer Id
	@GetMapping("getInvoicebyCustomerId/{customerId}")
	public ResponseEntity<Object> getInvoiceByCusId(@PathVariable int customerId) {
		List<Invoice> invoiceDB = invoiceService.getInvoiceByCusId(customerId);
		if (invoiceDB.isEmpty()) {
			return ResponseEntity.badRequest().body("Invoice not found for this customerId");
		}
		return ResponseEntity.ok(invoiceDB);
	}

	
	// @Author:Priyanshi Verma: get invoice by using bill Id
	@GetMapping("getInvoicebyBillId/{billId}")
	public ResponseEntity<Object> getInvoiceByBillId(@PathVariable int billId) {
		List<Invoice> invoiceDB = invoiceService.getInvoiceByBillId(billId);
		if (invoiceDB.isEmpty()) {
			return ResponseEntity.badRequest().body("Invoice not found for this billId");
		}
		return ResponseEntity.ok(invoiceDB);
	}

}
