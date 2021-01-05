package com.example.demo.controller;

import com.example.demo.dto.PersonDetailDto;
import com.example.demo.dto.PersonDto;
import com.example.demo.dto.Response;
import com.example.demo.service.PersonService;
import com.example.demo.utils.DtoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public ResponseEntity<Response<PersonDetailDto>> addPerson(@Valid @RequestBody PersonDetailDto person){
        PersonDetailDto newPerson = DtoConverter.convertToDto(personService.addPerson(DtoConverter.convertToEntity(person)));
        return new ResponseEntity<>(new Response<>("success", "Person Added", newPerson),HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Response<List<PersonDto>>> getAllPersons(){
        List<PersonDto> personList = DtoConverter.convertToDto(personService.getAllPersons());
        return new ResponseEntity<>(new Response<>("success", "List of persons", personList),HttpStatus.OK);
    }

    @GetMapping(path = {"{id}"})
    public ResponseEntity<Response<PersonDetailDto>> getPersonById(@PathVariable("id") Long id){
        PersonDetailDto person = DtoConverter.convertToDto(personService.getPersonById(id));
        return new ResponseEntity<>(new Response<>("success", "Person Found", person),HttpStatus.OK);
    }

    @PutMapping(path = {"{id}"})
    public ResponseEntity<Response<PersonDetailDto>> updatePerson(@PathVariable("id") Long id, @Valid @RequestBody PersonDetailDto person){
        PersonDetailDto updatedPerson = DtoConverter.convertToDto(personService.updatePersonById(id,DtoConverter.convertToEntity(person)));
        return new ResponseEntity<>(new Response<>("success", "Person Updated", updatedPerson),HttpStatus.OK);
    }

    @DeleteMapping(path = {"{id}"})
    public ResponseEntity<Response<PersonDetailDto>> deletePerson(@PathVariable("id") Long id){
        personService.deletePersonById(id);
        return new ResponseEntity<>(new Response<>("success", "Person deleted"),HttpStatus.OK);
    }
}
