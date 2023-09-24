package com.bbc.ubp.BBCUBP.service.bill;

import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import com.bbc.ubp.BBCUBP.dao.BillDao;
import com.bbc.ubp.BBCUBP.entity.Bill;
import com.bbc.ubp.BBCUBP.entity.Customer;

@Service
public class BillServiceImpl implements BillService {

	@Autowired
	BillDao billdao;

	@Override
	public List<Bill> getBillsByCustomerId(int customerId) {
		return billdao.getBillsByCustomerId(customerId);
	}

	@Override
	public List<Bill> getUnpaidCustomerBills(int customerId) {
		List<Bill> list = billdao.getUnpaidCustomerBills(customerId);
		List<Bill> al = new ArrayList<>();
		for (Bill bill : list) {
			if (bill.getPaid() == false) {
				al.add(bill);
			}
		}
		return al;
	}

	@Override
	public List<Bill> getPaidCustomerBills(int customerId) {
		List<Bill> list = billdao.getPaidCustomerBills(customerId);
		List<Bill> al = new ArrayList<>();
		for (Bill bill : list) {
			if (bill.getPaid() == true) {
				al.add(bill);
			}
		}
		return al;
	}

	@Override
	public Bill getBills(int billId) {
		return  billdao.getBills(billId);
	}

//
//	@Override
//	public List<Bill> getBillsByDueDates(int billId) {
//		List<Bill> list = billdao.getBillDueDate(billId);
//		List<Bill> al = new ArrayList<>();
//		
//		for(Bill bill : list)
//		{
//			 LocalDate currentDate = LocalDate.now();
//		  if(bill.getBillDueDate() > currentDate)
//		  {
//		   al.add(bill);
//		}
//		}
//		return al;
//	}

}
