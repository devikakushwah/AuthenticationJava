package com.example.testing1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.testing1.entities.UserEntities;
public interface UserRepository extends JpaRepository<UserEntities, Integer> {
   public UserEntities findByEmail(String email);
   public UserEntities findByCity(int city);
   
}
