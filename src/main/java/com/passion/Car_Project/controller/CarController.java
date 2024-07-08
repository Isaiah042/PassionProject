package com.passion.Car_Project.controller;

import com.passion.Car_Project.model.Car;
import com.passion.Car_Project.reponse.ResponseHandler;
import com.passion.Car_Project.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class CarController {

    @Autowired
    private CarService carService;

    @PostMapping("/yourCar")
    public ResponseEntity<?> saveYourCar(@RequestBody Car car) {
        try{
            carService.saveYourCar(car);
            return ResponseEntity.ok("Car added successfully");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Car not added");
        }
    }

    @GetMapping("/yourCar/{id}")
    public ResponseEntity<?> getYourCarById(@RequestParam Long id) {
        try{
            Car car = carService.getYourCarById(id);
            return ResponseHandler.responseBuilder("Car found successfully", HttpStatus.OK, car);
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Car not found");
        }
    }

    @DeleteMapping("/yourCar/{id}")
    public ResponseEntity<?> deleteYourCarById(@PathVariable Long id) {
        try{
            carService.deleteYourCarById(id);
            return ResponseEntity.ok("Car deleted successfully");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Car not deleted");
        }
    }

    @GetMapping("/allCars")
    public ResponseEntity<?> getAllCars() {
        try{
            Iterable<Car> cars = carService.getAllCars();
            return ResponseHandler.responseBuilder("Cars found successfully", HttpStatus.OK, cars);
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Cars not found");
        }
    }

    @PutMapping("/yourCar/{id}")
    public ResponseEntity<?> updateYourCar(@PathVariable Long id, @RequestBody Car updatedCar) {
        try{
            carService.updateYourCar(id, updatedCar);
            return ResponseEntity.ok("Car updated successfully");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Car not updated");
        }
    }

}
