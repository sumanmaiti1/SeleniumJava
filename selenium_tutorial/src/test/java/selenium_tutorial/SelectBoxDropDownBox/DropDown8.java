//-------------- https://www.yatra.com/ -----------------------
//-------------- Handling Auto-suggestive Dropdowns

package selenium_tutorial.SelectBoxDropDownBox;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium_tutorial.utilities.browserFactory.BrowserFactory;

public class DropDown8 {
	
	private String string = "";
	private WebDriver driver = BrowserFactory.getDriver("chrome");
	private By input_airportName = By.id("input-with-icon-adornment");
	private By searchButton = By.xpath("//button[text()='Search']");
	

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
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.yatra.com/");
		assertTrue(driver.getTitle().contains("Yatra.com"));
		
		String from = "Mumbai, (BOM)";
		String to = "Chennai, (MAA)";
		
		//------------ Fill from Airport ---------------
		driver.findElement(By.xpath("//p[text()='Departure From']")).click();
		Thread.sleep(500);
		driver.findElement(input_airportName).sendKeys(from);
		Thread.sleep(500);
		selectvaluesFromBootstrapDropdown(new By[] {By.xpath("//div[text()='" + from +"']")});

		//------------ Fill To Airport ---------------
		driver.findElement(By.xpath("//p[text()='Going To']")).click();
		Thread.sleep(500);
		driver.findElement(input_airportName).sendKeys(to);
		Thread.sleep(500);
		selectvaluesFromBootstrapDropdown(new By[] {By.xpath("//div[text()='" + to +"']")});
		
		
		//-------------- Click on Search Button -------------
		driver.findElement(searchButton).click();

		//------------- Verify if resuluts are populated for your search and if populated, pring number of results -----------
		By searchResults = By.xpath("//div[contains(@id,'".concat(from.substring(from.indexOf('(')+1, from.indexOf(')')))
							.concat(to.substring(to.indexOf('(')+1, to.indexOf(')')).concat("')]")));
		
		//------------------ Wait for Maximum of 15 seconds for the Results to be populated
		new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOfElementLocated(searchResults));
		
		//---------------- get all the Records in a List ----------
		List<WebElement> noOfResults = driver.findElements(searchResults);		
		if(noOfResults.size()>0) {
			System.out.println("Total " + noOfResults.size() + " Search Results are populated for Direct Flight.");
		}else {
			System.out.println("No Search Result is populated.");
		}
	}
	
	@AfterAll
	public static void tearDown() {
		BrowserFactory.quitDriver();
	}
}
