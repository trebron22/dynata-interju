package com.dynata.cars.dao;

import lombok.*;
import javax.persistence.*;
import java.util.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "Cars")
public class CarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "car_id")
    private Integer id;

    private String brand;
    private String type;
    private String plateNumber;
    private Integer yearOfManufacture;
    private Integer calculatedValue;
    private Integer drivenDistance;
    private Boolean isSent;
    @ToString.Exclude
    @ManyToMany(mappedBy = "cars")
    private Set<PersonEntity> personEntities = new HashSet<>();

}
