package junit.Annotations;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
@DisplayName("Outer Class")
public class NestedTest {
	
	@Test
	void Test1() {
		System.out.println("Test1 method of Top Most Class");
	}
	
	@BeforeAll
	void beforeAll() {
		System.out.println("Before All method of Top Most Class\n");
	}
	
	@AfterAll
	void afterAll() {
		System.out.println("\nAfter All method of Top Most Class");
	}
	
	@BeforeEach
	void beforeEach() {
		System.out.println("Before Each method of Top Most Class");
	}
	
	@AfterEach
	void afterEach() {
		System.out.println("After Each method of Top Most Class");
	}
	
	@Nested
	@DisplayName("Primary Inner Class")
	class PrimaryClass{
		@Test
		void primaryTest() {
			System.out.println("Test1 method of First Level inner Class");
		}
		
		@BeforeAll
		static void beforeAll() {
			System.out.println("Before All method of Primary inner Class\n");
		}
		
		@AfterAll
		static void afterAll() {
			System.out.println("\nAfter All method of Primary inner Class");
		}
		
		@BeforeEach
		void beforeEach() {
			System.out.println("Before Each method of Primary inner Class");
		}
		
		@AfterEach
		void afterEach() {
			System.out.println("After Each method of Primary inner Class");
		}
		
		@Nested
		@DisplayName("Inner Class of Primary Inner Class")
		@TestInstance(Lifecycle.PER_CLASS)
		class InnerClassOfPrimaryClass{
			@Test
			void primaryTest() {
				System.out.println("Test1 method of inner Class of First Level inner Class");
			}
			
			@BeforeAll
			void beforeAll() {
				System.out.println("Before All method of InnerClassOfPrimaryClass inner Class\n");
			}
			
			@AfterAll
			void afterAll() {
				System.out.println("\nAfter All method of InnerClassOfPrimaryClass inner Class");
			}
			
			@BeforeEach
			void beforeEach() {
				System.out.println("Before Each method of InnerClassOfPrimaryClass inner Class");
			}
			
			@AfterEach
			void afterEach() {
				System.out.println("After Each method of InnerClassOfPrimaryClass inner Class");
			}
		}
	}
	
}
