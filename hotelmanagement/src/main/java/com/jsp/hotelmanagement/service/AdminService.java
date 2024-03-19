package com.jsp.hotelmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.hotelmanagement.dao.Admindao;
import com.jsp.hotelmanagement.dao.Hoteldao;
import com.jsp.hotelmanagement.dto.Admin;
import com.jsp.hotelmanagement.dto.Hotel;
import com.jsp.hotelmanagement.exception.IdNotFoundException;
import com.jsp.hotelmanagement.util.Responsestructure;

@Service
public class AdminService {

	@Autowired
	private Admindao admindao;
	@Autowired
	private Hoteldao hoteldao;
	
	Responsestructure<Admin> responsestructure = new Responsestructure<>();
	
	public ResponseEntity<Responsestructure<Admin>> saveAdmin(Admin admin, int hid) {
		Hotel hotel = hoteldao.gethotelbyid(hid);
		admin.setHotel(hotel);
		Admin admin2 = admindao.saveAdmin(admin);
		if (admin2 != null) {
			responsestructure.setMessage("admin saved successfully");
			responsestructure.setStatus(HttpStatus.CREATED.value());
			responsestructure.setData(admin2);
			return new ResponseEntity<Responsestructure<Admin>>(responsestructure, HttpStatus.CREATED);
		}else {
			throw new IdNotFoundException();
		}
	}
	
	
	public ResponseEntity<Responsestructure<Admin>> updateAdmin(int aid,Admin admin) {
		Admin dbAdmin = admindao.getAdminbyid(aid);
		admin.setHotel(dbAdmin.getHotel());
		if (dbAdmin != null) {
			admin.setAdmin_id(aid);
			responsestructure.setMessage("updated successfully");
			responsestructure.setStatus(HttpStatus.OK.value());
			responsestructure.setData(admindao.updateAdmin(admin));
			return new ResponseEntity<Responsestructure<Admin>>(responsestructure, HttpStatus.OK);
		}else {
			throw new IdNotFoundException();
		}
	}
	
	public ResponseEntity<Responsestructure<Admin>> deleteAdmin(int aid) {
		Admin admin = admindao.getAdminbyid(aid);
		if (admin != null) {
			responsestructure.setMessage("deleted successfully");
			responsestructure.setStatus(HttpStatus.OK.value());
			responsestructure.setData(admindao.deleteAdmin(admin));
			return new ResponseEntity<Responsestructure<Admin>>(responsestructure, HttpStatus.OK);
		}else {
			throw new IdNotFoundException();
		}
		
	}
	
	public ResponseEntity<Responsestructure<Admin>> getAdminbyemail(String email) {
		Admin admin = admindao.getAdminbyemail(email);
		if (admin != null) {
			responsestructure.setMessage("found successfully");
			responsestructure.setStatus(HttpStatus.FOUND.value());
			responsestructure.setData(admin);
			return new ResponseEntity<Responsestructure<Admin>>(responsestructure, HttpStatus.FOUND);
		}else {
			throw new IdNotFoundException();
		}
	}
	
	public ResponseEntity<Responsestructure<List<Admin>>> getAllAdmin(){
		Responsestructure<List<Admin>> responsestructure = new Responsestructure<>();
		if (admindao.getAllAdmins() != null) {
			responsestructure.setMessage("found successfully");
			responsestructure.setStatus(HttpStatus.FOUND.value());
			responsestructure.setData(admindao.getAllAdmins());
			return new ResponseEntity<Responsestructure<List<Admin>>>(responsestructure, HttpStatus.FOUND);
		}
		throw new IdNotFoundException();
	}
	
	public ResponseEntity<Responsestructure<Admin>> loginAdmin(String email, String password) {
		Admin admin = admindao.getAdminbyemail(email);
		if (admin.getAdmin_password().equals(password)) {
			responsestructure.setMessage("admin logged in successfully");
			responsestructure.setStatus(HttpStatus.OK.value());
			responsestructure.setData(admin);
			return new ResponseEntity<Responsestructure<Admin>>(responsestructure, HttpStatus.OK);
		}else {
			responsestructure.setMessage("enter valid email and password");
			responsestructure.setStatus(HttpStatus.BAD_REQUEST.value());
			responsestructure.setData(null);
			return new ResponseEntity<Responsestructure<Admin>>(responsestructure, HttpStatus.BAD_GATEWAY);
		}
	}
	
	public ResponseEntity<Responsestructure<Admin>> getAdminbyid(int aid) {
		Admin admin = admindao.getAdminbyid(aid);
		if (admin != null) {
			responsestructure.setMessage("found successfully");
			responsestructure.setStatus(HttpStatus.FOUND.value());
			responsestructure.setData(admin);
			return new ResponseEntity<Responsestructure<Admin>>(responsestructure, HttpStatus.FOUND);
		}else {
			throw new IdNotFoundException();
		}
	}
}
