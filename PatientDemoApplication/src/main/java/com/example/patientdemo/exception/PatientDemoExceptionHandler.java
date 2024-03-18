package com.example.patientdemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.patientdemo.data.ErrorResponse;

@RestControllerAdvice
public class PatientDemoExceptionHandler {

	@ExceptionHandler(PatientNotFoundException.class)
	public ResponseEntity<Object> handleNotFoundException(PatientNotFoundException ex) {
		return new ResponseEntity<>(new ErrorResponse(HttpStatus.NOT_FOUND.value(),
				HttpStatus.NOT_FOUND.getReasonPhrase(), ex.getMessage()), HttpStatus.NOT_FOUND);
	}
	
}
