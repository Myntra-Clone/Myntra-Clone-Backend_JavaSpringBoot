package com.myntra.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.myntra.entity.CustomerAuth;
import com.myntra.repository.CustomerAuthRepository;
import com.myntra.security.UserDetailsInfo;

public class AuthDetailsService implements UserDetailsService {

	@Autowired
	CustomerAuthRepository customerAuthRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<CustomerAuth> user = customerAuthRepository.findByEmail(email);
		return user.map(UserDetailsInfo::new).orElseThrow(() -> new UsernameNotFoundException("CUSTOMER.NOT.FOUND"));
	}

}
