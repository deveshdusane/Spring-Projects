package com.jsp.hotelmanagement.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.hotelmanagement.dto.Room;
import com.jsp.hotelmanagement.repository.RoomRepository;

@Repository
public class Roomdao {

	@Autowired
	private RoomRepository roomrepo;
	
	public Room saveRoom(Room room) {
		return roomrepo.save(room);
	}
	
	public Room updateRoom(Room room) {
		return roomrepo.save(room);
	}
	
	public Room deleteRoom(Room room) {
		roomrepo.delete(room);
		return room;
	}
	
	public Room getRoombyid(int rid) {
		if (roomrepo.getRoombyId(rid) != null) {
			return roomrepo.getRoombyId(rid);
		}
		return null;
	}
	
	public List<Room> getAllRooms(){
		return roomrepo.findAll();
	}
	
	public Room getRoombyno(String room_no) {
		if (roomrepo.getRoombyno(room_no) != null) {
			return roomrepo.getRoombyno(room_no);
		}
		return null;
	}
	
	public List<Room> getRoombytype(String room_type) {
		if (roomrepo.getRoombytype(room_type) != null) {
			return roomrepo.getRoombytype(room_type);
		}
		return null;
	}
	
	public List<Room> getRoombyavailability(String availability) {
		if (roomrepo.getRoombyavailability(availability) != null) {
			return roomrepo.getRoombyavailability(availability);
		}
		return null;
	}
}
