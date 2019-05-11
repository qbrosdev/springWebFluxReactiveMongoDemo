package com.qbros.WebFluxReactiveMongo.springstruff;

import com.qbros.WebFluxReactiveMongo.persistence.model.Person;
import com.qbros.WebFluxReactiveMongo.persistence.repository.PersonReactiveRepo;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.stream.IntStream;

/**
 * Created by V.Ghasemi
 * on 5/11/2019.
 */
@AllArgsConstructor
@Component
public class Init implements CommandLineRunner {

    private PersonReactiveRepo personReactiveRepo;

    @Override
    public void run(String... args) throws Exception {
        personReactiveRepo.deleteAll()
                .subscribe(null, null, () -> {
                    IntStream.range(1, 50)
                            .mapToObj(intx -> new Person(intx, "name", intx))
                            .peek(System.out::println)
                            .forEach(personReactiveRepo::save);
                });
        System.out.println("init finish");
    }
}
