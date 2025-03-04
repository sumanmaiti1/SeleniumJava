package selenium_tutorial.tables;

import static org.junit.Assert.assertTrue;

import java.nio.file.Paths;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import selenium_tutorial.utilities.browserFactory.BrowserFactory;

public class Table3 {
	
	WebDriver driver = BrowserFactory.getDriver("Chrome");
	private By table_table1 = By.xpath("//table[@id='example']");
	private By pagenation_next = By.xpath("//button[@data-dt-idx='next']");
	private By pagenation_previous = By.xpath("//button[@data-dt-idx='previous']");
	
	@Test
	public void Test() throws InterruptedException {
		
		driver.get("https://datatables.net/examples/basic_init/alt_pagination.html");
		assertTrue(driver.getTitle().equalsIgnoreCase("DataTables example - Alternative pagination"));
		
		
		//String emptName = "Cara Stevens"; //-------------- PRESENT IN FIRST PAGE
		String emptName ="Zorita Serrano";	//-------------- PRESENT IN LAST PAGE 
		//String emptName ="Radhe Shyam Sharma"; //-------------- NOT PRESENT
		
		boolean flagMatch = false;
		int pageNo = 1;
		
		//------------- Search An Employee by name. if Present print page Number, Age, Position, Location --------------
		System.out.println("------------- Search An Employee by name. if Present print page Number, Age, Position, Location ------------");
		int columnCount = driver.findElements(By.xpath("//table[@id='example']/thead/tr/th")).size();
		int rowCount = driver.findElements(By.xpath("//table[@id='example']/tbody/tr")).size();
		int pageCount = driver.findElements(By.xpath("//button[@class='dt-paging-button']")).size()+1;
		
		for(int n = 1;n<=pageCount ;n++) {
			int rowfoundAt = 0;
			for(int i=1; i<=rowCount; i++) {
				if(driver.findElement(By.xpath("//table[@id='example']/tbody/tr[" + i + "]")).getText().strip().contains(emptName)) {
					flagMatch = true;
					System.out.println("Employee " + emptName + " is Present in Page: " + n + " And Row :" + i);
					rowfoundAt = i;
					break;
				}			
			}
			if(!flagMatch) {
				if(n!=pageCount) {
					driver.findElement(By.xpath("//button[@class='dt-paging-button'][" + n +"]")).click();				
					Thread.sleep(1000);
					rowCount = driver.findElements(By.xpath("//table[@id='example']/tbody/tr")).size();
				}
				
			}else {
				System.out.println("Age : " + driver.findElement(By.xpath("//table[@id='example']/tbody/tr[" + rowfoundAt + "]/td[4]")).getText().strip());
				System.out.println("Position : " + driver.findElement(By.xpath("//table[@id='example']/tbody/tr[" + rowfoundAt + "]/td[2]")).getText().strip());
				System.out.println("Location : " + driver.findElement(By.xpath("//table[@id='example']/tbody/tr[" + rowfoundAt + "]/td[3]")).getText().strip());
				break;
			}
		}
		
		if(!flagMatch) {
			System.out.println("Employee " + emptName + " is NOT Present in Table." );
		}
	}
	
	@AfterEach
	public void teardown() {
		BrowserFactory.quitDriver();
	}
	
}
