package com.bbc.ubp.BBCUBP.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bbc.ubp.BBCUBP.entity.Bill;
import com.bbc.ubp.BBCUBP.entity.Customer;
import com.bbc.ubp.BBCUBP.service.bill.BillService;

@RestController
@RequestMapping("api")
public class BillController {

	@Autowired
	BillService billService;
	

	// @Author:Priyanshi Verma: Get all bills by using customerId
	@GetMapping("billbyCustId/{customerId}")
	public ResponseEntity<Object> getBillsByCustomerId(@PathVariable int customerId) {
		List<Bill> billsDB = billService.getBillsByCustomerId(customerId);
		if (billsDB.isEmpty()) {
			return ResponseEntity.badRequest().body("Bills not found for this coustomer");
		}
		return ResponseEntity.ok(billsDB);
	}
	
	
	// @Author:Priyanshi Verma: get all paid bills using customer Id 
	@GetMapping("unpaidBills/{customerId}")
	public List<Bill> getUnpaidCustomerBills(@PathVariable int customerId) {
		return billService.getUnpaidCustomerBills(customerId);
	}

	
	// @Author:Priyanshi Verma: get all unpaid bills using customer Id 
	@GetMapping("paidBills/{customerId}")
	public List<Bill> getPaidCustomerBills(@PathVariable int customerId) {
		return billService.getPaidCustomerBills(customerId);
	}
	
	
	// @Author:Priyanshi Verma: get all paid bills using bill Id 
	@GetMapping("getAllBillsByBillId/{billId}")
	public Bill getBills(@PathVariable int billId)
	{
		return billService.getBills(billId);
	}
	

}
