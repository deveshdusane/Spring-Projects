package com.jsp.hotelmanagement.exception;

public class RoomTypeNotFoundException extends RuntimeException {

	private String message = "type not found";

	@Override
	public String getMessage() {
		return message;
	}

	public RoomTypeNotFoundException() {
		super();
	}

	public RoomTypeNotFoundException(String message) {
		super();
		this.message = message;
	}
	
	
	
	
	
	
	
	
}
