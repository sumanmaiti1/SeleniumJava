package selenium_tutorial.javascriptExecutor;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import selenium_tutorial.utilities.browserFactory.BrowserFactory;

public class JacaScriptExecutor2 {
	
	WebDriver driver = BrowserFactory.getDriver("Chrome");	
	private By checkBox_option1 = By.id("checkBoxOption1");
	private By checkBox_option2 = By.id("checkBoxOption2");
	private By checkBox_option3 = By.id("checkBoxOption3");
	
	@Test
	public void test() throws InterruptedException {
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		JavascriptExecutor jse = ((JavascriptExecutor)driver);
		
		System.out.println("------------- Clicking by Purely Javascript, using Document----------- ");
		jse.executeScript("document.getElementById('checkBoxOption1').click()");
		Thread.sleep(1000);
		jse.executeScript("document.getElementsByClassName('radioButton')[1].click()");
		Thread.sleep(1000);
		jse.executeScript("document.getElementsByName('radioButton')[0].click()");
		Thread.sleep(1000);
		jse.executeScript("document.getElementsByTagName('select')[0].selectedOptions[0].text='Option1'");
		Thread.sleep(1000);			
		jse.executeScript("document.querySelector('#name').value='Jay Shree Ram'");
		Thread.sleep(1000);
		System.out.println(jse.executeScript("return document.querySelectorAll('.btn-style')[3].value"));
		Thread.sleep(1000);
		
		System.out.println(jse.executeScript("return document.title"));
		System.out.println(jse.executeScript("return document.URL"));
		System.out.println(jse.executeScript("return document.getElementById('checkBoxOption1').id"));
		System.out.println(jse.executeScript("return document.getElementsByTagName('legend')[0].innerHTML"));
		System.out.println(jse.executeScript("return document.getElementsByTagName('legend')[1].innerText"));
		System.out.println(jse.executeScript("document.getElementsByTagName('legend')[0].style.color='Orange'"));
		System.out.println(jse.executeScript("document.getElementsByTagName('legend')[1].style.background='Red'"));
		
		Thread.sleep(2000);
		
		//------------- Clicking by Javascript + Selenium Element, using arguments[0].click ----------- 
		System.out.println("------------- Clicking by Javascript + Selenium Element, using arguments[0].click ----------- ");
		Thread.sleep(1000);
		//jse.executeScript("arguments[0].click();","arguments[1].click();",driver.findElement(checkBox_option3),driver.findElement(checkBox_option2));
		jse.executeScript("arguments[0].click();arguments[1].click()",driver.findElement(checkBox_option3),driver.findElement(checkBox_option2));
		Thread.sleep(1000);
	}
		
	@AfterEach
	public void teardown() {
		BrowserFactory.quitDriver();
	}
		
}