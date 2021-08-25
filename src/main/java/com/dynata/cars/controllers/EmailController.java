package com.dynata.cars.controllers;

import com.dynata.cars.controllers.dto.response.GeneratedEmailsResponse;
import com.dynata.cars.service.EmailGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emails")
public class EmailController {

    EmailGeneratorService emailGeneratorService;

    @GetMapping(value = "")
    public GeneratedEmailsResponse generatedEmailsResponse() {
        return emailGeneratorService.generateEmails();
    }

    @Autowired
    public void setEmailGeneratorService(EmailGeneratorService emailGeneratorService) {
        this.emailGeneratorService = emailGeneratorService;
    }
}
