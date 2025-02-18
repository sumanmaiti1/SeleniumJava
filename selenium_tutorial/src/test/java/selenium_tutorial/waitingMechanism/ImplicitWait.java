/**
 * Apart from the Page Loading , Selenium won't wait for anything.
 * Sometimes we need to wait for some things in Webpage. Sometime thee are AJAX section in page
 * We need to wait for a specific amount of time at the time of Execution
 * Below are Waiting mechanism of Selenium.
 * 
 * 1) Java's Thread.sleep() -- Not recomended
 * 2) Implicit Wait - It's global setting applicable for all elements and if element appear before specified time than script will start executing 
 * 					  otherwise script will throw NoSuchElementException.  Instead of halting the program till the specified time is reached, 
 * 					  Implicit wait will wait for all the web elements dynamically (i.e. Global wait) 
 * 3) Explicit wait
 * 			i) Webdriver Wait
 * 		   ii) Fluent Wait
 */


package selenium_tutorial.waitingMechanism;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import selenium_tutorial.utilities.browserFactory.BrowserFactory;

public class ImplicitWait {
	
	private WebDriver driver = BrowserFactory.getDriver("chrome");
	private By button_dropdown = By.xpath("//button[text()='Dropdown']");
	private By link_facebook = By.linkText("Flipkart");
	
	@Test
	public void SriRam() throws InterruptedException {
		
		//--------------- Implicit wait ------------
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println("Implicit Wait Timeout = ".concat(driver.manage().timeouts().getImplicitWaitTimeout().toString()));
		
		driver.get("https://omayo.blogspot.com/");
		assertEquals("omayo (QAFox.com)",driver.getTitle());
		
		//Thread.sleep(2000); //------------- This Java method of Thread class, will wait 2 Seconds
		
		//---------------- Click dropdown button ------------
		driver.findElement(button_dropdown).click();
		//------------- This is delayed Dropdown. But it will be taken care by Implicit Wait----------
		assertTrue(driver.findElement(link_facebook).isDisplayed());
		
		driver.findElement(link_facebook).click();
		
		assertTrue(driver.getTitle().equalsIgnoreCase("Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!"));
		
		//------------ closed the driver -----------
		BrowserFactory.quitDriver();
	}
	
	
	
	
	
	//--------------- Main method -------------------
	public static void main(String[] args) {}

}
