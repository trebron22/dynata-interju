package com.dynata.cars.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Builder
@Table(name="Person_data")
public class PersonEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="person_id")
    private Integer id;
    private String name;
    @Column(name="data_of_birht")
    private LocalDate dateOfBirht;
    private String country;

    @ToString.Exclude
    @ManyToMany
    @JsonIgnore
    @JoinTable(
            name = "cars_of_people",
            joinColumns = @JoinColumn(name = "person_id", referencedColumnName = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "car_id", referencedColumnName = "car_id"))
    private Set<CarEntity> cars = new HashSet<>();

    @OneToOne
    @JoinColumn(name = "language_id", referencedColumnName = "language_id")
    private EmailTemplateEntity emailTemplateEntity;



}
