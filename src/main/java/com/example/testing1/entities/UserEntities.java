package com.example.testing1.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class UserEntities {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	public UserEntities() {
	}
	
	private String email;
	private String password;
	private String name;
	
	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="city_id")
    private CityEntities city;
    
	
	private String mobileNo;
	
	public UserEntities(int id, String email, String password, String name, CityEntities city, String mobileNo) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.name = name;
		this.city = city;
		this.mobileNo = mobileNo;
	}
	public String getName() {
		return name;
	}
	public CityEntities getCity() {
		return city;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setCity(CityEntities city) {
		this.city = city;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public int getId() {
		return id;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
