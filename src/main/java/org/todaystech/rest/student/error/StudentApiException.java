package org.todaystech.rest.student.error;

import org.springframework.http.HttpStatus;

public class StudentApiException extends RuntimeException {

	private final HttpStatus status;

	public StudentApiException(String message, HttpStatus status) {
		super(message);
		this.status = status;
	}

	public HttpStatus getStatus() {
		return status;
	}
	
}
