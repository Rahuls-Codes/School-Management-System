package com.jsp.school_management_system.exception;

public class BranchHeadIdNotFound extends RuntimeException {

	private String message="Branch Head Id not found in the Database";

	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		return "BranchHeadIdNotFound [message=" + message + "]";
	}

	
}
