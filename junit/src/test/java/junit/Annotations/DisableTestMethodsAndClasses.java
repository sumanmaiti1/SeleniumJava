package junit.Annotations;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;

class DisableTestMethodsAndClasses {
	
	@Test
	void Test1() {
		System.out.println("Test 1");
		assertEquals(2, 2);
	}
	
	@Test
	@Disabled //---------------- This Test Method will be Disabled
	void Test2() {
		System.out.println("Test 2");
	}
	
	@Test
	void Test3() {
		System.out.println("Test 3");
	}
	
	@Nested
	class NestedClass1{
		@Test
		void Test4() {
			System.out.println("Test 4");
		}
		
		@Test
		@Disabled //---------------- This Test Method will be Disabled
		void Test41() {
			System.out.println("Test 41");
		}
	}
	
	@Nested
	@Disabled("This has an Existing Bug. CMIT-12345  ") //---------------- This Test Class will be Disabled
	class NestedClass2{
		@Test
		void Test5() {
			System.out.println("Test 5");
		}
		
		@Test
		@Disabled
		void Test51() {
			System.out.println("Test 51");
		}
	}
	
}
