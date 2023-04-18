package com.films4you.req4;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import com.films4you.main.Database;

public class RequirementTest {

	/**
	 * A sample test. You'll need to test your solution properly.
	 */
	@Test
	public void testRequirementGetActual() {
		//TODO test req4 get actual
		Requirement r = new Requirement();
		assertEquals("Cape Coral", r.getValueAsString()); //cape coral ?
	}
	
	//city constructor id positive
	@Test(expected = IllegalArgumentException.class)
	public void testCityConstructorInvalidID() {
		City city = new City(-123, new BigDecimal("9.99"));
	}
	
	//city constructor amount positive
	@Test(expected = IllegalArgumentException.class)
	public void testCityConstructorInvalidAmount() {
		City city = new City(123, new BigDecimal("-9.99"));
	}
	
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
	
	//TODO test get human readable
}
