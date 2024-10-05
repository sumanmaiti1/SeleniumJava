package junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 * This class is the first Test Class Created for Junit 5
 */

public class FirstJunit {
    @Test
    void JayShreeKrishna(){
        assertEquals(2,2,"This is not Equal");
        //assertEquals(2,1,"This is not Equal");
    }
}