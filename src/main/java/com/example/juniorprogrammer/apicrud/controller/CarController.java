package com.example.juniorprogrammer.apicrud.controller;

import com.example.juniorprogrammer.apicrud.entities.CarEntity;
import com.example.juniorprogrammer.apicrud.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/car")
public class CarController {

    @Autowired
    CarRepository carRepository;

    @GetMapping(value = "checkAPI")
    public String checkAPI() {
        return "Hello World";
    }

    @PostMapping(value = "addNewCar")
    public CarEntity addNewCar(@RequestBody CarEntity param){
        carRepository.save(param);
        return param;
    }

    @GetMapping(value = "getAllCar")
    public List<CarEntity> getAllCar(){
        return carRepository.findAll();
    }

    @GetMapping(value = "getById")
    public CarEntity getById(@RequestParam int id){
        return carRepository.findById(id).get();
    }
}
