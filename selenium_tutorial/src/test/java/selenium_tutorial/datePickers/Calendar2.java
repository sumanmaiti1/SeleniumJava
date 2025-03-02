package selenium_tutorial.datePickers;

import static org.junit.Assert.assertTrue;

import java.time.Month;
import java.util.Scanner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import selenium_tutorial.utilities.browserFactory.BrowserFactory;

public class Calendar2 {
	
	WebDriver driver = BrowserFactory.getDriver("Chrome");
	private By calendar_calendar1 = By.id("datepicker");
	private By div_calendarBody = By.id("ui-datepicker-div");
	private By selectedmonthName = By.cssSelector(".ui-datepicker-month");
	private By selectedYear = By.cssSelector(".ui-datepicker-year");
	private By nextButton = By.xpath("//a[@title='Next']");
	private By prevButton = By.xpath("//a[@title='Prev']");
	
	
	@Test
	public void Test1() throws InterruptedException {
		
		
		String dateOfJourney = "03/01/2025";
		
		String[] arrDate = dateOfJourney.split("/");
		String monthName = Month.of(Integer.parseInt(arrDate[0])).name();
		String date = arrDate[1];
		String year = arrDate[2];
		
		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
		assertTrue(driver.getTitle().contains("Selenium Practise"));
		
//		//----------------- set Calender by SendKeys ----------------
//		driver.findElement(calendar_calendar1).sendKeys(dateOfJourney);
//		Thread.sleep(1000);
//		driver.findElement(calendar_calendar1).sendKeys("");
		
		
		driver.findElement(calendar_calendar1).click();
		assertTrue("After Clicking on calendar icon calendar body is not populated.", driver.findElement(div_calendarBody).isDisplayed());
			
		//----------------------- Getting Currently Selected monthname and Year --------------------------
		//---------------------- Click Next Month button untill month and year matches -------------------
		
		String selectedMonthYear = driver.findElement(selectedmonthName).getText().strip() + driver.findElement(selectedYear).getText().strip(); 
		while(! selectedMonthYear.equalsIgnoreCase(monthName+year)) {
			
			if(Integer.parseInt(year)>Integer.parseInt( driver.findElement(selectedYear).getText().strip())) {
				driver.findElement(nextButton).click();
			}else if(Integer.parseInt(year)<Integer.parseInt( driver.findElement(selectedYear).getText().strip())) {
				driver.findElement(nextButton).click();
			}
			
			if(Integer.parseInt(arrDate[0]) > Month.valueOf(driver.findElement(selectedmonthName).getText().strip().toUpperCase()).getValue()) {
				driver.findElement(nextButton).click();
			}else if(Integer.parseInt(arrDate[0]) < Month.valueOf(driver.findElement(selectedmonthName).getText().strip().toUpperCase()).getValue()) {
				driver.findElement(nextButton).click();
			}
			
			Thread.sleep(500);
			selectedMonthYear =  driver.findElement(selectedmonthName).getText().strip() + driver.findElement(selectedYear).getText().strip();			
		}
		
		//---------------- Now select the date ----------------
		By datelink = By.xpath("//a[text()='" + Integer.parseInt(date) + "']");
		
		new Actions(driver).moveToElement(driver.findElement(datelink)).click().build().perform();
		
		System.out.println("Input Date : " + dateOfJourney);
		System.out.println("Selected Date : " + driver.findElement(calendar_calendar1).getDomProperty("value"));
		assertTrue("Calender date is not equal to the date provided",driver.findElement(calendar_calendar1).getDomProperty("value").equalsIgnoreCase(dateOfJourney));		
		
	}
	
	
	@AfterEach
	public void teardown() {
		BrowserFactory.quitDriver();
	}
	
}
