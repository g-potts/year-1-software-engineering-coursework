package com.films4you.req4;

import com.films4you.main.Database;
import com.films4you.main.RequirementInterface;
import com.films4you.main.TaskNotAttemptedException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * Your class description here.
 * 
 * @author Your name
 *
 */
// 4. List top 10 cities by revenue.
// city -> address [city id] -> customer -> payment
// get payments like before, then get addresses, then sort into cities, sort by
// amount total

// get all customers with payment amounts and address ids
// sort city ids into cities
// sort cities by revenue
public class Requirement implements RequirementInterface {
	
	private List<City> getHighestRentingCities() {
		CustomerManager custm = CustomerManager.getInstance();
		
		custm.initialiseCustomers();
		custm.addPayments();
		
		CityManager citym = CityManager.getInstance();
		
		citym.setAddressMap(custm.createAddressMap());
		citym.initialiseCitiesNew();
		
		return citym.findHighestCities();
	}
	
	@Override
	public @Nullable String getValueAsString() {
//		throw new TaskNotAttemptedException();
//		int cityid = getHighestRentingCity();
//		Database db = new Database();
//		ResultSet queryresult = db.query("SELECT * FROM city");
//		try {
//			while (queryresult.getInt("city_id") != cityid) {
//				queryresult.next();
//			}
//			return queryresult.getString("city");
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return "city not found";
		String output = ""; 
		List<City> topten = getHighestRentingCities();
		for (City c : topten) {
			output += c.getName() + "," + c.getRevenue() + "\n";
		}
		return output;
	}

	@Override
	public @NonNull String getHumanReadable() {
		throw new TaskNotAttemptedException();
	}

}
