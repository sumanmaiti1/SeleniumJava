package junit.Assertions;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class AssertFalseTrueTest {
	@Test
	void Test1(){
		System.out.println("Test1");
		assertTrue(2>=2);
		//assertTrue(false);
		assertTrue("Assert True Or False", 2<3);
		assertTrue("Jay Shree Krishna".contains("Krishna"));
		
		
		assertFalse(2>=3);
		//assertTrue(false);
		assertFalse("Assert True Or False", 2>3);
		assertFalse("Jay Shree Krishna".contains("Sri Krishna"));
	}
}
