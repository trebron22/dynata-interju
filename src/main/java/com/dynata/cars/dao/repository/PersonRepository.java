package com.dynata.cars.dao.repository;

import com.dynata.cars.dao.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, Integer> {

    @Query(value = "SELECT pd FROM PersonEntity pd JOIN pd.cars c where c.calculatedValue > 0 and c.isSent = false")
    Set<PersonEntity> findALLByCars_CalculatedValueGreaterThanAndCars_isSent();

}
