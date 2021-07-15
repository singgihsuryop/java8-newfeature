package com.singgihsuryop.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import org.junit.jupiter.api.Test;

interface IFunctional1{
	public void voidMethod();
	public int intMethod();
}

public class FunctionalInterfacesTest {

	/**
	 * It represents an operation that accepts two input arguments and returns no result.
	 */
	@Test
	public void testBiConsumer() {
		BiConsumer<String, Integer> biConsumer = (a,b) ->{
			System.out.println("testBiConsumer a: "+a+", b: "+b);
		};
		biConsumer.accept("1", 2);
	}
	
	/**
	 * It represents an operation that accepts a single argument and returns no result.
	 */
	@Test
	public void testConsumer() {
		Consumer<String> consumer = (n) -> {
			System.out.println("testConsumer "+n);
		};
		consumer.accept("OKAY");
	}

	/**
	 * It represents a function that accepts one argument and returns a result.
	 */
	@Test
	public void testFunction() {
		Function<String, String> function = (a) -> {
			return "testFunction Input is "+a;
		};
		Function<Integer, String> function2 = (a) -> ("testFunction2 Input is "+a);

		System.out.println(function.apply("1"));
		System.out.println(function2.andThen(function).apply(3));
	}
	
	/**
	 * It represents a predicate (boolean-valued function) of one argument.
	 */
	@Test
	public void testPredicate() {
		Predicate<Boolean> predicate = (a) -> {
			return a==true ? false : true;
		};
		System.out.println("testPredicate1: " +predicate.test(true));
		
		Predicate<Integer> predicate2 = (a) -> {
			return a>10? false : true;
		};
		System.out.println("testPredicate2: " +predicate2.test(11));
	}

	/**
	 * It represents a function that accepts two arguments and returns a a result.
	 */
	@Test
	public void testBiFunction() {
		BiFunction<Long, Integer, String> biFunction = (a,b) -> {
			return "testBiFunction Long is "+a+", Integer is "+b;
		};
		System.out.println(biFunction.apply(10l, 13));
	}

	/**
	 * It represents an operation upon two operands of the same data type. It returns a result of the same type as the operands.
	 */
	@Test
	public void testBinaryOperator() {
		BinaryOperator<Integer> binaryOperator = (a,b) -> (a*b);
		System.out.println("testBinaryOperator: "+ binaryOperator.apply(4, 5));
	}
	
	
	/**
	 * It represents a predicate (boolean-valued function) of two arguments.
	 */
	@Test
	public void testBiPredicate() {
		BiPredicate<Integer,Integer> biPredicate = (a,b) -> {
			return a+b > 10 ? true : false;
		};
		System.out.println("testBiPredicate: " +biPredicate.test(6,6));
	}

	/**
	 * It represents a supplier of boolean-valued results.
	 */
	@Test
	public void testBooleanSupplier() {


		BooleanSupplier booleanSupplier	= () -> true;
		System.out.println("testBooleanSupplier: "+booleanSupplier.getAsBoolean());

	}
}
