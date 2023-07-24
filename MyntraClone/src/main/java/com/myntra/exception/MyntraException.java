package com.myntra.exception;

import org.springframework.http.HttpStatus;

public class MyntraException extends Exception {
	
	public  MyntraException(String message,HttpStatus status) {
		super(message);
	}
	

}
