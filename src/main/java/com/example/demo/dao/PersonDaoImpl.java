package com.example.demo.dao;

import com.example.demo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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

    @Override
    public Optional<Person> getPersonById(UUID id) {
        return personList.stream()
                .filter(person -> person.getId().equals(id))
                .findFirst();
    }

    @Override
    public int updatePerson(UUID id, Person newPerson) {
        return getPersonById(id).map(person -> {
            int index = personList.indexOf(person);
            personList.set(index,newPerson);
            return 1;
        }).orElse(1);
    }

    @Override
    public int deletePerson(UUID id) {
        Optional<Person> person = getPersonById(id);
        if(person.isPresent()){
            personList.remove(person.get());
            return 1;
        }
        return 0;
    }
}
