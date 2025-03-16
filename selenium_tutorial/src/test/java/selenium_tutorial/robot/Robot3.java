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
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium_tutorial.utilities.browserFactory.BrowserFactory;

public class Robot3 {
	
	WebDriver driver = BrowserFactory.getDriver("Chrome");
	private By button_uploadFile = By.xpath("//label[@for='select-files-input']");
	private By label_downloadedFileName = By.xpath("//h3[text()='k-meleon.exe']");
	
	private By textBox_enterData = By.id("textbox");
	private By button_generateFile = By.id("createTxt");
	private By button_downoadFile = By.xpath("//a[text()='Download']");

	private Robot robot = new Robot();
	
	private Robot3() throws AWTException{}

	//--------------- Upload File using Robot ------------------
	
	public void test1() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.file.io/");		
		assertTrue(driver.getTitle().equals("file.io - Super simple file sharing"));
		
		driver.findElement(button_uploadFile).click();
		robot.delay(2000);
		StringSelection strSelection = new StringSelection("C:\\Users\\Radhe_Radhe\\Desktop\\k-meleon.lnk");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(strSelection,null); 
		
		
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		List<WebElement> list = new WebDriverWait(driver, Duration.ofSeconds(30))
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(label_downloadedFileName));
		
		robot.delay(2000);
		
		assertAll("Checking if Upload is Completed successfully ", 
				()->assertTrue(list.size()>=1));
		
		//--------------------- Download Files using Robot class ----------------
		driver.findElements(button_downoadFile).get(0).click();
		robot.delay(5000);
		
		String path = System.getProperty("user.dir").concat("\\src\\test\\java\\selenium_tutorial\\robot\\downloads\\k-meleon.lnk");
		StringSelection strSelectionDownload = new StringSelection(path);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(strSelectionDownload,null); 
		
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		assertTrue(new File(path).exists());
		
	}
	
	//--------------- Download File using Robot ------------------
	@Test
	public void test2() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.automationtesting.in/FileDownload.html");		
		assertTrue(driver.getTitle().equals("File input - Multi select"));
		
		ChromeOptions options=new ChromeOptions();
		Map<String, Object> prefs = new HashMap<String, Object>();
		//String path = System.getProperty("user.dir").concat("\\src\\test\\java\\selenium_tutorial\\robot\\downloads\\k-meleon.lnk");
		String path = System.getProperty("user.dir").concat("\\src\\test\\java\\selenium_tutorial\\robot\\downloads");
		prefs.put("download.default_directory", path);

		options.setExperimentalOption("prefs", prefs);
		
		//--------------------- Download Files using Robot class ----------------
		driver.findElement(textBox_enterData).clear();
		driver.findElement(textBox_enterData).sendKeys("Jay Shree Ram");
		driver.findElement(button_generateFile).click();
		driver.findElements(button_downoadFile).get(1).click();
		robot.delay(5000);
		
		
		StringSelection strSelectionDownload = new StringSelection(path);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(strSelectionDownload,null); 
		
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		assertTrue(new File(path).exists());
		
	}
	
	@AfterEach
	public void tearDown() {
		BrowserFactory.quitDriver();
	}
	
	
}
