package com.bbc.ubp.BBCUBP.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customerId;
	private String customerName;
	private String password;
	private String customerAadharcardno;
	private String otp;

	@OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
	private List<Bill> bill;

	@Embedded
	private Address address;
	@Embedded
	private ContactInfo contactInfo;

	public Customer() {

	}

	public Customer(int customerId, String customerName, String password, String customerAadharcardno, Address address,
			ContactInfo contactInfo, String OTP) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.password = password;
		this.customerAadharcardno = customerAadharcardno;
		this.bill = new ArrayList<>();
		this.address = address;
		this.contactInfo = contactInfo;
		this.otp = OTP;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCustomerAadharcardno() {
		return customerAadharcardno;
	}

	public void setCustomerAadharcardno(String customerAadharcardno) {
		this.customerAadharcardno = customerAadharcardno;
	}

	public List<Bill> getBill() {
		return bill;
	}

	public void setBill(List<Bill> bill) {
		this.bill = bill;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public ContactInfo getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(ContactInfo contactInfo) {
		this.contactInfo = contactInfo;
	}

	public String getOTP() {
		return otp;
	}

	public void setOTP(String otp) {
		this.otp = otp;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", password=" + password
				+ ", customerAadharcardno=" + customerAadharcardno + ", bill=" + bill + ", address=" + address
				+ ", contactInfo=" + contactInfo + "]";
	}

}
