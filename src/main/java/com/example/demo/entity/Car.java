package com.example.demo.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;

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


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner", nullable = false)
    private Owner owner;

    // Need no args constructor
    public Car(){}


    public Car(Owner owner, String brand, String model, Integer year, String regnumber, String colour) {
        this.owner = owner;
        this.brand = brand;
        this.model = model;
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


    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
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
