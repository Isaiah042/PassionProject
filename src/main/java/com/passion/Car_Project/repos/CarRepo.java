package com.passion.Car_Project.repos;

import com.passion.Car_Project.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepo extends JpaRepository<Car,Long> {
}
