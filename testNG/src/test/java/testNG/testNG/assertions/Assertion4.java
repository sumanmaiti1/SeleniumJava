package testNG.testNG.assertions;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;
import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Assertion4 {
	
	@Test(expectedExceptions = {Exception.class})
	private void method1() throws Exception {
		assertEquals(1l, 1l);
		throw new Exception("Jay Shree Ram");		
	}
	
	@Test
	private void method2()  {
		//fail();
		//fail("Fail to Say Har har Mahadev !!!");
		//fail("Fail to Say Jay Shree Ram !!!", new IllegalAccessException("You don't belong Here !!!"));
	}
}
