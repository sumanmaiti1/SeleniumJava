package selenium_tutorial.waitingMechanism;
import static org.junit.Assert.assertTrue;

import java.time.Duration;
import java.util.function.Function;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import selenium_tutorial.utilities.browserFactory.BrowserFactory;

public class FluentWaits {
	private WebDriver driver = BrowserFactory.getDriver("chrome");
	private By button_dropdown = By.xpath("//button[text()='Dropdown']");
	private By link_facebook = By.linkText("Flipkart");
	private By link_pageOne =By.linkText("Page One"); 
	
	@Test
	public void Test() {
		
		driver.get("https://omayo.blogspot.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		assertTrue(driver.getTitle().equalsIgnoreCase("omayo (QAFox.com)"));
		
		driver.findElement(button_dropdown).click();
		
		//------------ Initiating Fluent Wait -----------
		// Waiting 30 seconds for an element to be present on the page, checking
		// for its presence once every 5 seconds.

		
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			       .withTimeout(Duration.ofSeconds(30L))
			       .pollingEvery(Duration.ofSeconds(5L))
			       .ignoring(NoSuchElementException.class);

	   WebElement buttonDropdown = wait.until(new Function<WebDriver, WebElement>() {
	     public WebElement apply(WebDriver driver) {
	       return driver.findElement(button_dropdown);
	     }
	   });
		
	   //buttonDropdown.click();
	   wait.until(ExpectedConditions.presenceOfElementLocated(link_facebook)).click();	   
	   assertTrue(driver.getTitle().equalsIgnoreCase("Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!"));		
	}
	
	@AfterEach
	public void tearDown() {
		BrowserFactory.quitDriver();
	}
}