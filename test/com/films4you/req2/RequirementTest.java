package com.films4you.req2;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

public class RequirementTest {

	/**
	 * A sample test. You'll need to test your solution properly.
	 */
	@Test
	public void testRequirementGetActual() {
		//TODO [[done]] test get actual
		Requirement r = new Requirement();
		assertEquals("KARL SEAL,221.55\n"
				+ "ELEANOR HUNT,216.54\n"
				+ "CLARA SHAW,195.58\n"
				+ "MARION SNYDER,194.61\n"
				+ "RHONDA KENNEDY,194.61\n"
				+ "TOMMY COLLAZO,186.62\n"
				+ "WESLEY BULL,177.60\n"
				+ "TIM CARY,175.61\n"
				+ "MARCIA DEAN,175.58\n"
				+ "ANA BRADLEY,174.66\n", r.getValueAsString());
	}
	
	//TODO [[??]] test against sql statement
	
	//TODO [[done]] test null constructor for payment
	@Test(expected = IllegalArgumentException.class)
	public void testPaymentConstructorInvalidID() {
		Payment p = new Payment(-123, new BigDecimal("9.99"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testPaymentConstructorInvalidAmount() {
		Payment p = new Payment(123, new BigDecimal("-10.00"));
	}
	
	//TODO [[done]] test positive payments added
	@Test(expected = IllegalArgumentException.class)
	public void testAddInvalidPaymentAmount() {
		Payment p = new Payment(123, new BigDecimal("9.99"));
		p.addPayment(new BigDecimal("-99.99"));
	}
	//TODO test get human readable
}
