package com.jsp.hotelmanagement.exception;

public class BookingIdNotFoundException extends RuntimeException {

	private String message = " booking id not found";

	@Override
	public String getMessage() {
		return message;
	}

	public BookingIdNotFoundException() {
		super();
	}

	public BookingIdNotFoundException(String message) {
		super();
		this.message = message;
	}
}
