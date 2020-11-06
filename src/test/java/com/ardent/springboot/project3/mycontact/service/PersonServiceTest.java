package com.ardent.springboot.project3.mycontact.service;

import com.ardent.springboot.project3.mycontact.domain.Block;
import com.ardent.springboot.project3.mycontact.domain.Person;
import com.ardent.springboot.project3.mycontact.repository.BlockRepository;
import com.ardent.springboot.project3.mycontact.repository.PersonRepository;
import org.apache.tomcat.jni.Local;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
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
        //givenBlocks();
        List<Person> myList = personService.getPeopleExcludeBlocks();
        myList.forEach(System.out::println);
    }

/*    private void givenBlocks() {
        givenBlock("aa");
    }*/

/*    private Block givenBlock(String name) {
        return blockRepository.save(Block.builder().name(name).build());
    }*/

    private void givenPeople(){
        givenPerson("aa",10,"A");
        givenPerson("bb",20,"O");
        givenPerson("cc",21,"O");
        givenPerson("dd",20,"O");
        givenPerson("ee",24,"O");
        givenPerson("ff",22,"O");
        givenBlockPerson("aa",10,"O");
    }

    private void givenPerson(String name, int age, String bloodType) {
        personRepository.save(Person.builder()
        .name(name)
        .age(age)
        .bloodType(bloodType).build());
    }

    private void givenBlockPerson(String name, int age, String bloodType){
        Person blockPerson = new Person(name, age, bloodType);
        blockPerson.setBlock(new Block(name));
        personRepository.save(blockPerson);
    }

    @Test
    void getPerson(){
        givenPeople();
        Person person = personService.getPerson(3L);
        System.out.println(person);
    }

    @Test
    void getPersonByName(){
        givenPeople();
        List<Person> persons = personService.getPeopleByName("aa");
        persons.forEach(System.out::println);
    }

    @Test
    void findByBloodType(){
        givenPerson("aa",10,"A");
        givenPerson("ba",10,"B");
        givenPerson("oa",10,"O");
        givenPerson("aba",10,"AB");
        givenPerson("abb",10,"AB");
        List<Person> people = personRepository.findByBloodType("AB");

        people.forEach(System.out::println);
    }

    @Test
    void findByBirthDayBetween(){
        givenPerson("aa",10,"A", LocalDate.of(1992,2,12));
        givenPerson("ba",10,"B", LocalDate.of(1992,8,15));
        givenPerson("oa",10,"O", LocalDate.of(1992,1,12));
        givenPerson("aba",10,"AB", LocalDate.of(1992,8,2));
        givenPerson("abb",10,"AB", LocalDate.of(1992,4,7));

        List<Person> people = personRepository.findByBirthdayBetween(LocalDate.of(1992,8,1), LocalDate.of(1992,8,31));
        people.forEach(System.out::println);
    }
    /**
     * method overloading
     * @param name
     * @param age
     * @param bloodType
     * @param birthday
     */
    private void givenPerson(String name, int age, String bloodType, LocalDate birthday){
        personRepository.save(Person.builder()
                                    .name(name)
                                    .age(age)
                                    .bloodType(bloodType)
                                    .birthday(birthday)
                                    .build());
    }
}