package com.mu_sigma.OrgPlatformAutomationFramework.muMoments.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//import org.openqa.selenium.support.PageFactory;

import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;

public class Contact_SavenCloseMan_Validator extends TestBase {
	
	private static final Logger Contact_SavenCloseMan_Validator_pageLog = LogManager.getLogger(Contact_SavenCloseMan_Validator.class.getName());
	WebDriver driver;
	
	//xpath for Contact tab selection
	By contact_Tab_SelectionSCM=By.xpath("//a[contains(text(),'Contacts')]");
	
	//xpath for contact plus icon  button
	By contact_PlusIconSCM=By.xpath("//span[@class='glyphicon glyphicon-plus-sign ng-scope']");		
	
	//xpath for contact first name
	By contacts_FirstNameSCM=By.xpath("//input[@placeholder='First Name']");
	
	//xpath for contact last name
	By contacts_LastNameSCM=By.xpath("//input[@placeholder='Last Name']");
	
	//xpath for contact account drop down
	By contacts_AccountDropDownSCM=By.xpath("(//a[@class='chosen-single chosen-default'])[1]");
	
	//xpath for Contact Account Selection
	By contacts_AccountSelSCM=By.xpath("//li[contains(text(),'Abbott Laboratories')][1]");
	
	//xpath for Contact Level Drop down
	By contact_LevelDropDown=By.xpath("(//a[@class='chosen-single chosen-default'])[2]");
	
	//xpath for contact level selection
	By contacts_LevelSelSCM=By.xpath("//li[contains(text(),'Staff')]");
	
	//xpath for contact status drop down
	By contact_StatusDropDownSCM=By.xpath("(//a[@class='chosen-single chosen-default'])[3]");
	
	//xpath for contact selection
	By contact_StatusSelSCM=By.xpath("//li[contains(text(),'CHAMPION')]");
	
	//xpath for sava and close button
	By contact_SaveNCloseSCM=By.xpath("//button[contains(text(),'Save & Close')]");
	
	public Contact_SavenCloseMan_Validator (WebDriver driver)
	{
		this.driver = driver;
		
	}
	/*
	 * method for clicking on Contacts tab
	 */
	public void clickOnContactsTabSCM()
    {
		clickWhenElementIsReady(driver, 20, contact_Tab_SelectionSCM);
   try
   {
	 Contact_SavenCloseMan_Validator_pageLog.info("Trying to locate the element for Contact tab click");
   }
   catch (Exception e)
   {
	   Contact_SavenCloseMan_Validator_pageLog.info("Unable to locate the element for contacts tab");
   }
    }
    
	/*
	 * method for clicking on plus icon
	 */
    public void clickOnPlusIconSCM()
    {
    	clickWhenElementIsReady(driver, 20, contact_PlusIconSCM);
    try
    {
    	Contact_SavenCloseMan_Validator_pageLog.info("Trying to locate the element for plus icon");
    }
    catch (Exception e)
    {
    	Contact_SavenCloseMan_Validator_pageLog.info("Unable to locate the element for plus icon");
    }
    }
    
    /*
     * method for clicking for first name
     */
    public void contactFirstNAmeSCM()
    {
    	driver.findElement(contacts_FirstNameSCM).sendKeys("Test");
    try
    {
    	Contact_SavenCloseMan_Validator_pageLog.info("Trying to locate the element for first name");
    }
    catch (Exception e)
    {
    	Contact_SavenCloseMan_Validator_pageLog.info("Unable to lovate the element for first name");
    }
    }
    
    /*
     * method for entering the last name
     */
    public void contactLastNameSCM()
    {
    driver.findElement(contacts_LastNameSCM).sendKeys("Contact 1");
    try
    {
    	Contact_SavenCloseMan_Validator_pageLog.info("Trying to locate the element for last name");
    }
    catch (Exception e)
    {
    	Contact_SavenCloseMan_Validator_pageLog.info("Unable to locate the element for last name");
    }
    }
	
    /*
     * method for entering contact account drop down
     */
    public void contactAccountDropDownSCM()
    {
    	clickWhenElementIsReady(driver, 20, contacts_AccountDropDownSCM);
    try
    {
    	Contact_SavenCloseMan_Validator_pageLog.info("Trying to locate the element for Account Drop down");
    }
    catch (Exception e)
    {
    	Contact_SavenCloseMan_Validator_pageLog.info("Unable to locate the element for Account drop down");
    }
    }
    
    /*
     * Method for entering Account Selection
     */
    public void contactsAccountSelectionSCM()
    {
    	clickWhenElementIsReady(driver, 20, contacts_AccountSelSCM);
    try
    {
    	Contact_SavenCloseMan_Validator_pageLog.info("Trying to locate the element for Account Selection");
    }
    catch (Exception e)
    {
    	Contact_SavenCloseMan_Validator_pageLog.info("Unable to locate the element for Account Selection");
    }
    }
    
    /*
     * method for entering contact level drop down
     */
    public void contactLevelDropDownSCM()
    {
    	clickWhenElementIsReady(driver, 20, contact_LevelDropDown);
    try
    {
    	Contact_SavenCloseMan_Validator_pageLog.info("Trying to locate the element for contact level drop down");
    }
    catch (Exception e)
    {
    	Contact_SavenCloseMan_Validator_pageLog.info("Unable to locate the element for contact level drop down");
    }
    }
    
    /*
     * Method for entering contact level selection
     */
    public void contactLevelSelectionSCM()
    {
    	clickWhenElementIsReady(driver, 20, contacts_LevelSelSCM);
    try
    {
    	Contact_SavenCloseMan_Validator_pageLog.info("Trying to locate the element for contact level selection");
    }
    catch (Exception e)
    {
    	Contact_SavenCloseMan_Validator_pageLog.info("Unable to locate the element for contact level drop down");
    }
    }
    
    /*
     * Method for entering contact status drop down
     */
    public void contactStatusDropDownSCM()
    {
    	clickWhenElementIsReady(driver, 20, contact_StatusDropDownSCM);
    try
    {
    	Contact_SavenCloseMan_Validator_pageLog.info("Trying to locate the element for Contact status drop down");
    }
    catch (Exception e)
    {
    	Contact_SavenCloseMan_Validator_pageLog.info("Unable to locate the element for contact status drop down");
    }
    }
    
    /*
     * Method for entering the contact status selection
     */
    public void contactStatusSelectionSCM()
    {
    	clickWhenElementIsReady(driver, 20, contact_StatusSelSCM);
    try
    {
    	Contact_SavenCloseMan_Validator_pageLog.info("trying to locate the element for Contact Status selection");
    }
    catch (Exception e)
    {
    	Contact_SavenCloseMan_Validator_pageLog.info("Unable to locate the element for contact status selection");
    }
    }

    /*
     * Method for clickin on Save n Close button
     */
    public void contactSavenCloseSCM()
    {
    	clickWhenElementIsReady(driver, 20, contact_SaveNCloseSCM);
    try
    {
    	Contact_SavenCloseMan_Validator_pageLog.info("Trying to locate the element for Save and Close button");
    }
    catch (Exception e)
    {
    	Contact_SavenCloseMan_Validator_pageLog.info("Unable to locate the element for Save and Close button");
    }
    }
}
