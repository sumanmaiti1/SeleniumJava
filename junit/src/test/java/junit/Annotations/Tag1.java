package junit.Annotations;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

@Tag("Testing")
public class Tag1 {
	@Test
	void Test1() {
		System.out.println("Test1");
	}
	
	@Test
	@Tag("Regression")
	@Tag("Smoke")
	void Test2() {
		System.out.println("Test2");
	}
	
	@Test
	@Tags({@Tag("Regression"),@Tag("Regressiona")})
	void Test3() {
		System.out.println("Test3");
	}
}
