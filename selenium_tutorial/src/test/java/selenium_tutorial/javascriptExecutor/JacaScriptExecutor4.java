package selenium_tutorial.javascriptExecutor;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import selenium_tutorial.utilities.browserFactory.BrowserFactory;

public class JacaScriptExecutor4 {
	
	WebDriver driver = BrowserFactory.getDriver("Chrome");	
	private By textbox_airportFrom = By.id("form-field-travel_from");
	private By button_search = By.xpath("//button[contains(@class,'elementor-button elementor-size-sm')]");
	private By label_postATravelCompanionRequest = By.xpath("//span[normalize-space(text())='POST A TRAVEL COMPANION REQUEST']");
	
	private By div_rightScroll = By.xpath("//div[@class='scroll-container']");
	
	@Test
	public void test() throws InterruptedException {
		
		driver.get("https://www.path2usa.com/travel-companion/");
		JavascriptExecutor jse = ((JavascriptExecutor)driver);

		//------------- PageScroll by PIXEL using javaScriptExecutor ----------------
		jse.executeScript("window.scrollBy(0,2000)", "");
		Thread.sleep(1000);
		jse.executeScript("window.scrollBy(0,-1000)", ""); //---------------- This Doesn't work ---------------
		Thread.sleep(1000);
		
		//------------- PageScroll till an webElement using javaScriptExecutor ----------------		
		jse.executeScript("arguments[0].scrollIntoView();", driver.findElement(textbox_airportFrom));
		Thread.sleep(1000);
		jse.executeScript("arguments[0].scrollIntoView();", driver.findElement(label_postATravelCompanionRequest));
		Thread.sleep(1000);
		
		//------------- PageScroll to the End -------------
		jse.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		Thread.sleep(1000);
		
		//------------- PageScroll to the Top -------------
		jse.executeScript("window.scrollTo(0, 0);");
		Thread.sleep(1000);
		
		//------------- PageScroll to the End -------------
		jse.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		Thread.sleep(1000);
		
		Thread.sleep(1000);
		jse.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
		Thread.sleep(1000);
		
		System.out.println("------------------------- Total Page Text --------------------- \n\n" + 
				jse.executeScript("return document.documentElement.innerText"));
		
		
		driver.get("https://www.w3schools.com/howto/howto_css_image_gallery_scroll.asp");
		WebElement scrollArea = driver.findElement(div_rightScroll);
		// Scroll to div's most right:
		jse.executeScript("arguments[0].scrollLeft = arguments[0].offsetWidth", scrollArea);
		Thread.sleep(3000);
		
		// Or scroll the div by pixel number:
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollLeft += 250", scrollArea);
		Thread.sleep(1000);
		
		
		
	}
	

		
	@AfterEach
	public void teardown() {
		BrowserFactory.quitDriver();
	}
		
}