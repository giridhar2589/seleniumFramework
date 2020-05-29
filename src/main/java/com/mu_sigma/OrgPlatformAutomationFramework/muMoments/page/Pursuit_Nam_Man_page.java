package com.mu_sigma.OrgPlatformAutomationFramework.muMoments.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.PageFactory;

import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;

public class Pursuit_Nam_Man_page extends TestBase {
	
	WebDriver driver;
	
	private static final Logger Pursuit_Nam_Man_page_pageLog = LogManager.getLogger(Pursuit_Nam_Man_page.class.getName());
	
	//xpath for pursuit tab selection
	By pursuitTab_selection_NamMan=By.xpath("//a[contains(text(),'Pursuits')]");	
	
	//xpath for pursuit add button
	By pursuit_addbutton_NamMan=By.xpath("//span[@class='glyphicon glyphicon-plus-sign ng-scope']");
	
	//xpath for account 
	By accountDrpDown_NamMan=By.xpath("//span[contains(text(),'Account/Sub Group')]");
	
	By account_selection_NamMan=By.xpath("//li[contains(text(),'Abbott Laboratories | Abbott - Corporate Development')]");
	
	By pursuitStatus_drpdown_NamMan=By.xpath("(//a[@class='chosen-single chosen-default'])[3]");
	
	By pursuit_status_Selection_NamMan=By.xpath("//li[contains(text(),'Target')]");
	
	By pursuit_type_drpdown_NamMan=By.xpath("(//a[@class='chosen-single chosen-default'])[4]");
	
	By pursuit_type_Selection_NamMan=By.xpath("//li[contains(text(),'Mining | Initial Attempt')]");
	
	By nextPress1_NamMan=By.xpath("//button[@class='btn df-btn-primary ng-scope']");
	
	By cancelButton=By.xpath("//button[@class='btn df-btn-text ng-scope']");
	
	public Pursuit_Nam_Man_page(WebDriver driver) {
		this.driver=driver;
		
	}
	/**
	 * click on pursuit tab
	 */
	public void pursuitTabSelectionNamMan()
	{
		clickWhenElementIsReady(driver, 20, pursuitTab_selection_NamMan);
	try
	{
		Pursuit_Nam_Man_page_pageLog.info("Trying to locate the element for Pursuit Tan selection");
	}
	catch (Exception e)
	{
		Pursuit_Nam_Man_page_pageLog.info("Unable to locate the element for Pursuit tab selection");
	}
	}
	
	/**
	 * click on add button
	 */
	
	public void clickOnAddButtonNamMan()
	{
		clickWhenElementIsReady(driver,20, pursuit_addbutton_NamMan);
	try
	{
		Pursuit_Nam_Man_page_pageLog.info("Trying to locate the element for plus icon button");
	}
	catch (Exception e)
	{
		Pursuit_Nam_Man_page_pageLog.info("Unable to locate the element for plus icon button");
	}
	}
	
	/**
	 * click on Account drop down
	 */
	
	public void pursuitAccountDrpDownNamMan()
	{
		clickWhenElementIsReady(driver, 20, accountDrpDown_NamMan);
	try
	{
		Pursuit_Nam_Man_page_pageLog.info("Trying to locate the element for pursuit account drop down");
	}
	catch (Exception e)
	{
		Pursuit_Nam_Man_page_pageLog.info("Unable to locate the element for pursuit account drop down");
	}
	}
	
	/**
	 * Select the Account
	 */
	
	public void pursuitAccountSelectionNamMan()
	{
		clickWhenElementIsReady(driver, 20, account_selection_NamMan);
    try
    {
    	Pursuit_Nam_Man_page_pageLog.info("Trying to locate the element for pursuit account selection");
    }
    catch (Exception e)
    {
    	Pursuit_Nam_Man_page_pageLog.info("Unable to locate the element for pursuit account selection");
    }
	}
	
	/**
	 * click on Status Drop down
	 */
	public void pursuitStatusDropDownNamMan()
	{
		clickWhenElementIsReady(driver, 20, pursuitStatus_drpdown_NamMan);
    try
    {
    	Pursuit_Nam_Man_page_pageLog.info("Trying to locate the element for pursuit status drop down");
    }
    catch (Exception e)
    {
    	Pursuit_Nam_Man_page_pageLog.info("Unable to locate the element for pursuit status drop down");
    }
	}
	
	/**
	 * Select the status
	 */
	
	public void pursuitStatusSelectionNamMan()
	{
		clickWhenElementIsReady(driver, 20, pursuit_status_Selection_NamMan);
    try
    {
    	Pursuit_Nam_Man_page_pageLog.info("Trying to locate the element for pursuit status selection");
    }
    catch (Exception e)
    {
    	Pursuit_Nam_Man_page_pageLog.info("Unable to locate the element for pursuit status selection");
    }
	}
	
	
	/**
	 * lcick on type drop down
	 */
	public void pursuitTypeDropDownNamMan()
	{
		clickWhenElementIsReady(driver, 20, pursuit_type_drpdown_NamMan);
	try
	{
		Pursuit_Nam_Man_page_pageLog.info("Trying to locate the element for pursuit type drop down");
	}
	catch (Exception e)
	{
		Pursuit_Nam_Man_page_pageLog.info("Unable to locate the element for pursuit type drop down");
	}
	}
	
	/**
	 * select type
	 */
	public void pursuitTypeSelectionNamMan()
	{
		clickWhenElementIsReady(driver, 20, pursuit_type_Selection_NamMan);
    try
    {
    	Pursuit_Nam_Man_page_pageLog.info("Trying to locate the element for pursuit type selection");
    }
    catch (Exception e)
    {
    	Pursuit_Nam_Man_page_pageLog.info("Unable to locate the element for pursuit type selection");
    }
	}
	
	/**
	 * click on Next Button
	 */
	
	public void nextbuttonPressNamMan()
	{
		clickWhenElementIsReady(driver, 20, nextPress1_NamMan);
    try
    {
    	Pursuit_Nam_Man_page_pageLog.info("Trying to locate element for pursuit next button");
    }
    catch (Exception e)
    {
    	Pursuit_Nam_Man_page_pageLog.info("Unable to locate the element for pursuit next button");
    }
	}
	
	/**
	 * click on Cancel Button
	 */
	
	public void cancelButtonPressNamMan()
	{
		clickWhenElementIsReady(driver, 20, cancelButton);
    try
    {
    	Pursuit_Nam_Man_page_pageLog.info("Trying to locate element for pursuit Cancel button");
    }
    catch (Exception e)
    {
    	Pursuit_Nam_Man_page_pageLog.info("Unable to locate the element for pursuit Cancel button");
    }
	}
	
}

