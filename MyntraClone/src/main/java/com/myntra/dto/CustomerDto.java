package com.myntra.dto;

import java.util.Arrays;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CustomerDto {

	@NotBlank
	@Email
	private String email;
	@NotNull
	private String name;
	@NotNull
	private String password;
	private Long phoneNumber;
	private AddressDto[] addressDto;

	public CustomerDto() {
	}

	

	public CustomerDto(@NotBlank @Email String email, @NotNull String name, @NotNull String password, Long phoneNumber,
			AddressDto[] addressDto) {
		super();
		this.email = email;
		this.name = name;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.addressDto = addressDto;
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

	public AddressDto[] getAddress() {
		return addressDto;
	}


	public void setAddress(AddressDto[] address) {
		this.addressDto = address;
	}



	@Override
	public String toString() {
		return "CustomerDto [email=" + email + ", name=" + name + ", password=" + password + ", phoneNumber="
				+ phoneNumber + ", addressDto=" + Arrays.toString(addressDto) + "]";
	}
	
	

}