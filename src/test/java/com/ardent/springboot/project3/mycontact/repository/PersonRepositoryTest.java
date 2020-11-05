package com.ardent.springboot.project3.mycontact.repository;

import com.ardent.springboot.project3.mycontact.domain.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class PersonRepositoryTest {
    @Autowired
    private PersonRepository personRepository;
    @Test
    void crud(){
//        Person person = new Person();
        Person person = Person.builder()
                        .id(1L)
                        .age(30)
                        .name("gildong")
                        .bloodType("O")
                        .build();

        personRepository.save(person);

        System.out.println(personRepository.findAll());

        List<Person> persons = personRepository.findAll();

        assertThat(persons.size()).isEqualTo(1);
        assertThat(persons.get(0).getId()).isEqualTo(1);
    }

    @Test
    void hashCodeAndEquals(){
        System.out.println();
    }
}