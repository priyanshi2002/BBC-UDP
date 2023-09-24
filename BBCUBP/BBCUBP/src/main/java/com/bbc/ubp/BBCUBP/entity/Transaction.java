package com.bbc.ubp.BBCUBP.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int transactionId;
	private String paymentMode;

	private String paymentStatus;
	private double amount;

	@ManyToOne()
	@JoinColumn(name = "customer_id_f")
	private Customer customer;

	@OneToOne()
	@JoinColumn(name = "bill_id_f")
	private Bill bill;

	@OneToMany
	private List<Payment> payments;

	public Transaction() {

	}

	public Transaction(int transactionId, Customer customer, String paymentMode, Bill bill, String paymentStatus,
			double amount) {
		super();
		this.transactionId = transactionId;
		this.customer = customer;
		this.paymentMode = paymentMode;
		this.bill = bill;
		this.paymentStatus = paymentStatus;
		this.payments = new ArrayList<>();
		this.amount = amount;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
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

	public List<Payment> getPayment() {
		return payments;
	}

	public void setPayment(List<Payment> payments) {
		this.payments = payments;
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", customer=" + customer + ", paymentMode=" + paymentMode
				+ ", bill=" + bill + ", paymentStatus=" + paymentStatus + ", payment=" + payments + ", amount=" + amount
				+ "]";
	}
}
