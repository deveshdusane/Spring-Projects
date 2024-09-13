package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.pojo.PlayerPOJO;

public interface PlayerRepository extends JpaRepository<PlayerPOJO, Integer> {

	List<PlayerPOJO> findByName(String name);
	
	List<PlayerPOJO> findByEmail(String email);
	
	List<PlayerPOJO> findByCountry(String country);
	
	
}
