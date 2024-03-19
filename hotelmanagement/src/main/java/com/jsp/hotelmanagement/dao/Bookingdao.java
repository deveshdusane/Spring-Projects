package com.jsp.hotelmanagement.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.hotelmanagement.dto.Booking;
import com.jsp.hotelmanagement.repository.BookingRepository;

@Repository
public class Bookingdao {

	@Autowired
	private BookingRepository bookingRepo;
	
	public Booking saveBooking(Booking booking) {
		return bookingRepo.save(booking);
	}
	
	public Booking updateBooking(Booking booking) {
		return bookingRepo.save(booking);
	}
	
	public Booking deleteBooking(Booking booking) {
		bookingRepo.delete(booking);
		return booking;
	}
	
	public Booking getBookingbyid(int bid) {
		if (bookingRepo.findById(bid).isPresent()) {
			return bookingRepo.findById(bid).get();
		}
		return null;
	}
	
	public List<Booking> getAllBookings(){
		return bookingRepo.findAll();
	}
	
	public Booking getBookingbycheckin(String check_in_date) {
		if (bookingRepo.getBookingbycheckin(check_in_date) != null) {
			return bookingRepo.getBookingbycheckin(check_in_date);
		}
		return null;
	}
	
	public Booking getBookingbycheckout(String check_out_date) {
		if (bookingRepo.getBookingbycheckout(check_out_date) != null) {
			return bookingRepo.getBookingbycheckout(check_out_date);
		}
		return null;
	}
}
