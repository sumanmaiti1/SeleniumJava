// ------- Now we will discuss about the advance CSS selector strategies -------
// ------- demo URL : https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php -------
// ------  https://www.automatetheplanet.com/selenium-webdriver-locators-cheat-sheet/  ------

package selenium_tutorial.locators;

import org.openqa.selenium.By;

public class TextXpathAdvanced {
	
	private By textbox_nameAbsolute = By.xpath("/html/body/main/div/div/div[2]/form/div[1]/div/input");   //---------- Absolute Xpath
	private By textbox_nameRelative = By.xpath("//input[@id='name']");        // ----------- attribute with ID
	private By textbox_name1 = By.xpath("//input[@name='name']");        // ----------- attribute with name
	private By textbox_name2 = By.xpath("//input[@id='name' and @name='name']");        // ----------- attribute with name AND id
	private By textbox_name3 = By.xpath("//input[@id='name' or @name='name']");        // ----------- attribute with name OR id
	private By textbox_name4 = By.xpath("//input[@id='name' and @name!='bame']");        // ----------- attribute with name and id AND NOT
	private By textbox_with_id_attribute = By.xpath("//input[@id]");      // ------------  input field with name attribute
	private By textbox_name5 = By.xpath("//input[@id='name'][@name='name']");  // ----------- attribute with name and id
	private By textbox_name6 = By.xpath("//input[@id='name' and not(@name='bame')]");        // ----------- attribute with name and id and Not
	private By label_dob1 = By.xpath("//label[contains(text(),'Date')]");  //----------- contains and text
	private By label_dob2 = By.xpath("//label[starts-with(text(),'Date')]");  //----------- contains text in starts-with
	private By label_dob3 = By.xpath("//label[ends-with(text(),'Birth:')]");  //----------- contains text in ends-with
	private By label_dob4 = By.xpath("//label[normalize-space(text()) = 'Date of Birth:']");   //---------- Normalize-space
	private By textbox_name7 = By.xpath("//form[@id='practiceForm']//input[1]");     //----------- use of // and index
	private By textbox_name8 = By.xpath("//input[@id][1]");     //----------- use of index
	private By option_meerut = By.xpath("//select[@id='city']//option[last()]");      // ---------- Last() element
	private By option_lucknow = By.xpath("//select[@id='city']//option[last()-1]");   // ---------- Second Last element

	//------------ Xpath Axes --------------
	private By select_city1 = By.xpath("//select[@id='city']/.");     // ----------- . represents current element
	private By parent_div_select_city1 = By.xpath("//select[@id='city']/..");     // ----------- .. represents Parent element
	private By parent_div_select_city_state = By.xpath("//select[@id='city']/../..");     // ----------- .. represent parent
	private By select_city2 = By.xpath("//select[@id='city']/self::*");     // ----------- . represents current element Self
	private By parent_div_select_city2 = By.xpath("//select[@id='city']/parent::div/.." );    // ----------- parent
	private By select_city3 = By.xpath("//select[@id='city']/parent::div/child::select");      // ----------- child


	// ------------ https://www.tutorialspoint.com/selenium/practice/webtables.php -----------
	private By td_salary = By.xpath("//td[text()>10000]");
	private By td_ancestor = By.xpath("//td[text()='Insurance']/ancestor::tbody");
	private By td_descendant = By.xpath("//td[text()='Insurance']/ancestor::tbody/descendant::td[text()='Vega']");
	private By td_following = By.xpath("//td[text()='Vega']/following::td");
	private By td_preceeding = By.xpath("//td[text()='Insurance']/preceding::td");
	private By td_preceeding_siblings = By.xpath("(//td[text()='Cantrell']/preceding-sibling::td)[1]");
	private By td_following_siblings = By.xpath("(//td[text()='Cantrell'])[2]/following-sibling::td");
	private By chkbox_music = By.xpath("//label[text()='Music']/preceding-sibling::input");
	
}
