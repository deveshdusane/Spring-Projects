package com.jsp.hotelmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.hotelmanagement.dto.Room;

public interface RoomRepository extends JpaRepository<Room, Integer> {

	@Query("select r from Room r where r.room_id=?1")
	public Room getRoombyId(int rid);
	
	@Query("select r from Room r where r.room_no=?1")
	public Room getRoombyno(String room_no);
	
	@Query("select r from Room r where r.room_type=?1")
	public List<Room> getRoombytype(String room_type);
	
	@Query("select r from Room r where r.availability=?1")
	public List<Room> getRoombyavailability(String availability);
	
}
