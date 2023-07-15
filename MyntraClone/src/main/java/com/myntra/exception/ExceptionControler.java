package com.myntra.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControler {

	@Autowired
	Environment environment;

	@ExceptionHandler
	public ResponseEntity<String> myntraGeneralException(MyntraException ex) {
		return new ResponseEntity<>(environment.getProperty(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);

	}
}
