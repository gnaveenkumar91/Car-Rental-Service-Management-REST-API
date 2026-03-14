package com.vcube.crsapp01.exception;


import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	// 1 Resource Not Found
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleNotFound(ResourceNotFoundException ex) {

		ErrorResponse error = new ErrorResponse(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), "NOT_FOUND",
				ex.getMessage());

		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	// 1 Resource Not Found
		@ExceptionHandler(CustomerNotFoundException.class)
		public ResponseEntity<ErrorResponse> handleNotFound(CustomerNotFoundException ex) {

			ErrorResponse error = new ErrorResponse(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), "NOT_FOUND",
					ex.getMessage());

			return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
		}
}