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
		assertEquals("The number 1 city is Cape Coral which generated £221.55 of income.\n"
				+ "The number 2 city is Saint-Denis which generated £216.54 of income.\n"
				+ "The number 3 city is Molodetno which generated £195.58 of income.\n"
				+ "The number 4 city is Santa Brbara dOeste which generated £194.61 of income.\n"
				+ "The number 5 city is Apeldoorn which generated £194.61 of income.\n"
				+ "The number 6 city is Qomsheh which generated £186.62 of income.\n"
				+ "The number 7 city is Ourense (Orense) which generated £177.60 of income.\n"
				+ "The number 8 city is Bijapur which generated £175.61 of income.\n"
				+ "The number 9 city is Tanza which generated £175.58 of income.\n"
				+ "The number 10 city is Memphis which generated £174.66 of income.\n", r.getHumanReadable());
	}
}
