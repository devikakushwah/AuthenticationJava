package com.example.testing1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.testing1.entities.CityEntities;
import com.example.testing1.entities.CountryEntities;
import com.example.testing1.entities.StateEntities;
import com.example.testing1.repository.CityRepository;
import com.example.testing1.repository.CountryRepository;
import com.example.testing1.repository.StateRepository;
@Service
public class CountryService implements CountryServiceInt{
	@Autowired
    private CountryRepository countryRepository;
	@Autowired
	private StateRepository stateRepository;
	@Autowired
	private CityRepository cityRepository;
	@Override
	public List<CountryEntities> getCountryDetails() {
		// TODO Auto-generated method stub
		Iterable<CountryEntities> it =  (Iterable<CountryEntities>) countryRepository.findAll();
		
		List<CountryEntities> list = new ArrayList<CountryEntities>();
		
       for(CountryEntities l:it) {
    	   
    		   list.add(l);
    	   
       }
       return list;
	
	}
	@Override
	public List<StateEntities> findStateByCountry(int country) {
		// TODO Auto-generated method stub
		CountryEntities co =  countryRepository.findById(country).orElse(null);
		List<StateEntities> list = stateRepository.findByCountry(co); 
		
    return list;
	
	}
	@Override
	public List<CityEntities> findCityByState(int state) {
		// TODO Auto-generated method stub
		    StateEntities st  =stateRepository.findById(state).orElse(null);
		List<CityEntities> list = cityRepository.findByState(st);
		return list;
	}

}
