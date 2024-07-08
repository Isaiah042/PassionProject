package com.passion.Car_Project.service;

import com.passion.Car_Project.model.Car;
import com.passion.Car_Project.repos.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    @Autowired
    private CarRepo carRepo;

    public Car saveYourCar(Car car) {
        return carRepo.save(car);
    }

    public Car updateYourCar(Long carId, Car updatedCar) {
        Car car = carRepo.findById(carId).orElse(null);
        if (car == null) {
            throw new RuntimeException("Car not found");
        }
        car.setCarName(updatedCar.getCarName());
        car.setCarType(updatedCar.getCarType());
        car.setModel(updatedCar.getModel());
        car.setYear(updatedCar.getYear());

        return carRepo.save(updatedCar);
    }

    public void deleteYourCarById(Long carId) {
        carRepo.deleteById(carId);
    }

    public Car getYourCarById(Long id) {
        Car car = carRepo.findById(id).orElse(null);
        return car;
    }

    public List<Car> getAllCars() {
        return carRepo.findAll();
    }

}
