package com.operazionicrud.operazionicrud.services;

import com.operazionicrud.operazionicrud.DAO.CarDAO;
import com.operazionicrud.operazionicrud.entities.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    @Autowired
    private CarDAO carDAO;

    public Car addCar(Car car) {
        Car newCar = carDAO.save(car);
        return newCar;
    }

    public Car getCarById(Long id) {
        Car car = carDAO.findById(id).orElse(null);
        return car;
    }

    public List<Car> getAllCar() {
        List<Car> carList = carDAO.findAll();
        return carList;
    }

    public Car editCar(Long id, Car car) {
        Car carSaved = carDAO.findById(id).orElse(null);
        carSaved.setType(car.getType());
        carSaved.setModelName(car.getModelName());
        Car carEdited = carDAO.save(carSaved);
        return carEdited;
    }

    public HttpStatus deleteById(Long id) {
        if (carDAO.existsById(id)) {
            carDAO.deleteById(id);
            return HttpStatus.ACCEPTED;
        } else {
            return HttpStatus.CONFLICT;
        }
    }
    public void deleteAllCar(){
        carDAO.deleteAll();
    }
}
