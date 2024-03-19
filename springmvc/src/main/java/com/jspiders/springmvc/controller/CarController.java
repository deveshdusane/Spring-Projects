package com.jspiders.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.jspiders.springmvc.pojo.AdminPOJO;
import com.jspiders.springmvc.pojo.CarPOJO;
import com.jspiders.springmvc.service.CarService;

@Controller
public class CarController {
	
	@Autowired     
	private CarService service;
	
//Home page Controller
	@GetMapping("/home")
	public String home(@SessionAttribute(name = "login",required = false) AdminPOJO admin,ModelMap map) {
		if (admin != null) {
			return "home";
		}
		map.addAttribute("msg", "Session Inactive. Login to Proceed...!");
		return "Login";
		
	}
	
//Add Page Controller
	@GetMapping("/add")
	public String addPage( @SessionAttribute(name = "login", required = false)AdminPOJO admin,ModelMap map) {
		if (admin != null) {
			List<CarPOJO> cars = service.findAllCars();
			if (!cars.isEmpty()) {
				map.addAttribute("cars", cars);
				return "Add";
			}
			return "Add";
		}
		map.addAttribute("msg", "Session Inactive. Login to Proceed...!");
		return "Login";	
	}
	
//Add Car Controller
	@PostMapping("/add")
	public String addCar(@SessionAttribute(name = "login",required = false) AdminPOJO admin, @RequestParam String name, @RequestParam String brand, @RequestParam String type, @RequestParam double price,ModelMap map) {
		if (admin != null) {
			CarPOJO car = service.addCar(name,brand,type,price);
			//Success
			if (car != null) {
				map.addAttribute("msg","Data Inserted Successfully");
				List<CarPOJO> cars = service.findAllCars();
				map.addAttribute("cars", cars);
				return "Add";
			}
			//Falure
			map.addAttribute("msg","Data Not Inserted");
			List<CarPOJO> cars = service.findAllCars();
			if (!cars.isEmpty()) {
				map.addAttribute("cars", cars);
			}
			return "Add";
		}
		map.addAttribute("msg", "Session Inactive. Login to Proceed...!");
		return "Login";	
		
	}
//Search Page Controller
	@GetMapping("/search")
	public String searchPage( @SessionAttribute(name = "login",required = false) AdminPOJO admin, ModelMap map) {
		if (admin != null) {
			return "Search";
		}
		map.addAttribute("msg", "Session Inactive. Login to Proceed...!");
		return "Login";
	}
	
//Search Car Controller
	@PostMapping("/search")
	public String searchCar(@SessionAttribute(name = "login",required = false) AdminPOJO admin, @RequestParam int id, ModelMap map) {
		if (admin != null) {
			CarPOJO car = service.searchCar(id);
			
			//Success
			if (car != null) {
				map.addAttribute("car", car);
				map.addAttribute("msg","Car Data Found.....");
				return "Search";
			}
			map.addAttribute("msg","Car Data Not Found......");
			return "Search";
		}
		map.addAttribute("msg", "Session Inactive. Login to Proceed...!");
		return "Login";
	}
	
//remove Page Controller
	@GetMapping("/remove")
	public String removePage(@SessionAttribute(name = "login",required = false) AdminPOJO admin,ModelMap map) {
		if (admin != null) {
			List<CarPOJO> cars = service.findAllCars();
			//success
			if (!cars.isEmpty()) {
				map.addAttribute("cars", cars);
				return "Remove";
			}
			//Failure
			map.addAttribute("msg", "No Data Present");
			return "Remove";
		}
		map.addAttribute("msg", "Session Inactive. Login to Proceed...!");
		return "Login";
		
	}
	
//Remove Car Controller
	@PostMapping("/remove")
	public String removeCar(@SessionAttribute(name = "login",required = false) AdminPOJO admin ,@RequestParam int id, ModelMap map) {
		if (admin != null) {
			CarPOJO car = service.removeCar(id);
			List<CarPOJO> cars = service.findAllCars();
			//Success
			if (car != null) {
				map.addAttribute("msg", "Data Removed Successfully......");
				map.addAttribute("cars", cars);
				return "Remove";
			}
			//Failure
			map.addAttribute("msg", "Data Does Not Exist......");
			map.addAttribute("cars", cars);
			return "Remove";
		}
		map.addAttribute("msg", "Session Inactive. Login to Proceed...!");
		return "Login";
	}
	
//Update Page Controller
	@GetMapping("/update")
	public String updatePage(@SessionAttribute(name = "login",required = false)  AdminPOJO admin , ModelMap map) {
		if (admin != null) {
			List<CarPOJO> cars = service.findAllCars();
			map.addAttribute("cars", cars);
			return "Update";
		}
		map.addAttribute("msg", "Session Inactive. Login to Proceed...!");
		return "Login";
	}
	
//Update Form Controller
	@PostMapping("/update")
	public String updateForm(@SessionAttribute(name = "login",required = false) AdminPOJO admin,@RequestParam int id, ModelMap map) {
		if (admin != null) {
			CarPOJO car = service.searchCar(id);
			//Success
			if (car != null) {
				map.addAttribute("car", car);
				return "Update";
			}
			//Failure
			List<CarPOJO> cars = service.findAllCars();
			map.addAttribute("cars", cars);
			map.addAttribute("msg", "Car Data Not Found........");
			return "Update";
		}
		map.addAttribute("msg", "Session Inactive. Login to Proceed...!");
		return "Login";
	}
	
//Update Car Controller
	@PostMapping("/updateCar")
	public String updateCar(@SessionAttribute(name = "login",required = false) AdminPOJO admin,@ RequestParam int id, @RequestParam String name, @RequestParam String brand, @RequestParam String type, @RequestParam double price, ModelMap map) {
		if (admin != null) {
			CarPOJO car = service.updateCar(id,name,brand,type,price);
			//Success
			if (car != null) {
				List<CarPOJO> cars = service.findAllCars();
				map.addAttribute("cars", cars);
				map.addAttribute("msg", "Data Updated Successfully........");
				return "Update";
			}
			//Failure
			List<CarPOJO> cars = service.findAllCars();
			map.addAttribute("msg", "Data Not Updated.....!");
			map.addAttribute("cars", cars);
			return "Update";
		}
		map.addAttribute("msg", "Session Inactive. Login to Proceed...!");
		return "Login";
	}
}
