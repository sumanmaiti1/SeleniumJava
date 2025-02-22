//-------------- https://demo.automationtesting.in/AutoComplete.html
//-------------- Handling Auto-suggestive Dropdowns

package selenium_tutorial.SelectBoxDropDownBox;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import selenium_tutorial.utilities.browserFactory.BrowserFactory;

public class DropDown7 {
	
	private String string = "";
	private WebDriver driver = BrowserFactory.getDriver("chrome");
	private By textbox_autoSuggestion = By.id("searchbox");

	//--------- Reusable Function to select Dropdown values -------------- 
	
	/**
	 * This Function can select values from BootStrap Dropdown / Listbox.  
	 * @param elements - This holds the Locator of Dropdown / Listbox.
	 * @throws InterruptedException 
	 * @createdBy - Suman Maiti
	 */
	public void selectvaluesFromBootstrapDropdown(By[] elements) throws InterruptedException {		
		try {
			for(By element : elements) {
				driver.findElement(element).click();
				Thread.sleep(500);
			}			
		}catch (NoSuchElementException e){
			System.out.println("\nNo Such element Exists : ".concat(e.toString()));
		}		
	}
	
	
	@Test
	public void Test() throws InterruptedException {
		
		driver.get("https://demo.automationtesting.in/AutoComplete.html");
		assertTrue(driver.getTitle().contains("Autocomplete"));
		
		String options = "India>>>Australia";
		
		driver.findElement(textbox_autoSuggestion).click();
		Thread.sleep(1000);
		
		for(String str : options.split(">>>")) {
			new Actions(driver).sendKeys(str).perform();
			Thread.sleep(500);
			selectvaluesFromBootstrapDropdown(
					new By[] {By.xpath("//a[text()='".concat(str).concat("']"))});
		}

		assertTrue(driver.findElement(By.xpath("//input[@id='searchbox']/parent::div")).getText().equalsIgnoreCase(options.replace(">>>", "")));

	}
	
	@AfterAll
	public static void tearDown() {
		BrowserFactory.quitDriver();
	}
}
