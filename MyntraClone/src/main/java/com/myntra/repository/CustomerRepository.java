package com.myntra.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.myntra.entity.Customer;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {

    Optional<String> findByEmail(String email);
}
