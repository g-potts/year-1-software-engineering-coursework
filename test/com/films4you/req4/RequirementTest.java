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
		//TODO [[done]] test req4 get actual
		Requirement r = new Requirement();
		assertEquals("Cape Coral,221.55\n"
				+ "Saint-Denis,216.54\n"
				+ "Molodetno,195.58\n"
				+ "Santa Brbara dOeste,194.61\n"
				+ "Apeldoorn,194.61\n"
				+ "Qomsheh,186.62\n"
				+ "Ourense (Orense),177.60\n"
				+ "Bijapur,175.61\n"
				+ "Tanza,175.58\n"
				+ "Memphis,174.66\n", r.getValueAsString());
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
	@Test
	public void testRequirementGetHumanReadable() {
		Requirement r = new Requirement();
		assertEquals("The number 1 customer is Cape Coral who generated £221.55 of income.\n"
				+ "The number 2 customer is Saint-Denis who generated £216.54 of income.\n"
				+ "The number 3 customer is Molodetno who generated £195.58 of income.\n"
				+ "The number 4 customer is Santa Brbara dOeste who generated £194.61 of income.\n"
				+ "The number 5 customer is Apeldoorn who generated £194.61 of income.\n"
				+ "The number 6 customer is Qomsheh who generated £186.62 of income.\n"
				+ "The number 7 customer is Ourense (Orense) who generated £177.60 of income.\n"
				+ "The number 8 customer is Bijapur who generated £175.61 of income.\n"
				+ "The number 9 customer is Tanza who generated £175.58 of income.\n"
				+ "The number 10 customer is Memphis who generated £174.66 of income.\n", r.getHumanReadable());
	}
}
