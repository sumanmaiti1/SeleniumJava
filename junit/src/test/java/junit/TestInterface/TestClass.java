package junit.TestInterface;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestClass implements SecondInterface, FirstInterface {
	
	@Test
	@Override
	public void test() {
		// TODO Auto-generated method stub
		System.out.println("This is Overridden Implemented method of Interface");
		assertEquals(12, 4*3);		
		System.out.println("---------------------------");
	}
	
	@Test
	void testTestClass() {
		System.out.println("This is testTestClass");
		assertEquals(12, 4*3);
		System.out.println("-------------------------------");
	}
	
	@AfterEach
	void afterEachTestClass() {
		System.out.println("afterEachTestClass");
	}
	
	@BeforeEach
	void beforeEachTestClass() {
		System.out.println("beforEachTestClass");
	}
	
	@AfterAll
	static void afterAllTestClass() {
		System.out.println("afterAllTestClass");
	}
	
	@BeforeAll
	static void beforeAllTestClass() {
		System.out.println("beforeAllTestClass");
	}
	
}
