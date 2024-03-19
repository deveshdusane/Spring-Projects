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

import com.jsp.hotelmanagement.dto.Admin;
import com.jsp.hotelmanagement.service.AdminService;
import com.jsp.hotelmanagement.util.Responsestructure;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;

	@PostMapping
	public ResponseEntity<Responsestructure<Admin>> saveBooking(@RequestBody Admin admin, @RequestParam int hid) {
		return adminService.saveAdmin(admin, hid);
	}

	@PutMapping
	public ResponseEntity<Responsestructure<Admin>> updateBooking(@RequestBody Admin admin, @RequestParam int aid) {
		return adminService.updateAdmin(aid, admin);
	}

	@DeleteMapping
	public ResponseEntity<Responsestructure<Admin>> deleteBooking(@RequestParam int aid ) {
		return adminService.deleteAdmin(aid);
	}
	
	@GetMapping("/adminbyid")
	public ResponseEntity<Responsestructure<Admin>> getAdminbyid(@RequestParam int aid) {
		return adminService.getAdminbyid(aid);
	}
	
	@GetMapping("/adminbyemail")
	public ResponseEntity<Responsestructure<Admin>> getAdminbyemail(@RequestParam String email) {
		return adminService.getAdminbyemail(email);
	}
	
	@GetMapping("/getalladmin")
	public ResponseEntity<Responsestructure<List<Admin>>> getAllAdmin() {
		return adminService.getAllAdmin();
	}
	
	@GetMapping("/loginadmin")
	public ResponseEntity<Responsestructure<Admin>> loginAdmin(@RequestParam String email,@RequestParam String password) {
		return adminService.loginAdmin(email, password);
	}

}
