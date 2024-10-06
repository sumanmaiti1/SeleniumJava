package junit.Annotations;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import junit.Calculator;

public class BeforeAfterEachTest {
	
	@BeforeEach
	void beforeEachTest() {
		System.out.println("This method will be called before each method");
	}
	
	@AfterEach
	void afterEachTest() {
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
