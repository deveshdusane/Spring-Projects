package com.jsp.hotelmanagement.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.hotelmanagement.dto.Customer;
import com.jsp.hotelmanagement.repository.CustomerRepository;

@Repository
public class Customerdao {

	@Autowired
	private CustomerRepository customerRepo;
	
	public Customer saveCustomer(Customer customer) {
		return customerRepo.save(customer);
	}
	
	public Customer updateCustomer(Customer customer) {
		return customerRepo.save(customer);
	}
	
	public Customer deleteCustomer(Customer customer) {
		customerRepo.delete(customer);
		return customer;
	}
	
	public Customer getCustomerbyid(int cid) {
		if (customerRepo.findById(cid).isPresent()) {
			return customerRepo.findById(cid).get();
		}
		return null;
	}
	
	public Customer getCustomerbyemail(String c_email) {
		if (customerRepo.getCustomerbyemail(c_email) != null) {
			return customerRepo.getCustomerbyemail(c_email);
		}
		return null;
	}
	
	public List<Customer> getAllCustomers(){
		return customerRepo.findAll();
	}
}
