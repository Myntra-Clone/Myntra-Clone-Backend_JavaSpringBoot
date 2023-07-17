package com.myntra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myntra.dto.CustomerDto;
import com.myntra.entity.Address;
import com.myntra.exception.MyntraException;
import com.myntra.service.CustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	@Autowired
	Environment environment;
	
	//Registering A User
	@PostMapping("/register")
	public ResponseEntity<String> customerRegisterApi(@Valid @RequestBody CustomerDto customerDto) throws MyntraException{
		String registeredEmail=customerService.registerNewCustomer(customerDto);
		registeredEmail=environment.getProperty("CUSTOMER.REGISTERED")+registeredEmail;
		return new ResponseEntity<>(registeredEmail, HttpStatus.CREATED);
		
	}
	
	

}


