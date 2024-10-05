package junit.Annotations;

import org.junit.jupiter.api.ClassOrderer;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestClassOrder;

@TestClassOrder(ClassOrderer.OrderAnnotation.class)
 class OrderedClassWise {
	
	@Nested
	@Order(1)
	class Primary{
		@Test
		void Test1() {
			System.out.println("Test 1 of InnerClass Primary");
		}
	}
	
	@Nested
	@Order(0)
	class Secondary{
		@Test
		void Test1() {
			System.out.println("Test 1 of InnerClass Secondary");
		}
	}
	
}
