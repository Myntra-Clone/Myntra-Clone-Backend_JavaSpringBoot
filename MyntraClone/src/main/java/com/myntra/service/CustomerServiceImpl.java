package com.myntra.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myntra.dto.CustomerDto;
import com.myntra.entity.Customer;
import com.myntra.exception.MyntraException;
import com.myntra.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	ModelMapper modelMapper;

	@Override
	public String registerNewCustomer(CustomerDto customerDto) throws MyntraException {

		boolean registeredEmail = customerRepository.findById(customerDto.getEmail().toLowerCase()).isEmpty();

		if (registeredEmail) {
			Customer customer = modelMapper.map(customerDto, Customer.class);
			customerRepository.save(customer);
		} else {
			throw new MyntraException("EMAIL.ALREADY.EXISTS");
		}

		return customerDto.getEmail();

	}

}
