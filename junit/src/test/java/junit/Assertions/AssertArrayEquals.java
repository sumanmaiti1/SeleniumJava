package junit.Assertions;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

import junit.Calculator;

public class AssertArrayEquals {
	@Test
	public void test1() {
		System.out.println("test1");
		assertArrayEquals(new int[] {2,4,6}, new int[] {2,4,6}, "Two int Arrays are not equal");
		assertArrayEquals(new short[] {2,4,6}, new short[] {2,4,6}, "Two short Arrays are not equal");
		assertArrayEquals(new byte[] {2,4,6}, new byte[] {2,4,6}, "Two byte Arrays are not equal");
		assertArrayEquals(new long[] {2,4,6}, new long[] {2,4,6}, "Two Long Arrays are not equal");
		assertArrayEquals(new double[] {2.1,4.3,6.9}, new double[] {2.1,4.3,6.9}, "Two double Arrays are not equal");
		assertArrayEquals(new float[] {2.1f,4.3f,6.9f}, new float[] {2.1f,4.3f,6.9f}, "Two float Arrays are not equal");
	}
}
