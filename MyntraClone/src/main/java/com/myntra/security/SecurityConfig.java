package com.myntra.security;

import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityConfig {

	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(requests -> requests
                        .antMatchers("/customer").permitAll());
//                        .anyRequest()
//                        .authenticated());
       return http.build();
	}
	

}
