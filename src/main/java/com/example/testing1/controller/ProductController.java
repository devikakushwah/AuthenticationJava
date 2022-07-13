package com.example.testing1.controller;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.testing1.entities.ProductEntities;
import com.example.testing1.model.ProductModel;
import com.example.testing1.service.ProductServiceInt;


@CrossOrigin(origins = "*")
@RequestMapping("product")
@RestController
public class ProductController {
	@Autowired
	private ProductServiceInt productInt;

	@PostMapping("/add")
	public ProductEntities saveProduct(@RequestBody ProductEntities product) {

		productInt.productSave(product);
		return product;
	}

	@GetMapping("/view-all-product")
	public Iterable<ProductEntities> getProduct() {

		return productInt.getDetails();

	}
	
	@GetMapping("/view-product")
	public List<ProductEntities> viewProduct() {
		System.out.println("ha chla ");
       return productInt.getProductDetails();
	}
	
	@DeleteMapping("delete-product-by-id")
	
	public Iterable<ProductEntities> deleteProduct(@RequestParam int id) {
		return productInt.productDelete(id);
	}
	@DeleteMapping("delete-by-id")
	public String deleteById(@RequestParam int id) {
		return productInt.productDeleteById(id);
	}
	@PutMapping("update")
	public ProductEntities updateProduct(@RequestBody ProductEntities product) {
		return productInt.productUpdate(product);
	}
	@RequestMapping(value = "products", method = RequestMethod.PUT)
	public String updatePro(@RequestParam int id,@RequestBody ProductEntities product) {
		
		return productInt.productU(id,product);
		
	}
	@RequestMapping(value = "product-find", method = RequestMethod.GET)
	public Iterable<ProductEntities> findByName(@RequestParam String productName){
		
		 return productInt.findProductByName(productName);
	}
	@RequestMapping(value = "order-by-desc", method = RequestMethod.GET)
	public Iterable<ProductEntities> findOrderByNameInDes(){
		
		 return productInt.findOrderByNameInDes();
	}
	@RequestMapping(value = "search-by-first-letter", method = RequestMethod.GET)
	public Iterable<ProductEntities> findByFirstLetter(@RequestParam String productName){
		
		 return productInt.findByLetter(productName);
	}

}
