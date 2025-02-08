
/**
 * This class will demonstrate some of the Webdriver commands mentioned in Topics.txt...
 * wesite Used : https://omayo.blogspot.com/
 */
package selenium_tutorial.webdriver_commands;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import selenium_tutorial.utilities.browserFactory.BrowserFactory;

public class webdriver_commands_3 {

	private WebDriver driver = BrowserFactory.getDriver("chrome");
	private By textbox_textareaField2 = By.xpath("//textarea[@rows=10 and @cols=30]");
	private By radio_male = By.id("radio1");
	private By radio_female = By.id("radio2");
	private By textbox_login = By.name("userid");
	private By textbox_password = By.name("pswrd");	
	
	@SuppressWarnings("deprecation")
	@Test
	@Tag("Krishna")
	public void Test1() throws InterruptedException{
		//------------------pageLoadTimeout(), implicitlyWait(), get() ----------------
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://google.com");
		Thread.sleep(2000);
		
		//----------- navigate(), to(), back(), forward(), refresh() -----------
		driver.navigate().to("https://omayo.blogspot.com/");
		driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().forward();
		driver.navigate().refresh();		
		
		driver.manage().window().maximize();
		
		//------------  get commands ---------------
		WebElement textAreaField2 = driver.findElement(textbox_textareaField2);
		System.out.println(textAreaField2.getAttribute("rows"));
		System.out.println(textAreaField2.getAccessibleName());
		System.out.println(textAreaField2.getAriaRole());
		System.out.println(textAreaField2.getCssValue("padding"));
		System.out.println(textAreaField2.getDomAttribute("rows"));
		System.out.println(textAreaField2.getDomProperty("value"));
		System.out.println(textAreaField2.getTagName());
		System.out.println(textAreaField2.getText());
		System.out.println(textAreaField2.getClass());
		System.out.println(textAreaField2.getLocation());
		System.out.println(textAreaField2.getRect().x + "-" + textAreaField2.getRect().y + "-"+ textAreaField2.getRect().height +"-"+ textAreaField2.getRect().width);
		System.out.println(textAreaField2.getShadowRoot());
		System.out.println(textAreaField2.getSize());
		
		textAreaField2.clear();
		textAreaField2.sendKeys("Jay Shree Ram");
		System.out.println(textAreaField2.getText());
		System.out.println("Value Provided");
		System.out.println(textAreaField2.getDomAttribute("cols"));
		System.out.println(textAreaField2.getDomProperty("value"));
		
		assertEquals(textAreaField2.getDomProperty("value"), "Jay Shree Ram");		
		assertEquals(driver.getTitle(), "omayo (QAFox.com)");
		
		System.out.println(driver.findElement(radio_female).isDisplayed());
		System.out.println(driver.findElement(radio_female).isEnabled());
		System.out.println(driver.findElement(radio_female).isSelected());
		if(!driver.findElement(radio_female).isSelected()) {
			driver.findElement(radio_female).click();
		}
		
		System.out.println("After Selection : " + (driver.findElement(radio_female).isSelected()));
		
		driver.findElement(textbox_login).sendKeys("Jay Shree Krishna");
		driver.findElement(textbox_password).sendKeys("Radhe Radhe");
		driver.findElement(textbox_password).submit();
		
		BrowserFactory.quitDriver();
	}

}
