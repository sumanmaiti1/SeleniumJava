package selenium_tutorial.robot;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium_tutorial.utilities.browserFactory.BrowserFactory;

public class Robot3 {
	
	private By div_uploadFile = By.xpath("//div[@class='mb-3']");
	private By button_upload = By.id("fileSubmit");
	private By label_downloaded = By.xpath("//h1[text()='File Uploaded!']");
	private By label_downloadedFileName = By.xpath("//p[contains(text(),'JayShreeRam')]");
	
	private By textBox_enterData = By.id("textbox");
	private By button_generateFile = By.id("createTxt");
	private By button_downoadFile = By.xpath("//a[text()='Download']");

	private Robot robot = new Robot();
	
	private Robot3() throws AWTException{}

	//--------------- Upload File using Robot ------------------
	@Test
	public void test1() throws InterruptedException {
		WebDriver driver = BrowserFactory.getDriver("Chrome");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://practice.expandtesting.com/upload");		
		assertTrue(driver.getTitle().contains("Files Upload page for Automation Testing Practice"));
		
		driver.findElement(div_uploadFile).click();
		robot.delay(2000);
		StringSelection strSelection = new StringSelection( System.getProperty("user.dir").concat("\\src\\test\\java\\selenium_tutorial\\robot\\downloads")
															.concat("\\JayShreeRam.txt"));
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(strSelection,null); 
		
		
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(2000);
		
		new Actions(driver).moveToElement(driver.findElement(button_upload)).perform();
		new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(button_upload)).click();
		
		List<WebElement> list = new WebDriverWait(driver, Duration.ofSeconds(30))
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(label_downloadedFileName));
		
		robot.delay(2000);
		
		assertAll("Checking if Upload is Completed successfully ", 
				()->assertTrue(list.size()>=1));
		
	}
	
	//--------------- Download File------------------
   @Test
	public void test2() throws InterruptedException {		
		
		String filePath = System.getProperty("user.dir").concat("\\src\\test\\java\\selenium_tutorial\\robot\\downloads");
		
		ChromeOptions options=new ChromeOptions();
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_settings.popups", 0);
		prefs.put("download.default_directory", filePath);
		options.setExperimentalOption("prefs",prefs);
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		//String path = System.getProperty("user.dir").concat("\\src\\test\\java\\selenium_tutorial\\robot\\downloads\\k-meleon.lnk");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.automationtesting.in/FileDownload.html");		
		assertTrue(driver.getTitle().equals("File input - Multi select"));
		
		//--------------------- Download Files using Robot class ----------------
		
		driver.findElement(textBox_enterData).clear();
		driver.findElement(textBox_enterData).sendKeys("Jay Shree Ram");
		driver.findElement(button_generateFile).click();
		driver.findElements(button_downoadFile).get(1).click();
		robot.delay(5000);
		
		
		assertTrue(new File(filePath + "\\info.txt").exists());
		assertTrue(new File(filePath + "\\info.txt").delete());
		
		driver.quit();
		
	}
	
	@AfterEach
	public void tearDown() {
		BrowserFactory.quitDriver();
	}
	
	
}
