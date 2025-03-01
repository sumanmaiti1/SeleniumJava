//-------------Taking Screenshots using ASHOT API LIBRARY -------------------
//------------- It can also take screenshot of an Alert ---------------
//------------ It can take screenshots with application URL -----------

package selenium_tutorial.takingScreenshots;

import static org.junit.Assert.assertTrue;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import selenium_tutorial.utilities.browserFactory.BrowserFactory;

public class Screenshots4 {
	
	WebDriver driver = BrowserFactory.getDriver("chrome");
	private By table_table1 = By.id("table1");
	private By button_getPrompt = By.id("prompt"); 
	private By button_getAlert = By.id("alert1"); 
	
	@Test
	public void Test() throws IOException, AWTException, InterruptedException {
		
		driver.get("https://omayo.blogspot.com/");
		assertTrue(driver.getTitle().contains("omayo"));
		
		//------------ Create object for Robot class -----------------
		File destinationFolder = new File("./src/test/java/selenium_tutorial/takingScreenshots/Screenshots");
		destinationFolder.mkdir();
		
		//------------ take screenshot of Whole screen -----------------
		File screenshotPath1 = new File(destinationFolder.getPath().concat("/robotScreenshot1.png"));
		Screenshot screenshot1 = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		ImageIO.write(screenshot1.getImage(),"PNG",screenshotPath1);

		
		//----------------- take screenshot of Alert. THIS WON'T WORK --------------
		//----------------- This WON'T WORK. Will raise Runtime Exception As it will try to Scroll down with Alret Open ---------
		driver.findElement(button_getAlert).click();
		Thread.sleep(1000);
		Alert alert1 = driver.switchTo().alert();
		System.out.println(alert1.getText());
		try {
			File screenshotPath2 = new File(destinationFolder.getPath().concat("/robotScreenshot2.png"));
			Screenshot screenshot2 = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
			ImageIO.write(screenshot2.getImage(),"PNG",screenshotPath2);
			alert1.accept();
		}catch (RuntimeException e) {
			System.out.println("As expected UnHandld Alert Exception occured. \n\n"+ e.getMessage());
		}
				
		assertTrue(screenshotPath1.exists());
		
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
