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

public class Table2 {
	
	WebDriver driver = BrowserFactory.getDriver("Chrome");
	private By table_table1 = By.xpath("//table[@id='webTable1']");
	private By thead = By.xpath("//table[@id='webTable1']/thead");
	private By tbody = By.xpath("//table[@id='webTable1']/tbody");
	private By tfoot = By.xpath("//table[@id='webTable1']/tfoot");
	
	
	@Test
	public void Test() {
		String htmlFilePath = Paths.get("./src/test/java/selenium_tutorial/tables/DemoWebTable.html").toUri().toString();		
		driver.get(htmlFilePath);
		assertTrue(driver.getTitle().equalsIgnoreCase("Demo Website for Webtables"));
		
		String str = "";
		
		//------------- Print All The Column Names --------------
		System.out.println("------------- Print All The Column Names --------------");
		List<WebElement> elements = driver.findElements(By.xpath("//table[@id='webTable1']/thead/tr/th"));
		for(WebElement e : elements ) {
			str = str + " - " + e.getText().strip();
		}
		System.out.println(str.substring(2));
		
		//----------------- Print Number of Rows ------------------
		System.out.println("Number of Rows : " + driver.findElements(By.xpath("//table[@id='webTable1']/tbody/tr")).size());
		
		//----------------- Print Number of Column ------------------
		System.out.println("Number of Columns : " + driver.findElements(By.xpath("//table[@id='webTable1']/thead/tr/th")).size());
		
		//----------------- Print Table Data Row Wise ------------------
		System.out.println("------------- Print Table Data Row Wise --------------");
		int rows = driver.findElements(By.xpath("//table[@id='webTable1']/tbody/tr")).size();
		for( int i=1; i<=rows; i++) {
			str = "";
			for(WebElement e : driver.findElements(By.xpath("//table[@id='webTable1']/tbody/tr[" + i + "]"))) {
				str = str + " - " + e.getText().strip();
			}
			System.out.println("Row " + i + " : " + str.substring(2));
		}
		
		//----------------- Print Table Data Column Wise ------------------
		System.out.println("------------- Print Table Data Column Wise --------------");
		int columns = driver.findElements(By.xpath("//table[@id='webTable1']/thead/tr/th")).size();
		for( int i=1; i<=columns; i++) {
			str = "";
			for(WebElement e : driver.findElements(By.xpath("//table[@id='webTable1']/tbody/tr/td[" + i + "]"))) {
				str = str + " - " + e.getText().strip();
			}
			System.out.println("Column " + i + " : " + str.substring(2));
		}
	}
	
	@AfterEach
	public void teardown() {
		BrowserFactory.quitDriver();
	}
	
}
