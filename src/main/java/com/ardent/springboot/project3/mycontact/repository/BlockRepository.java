package com.ardent.springboot.project3.mycontact.repository;

import com.ardent.springboot.project3.mycontact.domain.Block;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface BlockRepository extends JpaRepository<Block, Long> {
}
