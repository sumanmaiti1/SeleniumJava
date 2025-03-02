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

public class Calendar1 {
	
	WebDriver driver = BrowserFactory.getDriver("Chrome");
	private By calendar_calendar1 = By.xpath("//input[@name='form_fields[travel_comp_date]']");
	private By div_calendarBody = By.className("flatpickr-calendar");
	private By selectedmonthName = By.xpath("//span[@title='Scroll to increment']");
	private By selectedYear = By.cssSelector(".numInput");
	private By nextButton = By.className("flatpickr-next-month");
	
	
	@Test
	public void Test1() throws InterruptedException {
		
		
		String dateOfJourney = "03/23/2027";
//		while(!(dateOfJourney.strip().length()>0)) {
//			System.out.println("Enter date in mm/dd/yyyy Format : ");
//			try {
//				dateOfJourney = new Scanner(System.in).next("(0[1-9]|1[0-2])/(0[1-9]|(1|2)[0-9]|3[0-1])/[0-9][0-9]{1,3}");
//			} catch (Exception e) {
//				System.out.println("Wrong Value Provided.");
//			}
//			
//		}
		
		
		String[] arrDate = dateOfJourney.split("/");
		String monthName = Month.of(Integer.parseInt(arrDate[0])).name();
		String date = arrDate[1];
		String year = arrDate[2];
		
		driver.get("https://www.path2usa.com/travel-companion/");
		assertTrue(driver.getTitle().equalsIgnoreCase("Find a Travel Companion - Path2USA"));
		
		try {
			new Actions(driver).moveToElement(driver.findElement(calendar_calendar1)).click().build().perform();
		  } catch (Exception e) {
		     JavascriptExecutor executor = (JavascriptExecutor) driver;
		     executor.executeScript("arguments[0].click();", driver.findElement(calendar_calendar1));
		  }
		
		assertTrue("After Clicking on calendar icon calendar body is not populated.", driver.findElement(div_calendarBody).isDisplayed());
		
		//----------------------- Getting Currently Selected monthname and Year --------------------------
		//---------------------- Click Next Month button untill month and year matches ------------------
		String selectedMonthYear = driver.findElement(selectedmonthName).getText().strip() + driver.findElement(selectedYear).getDomProperty("value").strip();; 
		while(! selectedMonthYear.equalsIgnoreCase(monthName+year)) {
			driver.findElement(nextButton).click();
			Thread.sleep(500);
			selectedMonthYear =  driver.findElement(selectedmonthName).getText().strip() + driver.findElement(selectedYear).getDomProperty("value").strip();			
		}
		
		//---------------- Now select the date ----------------
		By datelink = By.xpath("//div[@class='dayContainer']//span[not(contains(@class,'next')) and not(contains(@class,'prev')) "
				+ "and not(contains(@class,'disabled')) and text()='" + date + "']");
		
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
