package com.bbc.ubp.BBCUBP.service.invoice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbc.ubp.BBCUBP.dao.InvoiceDao;
import com.bbc.ubp.BBCUBP.entity.Customer;
import com.bbc.ubp.BBCUBP.entity.Invoice;

@Service
public class InvoiceServiceImpl implements InvoiceService {

	@Autowired
	InvoiceDao invoicedao;
	
	@Override
	public Invoice getInvoice(int invoiceId) {
		return invoicedao.getAllInvoice(invoiceId);
	}

	@Override
	public List<Invoice> getInvoiceByCusId(int customerId) {
		return invoicedao.getInvoiceByCusId(customerId);
	}

	@Override
	public List<Invoice> getInvoiceByBillId(int billId) {
		return invoicedao.getInvoiceByBillId(billId);
	}

}
