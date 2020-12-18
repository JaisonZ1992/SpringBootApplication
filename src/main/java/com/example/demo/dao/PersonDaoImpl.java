package com.example.demo.dao;

import com.example.demo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("first")
public class PersonDaoImpl implements PersonDao{
    static List<Person> personList = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        personList.add(new Person(id,person.getName()));
        return 1;
    }

    @Override
    public List<Person> getAllPersons() {
        return personList;
    }
}
