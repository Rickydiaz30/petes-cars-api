package com.rickydiaz30.petescars.entity;

import jakarta.persistence.*;

@Entity
@Table(name="cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="year")
    private Integer year;

    @Column(name="make")
    private String make;

    @Column(name="model")
    private String model;

    @Column(name="miles")
    private Integer miles;

    @Column(name="color")
    private String color;

    @Column(name="price")
    private Double price;

    @Column(name="image_url")
    private String imageUrl;

    @Column(name="description")
    private String description;

    public Car() {}

    public Car(Integer year, String make, String model, Integer miles, String color, Double price, String imageUrl, String description) {
        this.year = year;
        this.make = make;
        this.model = model;
        this.miles = miles;
        this.color = color;
        this.price = price;
        this.imageUrl = imageUrl;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
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

    public Integer getMiles() {
        return miles;
    }

    public void setMiles(int miles) {
        this.miles = miles;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", year=" + year +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", miles=" + miles +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", imageUrl='" + imageUrl + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
