package selenium_tutorial.locators;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import selenium_tutorial.utilities.browserFactory.BrowserFactory;

//---------- Here we will discuss n Type of Basic Locators of Selenium -------------
//---------- https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php ---------------
/**
 * There are 7 Locators strategy. Bwlow are the list.
 * By.id
 * By.name
 * By.tag
 */


//@TestInstance(Lifecycle.PER_CLASS)
//@Execution(value = ExecutionMode.CONCURRENT)
public class TestBasicLocators2 {
	
	private WebDriver driver;
	private String url = "https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php";
	
	//------------- ID ----------------
	private By textboxName = By.id("name");
	//------------- NAME ----------------
	private By textboxEmail = By.name("email");
	
	private By gender = By.name("gender");
	
	
	@BeforeEach
	void setup() {
		driver = BrowserFactory.getDriver("Chrome");
		driver.get(url);
	}
	
	@Test
	void TestwithID() {
		System.out.println("TestwithID 2");
		driver.findElement(textboxName).sendKeys("Jay Shree krishna");
		assertAll(
				()-> assertEquals("Selenium Practice - Student Registration Form", driver.getTitle()),
				()-> assertEquals("Jay Shree krishna", driver.findElement(textboxName).getDomProperty("value"))
				);
	}
	
	
	@Test
	void TestwithNAME() {
		System.out.println("TestwithNAME 2");
		assertEquals("Selenium Practice - Student Registration Form", driver.getTitle()); 
		driver.findElement(textboxEmail).sendKeys("JayShreekrishna@Golok.com");
		assertAll(
				()-> assertEquals("Selenium Practice - Student Registration Form", driver.getTitle()),
				()-> assertEquals("JayShreekrishna@Golok.com", driver.findElement(textboxEmail).getDomProperty("value"))
				);
	}
	
	@AfterEach
	void tearDown() {
		BrowserFactory.quitDriver();
	}
	
	
}
