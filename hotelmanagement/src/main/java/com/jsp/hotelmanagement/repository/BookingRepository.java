package com.jsp.hotelmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.hotelmanagement.dto.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

	@Query("select b from Booking b where b.check_in_date=?1")
	public Booking getBookingbycheckin(String check_in_date);
	
	@Query("select b from Booking b where b.check_out_date=?1")
	public Booking getBookingbycheckout(String check_out_date);
}
