package junit.Annotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

public class ParameterizedTest1 {
	
	@ParameterizedTest
	@ValueSource(strings = { "race car", "radar", "able was I ere I saw elba" })
	void Test1(String str){
		System.out.println("Testing with : " + str );
		assertNotEquals(false, StringUtils.containsWhitespace(str),str + " doesn't contain whiteSpace");
	}
	
	
	@ParameterizedTest
	@ValueSource(ints = { 2,4,6,5,8,3,-4,0 })
	void Test2(int i){
		System.out.println("Testing with : " + i );
		assertEquals(true, i%2==0, i + " is not Even number");
	}
}
