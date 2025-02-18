package selenium_tutorial.SelectBoxDropDownBox;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import selenium_tutorial.utilities.browserFactory.BrowserFactory;

public class DropDown3 {
	
	private String string = "";
	private WebDriver driver = BrowserFactory.getDriver("chrome");
	private By dropdown_multiSelection = By.id("multiselect1");
	private By option_volvo = By.xpath("//option[@value='volvox']");
	private By option_swift = By.xpath("//option[@value='swiftx']");
	private By option_Hyundai = By.xpath("//option[@value='Hyundaix']");
	private By option_audi = By.xpath("//option[@value='audix']");
	
	
	@Test
	public void Test() throws InterruptedException {
		
		driver.get("https://omayo.blogspot.com/");
		assertTrue(driver.findElement(dropdown_multiSelection).isDisplayed());
		Select select = new Select(driver.findElement(dropdown_multiSelection));
		
		//----------------- select Options by cicking Option WebElements ----------- 
		driver.findElement(option_Hyundai).click();
		driver.findElement(option_volvo).click();
		driver.findElement(option_swift).click();
		
		
		//------------- get all selected options ------------
		string = "";
		for( WebElement element : select.getAllSelectedOptions()){
			string += element.getText().strip().concat("\n");
		}
		System.out.println("\nAll Selected options in the Dropdown are : ".concat(string));
		
		System.out.println("First Selected Option : ".concat(select.getFirstSelectedOption().getText()));
		
		//---------------- Clicking Hundai to Deselect it --------
		driver.findElement(option_Hyundai).click();
		
		
		//------------- get all selected options ------------
		string = "";
		for( WebElement element : select.getAllSelectedOptions()){
			string += element.getText().strip().concat("\n");
		}
		System.out.println("\nAll Selected options in the Dropdown are : ".concat(string));
		
		System.out.println("First Selected Option : ".concat(select.getFirstSelectedOption().getText()));
		
	}
	
	@AfterAll
	public static void tearDown() {
		BrowserFactory.quitDriver();
	}
}
