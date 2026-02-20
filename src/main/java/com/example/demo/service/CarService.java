package com.example.demo.service;

import com.example.demo.entity.Car;
import com.example.demo.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarService {

    // Constructor Injections :)
    private final CarRepository carRepository;

    CarService( CarRepository carRepository){
        this.carRepository = carRepository;
    }

    public Iterable<Car> returnAllCars(){
        return carRepository.findAll();
    }


}
