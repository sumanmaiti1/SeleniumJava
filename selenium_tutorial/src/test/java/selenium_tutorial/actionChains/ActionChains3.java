package selenium_tutorial.actionChains;

import static org.junit.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium_tutorial.utilities.browserFactory.BrowserFactory;

public class ActionChains3 {
	
	WebDriver driver = BrowserFactory.getDriver("Chrome");
	private By textbox_firstName = By.id("input-firstname");
	private By checkBox_agree = By.name("agree");
	private By label_success = By.xpath("//h1[text()='Your Account Has Been Created!']");
	private String email = "shreekrishna".concat(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())).concat("@gmail.com") ;

	
	@Test
	public void Test1() throws InterruptedException {
		driver.get("http://tutorialsninja.com/demo/index.php?route=account/register");
		assertTrue(driver.getTitle().contains("Register Account"));
		
		new Actions(driver).click(driver.findElement(textbox_firstName)).sendKeys("Shree").sendKeys(Keys.TAB).sendKeys("Krishna")
							.sendKeys(Keys.TAB).sendKeys(email).sendKeys(Keys.TAB).sendKeys("9876543210").sendKeys(Keys.TAB)
							.sendKeys("Password").sendKeys(Keys.TAB).sendKeys("Password").sendKeys(Keys.TAB)
							.sendKeys(Keys.TAB).pause(1000).sendKeys(Keys.TAB).pause(1000).sendKeys(Keys.TAB).pause(1000)
							.sendKeys(Keys.TAB).pause(1000).click(driver.findElement(checkBox_agree)).sendKeys(Keys.TAB)
							.sendKeys(Keys.ENTER).build().perform(); //
		
		assertTrue(new WebDriverWait(driver,Duration.ofSeconds(5)).until(ExpectedConditions
								.visibilityOfElementLocated(label_success)).isDisplayed());
							
	}
	
	@AfterEach
	public void teardown() {
		BrowserFactory.quitDriver();
	}
	
}
