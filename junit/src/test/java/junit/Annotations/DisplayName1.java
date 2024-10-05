package junit.Annotations;

import org.junit.jupiter.api.Test;

import junit.Calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;


@DisplayName("Claculator Test Class")
public class DisplayName1 {
	
	
	@DisplayName("Testing Addition Functionality with 2 Positive")
	@Test
	void testAddCalculator1() {
		Assertions.assertEquals(2, new Calculator().addition(1.501, .499),"Addition is not Working properly");
	}
	
	
	@DisplayName("Testing Addition Functionality with 2 Negative")
	@Test
	void testAddCalculator2() {
		Assertions.assertEquals(-10.0, new Calculator().addition(-1.501, -8.499),"Addition is not Working properly");
	}
	
	@DisplayName("Testing Addition Functionality  with 1 Positive 1 Negative")
	@Test
	void testAddCalculator3() {
		Assertions.assertEquals(21.001, new Calculator().addition(11.501, 9.502),"Addition is not Working properly");
	}
	
}
