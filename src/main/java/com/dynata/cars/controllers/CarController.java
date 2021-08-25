package com.dynata.cars.controllers;

import com.dynata.cars.dao.CarEntity;
import com.dynata.cars.dao.PersonEntity;
import com.dynata.cars.dao.repository.CarRepository;
import com.dynata.cars.dao.repository.PersonRepository;
import com.dynata.cars.service.CarService;
import com.dynata.cars.service.EmailGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

   CarService carService;

    @GetMapping(value = "/{id}")
    public CarEntity findById(@PathVariable("id") Integer id) {
        return carService.findById(id);
    }


    @Autowired
    public void setCarService(CarService carService) {
        this.carService = carService;
    }
}
