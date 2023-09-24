package com.bbc.ubp.BBCUBP.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Bill {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int billId;
	private Date billDueDate;
	private double unitConsumption;
	private String billDuration;
	private boolean isPaid;

	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	@Column(name = "creation_date")
	private Date creationDate;

	@ManyToOne()
	@JoinColumn(name = "customer_Id_f")
	private Customer customer;
    private int customerId;
 
    
	public Bill() {

	}

	public Bill(int billId, Date billDueDate, double unitConsumption, Customer customer, String billDuration,
			boolean isPaid,int customerId) {
		super();
		this.billId = billId;
		this.billDueDate = billDueDate;
		this.unitConsumption = unitConsumption;
		this.customer = customer;
		this.billDuration = billDuration;
		this.isPaid = isPaid;
		this.customerId=customerId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public boolean isPaid() {
		return isPaid;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public boolean getPaid() {
		return isPaid;
	}

	public void setPaid(boolean isPaid) {
		this.isPaid = isPaid;
	}

	public int getBillId() {
		return billId;
	}

	public void setBillId(int billId) {
		this.billId = billId;
	}

	public Date getBillDueDate() {
		return billDueDate;
	}

	public void setBillDueDate(Date billDueDate) {
		this.billDueDate = billDueDate;
	}

	public double getUnitConsumption() {
		return unitConsumption;
	}

	public void setUnitConsumption(double unitConsumption) {
		this.unitConsumption = unitConsumption;
	}

	public String getBillDuration() {
		return billDuration;
	}

	public void setBillDuration(String billDuration) {
		this.billDuration = billDuration;
	}

}
