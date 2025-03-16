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

public class Robot1 {
	
	WebDriver driver = BrowserFactory.getDriver("Chrome");
	private By textbox_search = By.xpath("//input[@name='search']");
	private By link_canonCamera = By.linkText("Canon EOS 5D");
	private By image_canonCamera = By.xpath("//img[@title='Canon EOS 5D']");
	private Robot robot = new Robot();
	
	private Robot1() throws AWTException{}

	//--------------- Keyboard key click using Robot ------------------
	@Test
	public void test1() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(textbox_search).sendKeys("canon");
		
		//------------ This equal to press ENTER from mouse -------------
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		
		assertAll("Checking if Canon Camera search Result is populated", 
				()->assertTrue(driver.findElement(link_canonCamera).isDisplayed()),
				()->assertTrue(driver.findElements(image_canonCamera).size()>0)
				);		
	}
	
	//--------------- Takes Screenshot using Robot ------------------
	@Test
	public void test2() throws IOException {
		//------------ Create object for Robot class -----------------
		File destinationFolder = new File("./src/test/java/selenium_tutorial/robot/Screenshots");
		destinationFolder.mkdir();
	
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle rect = new Rectangle(dimension);
		
		//------------ take screenshot of Whole screen -----------------
		File screenshotPath1 = new File(destinationFolder.getPath().concat("/robotScreenshot1.png"));
		BufferedImage bufferedImage1 = robot.createScreenCapture(rect);
		ImageIO.write(bufferedImage1,"png",screenshotPath1);
		
		assertTrue(screenshotPath1.exists());
		
		//-------------Delete the created files and Folder
		for(File item:destinationFolder.listFiles()) {
			if(item.isFile()) {
				item.delete();
			}
		}
		destinationFolder.delete();
	}
	
	@AfterEach
	public void tearDown() {
		BrowserFactory.quitDriver();
	}
	
	
}
