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

	//TODO [[done]] test get human readable
	@Test
	public void testRequirementGetHumanReadable() {
		Requirement r = new Requirement();
		assertEquals("The number 1 customer is KARL SEAL who generated £221.55 of income.\n"
				+ "The number 2 customer is ELEANOR HUNT who generated £216.54 of income.\n"
				+ "The number 3 customer is CLARA SHAW who generated £195.58 of income.\n"
				+ "The number 4 customer is MARION SNYDER who generated £194.61 of income.\n"
				+ "The number 5 customer is RHONDA KENNEDY who generated £194.61 of income.\n"
				+ "The number 6 customer is TOMMY COLLAZO who generated £186.62 of income.\n"
				+ "The number 7 customer is WESLEY BULL who generated £177.60 of income.\n"
				+ "The number 8 customer is TIM CARY who generated £175.61 of income.\n"
				+ "The number 9 customer is MARCIA DEAN who generated £175.58 of income.\n"
				+ "The number 10 customer is ANA BRADLEY who generated £174.66 of income.\n", r.getHumanReadable());
	}
}
