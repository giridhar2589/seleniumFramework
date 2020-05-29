package com.mu_sigma.OrgPlatformAutomationFramework.muMoments.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;

import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;

public class Contact_Creation_page extends TestBase {
	
	WebDriver driver;
	private static final Logger Contact_Creation_page_pageLog = LogManager.getLogger(Contact_Creation_page.class.getName());

	//xpath for contact tab
	By contact_Tab_Selection=By.xpath("//a[contains(text(),'Contacts')]");
	
	//xpath for plus icon
	By plusicon_contacts=By.xpath("//span[@tooltip='Create Contact']");		
	
	//xpath for firstname 
	By firstname_contacts=By.xpath("//input[@ng-model='contact.firstName']");
	
	//xpath for the lastname
	By lastname_contacts=By.xpath("//input[@placeholder='Last Name']");
		
	//xpath for the Account drop down
	By contact_Account_DropDown=By.xpath("(//a[@class='chosen-single chosen-default'])[1]");
	
	//xpath for Account selection
	By contact_Account_Selection=By.xpath("//li[contains(text(),'Abbott Laboratories')][1]");
	
	//xpath for contact level drop down
	By contact_Level_DropDown=By.xpath("(//a[@class='chosen-single chosen-default'])[3]");
	
	//xpath for contact level selection
	By contact_Level_Selection=By.xpath("//li[contains(text(),'Staff')]");
	
	//xpath for contact status drop down
	By contact_Status_DropDown=By.xpath("//span[contains(text(),'Status')]");
	
	//xpath for contact status selection
	By contact_Status_Selection=By.xpath("//li[contains(text(),'CHAMPION')]");
	
	//Click on Next button
    By contact_Nextpress1=By.xpath("//button[contains(text(),'Next')]");
	    
    //click on country selection box
    By contact_Country_DropDown=By.xpath("(//a[@class='chosen-single chosen-default'])[2]");
    
    //xpath for country selection
    By contact_Country_Selection=By.xpath("//li[contains(text(),'INDONESIA')]");
    
    //xpath for contact save button
    By contact_SaveButton=By.xpath("//button[contains(text(),'Save & Close')]");
    
    By contact_Validation_Message = By.xpath(
			"//div[@class='df-alerts ng-pristine ng-untouched ng-valid ng-scope ng-isolate-scope alert alert-danger' and contains(text(),'validation errors')]");
    
    public Contact_Creation_page(WebDriver driver) {
		this.driver=driver;
	
    }
    
    public String contactValidationMessageCheck(){
    	waitForElement(contact_Validation_Message, 15);
    	return driver.findElement(contact_Validation_Message).getText();
    }
    
    /*
     * Method for clicking on Contacts tab
     */
    public void clickOnContactsTab()
    {
    	clickWhenElementIsReady(driver, 20, contact_Tab_Selection);
    	try
    	{
    		Contact_Creation_page_pageLog.info("Trying to locate the element for clicking on Contacts tab");
    	}
    	catch (Exception e)
    	{
    		Contact_Creation_page_pageLog.info("Not able to find the element to click on Contacts tab");
    	}
    
    }
    
    /*
     * Method for Clicking on Plus icon under the Contacts tab
     */
    public void clickOnAddButtonIcon()
    {
    	clickWhenElementIsReady(driver, 20, plusicon_contacts);
    	//plusicon_contacts.click();
    	
    	try
    	{
    		Contact_Creation_page_pageLog.info("Trying to locate the element for clickin on Plus icon");
    	}
    	catch (Exception e)
    	{
    		Contact_Creation_page_pageLog.info("Not able to locate the element for plus icon button");
    	}
    }
    
    
    /*
     * Method for entering the first name
     */
    public void enterFirstName(String firstNameEnter)
    {
    	driver.findElement(firstname_contacts).sendKeys(firstNameEnter);
    try
    {
    	Contact_Creation_page_pageLog.info("Trying to locate element for the first name");
    }
    catch (Exception e)
    {
    	Contact_Creation_page_pageLog.info("Not able to locate the element first name");
    }
    }
    
    /*
     * Method for entering the last name
     */
    public void enterLastName(String lastNameEnter)
    {
     driver.findElement(lastname_contacts).sendKeys(lastNameEnter);
    
    try
    {
    	Contact_Creation_page_pageLog.info("trying to locate element  for entering last name");
    }
    catch (Exception e)
    {
    	Contact_Creation_page_pageLog.info("Not able to locate element for last name");
    }
    }
	
