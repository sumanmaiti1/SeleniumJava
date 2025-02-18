package selenium_tutorial.alertPopupPrompts;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import selenium_tutorial.utilities.browserFactory.BrowserFactory;

public class Alert_1 {
	
	private WebDriver driver = BrowserFactory.getDriver("chrome");
	
	private By button_getConfirmation = By.id("confirm");
	private By button_getPrompt = By.id("prompt");
	private By button_jsPrompt = By.xpath("//button[text()='Click for JS Prompt']");
	private By label_youEntered = By.xpath("//p[contains(text(),'You entered')]");
	private By label_basicAuth = By.xpath("//h3[contains(text(),'Basic Auth')]");
	private By label_digestAuth = By.xpath("//h3[contains(text(),'Digest Auth')]");
	private By label_congratulation = By.xpath("//p[contains(text(),'Congratulations! You must have the proper credentials.')]");
	
	private By button_clickToOpenModal = By.xpath("//button[text()='Click To Open Modal']");
	private By label_someTextInModal = By.xpath("//p[text()='Some text in the modal.']");
	private By button_closeModal = By.xpath("//button[text()='Close']");
	private By label_modalHeader = By.xpath("//h4[text()='Modal Header']");
	
	private By link_iphone = By.xpath("(//a[@title='iPhone'])[last()]");
	private By image_iphone4LightBox = By.xpath("//img[contains(@src,'iphone_4') and not(@alt='iPhone')]");
	private By button_closeLightBox = By.xpath("//button[@title='Close (Esc)']");
	
	private By button_acceptAllCookies = By.xpath("//button[text()='Accept all']");
	private By link_aboutHenleyglobal = By.linkText("About");
	private By label_aboutUs = By.xpath("//h1[contains(text(),'About Us')]");
	
	private By button_whereAmI = By.xpath("//button[text()='Where am I?']");
	
	
	@Test
	public void Test() throws InterruptedException {
		
		driver.get("https://omayo.blogspot.com/");
		assertTrue(driver.getTitle().contains("omayo"));
		
		//------------------ if we don't handle Alert, we will get UnHandledAlert Exception ---------------		
		try {
			driver.findElement(button_getConfirmation).click();
			Thread.sleep(1000);
			assertTrue(driver.findElement(button_getPrompt).isEnabled());			
			} catch (UnhandledAlertException e) {
			// TODO: handle exception
			System.out.println("UnHandled Exception Occured.");
		} catch (InterruptedException e) {
				// TODO Auto-generated catch block
			System.out.println("Interrupted Exception Occured.");
			}
		
		
		//------------------ Check if Alert is present --------------
		 driver.findElement(button_getConfirmation).click();
		 Alert alert1 =  new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.alertIsPresent());
		 System.out.println(alert1.getText()); //------------- prints he alert Text
		 alert1.accept(); //------------------- Accept the Alert . click on OK utton
		 
		//------------------ Check if Alert is present --------------
		 driver.findElement(button_getConfirmation).click();
		 Alert alert2 =  driver.switchTo().alert();
		 System.out.println(alert2.getText()); //------------- prints he alert Text
		 alert2.dismiss(); //----------------- Click on the Cancel button of Alert Window
		 
		 
		 //------------ provide value in Textbox of Alert --------------
		 driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		 driver.findElement(button_jsPrompt).click();
		 Alert alert3 = driver.switchTo().alert();
		 System.out.println(alert3.getText());
		 alert3.sendKeys("Jay Shree Krishna");
		 Thread.sleep(1000);
		 alert3.accept();
		 
		 assertEquals("You entered: Jay Shree Krishna", driver.findElement(label_youEntered).getText().strip());
		
		 //--------------- Handelling authentication popup ---------------
		 //--------------- http://username:password@restURL --------------
		 driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
		 assertTrue(driver.findElement(label_basicAuth).isDisplayed());
		 assertTrue(driver.findElement(label_congratulation).isDisplayed());
		 
		 //--------------- Handelling authentication popup ---------------
		 //--------------- http://username:password@restURL --------------
		 driver.get("http://admin:admin@the-internet.herokuapp.com/digest_auth");
		 assertTrue(driver.findElement(label_digestAuth).isDisplayed());
		 assertTrue(driver.findElement(label_congratulation).isDisplayed());
		 
		 //---------- Handling Application Web Push Notifications (Permission Pop-ups) ------------
		 //  ChromeOptions options = new ChromeOptions();		//---------- this is already done in Browser Factory class ---------
		 //  options.addArguments(“–disable-notifications”);    //---------- this is already done in Browser Factory class ---------

		 
		 //----------------- Handling Bootstrap Model Dialogs ---------------------
		 driver.get("http://www.w3schools.com/Bootstrap/bootstrap_modal.asp");
		 driver.findElement(button_clickToOpenModal).click();
		 assertTrue(new WebDriverWait(driver, Duration.ofSeconds(10))
				 					.until(ExpectedConditions.visibilityOfElementLocated(label_someTextInModal)).isDisplayed());
		 driver.findElement(button_closeModal).click();
		 assertTrue(new WebDriverWait(driver, Duration.ofSeconds(10))
									.until(ExpectedConditions.invisibilityOfElementLocated(label_modalHeader)));
		 
		 //----------------- Handling Lightbox ----------------
		 driver.get("https://tutorialsninja.com/demo/index.php?route=product/product&product_id=40");
		 driver.findElement(link_iphone).click();
		 
		 assertTrue(new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(image_iphone4LightBox)).isDisplayed());
		 driver.findElement(button_closeLightBox).click();
		 assertTrue(new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.invisibilityOfElementLocated(image_iphone4LightBox)));
		 
		 //--------------- Handling Accept all cookies dialog --------------
		 driver.get("https://www.henleyglobal.com/");
		 assertTrue(driver.getTitle().equalsIgnoreCase("Residence and Citizenship by Investment | Henley & Partners"));
		 driver.findElement(button_acceptAllCookies).click();
		 driver.findElement(link_aboutHenleyglobal).click();
		 assertTrue(driver.findElement(label_aboutUs).isDisplayed());
		 
		 //------ Geolocation Popup . This will already be handled by [options.addArguments(“–disable-notifications”)] done in BrowserFactory.java class -------
		 driver.get("https://the-internet.herokuapp.com/geolocation");
		 driver.findElement(button_whereAmI).click();
		 Thread.sleep(5000);
	}
	
	@AfterAll
	public static void tearDown() {
		BrowserFactory.quitDriver();
	}
	
}
