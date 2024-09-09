package com.registerUsers.registerUsers.services.exceptions;

public class EmailAlreadyExistsException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public EmailAlreadyExistsException(String email) {
		super("Email already exists: " + email);
	}
}
