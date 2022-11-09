package com.example.reactivebaeldung.handler;

import com.example.reactivebaeldung.dao.PersonDao;
import com.example.reactivebaeldung.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PersonStreamHandler {

    @Autowired
    private PersonDao personDao;

    public Mono<ServerResponse> loadPeople(ServerRequest request) {
        Flux<Person> personsStream = personDao.getPeopleStream();
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(personsStream, Person.class);
    }
}