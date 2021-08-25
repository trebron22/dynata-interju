package com.dynata.cars.service;

import com.dynata.cars.dao.CarEntity;
import java.util.Set;

public interface PersonService {

    Set<CarEntity> findCarsByPersonId(Integer id);
}
