package com.ardent.springboot.project3.mycontact.service;

import com.ardent.springboot.project3.mycontact.domain.Block;
import com.ardent.springboot.project3.mycontact.domain.Person;
import com.ardent.springboot.project3.mycontact.repository.BlockRepository;
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

    @Autowired
    private BlockRepository blockRepository;

    public List<Person> getPeopleExcludeBlocks(){
//        List<Person> persons = personRepository.findAll();
//        List<Block> blocks = blockRepository.findAll();
//        List<String> blockNames = blocks.stream().map(Block::getName).collect(Collectors.toList());
//        return persons.stream().filter(person -> person.getBlock() == null).collect(Collectors.toList());
        return personRepository.findByBlockIsNull();
    }

    @Transactional(readOnly = true)
    public Person getPerson(Long id){
        Person person = personRepository.findById(id).get();
        log.info(" person : {}",person);
        return person;
    }

    public List<Person> getPeopleByName(String name) {
     //   List<Person> persons = personRepository.findAll();
//        return persons.stream().filter(person -> person.getName().equals(name)).collect(Collectors.toList());f
        return personRepository.findByName(name);
    }

}
