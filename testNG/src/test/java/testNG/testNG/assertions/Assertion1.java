package testNG.testNG.assertions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertEqualsDeep;
import static org.testng.Assert.assertEqualsNoOrder;
import static org.testng.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import org.testng.annotations.Test;

	public class Assertion1 {
		
		@Test
		private void method1() {
			
			assertEquals(false, 1>2); //-------- True
			assertEquals(true, 1<2); //-------- True
			//assertEquals(true, "ABC".contains("Z")); //-------- False
			assertEquals(2, 2.00); //-------- True
			assertEquals("Jay Shree Ram", "Jay ".concat("Shree ".concat("Ram"))); //-------- True
			//assertEquals(10, 4*3, "4*3 is not Equal to 10."); //-------- False
			assertEquals("Jay Shree Krishna".split(" "),new String[] {"Jay","Shree","Krishna"}); //-------- True		
			//assertEquals("Jay Shree Krishna".split(" "),new String[] {"Shree","Krishna","Jay"}, "Two Arrays are not the same"); //-------- False
			assertEquals(new ArrayList<Integer>() {{add(0,10);}{add(1,20);}} , new ArrayList<Integer>() {{add(0,2*5);}{add(1,5*4);}} );
			
			
			assertNotEquals(2.5*4 , 10); //------------- True
			//assertNotEquals(2.5*4 , 10.0); //------------- False
			assertNotEquals(new String("Har har Mahadev"), "Har" + "Har" + "Mahadev"); //------------- True
			//assertNotEquals(new String("Har har Mahadev"), new String("Har har Mahadev"), "These two are same !!!"); //------------ False
			
		}
		
		@Test
		private void method2() {
			assertEqualsDeep(new HashSet<String>(Arrays.asList("A","C","A","B")), new HashSet<String>(Arrays.asList("A","B","A","C","C"))); //---- True
			//assertEqualsDeep(new HashSet<String>(Arrays.asList("A","C","D","B")), new HashSet<String>(Arrays.asList("A","B","A","C","C"))); //- False
			assertEqualsNoOrder(new Object[] {"Krishna","Ram"}, new Object[] {"Ram","Krishna" },"Two Arays are not same !!!"); //---- True
			
		}
	}
