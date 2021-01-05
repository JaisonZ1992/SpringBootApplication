package com.example.demo.utils;

import com.example.demo.dto.PersonDetailDto;
import com.example.demo.dto.PersonDto;
import com.example.demo.entity.Person;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.text.ParseException;
import java.util.List;

public class DtoConverter {

    public static PersonDetailDto convertToDto(Person person) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(person, PersonDetailDto.class);
    }

    public static Person convertToEntity(PersonDetailDto personDto){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(personDto, Person.class);
    }

    public static List<PersonDto> convertToDto(List<Person> personSet) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(personSet, new TypeToken<List<PersonDto>>() {}.getType());
    }
}
