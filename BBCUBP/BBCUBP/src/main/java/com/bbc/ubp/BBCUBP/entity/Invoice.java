package com.bbc.ubp.BBCUBP.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.util.Date;

@Entity
public class Invoice {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int invoiceId;
	private double amount;
	private Date billDueDate;
	private double earlyPayment;
	private double onlinePayment;
	private double totalAmount;
	private String paymentStatus;

	@ManyToOne()
	@JoinColumn(name = "customer_id_f")
	private Customer customer;

	@OneToOne()
	@JoinColumn(name = "bill_id_f")
	private Bill bill;
    private int customerId;
    private int billId;
    
	public Invoice() {

	}

	public Invoice(int invoiceId, Customer customer, String paymentStatus, Bill bill, double amount,
			Date billDueDate, double earlyPayment, double onlinePayment, double totalAmount,int customerId,int billId) {
		super();
		this.invoiceId = invoiceId;
		this.customer = customer;
		this.paymentStatus = paymentStatus;
		this.bill = bill;
		this.amount = amount;
		this.billDueDate = billDueDate;
		this.earlyPayment = earlyPayment;
		this.onlinePayment = onlinePayment;
		this.totalAmount = totalAmount;
		this.customerId=customerId;
		this.billId=billId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getBillId() {
		return billId;
	}

	public void setBillId(int billId) {
		this.billId = billId;
	}

	public int getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getBillDueDate() {
		return billDueDate;
	}

	public void setBillDueDate(Date billDueDate) {
		this.billDueDate = billDueDate;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public double getEarlyPayment() {
		return earlyPayment;
	}

	public void setEarlyPayment(double earlyPayment) {
		this.earlyPayment = earlyPayment;
	}

	public double getOnlinePayment() {
		return onlinePayment;
	}

	public void setOnlinePayment(double onlinePayment) {
		this.onlinePayment = onlinePayment;
	}

	@Override
	public String toString() {
		return "Invoice [invoiceId=" + invoiceId + ", customer=" + customer + ", paymentStatus=" + paymentStatus
				+ ", bill=" + bill + ", amount=" + amount + ", billDueDate=" + billDueDate + ", earlyPayment="
				+ earlyPayment + ", onlinePayment=" + onlinePayment + ", totalAmount=" + totalAmount + "]";
	}
}
