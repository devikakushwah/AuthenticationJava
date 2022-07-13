package com.example.testing1.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.testing1.entities.ProductEntities;
import com.example.testing1.model.ProductModel;
import com.example.testing1.repository.ProductRepository;

@Service
public class ProductService implements ProductServiceInt{
    
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public void productSave(ProductEntities product) {
		// TODO Auto-generated method stub
		productRepository.save(product);
		
	}

	@Override
	public List<ProductEntities> getProductDetails() {
		// TODO Auto-generated method stub
		Iterable<ProductEntities> it =  productRepository.findAll();
		List<ProductEntities> list = new ArrayList<ProductEntities>();
		
       for(ProductEntities l:it) {
    	   if(!l.isDeleted()) {
    		   list.add(l);
    	   }
       }
       return list;
	}
   public Iterable<ProductEntities> getDetails() {
	   return productRepository.findAll();
   }
	@Override
	public Iterable<ProductEntities> productDelete(int id) {
		
			
		productRepository.deleteById(id);
	   return productRepository.findAll();
	}

	@Override
	public ProductEntities productUpdate(ProductEntities product) {
		// TODO Auto-generated method stub
		ProductEntities p =   productRepository.findById(product.getId()).orElse(null);
		if(p!=null) {
	    p.setColor(product.getColor());
	    p.setPrice(product.getPrice());
	    p.setProductName(product.getProductName());
	    p.setQuantity(product.getQuantity());
	    productRepository.save(p);
	    return p;
		}
		else {
			return null;
		}
	}

	@Override
	public String productU(int id,ProductEntities product) {
		// TODO Auto-generated method stub
		ProductEntities p =   productRepository.findById(id).orElse(null);
		if(p!=null) {
	    p.setColor(product.getColor());
	    p.setPrice(product.getPrice());
	    p.setProductName(product.getProductName());
	    p.setQuantity(product.getQuantity());
	    productRepository.save(p);
	    return "Update successfully";
		}
		else {
			return "this id has not exists";
		}
	}

	@Override
	public Iterable<ProductEntities> findProductByName(String name) {
		// TODO Auto-generated method stub
		Iterable<ProductEntities> product = productRepository.findByProductName(name);
		if(product!= null) {
			return product;
		}
		else {
			return null;
		}
	}

	
  public Iterable<ProductEntities> findOrderByNameInDes() {
	  return productRepository.findAllByOrderByProductNameDesc();
  }

@Override
public String productDeleteById(int id) {
	// TODO Auto-generated method stub
	ProductEntities p =   productRepository.findById(id).orElse(null);
	if(p!=null) {
		p.setDeleted(true);
    productRepository.save(p);
    return "Delete successfully";
	}
	else {
		return "this id has not exists";
	}
	
}

@Override
public Iterable<ProductEntities> findByLetter(String productName) {
	// TODO Auto-generated method stub
	return productRepository.findByproductNameStartsWith(productName);
}


}
