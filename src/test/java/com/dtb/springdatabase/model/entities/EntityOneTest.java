package com.dtb.springdatabase.model.entities;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

import com.dtb.springdatabase.model.entities.acossiative.OneToTwo;

public class EntityOneTest {
	@Test
	public void testHashSet() {
		EntityOne one = EntityOne.builder().id(1).name("One 1").build();
		EntityTwo two = EntityTwo.builder().id(1).name("One 2").build();
		
		OneToTwo associativeOne = OneToTwo.builder().id(1).one(one).two(two).build();
		OneToTwo associativeTwo = OneToTwo.builder().id(2).one(EntityOne.builder().id(1).build()).two(EntityTwo.builder().id(1).build()).build();
		
		one.getTwos().addAll(Arrays.asList(associativeOne, associativeTwo));
		
		assertTrue(one.getTwos().size() == 1);
	}
}
