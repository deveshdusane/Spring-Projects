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

import com.jsp.hotelmanagement.dto.Customer;
import com.jsp.hotelmanagement.service.CustomerService;
import com.jsp.hotelmanagement.util.Responsestructure;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@PostMapping
	public ResponseEntity<Responsestructure<Customer>> saveCustomer(@RequestBody Customer customer) {
		return customerService.saveCustomer(customer);
	}
	
	@PutMapping
	public ResponseEntity<Responsestructure<Customer>> updateCustomer(@RequestBody Customer customer, @RequestParam int cid) {
		return customerService.updateCustomer(cid, customer);
	}
	
	@DeleteMapping 
	public ResponseEntity<Responsestructure<Customer>> deleteCustomer(@RequestParam int cid) {
		return customerService.deleteCustomer(cid);
	}
	
	@GetMapping
	public ResponseEntity<Responsestructure<Customer>> getCustomerbyid(@RequestParam int cid) {
		return customerService.getCustomerbyid(cid);
	}
	
	@GetMapping("/getcustomerbyemail")
	public ResponseEntity<Responsestructure<Customer>> getCustomerbyemail(@RequestParam String c_email) {
		return customerService.getCustomerbyemail(c_email);
	}
	
	@GetMapping("/getallcustomers")
	public ResponseEntity<Responsestructure<List<Customer>>> getAllCustomer() {
		return customerService.getAllCustomers();
	}
	
	@GetMapping("/customerlogin")
	public ResponseEntity<Responsestructure<Customer>> loginCustomer(@RequestParam String email,@RequestParam String password) {
		return customerService.loginCustomer(email, password);
	}
}
