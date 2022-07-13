package com.example.testing1.service;

import java.util.List;

import com.example.testing1.entities.ProductEntities;
import com.example.testing1.model.ProductModel;

public interface ProductServiceInt {
    public void productSave(ProductEntities pro);
    public List<ProductEntities> getProductDetails();
    public Iterable<ProductEntities> productDelete(int id);
    public ProductEntities productUpdate(ProductEntities product);
    public String productU(int id,ProductEntities product);
    public Iterable<ProductEntities> findProductByName(String productName);
    public Iterable<ProductEntities> findOrderByNameInDes();
    public Iterable<ProductEntities> getDetails();
    public String productDeleteById(int id);
    public Iterable<ProductEntities> findByLetter(String productName);
   
}
