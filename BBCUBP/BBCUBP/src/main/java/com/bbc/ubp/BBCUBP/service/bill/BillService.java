package com.bbc.ubp.BBCUBP.service.bill;

import java.util.List;

import com.bbc.ubp.BBCUBP.entity.Bill;
import com.bbc.ubp.BBCUBP.entity.Customer;

public interface BillService {

	List<Bill> getBillsByCustomerId(int customerId);

	List<Bill> getUnpaidCustomerBills(int customerId);

	List<Bill> getPaidCustomerBills(int customerId);

	Bill getBills(int billId);

	//List<Bill> getBillsByDueDates(String billId);


}
