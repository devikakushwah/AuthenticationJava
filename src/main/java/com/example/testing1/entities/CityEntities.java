package com.example.testing1.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class CityEntities {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
   private int id;
   private String cityName;
   
   @ManyToOne(cascade= CascadeType.ALL)
   @JoinColumn(name="state_id")
   private StateEntities state;
public CityEntities() {
	super();
	// TODO Auto-generated constructor stub
}
public int getId() {
	return id;
}
public String getCityName() {
	return cityName;
}
public StateEntities getState() {
	return state;
}
public void setId(int id) {
	this.id = id;
}
public void setCityName(String cityName) {
	this.cityName = cityName;
}
public void setState(StateEntities state) {
	this.state = state;
}
public CityEntities(int id, String cityName, StateEntities state) {
	super();
	this.id = id;
	this.cityName = cityName;
	this.state = state;
}

}
