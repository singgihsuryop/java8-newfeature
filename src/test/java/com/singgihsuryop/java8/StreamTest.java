package com.singgihsuryop.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;


public class StreamTest {

	static List<Product> productsList = new ArrayList<Product>();
	
	@BeforeAll
	public static void beforeAll() {
		 //Adding Products  
        productsList.add(new Product(1,"HP Laptop","Murah",25000f));  
        productsList.add(new Product(2,"Dell Laptop","Menengah",30000f));  
        productsList.add(new Product(3,"Lenevo Laptop","Murah",28000f));  
        productsList.add(new Product(4,"Sony Laptop","Menengah",28000f));  
        productsList.add(new Product(5,"Apple Laptop","Mahal",90000f));  
	}
	
	@Test
	@Disabled
	public void testFilterCollections() {
		List<String> filtered = productsList.stream()
				.filter((a) -> a.price > 25000f)
				.map((a) -> a.name)
				.collect(Collectors.toList());
		
		filtered.forEach((n) -> {
			System.out.println(n);
		});
	}
	
	@Test
	@Disabled
	public void testInteratingCollections() {
		productsList.stream().limit(3).map((p) -> p.toString()).forEach(System.out::println);
	}
	
	@Test
	@Disabled
	public void testInteratingCollections2() {
		productsList.stream().forEach(p -> {
			System.out.println("testInteratingCollections2 " +p.toString());
		});
	}
	
	@Test
	@Disabled
	public void testInteratingNumber() {
		Stream.iterate(1, e -> e+1)
		.filter(element->element%5==0)  
		.limit(10)
		.forEach(System.out::println);
	}
	
	@Test
	@Disabled
	public void testSumNumber() {
		Float totalPrice = productsList.stream()
				.map(p -> p.price)
				.reduce(0f, (a, b) -> a+b);
		System.out.println("testSumNumber1: " +totalPrice);
		
		Float totalPrice2 = productsList.stream()
				.map(p -> p.price)
				.reduce(0f, Float::sum);
		System.out.println("testSumNumber2: " +totalPrice2);
	}
	
	@Test
	@Disabled
	public void testSumNumberByCollector() {
		double totalPrice = productsList.stream().collect(Collectors.summingDouble(p->p.price));
		System.out.println("testSumNumberByCollector: " +totalPrice);
	}
	
	@Test
	@Disabled
	public void testConvertListToSet() {
		Set<Float> set = productsList.stream()
				.map(p -> p.price).collect(Collectors.toSet());
		set.forEach(System.out::println);
	}
	
	@Test
	@Disabled
	public void testConvertListToMap() {
		Map<String, Object> map = productsList.stream().collect(Collectors.toMap(p -> p.name, p -> p.price));
		map.forEach((k,v) -> {
			System.out.println("key: "+k +", value: "+v);
		});
	}
	
	@Test
	public void testMethodReference() {
		productsList.stream().map(Product::getPrice).forEach(System.out::println);;
	}
	
}
