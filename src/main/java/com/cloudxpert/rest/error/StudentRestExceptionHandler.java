package com.cloudxpert.rest.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {

	/**
     * Application Specific error handler
     * @param studentException
     * @return
     */
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentApiException studentException) {
    	StudentErrorResponse errorResponse = new StudentErrorResponse();
    	errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
    	errorResponse.setErrorMessage(studentException.getMessage());
    	errorResponse.setTimestamp(System.currentTimeMillis());
    	
    	return new ResponseEntity<StudentErrorResponse>(errorResponse,HttpStatus.NOT_FOUND);
    }
    
    /**
     * Generic catch-all error handler
     * @param studentException
     * @return
     */
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception studentException) {
    	StudentErrorResponse errorResponse = new StudentErrorResponse();
    	errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
    	errorResponse.setErrorMessage(studentException.getMessage());
    	errorResponse.setTimestamp(System.currentTimeMillis());
    	
    	return new ResponseEntity<StudentErrorResponse>(errorResponse,HttpStatus.BAD_REQUEST);
    }
}
