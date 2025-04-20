package com.rickydiaz30.petescars.service;

import com.rickydiaz30.petescars.entity.Car;

import java.util.List;

public interface CarService {
    List<Car> findAll();
    Car findById(int id);
    Car save(Car car);
    List<Car> saveAll(List<Car> cars);

    Car patch(int id, Car partialCar);
    void deleteById(int id);
}
