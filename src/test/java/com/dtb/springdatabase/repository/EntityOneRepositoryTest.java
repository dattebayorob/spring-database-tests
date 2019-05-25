package com.dtb.springdatabase.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.dtb.springdatabase.model.entities.EntityOne;
import com.dtb.springdatabase.model.entities.EntityTwo;
import com.dtb.springdatabase.model.entities.acossiative.OneToTwo;

@SpringBootTest
@RunWith(SpringRunner.class)
public class EntityOneRepositoryTest {
	@Autowired
	EntityOneRepository repository;
	
	@Test
	public void testFindAll() {
		List<EntityOne> ones = repository.findAll();
		assertNotNull(ones);
		assertTrue(ones.size() > 1);
	}
	
	@Transactional
	@Rollback(value = false)
	@Test
	public void testUpdateAssoatives() {
		EntityOne one = EntityOne.builder().id(1).name("One 1").build();
		EntityTwo two = EntityTwo.builder().id(1).name("One 2").build();
		
		OneToTwo associativeOne = OneToTwo.builder().id(1).one(one).two(two).build();
		OneToTwo associativeTwo = OneToTwo.builder().id(2).one(EntityOne.builder().id(1).build()).two(EntityTwo.builder().id(1).build()).build();
		
		
		assertNotNull(one.getId());
		
		EntityOne persisted = repository.findById(1).get();
		
		persisted.getTwos().addAll(Arrays.asList(associativeOne,associativeTwo));
		
		assertTrue(persisted.getTwos().size() == 1);
		
		repository.save(one);
	}
	
	@Transactional
	@Test
	public void testSaveAEntityAndAssociatives() {
		EntityOne one = EntityOne.builder().name("One Persisted On Test").build();
		EntityTwo two = EntityTwo.builder().id(1).build();
		EntityTwo anotherTwo = EntityTwo.builder().id(2).build();
		EntityTwo otherAnotherTwo = EntityTwo.builder().id(3).build();
		
		repository.save(one);
		
		List<OneToTwo> associatives = Arrays.asList(
				OneToTwo.builder().one(one).two(two).build(),
				OneToTwo.builder().one(one).two(anotherTwo).build(),
				OneToTwo.builder().one(one).two(otherAnotherTwo).build()
				);
		
		one.getTwos().addAll(associatives);
		
		assertTrue(one.getTwos().size() == 3);
		
		repository.save(one);
		
		assertThat(one.getTwos()).first().isNotNull();

	}
	
	@Transactional
	@Test
	public void testSaveAEntityAndMultiplesAssociatives() {
		EntityOne one = EntityOne.builder().name("One Persisted On Test").build();
		EntityTwo two = EntityTwo.builder().id(1).build();
		EntityTwo anotherTwo = EntityTwo.builder().id(1).build();
		EntityTwo otherAnotherTwo = EntityTwo.builder().id(1).build();
		
		repository.save(one);
		
		List<OneToTwo> associatives = Arrays.asList(
				OneToTwo.builder().one(one).two(two).build(),
				OneToTwo.builder().one(one).two(anotherTwo).build(),
				OneToTwo.builder().one(one).two(otherAnotherTwo).build()
				);
		
		one.getTwos().addAll(associatives);
		
		assertTrue(one.getTwos().size() == 1);
		
		repository.save(one);
		
		assertThat(one.getTwos()).first().isNotNull();

	}
	
}
