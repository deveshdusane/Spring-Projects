package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.InvalidEmailException;
import com.example.demo.exception.InvalidIdException;
import com.example.demo.pojo.PlayerPOJO;
import com.example.demo.repository.PlayerRepository;

@Service
public class PlayerService {

	@Autowired
	private PlayerRepository repository;

	public PlayerPOJO addPlayer(PlayerPOJO pojo) throws InvalidEmailException {
		if (pojo.getEmail().contains("@")) {
			PlayerPOJO player = repository.save(pojo);
			return player;
		}
		throw new InvalidEmailException(true,"Invalid Email. ");
	}

	public PlayerPOJO searchById(int id) throws InvalidIdException {
		
		if (id <= 0) {
			throw new InvalidIdException(true,"Invalid Id, Id Must be in Positive Number....");
		}
		PlayerPOJO pojo = repository.findById(id).orElse(null);
		return pojo;
	}

	public List<PlayerPOJO> searchAll() {
		List<PlayerPOJO> players = repository.findAll();
		return players;
	}

	public List<PlayerPOJO> searchByName(String name) {
		List<PlayerPOJO> players = repository.findByName(name);
		return players;
	}

	public List<PlayerPOJO> searchByEmail(String email) {
		List<PlayerPOJO> players = repository.findByEmail(email);
		return players;
	}

	public PlayerPOJO updatePlayer(PlayerPOJO pojo) throws InvalidEmailException,InvalidIdException {
		if (!pojo.getEmail().contains("@")) {
			throw new InvalidEmailException(true, "Invalid Email Format...");
		}
		
		PlayerPOJO player = repository.findById(pojo.getId()).orElseThrow(() -> new InvalidEmailException(true, "Player Id Not Found...")); 
		player.setId(pojo.getId());
		player.setName(pojo.getName());
		player.setEmail(pojo.getEmail());
		player.setCountry(pojo.getCountry());
		
		
		return repository.save(player);
	}

	public PlayerPOJO deletePlayer(int id) throws InvalidIdException {
		
		PlayerPOJO pojo = repository.findById(id).orElseThrow(() -> new InvalidIdException(true,"Player with the given ID does not exist."));
		
		repository.deleteById(id);
		
		return pojo;
	}

	
}
