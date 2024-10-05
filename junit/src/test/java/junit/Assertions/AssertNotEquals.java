package junit.Assertions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import junit.Calculator;

public class AssertNotEquals {
	
	@Test
	public void test1() {
		System.out.println("test1");
		assertNotEquals((byte)12, (byte)13);
		assertNotEquals(false, 2<=3);
		assertNotEquals(Integer.parseInt("12"),13);
		assertNotEquals(20,new Calculator().multiplication(8, 3));
		assertNotEquals('b','a'+2);
		assertNotEquals(12L,10);
		assertNotEquals(12.5 , 10+3,()->"This has failed");
		
	}
	
}

