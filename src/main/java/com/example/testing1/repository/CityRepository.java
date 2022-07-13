package com.example.testing1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.testing1.entities.CityEntities;

import com.example.testing1.entities.StateEntities;

public interface CityRepository extends JpaRepository<CityEntities, Integer>{
//  public CityEntities findByState();
	 public List<CityEntities> findByState(StateEntities state);
}
