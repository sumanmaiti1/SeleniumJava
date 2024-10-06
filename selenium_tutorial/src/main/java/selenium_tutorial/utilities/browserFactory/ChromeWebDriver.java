package selenium_tutorial.utilities.browserFactory;

import java.io.File;
import java.util.Collections;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import selenium_tutorial.utilities.ReadPropertyFile;

public class ChromeWebDriver {
	
	private WebDriver driver;
	private ChromeOptions options = new ChromeOptions();
	private String driverpath= ReadPropertyFile.read("chromeDriverPath");
	private File driverFile = new File(driverpath);
	private ChromeDriverService service = new ChromeDriverService.Builder().usingDriverExecutable(driverFile).build();
	

	
	public WebDriver getChromeDriver() {
		return new ChromeDriver(service,getChromeOptions());
	}
	
	
	//----------------- for Chromr Options Options----------------
	private ChromeOptions getChromeOptions() {
		
		options.addArguments("--disable-notifications");
		options.addArguments("--start-maximized");
		options.addArguments("--disable-features=EnableEphemeralFlashPermission");
		options.addArguments("--disable-infobars");
		//--------This is to prevent "Microsoft Edge is being controlled by automated test software"
		options.setExperimentalOption("useAutomationExtension", false);
		options.setExperimentalOption("excludeSwitches",Collections.singletonList("enable-automation"));
		
		return options;
	}
	
}
