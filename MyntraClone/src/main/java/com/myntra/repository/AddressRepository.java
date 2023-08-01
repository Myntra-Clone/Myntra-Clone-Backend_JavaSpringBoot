package com.myntra.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.myntra.entity.Address;
import java.util.List;


public interface AddressRepository extends MongoRepository<Address, String> {
	
	List<Address> findAllByUserIdEmail(String userIdEmail);
	Address findByName(String name);
}
