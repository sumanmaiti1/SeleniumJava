
/**
 * This class will demonstrate some of the Webdriver commands mentioned in Topics.txt...
 * wesite Used : https://google.com/
 */
package selenium_tutorial.webdriver_commands;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import selenium_tutorial.utilities.browserFactory.BrowserFactory;

public class webdriver_commands_2 {

	private WebDriver driver = BrowserFactory.getDriver("chrome");
	private By textbox_search = By.name("q");
	private By button_googleSearch = By.xpath("(//input[@name='btnK'])[last()]");
	private By links_googleOfferedInLanguages = By.xpath("//a[contains(@href,'https://www.google.com/setprefs')]");
	
	@Test
	public void Test1() throws InterruptedException{
		//------------------get() ----------------
		driver.get("http://google.com/");  //---------------- get() ------- opens an url with Webdriver
		
		//--------------- manage().window()----------------
		driver.manage().window().maximize();
		
		//------------ findElements(),getText() -----------------
		List<WebElement> list_language = driver.findElements(links_googleOfferedInLanguages);
		for(WebElement e : list_language) {
			System.out.println(e.getText());
		}
		
		//------------- findElement() , sendKeys()-------------
		WebElement search = driver.findElement(textbox_search);
		search.sendKeys("Jay Shree Krishna");
		
		//------------------- click() ------------------
		driver.findElement(button_googleSearch).click();
		Thread.sleep(3000);
		
		assertEquals(driver.getTitle(), "Jay Shree Krishna - Google Search");
		BrowserFactory.quitDriver();
	}

}
