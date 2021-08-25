package com.dynata.cars.service;

import com.dynata.cars.controllers.dto.response.GeneratedEmailsResponse;
import com.dynata.cars.dao.CarEntity;
import com.dynata.cars.dao.PersonEntity;
import org.apache.commons.text.StringSubstitutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
public class EmailGeneratorServiceImpl implements EmailGeneratorService {

    private PersonService personService;


    @Autowired
    public void setPersonRepository(PersonService personService) {
        this.personService = personService;
    }

    @Override
    public GeneratedEmailsResponse generateEmails() {
        GeneratedEmailsResponse generatedEmailsResponse = new GeneratedEmailsResponse();
        Set<PersonEntity> personRepositoryList = personService.getPersonEntitiesForEmailGeneration();

        for (PersonEntity personEntity : personRepositoryList) {
            StringBuilder builder = new StringBuilder();
            personEntity.setCars(personEntity.getCars());
            String templateString = personEntity.getEmailTemplateEntity().getText();
            String carLoopTemplateString = templateString.substring(templateString.indexOf("<carsLoopBegin>") + "<carsLoopBegin>".length(), templateString.indexOf("<carsLoopEnd>"));
            String personTemplateString = templateString.substring(0, templateString.indexOf("<carsLoopBegin>"));
            String greeting = templateString.substring(templateString.indexOf("<carsLoopEnd>") + "<carsLoopEnd>".length());
            Map<String, String> valuesMap = getPersonValuesMap(personEntity);
            StringSubstitutor personSubstitution = new StringSubstitutor(valuesMap, "<", ">");
            String personResolvedString = personSubstitution.replace(personTemplateString);
            builder.append(personResolvedString);
            for (CarEntity carEntity : personEntity.getCars()) {
                carEntitySubstitute(carLoopTemplateString, builder, carEntity);
            }
            builder.append(greeting);
            generatedEmailsResponse.getEmails().add(builder.toString());
        }

        return generatedEmailsResponse;
    }

    private void carEntitySubstitute(String carLoopTemplateString, StringBuilder builder, CarEntity carEntity) {
        if (isaCorrectCar(carEntity)) {
            Map<String, String> valuesMapLoop = getCarValuesMap(carEntity);
            StringSubstitutor carSubstitution = new StringSubstitutor(valuesMapLoop, "<", ">");
            String carResolvedString = carSubstitution.replace(carLoopTemplateString);
            builder.append(carResolvedString);
        }
    }

    private boolean isaCorrectCar(CarEntity carEntity) {
        return !carEntity.getIsSent() && carEntity.getCalculatedValue() > 0;
    }

    private Map<String, String> getPersonValuesMap(PersonEntity personEntity) {
        Map<String, String> valuesMap = new HashMap<>();
        valuesMap.put("name", personEntity.getName());
        valuesMap.put("country", personEntity.getCountry());
        valuesMap.put("dateOfBirth", personEntity.getDateOfBirht().toString());
        return valuesMap;
    }

    private Map<String, String> getCarValuesMap(CarEntity carEntity) {
        Map<String, String> valuesMap = new HashMap<>();
        valuesMap.put("brand", carEntity.getBrand());
        valuesMap.put("type", carEntity.getType());
        valuesMap.put("plateNumber", carEntity.getPlateNumber());
        valuesMap.put("yearOfManufacture", carEntity.getYearOfManufacture().toString());
        valuesMap.put("drivenDistance", carEntity.getDrivenDistance().toString());
        valuesMap.put("calculatedValue", carEntity.getCalculatedValue().toString());
        return valuesMap;
    }
}
