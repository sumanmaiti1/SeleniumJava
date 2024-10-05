package selenium_tutorial;

import java.io.File;
import java.util.Collections;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.edge.EdgeOptions;

import selenium_tutorial.utilities.ReadPropertyFile;

public class FirstSeleniumScript {

    public static void main(String[] args) {

        //----------- reading EdgeDriver Path from Property File
        String driverPath = ReadPropertyFile.read("msEdgeDriverPath");
        //--------- Creating a file object of Edge Driver 
        File driverFile = new File(driverPath);
        //--------- Creating a EdgeDriverService object for Edge Driver 
        EdgeDriverService service = new EdgeDriverService.Builder().usingDriverExecutable(driverFile).build();

        //--------- Creating Edge Option class 
        EdgeOptions option = new EdgeOptions();

        //--------This is to prevent "Microsoft Edge is being controlled by automated test software"
        option.setExperimentalOption("useAutomationExtension", false);
        option.setExperimentalOption("excludeSwitches",Collections.singletonList("enable-automation"));

        //----------- Creating webdriver using service----------
        WebDriver driver = new EdgeDriver(service,option);

        //----------Maximize the browser
        driver.manage().window().maximize();

        //--------opening google.com
        driver.get("https://google.com");

        //---------verifying if google.com is populated successfully by checking the Page Title----------
        if (driver.getTitle().equals("Google")) {
            System.out.println("Google page is successfully loaded");
        } else{
            System.out.println("Google page isn't successfully loaded");
        }
        //----------- Quiting Webdriver Edge instance
        driver.quit();
    }
}
