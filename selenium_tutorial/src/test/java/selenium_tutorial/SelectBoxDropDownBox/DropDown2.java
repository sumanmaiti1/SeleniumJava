package selenium_tutorial.SelectBoxDropDownBox;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import selenium_tutorial.utilities.browserFactory.BrowserFactory;

public class DropDown2 {
	
	private String string = "";
	private WebDriver driver = BrowserFactory.getDriver("as");
	private By dropdown_multiSelection = By.id("multiselect1");
	
	@Test
	public void Test() throws InterruptedException {
		
		driver.get("https://omayo.blogspot.com/");
		assertTrue(driver.findElement(dropdown_multiSelection).isDisplayed());
		
		//---------------- Creation Select class object for the dropdown -----------
		Select select = new Select(driver.findElement(dropdown_multiSelection));
				
		//--------- get all the Options of Dropdown ---------- 
		for( WebElement element : select.getOptions()){
			string += element.getText().strip().concat("\n");
		}
		System.out.println("All options present in the Dropdown are : ".concat(string));
		
		//------------- get all selected options ------------
		string = "";
		for( WebElement element : select.getAllSelectedOptions()){
			string += element.getText().strip().concat("\n");
		}
		System.out.println("All Selected options in the Dropdown are : ".concat(string));

		//------------- select by Index ------ 
		select.selectByIndex(2);
		Thread.sleep(1000);
		
		//------------- select by Contains Visible Text ------ 
		select.selectByContainsVisibleText("Aud");
		Thread.sleep(1000);
		
		//------------- select by Value ------ 
		select.selectByValue("swiftx");
		Thread.sleep(1000);
		
		//------------ getFirstSelectedOption() -----------
		assertTrue(select.getFirstSelectedOption().getText().contains("Swift"));
		
		//--------------- isMultiple() ---------
		assertTrue(select.isMultiple());
		
		//------------- Deselets all ------------
		select.deselectAll();
		Thread.sleep(1000);
		
		//------- Selecting Multiple Values ----------
		select.selectByIndex(3);
		select.selectByIndex(1);
		select.selectByIndex(2);
		
		System.out.println("First Selected Option : ".concat(select.getFirstSelectedOption().getText()));
		
		//------------- get all selected options ------------
		string = "";
		for( WebElement element : select.getAllSelectedOptions()){
			string += element.getText().strip().concat("\n");
		}
		System.out.println("\nAll Selected options in the Dropdown are : ".concat(string));
		
		//----------- deSelectByContainsVisibleText() ------------
		select.deSelectByContainsVisibleText("Hyun");
		
		//----------- deselectByIndex() ------------
		select.deselectByIndex(3);
		
		// ------------  deselectByValue() ------------
		select.deselectByValue("swiftx");		
		
	}
	
	@AfterAll
	public static void tearDown() {
		BrowserFactory.quitDriver();
	}
}
