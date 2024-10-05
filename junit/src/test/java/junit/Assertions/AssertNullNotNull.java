package junit.Assertions;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.jupiter.api.Test;

public class AssertNullNotNull {
	
	String s;
	@Test
	void Test1() {
		System.out.println("Test1");
		assertNull(s);
		
		s="Jay Shree Ram";
		assertNotNull(s);
	}
}
