package junit.Annotations;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

@Timeout(unit= TimeUnit.SECONDS ,value=2)
public class TimeOutTest {
	
	@Timeout(2)
	@Test
	void test1() throws InterruptedException {
		Thread.sleep(5000);
		System.out.println("Test1");
	}
	
	@Test
	@Timeout(unit = TimeUnit.SECONDS, value = 2)
	void test2() throws InterruptedException {
		Thread.sleep(5000);
		System.out.println("Test2");
	}
	
	@Timeout(2)
	@Test
	void test3() {
		System.out.println("Test3");
	}
}
