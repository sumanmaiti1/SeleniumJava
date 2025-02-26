package selenium_tutorial.takingScreenshots;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import selenium_tutorial.utilities.browserFactory.BrowserFactory;

public class Screenshots1 {
	
	WebDriver driver = BrowserFactory.getDriver("chrome");
	private By table_table1 = By.id("table1");
	
	@Test
	public void Test() throws IOException {
		
		driver.get("https://omayo.blogspot.com/");
		assertTrue(driver.getTitle().contains("omayo"));
		
		File destinationFolder = new File("./src/test/java/selenium_tutorial/takingScreenshots/Screenshots");
		FileHandler.createDir(destinationFolder);
		
		//------------ take screenshot of Whole screen -----------------
		File file1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);		
		FileHandler.copy(file1, new File(destinationFolder.getPath().concat("/snap1.jpg")));
		
		//------------take screenshot of a particular element -------------		
		File file2 = ((TakesScreenshot)driver.findElement(table_table1)).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file2, new File(destinationFolder.getPath().concat("/snap2.jpg")));
		
		assertTrue(file1.exists());
		assertTrue(file2.exists());
		
		//-------------Delete the created files and Folder
		for(File item:destinationFolder.listFiles()) {
			if(item.isFile()) {
				item.delete();
			}
		}
		destinationFolder.delete();
	}
	
	@AfterEach
	public void teardown() {
		BrowserFactory.quitDriver();
	}
}
