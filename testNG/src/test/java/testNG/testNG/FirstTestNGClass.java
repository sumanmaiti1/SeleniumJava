package testNG.testNG;

import org.testng.annotations.Test;

public class FirstTestNGClass {
	
	@Test
	public void main()	{
		System.out.println("i am NOT java Mainmethod , but just user created TestNG method");
	}
	
	@Test
	public void suman()	{
		System.out.println("Hurray i can be called without Java's main method.");
	}
}
