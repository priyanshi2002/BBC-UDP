package com.bbc.ubp.BBCUBP.service.invoice;

import java.util.List;

import com.bbc.ubp.BBCUBP.entity.Customer;
import com.bbc.ubp.BBCUBP.entity.Invoice;

public interface InvoiceService {

	Invoice getInvoice(int invoiceId);

	List<Invoice> getInvoiceByCusId(int customerId);

	List<Invoice> getInvoiceByBillId(int billId);
}
