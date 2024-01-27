package com.jspider.springmvcproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.jspider.springmvcproject.pojo.CarPOJO;
import com.jspider.springmvcproject.repository.CarRepository;

@Service
public class CarService {
@Autowired
private CarRepository repository;

public CarPOJO addCarDetails( String name, String brand, String fuielType, long price)
{
CarPOJO pojo=repository.addCarDetails( name,  brand, fuielType,price);
	return pojo;
}

public List<CarPOJO> findAllCars() {
	List<CarPOJO> cars = repository.findAllCars();
	
	return cars;
}

public CarPOJO removeCarDetails(int id) {
	CarPOJO pojo=repository.removeCarDetails(id);
	return pojo;
}

public CarPOJO updateCarDetails(int id, String name, String brand, String fuielType, long price) {
CarPOJO pojo=repository.updateCarDetails(id,name,brand,fuielType,price);
	return pojo;
}



public CarPOJO searchCarDetails(int id) {
	CarPOJO pojo=repository.searchCarDetails(id);
	return pojo;
}


}
