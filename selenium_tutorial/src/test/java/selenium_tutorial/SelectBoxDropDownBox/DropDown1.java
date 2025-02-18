package selenium_tutorial.SelectBoxDropDownBox;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import selenium_tutorial.utilities.browserFactory.BrowserFactory;

public class DropDown1 {
	
	private String string = "";
	private WebDriver driver = BrowserFactory.getDriver("as");
	private By dropdown_singleSelection = By.id("drop1");
	
	@Test
	public void Test() throws InterruptedException {
		
		driver.get("https://omayo.blogspot.com/");
		assertTrue(driver.findElement(dropdown_singleSelection).isDisplayed());
		
		//---------------- Creation Select class object for the dropdown -----------
		Select select = new Select(driver.findElement(dropdown_singleSelection));
				
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
		select.selectByContainsVisibleText("Older");
		Thread.sleep(1000);
		
		//------------- select by Value ------ 
		select.selectByValue("jkl");
		Thread.sleep(1000);
		
		//------------ getFirstSelectedOption() -----------
		assertTrue(select.getFirstSelectedOption().getText().contains("doc 3"));
		
		//--------------- isMultiple() ---------
		assertTrue(select.isMultiple()==false);
		
		//------------- deselectAll() will raise UnsupportedOperationException for NON  multi selection Select Box------------
		try {
			select.deselectAll();
		} catch (UnsupportedOperationException e) {
			// TODO: handle exception
			System.out.println("Expected Exception Caught : [java.lang.UnsupportedOperationException: You may only deselect all options of a multi-select]");
		}
		
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
			
		
	}
	
	@AfterAll
	public static void tearDown() {
		BrowserFactory.quitDriver();
	}
}
