package com.myntra.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "CustomerAddressS")
public class Address {

	private String name;
	private String emailId;
	private String addressLine1;
	private Long pincode;
	private String state;
	private String locality;
	private String city;
	private String addressType;

	public Address() {
	}

	public Address(String name, String emailId, String addressLine1, Long pincode, String state, String locality,
			String city, String addressType) {
		super();
		this.name = name;
		this.emailId = emailId;
		this.addressLine1 = addressLine1;
		this.pincode = pincode;
		this.state = state;
		this.locality = locality;
		this.city = city;
		this.addressType = addressType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public Long getPincode() {
		return pincode;
	}

	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

}
