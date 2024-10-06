package junit.ExceptionHandling;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import org.junit.jupiter.api.Test;

import junit.Calculator;

public class ExceptionHandlingTest {
	
	Calculator cal = new Calculator();
	@Test
	void test1() {
		Exception e = assertThrows(NumberFormatException.class, ()->Integer.parseInt("One"));
		//System.out.println(e.getMessage());
		assertEquals("For input string: \"One\"", e.getMessage());
	}
	
	@Test
	void test2() {
		double d = assertDoesNotThrow(()-> cal.division(10, 0));
		System.out.println(d);		
	}
	
	@Test
	void test3() {
		Exception e = assertThrows(IndexOutOfBoundsException.class,()-> {throw new IndexOutOfBoundsException("Test Exception");});
		assertEquals("Test Exception", e.getLocalizedMessage());
		assertThrowsExactly(ClassCastException.class, ()-> {throw new ClassCastException("Test Class Cast");} , "This is My Test Message");
		assertThrowsExactly(ClassCastException.class, ()-> {throw new IllegalArgumentException("Test Class Cast");} , "This is My Test Message"); //----Ths will fail
	}
	
	
}
