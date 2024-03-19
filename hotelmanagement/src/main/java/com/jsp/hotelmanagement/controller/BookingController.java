package com.jsp.hotelmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.hotelmanagement.dto.Booking;
import com.jsp.hotelmanagement.service.BookingService;
import com.jsp.hotelmanagement.util.Responsestructure;

@RestController
@RequestMapping("/booking")
public class BookingController {

	@Autowired
	private BookingService bookingService;
	
	@PostMapping
	public ResponseEntity<Responsestructure<Booking>> saveBooking(@RequestBody Booking booking, @RequestParam int cid, @RequestParam int rid) {
		return bookingService.saveBooking(booking, cid, rid);
	}
	
	@PutMapping
	public ResponseEntity<Responsestructure<Booking>> updateBooking(@RequestBody Booking booking,@RequestParam int bid) {
		return bookingService.updateBooking(booking, bid);
	}
	
	@DeleteMapping
	public ResponseEntity<Responsestructure<Booking>> deleteBooking(@RequestParam int bid) {
		return bookingService.deleteBooking(bid);
	}
	
	@GetMapping("/bookingbyid")
	public ResponseEntity<Responsestructure<Booking>> getBookingbyid(@RequestParam int bid) {
		return bookingService.getBookingbyid(bid);
	}
	
	@GetMapping("/getallbooking")
	public ResponseEntity<Responsestructure<List<Booking>>> getAllBookings() {
		return bookingService.getAllBookings();
	}
	
	@PutMapping("/closebooking")
	public ResponseEntity<Responsestructure<Booking>> closeBooking(@RequestParam int bid) {
		return bookingService.closeBoking(bid);
	}
}
