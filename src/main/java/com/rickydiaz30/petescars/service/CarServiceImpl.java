package com.rickydiaz30.petescars.service;

import com.rickydiaz30.petescars.dao.CarRepository;
import com.rickydiaz30.petescars.entity.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService{

    private final CarRepository carRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<Car> findAll() {
        return carRepository.findAll();
    }

    @Override
    public Car findById(int id) {
        return carRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Car not found!"));
    }

    @Override
    public Car save(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Car patch(int id, Car partialCar) {
        Car existingCar = findById(id);

        if(partialCar.getYear() != null) {
            existingCar.setYear(partialCar.getYear());
        }
        if(partialCar.getMake() != null) {
            existingCar.setMake(partialCar.getMake());
        }
        if(partialCar.getModel() != null) {
            existingCar.setModel(partialCar.getModel());
        }
        if(partialCar.getMiles() != null) {
            existingCar.setMiles(partialCar.getMiles());
        }
        if(partialCar.getColor() != null) {
            existingCar.setColor(partialCar.getColor());
        }
        if(partialCar.getPrice() != null) {
            existingCar.setPrice(partialCar.getPrice());
        }
        if(partialCar.getImageUrl() != null) {
            existingCar.setImageUrl(partialCar.getImageUrl());
        }
        return carRepository.save(existingCar);
    }

    @Override
    public void deleteById(int id) {
        Car car = findById(id);
        carRepository.delete(car);
    }

    @Override
    public List<Car> saveAll(List<Car> cars) {
        return carRepository.saveAll(cars);
    }

}
