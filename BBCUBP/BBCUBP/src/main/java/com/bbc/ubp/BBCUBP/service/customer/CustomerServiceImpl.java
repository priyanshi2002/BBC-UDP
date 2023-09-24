package com.bbc.ubp.BBCUBP.service.customer;

import com.bbc.ubp.BBCUBP.security.Security;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbc.ubp.BBCUBP.dao.CustomerDao;
import com.bbc.ubp.BBCUBP.entity.ContactInfo;
import com.bbc.ubp.BBCUBP.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerDao customerDao;
	
	@Override
	public Customer getDetailsByCustomerId(int customerId) {
		return customerDao.getDetailsByCustomerId(customerId);
	}

	@Override
	public String login(Customer customerDB) {
		Security mySecurity = new Security();
		return mySecurity.generateToken(customerDB);
	}


}
