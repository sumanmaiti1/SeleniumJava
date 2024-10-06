package selenium_tutorial.utilities.browserFactory;

import java.io.File;
import java.util.Collections;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.edge.EdgeOptions;

import selenium_tutorial.utilities.ReadPropertyFile;

public class EdgeWebDriver {
	
	private WebDriver driver;
	private EdgeOptions options = new EdgeOptions();
	private String driverpath= ReadPropertyFile.read("msEdgeDriverPath");
	private File driverFile = new File(driverpath);
	private EdgeDriverService service = new EdgeDriverService.Builder().usingDriverExecutable(driverFile).build();
	

	
	public WebDriver getEdgeDriver() {
		return new EdgeDriver(service,getEdgeOptions());
	}
	
	
	//----------------- for Chromr Options Options----------------
	private EdgeOptions getEdgeOptions() {
		
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
