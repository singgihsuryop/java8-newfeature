package com.singgihsuryop.java8;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

interface InterfaceNoParamNoReturn{
	public void function();
}

interface InterfaceNoParamWithReturn{
	public String function();
}

interface Interface2ParamWithReturn{
	public int function(int a , int b);
}

public class LambdaExpressionsTest 
{

	@Test
    public void testNoParamNoReturn() {
		InterfaceNoParamNoReturn iNoParam = () -> {
		};
		
		iNoParam.function();
		
	}
	
	@Test
	public void testNoParamWithReturn() {
		InterfaceNoParamWithReturn intface = () ->{
			return "InterfaceNoParamWithReturn";
		};
		
		assertEquals("InterfaceNoParamWithReturn", intface.function()); ;
		
	}
	
	@Test
	public void test2ParamWithReturn() {
		Interface2ParamWithReturn intface = (int a, int b) -> {
			return a + b;
		};
		
		
		assertEquals(4, intface.function(2, 2));		
	}
	
	@Test
	public void test2ParamWithReturn2() {
		Interface2ParamWithReturn intface = (int a, int b) -> (a+b);
		
		
		assertEquals(4, intface.function(2, 2));		
	}
	
	@Test
	public void testListForEach() {
		List<String> list=new ArrayList<String>();  
        list.add("ankit");  
        list.add("mayank");  
        list.add("irfan");  
        list.add("jai");  
		list.forEach((n) -> {
			//System.out.println(n);
		});
		
		assertEquals(4, list.size());		
	}
	
	@Test
	public void testComparator() {
		List<Product> list=new ArrayList<>();  
		list.add(new Product(1,"Samsung A5","Mahal",17000f));  
        list.add(new Product(3,"Iphone 6S","Mahal",65000f));  
        list.add(new Product(2,"Sony Xperia","Menengah",25000f));  
        list.add(new Product(4,"Nokia Lumia","Murah",15000f));  
        list.add(new Product(5,"Redmi4 ","Murah",26000f));  
        list.add(new Product(6,"Lenevo Vibe","menengah",19000f));    
        
        Stream<Product> filtered = list.stream().filter((p) -> p.price > 20000f);
        
        filtered.forEach((n) -> {
        	System.out.println(n.name+": "+n.price);
        });
		
		assertEquals(4, list.size());		
	}
	
	@Test
	public void testFilter() {
		
	}
	
	
}
