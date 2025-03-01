//-------------Taking Screenshots using Robot Class -------------------
//------------- It can also take screenshot of an Alert ---------------
//------------ It can take screenshots with application URL -----------

package selenium_tutorial.takingScreenshots;

import static org.junit.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import selenium_tutorial.utilities.browserFactory.BrowserFactory;

public class Screenshots3 {
	
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
		
		Robot robot = new Robot();
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle rect = new Rectangle(dimension);
		
		//------------ take screenshot of Whole screen -----------------
		File screenshotPath1 = new File(destinationFolder.getPath().concat("/robotScreenshot1.png"));
		BufferedImage bufferedImage1 = robot.createScreenCapture(rect);
		ImageIO.write(bufferedImage1,"png",screenshotPath1);

		
		//----------------- take screenshot of Alert --------------
		driver.findElement(button_getPrompt).click();
		Thread.sleep(1000);
		Alert alert1 = driver.switchTo().alert();
		System.out.println(alert1.getText());
		
		File screenshotPath2 = new File(destinationFolder.getPath().concat("/robotScreenshot2.bmp"));
		BufferedImage bufferedImage2 = robot.createScreenCapture(rect);
		ImageIO.write(bufferedImage2, "bmp", screenshotPath2);
		alert1.dismiss();
		
		assertTrue(screenshotPath1.exists());
		assertTrue(screenshotPath2.exists());
		
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
