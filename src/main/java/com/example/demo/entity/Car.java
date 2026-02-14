package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Column(name= "Brand")
    private String brand;

    @Column(name = "Model")
    private String model;

    @Column(name = "ModelYear")
    private Integer year;

    private String regnumber;

    @Column(name= "Colour")
    private String colour;


    // Need no args constructor
    public Car(){}

    public Car(String model, String brand, Integer year, String regnumber, String colour) {
        this.model = model;
        this.brand = brand;
        this.year = year;
        this.regnumber = regnumber;
        this.colour = colour;
    }

    public Long getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getRegnumber() {
        return regnumber;
    }

    public void setRegnumber(String regnumber) {
        this.regnumber = regnumber;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", regnumber='" + regnumber + '\'' +
                ", colour='" + colour + '\'' +
                '}';
    }
}
