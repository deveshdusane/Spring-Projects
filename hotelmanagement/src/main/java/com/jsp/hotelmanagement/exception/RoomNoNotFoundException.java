package com.jsp.hotelmanagement.exception;

public class RoomNoNotFoundException extends RuntimeException{

	private String message = "room no not found";

	@Override
	public String getMessage() {
		return message;
	}

	public RoomNoNotFoundException() {
		super();
	}

	public RoomNoNotFoundException(String message) {
		super();
		this.message = message;
	}
}
