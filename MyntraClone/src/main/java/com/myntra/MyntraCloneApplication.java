package com.myntra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(value = {"classpath:messages.properties"})
public class MyntraCloneApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyntraCloneApplication.class, args);
	}

}
