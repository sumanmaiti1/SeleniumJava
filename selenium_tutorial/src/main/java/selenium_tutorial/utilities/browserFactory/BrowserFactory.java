package selenium_tutorial.utilities.browserFactory;

import org.openqa.selenium.WebDriver;

public class BrowserFactory {
	
	private String browserName;
	private static ThreadLocal<WebDriver> drivers = new ThreadLocal<WebDriver>();
	
	//------------get browser instance ------------
	public static synchronized WebDriver getDriver(String browserName) {
		
		WebDriver driver = drivers.get();
		if (null == drivers.get()) {
			
			switch (browserName.toUpperCase()) {
			case "EDGE":
				driver = new EdgeWebDriver().getEdgeDriver();
				break;
			case "CHROME":
				driver = new ChromeWebDriver().getChromeDriver();
				break;
			default:
				driver = new ChromeWebDriver().getChromeDriver();
				break;
			}
		}
		drivers.set(driver);
		System.out.println("invoked by Thread :" + Thread.currentThread().getName());
		return drivers.get();
	}
	
	
	
	//------------close browsder instance ------------
	public static synchronized void quitDriver() {
		WebDriver driver = drivers.get();
		if(driver != null) {
			driver.quit();
			drivers.remove();
		}
	}
	
}