package com.myntra.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CustomerDto {

	@NotBlank
	@Email
	private String email;
	@NotNull
	private String name;
	private Long phoneNumber;
	private AddressDto addressDto;

	public CustomerDto() {
	}

	public CustomerDto(@Email String email, @NotNull String name, Long phoneNumber, AddressDto addressDto) {
		super();
		this.email = email;
		this.name = name;
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

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public AddressDto getAddressDto() {
		return addressDto;
	}

	public void setAddressDto(AddressDto addressDto) {
		this.addressDto = addressDto;
	}

}