package com.jsp.school_management_system.exception;

public class TeacherIdNotFound extends RuntimeException {

	private String message="Teacher Id not found in the Database";

	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		return "TeacherIdNotFound [message=" + message + "]";
	}

	
}
