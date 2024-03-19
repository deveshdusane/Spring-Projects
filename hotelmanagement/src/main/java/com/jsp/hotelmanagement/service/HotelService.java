package com.jsp.hotelmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.hotelmanagement.dao.Hoteldao;
import com.jsp.hotelmanagement.dto.Hotel;
import com.jsp.hotelmanagement.exception.IdNotFoundException;
import com.jsp.hotelmanagement.util.Responsestructure;

@Service
public class HotelService {

	@Autowired
	private Hoteldao hoteldao;
	
	public ResponseEntity<Responsestructure<Hotel>> saveHotel(Hotel hotel) {
		Responsestructure<Hotel> responsestructure = new Responsestructure<>();
		responsestructure.setMessage("saved successfully");
		responsestructure.setStatus(HttpStatus.CREATED.value());
		responsestructure.setData(hoteldao.saveHotel(hotel));
		return new ResponseEntity<Responsestructure<Hotel>>(responsestructure,HttpStatus.CREATED);		
	}
	
	public ResponseEntity<Responsestructure<Hotel>> updateHotel(int hid, Hotel hotel) {
		Responsestructure<Hotel> responsestructure = new Responsestructure<>();
		Hotel dbHotel =  hoteldao.gethotelbyid(hid);
		if (dbHotel != null) {
			hotel.setHotel_id(hid);
			responsestructure.setMessage("saved successfully");
			responsestructure.setStatus(HttpStatus.OK.value());
			responsestructure.setData(hoteldao.updateHotel(hotel));
			return new ResponseEntity<Responsestructure<Hotel>>(responsestructure,HttpStatus.OK);
		}else {
			throw new IdNotFoundException();
		}
	}
	
	public ResponseEntity<Responsestructure<Hotel>> deleteHotel(int hid) {
		
		Responsestructure<Hotel> responsestructure = new Responsestructure<>();
		Hotel hotel =  hoteldao.gethotelbyid(hid);
		
		if (hotel != null) {
			responsestructure.setMessage("deleted successfully");
			responsestructure.setStatus(HttpStatus.OK.value());
			responsestructure.setData(hoteldao.deleteHotel(hid));
			return new ResponseEntity<Responsestructure<Hotel>>(responsestructure,HttpStatus.OK);
		}else {
			throw new IdNotFoundException();
		}
	}
	
	public ResponseEntity<Responsestructure<Hotel>> getHotelbyid(int hid) {
		Responsestructure<Hotel> responsestructure = new Responsestructure<>();
		 Hotel hotel = hoteldao.gethotelbyid(hid);
		 if (hotel != null) {
			    responsestructure.setMessage("found successfully");
				responsestructure.setStatus(HttpStatus.FOUND.value());
				responsestructure.setData(hoteldao.gethotelbyid(hid));
				return new ResponseEntity<Responsestructure<Hotel>>(responsestructure,HttpStatus.FOUND);
		}else {
			throw new IdNotFoundException();
		}
	}
}
