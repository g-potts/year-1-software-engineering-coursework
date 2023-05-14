package com.films4you.req1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RequirementTest {

	@Test
	public void testRequirementGetActual() {
		Requirement r = new Requirement();
		assertEquals("599", r.getValueAsString());
	}
	
	@Test
	public void testRequirementGetHumanReadable() {
		Requirement r = new Requirement();
		assertEquals("Total number of customers in database: 599", r.getHumanReadable());
	}
}
