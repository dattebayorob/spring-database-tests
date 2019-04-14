package com.dtb.springdatabase.model.repositories.dbone;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dtb.springdatabase.model.entities.People;
import com.dtb.springdatabase.model.repositories.dbone.PeopleRepository;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PeopleRepositoryTest {
	private static final Logger log = LoggerFactory.getLogger(PeopleRepositoryTest.class);
	@Autowired
	private PeopleRepository repository;
	
	@Before
	public void init() {
		log.info("Init tests");
	}
	
	@Test
	public void testFindAll() {
		List<People> peoples = repository.findAll();
		peoples.forEach(p -> log.info("Name: {}",p.getName()));
		assertNotNull(peoples);
		assertFalse(peoples.isEmpty());
	}
	
}
