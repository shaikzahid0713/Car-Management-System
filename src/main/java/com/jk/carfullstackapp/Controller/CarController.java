package com.jk.carfullstackapp.Controller;

import com.jk.carfullstackapp.Domain.CarRepository;
import com.jk.carfullstackapp.Model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class CarController {
	@Autowired
	private CarRepository carRepository;
	
	@RequestMapping("/cars")
	public Iterable<Car> getCars() {
		return carRepository.findAll();
	}
}
