package selenium_tutorial.locators;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import selenium_tutorial.utilities.browserFactory.BrowserFactory;

//---------- Here we will discuss n Type of Basic Locators of Selenium -------------
//---------- https://seleniumbase.io/demo_page ---------------
/**
 * There are 8 Locators strategy. Bwlow are the list.
 * By.id
 * By.name
 * By.tagName
 * By.className
 * By.linkText
 * By.partialLinkText
 * By.css
 * By.xpath
 */


//@TestInstance(Lifecycle.PER_CLASS)
//@Execution(ExecutionMode.CONCURRENT)
public class TestBasicLocators {
	
	private WebDriver driver;
	private String url = "https://seleniumbase.io/demo_page";
	
	//------------- ID ----------------
	private By textbox1 = By.id("myTextInput");
	//------------- NAME ----------------
	private By textArea = By.name("textareaName");
	private By preFilledTextBox = By.name("preText2");
	
	//------------- TAG NAME ----------------
	private By totalHyperLinks = By.tagName("a");
	
	//------------- TAG NAME ----------------
	private By slider = By.className("slider");
	
	//------------- LINK TEXT ----------------
	private By linkSeleniumBase1 = By.linkText("seleniumbase.com");
	
	//-------------PARTIAL LINK TEXT ----------------
	private By linksSelenium = By.partialLinkText("selenium");
	
	//------------ CSS SELECTOR ------------
	private By clickMe = By.cssSelector("#myButton");
	
	//------------- XPATH --------------
	private By setTo100Percent = By.xpath("//option[@value='100%']");
	
	
	@BeforeEach
	void setup() {
		driver = BrowserFactory.getDriver("Chrome");
		driver.get(url);
	}
	
	@Test
	void TestwithID() {
		System.out.println("TestwithID");
		driver.findElement(textbox1).sendKeys("Jay Shree krishna");
		assertAll(
				()-> assertEquals("Web Testing Page", driver.getTitle()),
				()-> assertEquals("Jay Shree krishna", driver.findElement(textbox1).getDomProperty("value").strip())
				);
	}
	
	@Test
	void TestwithNAME() {
		System.out.println("TestwithNAME");
		assertEquals("Web Testing Page", driver.getTitle()); 
		driver.findElement(textArea).sendKeys("JayShreekrishna@Golok.com");
		assertAll(
				()-> assertEquals("Web Testing Page", driver.getTitle()),
				()-> assertEquals("JayShreekrishna@Golok.com", driver.findElement(textArea).getDomProperty("value")),
				()-> assertEquals("Text...", driver.findElement(preFilledTextBox).getAttribute("value"))
				);
	}
	
	@Test
	void TestWithTagName() {
		//---------------- Testing with all the HyperLinks in tha page ---------------
		System.out.println("TestwithTAGNAME");
		List<WebElement> numberOfHyperLinks= driver.findElements(totalHyperLinks);
		for(WebElement e: numberOfHyperLinks) {
			System.out.println(e.getAttribute("href"));
		}			
		assertTrue(numberOfHyperLinks.size()>5);
	}
	
	@Test
	void TestWithClassName() {
		//---------------- Testing with all the HyperLinks in tha page ---------------
		System.out.println("TestwithCLASSNAME");
		assertEquals("sliderName", driver.findElement(slider).getAttribute("name"));		
	}

	@Test
	void TestWithLinkText() {
		System.out.println("TestwithLinkText");
		assertTrue(driver.findElement(linkSeleniumBase1).getText().strip().equalsIgnoreCase("seleniumbase.com"),"Text of Seleniumbase.com link isn't equal to seleniumbase.com");				
	}
	
	@Test
	void TestWithPartialLinkText() {
		System.out.println("TestwithPartialLinkText");
		List<WebElement> linksWithSelenium = driver.findElements(linksSelenium);
		for(WebElement e: linksWithSelenium) {
			System.out.println(e.getText());
		}
		assertTrue(1<linksWithSelenium.size());		
	}
	
	@Test
	void TestWithCssSelector() {
		System.out.println("TestwithCSSSelector");		
		assertTrue(driver.findElement(clickMe).getText().strip().equalsIgnoreCase("Click Me (Green)"));		
	}
	
	@Test
	void TestWithXpath() {
		System.out.println("TestwithXPath");
		driver.findElement(setTo100Percent).click();
		assertTrue(new Select(driver.findElement(By.xpath("//*[@id='mySelect']"))).getFirstSelectedOption().getText().equalsIgnoreCase("Set to 100%"));
		
	}
	
	@AfterEach
	void tearDown() {
		BrowserFactory.quitDriver();
	}
	
	
}
