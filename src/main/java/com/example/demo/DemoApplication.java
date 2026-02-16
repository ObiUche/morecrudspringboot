package com.example.demo;

import com.example.demo.entity.Car;
import com.example.demo.entity.Owner;
import com.example.demo.repository.CarRepository;
import com.example.demo.repository.OwnerRepository;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }


    @Component
    class Runner implements ApplicationRunner {


        private final CarRepository repository;

        // added the owner repository by constructor injection

        private final OwnerRepository orepository;

        // Constructor injection :)
        Runner(CarRepository repository, OwnerRepository orepository){

            this.repository = repository;
            this.orepository = orepository;
        }


        @PostConstruct
        @Transactional
        void init(){

            Owner owner1 = new Owner("Obinna Uche", "Software Engineer");
            Owner owner2 = new Owner("Chidera Okafor", "Lawyer");

            orepository.save( owner2);
            orepository.save( owner1);





            repository.save(new Car(owner1 , "BMW","520D",2011, "AD11AHD", "Black"));
            repository.save(new Car(owner2,"A1", "AUDI",2025, "CJ25LSK", "Orange"));
            repository.save(new Car( owner1, "Nissan"," Micra",2013, "WS13ASD", "Grey"));
        }


        @Override
        public void run(ApplicationArguments args) throws Exception {
            Car output;
            try {
                output = repository.findById(2L).orElseThrow(NoSuchElementException::new);
                System.out.println("Car with 2ID: " + output);
            } catch (NoSuchElementException e) {
                System.out.println("Not Found");
            }

            System.out.println("Now we are going to update");

            try{
                Car car = repository.findById(1L).orElseThrow(NoSuchElementException:: new);
                System.out.println("Before Update " + car);
                System.out.println("Updating....");
                car.setModel("720D");
                repository.save(car);
                System.out.println("After Update " + car);

            } catch (NoSuchElementException e){
                System.out.println("Not Found");
            }

            // Now i want to delete a Car by ID 1;

            System.out.println("Before the delete");
            printAllCars();

            repository.deleteById(1L);
            System.out.println("After the delete");

            printAllCars();




        }

        void printAllCars(){
            Iterable<Car> allCars = repository.findAll();

            for(Car i: allCars){
                System.out.println(i);
            }
        }
//
//        @Transactional
//        void printAllOwners(){
//            Iterable<Owner> allOwners = orepository.findAll();
//
//            for( Owner i : allOwners){
//                Hibernate.initialize(i.getCarList());
//            }
//
//            allOwners.forEach(System.out::println);
//        }

    }
}
