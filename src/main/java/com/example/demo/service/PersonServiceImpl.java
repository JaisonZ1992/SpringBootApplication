package com.example.demo.service;

import com.example.demo.repository.PersonRepository;
import com.example.demo.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("personService")
public class PersonServiceImpl implements PersonService{

    private final PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personDao) {
        this.personRepository = personDao;
    }

    @Override
    public Person addPerson(Person person){
        person.getOrders().forEach(d -> d.setPerson(person));
        person.getAssociatedGroups().forEach(d -> d.getMembers().add(person));
        return personRepository.save(person);
    }

    @Override
    public List<Person> getAllPersons(){
        return personRepository.findAll();
    }

    @Override
    public Person getPersonById(Long id) {
        return personRepository.findById(id).orElse(null);
    }

    @Override
    public void deletePersonById(Long id) {
        personRepository.deleteById(id);
    }

    @Override
    public Person updatePersonById(Long id, Person newPerson) {
        Optional<Person> person = personRepository.findById(id);
        //TODO Many to Many tables getting deleted on Delete by Id and merge exisitng items with new items
        if(person.isPresent()){
            newPerson.setId(id);
            newPerson.getOrders().forEach(d -> d.setPerson(newPerson));
            newPerson.getAssociatedGroups().forEach(d -> d.getMembers().add(newPerson));
            return personRepository.save(newPerson);
        }else {
            return null;
        }
    }
}
