package com.films4you.req1;

import com.films4you.main.Database;
import com.films4you.main.RequirementInterface;
//import com.films4you.main.TaskNotAttemptedException;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * Your class description here.
 * 
 * @author gpotts
 *
 */
// 1. Find the total number of customers
public class Requirement implements RequirementInterface {
	
	/*
	 * total number of customers:
	 * select * from customer
	 * count rows returned
	 * */
	
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
		return customercount;
	}
	
	
	@Override
	public @Nullable String getValueAsString() {
		// throw new TaskNotAttemptedException();
		return Integer.toString(countCustomers());
		
	}

	@Override
	public @NonNull String getHumanReadable() {
		return "Total number of customers in database: " + getValueAsString();
	}

}
