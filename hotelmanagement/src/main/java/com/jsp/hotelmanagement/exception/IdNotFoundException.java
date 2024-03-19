package com.jsp.hotelmanagement.exception;

public class IdNotFoundException extends RuntimeException {

	private String message = "id not found";

	@Override
	public String getMessage() {
		return message;
	}

	public IdNotFoundException() {
		super();
	}

	public IdNotFoundException(String message) {
		super();
		this.message = message;
	}
	
	
	
}
