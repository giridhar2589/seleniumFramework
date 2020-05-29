package com.mu_sigma.OrgPlatformAutomationFramework.muMoments.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.PageFactory;

import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;

public class Pursuit_Status_Man extends TestBase{
	
	WebDriver driver;
	private static final Logger Pursuit_Status_Man_pageLog = LogManager.getLogger(Pursuit_Status_Man.class.getName());

	//xpath for pursuit tab selection
    By pursuit_TabSelection_StatMan=By.xpath("//a[contains(text(),'Pursuits')]");	
	
	//xpath for plus icon click
	By pursuit_AddButton_StatMan=By.xpath("//span[@class='glyphicon glyphicon-plus-sign ng-scope']");
	
	//xpath for pursuit name entering
	By pursuitName_enter_StatMan=By.xpath("//input[@class ='form-control ng-pristine ng-invalid ng-invalid-required']");
	
	//xpath for pursuit account drop down
	By pursuit_Accountdropdown_StatMan=By.xpath("//span[contains(text(),'Account/Sub Group')]");
	
	//xpath for Account selection
	By pursuit_AccountSelection_StatMan=By.xpath("//li[contains(text(),'Abbott Laboratories | Abbott - Corporate Development')]");
	
	//xpath for pursuit type dropdown 
	By pursuit_Type_Dropdown_StatMan=By.xpath("(//a[@class='chosen-single chosen-default'])[4]");
	
	//xpath for pursuit type selection
	By pursuit_Type_Selection_StatMan=By.xpath("//li[contains(text(),'Mining | Initial Attempt')]");
	
	//xpath for pursuit next button
	By next_press1_StatMan=By.xpath("//button[@class='btn df-btn-primary ng-scope']");
	
	By cancelButtonStatusMan=By.xpath("//button[@class='btn df-btn-text ng-scope']");
	
	public Pursuit_Status_Man(WebDriver driver) {
		this.driver=driver;
		
	}
	/*
	 * click on Pursuit tab
	 */
	public void pursuitTabSelectionStatMan()
	{
		clickWhenElementIsReady(driver, 20, pursuit_TabSelection_StatMan);
    try
    {
    	Pursuit_Status_Man_pageLog.info("Trying to locate the element for pursuit tab selection");
    }
    catch (Exception e)
    {
    	Pursuit_Status_Man_pageLog.info("Unable to locate the element for pursuit tab selection");
    }
	}
	
	/*
	 * click on add button
	 */
	public void clickOnAddButtonStatMan()
	{
		clickWhenElementIsReady(driver, 20, pursuit_AddButton_StatMan);
    try
    {
    	Pursuit_Status_Man_pageLog.info("Trying to locate the element for pursuit plus icon");
    }
    catch (Exception e)
    {
    	Pursuit_Status_Man_pageLog.info("Unable to locate the element for pursuit plus icon");
    }
	}
	
	/*
	 * click on account dropdown
	 */
	
	public void clickOnAccountDropDownStatMan()
	{
		clickWhenElementIsReady(driver, 20, pursuit_Accountdropdown_StatMan);
	 try
	 {
		 Pursuit_Status_Man_pageLog.info("Trying to locate the element for account drop down");
	 }
	 catch (Exception e)
	 {
		 Pursuit_Status_Man_pageLog.info("Unable to locate the element for account drop down");
	 }
	}
	
	/*
	 * method for entering pursuit name
	 */
	public void enterPursuitNameStatMan()
	{
		driver.findElement(pursuitName_enter_StatMan).sendKeys("Test Pursuit Status Mand check");
	try
	{
		Pursuit_Status_Man_pageLog.info("Trying to locate the element for pursuit name entering");
	}
	catch (Exception e)
	{
		Pursuit_Status_Man_pageLog.info("Unable to locate the element for pursuit name entering");
	}
	}
	
	/*
	 * Select the Account
	 */
	public void selectAccountStatMan()
	{
		clickWhenElementIsReady(driver, 20, pursuit_AccountSelection_StatMan);
	try
	{
		Pursuit_Status_Man_pageLog.info("Trying to locate the element for Selecting Accoun ");
	}
	catch (Exception e)
	{
		Pursuit_Status_Man_pageLog.info("Unable to locate the element for Selecting account");
	}
	}
	
	/*
	 * click on purstuit type drop Down
	 */
	public void pursuitTypeDropDownStatMan()
	{
		clickWhenElementIsReady(driver, 20, pursuit_Type_Dropdown_StatMan);
    try
    {
    	Pursuit_Status_Man_pageLog.info("Trying to locate the element for pursuit type drop down");
    }
    catch (Exception e)
    {
    	Pursuit_Status_Man_pageLog.info("Unable to locate the element for Pursuit type drop down");
    }
	}
	
	/*
	 * Select the type
	 */
	
	public void pursuitTypeSelectionStatMan()
	{
		clickWhenElementIsReady(driver, 20, pursuit_Type_Selection_StatMan);
    try
    {
    	Pursuit_Status_Man_pageLog.info("Trying to locate the element pursuit type selection");
    }
    catch (Exception e)
    {
    	Pursuit_Status_Man_pageLog.info("Unable to locate the element for pursuit type selection");
    }
	}
	
	/*
	 * Click on next button
	 */
	public void next_btn1StatMan()
	{
		clickWhenElementIsReady(driver, 20, next_press1_StatMan);
	try
	{
		Pursuit_Status_Man_pageLog.info("Trying to locate the element for pursuit next button");
	}
	catch (Exception e)
	{
		Pursuit_Status_Man_pageLog.info("Unable to locate the element for pursuit next button");
	}
	}
	
	/*
	 * Click on cancel button
	 */
	public void cancelButton1StatMan()
	{
		clickWhenElementIsReady(driver, 20, cancelButtonStatusMan);
	try
	{
		Pursuit_Status_Man_pageLog.info("Trying to locate the element for pursuit cancel button");
	}
	catch (Exception e)
	{
		Pursuit_Status_Man_pageLog.info("Unable to locate the element for pursuit cancel button");
	}
	}
}
	

