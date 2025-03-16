package selenium_tutorial.robot;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Driver;
import java.time.Duration;

import javax.imageio.ImageIO;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import selenium_tutorial.utilities.browserFactory.BrowserFactory;

public class Robot2 {
	
	WebDriver driver = BrowserFactory.getDriver("Chrome");
	private By textbox_search = By.xpath("//input[@name='search']");
	private By button_search = By.xpath("//*[@id=\"search\"]//button");
	private By link_canonCamera = By.linkText("Canon EOS 5D");
	private By image_canonCamera = By.xpath("//img[@title='Canon EOS 5D']");
	private Robot robot = new Robot();
	
	private Robot2() throws AWTException{}

	//--------------- Mouse Wheel using Robot ------------------
	@Test
	public void test1() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(textbox_search).sendKeys("canon");
		driver.findElement(button_search).click();

		//------------- equilavent to Thread.sleep()  ----------------
		robot.delay(2000);
		
		assertAll("Checking if Canon Camera search Result is populated", 
				()->assertTrue(driver.findElement(link_canonCamera).isDisplayed()),
				()->assertTrue(driver.findElements(image_canonCamera).size()>0)
				);
		
		//------------------ Doing Mouse Wheel ---------------
		robot.mouseWheel(10); //------------- Scroll down
		robot.delay(2000);
		robot.mouseWheel(-5); //------------- Scroll up
		robot.delay(2000);
	}
	
	@AfterEach
	public void tearDown() {
		BrowserFactory.quitDriver();
	}
	
	
}
