package com.myntra.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.myntra.entity.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String> {

	Customer findByEmail(String email);
}
