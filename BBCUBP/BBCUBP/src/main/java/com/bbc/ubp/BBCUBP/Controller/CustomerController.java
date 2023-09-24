package com.bbc.ubp.BBCUBP.Controller;

import java.util.Map;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bbc.ubp.BBCUBP.entity.ContactInfo;
import com.bbc.ubp.BBCUBP.entity.Customer;
import com.bbc.ubp.BBCUBP.exception.CustomerNotFoundException;
import com.bbc.ubp.BBCUBP.service.customer.CustomerService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	// @Author:Priyanshi Verma : Get all details of customer By customerId
	@GetMapping("customer/{customerId}")
	public Customer getDetailsByCustomerId(@PathVariable int customerId) {
		return customerService.getDetailsByCustomerId(customerId);
	}
	
	

	// @Author:Priyanshi Verma: to login for customer 
	@PostMapping("/auth/login")
	public ResponseEntity<Object> login(@RequestBody Customer loginData) {
		try {
			int CustomerId = loginData.getCustomerId();
			String password = loginData.getPassword().trim();

			Customer customerDB = customerService.getDetailsByCustomerId(CustomerId);

			if (CustomerId == customerDB.getCustomerId() && password.equals(customerDB.getPassword())) {
				String token = customerService.login(customerDB);
				Map<String, String> mp = new HashMap<>();
				mp.put("token", token);

				return ResponseEntity.ok(mp);
			} else {
				Map<String, String> errorResponse = new HashMap<>();
				errorResponse.put("errorMsg", "Invalid Credential");
				return ResponseEntity.ok(errorResponse);
			}

		} catch (CustomerNotFoundException e) {
			Map<String, String> errorResponse = new HashMap<>();
			errorResponse.put("errorMsg", "Customer Not Found");
			return ResponseEntity.ok(errorResponse);
		}
	}

}
