package com.films4you.req4;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class RequirementTest {

	@Test
	public void testRequirementGetActual() {
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
