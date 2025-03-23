package selenium_tutorial.robot;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium_tutorial.utilities.browserFactory.BrowserFactory;

public class Robot4 {
	
	WebDriver driver = BrowserFactory.getDriver("Chrome");
	
	private Robot robot = new Robot();
	private By img_selenium143Logo = By.xpath("//img[@alt='Selenium143 ']"); 
	
	private By button_rightClick = By.xpath("//span[text()='right click me']");
	
	private Robot4() throws AWTException{}

	//--------------- Upload File using Robot ------------------
	@Test
	public void test1() throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://omayo.blogspot.com/");		
		assertTrue(driver.getTitle().contains("omayo"));
		
		//-------------------- Clicking using Mouse ------------------
		
		robot.mouseMove(200, 275);
		robot.delay(1000);
		robot.mouseMove(200, 300);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		
		assertTrue(new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(img_selenium143Logo)).isDisplayed());
		
		System.out.println("sdsdsd");
	}

	@Test
	public void test2() {
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		assertTrue(driver.getTitle().contains("jQuery contextMenu (2.x)"));
		
		//Rectangle rect = driver.findElement(button_rightClick).getRect();
		robot.mouseMove(500,275);
		robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
		
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_ENTER);
		
		assertTrue(driver.switchTo().alert().getText().contains("clicked: quit"));
	}
	
	@AfterEach
	public void tearDown() {
		BrowserFactory.quitDriver();
	}
	
	
}
