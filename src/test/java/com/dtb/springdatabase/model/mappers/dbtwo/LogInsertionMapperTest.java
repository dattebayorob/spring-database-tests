package com.dtb.springdatabase.model.mappers.dbtwo;

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

import com.dtb.springdatabase.model.vos.LogInsertionVO;

@SpringBootTest
@RunWith(SpringRunner.class)
public class LogInsertionMapperTest {
	private static final Logger log = LoggerFactory.getLogger(LogInsertionMapperTest.class);
	@Autowired
	private LogInsertionMapper mapper;
	
	@Before
	public void init() {
		log.info("Init tests");
	}
	@Test
	public void testFindAll() {
		List<LogInsertionVO> insertions = mapper.findAll();
		insertions.forEach(l -> log.info(l.toString()));
		assertNotNull(insertions);
	}
}
