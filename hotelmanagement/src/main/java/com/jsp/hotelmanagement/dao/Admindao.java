package com.jsp.hotelmanagement.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.hotelmanagement.dto.Admin;
import com.jsp.hotelmanagement.repository.AdminRepository;

@Repository
public class Admindao {

	@Autowired
	private AdminRepository adminRepo;
	
	public Admin saveAdmin(Admin admin) {
		return adminRepo.save(admin);
	}
	
	public Admin updateAdmin(Admin admin) {
		return adminRepo.save(admin);
	}
	
	public Admin deleteAdmin(Admin admin) {
		adminRepo.delete(admin);
		return admin;
	}
	
	public Admin getAdminbyid( int aid) {
		if (adminRepo.findById(aid).isPresent()) {
			return adminRepo.findById(aid).get();
		}
		return null;
	}
	
	public List<Admin> getAllAdmins(){
		return adminRepo.findAll();
	}
	
	public Admin getAdminbyemail(String admin_email) {
		if (adminRepo.getAdminbyemail(admin_email) != null) {
			return adminRepo.getAdminbyemail(admin_email);
		}
		return null;
	}
}
