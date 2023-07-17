package com.myntra.entity;

public class Address {

	private String name;
	private String emailId;
	
	public Address(){}
	
	
	public Address(String name, String emailId) {
		super();
		this.name = name;
		this.emailId = emailId;
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


	@Override
	public String toString() {
		return "Address [name=" + name + ", emailId=" + emailId + "]";
	}
	
	/*
	private String houseNumber;
	private Long pincode;
	private String state;
	private String locality;
	private String city;
	
	public Address() {}

	public Address(String name, String emailId, String houseNumber, Long pincode, String state, String locality,
			String city) {
		super();
		this.name = name;
		this.emailId = emailId;
		this.houseNumber = houseNumber;
		this.pincode = pincode;
		this.state = state;
		this.locality = locality;
		this.city = city;
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

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
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
	
	*/
	
	
	
}
