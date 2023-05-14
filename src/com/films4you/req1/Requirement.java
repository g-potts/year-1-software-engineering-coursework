package com.films4you.req1;

import com.films4you.main.Database;
import com.films4you.main.RequirementInterface;
//import com.films4you.main.TaskNotAttemptedException;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * Requirement 1: find the total number of customers in the database.
 * 
 * @author Grace Potts
 *
 */
// 1. Find the total number of customers
public class Requirement implements RequirementInterface {
	
	/**
	 * Counts number of entries in customer table of database.
	 * 
	 * @return number of customers found in database
	 */
	private int countCustomers() {
		Database db = new Database();
		ResultSet queryresult = db.query("SELECT * FROM customer");
		int customercount = 0;
		try {
			while (queryresult.next()) {
				customercount++;
			}
			System.out.println(customercount);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		db.close();
		return customercount;
	}
	
	@Override
	public @Nullable String getValueAsString() {
		return Integer.toString(countCustomers());
	}

	@Override
	public @NonNull String getHumanReadable() {
		return "Total number of customers in database: " + getValueAsString();
	}

}
