package selenium_tutorial.iframesFrames;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import selenium_tutorial.utilities.browserFactory.BrowserFactory;

public class IframesFrames1 {
	
	private WebDriver driver = BrowserFactory.getDriver("Chrome");
	private By link_whatIsSelenium = By.linkText("What is Selenium?");
	
	@Test
	public void Test_TryToAcessElementInsideFrameWithoutSwitching() {
		driver.get("https://omayo.blogspot.com/");
		assertTrue(driver.getTitle().contains("omayo"));
		
		try {
			assertTrue(driver.findElement(link_whatIsSelenium).isDisplayed());
		} catch (NoSuchElementException e) {
			System.out.println("NoSuchElement Exception is Caught , as we are trying to access an Element inside Frame without switching inside Frame.");
			assertTrue(true);
		}
	}
	
	@Test
	public void TestTest_TryToAcessElementInsideFrameWithSwitching() {
		driver.get("https://omayo.blogspot.com/");
		assertTrue(driver.getTitle().contains("omayo"));
		
		try {
			 
			//----------------- Switch to Iframe -------------
			driver.switchTo().frame("iframe2");
			
			assertTrue(driver.findElement(link_whatIsSelenium).isDisplayed());
			driver.findElement(link_whatIsSelenium).click();
			System.out.println("NoSuchElement Exception is  NOT Caught , as we are trying to access an Element inside Frame after switching inside Frame.");
			assertTrue(true);
			
		} catch (NoSuchElementException e) {
			System.out.println("NoSuchElement Exception is Caught , as we are trying to access an Element inside Frame without switching inside Frame.");
			assertTrue(false);
		}
	}
	
	@AfterAll
	public static void tearDown() {
		BrowserFactory.quitDriver();
		
	}
	
}
