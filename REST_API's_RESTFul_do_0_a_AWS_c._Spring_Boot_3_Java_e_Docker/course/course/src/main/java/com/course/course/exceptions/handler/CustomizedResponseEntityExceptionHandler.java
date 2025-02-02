package com.course.course.exceptions.handler;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.course.course.exceptions.ExceptionResponse;
import com.course.course.exceptions.InvalidJwtAuthenticationException;
import com.course.course.exceptions.RequiredObjectsNullException;
import com.course.course.exceptions.ResourceNotFoundException;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception ex, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(
					Instant.now(),
					ex.getMessage(),
					request.getDescription(false)
				);
		
		return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public final ResponseEntity<ExceptionResponse> handleNotFoundExceptions(ResourceNotFoundException ex, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(
				Instant.now(),
				ex.getMessage(),
				request.getDescription(false)
				);
		
		return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(RequiredObjectsNullException.class)
	public final ResponseEntity<ExceptionResponse> handleBadRequestExceptions(RequiredObjectsNullException ex, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(
				Instant.now(),
				ex.getMessage(),
				request.getDescription(false)
				);
		
		return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(InvalidJwtAuthenticationException.class)
	public final ResponseEntity<ExceptionResponse> handleInvalidJwtAuthenticationExceptions(InvalidJwtAuthenticationException ex, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(
				Instant.now(),
				ex.getMessage(),
				request.getDescription(false)
				);
		
		return new ResponseEntity<>(exceptionResponse, HttpStatus.FORBIDDEN);
	}
}
