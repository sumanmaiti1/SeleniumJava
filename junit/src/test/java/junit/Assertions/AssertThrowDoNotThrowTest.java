package junit.Assertions;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import junit.Calculator;

public class AssertThrowDoNotThrowTest {
	@Test
	void Test1() {
		System.out.println("Test1");
		Exception exception = assertThrows(IndexOutOfBoundsException.class, () ->"Jay Shree Ram".charAt(100));
		System.out.println(exception.getClass().getName());
		assertEquals("java.lang.StringIndexOutOfBoundsException", exception.getClass().getName());
		
		
		char ch = assertDoesNotThrow(() ->"Jay Shree Ram".charAt(10), "SomeThing wrong Happened");
		assertEquals(ch, 'R');
		
	}
}
