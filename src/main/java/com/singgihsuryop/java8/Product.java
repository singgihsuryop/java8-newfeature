package com.singgihsuryop.java8;

import java.io.Serializable;

public class Product implements Serializable{  
	int id;  
	String name;  
	String category;
	float price;  
	
	public Product(int id, String name, String category, float price) {  
		this.id = id;  
		this.name = name;
		this.category = category;
		this.price = price;  
	}  
	
	public String toString() {
		return new StringBuilder()
				.append(id)
				.append(" - ")
				.append(name)
				.append(" - ")
				.append(category)
				.append(" - ")
				.append(price).toString()
				;
	}

	public int getId() {  
		return id;  
	}  
	public String getName() {  
		return name;  
	}  
	public String getCategory() {  
		return category;  
	}  
	public float getPrice() {  
		return price;  
	}  
}
