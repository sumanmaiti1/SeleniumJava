package selenium_tutorial.datePickers;

import static org.junit.Assert.assertTrue;

import java.time.Month;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import selenium_tutorial.utilities.browserFactory.BrowserFactory;

public class Calendar3 {
	
	WebDriver driver = BrowserFactory.getDriver("Chrome");
	private By calendar_calendar3 = By.id("third_date_picker");
	private By calendar_calendar3_month = By.xpath("//select[@class='ui-datepicker-month']");
	private By calendar_calendar3_Year = By.xpath("//select[@class='ui-datepicker-year']");
	
	private By calendar_calendar4 = By.id("fourth_date_picker");
	private By calendar_calendar6 = By.id("sixth_date_picker");
	private By calendar_calendar6Icon = By.xpath("//img[@title='Calendar-icon']");
	
	
	@Test
	public void Test1() throws InterruptedException {	
		
		driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");
		assertTrue(driver.getTitle().contains("Calendars Practice"));
		
		//---------------- Third Calender date Picker --------------

		String dateOfJourney = "06/29/2027";
		String month = Character.toString(Month.of(Integer.parseInt(dateOfJourney.split("/")[0])).name().charAt(0))  + 
					   Month.of(Integer.parseInt(dateOfJourney.split("/")[0])).name().substring(1,3).toLowerCase();
		driver.findElement(calendar_calendar3).click();
		Thread.sleep(500);
		new Select(driver.findElement(calendar_calendar3_Year)).selectByVisibleText(dateOfJourney.split("/")[2]);
		new Select(driver.findElement(calendar_calendar3_month)).selectByContainsVisibleText(month);
		driver.findElement(By.xpath("//a[text()='" + dateOfJourney.split("/")[1] +"']")).click();
		Thread.sleep(500);
		

		assertTrue("After Clicking on Sublit button confirmation Pop up is not populated. ",
				driver.findElement(calendar_calendar3).getDomProperty("value").equalsIgnoreCase(dateOfJourney));
		
		
		//---------------- Fourth Calender date Picker --------------

		dateOfJourney = "08/15/2020";
		month = Character.toString(Month.of(Integer.parseInt(dateOfJourney.split("/")[0])).name().charAt(0))  + 
					   Month.of(Integer.parseInt(dateOfJourney.split("/")[0])).name().substring(1,3).toLowerCase();
		driver.findElement(calendar_calendar4).click();
		Thread.sleep(500);
		new Select(driver.findElement(calendar_calendar3_Year)).selectByVisibleText(dateOfJourney.split("/")[2]);
		new Select(driver.findElement(calendar_calendar3_month)).selectByContainsVisibleText(month);
		driver.findElement(By.xpath("//a[text()='" + dateOfJourney.split("/")[1] +"' and @class='ui-state-default']")).click();
		Thread.sleep(500);
		

		assertTrue("After Clicking on Sublit button confirmation Pop up is not populated. ",
				driver.findElement(calendar_calendar4).getDomProperty("value").equalsIgnoreCase(dateOfJourney));
		
		
		//---------------- Sixth Calender date Picker --------------

		dateOfJourney = "12/31/2024";
		month =   Month.of(Integer.parseInt(dateOfJourney.split("/")[0])).name().toLowerCase();
		driver.findElement(calendar_calendar6Icon).click();
		Thread.sleep(500);
		WebElement prevIcon = driver.findElement(By.xpath("//a[@title='Prev']")) ;
		WebElement nextIcon = driver.findElement(By.xpath("//a[@title='Next']")) ;
		
		WebElement selectedMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")) ;
		WebElement selectedYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")) ;
		
		while((Integer.parseInt(selectedYear.getText()) > Integer.parseInt(dateOfJourney.split("/")[2])) || 
				(Month.valueOf(selectedMonth.getText().toUpperCase()).getValue() > Integer.parseInt(dateOfJourney.split("/")[0]))){
			driver.findElement(By.xpath("//a[@title='Prev']")).click();
			
			selectedMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")) ;
			selectedYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")) ;
		}
		
		
		while((Integer.parseInt(selectedYear.getText()) < Integer.parseInt(dateOfJourney.split("/")[2])) || 
				(Month.valueOf(selectedMonth.getText().toUpperCase()).getValue() < Integer.parseInt(dateOfJourney.split("/")[0]))){
			driver.findElement(By.xpath("//a[@title='Next']")).click();
			
			selectedMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")) ;
			selectedYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")) ;
		}

		
		driver.findElement(By.xpath("//a[text()='" + dateOfJourney.split("/")[1] +"' and @class='ui-state-default']")).click();
		Thread.sleep(500);
		
		assertTrue("After Clicking on Sublit button confirmation Pop up is not populated. ",
				driver.findElement(calendar_calendar6).getDomProperty("value").equalsIgnoreCase(dateOfJourney));
	
	}
	
	
	@AfterEach
	public void teardown() {
		BrowserFactory.quitDriver();
	}
	
}
