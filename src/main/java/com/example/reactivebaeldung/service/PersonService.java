package com.example.reactivebaeldung.service;

import com.example.reactivebaeldung.dao.PersonDao;
import com.example.reactivebaeldung.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class PersonService {
    @Autowired
    private PersonDao dao;

    public Flux<Person> loadAllPeopleStream() {
        return dao.getPeopleStream();
    }
}
