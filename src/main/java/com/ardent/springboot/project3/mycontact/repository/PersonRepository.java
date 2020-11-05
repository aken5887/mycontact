package com.ardent.springboot.project3.mycontact.repository;

import com.ardent.springboot.project3.mycontact.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**자동으로 Repository Bean 등록*/
public interface PersonRepository extends JpaRepository<Person, Long> {

}
