package com.example.testing1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.testing1.entities.CountryEntities;
import com.example.testing1.entities.StateEntities;

public interface StateRepository extends JpaRepository<StateEntities, Integer> {
  public List<StateEntities> findByCountry(CountryEntities country);
}
