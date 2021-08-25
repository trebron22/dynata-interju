package com.dynata.cars.service;

import com.dynata.cars.controllers.dto.response.GeneratedEmailsResponse;
import com.dynata.cars.dao.PersonEntity;

import java.util.Set;

public interface EmailGeneratorService {

    GeneratedEmailsResponse generateEmails();
}
