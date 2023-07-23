package com.myntra.controller;

import java.security.Principal;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.myntra.dto.CustomerAuthDto;
import com.myntra.dto.CustomerDto;
import com.myntra.exception.MyntraException;
import com.myntra.security.JwtHelper;
import com.myntra.service.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/customer")
@Api(value = "Customer Controller : REST APIs")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@Autowired
	Environment environment;

	@Autowired
	private JwtHelper jwtHelper;

	@Autowired
	AuthenticationManager authenticationManager;

	/**
	 * API to register a new user
	 * 
	 * @param CustomerDto
	 * @returns ResponseEntity<String>
	 */
	@PostMapping("/register")
	@ApiOperation(value = "Register a new customer", response = String.class)
	public ResponseEntity<String> customerRegisterApi(@Valid @RequestBody CustomerDto customerDto)
			throws MyntraException {
		String registeredEmail = customerService.registerNewCustomer(customerDto);
		registeredEmail = environment.getProperty("CUSTOMER.REGISTERED") + registeredEmail;
		return new ResponseEntity<>(registeredEmail, HttpStatus.CREATED);

	}

	// Login with email id & password
	@PostMapping("/login")
	@ApiOperation(value = "Login with user Credentials", response = String.class)
	public ResponseEntity<String> customerLoginApi(@Valid @RequestBody CustomerAuthDto customerAuthDto)
			throws BadCredentialsException {
		if (authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(customerAuthDto.getEmail(), customerAuthDto.getPassword()))
				.isAuthenticated()) {
			String jwtToken = jwtHelper.generateToken(customerAuthDto.getEmail());
			return new ResponseEntity<>(jwtToken, HttpStatus.OK);
		} else {
			throw new BadCredentialsException("INVALID.CREDENTIAL");
		}

	}

	@GetMapping("/welcome")
	public String welcome(Principal principal) {
		String customerName = customerService.welcomeService(principal.getName());
		return "Welcome " + customerName;
	}
}
