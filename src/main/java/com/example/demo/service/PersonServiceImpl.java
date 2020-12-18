package com.example.demo.service;

import com.example.demo.dao.PersonDao;
import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service("second")
public class PersonServiceImpl implements PersonService{

    private final PersonDao personDao;

    @Autowired
    public PersonServiceImpl(@Qualifier("first") PersonDao personDao) {
        this.personDao = personDao;
    }

    @Override
    public int addPerson(Person person){
        return personDao.insertPerson(person);
    }

    @Override
    public List<Person> getAllPersons(){
        return personDao.getAllPersons();
    }

    @Override
    public Person getPersonById(UUID id) {
        return personDao.getPersonById(id).orElse(null);
    }

    @Override
    public int deletePersonById(UUID id) {
        return personDao.deletePerson(id);
    }

    @Override
    public int updatePersonById(UUID id, Person person) {
        return personDao.updatePerson(id,person);
    }
}
