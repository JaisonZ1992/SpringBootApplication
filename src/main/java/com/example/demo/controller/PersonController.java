package com.example.demo.controller;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/api/v1/person")
@RestController
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(@Qualifier("second") PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public int addPerson(@RequestBody Person person){
        return personService.addPerson(person);
    }

    @GetMapping
    public List<Person> getAllPersons(){
        return personService.getAllPersons();
    }

    @GetMapping(path = {"{id}"})
    public Person getPersonById(@PathVariable("id") UUID id){
        return personService.getPersonById(id);
    }

    @PutMapping(path = {"{id}"})
    public int updatePerson(@PathVariable("id") UUID id,@RequestBody Person person){
        return personService.updatePersonById(id,person);
    }

    @DeleteMapping(path = {"{id}"})
    public int updatePerson(@PathVariable("id") UUID id){
        return personService.deletePersonById(id);
    }
}
