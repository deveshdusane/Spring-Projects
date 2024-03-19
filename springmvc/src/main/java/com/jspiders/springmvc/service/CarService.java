package com.jspiders.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.springmvc.pojo.CarPOJO;
import com.jspiders.springmvc.repository.CarRepository;
import com.mysql.cj.x.protobuf.MysqlxCursor.Open;

@Service
public class CarService {
	
	@Autowired
	private CarRepository repository;

	public List<CarPOJO> findAllCars() {
		List<CarPOJO> cars = repository.findAllCars();
		return cars;
	}

	public CarPOJO addCar(String name, String brand, String type, double price) {
		CarPOJO pojo = repository.addCar(name,brand,type,price);
		return pojo;
	}

	public CarPOJO searchCar(int id) {
		CarPOJO pojo = repository.searchCar(id);
		return pojo;
	}

	public CarPOJO removeCar(int id) {
		CarPOJO pojo = repository.removeCar(id);
		return pojo;
	}

	public CarPOJO updateCar(int id, String name, String brand, String type, double price) {
		CarPOJO pojo = repository.updateCar(id,name,brand,type,price);
		return pojo;
	}

}
