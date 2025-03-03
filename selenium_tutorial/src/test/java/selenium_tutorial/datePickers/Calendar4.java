package selenium_tutorial.datePickers;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import selenium_tutorial.utilities.browserFactory.BrowserFactory;

public class Calendar4 {
	
	WebDriver driver = BrowserFactory.getDriver("Chrome");
	private By calendar_calendar1 = By.name("bdaytime");
	private By button_submit = By.xpath("//input[@type='submit']");
	private By label_confirmation = By.xpath("//div[contains(text(),'Your Birth Date is')]");
	
	
	@Test
	public void Test1() throws InterruptedException {	
		
		
		String dateOfJourney = "23-11-1900 23:59";
		
		driver.get("https://demo.guru99.com/test/");
		assertTrue(driver.getTitle().contains("Select Date from DatePicker Demo Page"));
		
		//----------------- set Calender by SendKeys ----------------
		driver.findElement(calendar_calendar1).sendKeys(dateOfJourney.split(" ")[0]);
		driver.findElement(calendar_calendar1).sendKeys(Keys.TAB);
		driver.findElement(calendar_calendar1).sendKeys(dateOfJourney.split(" ")[1]);
		Thread.sleep(1000);
		driver.findElement(button_submit).click();
		assertTrue("After Clicking on Sublit button confirmation Pop up is not populated. ",driver.findElement(label_confirmation).isDisplayed());
		
		
		//----------------- set Calender by SendKeys of Actions class----------------
		driver.get("https://demo.guru99.com/test/");
		dateOfJourney = "15-08-1950 00:00";
		
		WebElement element = driver.findElement(calendar_calendar1);;
		new Actions(driver).click(element).sendKeys(Keys.ARROW_LEFT).sendKeys(Keys.ARROW_LEFT).sendKeys(Keys.ARROW_LEFT).sendKeys(Keys.ARROW_LEFT)
				.sendKeys(dateOfJourney.split(" ")[0]).pause(200).sendKeys(Keys.TAB).pause(200).sendKeys(dateOfJourney.split(" ")[1]).build().perform();
		driver.findElement(button_submit).click();
		assertTrue("After Clicking on Sublit button confirmation Pop up is not populated. ",driver.findElement(label_confirmation).isDisplayed());
		
		
	}
	
	
	@AfterEach
	public void teardown() {
		BrowserFactory.quitDriver();
	}
	
}
