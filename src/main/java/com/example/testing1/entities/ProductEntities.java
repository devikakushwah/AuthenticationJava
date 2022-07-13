package com.example.testing1.entities;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProductEntities {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
   private int id;
   private  String productName;
   private int price;
   private String color;
   private int quantity;
   private boolean isDeleted = false;
   private String imageUrl;
   public ProductEntities() {
	
	// TODO Auto-generated constructor stub
}
public int getId() {
	return id;
}
public String getProductName() {
	return productName;
}
public int getPrice() {
	return price;
}
public String getColor() {
	return color;
}
public void setId(int id) {
	this.id = id;
}
public void setProductName(String productName) {
	this.productName = productName;
}
public void setPrice(int price) {
	this.price = price;
}
public void setColor(String color) {
	this.color = color;
}
public int getQuantity() {
	return quantity;
}
public boolean isDeleted() {
	return isDeleted;
}
public ProductEntities(int id, String productName, int price, String color, int quantity, boolean isDeleted,
		String imageUrl) {
	super();
	this.id = id;
	this.productName = productName;
	this.price = price;
	this.color = color;
	this.quantity = quantity;
	this.isDeleted = isDeleted;
	this.imageUrl = imageUrl;
}
public String getImageUrl() {
	return imageUrl;
}
public void setImageUrl(String imageUrl) {
	this.imageUrl = imageUrl;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public void setDeleted(boolean isDeleted) {
	this.isDeleted = isDeleted;
}



}
