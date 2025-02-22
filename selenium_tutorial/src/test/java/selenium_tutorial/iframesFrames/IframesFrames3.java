/*
We will Discuss about handelling Nested Frames
Site : https://ui.vision/demo/webtest/frames/
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

public class IframesFrames3 {
	
	private WebDriver driver = BrowserFactory.getDriver("Chrome");
	private By frame_frame1 = By.xpath("//frame[contains(@src,'frame_1')]");
	private By frame_frame2 = By.xpath("//frame[contains(@src,'frame_2')]");
	private By frame_frame3 = By.xpath("//frame[contains(@src,'frame_3')]");
	private By frame_frame4 = By.xpath("//frame[contains(@src,'frame_4')]");
	private By frame_frame5 = By.xpath("//frame[contains(@src,'frame_5')]");
	private By frame_fameInsideFrame = By.xpath("//iframe[contains(@src,'forms')]");
	private By radioButton_iAmAHuman = By.cssSelector("#i9");
	private By textbox_myTest1 = By.name("mytext1");
	private By textbox_myTest2 = By.name("mytext2");
	private By textbox_myTest3 = By.name("mytext3");
	private By textbox_myTest4 = By.name("mytext4");
	private By textbox_myTest5 = By.name("mytext5");
	
	
	@Test
	public void test() {
		driver.get("https://ui.vision/demo/webtest/frames/");
		assertTrue(driver.getTitle().contains("Frames - Web Automation Test"));
		
		//----------------- Switch to Iframe 1  -------------
		driver.switchTo().frame(driver.findElement(frame_frame1));
		driver.findElement(textbox_myTest1).sendKeys("Jay Shree Krishna");
		assertTrue(driver.findElement(textbox_myTest1).getDomProperty("value").contains("Jay Shree Krishna"));		
		//-------------- Switching Outside of Frame 1 -------------
		driver.switchTo().defaultContent();
		
		
		//----------------- Switch to Iframe 2  -------------
		driver.switchTo().frame(driver.findElement(frame_frame2));
		driver.findElement(textbox_myTest2).sendKeys("Jay Shree Ram");
		assertTrue(driver.findElement(textbox_myTest2).getDomProperty("value").contains("Jay Shree Ram"));		
		//-------------- Switching Outside of Frame 1 -------------
		driver.switchTo().defaultContent();
		
		
		//----------------- Switch to Iframe 3  -------------
		driver.switchTo().frame(driver.findElement(frame_frame3));
		
			//----------- Switch Frame Inside Frame ----------
			driver.switchTo().frame(driver.findElement(frame_fameInsideFrame));
			driver.findElement(radioButton_iAmAHuman).click();			
			//--------------- Switching back to Parent Frame ---------------
			driver.switchTo().parentFrame();
		
			
		driver.findElement(textbox_myTest3).sendKeys("Har Har Mahadev");
		assertTrue(driver.findElement(textbox_myTest3).getDomProperty("value").contains("Har Har Mahadev"));		
		//-------------- Switching Outside of Frame 1 -------------
		driver.switchTo().defaultContent();
		
		
		//----------------- Switch to Iframe 4  -------------
		driver.switchTo().frame(driver.findElement(frame_frame4));
		driver.findElement(textbox_myTest4).sendKeys("Radhe Radhe");
		assertTrue(driver.findElement(textbox_myTest4).getDomProperty("value").contains("Radhe Radhe"));		
		//-------------- Switching Outside of Frame 1 -------------
		driver.switchTo().defaultContent();
		
		
		//----------------- Switch to Iframe 5  -------------
		driver.switchTo().frame(driver.findElement(frame_frame5));
		driver.findElement(textbox_myTest5).sendKeys("Jay Maa Durga");
		assertTrue(driver.findElement(textbox_myTest5).getDomProperty("value").contains("Jay Maa Durga"));		
		//-------------- Switching Outside of Frame 1 -------------
		driver.switchTo().defaultContent();		
	}
	
	@AfterEach
	public  void tearDown() {
		BrowserFactory.quitDriver();
		
	}
	
}
