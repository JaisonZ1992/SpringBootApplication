package com.example.demo.service;

import com.example.demo.entity.Person;

import java.util.List;

public interface PersonService {
    Person addPerson(Person person);

    List<Person> getAllPersons();

    Person getPersonById(Long id);

    void deletePersonById(Long id);

    Person updatePersonById(Long id, Person person);
}