    /*
     * Account drop down clicking 
     */
    public void clickOnAccountSelectionDropDown()
    {
    clickWhenElementIsReady(driver, 20, contact_Account_DropDown);
    
    try
    {
    	Contact_Creation_page_pageLog.info("Trying to locate element for clicking on Account Dropdown");
    }
    catch (Exception e)
    {
    	Contact_Creation_page_pageLog.info("Not able to locate the element for Account Dropdown");
    }
    }
    
    /*
     * Account selection while creating a contact
     */
    public void selectingAccountforContact()
    {
    	clickWhenElementIsReady(driver, 20, contact_Account_Selection);
    try
    {
    	Contact_Creation_page_pageLog.info("Trying to locate the element for Account Selection");
    }
    catch (Exception e)
    {
    	Contact_Creation_page_pageLog.info("Failed to locate the element for Account Selection");
    }
    }
    
    /*
     * Clicking on Level drop down
     */
    public void clickOnContactLevelDropDown()
    {
    	clickWhenElementIsReady(driver, 20, contact_Level_DropDown);
   try
   {
	   Contact_Creation_page_pageLog.info("Trying to locate the element for Contact Level Drop Down");
   }
   catch (Exception e)
   {
	   Contact_Creation_page_pageLog.info("Not able to locate the element for contact level drop down");
   }
    }
    
    /*
     * Selecting the contact level
     */
    public void selectingTheContactLevel()
    {
    	clickWhenElementIsReady(driver, 20, contact_Level_Selection);
    try
    {
    	Contact_Creation_page_pageLog.info("Trying to locate the element for selecting the contact level");
    }
    catch (Exception e)
    {
    	Contact_Creation_page_pageLog.info("Not able to locate the element for contact level selection");
    }
    }
    
    /*
     * Method for contact status drop down click
     */
    public void clickOncontactStatusDropDown()
    {
    	clickWhenElementIsReady(driver, 20, contact_Status_DropDown);
    try
    {
    	Contact_Creation_page_pageLog.info("Trying to locate the element for contact status drop down");
    }
    catch (Exception e)
    {
    	Contact_Creation_page_pageLog.info("Not able to locate the element contact status drop down");
    }
       
    }
    
    /*
     * Method for selecting the contact status
     */
    public void selectingContactStatus()
    {
    	clickWhenElementIsReady(driver, 20, contact_Status_Selection);
    try
    {
    	Contact_Creation_page_pageLog.info("Trying to locate the element for selecting contact status");
    }
    catch (Exception e)
    {
    	Contact_Creation_page_pageLog.info("Not able to locate the element for selecting the contact status");
    }
    }
    
    /*
     * Method for clicking on Next button on the first page
     */
    public void clickOnNextButton1()
    {
    	clickWhenElementIsReady(driver, 20, contact_Nextpress1);
    try
    {
    Contact_Creation_page_pageLog.info("trying to locate the element for clicking on next button under the first tab");	
    }
    catch (Exception e)
    {
    Contact_Creation_page_pageLog.info("Not able to locate the element for clickin on next button");	
    }
    }
    
    /*
     * Method for clicking on country down
     */
    public void clickOnCountryDropDown()
    {
    	clickWhenElementIsReady(driver, 20, contact_Country_DropDown);
    	try
    	{
   Contact_Creation_page_pageLog.info("Trying to locate the element for country drop down");
    	}
    	catch (Exception e)
    	{
    		Contact_Creation_page_pageLog.info("Not able to locate the element for clickin on country drop down");
    	}
    }
    
    /*
     * Method for Selecting the country
     */
    public void selectingTheContactCountry()
    {
    	clickWhenElementIsReady(driver, 20, contact_Country_Selection);
    try
    {
    	Contact_Creation_page_pageLog.info("Trting to locate the element for selecting the country");
    }
    catch (Exception e)
    {
    	Contact_Creation_page_pageLog.info("Not able to locate the element for selecting the country");
    }
    }
    
    public void contact_SaveButton()
    {
    driver.findElement(contact_SaveButton).click();
    try
    {
    	Contact_Creation_page_pageLog.info("trying to locate the element for save button");
    }
    catch (Exception e)
    {
    	Contact_Creation_page_pageLog.info("Not able to locate the element for Save button click event");
    }
    }
}

