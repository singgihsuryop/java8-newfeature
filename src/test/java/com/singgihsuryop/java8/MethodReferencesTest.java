package com.singgihsuryop.java8;

import java.util.function.BiFunction;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@FunctionalInterface
interface Sayable{  
    void say();  
}  

class Arithmetic{  
	public static int add(int a, int b){  
		return a+b;  
	}  
	public static float add(int a, float b){  
		return a+b;  
	}  
	public static float add(float a, float b){  
		return a+b;  
	} 
	public static String addShow(float a, float b){  
		return "Result is "+(a+b);  
	}
	public void nonStaticMethod(){  
		System.out.println("This is non statoc method");  
	}
	public int addNonStatic(int a, int b){  
		return a+b;  
	}
}


interface Messageable{  
    Message getMessage(String msg);  
}  
class Message{  
    Message(String msg){  
        System.out.print(msg);  
    }  
    
    Message(String msg, String msg2){  
        System.out.print(msg.concat(msg2));  
    }  
} 


public class MethodReferencesTest {

	public static void saySomething(){  
        System.out.println("Hello, this is static method.");  
    }
	
	public static void saySomething2(){  
        System.out.println("Hello, this is static method. also.");  
    }
	
	@Test
	@Disabled
	public void test1() {
		// Referring static method  
        Sayable sayable = MethodReferencesTest::saySomething2;  
        // Calling interface method  
        sayable.say();  
	}
	
	@Test
	@Disabled
	public void test2() {
		Thread t = new Thread(MethodReferencesTest::saySomething2);
		t.run();
	}
	
	@Test
	@Disabled
	public void test3() {
	
		BiFunction<Integer, Integer, Integer> function = Arithmetic::add;
		BiFunction<Integer, Float, Float> function2 = Arithmetic::add;
		BiFunction<Float, Float, Float> function3 = Arithmetic::add;
		BiFunction<Float, Float, String> function4 = Arithmetic::addShow;
		
		System.out.println(function.apply(3, 3));
		System.out.println(function2.apply(3, 3f));
		System.out.println(function3.apply(3f, 3f));
		System.out.println(function4.apply(3f, 3f));
	}
	
	@Test
	@Disabled
	public void test4() {
		Arithmetic a = new Arithmetic();
		Sayable s = a::nonStaticMethod;
		s.say();
		
		Sayable s2 = new Arithmetic()::nonStaticMethod;
		s2.say();
	}
	
	@Test
	@Disabled
	public void test5() {
		Thread t = new Thread(new Arithmetic()::nonStaticMethod);
		t.start();
	}
	
	@Test
	@Disabled
	public void test6() {
		BiFunction<Integer, Integer, Integer> func = new Arithmetic()::addNonStatic;
		System.out.println(func.apply(3, 4));
	}
	
	@Test
	public void test7() {
		 Messageable hello = Message::new;  
		 hello.getMessage("Hello");  
	}
	
}
