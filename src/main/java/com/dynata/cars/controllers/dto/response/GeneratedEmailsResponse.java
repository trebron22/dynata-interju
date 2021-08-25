package com.dynata.cars.controllers.dto.response;

import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class GeneratedEmailsResponse {
   private List<String> emails = new ArrayList<>();
}
