package com.dtb.springdatabase.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

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

@SpringBootTest
@RunWith(SpringRunner.class)
public class EntityOneServiceTest {
	
	@Autowired
	EntityOneService service;
	
	@Transactional
	@Test
	public void shouldSaveAEntityOneAndAssociativesWithEntityTwo() {
		String name = "Worked Flawless";
		List<Integer> twoIds = Arrays.asList(1, 2, 3);
		
		EntityOne one = service.save(name, twoIds);
		
		assertNotNull(one.getId());
		assertThat(one.getTwos()).hasSize(3);
	}
	
	@Transactional
	@Rollback(value = false)
	@Test 
	public void shouldUpdateAEntityAndRemoveUnusedAssociativeWithEntityTwo() {
		EntityOne one = EntityOne.builder().id(23).name("Updated flawless").build();
		List<Integer> twoIds = Arrays.asList(2, 3);
		
		EntityOne saved = service.update(one, twoIds);
		
		assertNotNull(saved.getId());
		assertThat(saved.getTwos()).hasSize(2);
	}
	
	@Transactional
	@Rollback(value = false)
	@Test
	public void shouldUpdateAEntityAndAddAssociativeWithEntityTwo() {
		EntityOne one = EntityOne.builder().id(23).name("Updated flawless again").build();
		List<Integer> twoIds = Arrays.asList(2, 3, 4);
		
		EntityOne saved = service.update(one, twoIds);
		
		assertNotNull(saved.getId());
		assertThat(saved.getTwos()).hasSize(3);
	}
	
}
