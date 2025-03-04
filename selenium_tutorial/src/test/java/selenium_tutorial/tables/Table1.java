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

public class Table1 {
	
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
		
		//------------- Print first Row --------------
		System.out.println("------------- Print first Row --------------");
		List<WebElement> elements = driver.findElements(By.xpath("//table[@id='webTable1']/tbody/tr[1]/td"));
		for(WebElement e : elements ) {
			str = str + " - " + e.getText().strip();
		}
		System.out.println(str.substring(2));
		
		
		//------------- Print nth Row --------------
		System.out.println("------------- Print nth Row --------------");
		int n =3; str = "";
		elements = driver.findElements(By.xpath("//table[@id='webTable1']/tbody/tr[" + n + "]/td"));
		for(WebElement e : elements ) {
			str = str + " - " + e.getText().strip();
		}
		System.out.println(str.substring(2));
		
		
		//------------- Print Last Row --------------
		System.out.println("------------- Print Last Row --------------");
		str = "";
		elements = driver.findElements(By.xpath("(//table[@id='webTable1']/tbody/tr)[last()]/td"));
		for(WebElement e : elements ) {
			str = str + " - " + e.getText().strip();
		}
		System.out.println(str.substring(2));
		
		//------------- Print All Rows --------------
		System.out.println("------------- Print All Rows --------------");		
		elements = driver.findElements(By.xpath("//table[@id='webTable1']/tbody/tr"));
		int rows = elements.size();
		
		for(int i=1;i<=rows;i++) {
			str = "";
			for(WebElement e : driver.findElements(By.xpath("//table[@id='webTable1']/tbody/tr[" + i + "]/td"))) {
				str = str + " - " + e.getText().strip();
			}
			System.out.println(str.substring(2));
		}
				
		//------------- Print First Column --------------
		System.out.println("------------- Print First Column --------------");
		str = "";
		elements = driver.findElements(By.xpath("//table[@id='webTable1']/tbody/tr//td[1]"));
		for(WebElement e : elements ) {
			str = str + " - " + e.getText().strip();
		}
		System.out.println(str.substring(2));
		
		//------------- Print Nth Column --------------
		System.out.println("------------- Print Nth Column --------------");
		n=2; str = "";
		elements = driver.findElements(By.xpath("//table[@id='webTable1']/tbody/tr//td[" + n + "]"));
		for(WebElement e : elements ) {
			str = str + " - " + e.getText().strip();
		}
		System.out.println(str.substring(2));
		
		
		//------------- Print Nth Column --------------
		System.out.println("------------- Print Last Column --------------");
		n=2; str = "";
		elements = driver.findElements(By.xpath("//table[@id='webTable1']/tbody/tr//td[last()]"));
		for(WebElement e : elements ) {
			str = str + " - " + e.getText().strip();
		}
		System.out.println(str.substring(2));
		
		
		//------------- Print xth Row Yth Column data ---------------
		System.out.println("------------- Print Xth row Yth Column Data --------------");
		int x = 4 ; int y = 6;
		System.out.println("Data in Xth row Yth column : " + driver.findElement(By.xpath("//table[@id='webTable1']/tbody/tr[" + x + "]//td[" + y +"]")).getText());
		
		//---------------- Print Footer Information ------------
		System.out.println("------------- Table Footer Information --------------");
		String[] footerInfo = driver.findElement(tfoot).getText().split("  ");
		for(String s : footerInfo) {
			System.out.println(s.strip());
		}
		
	}
	
	@AfterEach
	public void teardown() {
		BrowserFactory.quitDriver();
	}
	
}
