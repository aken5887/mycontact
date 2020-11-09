package com.ardent.springboot.project3.mycontact.repository;

import com.ardent.springboot.project3.mycontact.domain.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/*@Sql("/data.sql")*/
@SpringBootTest
class PersonRepositoryTest {
    @Autowired
    private PersonRepository personRepository;
    @Test
    void crud(){
        Person param = Person.builder()
                        .name("gildong")
                        .build();

        personRepository.save(param);

        List<Person> persons = personRepository.findByName("gildong");

        persons.forEach(System.out::println);

        List<Person> newPerson = personRepository.findAll();

        newPerson.forEach(System.out::println);

        assertThat(newPerson.size()).isEqualTo(7);
        assertThat(newPerson.get(0).getId()).isEqualTo(1);
        assertThat(newPerson.get(0).getName()).isEqualTo("aa");
    }

    @Test
    void findByBirthday(){
        List<Person> persons = personRepository.findByMonthOfBirthday(10);
        assertThat(persons.size()).isEqualTo(6);
    }
}