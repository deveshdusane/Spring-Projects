package com.jsp.hotelmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.hotelmanagement.dao.Customerdao;
import com.jsp.hotelmanagement.dto.Customer;
import com.jsp.hotelmanagement.exception.IdNotFoundException;
import com.jsp.hotelmanagement.util.Responsestructure;

@Service
public class CustomerService {

	@Autowired
	private Customerdao customerdao;

	Responsestructure<Customer> responsestructure = new Responsestructure<>();

	public ResponseEntity<Responsestructure<Customer>> saveCustomer(Customer customer) {
		Customer dbCustomer = customerdao.saveCustomer(customer);
		if (dbCustomer != null) {
			responsestructure.setMessage("saved successfully");
			responsestructure.setStatus(HttpStatus.CREATED.value());
			responsestructure.setData(dbCustomer);
			return new ResponseEntity<Responsestructure<Customer>>(responsestructure, HttpStatus.CREATED);
		} else {
			throw new IdNotFoundException();
		}
	}

	public ResponseEntity<Responsestructure<Customer>> updateCustomer(int cid, Customer customer) {
		Customer dbCustomer = customerdao.getCustomerbyid(cid);
		if (dbCustomer != null) {
			customer.setC_id(cid);
			responsestructure.setMessage("updated successfully");
			responsestructure.setStatus(HttpStatus.OK.value());
			responsestructure.setData(customerdao.updateCustomer(customer));
			return new ResponseEntity<Responsestructure<Customer>>(responsestructure, HttpStatus.CREATED);
		} else {
			throw new IdNotFoundException();
		}
	}

	public ResponseEntity<Responsestructure<Customer>> deleteCustomer(int cid) {
		Customer customer = customerdao.getCustomerbyid(cid);
		if (customer != null) {
			responsestructure.setMessage("deleted successfully");
			responsestructure.setStatus(HttpStatus.OK.value());
			responsestructure.setData(customerdao.deleteCustomer(customer));
			return new ResponseEntity<Responsestructure<Customer>>(responsestructure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException();
		}
	}

	public ResponseEntity<Responsestructure<Customer>> getCustomerbyid(int cid) {
		Customer customer = customerdao.getCustomerbyid(cid);
		if (customer != null) {
			responsestructure.setMessage("found successfully");
			responsestructure.setStatus(HttpStatus.FOUND.value());
			responsestructure.setData(customer);
			return new ResponseEntity<Responsestructure<Customer>>(responsestructure, HttpStatus.FOUND);
		} else {
			throw new IdNotFoundException();
		}
	}

	public ResponseEntity<Responsestructure<Customer>> getCustomerbyemail(String c_email) {
		Customer customer = customerdao.getCustomerbyemail(c_email);
		if (customer != null) {
			responsestructure.setMessage("found successfully");
			responsestructure.setStatus(HttpStatus.FOUND.value());
			responsestructure.setData(customer);
			return new ResponseEntity<Responsestructure<Customer>>(responsestructure, HttpStatus.FOUND);
		} else {
			throw new IdNotFoundException();
		}
	}

	public ResponseEntity<Responsestructure<List<Customer>>> getAllCustomers() {
		Responsestructure<List<Customer>> responsestructure = new Responsestructure<>();
		if (customerdao.getAllCustomers() != null) {
			responsestructure.setMessage("found successfully");
			responsestructure.setStatus(HttpStatus.FOUND.value());
			responsestructure.setData(customerdao.getAllCustomers());
			return new ResponseEntity<Responsestructure<List<Customer>>>(responsestructure, HttpStatus.FOUND);
		}
		throw new IdNotFoundException();
	}

	public ResponseEntity<Responsestructure<Customer>> loginCustomer(String email, String password) {
		Customer customer = customerdao.getCustomerbyemail(email);
		if (customer.getC_password().equals(customer)) {
			responsestructure.setMessage("logged in successfully");
			responsestructure.setStatus(HttpStatus.OK.value());
			responsestructure.setData(customer);
			return new ResponseEntity<Responsestructure<Customer>>(responsestructure, HttpStatus.FOUND);
		} else {
			responsestructure.setMessage("enter valid email and password");
			responsestructure.setStatus(HttpStatus.BAD_REQUEST.value());
			responsestructure.setData(null);
			return new ResponseEntity<Responsestructure<Customer>>(responsestructure, HttpStatus.BAD_REQUEST);
		}
	}
}
