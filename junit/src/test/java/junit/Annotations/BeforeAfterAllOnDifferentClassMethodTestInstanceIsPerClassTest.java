package junit.Annotations;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import junit.Calculator;

@TestInstance(Lifecycle.PER_CLASS)
public class BeforeAfterAllOnDifferentClassMethodTestInstanceIsPerClassTest extends AnotherClass1{
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

class AnotherClass1{
	
	//---------------- For Own Class Method in Before All, AfterAll if Test Instance in set to PER CLASS, NO need to set the method as STATIC
	@BeforeAll
	void BeforeAllTest() {
		System.out.println("This method from Different Class will be called After All method. And once per Test Class");
	}
	
	//---------------- For Own Class Method in Before All, AfterAll if Test Instance in set to PER METHOD, NO need to set the method as STATIC
	@AfterAll
	void afterAllTest() {
		System.out.println("This method from Different Class will be called After All method. And once per Test Class");
	}
	
}
