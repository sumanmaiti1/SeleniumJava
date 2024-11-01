package selenium_tutorial.locators;

//------- Now we will discuss about the advance CSS selector strategies -------
// ------- demo URL : https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php -------
// ------  https://www.automatetheplanet.com/selenium-webdriver-locators-cheat-sheet/  ------
// ------  https://www.w3schools.com/cssref/css_selectors.php ------
// ------  https://www.w3.org/TR/selectors-3///selectors ------

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import selenium_tutorial.utilities.browserFactory.BrowserFactory;

public class TestCssAdvanced {
	
	private WebDriver driver;
	private String url = "https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php";
	
	private By tutorilspointImageAbsoluteXpath = By.cssSelector("body > div > header > div:nth-child(1) > a > svg");
	private By tutorilspointImageRelativeXpath = By.cssSelector("svg.logo-desktop");
	
	private By txtbox_name1 = By.cssSelector("input[id='name']");  // --- Normal Css schema  tagName[attributeName=attributeValue]
	private By txtbox_name2 = By.cssSelector("input#name");  // --- tagname#id
	private By txtbox_name3 = By.cssSelector("#name");  // --- #id  Tagname is optional
	
    private By link_selenium_tutorial1 = By.cssSelector("a.external-link");  // --- Tagname.Classname
	private By link_selenium_tutorial2 = By.cssSelector(".external-link") ; // --- .Classname  Tagname is optional

	private By link_selenium_tutorial3 = By.cssSelector("a[class='external-link'][title='back to Selenium Tutorial']");  // --- two properties
	private By link_selenium_tutorial4 = By.cssSelector("a[class='external-link'][title='back to Selenium Tutorial']"); // Tag name is optional

	private By txtbox_mobile1 = By.cssSelector("input#mobile.form-control");  // ------ combining tag, Id, Class
	private By txtbox_mobile2 = By.cssSelector("input#mobile.form-control[name='mobile']");  // ------ combining Tag,Id,Class,attribute
	private By txtbox_mobile3 = By.cssSelector("#mobile.form-control[name='mobile']");  // ------ combining Id,Class,attribute.    Tag is optional

	private By option_uttar_pradesh1 = By.cssSelector("option[value^='Uttar']");     // ----- value attribute starts with Uttar
	private By option_uttar_pradesh2 = By.cssSelector("option[value$='Pradesh']");   // ----- value attribute ends with Pradesh
	private By option_uttar_pradesh3 = By.cssSelector("option[value*='r Pr']");      // ----- value attribute contains 'r Pr'

	private By option_element1 = By.cssSelector("select#state>option");       // --------- all childs of select tag. Usage of >
	private By option_element2 = By.cssSelector("select#state option");      // all child & subchilds of Select tab. Usage of Space
	private By elements_collapse_sign1 = By.cssSelector("h2#headingOne+div");    //  div element immediately preceeded by h2. Usage of + (following sibling)
	private By elements_collapse_sign2 = By.cssSelector("h2#headingOne~div");    // div element preceeded by h2. Usage of ~ (sibling)

	private By option_hariyana1 = By.cssSelector("select#state option:nth-child(4)");     // ----- nth-child
	private By option_hariyana2 = By.cssSelector("select#state option:nth-last-child(2)");     // ----- nth-last-child
	private By option_hariyana3 = By.cssSelector("select#state option:nth-of-type(4)");     // ----- nth-of-type
	private By option_hariyana4 = By.cssSelector("select#state option:nth-last-of-type(2)");     // ----- nth-last-of-type
	private By option_choose_state1 = By.cssSelector("select#state option:first-child");   // ------- first-child
	private By option_rajasthan1 = By.cssSelector("select#state option:last-child");     // ------- last-child
	private By option_rajasthan2 = By.cssSelector("select#state option:last-of-type");       // ------- last-of-type
	private By selectedInputTags1 = By.cssSelector("select#state option:first-of-type");    //  ------- first-of-type
	private By selectedInputTags2 = By.cssSelector("input:not([id='name'] , [type='radio'] , [type='checkbox'], [type='date'] , [type='file'])");    
																							//  ------- usage of NOT. matches 4 input which are not 
																							//name, radiobutton, checkbox and for Files
		
	private By textbox_nameAndEmail1 = By.cssSelector("input[id='name'] , input[id= 'email']"); //-------- usage of comma. This will fetch 2 elements. Works as OR
	private By textbox_nameAndEmail2 = By.cssSelector("[id='name'] , [id= 'email']"); //-------- usage of comma. This will fetch 2 elements. Works as OR
	
	private By practicFormLoginRegister = By.cssSelector("#collapseTwo [class='list-group rounded']>*"); //-------- usage of Asteric. This will fetch 3 elements. Works as OR
	 
	//----------------- More CSS Selectors Examples are given below
	private By allLinks = By.cssSelector("a:link");
	private By allLinksVisited = By.cssSelector("a:visited");
	private By allCheckBoxChecked = By.cssSelector("input:checked");
	private By allInputEnabled = By.cssSelector("input:enabled");
	private By allInputDisabled = By.cssSelector("input:disabled");	
	
	@BeforeEach
	void setup() {
		driver = BrowserFactory.getDriver("Chrome");
		driver.get(url);
	}
	
	@AfterEach
	void tearDowd() {
		BrowserFactory.quitDriver();
	}
	
	@Test
	void testAdvanceXpath() {
		
		assertAll(
				()-> assertEquals("Selenium Practice - Student Registration Form", driver.getTitle()),
				()-> assertTrue(driver.findElement(tutorilspointImageAbsoluteXpath).isDisplayed()),
				()-> assertTrue(driver.findElement(tutorilspointImageAbsoluteXpath).isDisplayed())
				);
		driver.findElement(txtbox_name1).clear();
		driver.findElement(txtbox_name1).sendKeys("Jay Shree Krishna");
		
		assertEquals("Jay Shree Krishna", driver.findElement(txtbox_name3).getDomProperty("value"));
		System.out.println(driver.findElement(txtbox_name3).getDomProperty("value"));
		System.out.println("Total Links in Page : " + driver.findElements(allLinks).size());
		
//		for(WebElement e: driver.findElements(allLinks)) {
//			System.out.println(e.getAttribute("href"));
//		}
	}
}
