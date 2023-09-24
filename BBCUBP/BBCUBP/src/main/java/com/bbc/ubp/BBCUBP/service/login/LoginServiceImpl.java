package com.bbc.ubp.BBCUBP.service.login;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbc.ubp.BBCUBP.dao.InvoiceDao;
import com.bbc.ubp.BBCUBP.dao.LoginDao;
import com.bbc.ubp.BBCUBP.entity.Customer;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginDao logindao;
	
	//@Override
	//public List<Customer> login(int customerId, String password, String otp) {
		//if(customerId.equals(getCustomerId()) && password.equals(getPssword()) && otp.equals(getOtp()))
		//{
			
		//}
//		return logindao.login(customerId,password,otp);
	//}

}
/*if (ccy.getCcy().isEmpty() || ccy.getAmount() == 0 || ccy.getCcy() == " "
|| Double.isNaN(ccy.getAmount())) {
return "Please enter proper currency pair. ";
} el
return fxdao.addingCcy(ccy);
}*/