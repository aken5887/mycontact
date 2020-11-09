package com.ardent.springboot.project3.mycontact.service;

import com.ardent.springboot.project3.mycontact.controller.dto.PersonDto;
import com.ardent.springboot.project3.mycontact.domain.Person;
import com.ardent.springboot.project3.mycontact.domain.dto.Birthday;
import com.ardent.springboot.project3.mycontact.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Transactional(readOnly = true)
    public Person getPerson(Long id){
        //Person person = personRepository.findById(id).get();
        Person person = personRepository.findById(id).orElse(null);

/*        if(person.isPresent()){
            log.info(" person : {}",person);
            return person.get();
        }else{
            return null;
        }*/
        return person;
    }

    public List<Person> getPeopleByName(String name) {
     //   List<Person> persons = personRepository.findAll();
//        return persons.stream().filter(person -> person.getName().equals(name)).collect(Collectors.toList());f
        return personRepository.findByName(name);
    }

    public void put(PersonDto personDto){
        Person person = new Person();
        person.set(personDto);
        personRepository.save(person);
    }

    @Transactional
    public void modify(Long id, PersonDto personDto) {
        Person person = personRepository.findById(id).orElseThrow(()->new RuntimeException("아이디가 존재하지 않습니다."));
        person.set(personDto);
        personRepository.save(person);
    }

    @Transactional
    public void modify(Long id, String name){
        Person person = personRepository.findById(id).orElseThrow(()->new RuntimeException("아이디가 존재하지 않습니다."));
        person.setName(name);
        personRepository.save(person);
    }

    @Transactional
    public void delete(Long id) {
        Person person = personRepository.findById(id).orElseThrow(()->new RuntimeException("아이디가 존재하지 않습니다."));
        person.setDeleted(true);
        personRepository.save(person);
    }
}
