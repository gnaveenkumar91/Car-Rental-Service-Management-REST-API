package com.vcube.crsapp01.service;

import java.util.List;

import com.vcube.crsapp01.exception.ResourceNotFoundException;
import com.vcube.crsapp01.model.Car;

public interface CarService {

	Car addCar(Car car);

	List<Car> getAllCars();

	Car getCarById(Long id) throws ResourceNotFoundException;

	Car updateCar(Long id, Car car) throws ResourceNotFoundException;;

	void deleteCar(Long id) throws ResourceNotFoundException ;

}
