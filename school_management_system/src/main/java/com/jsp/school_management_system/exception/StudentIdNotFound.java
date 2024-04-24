package com.jsp.school_management_system.exception;

public class StudentIdNotFound extends RuntimeException {

	private String message="Student Id not found in the Database";

	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		return "StudentIdNotFound [message=" + message + "]";
	}

	
}
