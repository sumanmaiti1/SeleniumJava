package junit.Assertions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import junit.Calculator;

public class AssertEquals {
	
	@Test
	public void test1() {
		System.out.println("test1");
		assertEquals((byte)12, (byte)12);
		assertEquals(false, 2>=3);
		assertEquals(Integer.parseInt("12"),12);
		assertEquals(20,new Calculator().multiplication(8, 2.5));
		assertEquals('b','a'+1);
		assertEquals(12L,12);
		assertEquals(12.5 , 10+2.5,()->"This has failed");
		
	}
	
}
