package com.dtb.springdatabase.model.repositories.dbtwo;

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

import com.dtb.springdatabase.model.entities.LogInsertion;
import com.dtb.springdatabase.model.repositories.dbtwo.LogInsertionRepository;

@SpringBootTest
@RunWith(SpringRunner.class)
public class LogInsertionRepositoryTest {
	private static final Logger log = LoggerFactory.getLogger(LogInsertionRepositoryTest.class);
	@Autowired
	LogInsertionRepository repository;
	
	@Before
	public void init() {
		log.info("Init tests.");
	}
	
	@Test
	public void testFindAll() {
		List<LogInsertion> logs = repository.findAll();
		logs.forEach(l -> log.info("Log of Insertions: {}",l));
		assertNotNull(logs);
		assertFalse(logs.isEmpty());
	}
}
