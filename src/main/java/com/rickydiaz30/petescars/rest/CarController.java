package com.rickydiaz30.petescars.rest;

import com.rickydiaz30.petescars.entity.Car;
import com.rickydiaz30.petescars.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "https://petescars.netlify.app")

@RestController
@RequestMapping("/api")
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public List<Car> getCars() {
        return carService.findAll();
    }

    @GetMapping("/cars/{id}")
    public Car getCar(@PathVariable int id) {
        return carService.findById(id);
    }

    @PostMapping("/cars")
    public Car addCar(@RequestBody Car car) {
        return carService.save(car);
    }

    @PostMapping("/cars/bulk")
    public List<Car> addCars(@RequestBody List<Car> cars) {
        return carService.saveAll(cars);
    }


    @PatchMapping("/cars/{id}")
    public ResponseEntity<Car> patchCar(
            @PathVariable int id,
            @RequestBody Car partialCar) {
        Car updated = carService.patch(id, partialCar);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/cars/{id}")
    public String deleteCar(@PathVariable int id) {
        Car car = carService.findById(id);
        if(car == null) {
            throw new RuntimeException("Car not found with id " + id);
        }
        carService.deleteById(id);
        return "Car with id " + id + " deleted";
    }
}
