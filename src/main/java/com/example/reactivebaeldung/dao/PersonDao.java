package com.example.reactivebaeldung.dao;

import com.example.reactivebaeldung.model.Person;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Component
public class PersonDao {

    public Flux<Person> getPeopleStream() {
        return Flux.range(1, 40)
                .delayElements(Duration.ofSeconds(1))
                .doOnNext(i -> System.out.println("processing count in stream flow : " + i))
                .map(i -> new Person(i, "person" + i));

    }

}