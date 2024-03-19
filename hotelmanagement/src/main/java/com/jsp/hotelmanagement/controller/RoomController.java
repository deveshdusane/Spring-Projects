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

import com.jsp.hotelmanagement.dto.Room;
import com.jsp.hotelmanagement.service.RoomService;
import com.jsp.hotelmanagement.util.Responsestructure;

@RestController
@RequestMapping("/room")
public class RoomController {

	@Autowired
	private RoomService roomService;
	
	@PostMapping
	public ResponseEntity<Responsestructure<Room>> saveRoom(@RequestBody Room room,@RequestParam int hid) {
		return roomService.saveRoom(room, hid);
	}
	
	@PutMapping
	public ResponseEntity<Responsestructure<Room>> updateRoom(@RequestParam int rid, @RequestBody Room room) {
		return roomService.updateRoom(rid, room);
	}
	
	@DeleteMapping
	public ResponseEntity<Responsestructure<Room>> deleteRoom(@RequestParam int rid) {
		return roomService.deleteRoom(rid);
	}
	
	@GetMapping
	public ResponseEntity<Responsestructure<Room>> getRoomnyid(@RequestParam int rid) {
		return roomService.getRoombyid(rid);
	}
	
	@GetMapping("/roombyno")
	public ResponseEntity<Responsestructure<Room>> getRoombyno(@RequestParam String room_no) {
		return roomService.getRoombyno(room_no);
	}
	
	@GetMapping("/roombytype")
	public ResponseEntity<Responsestructure<List<Room>>> getRoombytype(@RequestParam String room_type) {
		return roomService.getRoomsbytype(room_type);
	}
	
	@GetMapping("/roombyavailability")
	public ResponseEntity<Responsestructure<List<Room>>> getRoombyavailability(@RequestParam String availability){
		return roomService.getRoombyavailability(availability);
	}
	
	@GetMapping("/getallrooms")
	public ResponseEntity<Responsestructure<List<Room>>> getAllRooms() {
		return roomService.getAllRooms();
		
	}
}
