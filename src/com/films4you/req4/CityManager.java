package com.films4you.req4;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.films4you.main.Database;
import com.films4you.req2.Payment;

public class CityManager {
	
	private Map<Integer, BigDecimal> addressmap = null;
	private Map<Integer, BigDecimal> citymap = null;
	private List<City> citylist = null;
	
	public CityManager() {
		citymap = new HashMap<Integer, BigDecimal>();
		citylist = new ArrayList<City>();
	}
	
	public void setAddressMap(Map<Integer, BigDecimal> a) {
		addressmap = a;
	}
	
	public void initialiseCities() {
		if (addressmap == null) {
			throw new NullPointerException("address map not initialised");
		}
		Database db = new Database();
		ResultSet queryresult = db.query("SELECT * FROM address");
		int addressid;
		try {
			while (queryresult.next()) {
				addressid = queryresult.getInt("address_id");
				if (addressmap.get(addressid) != null) {
					citymap.put(queryresult.getInt("city_id"), addressmap.get(addressid));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void initialiseCitiesNew() {
		if (addressmap == null) {
			throw new NullPointerException("address map not initialised");
		}
		//currently have map relating address id to total revenue
		Database db = new Database();
		ResultSet queryresult = db.query("SELECT * FROM address");
		ResultSet cityresults = db.query("SELECT * FROM city");
		try {
			while (queryresult.next()) {
				if (addressmap.containsKey(queryresult.getInt("address_id"))) {
					City c = new City(queryresult.getInt("city_id"), addressmap.get(queryresult.getInt("address_id")));
					cityresults = db.query("SELECT * FROM city");
					while (cityresults.getRow() != queryresult.getInt("city_id")) {
						cityresults.next();
					}
					c.setName(cityresults.getString("city"));
					citylist.add(c);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int findHighestCity() {
		int id = 1;
		for (int i : citymap.keySet()) {
			if (citymap.get(i).compareTo(citymap.get(id)) == 1) {
				id = i;
			}
		}
		return id;
	}
	
	public List<City> findHighestCities() {
		sortCityList();
		List<City> topten = new ArrayList<City>();
		for (int i = 0; i < 10; i++) {
			topten.add(citylist.get(i));
		}
		return topten;
	}
	
	private void sortCityList() {
		Collections.sort(citylist, new Comparator<City>() {
			public int compare(City c1, City c2) {
				return c1.compareTo(c2);
			}
		});
		Collections.reverse(citylist);
	}
}
