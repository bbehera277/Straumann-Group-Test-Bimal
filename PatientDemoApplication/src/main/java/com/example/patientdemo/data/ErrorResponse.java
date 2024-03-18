package com.example.patientdemo.data;

import java.io.Serializable;

/*
 * Global Error Response to be used by the application for all exception and error scenarios
 */
public class ErrorResponse implements Serializable{

	private static final long serialVersionUID = 1888367563384794514L;
	private int status;
	private String error;
	private String message;
	/**
	 * @param status
	 * @param error
	 * @param message
	 */
	public ErrorResponse(int status, String error, String message) {
		this.status = status;
		this.error = error;
		this.message = message;
	}
	/**
	 * 
	 */
	public ErrorResponse() {
	}
	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}
	/**
	 * @return the error
	 */
	public String getError() {
		return error;
	}
	/**
	 * @param error the error to set
	 */
	public void setError(String error) {
		this.error = error;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
}