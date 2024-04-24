package com.jsp.school_management_system.exception;

public class SchoolIdNotFound extends RuntimeException {

	private String message="School Id not found in the Database";

	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		return "SchoolIdNotFound [message=" + message + "]";
	}

	
}
