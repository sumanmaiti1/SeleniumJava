package testNG.testNG.assertions;


import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertNotEqualsDeep;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNotSame;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertSame;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.testng.annotations.Test;

public class Assertion3 {
	
	@Test
	private void method1() {
		
		List<Integer> list = new ArrayList<Integer>() {{add(0, 1);}; {add(1, 2);}; {add(2, 3);}};
		//assertNotEquals(list ,List.of(1,2,3)); //----------- False
		//assertNotEquals(list , List.of(1,1+1,1+1+1) ); //----------- False
		//assertNotEquals(list , list, "Two List are same !!!" ); //----------- False
		
		assertNotEquals(list ,List.of(1,2,3,4)); //----------- True
		assertNotEquals(list , List.of(1,1+1,1+1+1, 2+2) , "two List are same !!!"); //----------- True
		
		assertNotEquals(1.000005f, 1.000004, .000001, "Two Float values are same !!!"); //--------- True
		//assertNotEquals(1.000005f, 1.000004, .000002, "Two Float values are same !!!"); //---------- False
		
		assertNotEquals(2, 1+5, " oh No Both are same !!!"); //--------------True
		//assertNotEquals(2, 1+1, " oh No Both are same !!!"); //------------ False
		
		assertNotEquals("Shree Ram", "Shree".concat("Ram"), " oh No Both are same !!!"); //--------------True
		//assertNotEquals("Shree Ram", "Shree ".concat("Ram"), " oh No Both are equal !!!"); //--------------False
		
		//assertNotEqualsDeep(Set.of("Ram","Shyam","Shankar"), new HashSet<String>(){{add("Ram");}; {add("Shyam");}; {add("Ram");}; {add("Shankar");};} ,
		//		"Both Set are same !!!");		//---------- False
		assertNotEqualsDeep(Set.of("Ram","Shankar","Shyam"), new HashSet<String>(){{add("Ram");}; {add("Shyam");}; {add("Madhu");}; {add("Shankar");};}, 
				"Both Set are Same !!");  //------------ True
		assertNotEqualsDeep(Set.of("Ram","Shankar"), new HashSet<String>(){{add("Ram");}; {add("Shyam");};} ,	"Both Set are Same !!");  //------------ True
		
	}
	
	@Test
	private void method2() {
		
		String str1 = null ;
		//assertNotNull(str1); //----------- False
		assertNotNull(new String("Jay Shree Krishna")); //----------- True
		
		assertNull(str1 , "Object is Not Null !!!"); //------------ True
		//assertNull(new String("Jay Shree Krishna") , "Object is Not Null !!!"); //------------ True
		
		int[] intArray = new int[] {1,2,3};
		assertNotSame(new int[] {1, 2, 3} , new int[] {1,2,3}); //------ True
		//assertNotSame(intArray , intArray); //------ False
		
		//assertSame(new int[] {1, 2, 3} , new int[] {1,2,3}, "Both are NOT same !!!"); //------ False
		assertSame(intArray , intArray ,"Both are not same !!!"); //------ True
	}
}
