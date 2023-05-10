package com.films4you.req4;

import java.math.BigDecimal;
import org.junit.Test;

public class CustomerTest {

	//customer constructor id positive
	@Test(expected = IllegalArgumentException.class)
	public void testCustomerConstructorInvalidID() {
		Customer customer = new Customer(-123);
	}
	
	//customer add payment amount positive
	@Test(expected = IllegalArgumentException.class)
	public void testCustomerAddInvalidPayment() {
		Customer customer = new Customer(123);
		customer.addPayment(new BigDecimal("-1.99"));
	}
	
	//customer set address positive int
	@Test(expected = IllegalArgumentException.class)
	public void testCustomerSetInvalidAddressID() {
		Customer customer = new Customer(123);
		customer.setAddressID(-123);
	}
	
}
