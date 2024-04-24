package com.jsp.school_management_system.exception;

public class AddressIdNotFound extends RuntimeException {

	private String message="Address Id not found in the Database";

	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		return "AddressIdNotFound [message=" + message + "]";
	}

	
}
