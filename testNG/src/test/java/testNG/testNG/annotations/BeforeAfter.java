package testNG.testNG.annotations;

import org.testng.annotations.*;

public class BeforeAfter {
	
	@BeforeClass
	private static void beforeClass() {
		System.out.println("\t\t--- Before Class ---");
	}
	
	
	@AfterClass
	private static void afterClass() {
		System.out.println("\t\t--- After Class ----");
	}
	
	
	@BeforeSuite
	private static void beforeSuite() {
		System.out.println("--- Before Suite ---");
	}
	
	
	@AfterSuite
	private static void afterSuite() {
		System.out.println("--- After Suite ----");
	}
	
	@BeforeTest
	private static void beforeTest() {
		System.out.println("\t---Before Test -----");
	}
	
	
	@AfterTest
	private static void afterTest() {
		System.out.println("\t---After Test ---");
	}
	
	@BeforeMethod
	private static void beforeMethod() {
		System.out.println("\t\t\t-- Before Method ---");
	}
	
	
	@AfterMethod
	private static void afterMethod() {
		System.out.println("\t\t\t-- After Method ----");
	}
	
		
	@Test
	private static void test1() {
		System.out.println("\t\t\t\t-- Executing Test1 ---");
	}
	@Test
	private static void test3() {
		System.out.println("\t\t\t\t-- Executing Test3 ---");
	}
	
	@Test
	private static void test2() {
		System.out.println("\t\t\t\t-- Executing Test2 ---");
	}
	@Test
	private static void test() {
		System.out.println("\t\t\t\t-- Executing Test ---");
	}
}
