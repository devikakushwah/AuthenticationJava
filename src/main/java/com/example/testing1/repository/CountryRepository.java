package com.example.testing1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.testing1.entities.CountryEntities;

public interface CountryRepository extends JpaRepository<CountryEntities, Integer> {
//  public  List<CountryEntities> findById(int id);
}
