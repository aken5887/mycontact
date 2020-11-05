package com.ardent.springboot.project3.mycontact.repository;

import com.ardent.springboot.project3.mycontact.domain.Block;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

@SpringBootTest
class BlockRepositoryTest {

    @Autowired
    private BlockRepository blockRepository;

    @Test
    void crud(){
      Block block = Block.builder()
              .name("ww")
              .reason("친하지않음")
              .startDate(LocalDate.now())
              .endDate(LocalDate.now())
              .build();

      blockRepository.save(block);

      List<Block> blocks = blockRepository.findAll();
      assertThat(blocks.size()).isEqualTo(1);
      assertThat(blocks.get(0).getName()).isEqualTo("ww");
    }
}