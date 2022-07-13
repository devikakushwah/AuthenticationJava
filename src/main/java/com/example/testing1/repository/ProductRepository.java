package com.example.testing1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.testing1.entities.ProductEntities;

public interface ProductRepository extends JpaRepository<ProductEntities, Integer> {
  public Iterable<ProductEntities> findByProductName(String productName);
  public Iterable<ProductEntities> findAllByOrderByProductNameDesc();
 public  Iterable<ProductEntities> findByproductNameStartsWith(String productName);



}
