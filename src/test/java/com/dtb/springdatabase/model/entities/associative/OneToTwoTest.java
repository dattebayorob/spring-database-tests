package com.dtb.springdatabase.model.entities.associative;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.dtb.springdatabase.model.entities.EntityOne;
import com.dtb.springdatabase.model.entities.EntityTwo;
import com.dtb.springdatabase.model.entities.acossiative.OneToTwo;

public class OneToTwoTest {
	
	@Test
	public void testEquals() {
		EntityOne one = EntityOne.builder().id(1).name("One 1").build();
		EntityTwo two = EntityTwo.builder().id(1).name("One 2").build();
		
		OneToTwo associativeOne = OneToTwo.builder().id(1).one(one).two(two).build();
		OneToTwo associativeTwo = OneToTwo.builder().id(2).one(EntityOne.builder().id(1).build()).two(EntityTwo.builder().id(1).build()).build();
		
		assertTrue(associativeOne.equals(associativeTwo));
	}
}
