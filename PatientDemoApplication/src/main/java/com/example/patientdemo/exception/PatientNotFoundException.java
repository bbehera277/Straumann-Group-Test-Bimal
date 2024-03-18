package com.example.patientdemo.exception;

public class PatientNotFoundException extends RuntimeException {
	
	public PatientNotFoundException(String exceptionMessage) {
		super(exceptionMessage);
	}
}
