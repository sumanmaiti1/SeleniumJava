//-------------- https://www.hdfcbank.com/
//-------------- Handle BootStrap Dropdown

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

public class DropDown5 {
	
	private String string = "";
	private WebDriver driver = BrowserFactory.getDriver("chrome");
	private By button_aceptcookies = By.id("onetrust-accept-btn-handler");
	private By button_addHDFCAsHomeScreen = By.id("nv_js-pwa-close-button-46uyv5uz");
	
	//--------- Reusable Function to select Dropdown values -------------- 
	
	/**
	 * This Function can select values from BootStrap Dropdown / Listbox.  
	 * @param elements - This holds the Locator of Dropdown / Listbox.
	 * @createdBy - Suman Maiti
	 */
	public void selectvaluesFromBootstrapDropdown(By[] elements) {		
		try {
			for(By element : elements) {
				driver.findElement(element).click();
			}			
		}catch (NoSuchElementException e){
			System.out.println("\nNo Such element Exists : ".concat(e.toString()));
		}		
	}
	
	
	@Test
	public void Test() throws InterruptedException {
		
		driver.get("https://www.hdfcbank.com/");
		assertTrue(driver.getTitle().contains("HDFC Bank – Personal Banking & Netbanking Services"));
		
		
		if(driver.findElement(button_aceptcookies).isDisplayed()) {
			driver.findElement(button_aceptcookies).click();
		}
		
		Thread.sleep(3000);
		if(driver.findElement(button_addHDFCAsHomeScreen).isDisplayed()) {
		driver.findElement(button_addHDFCAsHomeScreen).click();
		}
		
		String productType = "All Cards";
		String product = "Debit Cards";
		
		//--------------- Select Product Type ----------------
		driver.findElement(By.xpath("//a[text()='Select Product Type']")).click();
		selectvaluesFromBootstrapDropdown(new By[] {By.xpath("//li[text()='".concat(productType).concat("']"))});
		//--------------- Select Product ----------------
		driver.findElement(By.xpath("//a[text()='Select Product']")).click();
		selectvaluesFromBootstrapDropdown(new By[] {By.xpath("//li[text()='".concat(product).concat("']"))});
		
		
		assertTrue(driver.findElement(By.xpath("//span[text()='".concat(productType).concat("']"))).getText().contains(productType));		
		assertTrue(driver.findElement(By.xpath("//div[@class='drp2']//span[text()='".concat(product).concat("']"))).getText().contains(product));
		
	}
	
	@AfterAll
	public static void tearDown() {
		BrowserFactory.quitDriver();
	}
}
