package com.myntra.repository;

import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.myntra.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
	Optional<Customer> findByEmail(String email);
	@Modifying
	@Transactional
	@Query(value = "delete from customer c where c.email= ?1",nativeQuery = true )
	void deleteByEmail(String email);
}
