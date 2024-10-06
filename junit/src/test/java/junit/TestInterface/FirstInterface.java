package junit.TestInterface;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public interface FirstInterface {

	@Test
	void test();  //------------- Abstract method of Second Interface
	
	@Test
	default void testFirstInstance() {
		assertEquals(10, 5+5);
	}
	
	@AfterEach
	default void afterEachFirstInterface() {
		System.out.println("afterEachFirstInterface");
	}
	
	@BeforeEach
	default void beforeEachFirstInterface() {
		System.out.println("beforEachFirstInterface");
	}
	
	@AfterAll
	static void afterAllFirstInterface() {
		System.out.println("afterAllFirstInterface");
	}
	
	@BeforeAll
	static void beforeAllFirstInterface() {
		System.out.println("beforeAllFirstInterface");
	}
	
}


interface SecondInterface {
	
	@Test
	void test();  //------------- Abstract method of Second Interface
	
	@Test
	default void testSecondInterface() {
		assertEquals(10, 5+5);
	}
	
	@AfterEach
	default void afterEachSecondInterface() {
		System.out.println("afterEachSecondInterface");
	}
	
	@BeforeEach
	default void beforeEachSecondInterface() {
		System.out.println("beforEachSecondInterface");
	}
	
	@AfterAll
	static void afterAllSecondInterface() {
		System.out.println("afterAllSecondInterface");
	}
	
	@BeforeAll
	static void beforeAllSecondInterface() {
		System.out.println("beforeAllSecondInterface");
	}
	
}