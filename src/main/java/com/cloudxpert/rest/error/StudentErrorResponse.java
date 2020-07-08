package com.cloudxpert.rest.error;

public class StudentErrorResponse {

	private String errorMessage;
	private int status;
	private long timestamp;
	
	public StudentErrorResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentErrorResponse(String errorMessage, int status, long timestamp) {
		super();
		this.errorMessage = errorMessage;
		this.status = status;
		this.timestamp = timestamp;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	
	
}
