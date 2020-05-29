package com.mu_sigma.OrgPlatformAutomationFramework.muMoments.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;

public class Contact_Acc_Man extends TestBase {

	WebDriver driver;
	
	private static final Logger Contact_Account_Mandatory_pageLog = LogManager.getLogger(Contact_Acc_Man.class.getName());
	
	//xpath for Contact tab selection
	By contact_Tab_SelectionAccMan=By.xpath("//a[contains(text(),'Contacts')]");
	
	//xpath for Plus Icon 
	//By contact_PlusIconAccMAn=By.xpath("//span[@class='glyphicon glyphicon-plus-sign ng-scope']");	
	By contact_PlusIconAccMAn=By.xpath("//span[@tooltip='Create Contact']");
	
	//xpaht for First Name
	
	By contact_FirstNameAccMan=By.xpath("//input[@ng-model='contact.firstName']");
	
	//xpath for Last Name
	By contact_LastNameAccMan=By.xpath("//input[@placeholder='Last Name']");
	
	//xpath for Level drop Down
	By contact_Level_DropDownAccMan=By.xpath("(//a[@class='chosen-single chosen-default'])[2]");
	
	//xpath for level selection
	By contact_Level_SelectionAccMan=By.xpath("//li[contains(text(),'Staff')]");
	
	//xpath for Status Drop Down
	By contact_Status_DropDownAccMan=By.xpath("(//a[@class='chosen-single chosen-default'])[3]");
	
	//xpath for Status selection
	By contact_Status_SelectionAccMan=By.xpath("//li[contains(text(),'CHAMPION')]");
	
	//Click on Next button
    By contact_NextPress1=By.xpath("//button[contains(text(),'Next')]");
	
	//click on Cancel button
	By contact_CancelButtonAccMan=By.xpath("//button[@class='btn df-btn-text ng-scope']");

	public Contact_Acc_Man(WebDriver driver)
	{
	this.driver=driver;
	
	}
	
	/*
	 * method for clicking on Contacts tab
	 */
    public void clickOnContactsTabAccMan()
    {
    	clickWhenElementIsReady(driver, 20, contact_Tab_SelectionAccMan);
    	try{
    		Contact_Account_Mandatory_pageLog.info("Trying to locate element for Contact tab");
    	}
    	catch(Exception e)
    	{
    		Contact_Account_Mandatory_pageLog.info("Not able to find element for clicking on Accounts tab");
    	}
    }
    
    /*
     * method for clicking on plus icon
     */
    public void clickOnPlusIconAccountMan()
    {
    	clickWhenElementIsReady(driver, 20, contact_PlusIconAccMAn);
    	try
    	{
    		Contact_Account_Mandatory_pageLog.info("Trying to locate element for clicking the plus icon");
    	}
    	catch (Exception e)
    	{
    		Contact_Account_Mandatory_pageLog.info("Not able to find element for plus icon");
    	}
    }
    
    /*
     * method for entering the first name of the contact
     */
    public void enteringTheFirstNameAccMan()
    {
    driver.findElement(contact_FirstNameAccMan).sendKeys("Test");	
    try
    {
    	Contact_Account_Mandatory_pageLog.info("Trying to find element and send the text");
    }
    catch (Exception e)
    {
    	Contact_Account_Mandatory_pageLog.info("Not able to find the element for entering the first name");
    }
    }
    
    /*
     * entering the last name of the contact
     */
    public void enteringTheLastNameAccMan()
    {
    driver.findElement(contact_LastNameAccMan).sendKeys("Contact 1");
    try
    {
    	Contact_Account_Mandatory_pageLog.info("Trying to locae the element for entering the second name");
    }
    catch (Exception e)
    {
    	Contact_Account_Mandatory_pageLog.info("Not able to find the element for entering the second name");
    }
    }
	
    /*
     * method for clicking the level drop down
     */
    public void contactLevelDropDownAccountMan()
    {
    	clickWhenElementIsReady(driver, 20, contact_Level_DropDownAccMan);
    	try
    	{
    		Contact_Account_Mandatory_pageLog.info("Trying to locate the element for clicking on drop down for contact level");
    	}
    	catch (Exception e)
    	{
    		Contact_Account_Mandatory_pageLog.info("Not able to find the element for level drop down");
    	}
    }
    
    /*
     * method for select contact level
     */
    public void contactLevelSelectionAccountMan()
    {
    	clickWhenElementIsReady(driver, 20, contact_Level_SelectionAccMan);
    	try
    	{
    		Contact_Account_Mandatory_pageLog.info("Trying to locate the element for selecting contact Level selection");
    	}
    	catch (Exception e)
    	{
    		Contact_Account_Mandatory_pageLog.info("Not able to locate the element for contact level selection");
    	}
    }
    
    /*
     * method for contact status drop down
     */
    public void contactStatusDropDownAccountMan()
    {
    	clickWhenElementIsReady(driver, 20, contact_Status_DropDownAccMan);
    	try
    	{
    		Contact_Account_Mandatory_pageLog.info("Trying to locate the element for contact status drop down");
    	}
    	catch (Exception e)
    	{
    		Contact_Account_Mandatory_pageLog.info("Not able to locate the element for clicking on status drop down");
    	}
    }
    
    /*
     * method for contact status selection
     */
    public void contactStatusSelectionAccountMan()
    {
    	clickWhenElementIsReady(driver, 20, contact_Status_SelectionAccMan);
    	try
    	{
    		Contact_Account_Mandatory_pageLog.info("Locating the element for contact status selection");
    	}
    	catch (Exception e)
    	{
    		Contact_Account_Mandatory_pageLog.info("Not able to locate the element for selecting the status");
    	}
    }
    
    /*
     * method for clicking on Next button
     */
    public void clickonNextButtonAccountMan()
    {
    	clickWhenElementIsReady(driver, 20, contact_NextPress1);
    	try
    	{
    	Contact_Account_Mandatory_pageLog.info("Locating the element for pressing the next button");
    	}
    	catch (Exception e)
    	{
    		Contact_Account_Mandatory_pageLog.info("Not able to locate the element for next button");
    	}
    }
    
    /*
     * method for clicking on Cancel button
     */
    public void clickonCancelButtonAccountMan()
    {
    	clickWhenElementIsReady(driver, 20, contact_CancelButtonAccMan);
    	try
    	{
    	Contact_Account_Mandatory_pageLog.info("Locating the element for pressing the Cancel button");
    	}
    	catch (Exception e)
    	{
    		Contact_Account_Mandatory_pageLog.info("Not able to locate the element for Cancel button");
    	}
    }
}