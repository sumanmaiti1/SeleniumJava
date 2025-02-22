//-------------- https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/
//-------------- Handle ComboTree jQuery Dropdown

package selenium_tutorial.SelectBoxDropDownBox;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;

import selenium_tutorial.utilities.browserFactory.BrowserFactory;

public class DropDown6 {
	
	private String string = "";
	private WebDriver driver = BrowserFactory.getDriver("chrome");
	private By input_multiSelectionJQueryDropdown = By.xpath("//input[@id='justAnInputBox1']");

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
		
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		assertTrue(driver.getTitle().contains("ComboTree jQuery Plugin Demos"));
		
		String options = "choice 1 >>>choice 2 2>>>choice 2 3>>>choice 4>>>choice 6 1>>>choice 6 2";
		
		driver.findElement(input_multiSelectionJQueryDropdown).click();
		Thread.sleep(1000);
		
		for(String str : options.split(">>>")) {
			selectvaluesFromBootstrapDropdown(
					new By[] {By.xpath("//input[@id='justAnInputBox1']/parent::div/following-sibling::div//span[contains(text(),'".concat(str).concat("')]"))});
		}
		
		System.out.println(driver.findElement(input_multiSelectionJQueryDropdown).getDomProperty("value"));
		assertTrue(driver.findElement(input_multiSelectionJQueryDropdown).getDomProperty("value")
				.contains("choice 1  , choice 2 2, choice 2 3, choice 4, choice 6 1, choice 6 2, choice 6 2 1, choice 6 2 2, choice 6 2 3"));		

		
	}
	
	@AfterAll
	public static void tearDown() {
		BrowserFactory.quitDriver();
	}
}
