package com.example.demo.controller;

import com.example.demo.dto.PersonDetailDto;
import com.example.demo.dto.PersonDto;
import com.example.demo.entity.Person;
import com.example.demo.service.PersonService;
import com.example.demo.utils.DtoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
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
    public PersonDetailDto addPerson(@NonNull @RequestBody PersonDetailDto person) throws ParseException {
        Person person1 = DtoConverter.convertToEntity(person);
        return DtoConverter.convertToDto(personService.addPerson(person1));
    }

    @GetMapping
    public List<PersonDto> getAllPersons(){
        return DtoConverter.convertToDto(personService.getAllPersons());
    }

    @GetMapping(path = {"{id}"})
    public PersonDetailDto getPersonById(@PathVariable("id") Long id){
        return DtoConverter.convertToDto(personService.getPersonById(id));
    }

    @PutMapping(path = {"{id}"})
    public PersonDetailDto updatePerson(@PathVariable("id") Long id, @NonNull @RequestBody PersonDetailDto person) throws ParseException {
        return DtoConverter.convertToDto(personService.updatePersonById(id,DtoConverter.convertToEntity(person)));
    }

    @DeleteMapping(path = {"{id}"})
    public void deletePerson(@PathVariable("id") Long id){
        personService.deletePersonById(id);
    }
}
