package selenium_tutorial.tables;

import static org.junit.Assert.assertTrue;

import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import selenium_tutorial.utilities.browserFactory.BrowserFactory;

public class Table4 {
	
	WebDriver driver = BrowserFactory.getDriver("Chrome");
	private By table_table1 = By.xpath("//table[@id='example']");
	private By pagenation_next = By.xpath("//button[@data-dt-idx='next']");
	private By pagenation_previous = By.xpath("//button[@data-dt-idx='previous']");
	
	@Test
	public void Test() throws InterruptedException {
		
		driver.get("https://datatables.net/examples/basic_init/alt_pagination.html");
		assertTrue(driver.getTitle().equalsIgnoreCase("DataTables example - Alternative pagination"));
		
		//String position = "Junior Technical Author";	//-------------- PRESENT IN First PAGE
		//String position = "Chief Operating Officer (COO)"; //-------------- PRESENT IN Second PAGE
		//String position = "Developer";	 //-------------- PRESENT IN fourth PAGE
		String position = "Teacher";    //-------------- NOT PRESENT
		String location = "San Francisco";
		
		boolean flagMatch = false;
		
		//------------- Find the Name, age,Salary, page Number of COO in San Francisco --------------
		System.out.println("------------- Find the Name, age,Salary, page Number of COO in San Francisco --------------");

		int pageCount = driver.findElements(By.xpath("//button[@class='dt-paging-button']")).size()+1;
		Object[] elements= null;
		
		for(int n = 1;n<=pageCount ;n++) {			
			By rowElements = By.xpath("//table[@id='example']/tbody/tr//td[text()='" + position +"']"
					+ "/following-sibling::td[text()='" + location +"']/parent::tr/td");  //-------------------Xpath Axes
			
			if(driver.findElements(rowElements).size()>0) {
				flagMatch=true;
				List<WebElement> listElements = driver.findElements(rowElements);
				elements= listElements.toArray();
				
				System.out.println("Page : " + n);
				System.out.println("Name : " +((WebElement)elements[0]).getText().strip());
				System.out.println("Age : " +((WebElement)elements[3]).getText().strip());
				System.out.println("Salary : " +((WebElement)elements[5]).getText().strip());
				
				break;
			}else {
				driver.findElement(pagenation_next).click();
				Thread.sleep(1000);
			}
		}
		
		if(!flagMatch) {
			System.out.println("No Record Found for " + position + " in " + location );
		}
	}
	
	@AfterEach
	public void teardown() {
		BrowserFactory.quitDriver();
	}
	
}
