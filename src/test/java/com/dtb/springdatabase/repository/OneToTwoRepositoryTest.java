package com.dtb.springdatabase.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.dtb.springdatabase.model.entities.EntityOne;
import com.dtb.springdatabase.model.entities.EntityTwo;
import com.dtb.springdatabase.model.entities.acossiative.OneToTwo;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OneToTwoRepositoryTest {
	@Autowired
	OneToTwoRepository repository;
	
	@After
	public void tearDown() {
		repository.deleteAll();
	}
	
	@Transactional
	@Test
	public void testDeleteByOneIdAndTwoNotIn() {
		repository.save(OneToTwo.builder().one(EntityOne.builder().id(1).build()).two(EntityTwo.builder().id(1).build()).build());
		repository.save(OneToTwo.builder().one(EntityOne.builder().id(1).build()).two(EntityTwo.builder().id(2).build()).build());
		repository.save(OneToTwo.builder().one(EntityOne.builder().id(1).build()).two(EntityTwo.builder().id(3).build()).build());
		
		assertThat(repository.count() == 3);
		
		repository.deleteByOneIdAndTwoIdNotIn(1, Arrays.asList(3));
		
		assertThat(repository.count() == 2);
		
	}
}
