package com.jsp.hotelmanagement.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.hotelmanagement.dto.Hotel;
import com.jsp.hotelmanagement.repository.HotelRepository;
@Repository
public class Hoteldao {

	@Autowired
	private HotelRepository hotelrepo;
	
	public Hotel saveHotel(Hotel hotel) {
		return hotelrepo.save(hotel);
	}
	
	public Hotel updateHotel(Hotel hotel) {
		return hotelrepo.save(hotel);
	}
	
	public Hotel deleteHotel(int hid) {
		if (hotelrepo.findById(hid).isPresent()) {
			Hotel hotel =hotelrepo.findById(hid).get();
			hotelrepo.delete(hotel);
			return hotel;
		}
		return null;
	}
	
	public Hotel gethotelbyid(int hid) {
	
		if (hotelrepo.findById(hid).isPresent()) {
			return hotelrepo.findById(hid).get();
		}
		return null;
	}
}
