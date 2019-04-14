package com.dtb.springdatabase.model.mappers.dbone;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dtb.springdatabase.model.mappers.dbone.PeopleMapper;
import com.dtb.springdatabase.model.vos.PeopleVO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PeopleMapperTest {
	
	private static final Logger log = LoggerFactory.getLogger(PeopleMapperTest.class);
	
	@Autowired
	private PeopleMapper mapper;
	
	@Before
	public void init() {
		log.info("Running Tests");
	}
	
	@Test
	public void testFindByAddressCityName() {
		List<PeopleVO> peoples = mapper.findByAdressCityName("taleza");
		peoples.forEach(p -> log.info(p.toString()));
		assertNotNull(peoples);
		assertTrue(peoples.size() > 0);
	}

}
