package com.myntra.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myntra.dto.CustomerDto;
import com.myntra.exception.MyntraException;
import com.myntra.service.CustomerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/customer")
@Api(value = "Customer Controller : REST APIs")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	@Autowired
	Environment environment;
	
	//Registering A User
	@PostMapping("/register")
	@ApiOperation(value = "Register a new customer", response = String.class)
	public ResponseEntity<String> customerRegisterApi(@Valid @RequestBody CustomerDto customerDto) throws MyntraException{
		String registeredEmail=customerService.registerNewCustomer(customerDto);
		registeredEmail=environment.getProperty("CUSTOMER.REGISTERED")+registeredEmail;
		return new ResponseEntity<>(registeredEmail, HttpStatus.CREATED);
		
	}
	
	//Login with email id & password
	@PostMapping("/login")
	@ApiOperation(value = "Login with user Credentials", response = String.class)
	public ResponseEntity<String> customerLoginApi(@Valid @RequestBody CustomerDto customerDto) throws MyntraException{
		
		return null;


}


