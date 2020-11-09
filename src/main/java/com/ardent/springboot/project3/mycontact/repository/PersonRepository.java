package com.ardent.springboot.project3.mycontact.repository;

import com.ardent.springboot.project3.mycontact.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.*;

/**자동으로 Repository Bean 등록*/
public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findByName(String name);

    @Query(value = "select * from person where month_of_birthday = :monthOfBirthday", nativeQuery = true)
    List<Person> findByMonthOfBirthday(@Param("monthOfBirthday") int monthOfBirthday);

    @Query(value=" select * from person where person.deleted = 1", nativeQuery = true)
    List<Person> findDeletedPerson();
}
