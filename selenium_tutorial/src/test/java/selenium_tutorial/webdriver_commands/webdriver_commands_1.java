
/**
 * This class will demonstrate some of the Webdriver commands mentioned in Topics.txt...
 * wesite Used : https://google.com/
 */
package selenium_tutorial.webdriver_commands;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;

import selenium_tutorial.utilities.browserFactory.BrowserFactory;

public class webdriver_commands_1 {

	private WebDriver driver = BrowserFactory.getDriver("chrome");
	
	@Test
	public void Test1() throws InterruptedException{
		//------------------get() ----------------
		driver.get("http://google.com/");  //---------------- get() ------- opens an url with Webdriver
		
		//--------------- manage().window()----------------
		driver.manage().window().maximize();
		driver.manage().window().minimize();
		driver.manage().window().fullscreen();		
		driver.manage().window().setPosition(new Point(400,400));
		driver.manage().window().setSize(new Dimension(200, 200));
		System.out.println(driver.manage().window().getPosition().toString());
		System.out.println(driver.manage().window().getSize().toString());
		
		Thread.sleep(2000);
		driver.manage().window().maximize();
		
		
		//--------------- getCurrentUrl, getPageSource, getTitle --------------------
		assertTrue(driver.getCurrentUrl().contains("https://www.google.com/")); //---------------- getCurrentUrl() ------- gets current url of opened page 
		assertTrue(driver.getPageSource().contains("https://ogs.google.com/")); //---------------- getPageSource() ------- gets page source opened page
		assertEquals(driver.getTitle(),"Google"); //---------------- getTitle() ------- gets Title of opened page
		
//		driver.get("http://facebook.com/");  //---------------- opens an url with Webdriver
//		driver.get("https://google.com/");  //---------------- opens an url with Webdriver
//		driver.get("https://omayo.blogspot.com/");  //---------------- opens an url with Webdriver
		
		//----------------- close() -----------
//		driver.close();	//----------------- closes the Driver Instance
		
		//----------------- quit() -----------
//		driver.quit();	//----------------- closes the Driver Instance
		
		BrowserFactory.quitDriver();
	}

}
