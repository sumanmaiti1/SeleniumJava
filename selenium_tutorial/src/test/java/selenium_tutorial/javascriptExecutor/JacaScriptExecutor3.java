package selenium_tutorial.javascriptExecutor;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import selenium_tutorial.utilities.browserFactory.BrowserFactory;

public class JacaScriptExecutor3 {
	
	WebDriver driver = BrowserFactory.getDriver("Chrome");	
	private By calendar_calendar1 = By.id("form-field-travel_comp_date");
	private By button_search = By.xpath("//button[contains(@class,'elementor-button elementor-size-sm')]");
	
	@Test
	public void test() throws InterruptedException {
		
		driver.get("https://www.path2usa.com/travel-companion/");
		JavascriptExecutor jse = ((JavascriptExecutor)driver);

		//------------- Highlight Element like UFT/QTP (Flashing + Border) ----------------
		highlightElement(driver.findElement(calendar_calendar1),driver);
		
		//----------------- Select Calendar date by JavaScript Executor -----------------
		jse.executeScript("arguments[0].value=arguments[1]", driver.findElement(calendar_calendar1),new SimpleDateFormat("MM/dd/yyyy").format(new Date()));
		assertTrue( driver.findElement(calendar_calendar1).getDomProperty("value").equalsIgnoreCase(new SimpleDateFormat("MM/dd/yyyy").format(new Date())));
		
		//------------ Highlight Search Button ----------------
		highlightElement(driver.findElement(button_search),driver);

	}
	
	//------------- Highlight Element like UFT/QTP (Flashing + Border) ----------------
	public void highlightElement(WebElement element,WebDriver driver) throws InterruptedException{
		
		JavascriptExecutor js = ((JavascriptExecutor)driver) ;
		
		//---------------- Move To Element And Take colour, Background Colout ----------------		
		new Actions(driver,Duration.ofSeconds(10)).moveToElement(element).perform();
		String currentColour =(String) js.executeScript("return arguments[0].style.color",element);
		String currentBackgroundColour =(String) js.executeScript("return arguments[0].style.background",element);
	
		js.executeScript("arguments[0].style.border = 'thick solid #f7ef4a'",element);
		for(int i=0;i<=2;i++) {
			js.executeScript("arguments[0].style.currentBackgroundColour = 'orange'",element);
			Thread.sleep(200);
		}
		js.executeScript("arguments[0].style.currentBackgroundColour = '" + currentBackgroundColour + "'",element);
		js.executeScript("arguments[0].style.border = 'None'",element);
	}
		
	@AfterEach
	public void teardown() {
		BrowserFactory.quitDriver();
	}
		
}