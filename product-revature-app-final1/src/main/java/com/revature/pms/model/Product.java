package com.revature.pms.model;

import java.io.Serializable;
/*
 * This is product pojo class mapped to product table in the database
 */

public class Product implements Serializable{
	
	//fields of my product pojo
	private int productId;
	private String productName;
	private int quantityOnHand;
	private int price;
	private String comments;
	
	//default constructor
	public Product() {
		// TODO Auto-generated constructor stub
	}
	
	//Parametrized constructor
	public Product(int productId, String productName, int quantityOnHand, int price, String comments) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.quantityOnHand = quantityOnHand;
		this.price = price;
		this.comments = comments;
	}


	//getters and setters for all the fields

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantityOnHand() {
		return quantityOnHand;
	}

	public void setQuantityOnHand(int quantityOnHand) {
		this.quantityOnHand = quantityOnHand;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", quantityOnHand=" + quantityOnHand
				+ ", price=" + price + ", comments=" + comments + "]";
	}
	
	
	
	
	
	

}
