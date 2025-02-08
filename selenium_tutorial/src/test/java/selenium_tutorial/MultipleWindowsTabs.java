

package selenium_tutorial;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Driver;
import java.time.Duration;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

import selenium_tutorial.utilities.browserFactory.BrowserFactory;

public class MultipleWindowsTabs {
	
	private WebDriver driver = BrowserFactory.getDriver("Chrome");	
	private By link_OpenAPopUpWindow = By.linkText("Open a popup window");
	private By link_blogger = By.linkText("Blogger");
	private By textbox_testArea1 = By.id("ta1"); 
	
	@Test
	public void Test1() throws InterruptedException {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		driver.get("https://omayo.blogspot.com/");
		assertTrue(driver.getTitle().contains("omayo"));
		
		System.out.println(driver.getWindowHandles().size()); //------------ Return all the window Handles count
		String workingWindowHandle = driver.getWindowHandle();
		System.out.println(workingWindowHandle); //---------------- This will only work for Single window.
		
		driver.findElement(link_OpenAPopUpWindow).click();
		driver.findElement(link_blogger).click();
		
		driver.switchTo().newWindow(WindowType.WINDOW).get("https://google.com");
		System.out.println(driver.getTitle());
		
		driver.switchTo().newWindow(WindowType.TAB).get("https://facebook.com");
		System.out.println(driver.getTitle());
		
		//----------------- verify 3 Windows/ Tab are opened -------------
		assertEquals(5, driver.getWindowHandles().size());
		
		//----------------- Iterate Through all the Windows, Fetch it's Title adn Close 2 of them -----------
		for(String window: driver.getWindowHandles()) {
			driver.switchTo().window(window); //--------------- Switching to Different window by Window Handle String ---------
			System.out.println(driver.getTitle());
			if(!driver.getTitle().contains("omayo")) {				
				driver.close(); //------------------------This will only close active window -----------------
			}
		}
		
		driver.switchTo().window(workingWindowHandle);
		driver.findElement(textbox_testArea1).clear();
		driver.findElement(textbox_testArea1).sendKeys("Har Har Mahadev");
		assertEquals(driver.findElement(textbox_testArea1).getDomProperty("value"),"Har Har Mahadev");
		Thread.sleep(1000);
		// driver.quit(); //------------------------This will close all the windows opened by Script -----------------
		BrowserFactory.quitDriver();
	}
	
}
