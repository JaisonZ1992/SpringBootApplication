package com.example.demo.service;

import com.example.demo.repository.PersonRepository;
import com.example.demo.model.Person;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("personService")
public class PersonServiceImpl implements PersonService{

    private final PersonRepository personDao;

    public PersonServiceImpl(PersonRepository personDao) {
        this.personDao = personDao;
    }

    @Override
    public Person addPerson(Person person){
        return personDao.save(person);
    }

    @Override
    public List<Person> getAllPersons(){
        return personDao.findAll();
    }

    @Override
    public Person getPersonById(Long id) {
        return personDao.findById(id).orElse(null);
    }

    @Override
    public void deletePersonById(Long id) {
        personDao.deleteById(id);
    }

    @Override
    public Person updatePersonById(Long id, Person person) {
        return personDao.save(person);
    }
}
