package com.films4you.req1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RequirementTest {

	/**
	 * A sample test. You'll need to test your solution properly.
	 */
	@Test
	public void testRequirementGetActual() {
		//TODO [[done]] test get actual
		Requirement r = new Requirement();
		assertEquals("599", r.getValueAsString());
	}
	
	//TODO [[done]] test r1 human readable
	@Test
	public void testRequirementGetHumanReadable() {
		Requirement r = new Requirement();
		assertEquals("Total number of customers in database: 599", r.getHumanReadable());
	}
}
