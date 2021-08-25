package com.dynata.cars.controllers;

import com.dynata.cars.dao.CarEntity;
import com.dynata.cars.service.CarService;
import com.dynata.cars.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/persons")
public class PersonController {
    PersonService personService;

    @GetMapping(value = "/{id}")
    public Set<CarEntity> findById(@PathVariable("id") Integer id) {
        return personService.findCarsByPersonId(id);
    }

    @Autowired
    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }
}
