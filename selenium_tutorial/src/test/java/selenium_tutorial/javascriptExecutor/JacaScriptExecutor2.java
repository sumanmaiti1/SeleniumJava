package selenium_tutorial.javascriptExecutor;

import static org.junit.Assert.assertTrue;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium_tutorial.utilities.browserFactory.BrowserFactory;

public class JacaScriptExecutor2 {
	
	public class JacaScriptExecutor1 {
		
		WebDriver driver = BrowserFactory.getDriver("Chrome");	
		
		@Test
		public void test() throws InterruptedException {
			JavascriptExecutor jse = ((JavascriptExecutor)driver);
			Alert alert = null;
			
			//-------------- Show an Alert in Webpage --------------
			jse.executeScript("alert('Jay Shree Krishna')");
			Thread.sleep(1000);
			assertTrue(new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.alertIsPresent()).getText().equalsIgnoreCase("Jay Shree Krishna"));
			driver.switchTo().alert().accept();
			
			//-------------- Show an Alert in Webpage --------------
			jse.executeScript("prompt('Jay Shree Ram')");
			Thread.sleep(1000);
			alert= new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.alertIsPresent());
			assertTrue(alert.getText().equalsIgnoreCase("Jay Shree Ram"));
			alert.sendKeys("SitaRam SitaRam");
			alert.accept();
			
			//-------------- Show an Alert in Webpage --------------
			jse.executeScript("confirm('Radhe Radhe')");
			Thread.sleep(1000);
			alert = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.alertIsPresent());
			assertTrue(alert.getText().equalsIgnoreCase("Radhe Radhe"));
			alert.dismiss();
			
		}
		
		@AfterEach
		public void teardown() {
			BrowserFactory.quitDriver();
		}
		
	}

	WebDriver driver = BrowserFactory.getDriver("Chrome");	
	
	@Test
	public void test() throws InterruptedException {
		JavascriptExecutor jse = ((JavascriptExecutor)driver);
		Alert alert = null;
		
		//-------------- Show an Alert in Webpage --------------
		jse.executeScript("alert('Jay Shree Krishna')");
		Thread.sleep(1000);
		assertTrue(new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.alertIsPresent()).getText().equalsIgnoreCase("Jay Shree Krishna"));
		driver.switchTo().alert().accept();
		
		//-------------- Show an Alert in Webpage --------------
		jse.executeScript("prompt('Jay Shree Ram')");
		Thread.sleep(1000);
		alert= new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.alertIsPresent());
		assertTrue(alert.getText().equalsIgnoreCase("Jay Shree Ram"));
		alert.sendKeys("SitaRam SitaRam");
		alert.accept();
		
		//-------------- Show an Alert in Webpage --------------
		jse.executeScript("confirm('Radhe Radhe')");
		Thread.sleep(1000);
		alert = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.alertIsPresent());
		assertTrue(alert.getText().equalsIgnoreCase("Radhe Radhe"));
		alert.dismiss();
		
	}
	
	@AfterEach
	public void teardown() {
		BrowserFactory.quitDriver();
	}
	
}
