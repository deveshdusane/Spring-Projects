package com.jsp.hotelmanagement.controller;

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

import com.jsp.hotelmanagement.dto.Hotel;
import com.jsp.hotelmanagement.service.HotelService;
import com.jsp.hotelmanagement.util.Responsestructure;


@RestController
@RequestMapping("/hotel")//this API is responsible for all request we don't need to create single-single API.
public class HotelController {

	@Autowired
	private HotelService hotelService;
	
	@PostMapping
	public ResponseEntity<Responsestructure<Hotel>> saveHotel(@RequestBody Hotel hotel) {
		return hotelService.saveHotel(hotel);
	}
	
	@PutMapping
	public ResponseEntity<Responsestructure<Hotel>> updateHotel(@RequestBody Hotel hotel, @RequestParam int hid) {
		return hotelService.updateHotel(hid, hotel);
	}
	
	@DeleteMapping
	public ResponseEntity<Responsestructure<Hotel>> deleteHotel(@RequestParam int hid) {
		return hotelService.deleteHotel(hid);
	}
	
	@GetMapping
	public ResponseEntity<Responsestructure<Hotel>> getHotelbyid(@RequestParam int hid) {
		return hotelService.getHotelbyid(hid);
	}
}
