package selenium_tutorial.actionChains;

import static org.junit.Assert.assertTrue;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium_tutorial.utilities.browserFactory.BrowserFactory;

public class ActionChains2 {
	
	WebDriver driver = BrowserFactory.getDriver("Chrome");
	private By link_leftSlider = By.xpath("//a[@aria-labelledby='price-min-label']");
	private By link_rightSlider = By.xpath("//a[@aria-labelledby='price-max-label']");
	private By box_oslo = By.id("box1");
	private By box_Stockholm = By.id("box2");
	private By box_Washington = By.id("box3");
	private By box_Copenhagen = By.id("box4");
	private By box_Seoul = By.id("box5");
	private By box_Rome = By.id("box6");
	private By box_Madrid = By.id("box7");
	
	private By box_Norway = By.id("box101");
	private By box_Sweden = By.id("box102");
	private By box_United_States = By.id("box103");
	private By box_Denmark = By.id("box104");
	private By box_South_Korea = By.id("box105");
	private By box_Italy = By.id("box106");
	private By box_Spain = By.id("box107");
	
	private By button_rightClickMe = By.xpath("//span[text()='right click me']");
	private By box_resizable =By.xpath("//div[@class='ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se']");

	
	@Test
	public void Test1() throws InterruptedException {
		driver.get("http://omayo.blogspot.com/p/page3.html");
		assertTrue(driver.getTitle().contains("omayo"));
		
		//--------------- moveToElement() , moveToLocation,  perform() -------------
		System.out.println("dragging and dropping the startButton on a slider horizontal to the right");
		new Actions(driver).dragAndDropBy(driver.findElement(link_leftSlider),50,0).perform();
		Thread.sleep(1000);
		new Actions(driver).dragAndDropBy(driver.findElement(link_leftSlider),-25,0).perform();
		Thread.sleep(1000);
		
		new Actions(driver).dragAndDropBy(driver.findElement(link_rightSlider),50,0).perform();
		Thread.sleep(1000);
		new Actions(driver).dragAndDropBy(driver.findElement(link_rightSlider),-75,0).perform();
		Thread.sleep(1000);
		
				
		//--------------- clickAndHold() moveToElement() and release() --------------------		
		driver.get("http://dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
		assertTrue(driver.getTitle().contains("Drag and drop"));
		new Actions(driver).clickAndHold(driver.findElement(box_Copenhagen)).moveToElement(driver.findElement(box_Denmark)).release().build().perform();
		new Actions(driver).clickAndHold(driver.findElement(box_Seoul)).moveToElement(driver.findElement(box_South_Korea)).release().build().perform();
		new Actions(driver).clickAndHold(driver.findElement(box_Madrid)).moveToElement(driver.findElement(box_Spain)).release().build().perform();
		
		Thread.sleep(2000);
		
		//--------------- dragAndDrop() -------------------
		new Actions(driver).dragAndDrop(driver.findElement(box_oslo), driver.findElement(box_Norway)).perform();
		new Actions(driver).dragAndDrop(driver.findElement(box_Washington), driver.findElement(box_United_States)).perform();
		new Actions(driver).dragAndDrop(driver.findElement(box_Rome), driver.findElement(box_Italy)).perform();
		
		Thread.sleep(2000);
		
		//--------------- contextClick() -------------------
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo");
		assertTrue(driver.getTitle().contains("jQuery contextMenu"));
		
		new Actions(driver).contextClick(driver.findElement(button_rightClickMe)).sendKeys(Keys.ARROW_DOWN).pause(1)
							.sendKeys(Keys.ARROW_DOWN).pause(1).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		
		Thread.sleep(2000);
		assertTrue(new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.alertIsPresent()).getText().contains("copy"));
		new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.alertIsPresent()).accept();
		
		//--------------- esize Elements by dragAndDropBy()---------------
		driver.get("https://jqueryui.com/resizable/");
		assertTrue(driver.getTitle().contains("Resizable | jQuery UI"));
		
		driver.switchTo().frame(0);
		new Actions(driver).dragAndDropBy(driver.findElement(box_resizable), 150, 100).perform();
		Thread.sleep(2000);
		
	}
	
	@AfterEach
	public void teardown() {
		BrowserFactory.quitDriver();
	}
	
}
