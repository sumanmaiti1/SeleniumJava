package junit.Assumptions;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeFalse;
import static org.junit.Assume.assumeNoException;
import static org.junit.Assume.assumeThat;
import static org.junit.Assume.assumeTrue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.abort;
import static org.junit.jupiter.api.Assumptions.assumingThat;

import org.junit.Assume;
import org.junit.jupiter.api.Test;

import junit.Calculator;

public class AssumptionsTest {
	
	@Test
	public void test1() {
		System.out.println("test1");
		
		assumeFalse(2>3);
		assertAll(()->assertEquals(5, 25/5),
				()-> assertTrue(2<3),
				()-> assertFalse(2>3)
				);	
	}
	
	@Test
	public void test2() {
		System.out.println("test2");
		
		assumeTrue(3>2);
		assertAll(()->assertEquals(5, 25/5),
				()-> assertTrue(2<3),
				()-> assertFalse(2>3)
				);
	}
	
	@Test
	public void test3() {
		System.out.println("test3");
		
		Exception exception = new Exception("Test Exception");
		
		assumeNoException("No exception is thrown.", exception); //------------------ Rest of the assertions will be Skipped now
		assertAll(()->assertEquals(5, 25/5),
				()-> assertTrue(2<3),
				()-> assertFalse(2>3)
				);
	}
	
	@Test
	public void test4() {
		System.out.println("test4");
		
		assumingThat("DEV".equalsIgnoreCase("dev"),
			      () -> {
			          // perform these assertions only on the DEV server
			          assertEquals(2, new Calculator().division(4, 2));
			      });
		assertAll(()->assertEquals(5, 25/5),
				()-> assertTrue(2<3),
				()-> assertFalse(2>3)
				);
	}
	
	@Test
	public void test5() {
		System.out.println("test5");
		
		abort("Test Abort");
		assertAll(()->assertEquals(5, 25/5),
				()-> assertTrue(2<3),
				()-> assertFalse(2>3)
				);
	}
}
