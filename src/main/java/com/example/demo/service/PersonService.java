package com.example.demo.service;

import com.example.demo.model.Person;

import java.util.List;
import java.util.UUID;

public interface PersonService {
    int addPerson(Person person);

    List<Person> getAllPersons();

    Person getPersonById(UUID id);

    int deletePersonById(UUID id);

    int updatePersonById(UUID id, Person person);
}
