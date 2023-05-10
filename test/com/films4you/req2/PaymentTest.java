package com.films4you.req2;

import java.math.BigDecimal;
import org.junit.Test;

public class PaymentTest {
	
	@Test(expected = IllegalArgumentException.class)
	public void testPaymentConstructorInvalidID() {
		Payment p = new Payment(-123, new BigDecimal("9.99"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testPaymentConstructorInvalidAmount() {
		Payment p = new Payment(123, new BigDecimal("-10.00"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAddInvalidPaymentAmount() {
		Payment p = new Payment(123, new BigDecimal("9.99"));
		p.addPayment(new BigDecimal("-99.99"));
	}

	
}
