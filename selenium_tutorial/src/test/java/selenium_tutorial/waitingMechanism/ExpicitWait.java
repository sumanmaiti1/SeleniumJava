/**
 * Explicit wait in Selenium is a synchronization mechanism that allows the WebDriver to wait for a specific condition to occur before proceeding with
 *  the next step in the code. Unlike Implicit waits, which apply globally, explicit waits are applied only to specific elements or conditions, making 
 *  them more flexible and precise.
	Setting Explicit Wait is important in cases where there are certain elements that naturally take more time to load. If one sets an implicit wait 
	command, then the browser will wait for the same time frame before loading every web element. This causes an unnecessary delay in executing the test script.
	
	Explicit wait is more intelligent, but can only be applied for specified elements. However, it is an improvement on implicit wait since it allows the program 
	to pause for dynamically loaded Ajax elements.
	
	By Default Polling Frequency of Explicit wait is .5 Seconds.
	
	In order to declare explicit wait, one has to use ExpectedConditions. The following Expected Conditions can be used in Explicit Wait.

    alertIsPresent()
    elementSelectionStateToBe()
    elementToBeClickable()
    elementToBeSelected()
    frameToBeAvaliableAndSwitchToIt()
    invisibilityOfTheElementLocated()
    invisibilityOfElementWithText()
    presenceOfAllElementsLocatedBy()
    presenceOfElementLocated()
    textToBePresentInElement()
    textToBePresentInElementLocated()
    textToBePresentInElementValue()
    titleIs()
    titleContains()
    visibilityOf()
    visibilityOfAllElements()
    visibilityOfAllElementsLocatedBy()
    visibilityOfElementLocated()
 */


package selenium_tutorial.waitingMechanism;

import static org.junit.Assert.assertTrue;

import java.time.Duration;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium_tutorial.utilities.browserFactory.BrowserFactory;

public class ExpicitWait {
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
		
		//------------ Initiating webDriverWait here. Using that we will incorporate Explicit Wait -----------
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(link_facebook));
		element.click();
		
		assertTrue(driver.getTitle().equalsIgnoreCase("Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!"));
		
		driver.navigate().back();
		//------------ Checking if Omayo page is populated, Page One is Displayed -------------------
		assertTrue(new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.titleContains("omayo")));
		
		assertTrue(new WebDriverWait(driver, Duration.ofSeconds(30), Duration.ofSeconds(3)).until(
				ExpectedConditions.textToBePresentInElementLocated(link_pageOne, "Page One")));
		

		new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(button_dropdown)).click();
		
		//----------- Checking if Facebook Link is Displayed ------------
		assertTrue(new WebDriverWait(driver, Duration.ofSeconds(30), Duration.ofSeconds(3)).until(
				ExpectedConditions.visibilityOfElementLocated(button_dropdown)).isDisplayed());
		
		BrowserFactory.quitDriver();
	}
}