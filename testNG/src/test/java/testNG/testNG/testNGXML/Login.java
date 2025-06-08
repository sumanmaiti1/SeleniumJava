//-------------- This is Demo Login Class ---------------

package testNG.testNG.testNGXML;

import org.testng.annotations.Test;

public class Login {
	
	@Test
	private void validLogin() {
		System.out.println("Valid Login");
	}
	
	@Test
	private void inValidLoginWrongPassword() {
		System.out.println("inValid Login Wring Password.");
	}
	
	@Test
	private void inValidLoginWringUserName() {
		System.out.println("inValid Login Wrong User name");
	}
	
	@Test
	private void demoLoginmethod1() {
		System.out.println("demo login method 1");
	}
	
	@Test
	private void demoLoginmethod2() {
		System.out.println("demo Login method 2");
	}
}
