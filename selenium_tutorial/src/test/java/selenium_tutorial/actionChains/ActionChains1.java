package selenium_tutorial.actionChains;

import static org.junit.Assert.assertTrue;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium_tutorial.utilities.browserFactory.BrowserFactory;

public class ActionChains1 {
	
	WebDriver driver = BrowserFactory.getDriver("Chrome");
	private By button_dropdown = By.xpath("//button[text()='Dropdown']");
	private By button_clickToGetAlert = By.id("alert1");
	private By button_checkThis = By.xpath("//button[text()='Check this']");
	private By checkBox_mrOption = By.id("dte");
	private By textbox_textarea2 = By.xpath("//div[@id='HTML11']//textarea");
	
	@Test
	public void Test1() throws InterruptedException {
		driver.get("https://omayo.blogspot.com/");
		assertTrue(driver.getTitle().contains("omayo"));
		
		//--------------- moveToElement() , moveToLocation,  perform() -------------
		System.out.println("Moving down to Dropdown button");
		new Actions(driver).moveToElement(driver.findElement(button_dropdown)).perform();
		Thread.sleep(1000);
		System.out.println("Moving up to ClickToGetAlert button");
		new Actions(driver).moveToElement(driver.findElement(button_clickToGetAlert),-10,-5).perform();
		Thread.sleep(1000);
		Rectangle rect =  driver.findElement(button_checkThis).getRect();
		
		System.out.println("Moving down to -" + Math.abs(rect.getX()) + ":" + (rect.getY()-2000));
		new Actions(driver).moveToLocation(Math.abs(rect.getX())+1200, rect.getY()-2000).perform();
		Thread.sleep(1000);
		
		//----------------click(WebElement) ---------------
		new Actions(driver).click(driver.findElement(button_checkThis)).perform();
		assertTrue(new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.elementToBeClickable(checkBox_mrOption)).isEnabled());
		
		//---------------- Sendkeys(), keyDown(),KeyUp(), build() --------------
		//---------------- This clears theText of Text area field using CTRL A+ DELETE then sendKeys() ----------
		new Actions(driver).click(driver.findElement(textbox_textarea2)).keyDown(Keys.CONTROL).pause(1L).sendKeys("A")
							.keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).pause(1).sendKeys("Jay Shree Krishna").build().perform();
		assertTrue(driver.findElement(textbox_textarea2).getDomProperty("value").equalsIgnoreCase("Jay Shree Krishna"));
		Thread.sleep(1000);
	}
	
	@AfterEach
	public void teardown() {
		BrowserFactory.quitDriver();
	}
	
}
