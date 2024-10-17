package com.project.todolist.services.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidTaskStatusException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public InvalidTaskStatusException(String msg) {
		super(msg);
	}
}
