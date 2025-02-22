/*
 * Different ways we can switch to the frames
  		Using id locator of frame	Practical Demonstration - https://omayo.blogspot.com/
  		Using name locator of frame	Practical Demonstration - https://docs.oracle.com/javase/8/docs/api/
  		Using WebElement of a frame	Example: https://docs.oracle.com/javase/8/docs/api/
  		Using index of a frame. Finding number of frames on the page https://omayo.blogspot.com/
 * 
 */

package selenium_tutorial.iframesFrames;

import static org.junit.Assert.assertTrue;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium_tutorial.utilities.browserFactory.BrowserFactory;

public class IframesFrames2 {
	
	private WebDriver driver = BrowserFactory.getDriver("Chrome");
	private By textbox_q = By.name("q");
	private By image_selenium143 = By.xpath("//img[contains(@alt,'Selenium143')]");
	private By link_whatIsSelenium = By.linkText("What is Selenium?");
	private By link_abstractAction = By.linkText("AbstractAction");
	private By frame_classFrame = By.xpath("//frame[@title='Package, class and interface descriptions']");
	private By label_classAbstraction = By.cssSelector("h2[title='Class AbstractAction']");
	
	@Test
	public void test_SwitchByID() {
		driver.get("https://omayo.blogspot.com/");
		assertTrue(driver.getTitle().contains("omayo"));
		
		//----------------- Switch to Iframe by ID -------------
		driver.switchTo().frame("iframe2");
		assertTrue(driver.findElement(link_whatIsSelenium).isDisplayed());
		
	}
	
	@Test
	public void test_SwitchByNameAndWebElemet() {
		driver.get("https://docs.oracle.com/javase/8/docs/api/");
		assertTrue(driver.getTitle().contains("Overview (Java Platform SE 8 )"));
		
		//----------------- Switch to Iframe By Name -------------
		driver.switchTo().frame("packageFrame");
		
		assertTrue(driver.findElement(link_abstractAction).isDisplayed());
		driver.findElement(link_abstractAction).click();
		
		//---------------- Move back to Parent Page --------------
		driver.switchTo().defaultContent();
		
		//----------------- Switch to Iframe By WebElement -------------
		driver.switchTo().frame(driver.findElement(frame_classFrame));
		assertTrue(new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(label_classAbstraction)).isDisplayed());
		
	}
	
	@Test
	public void test_SwitchByIndex() {
		driver.get("https://omayo.blogspot.com/");
		assertTrue(driver.getTitle().contains("omayo"));
		
		//-------------- Finding the Number of iFrames present in Page ------------
		System.out.println("Number of Iframes Present in The page : " + driver.findElements(By.cssSelector("iframe")).size());
		
		//----------------- Switch to Iframe by ID -------------
		for(int i=0;i<driver.findElements(By.cssSelector("iframe")).size() ;i++) {	
			System.out.println("Switching to Frame " + i);
			driver.switchTo().frame(i);
			
			if(i==0) {
				assertTrue(driver.findElement(textbox_q).isDisplayed());
			}else if(i==1) {
				assertTrue(driver.findElement(image_selenium143).isDisplayed());
			}else if(i==2) {
				assertTrue(driver.findElement(link_whatIsSelenium).isDisplayed());
			}
			//---------------- Move back to Parent Page --------------			
			driver.switchTo().defaultContent();
			
		}
	}
	
	@AfterEach
	public  void tearDown() {
		BrowserFactory.quitDriver();
		
	}
	
}
