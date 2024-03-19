package com.jsp.hotelmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.hotelmanagement.dto.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {

}
