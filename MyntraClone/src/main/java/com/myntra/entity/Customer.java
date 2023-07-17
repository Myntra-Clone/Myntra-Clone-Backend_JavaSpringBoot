package com.myntra.entity;

import java.util.Arrays;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Customer")
public class Customer {

	@Id
	private String email;
	private String name;
	private String password;
	private Long phoneNumber;
	private Address[] address;

	public Customer() {
	}


	public Customer(String email, String name, String password, Long phoneNumber, Address[] address) {
		super();
		this.email = email;
		this.name = name;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}



	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public Address[] getAddress() {
		return address;
	}


	public void setAddress(Address[] address) {
		this.address = address;
	}


	@Override
	public String toString() {
		return "Customer [email=" + email + ", name=" + name + ", password=" + password + ", phoneNumber=" + phoneNumber
				+ ", address=" + Arrays.toString(address) + "]";
	}

	

}
