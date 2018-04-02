package com.example.demo;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "vehicles")
public class Vehicle implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String makemodel;
    private int year;
    private double retailPrice;

    public Vehicle(){

    }

    public Vehicle( String makemodel, int year, double retailPrice){
        this.makemodel = makemodel;
        this.year = year;
        this.retailPrice = retailPrice;
    }

    public String toString(){
        return this.getId() + ", " + this.makemodel + ", Year:" + this.year + ", Price:" + this.retailPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMakemodel() {
        return makemodel;
    }

    public void setMakemodel(String makemodel) {
        this.makemodel = makemodel;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(double retailPrice) {
        this.retailPrice = retailPrice;
    }
}
