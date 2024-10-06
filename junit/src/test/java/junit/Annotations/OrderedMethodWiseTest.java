package junit.Annotations;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(OrderAnnotation.class) //--------------- This is important for Method Order
public class OrderedMethodWiseTest {
	
	@Test
	@Order(0) //--------------- This is important for Method Order
	void Test1() {
		System.out.println("Test 1");
		assertEquals(2, 2);
	}
	
	@Test
	@Order(2) //--------------- This is important for Method Order
	void Test2() {
		System.out.println("Test 2");
		assertEquals(2, 2);
	}
	
	@Test
	@Order(1) //--------------- This is important for Method Order
	void Test3() {
		System.out.println("Test 3");
		assertEquals(2, 2);
	}
	

	
}
