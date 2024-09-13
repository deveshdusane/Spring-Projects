package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.InvalidEmailException;
import com.example.demo.exception.InvalidIdException;
import com.example.demo.pojo.PlayerPOJO;
import com.example.demo.response.PlayerResponse;
import com.example.demo.service.PlayerService;


@RestController

public class PlayerController {

	@Autowired
	private PlayerService service;
	
	@PostMapping("/add")
	public ResponseEntity<?> addPlayer(@RequestBody PlayerPOJO pojo){
		
		try {
			PlayerPOJO player = service.addPlayer(pojo);
			//Success
			if (player != null) {
				return new ResponseEntity<PlayerResponse>(new PlayerResponse("Data Added Successfully..",player,null),HttpStatus.ACCEPTED);
			}
			return new ResponseEntity<PlayerResponse>(new PlayerResponse("Data Not added..",null,null),HttpStatus.NOT_ACCEPTABLE);
		} catch (InvalidEmailException e) {
			return new ResponseEntity<InvalidEmailException>(new InvalidEmailException(true,"Invalid email"),HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updatePlayer(@RequestBody PlayerPOJO pojo){
		
		try {
			PlayerPOJO player = service.updatePlayer(pojo);
			if (player != null) {
				return new ResponseEntity<PlayerResponse>(new PlayerResponse("Player Data Updated Successfully..",player,null),HttpStatus.OK);
			}
			return new ResponseEntity<PlayerResponse>(new PlayerResponse("Player data Not Updated...",null,null),HttpStatus.NOT_FOUND);
			
		} catch (InvalidEmailException e) {
			return new ResponseEntity<InvalidEmailException>(new InvalidEmailException(true,"Invalid Email..."),HttpStatus.BAD_REQUEST);
		}catch (InvalidIdException e) {
			return new ResponseEntity<InvalidIdException>(new InvalidIdException(true,"Invalid Id..."),HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deletePlayer(@PathVariable int id){
		try {
			PlayerPOJO pojo = service.deletePlayer(id);
			if (pojo != null) {
				return new ResponseEntity<PlayerResponse>(new PlayerResponse("Player Data Deleted Successfully..",pojo,null),HttpStatus.OK);
			}
			return new ResponseEntity<PlayerResponse>(new PlayerResponse("Player Data Not Deleted..",null,null),HttpStatus.OK);
			
		} catch (InvalidIdException e) {
			return new ResponseEntity<InvalidIdException>(new InvalidIdException(true,"Invalid Id"),HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@GetMapping("/search/{id}")
	public ResponseEntity<?> searchById(@PathVariable int id){
		try {
			PlayerPOJO pojo = service.searchById(id);
			if (pojo != null) {
				return new ResponseEntity<PlayerResponse>(new PlayerResponse("Player Data Found Successfully....",pojo,null),HttpStatus.FOUND);
			}
			return new ResponseEntity<PlayerResponse>(new PlayerResponse("Player Data Not Found...",pojo,null),HttpStatus.BAD_REQUEST);
		} catch (InvalidIdException e) {
			return new ResponseEntity<InvalidIdException>(new InvalidIdException(true,"Invalid Id, Id must be in Positive Number"),HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/searchAll")
	public ResponseEntity<?> searchAll(){
		List<PlayerPOJO> players = service.searchAll();
		if (players.isEmpty() == false) {
			return new ResponseEntity<PlayerResponse>(new PlayerResponse("Player Data Found Successfully..",null,players),HttpStatus.FOUND);
		}
		return new ResponseEntity<PlayerResponse>(new PlayerResponse("Player Data Not Found..",null,null),HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/searchByName/{name}")
	public ResponseEntity<?> searchByName(@PathVariable String name){
		List<PlayerPOJO> players = service.searchByName(name);
		
		if (players.isEmpty() == false) {
			return new ResponseEntity<PlayerResponse>(new PlayerResponse("Data Found Successfully...",null,players),HttpStatus.FOUND);
		}
		return new ResponseEntity<PlayerResponse>(new PlayerResponse("Student Data Not Found...",null,null),HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/searchByEmail/{email}")
	public ResponseEntity<?> searchByEmail(@PathVariable String email){
		List<PlayerPOJO> players = service.searchByEmail(email);
		if (players.isEmpty() == false) {
			return new ResponseEntity<PlayerResponse>(new PlayerResponse("Player data Found Successfull",null,players),HttpStatus.FOUND);
		}
		return new ResponseEntity<PlayerResponse>(new PlayerResponse("Player Data Not Found...",null,null),HttpStatus.BAD_REQUEST);
	}
	
}
