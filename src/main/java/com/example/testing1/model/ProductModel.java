package com.example.testing1.model;

public class ProductModel {
	private int id ;
	private  String productName;
    private int price;
    private String color;
    private int quantity;
	public String getProductName() {
		return productName;
	}
	public int getPrice() {
		return price;
	}
	public String getColor() {
		return color;
	}
	public int getQuantity() {
		return quantity;
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
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	   
}
