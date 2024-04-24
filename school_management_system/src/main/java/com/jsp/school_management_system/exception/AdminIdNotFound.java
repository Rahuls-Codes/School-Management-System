package com.jsp.school_management_system.exception;

public class AdminIdNotFound extends RuntimeException {

	private String message="Admin Id not found in the Database";

	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		return "AdminIdNotFound [message=" + message + "]";
	}
	
}
