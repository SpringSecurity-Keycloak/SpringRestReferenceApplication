package com.cloudxpert.rest.error;

import org.springframework.http.HttpStatus;

public class StudentApiException extends RuntimeException {

	private HttpStatus status = null;
	public StudentApiException() {
		super();
	}

	public StudentApiException(String message, HttpStatus status) {
		super(message);
		this.status = status;
	}

	public HttpStatus getStatus() {
		return status;
	}
	
}
