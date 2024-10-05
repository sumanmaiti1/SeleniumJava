package junit.Annotations;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import junit.Calculator;

public class BeforeAfterAllOnDifferentClassMethodTestInstanceIsPerMethod extends AnotherClass {
	
	@BeforeEach
	void beforeEachTest() {
		System.out.println("This method will be called before each method");
	}
	
	@AfterEach
	void afterEachTest1() {
		System.out.println("This method will be called After each method\n");
	}
	
	
	//--------------- Positive Test
	@Test
	void TestAddMethod() {
		System.out.println("This is TestAddMethod");
		assertEquals(5, new Calculator().addition(3, 2),"Adition is not Write");
	}
	
	//--------------- Negative Test
	@Test
	void TestMultiplyMethod() {
		System.out.println("This is TestMultiplyMethod");
		assertEquals((10+2.5), new Calculator().addition(5, 2.5),"Multiplication is not Write");
	}
	
}


class AnotherClass{
	
	//---------------- For Own Class Method in Before All, AfterAll if Test Instance in set to PER CLASS, NO need to set the method as STATIC
	@BeforeAll
	static void BeforeAllTest() {
		System.out.println("This method from Different Class will be called After All method. And once per Test Class");
	}
	
	//---------------- For Own Class Method in Before All, AfterAll if Test Instance in set to PER METHOD, NO need to set the method as STATIC
	@AfterAll
	static void afterAllTest() {
		System.out.println("This method from Different Class will be called After All method. And once per Test Class");
	}
	
}
