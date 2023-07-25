package com.myntra.controller;

import java.security.Principal;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

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
import org.springframework.web.client.RestTemplate;
import com.myntra.dto.CustomerAuthDto;
import com.myntra.dto.CustomerDto;
import com.myntra.dto.JwtTokens;
import com.myntra.dto.StringInputDto;
import com.myntra.exception.MyntraException;
import com.myntra.security.JwtHelper;
import com.myntra.service.CustomerService;
import com.myntra.service.RefreshTokenService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/auth")
@Api(value = "Customer Controller : REST APIs") //    http://localhost:8500/myntra/swagger-ui/index.html#/
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@Autowired
	RefreshTokenService refreshTokenService;

	@Autowired
	Environment environment;

	@Autowired
	private JwtHelper jwtHelper;

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	RestTemplate restTemplate; 

	@PostMapping("/is-present")
	@ApiOperation(value = "To check if email id is present in database", response = Boolean.class)
	public ResponseEntity<Boolean> customerIsPresent(@RequestBody @NotBlank StringInputDto stringInputDto) {
		return new ResponseEntity<>(customerService.isPresent(stringInputDto), HttpStatus.OK);
	}

	@PostMapping("/register")
	@ApiOperation(value = "Register a new customer", response = JwtTokens.class)
	public ResponseEntity<JwtTokens> customerRegisterApi(@Valid @RequestBody CustomerDto customerDto)
			throws MyntraException {
		customerService.registerNewCustomer(customerDto);
		ResponseEntity<JwtTokens> jwtTokens = restTemplate.postForEntity(
				environment.getProperty("HOST.URL") + "/auth/login",
				new CustomerAuthDto(customerDto.getEmail(), customerDto.getPassword()), JwtTokens.class);
		return jwtTokens;

	}

	// Login with email id & password
	@PostMapping("/login")
	@ApiOperation(value = "Login with user Credentials", response = String.class)
	public ResponseEntity<JwtTokens> customerLoginApi(@Valid @RequestBody CustomerAuthDto customerAuthDto)
			throws BadCredentialsException {
		if (authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(customerAuthDto.getEmail(), customerAuthDto.getPassword()))
				.isAuthenticated()) {
			String jwtToken = jwtHelper.generateToken(customerAuthDto.getEmail());
			String refreshToken = refreshTokenService.getRefreshToken(customerAuthDto.getEmail());
			return new ResponseEntity<>(new JwtTokens(jwtToken, refreshToken), HttpStatus.OK);
		} else {
			throw new BadCredentialsException("INVALID.CREDENTIAL");
		}
	}

	// Get new jwt with refresh token
	@PostMapping("/refresh-token")
	@ApiOperation(value = "Get new jwt with refresh token", response = String.class)
	public ResponseEntity<String> customerLoginApi(@RequestBody StringInputDto refreshToken) throws MyntraException {
		String email = refreshTokenService.tokenValidation(refreshToken);
		return new ResponseEntity<>(jwtHelper.generateToken(email), HttpStatus.OK);
	}

	@GetMapping("/welcome")
	public String welcome(Principal principal) {
		String customerName = customerService.welcomeService(principal.getName());
		return "Welcome " + customerName;
	}
}
