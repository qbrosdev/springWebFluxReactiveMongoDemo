package com.qbros.WebFluxReactiveMongo.controller.dto;

import com.qbros.WebFluxReactiveMongo.persistence.model.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created by V.Ghasemi
 * on 5/11/2019.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PersonEventDTO {

    private Person person;
    private Date date;
}
