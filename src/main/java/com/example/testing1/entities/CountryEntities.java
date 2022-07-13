package com.example.testing1.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class CountryEntities {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
   private int id;
	
   private String countryName;

public int getId() {
	return id;
}

public String getCountryName() {
	return countryName;
}

public void setId(int id) {
	this.id = id;
}

public void setCountryName(String countryName) {
	this.countryName = countryName;
}

public CountryEntities(int id, String countryName) {
	super();
	this.id = id;
	this.countryName = countryName;
}

public CountryEntities() {
	
	// TODO Auto-generated constructor stub
}
   
}
