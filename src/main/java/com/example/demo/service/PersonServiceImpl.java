package com.example.demo.service;

import com.example.demo.exception.EntityNotFoundException;
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
    public Person getPersonById(Long id) throws EntityNotFoundException{
        return personRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(Person.class, "id", id.toString()));
    }

    @Override
    public void deletePersonById(Long id) {
        Optional<Person> person = personRepository.findById(id);
        if(person.isPresent()) {
            personRepository.deleteById(id);
        }else {
            throw new EntityNotFoundException(Person.class, "id", id.toString());
        }
    }

    @Override
    public Person updatePersonById(Long id, Person newPerson) throws EntityNotFoundException{
        Optional<Person> person = personRepository.findById(id);
        //TODO Many to Many tables getting deleted on Delete by Id,
        // merge existing items with new items,
        // new Ids generated instead of updating existing ones for mapped tables
        if(person.isPresent()){
            newPerson.setId(id);
            newPerson.getOrders().forEach(d -> d.setPerson(newPerson));
            newPerson.getAssociatedGroups().forEach(d -> d.getMembers().add(newPerson));
            return personRepository.save(newPerson);
        }else {
            throw new EntityNotFoundException(Person.class, "id", id.toString());
        }
    }
}
