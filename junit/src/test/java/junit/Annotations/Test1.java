package junit.Annotations;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import junit.Calculator;

//@TestInstance(Lifecycle.PER_CLASS) --------------- Single Instance of Class for all the Methods/tests
@TestInstance(Lifecycle.PER_METHOD) //--------------- Diff Instance of Class for each the Methods/tests
public class Test1 {

    //------------- @Test annotations. Used to indicate if a method is a test. 
    @Test
    public void testMethod(){
        System.out.println("I will be considered as test method as i have @Test annotation");
        assertEquals(2, 1+1);
    }

    @Test
    void anotherMethod(){
        System.out.println("I too will be considered as test method as i have @Test annotation");
        assertEquals(6, 3,"FAILED");
    }

    void normalMethod(){
        System.out.println("I am Normal Method. NOT a Test Method");
    }
}
