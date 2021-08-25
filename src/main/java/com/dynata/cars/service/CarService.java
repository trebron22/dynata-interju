package com.dynata.cars.service;

import com.dynata.cars.dao.CarEntity;

public interface CarService {

    CarEntity findById(Integer id);
}
