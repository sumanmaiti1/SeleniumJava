package junit.Annotations;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledForJreRange;
import org.junit.jupiter.api.condition.DisabledIf;
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.DisabledOnJre;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

public class DisabledOnCondition {
	
	@Test
	void Test1() {
		System.out.println("Test 1");
	}
	
	@Test
	@DisabledForJreRange(min = JRE.JAVA_17) //------------- Disabling on Min JRE
	void Test2() {
		System.out.println("Test 2");
	}
	
	@Test
	@DisabledForJreRange(max = JRE.JAVA_22) //------------- Disabling on Max JRE
	void Test3() {
		System.out.println("Test 3");
	}
	
	@Test
	@DisabledForJreRange(min = JRE.JAVA_17, max = JRE.JAVA_22)
	void Test4() {
		System.out.println("Test 4");
	}
	
	@Test
	@DisabledOnOs(value = OS.WINDOWS)
	void Test5() {
		System.out.println("Test 5");
	}
	
	@Test
	@DisabledIfEnvironmentVariable(named = "ENV", matches = "staging-server")
	void Test6() {
		System.out.println("Test 6");
	}
	
	@Test
	@DisabledIf("TestFunction")
	void Test7() {
		System.out.println("Test 7");
	}
	
	boolean TestFunction() {
		return true;
	}
	
}
