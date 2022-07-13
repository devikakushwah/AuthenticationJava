package com.example.testing1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.testing1.entities.CityEntities;
import com.example.testing1.entities.CountryEntities;
import com.example.testing1.entities.StateEntities;
import com.example.testing1.service.CountryServiceInt;
import com.example.testing1.service.ProductServiceInt;

@CrossOrigin(origins = "*")
@RequestMapping("country")
@RestController

public class CountryController {

    @Autowired
     private CountryServiceInt countryServiceInt;
	 
    
	@RequestMapping(value="/get",method=RequestMethod.GET)
  	public List<CountryEntities> getDetails() {
  		
  		List<CountryEntities> li = countryServiceInt.getCountryDetails();
  		if(li != null) {
  			return li;
  		}
  		else {
  			return null;
  		}
  	}
	@RequestMapping(value="/get-state/{country}",method=RequestMethod.GET)
	public List<StateEntities> getStateDetails(@PathVariable int country){
	
	     return countryServiceInt.findStateByCountry(country);
		
	}
	@RequestMapping(value="/get-city/{state}",method=RequestMethod.GET)
	public List<CityEntities> getCityDetails(@PathVariable int state){
	       
	     return countryServiceInt.findCityByState(state);
		
	}
//	@RequestMapping(value="/get-city/{state}",method=RequestMethod.GET)
//	public List<CityEntities> getCityDetails(@PathVariable int state){
//	       
//	     return countryServiceInt.findCityByState(state);
//		
//	}
}
