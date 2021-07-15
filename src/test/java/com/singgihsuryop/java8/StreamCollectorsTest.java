package com.singgihsuryop.java8;

import static java.util.stream.Collectors.averagingDouble;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.minBy;
import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.reducing;
import static java.util.stream.Collectors.summarizingDouble;
import static java.util.stream.Collectors.toSet;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

@DisplayName("Stream Collectors")
public class StreamCollectorsTest {

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
	public void testAveragingDouble() {
		print("averagingDouble");
		Double averagingDouble = productsList.stream().collect(averagingDouble((p) -> (p.price)));
		System.out.println(averagingDouble);
	}

	@Test
	public void testCounting(TestInfo info) {

		print("counting");
		Long counting = productsList.stream().collect(counting());
		System.out.println(counting);
	}

	@Test
	public void testJoining(TestInfo info) {
		print("joining");
		String joining = productsList.stream().map(p -> p.name).collect(joining("|"));
		System.out.println(joining);
	}

	@Test
	public void testMapping(TestInfo info) {
		print("mapping");
		Map<Float, Set<String>> mapping = productsList.stream().collect(groupingBy(Product::getPrice,
				mapping(Product::getName, toSet())));
		mapping.forEach((k,v) ->{
			System.out.println("key:"+k+", value:"+v.stream().collect(Collectors.joining(", ")));
		});
	}

	@Test
	public void testMaxBy(TestInfo info) {
		print("maxBy");
		Float maxBy = productsList.stream().map(p->p.price).collect(maxBy((a,b)-> {
			return a.compareTo(b);
		})).get();
		System.out.println(maxBy);
	}

	@Test
	public void testMinBy(TestInfo info) {
		print("minBy");
		Float minBy = productsList.stream().map(p->p.price).collect(minBy((a,b)-> {
			return b.compareTo(a);
		})).get();
		System.out.println(minBy);
	}

	@Test
	public void testPartitioningBy(TestInfo info) {
		print("partitioningBy");
		Map<Boolean, List<Product>> partitioningBy = productsList.stream().collect(partitioningBy((p) -> (p.price>30000)));
		partitioningBy.forEach((k,v) -> {
			System.out.println("key:"+k+", value:"+v.stream().map(Product::toString).collect(Collectors.joining(", ")));
		});
	}

	@Test
	public void testReducing(TestInfo info) {
		print("reducing");
		String reducing = productsList.stream().map((p) -> p.name).collect(reducing((a,b) -> {
			return a.concat(", ").concat(b);
		})).get();
		System.out.println(reducing);
	}

	@Test
	public void testSummarizingDouble(TestInfo info) {
		print("summarizingDouble");
		DoubleSummaryStatistics summarizingDouble = productsList.stream().collect(summarizingDouble((p) -> (p.price)));
		System.out.println(summarizingDouble.toString());
	}

	@Test
	public void testSummingDouble(TestInfo info) {
		print("summingDouble");
		Double summingDouble = productsList.stream().collect(Collectors.summingDouble((p) -> (p.price)));
		System.out.println(summingDouble);
	}

	@Test
	@DisplayName("groupingBy price")
	public void testCollectorsGrouping1(TestInfo info) {
		print(info.getDisplayName());
		Map<Float, List<Product>> groupingBy = productsList.stream().collect(groupingBy((p) -> (p.price)));
		groupingBy.forEach((k,v) ->{
			System.out.println("key:"+k+", value:"+v.stream().map(Product::toString).collect(Collectors.joining(", ")));
		});
	}
	
	@Test
	@DisplayName("groupingBy category")
	public void testCollectorsGrouping2(TestInfo info) {
		print(info.getDisplayName());
		Map<String, List<Product>> groupingBy2 =
				productsList.stream().collect(groupingBy(Product::getCategory));
		System.out.println(groupingBy2.toString());
	}
	
	@Test
	@DisplayName("groupingBy category then collect with counting")
	public void testCollectorsGrouping3(TestInfo info) {
		print(info.getDisplayName());
		Map<String, Long> groupingByCategoryCount =
				productsList.stream().collect(groupingBy(Product::getCategory, counting()));
		System.out.println(groupingByCategoryCount.toString());
	}
	
	@Test
	@DisplayName("groupingBy category then collect with averageDouble")
	public void testCollectorsGrouping4(TestInfo info) {
		print(info.getDisplayName());
		Map<String, Double> groupingByCategoryAverageDouble =
				productsList.stream().collect(groupingBy(Product::getCategory,
						averagingDouble(Product::getPrice)));
		System.out.println(groupingByCategoryAverageDouble.toString());
	
	}
	
	private void print(String text) {
		System.out.println("\n================= " + text + " =================");
	}
	
	
}
