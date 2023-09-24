package com.bbc.ubp.BBCUBP.service.customer;

import java.util.List;

import com.bbc.ubp.BBCUBP.entity.ContactInfo;
import com.bbc.ubp.BBCUBP.entity.Customer;

public interface CustomerService {

	Customer getDetailsByCustomerId(int customerId);

	String login(Customer customerDB);

}
