package com.myntra.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Authentication")
public class CustomerAuth {

	@Id
	private String email;
	private String password;

	public CustomerAuth() {
	}

	public CustomerAuth(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "CustomerAuth [email=" + email + ", password=" + password + "]";
	}

}