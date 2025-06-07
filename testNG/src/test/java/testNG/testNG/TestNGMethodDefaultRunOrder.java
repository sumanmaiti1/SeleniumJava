//------------- This is demonstrate how test NG methods will be run by default -------------
//------------- What will be the order of the methods -------------
//.------------ It's based on te ASCII values of the method Name -----------
//------------ Some call it as Alphabetical order -----------

package testNG.testNG;

import org.testng.annotations.Test;

public class TestNGMethodDefaultRunOrder {

	@Test
	private void P() {
		System.out.println("Inside P");
	}
	@Test
	private void A13() {
		System.out.println("Inside A13");
	}
	@Test
	private void A() {
		System.out.println("Inside A");
	}
	
	@Test
	private void Z() {
		System.out.println("Inside Z");
	}
	@Test
	private void A130() {
		System.out.println("Inside A130");
	}
	@Test
	private void A12() {
		System.out.println("Inside A12");
	}
}
