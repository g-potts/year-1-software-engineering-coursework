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
	//TODO [[unnecessary?]] test compared to sql statement
	//TODO test r1 human readable
}
