package com.ardent.springboot.project3.mycontact.service;

import com.ardent.springboot.project3.mycontact.domain.Person;
import com.ardent.springboot.project3.mycontact.domain.dto.Birthday;
import com.ardent.springboot.project3.mycontact.repository.PersonRepository;
import org.apache.tomcat.jni.Local;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.*;
@Transactional
@SpringBootTest
class PersonServiceTest {

    @Autowired
    private PersonService personService;

    @Test
    void getPerson(){
        Person person = personService.getPerson(4L);
        assertThat(person.getName()).isEqualTo("dd");
    }

    @Test
    void getPersonByName(){
        List<Person> persons = personService.getPeopleByName("aa");
        assertThat(persons.size()).isEqualTo(1);
    }
}