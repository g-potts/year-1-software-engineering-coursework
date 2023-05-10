package com.films4you.req4;

import java.math.BigDecimal;
import org.junit.Test;

public class CityTest {

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
	
}
