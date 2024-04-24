package com.jsp.school_management_system.exception;

public class BranchIdNotFound extends RuntimeException {

	private String message="Branch Id not found in the Database";

	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		return "BranchIdNotFound [message=" + message + "]";
	}

	
}
