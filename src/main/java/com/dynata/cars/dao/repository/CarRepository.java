package com.dynata.cars.dao.repository;

import com.dynata.cars.dao.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface CarRepository extends JpaRepository<CarEntity, Integer> {
    
}
