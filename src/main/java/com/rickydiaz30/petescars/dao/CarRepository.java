package com.rickydiaz30.petescars.dao;

import com.rickydiaz30.petescars.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Integer> {
}
