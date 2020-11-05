package com.ardent.springboot.project3.mycontact.service;

import com.ardent.springboot.project3.mycontact.domain.Block;
import com.ardent.springboot.project3.mycontact.domain.Person;
import com.ardent.springboot.project3.mycontact.repository.BlockRepository;
import com.ardent.springboot.project3.mycontact.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

@SpringBootTest
class PersonServiceTest {

    @Autowired
    private PersonService personService;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private BlockRepository blockRepository;

    @Test
    void getPeopleExcludeBlocks(){
        givenPeople();
        givenBlocks();

        List<Person> myList = personService.getPeopleExcludeBlocks();

        myList.forEach(System.out::println);
    }

    private void givenBlocks() {
        givenBlock("aa");
    }

    private Block givenBlock(String name) {
        return blockRepository.save(Block.builder().name(name).build());
    }

    private void givenPeople(){
        givenPerson("aa",10,"A");
        givenPerson("bb",20,"O");
        givenPerson("cc",21,"O");
        givenPerson("dd",20,"O");
        givenPerson("ee",24,"O");
        givenPerson("ff",22,"O");
        givenBlockPerson("aa",10,"A");
    }

    private void givenPerson(String name, int age, String bloodType) {
        personRepository.save(Person.builder()
        .name(name)
        .age(age)
        .bloodType(bloodType).build());
    }

    private void givenBlockPerson(String name, int age, String bloodType){
        Person blockPerson = new Person(name, age, bloodType);
        blockPerson.setBlock(givenBlock(name));
        personRepository.save(blockPerson);
    }

}