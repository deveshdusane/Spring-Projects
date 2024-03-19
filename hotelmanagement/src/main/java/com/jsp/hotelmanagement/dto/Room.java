package com.jsp.hotelmanagement.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
@Entity
@Data
public class Room {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int room_id;
	private String room_no;
	private String room_type;
	private int room_price;
	private int no_beds;
	private int max_people;
	private String availability;
	@Enumerated(EnumType.STRING)
	private Floor floor;
	@ManyToOne
	private Hotel hotel;
}
