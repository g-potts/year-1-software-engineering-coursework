package com.films4you.req2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RequirementTest {

	/**
	 * A sample test. You'll need to test your solution properly.
	 */
	//test req 2
	@Test
	public void testRequirementGetActual() {
		Requirement r = new Requirement();
		assertEquals("???", r.getValueAsString());
	}
	
	//test it gives 10 values
	//test they are in descending order

}
