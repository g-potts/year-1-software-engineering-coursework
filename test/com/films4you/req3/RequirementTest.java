package com.films4you.req3;

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
		assertEquals("ELEANOR HUNT", r.getValueAsString());
	}
	// TODO [[r??]]test check against sql statement
	
	// TODO [[done]] test invalid fullname
	@Test(expected = IllegalArgumentException.class)
	public void testCustomerInvalidFullname() {
		Customer c = new Customer("Name", 123);
	}
	
	// TODO [[done]] test bad customer id
	@Test(expected = IllegalArgumentException.class)
	public void testCustomerInvalidID() {
		Customer c = new Customer("Name Surname", -123);
	}
	//TODO [[done]] test get human readable
	@Test
	public void testRequirementGetHumanReadable() {
		Requirement r = new Requirement();
		assertEquals("The most frequent renter is Eleanor Hunt", r.getHumanReadable());
	}
}
