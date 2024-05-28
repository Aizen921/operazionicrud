package com.operazionicrud.operazionicrud.controllers;

import com.operazionicrud.operazionicrud.entities.Car;
import com.operazionicrud.operazionicrud.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/car")
public class CarController {
    @Autowired
    private CarService carService;

    @PostMapping("/")
    public ResponseEntity<Car> createCar(@RequestBody Car car) {
        try {
            Car newCar = carService.addCar(car);
            return ResponseEntity.ok().body(car);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> findCarById(@PathVariable Long id) {
        try {
            Car car = carService.getCarById(id);
            return ResponseEntity.ok().body(car);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
    @GetMapping("/list")
    public List<Car> carList(){
        return carService.getAllCar();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Car> editCar(@PathVariable Long id, @RequestBody Car car){
        try{
            carService.editCar(id, car);
            return ResponseEntity.ok().body(car);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(null);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Car> deleteCarById(@PathVariable Long id) {
        try {
            carService.deleteById(id);
            return ResponseEntity.ok().body(null);
        }catch(Exception e){
            return ResponseEntity.badRequest().body(null);
        }
    }
    @DeleteMapping("/list")
    public void deleteCarList(){
        carService.deleteAllCar();
    }

}
