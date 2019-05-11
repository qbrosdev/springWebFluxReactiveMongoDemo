package com.qbros.WebFluxReactiveMongo.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by V.Ghasemi
 * on 5/11/2019.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Person {

    @Id
    int id;
    String name;
    int age;
}
