package com.films4you.req3;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RequirementTest {

	@Test
	public void testRequirementGetActual() {
		Requirement r = new Requirement();
		assertEquals("ELEANOR HUNT", r.getValueAsString());
	}

	@Test
	public void testRequirementGetHumanReadable() {
		Requirement r = new Requirement();
		assertEquals("The most frequent renter is Eleanor Hunt", r.getHumanReadable());
	}
}
