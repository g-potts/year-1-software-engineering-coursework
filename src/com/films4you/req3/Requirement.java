package com.films4you.req3;

import com.films4you.main.RequirementInterface;
//import com.films4you.main.TaskNotAttemptedException;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * Your class description here.
 * 
 * @author Your name
 *
 */
// 3. Find the customer who is the most frequent renter.
public class Requirement implements RequirementInterface {

	/*
	 * get customer id
	 * count number of rentals with each customer id
	 * sort descending by count
	 * return highest
	 */
	//TODO [[done]] put get value as string code in private method
	private Customer getHighestRenter() {
		RentalCounter r = new RentalCounter();
		r.initialiseArray();
		r.countRentals();
		r.sortByRentalsDescending();
		return r.getRenter(0);
	}
	
	@Override
	public @Nullable String getValueAsString() {
		return getHighestRenter().getFullName();
	}

	@Override
	public @NonNull String getHumanReadable() {
		//TODO [[done]] r3 get human readable
		String firstname = this.getValueAsString().split(" ")[0];
		String lastname = this.getValueAsString().split(" ")[1];
		String nameLowercase = firstname.charAt(0) + firstname.substring(1).toLowerCase() + " " + lastname.charAt(0) + lastname.substring(1).toLowerCase();
		return "The most frequent renter is " + nameLowercase;
	}

}
