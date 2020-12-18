package com.example.demo.controller;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/person")
@RestController
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(@Qualifier("personService") PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public Person addPerson(@NonNull @RequestBody Person person){
        return personService.addPerson(person);
    }

    @GetMapping
    public List<Person> getAllPersons(){
        return personService.getAllPersons();
    }

    @GetMapping(path = {"{id}"})
    public Person getPersonById(@PathVariable("id") Long id){
        return personService.getPersonById(id);
    }

    @PutMapping(path = {"{id}"})
    public Person updatePerson(@PathVariable("id") Long id,@NonNull @RequestBody Person person){
        return personService.updatePersonById(id,person);
    }

    @DeleteMapping(path = {"{id}"})
    public void deletePerson(@PathVariable("id") Long id){
        personService.deletePersonById(id);
    }
}
