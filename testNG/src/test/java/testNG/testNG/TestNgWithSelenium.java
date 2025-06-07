//---------------- This demonstrates usage of TestNG for selenium Script ------------

package testNG.testNG;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TestNgWithSelenium {
	
	//WebDriver driver= null;
	@Test
	private void googleSearch() {
		WebDriver driver = new ChromeDriver();
		//---------- getting google.com -----------
		driver.get("https://google.co.in");
		//---------- Checking if Google.com is populated by title -------------
		assertTrue(driver.getTitle().toLowerCase().contains("google"));
		
//		//----------- Searching with Jay Shree Krishna -------------
//		driver.findElement(By.name("q")).sendKeys("Jay Shree Krishna");
//		driver.findElement(By.name("btnK")).click();
//		//------------- Checking if Search Result is populated --------------
//		assertTrue(new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions
//				.presenceOfElementLocated(By.xpath("//span[text()='Jai Shri Krishna']"))).isDisplayed());
		driver.quit();
	}
	
	@Test
	private void chessSite() {
		WebDriver driver = new ChromeDriver();
		//---------- getting chess.com -----------
		driver.get("https://chess.com");
		//---------- Checking if chess.com is populated by title -------------
		assertTrue(driver.getTitle().equalsIgnoreCase("Chess.com - Play Chess Online - Free Games"));

		driver.quit();
	}
	
}

