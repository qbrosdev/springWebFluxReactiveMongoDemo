package com.qbros.WebFluxReactiveMongo.controller;

import com.qbros.WebFluxReactiveMongo.controller.dto.PersonEventDTO;
import com.qbros.WebFluxReactiveMongo.persistence.model.Person;
import com.qbros.WebFluxReactiveMongo.persistence.repository.PersonReactiveRepo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.time.Duration;
import java.util.Date;
import java.util.stream.Stream;

/**
 * Created by V.Ghasemi
 * on 5/11/2019.
 */
@Data
@AllArgsConstructor(onConstructor = @__(@Autowired)) //https://www.baeldung.com/spring-injection-lombok
@RestController
@RequestMapping("/persons")
public class PersonAPI {

    private PersonReactiveRepo personReactiveRepo;

    @GetMapping
    public Flux<Person> getAll() {
        return personReactiveRepo.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Person> getId(@PathVariable("id") final Integer personId) {
        return personReactiveRepo.findById(personId);
    }

    @GetMapping(value = "/{id}/events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<PersonEventDTO> getEvents(@PathVariable("id") final Integer personId) {
        return personReactiveRepo.findById(personId).flatMapMany(employee -> {
            Flux<Long> interval = Flux.interval(Duration.ofSeconds(2));
            Flux<PersonEventDTO> employeeEventFlux = Flux.fromStream(Stream.generate(() -> new PersonEventDTO(employee, new Date())));
            return Flux.zip(interval, employeeEventFlux).map(Tuple2::getT2);
        });
    }
}
