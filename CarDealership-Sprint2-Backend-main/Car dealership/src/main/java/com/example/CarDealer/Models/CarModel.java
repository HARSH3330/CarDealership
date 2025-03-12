package com.example.CarDealer.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CarModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int carid;

    @JsonProperty("make")
    private String make;

    @JsonProperty("model")
    private String model;

    @JsonProperty("year")
    private int year;

    @JsonProperty("price")
    private double price;

    @JsonProperty("colour")
    private String colour;

    @JsonProperty("status")
    private int status;

    @JsonProperty("kms_driven")
    private double kms_driven;

    @JsonProperty("no_owners")
    private int no_owners;

    public CarModel() {
    }

    public CarModel(int carid, String make, String model, int year, double price, String colour, int status, double kms_driven, int no_owners) {
        this.carid = carid;
        this.make = make;
        this.model = model;
        this.year = year;
        this.price = price;
        this.colour = colour;
        this.status = status;
        this.kms_driven = kms_driven;
        this.no_owners = no_owners;
    }

    public int getCarid() {
        return carid;
    }

    public void setCarid(int carid) {
        this.carid = carid;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public double getKms_driven() {
        return kms_driven;
    }

    public void setKms_driven(double kms_driven) {
        this.kms_driven = kms_driven;
    }

    public int getNo_owners() {
        return no_owners;
    }

    public void setNo_owners(int no_owners) {
        this.no_owners = no_owners;
    }
}
