package com.myntra.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.myntra.entity.OtpDetails;

public interface OtpDetailsRepository extends MongoRepository<OtpDetails, String> {

}
