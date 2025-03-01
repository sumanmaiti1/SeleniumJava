package selenium_tutorial.takingScreenshots;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;

import selenium_tutorial.utilities.browserFactory.BrowserFactory;

public class Screenshots2 {
	
	WebDriver driver = BrowserFactory.getDriver("chrome");
	private By table_table1 = By.id("table1");
	private By button_getAlert = By.id("prompt"); 
	
	
	@Test
	public void Test() throws IOException {
		
		driver.get("https://omayo.blogspot.com/");
		assertTrue(driver.getTitle().contains("omayo"));
		
		//------------ take screenshot of Whole screen -----------------
		File destinationFolder = new File("./src/test/java/selenium_tutorial/takingScreenshots/Screenshots");
		File file1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);		
				
		FileUtils.copyFile(file1, new File(destinationFolder.getPath().concat("/snap1.png")));
		
		
		//------------take screenshot of a particular element -------------		
		File file2 = ((TakesScreenshot)driver.findElement(table_table1)).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file2, new File(destinationFolder.getPath().concat("/snap2.jpeg")));
		
		//----------------- There's another method for Taking Screenshot but that's only applicable for Firefox driver --------------
		//----------------- getFullPageScreenshotAs() - Only firefox browser
		//----------------- We can't take screenshot of an Alert -------------
		
		driver.findElement(button_getAlert).click();
		Alert alert1 = driver.switchTo().alert();
		System.out.println(alert1.getText());
		
		File file3 = null;
		try {
			file3 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(file3, new File(destinationFolder.getPath().concat("/snap3.jpeg")));
		} catch (UnhandledAlertException e) {
			System.out.println("UnhandledAlertException is raised as expected.");
		}
		
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
