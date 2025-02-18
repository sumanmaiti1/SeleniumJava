//-------------- https://letcode.in/dropdowns

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

public class DropDown4 {
	
	private String string = "";
	private WebDriver driver = BrowserFactory.getDriver("chrome");
	private By label_dropdown = By.xpath("//h1[text()='Dropdown']");
	private By dropdown_fruits = By.id("fruits");
	private By dropdown_superheros = By.id("superheros");
	private By dropdown_lang = By.id("lang");
	private By dropdown_countries = By.id("country");
	
	//--------- Reusable Function to select Dropdown values -------------- 
	
	/**
	 * This Function can select values from Dropdown / Listbox.  
	 * @param element - This holds the Locator of Dropdown / Listbox.
	 * @param selectBy - This is a String value which indicates the Type using which options will be selected (e.g. by Value / Index / VisibleText / ContainsVisibleTest)
	 * @param toBeSelectedValue - This is a String which contains the Value/s/Index [Delimited by >>>] to be selected from Dropdown / Listbox.
	 * @createdBy - Suman Maiti
	 */
	public void selectvaluesFromDropdown(By element, String selectBy, String toBeSelectedValue) {
		
		String[] toBeSelectedValues = toBeSelectedValue.split(">>>");
		
		if(driver.findElement(element).isDisplayed() && driver.findElement(element).isEnabled()) {
			try {
				Select select = new Select(driver.findElement(element));
				
				//--------------- Deselect all before Seletio if it's multiSelection Dropdown ------------
				if(select.isMultiple()) {
					select.deselectAll();
				}				
				
				switch (selectBy.strip().toUpperCase()) {
				case "VALUE":
					for(String str: toBeSelectedValues) {
						select.selectByValue(str);
					}
					break;
				case "INDEX":
					for(String str: toBeSelectedValues) {
						select.selectByIndex(Integer.parseInt(str));
					}
					break;
				case "VISIBLE_TEXT":
					for(String str: toBeSelectedValues) {
						select.selectByVisibleText(str);
					}
					break;
				case "CONTAINS_VISIBLE_TEXT":
					for(String str: toBeSelectedValues) {
						select.selectByContainsVisibleText(str);
					}
					break;
				}
				
			}catch (NoSuchElementException e){
				System.out.println("\nNo Such element Exists : ".concat(e.toString()));
			} catch(UnexpectedTagNameException  e) {
				System.out.println("\nThe Element provided is not a Dropdowl/listbox : ".concat(e.toString()));
			} catch (NumberFormatException e) {
				System.out.println("\nWrong value Provided for Index Value : ".concat(e.toString()));
			}catch(UnsupportedOperationException e) {
				System.out.println("\nWrong value Provided for Index Value : ".concat(e.toString()));
			}
		}else {
			System.out.println("\nDropdownL/istBox is either Not present or Not enabled.");
		}
		
	}
	
	
	@Test
	public void Test() throws InterruptedException {
		
		driver.get("https://letcode.in/dropdowns");
		assertTrue(driver.findElement(label_dropdown).isDisplayed());		
		selectvaluesFromDropdown(dropdown_fruits, "VISIBLE_TEXT" , "Apple");
		selectvaluesFromDropdown(dropdown_superheros, "CONTAINS_VISIBLE_TEXT" , "Aqua>>>Iron Man>>>The>>>Super");
		selectvaluesFromDropdown(dropdown_lang, "VALUE" , "py");
		selectvaluesFromDropdown(dropdown_countries, "INDEX" , "6");
		
		//--------------- Below will raise Exceptions ---------------
		selectvaluesFromDropdown(dropdown_countries, "INDEX" , "-100");
		selectvaluesFromDropdown(dropdown_countries, "INDEX" , "1234");
		selectvaluesFromDropdown(dropdown_lang, "VALUE" , "Jay Shree Ram");
		selectvaluesFromDropdown(dropdown_superheros, "CONTAINS_VISIBLE_TEXT" , "Aqua>>>Iron Man>>>Hanuman");
		selectvaluesFromDropdown(dropdown_fruits, "VISIBLE_TEXT" , "Rambha");
		//-----------------------------------------------------------
		
		assertTrue(new Select(driver.findElement(dropdown_fruits)).getFirstSelectedOption().getText().equalsIgnoreCase("APPLE"));
		assertTrue(new Select(driver.findElement(dropdown_lang)).getFirstSelectedOption().getText().equalsIgnoreCase("PYTHON"));
		assertTrue(new Select(driver.findElement(dropdown_countries)).getFirstSelectedOption().getText().equalsIgnoreCase("india"));
		
		string = "";
		for( WebElement element : new Select(driver.findElement(dropdown_superheros)).getAllSelectedOptions()){
			string += element.getText().strip().concat("\n");
		}
		System.out.println("\nAll Selected Selected Heroes are : ".concat(string));
		
	}
	
	@AfterAll
	public static void tearDown() {
		BrowserFactory.quitDriver();
	}
}
