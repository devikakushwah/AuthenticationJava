package com.example.testing1.service;

import java.util.List;

import com.example.testing1.entities.CityEntities;
import com.example.testing1.entities.CountryEntities;
import com.example.testing1.entities.StateEntities;

public interface CountryServiceInt {
	public List<CountryEntities> getCountryDetails();
	public List<StateEntities> findStateByCountry(int country);
	public List<CityEntities> findCityByState(int state);
	
}
