package junit.Assertions;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import junit.Calculator;

public class AssertIterableEqualsAndMiscs {
	
	Calculator cal = new Calculator();
	
	@Test
	void test1() {
		System.out.println("Test1");
		List<Integer> l= List.of(1,2,3,4,5,6);
		List<Integer> ll= Arrays.asList(1,2,3,4,5,6);
		
		assertIterableEquals(ll, l);
		
		Object o = new String("Jay Shree Krishna");
		assertInstanceOf(java.lang.String.class, o);
		assertTimeout(Duration.ofSeconds(2), () -> {
            // Perform task that takes less than 2 Seconds.
			cal.addition(10,20);
			cal.division(10, 2);
			cal.subtraction(2, -2);
			cal.multiplication(5, 5);
			cal.power(10, 4);
			Thread.sleep(Duration.ofSeconds(2)); //------------------ This will make the assertion Fail
			
			
        });
	}
}
