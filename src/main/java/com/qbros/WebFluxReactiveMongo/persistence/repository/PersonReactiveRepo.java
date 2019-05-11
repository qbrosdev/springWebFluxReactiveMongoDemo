package com.qbros.WebFluxReactiveMongo.persistence.repository;

import com.qbros.WebFluxReactiveMongo.persistence.model.Person;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by V.Ghasemi
 * on 5/11/2019.
 */
@Repository
public interface PersonReactiveRepo extends ReactiveMongoRepository<Person,Integer>{
}
