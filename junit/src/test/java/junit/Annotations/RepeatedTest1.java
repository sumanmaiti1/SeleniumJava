package junit.Annotations;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;

public class RepeatedTest1 {
	
	@BeforeEach
    void beforeEach(TestInfo testInfo, RepetitionInfo repetitionInfo) {
        int currentRepetition = repetitionInfo.getCurrentRepetition();
        int totalRepetitions = repetitionInfo.getTotalRepetitions();
        String methodName = testInfo.getTestMethod().get().getName();
        System.out.println(String.format("About to execute repetition %d of %d for %s", currentRepetition, totalRepetitions, methodName));
    }
	
	
	@RepeatedTest(failureThreshold = 2, value = 10, name = "Jay Shree Krishna")
	void Test1(RepetitionInfo repetitionInfo){
		assertEquals(true, repetitionInfo.getCurrentRepetition()>=2);
	}
	
	@RepeatedTest(failureThreshold = 2, value = 10, name = "Jay Shree Krishna")
	void Test2(RepetitionInfo repetitionInfo){
		assertEquals(true, repetitionInfo.getCurrentRepetition()<5);
	}
	
	@RepeatedTest(failureThreshold = 6, value = 10, name = "Jay Shree Krishna")
	void Test3(RepetitionInfo repetitionInfo, TestReporter testReporter){
		testReporter.publishEntry("Har Har Mahadev");
		testReporter.publishEntry("Har Har Mahadev","Om Namah Shivaya");
		assertEquals(true, repetitionInfo.getCurrentRepetition()<5);
		testReporter.publishEntry("Har Har Mahadev");		
	}
	
}
