package com.films4you.req3;

import org.junit.Test;

public class CustomerTest {
	
	@Test(expected = IllegalArgumentException.class)
	public void testCustomerInvalidFullname() {
		Customer c = new Customer("Name", 123);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCustomerInvalidID() {
		Customer c = new Customer("Name Surname", -123);
	}
	
}
