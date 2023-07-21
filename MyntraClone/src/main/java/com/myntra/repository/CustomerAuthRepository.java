package com.myntra.repository;

import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.myntra.entity.CustomerAuth;

public interface CustomerAuthRepository extends MongoRepository<CustomerAuth, String> {
	Optional<CustomerAuth> findByEmail(String email);
}
