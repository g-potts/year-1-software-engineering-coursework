package com.films4you.req1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RequirementTest {

	/**
	 * A sample test. You'll need to test your solution properly.
	 */
	// test on req 1
	@Test
	public void testRequirementGetActual() {
		Requirement r = new Requirement();
		assertEquals("599", r.getValueAsString());
	}

}
