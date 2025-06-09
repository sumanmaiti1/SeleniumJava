package testNG.testNG.assertions;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertListContains;
import static org.testng.Assert.assertListContainsObject;
import static org.testng.Assert.assertListNotContains;
import static org.testng.Assert.assertListNotContainsObject;
import static org.testng.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

public class Assertion2 {
	
	@Test
	private void method1() {
		
		assertTrue(1>0); //------- True
		assertTrue(1+2==5-2); //------- True
		assertTrue('d'>'a'); //------- True
		assertTrue('d'-'a'==3); //------- True
		assertTrue('d'-'a'==3); //------- True
		assertFalse(2<1); //-------- True
		assertFalse("ABC".contains("Z")); //-------- True
		//assertFalse("ABC".contains("B")); //-------- False
		
		assertFalse(2>5, "2 is not Greater than 5 !!!"); //------------ true
		//assertFalse(2<5, "2 is not Greater than 5 !!!"); //----------- false
		
		assertTrue(1+1>0, "1+1 is not greater than 0 !!!");//------------ true
		//assertTrue(1+1<0, "1+1 is not less than 0 !!!"); //----------- false
	}
	
	@Test
	private void method2() {
		
		List<String> god = Arrays.asList(new String[] {"Ram","Krishna","Mahadev"});
		
		assertListContains(god, str->str.equals("Ram") , "Ram is Not present in the List !!!"); //--------- True
		//assertListContains(god, str->str.equals("Sashi") , "Sashi is Not present in the List !!!"); //--------- False
		assertListContainsObject(god, "Krishna", "Krishna Is Not present in the List !!!"); //------------ True
		//assertListContainsObject(god, "Mridul", "Mridul Is Not present in the List !!!"); //------------ False
		
		assertListNotContains(god, str->str.equals("sahil"), "Sahil is present in the List !!!"); //---------- True
		//assertListNotContains(god, str->str.equals("Mahadev"), "Mahadev is present in the List !!!"); //---------- False
		assertListNotContainsObject(god, "Ramjan", "Ramjan is present in the List !!!"); //--------- True
		//assertListNotContainsObject(god, "Ram", "Ram is present in the List !!!"); //--------- False
		
		
	}
}
