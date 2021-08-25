package com.dynata.cars.dao;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="Email_templates")
public class EmailTemplateEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="language_id")
    private Integer languageId;
    private String text;

}
