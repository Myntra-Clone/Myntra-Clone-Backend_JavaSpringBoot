package com.myntra.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.myntra.entity.Address;

public interface AddressRepository extends MongoRepository<Address, String> {

}
