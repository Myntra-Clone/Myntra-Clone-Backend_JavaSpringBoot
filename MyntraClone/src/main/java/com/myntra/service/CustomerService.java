package com.myntra.service;

import com.myntra.dto.CustomerDto;
import com.myntra.exception.MyntraException;

public interface CustomerService {

	String registerNewCustomer(CustomerDto customerDto) throws MyntraException;
	
	

}
