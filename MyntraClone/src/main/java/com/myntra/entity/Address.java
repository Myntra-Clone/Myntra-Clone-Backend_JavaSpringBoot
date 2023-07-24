package com.myntra.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "CustomerAddressS")
public class Address {

	private String userIdEmail;
	private String name;
	private String addressEmail;
	private String addressLine1;
	private Long pincode;
	private String state;
	private String locality;
	private String city;
	private String addressType;

}