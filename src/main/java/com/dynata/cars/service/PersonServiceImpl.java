package com.dynata.cars.service;

import com.dynata.cars.dao.CarEntity;
import com.dynata.cars.dao.PersonEntity;
import com.dynata.cars.dao.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Service
public class PersonServiceImpl implements PersonService{
    private PersonRepository personRepository;


    @Autowired
    public void setPersonRepository(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Cacheable("carEntities")
    @Override
    public Set<CarEntity> findCarsByPersonId(Integer id) {
        PersonEntity personEntity = personRepository.findById(id).orElse(new PersonEntity());
        return personEntity.getCars();
    }

    @Override
    @Cacheable("PersonEntitiesForEmailGeneration")
    public Set<PersonEntity> getPersonEntitiesForEmailGeneration() {
        return personRepository.findALLByCars_CalculatedValueGreaterThanAndCars_isSent();
    }
}
