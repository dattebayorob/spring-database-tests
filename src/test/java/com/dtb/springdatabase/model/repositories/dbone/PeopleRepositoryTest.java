package com.dtb.springdatabase.model.repositories.dbone;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
	
	@Test
	public void testFindByAddressCityNameContaining() {
		List<People> peoples = repository.findByAddressCityNameContaining("taleza");
		peoples.forEach(p -> log.info("Name: {}",p.getName()));
		assertNotNull(peoples);
		assertFalse(peoples.isEmpty());
	}
	
	@Test
	@Transactional
	public void testFindByNameContainingAndWorkplaceAddressCityFederationUnityInitials() {
		log.info("findByNameContainingAndWorkplaceAddressCityFederationUnityInitials");
		People sarah = repository.findById(Long.valueOf(2)).get();
		String name = "Sarah";
		String worplaceFuInitials = "PA";
		Page<People> peoples = repository.findByNameContainingAndWorkplaceAddressCityFederationUnityInitials(name, worplaceFuInitials, PageRequest.of(0, 10));
		assertNotNull(peoples);
		assertEquals(peoples.getTotalElements(), 1);
		assertThat(peoples).contains(sarah);
	}
	@Test
	@Transactional
	public void testFindByNameAndFUInitials() {
		log.info("findByNameAndFUInitials");
		People sarah = repository.findById(Long.valueOf(2)).get();
		String name = "sarah";
		String workplaceFu = "PA";
		List<People> peoples = repository.findByNameAndFUInitials(name, workplaceFu);
		peoples.forEach(p -> System.out.println(p.getName()));
		assertNotNull(peoples);
		assertEquals(peoples.size(), 1);
		assertThat(peoples).contains(sarah);
	}
	@Test
	public void testFindByFilter() {
		log.info("testFindByFilter");
		People sarah = repository.findByIdFetch(Long.valueOf(2));
		Map<String, String> filters = new HashMap<>();
		filters.put("name", "sarah");
		filters.put("fu", "PA");
		List<People> peoples = repository.findByFilters(filters);
		assertNotNull(peoples);
		assertEquals(peoples.size(), 1);
		assertEquals(peoples.get(0).getWorkplace().getAddress().getCity().getFederationUnity().getId(),
				sarah.getWorkplace().getAddress().getCity().getFederationUnity().getId());
		assertNotNull(sarah.getAddress().getCity().getFederationUnity().getInitials());
	}
	
}
