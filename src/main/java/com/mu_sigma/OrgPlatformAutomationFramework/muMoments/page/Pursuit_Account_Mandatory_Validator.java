package com.mu_sigma.OrgPlatformAutomationFramework.muMoments.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;

public class Pursuit_Account_Mandatory_Validator extends TestBase  {
	
	WebDriver driver;
	private static final Logger Pursuit_Account_Mandatory_Validator_pageLog = LogManager.getLogger(Pursuit_Account_Mandatory_Validator.class.getName());
	
	//xpath for pursuit tab selection
	By pursuitTab_Selection_AccMan=By.xpath("//a[contains(text(),'Pursuits')]");	
	
	//xpath for pursuit add button
	By pursuit_addbtn_AccMan=By.xpath("//span[@class='glyphicon glyphicon-plus-sign ng-scope']");
	
	//xpath for pursuit name
	By pursuitName_enter=By.xpath("//input[@class ='form-control ng-pristine ng-invalid ng-invalid-required']");
	
	//xpath for pursuit status drop down
	By pursuit_status_drpdwn_AccMan=By.xpath("(//a[@class='chosen-single chosen-default'])[3]");
	
	//xpath for pursuit status selection
	By pursuit_status_selection_AccMan=By.xpath("//li[contains(text(),'Target')]");
	
	//xpath for pursuit type drop down
	By pursuit_type_drpdown_AccMan=By.xpath("(//a[@class='chosen-single chosen-default'])[4]");
	
	//xpath for pursuit type selection
	By pursuit_type_selection_AccMan=By.xpath("//li[contains(text(),'Mining | Initial Attempt')]");
	
	//xpath for next press button
	By nextpress1_AccMan=By.xpath("//button[@class='btn df-btn-primary ng-scope']");
	
	//xpath for cancel button
	By cancelButtonAccountMan=By.xpath("//button[@class='btn df-btn-text ng-scope']");
	
	public Pursuit_Account_Mandatory_Validator(WebDriver driver) {
		this.driver=driver;
		
	}
	
	/**
	 * click on pursuit tab
	 */
	public void clickOnPursuitEntityAccMan()
	{
		clickWhenElementIsReady(driver,20, pursuitTab_Selection_AccMan);
	try
	{
		Pursuit_Account_Mandatory_Validator_pageLog.info("Trying to locate the element for pursuit tab");
	}
	catch (Exception e)
	{
		Pursuit_Account_Mandatory_Validator_pageLog.info("Unable to locate the element for pursuit tab");
	}
	}
	
	/**
	 * click on Add Button
	 */
	
	public void clickOnAddButtonIconAccMan()
	{
		clickWhenElementIsReady(driver, 10, pursuit_addbtn_AccMan);
		try
		{
			Pursuit_Account_Mandatory_Validator_pageLog.info("Trying to locate the element for click on plus icon");
		}
		catch (Exception e)
		{
			Pursuit_Account_Mandatory_Validator_pageLog.info("Unable to locate the element for clicking on plus icon");
		}
	}
	
	/**
	 * enter the pursuit name
	 */
	public void enterPursuitNameAccMan()
	{
		driver.findElement(pursuitName_enter).sendKeys("Test Pursuit Account Mand check");
		try
		{
			Pursuit_Account_Mandatory_Validator_pageLog.info("Trying to locate the element for entering the pursuit name");
		}
		catch (Exception e)
		{
			Pursuit_Account_Mandatory_Validator_pageLog.info("Unable to locate the element for entering the pursuit name");
		}
	}
	
	/**
	 * click on status drop down
	 */
	
	public void clickOnStatusdrpdownAccMan()
	{
		clickWhenElementIsReady(driver, 20, pursuit_status_drpdwn_AccMan);
		try
		{
			Pursuit_Account_Mandatory_Validator_pageLog.info("Trying to locate the element for pursuit status drop down ");
		}
		catch (Exception e)
		{
			Pursuit_Account_Mandatory_Validator_pageLog.info("Unable to locate the element for pursuit status drop down");
		}
	}
	
	
	/**
	 * Select the pursuit status
	 */
	public void prsuitStatusSelAccMan()
	{
		clickWhenElementIsReady(driver, 20, pursuit_status_selection_AccMan);
		try
		{
			Pursuit_Account_Mandatory_Validator_pageLog.info("Trying to locate the element for pursuit status selection");
		}
		catch (Exception e)
		{
			Pursuit_Account_Mandatory_Validator_pageLog.info("Unable to locate the element for pursuit status selection");
		}
	}
	
	/**
	 * click on pursuit type drop down
	 */
	public void clickOnPursuitTypedrpdownAccMan()
	{
		clickWhenElementIsReady(driver, 20, pursuit_type_drpdown_AccMan);
		try
		{
			Pursuit_Account_Mandatory_Validator_pageLog.info("Trying to locate the element for pursuit type drop down");
		}
		catch (Exception e)
		{
			Pursuit_Account_Mandatory_Validator_pageLog.info("Unable to locate the element for pursuit type drop down");
		}
	}
	
	/**
	 * Select the pursuit type
	 */
	public void pursuitTypeSelAccMan()
	{
		clickWhenElementIsReady(driver, 20, pursuit_type_selection_AccMan);
		try
		{
			Pursuit_Account_Mandatory_Validator_pageLog.info("Trying to locate the element for pursuit type selection");
		}
		catch (Exception e)
		{
			Pursuit_Account_Mandatory_Validator_pageLog.info("Unable to locate the element for pursuit type selection");
		}
	}
	
	/**
	 * click on Next button
	 */
	
	public void nextButtonPress1AccMan()
	{
		clickWhenElementIsReady(driver, 20, nextpress1_AccMan);
		try
		{
			Pursuit_Account_Mandatory_Validator_pageLog.info("Trying to locate the element for next button");
		}
		catch (Exception e)
		{
			Pursuit_Account_Mandatory_Validator_pageLog.info("Unable to locate the element for next button");
		}
	}
	
	public void cancelButtonPressAccMan()
	{
		clickWhenElementIsReady(driver, 20, cancelButtonAccountMan);
		try
		{
			Pursuit_Account_Mandatory_Validator_pageLog.info("Trying to locate the element for cancel button");
		}
		catch (Exception e)
		{
			Pursuit_Account_Mandatory_Validator_pageLog.info("Unable to locate the element for cancel button");
		}
	}
}


