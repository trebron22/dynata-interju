package com.dynata.cars.service;

import com.dynata.cars.dao.CarEntity;
import com.dynata.cars.dao.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService{

    CarRepository carRepository;

    @Cacheable("carEntity")
    @Override
    public CarEntity findById(Integer id) {
        return carRepository.findById(id).orElse(new CarEntity());
    }

    @Autowired
    public void setCarRepository(CarRepository carRepository) {
        this.carRepository = carRepository;
    }
}
