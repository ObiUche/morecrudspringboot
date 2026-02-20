package com.example.demo.conotroller;

import com.example.demo.entity.Car;
import com.example.demo.repository.CarRepository;
import com.example.demo.service.CarService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {


    private final CarService carService;

    CarController(CarService service){
        this.carService = service;
    }

    @GetMapping("/cars")
    public Iterable<Car> displayAllCars(){
        return carService.returnAllCars();
    }
}
