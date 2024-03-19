package com.jsp.hotelmanagement.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.hotelmanagement.dao.Bookingdao;
import com.jsp.hotelmanagement.dao.Customerdao;
import com.jsp.hotelmanagement.dao.Roomdao;
import com.jsp.hotelmanagement.dto.Booking;
import com.jsp.hotelmanagement.dto.Customer;
import com.jsp.hotelmanagement.dto.Room;
import com.jsp.hotelmanagement.exception.BookingIdNotFoundException;
import com.jsp.hotelmanagement.exception.IdNotFoundException;
import com.jsp.hotelmanagement.exception.MaxNumberPeopleException;
import com.jsp.hotelmanagement.util.Responsestructure;

@Service
public class BookingService {

	@Autowired
	private Bookingdao bookingdao;
	@Autowired
	private Customerdao customerdao;
	@Autowired
	private Roomdao roomdao;
	
	Responsestructure<Booking> responsestructure = new Responsestructure<>();
	
	public ResponseEntity<Responsestructure<Booking>> saveBooking(Booking booking, int cid, int rid ) {
			Room room = roomdao.getRoombyid(rid);
			room.setAvailability("N");
			if (booking.getNo_people() <= room.getMax_people()) {
				Room room2 = roomdao.updateRoom(room);
				Customer customer = customerdao.getCustomerbyid(cid);
				booking.setCustomer(customer);
				booking.setRoom(room2);
				LocalDateTime check_in_date = LocalDateTime.now();
				booking.setCheck_in_date(check_in_date);
				responsestructure.setMessage("booking saved successfully");
				responsestructure.setStatus(HttpStatus.CREATED.value());
				responsestructure.setData(bookingdao.saveBooking(booking));
				return new ResponseEntity<Responsestructure<Booking>>(responsestructure, HttpStatus.CREATED);
			}else {
				throw new BookingIdNotFoundException();
			}
	}
	
	public ResponseEntity<Responsestructure<Booking>> updateBooking(Booking booking, int bid) {
		Booking dbBooking = bookingdao.getBookingbyid(bid);
		if (dbBooking != null) {
			if (booking.getNo_people() <= dbBooking.getRoom().getMax_people()) {
				booking.setId(bid);
				booking.setCustomer(dbBooking.getCustomer());
				booking.setRoom(dbBooking.getRoom());
				booking.setCheck_in_date(dbBooking.getCheck_in_date());
				booking.setCheck_out_date(dbBooking.getCheck_out_date());
				responsestructure.setMessage("updated successfully");
				responsestructure.setStatus(HttpStatus.OK.value());
				responsestructure.setData(bookingdao.updateBooking(booking));
				return new ResponseEntity<Responsestructure<Booking>>(responsestructure, HttpStatus.OK);
			}
			throw new MaxNumberPeopleException();
		}
		throw new IdNotFoundException();
	}
	
	public ResponseEntity<Responsestructure<Booking>> deleteBooking(int bid) {
		Booking booking = bookingdao.getBookingbyid(bid);
		if (booking != null) {
			responsestructure.setMessage("deleted successfully");
			responsestructure.setStatus(HttpStatus.OK.value());
			responsestructure.setData(bookingdao.deleteBooking(booking));
			return new ResponseEntity<Responsestructure<Booking>>(responsestructure, HttpStatus.OK);
		}
		throw new IdNotFoundException();
	}
	
	public ResponseEntity<Responsestructure<Booking>> getBookingbyid(int bid) {
		Booking booking = bookingdao.getBookingbyid(bid);
		if (booking != null) {
			responsestructure.setMessage("found successfully");
			responsestructure.setStatus(HttpStatus.FOUND.value());
			responsestructure.setData(booking);
			return new ResponseEntity<Responsestructure<Booking>>(responsestructure, HttpStatus.FOUND);
		}
		throw new IdNotFoundException();
	}
	
	public ResponseEntity<Responsestructure<List<Booking>>> getAllBookings(){
		Responsestructure<List<Booking>> responsestructure = new Responsestructure<>();
		if (bookingdao.getAllBookings() != null) {
			responsestructure.setMessage("booking saved successfully");
			responsestructure.setStatus(HttpStatus.FOUND.value());
			responsestructure.setData(bookingdao.getAllBookings());
			return new ResponseEntity<Responsestructure<List<Booking>>>(responsestructure, HttpStatus.FOUND);
		}
		throw new IdNotFoundException();
	}
	
	public ResponseEntity<Responsestructure<Booking>> closeBoking(int bid) {
		Booking booking = bookingdao.getBookingbyid(bid);
		if (booking != null) {
			LocalDateTime check_out_date = LocalDateTime.now();
			booking.setCheck_out_date(check_out_date);
			Room room = booking.getRoom();
			room.setAvailability("Y");
			booking.setRoom(room);
			responsestructure.setMessage("successfully closed the booking");
			responsestructure.setStatus(HttpStatus.OK.value());
			responsestructure.setData(bookingdao.updateBooking(booking));
			return new ResponseEntity<Responsestructure<Booking>>(responsestructure, HttpStatus.OK);
		}else {
			throw new IdNotFoundException();
		}
	}
}
