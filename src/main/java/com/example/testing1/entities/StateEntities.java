package com.example.testing1.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
public class StateEntities {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
   private int id;
   private String stateName;
   
   @ManyToOne(cascade= CascadeType.ALL)
   @JoinColumn(name="country_id")
   private CountryEntities country;
   
public int getId() {
	return id;
}
public String getStateName() {
	return stateName;
}
public CountryEntities getCountry() {
	return country;
}
public void setId(int id) {
	this.id = id;
}
public void setStateName(String stateName) {
	this.stateName = stateName;
}
public void setCountry(CountryEntities country) {
	this.country = country;
}
public StateEntities(int id, String stateName, CountryEntities country) {
	super();
	this.id = id;
	this.stateName = stateName;
	this.country = country;
}
public StateEntities() {
	super();
	// TODO Auto-generated constructor stub
}


}
