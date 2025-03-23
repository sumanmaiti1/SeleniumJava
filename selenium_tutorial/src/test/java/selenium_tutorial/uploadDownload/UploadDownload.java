package selenium_tutorial.uploadDownload;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium_tutorial.utilities.browserFactory.BrowserFactory;

public class UploadDownload {
	
	private WebDriver driver = BrowserFactory.getDriver("Chrome");
	private By input_chooseFile = By.id("file-upload");
	private By button_uploade = By.id("file-submit");
	private By label_uploadedFile = By.id("uploaded-files");
	
	private By link_excel = By.linkText("Excel.xlsx") ;
	
	//------------------------- Upload File ---------------------
	@Test
	public void test1() throws InterruptedException {
		driver.get("https://the-internet.herokuapp.com/upload");
		driver.getTitle().contains("The Internet");
		
		driver.findElement(input_chooseFile).sendKeys(System.getProperty("user.dir").concat("\\src\\test\\java\\selenium_tutorial\\uploadDownload")
																					.concat("\\JayShreeRam.txt"));
		Thread.sleep(2000);
		driver.findElement(button_uploade).click();
		
		assertTrue( new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOfElementLocated(label_uploadedFile))
														 .getText().contains("JayShreeRam.txt"));
		
	}
	
	//------------------------- Download File -------------------
	@Test
	public void test2() throws InterruptedException{		
		
		String filePath = System.getProperty("user.dir").concat("\\src\\test\\java\\selenium_tutorial\\uploadDownload\\downloads");
		
		ChromeOptions options=new ChromeOptions();
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_settings.popups", 0);
		prefs.put("download.default_directory", filePath);
		options.setExperimentalOption("prefs",prefs);
		WebDriver driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/download");
		driver.getTitle().contains("The Internet");
		
		driver.findElement(link_excel).click();
		Thread.sleep(10000);
		
		assertTrue(new File(filePath.concat("\\Excel.xlsx")).exists());
		assertTrue(new File(filePath.concat("\\Excel.xlsx")).delete());

		driver.quit();
	}
	
	@AfterEach
	void teardown() {
		BrowserFactory.quitDriver();
	}
	
}
