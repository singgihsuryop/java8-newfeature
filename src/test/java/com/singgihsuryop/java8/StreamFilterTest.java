package com.singgihsuryop.java8;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StreamFilterTest {

	static List<Product> productsList = new ArrayList<Product>();
	
	@BeforeEach
	public void beforeEach() {
		 //Adding Products  
        productsList.add(new Product(1,"HP Laptop","Murah",25000f));  
        productsList.add(new Product(2,"Dell Laptop","Menengah",30000f));  
        productsList.add(new Product(3,"Lenevo Laptop","Murah",28000f));  
        productsList.add(new Product(4,"Sony Laptop","Menengah",28000f));  
        productsList.add(new Product(5,"Apple Laptop","Mahal",90000f));  
	}
	
	@Test
	public void testFilter1() {
		productsList.stream().filter(p -> p.price> 30000).forEach(System.out::println);;
	}
}
