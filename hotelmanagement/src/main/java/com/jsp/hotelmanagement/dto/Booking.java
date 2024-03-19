package com.jsp.hotelmanagement.dto;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private LocalDateTime check_in_date;
	private LocalDateTime check_out_date;
	private int no_people;
	private int rating;
	
	@ManyToOne
	private Customer customer;
	
	@OneToOne
	private Room room;
}
