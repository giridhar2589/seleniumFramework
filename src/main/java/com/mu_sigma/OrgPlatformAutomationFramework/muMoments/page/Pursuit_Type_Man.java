package com.mu_sigma.OrgPlatformAutomationFramework.muMoments.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;

import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;

public class Pursuit_Type_Man extends TestBase {
	
	WebDriver driver;
	private static final Logger Pursuit_Type_Man_pageLog = LogManager.getLogger(Pursuit_Type_Man.class.getName());

	//xpath for Pursuit tab selection
	By pursuit_TabSelection_TypeMan=By.xpath("//a[contains(text(),'Pursuits')]");	
	
	//xpath for pursuits plus button icon
	By pursuit_Type_AddBtn_TypeMan=By.xpath("//span[@class='glyphicon glyphicon-plus-sign ng-scope']");
	
	//xpath for Account Drop down
	By pursuit_Account_drpdown_TypeMan=By.xpath("//span[contains(text(),'Account/Sub Group')]");
	
	//xpath for Account Selection for pursuit
	By pursuit_AccountSelection_TypeMan=By.xpath("//li[contains(text(),'Abbott Laboratories | Abbott - Corporate Development')]");
	
	//xpath for pursuit name entering 
	By pursuit_Name_Enter_TypeMan=By.xpath("//input[@class ='form-control ng-pristine ng-invalid ng-invalid-required']");
	
	//xpath for pursuit name type
	By pursuit_Name_TypeMan=By.xpath("//input[@class ='form-control ng-pristine ng-invalid ng-invalid-required']");
	
	//xpath for pursuit status drop down
	By pursuit_StatusDropDown_TypeMan=By.xpath("(//a[@class='chosen-single chosen-default'])[3]");
	
	//xpath for pursuit status selection 
	By pursuit_Status_Selection_TypeMan=By.xpath("//li[contains(text(),'Target')]");
	
	//xpath for pursuit next button press
	By nextPress1_TypeMan=By.xpath("//button[@class='btn df-btn-primary ng-scope']");
	
	By cancelButtonTypeMan=By.xpath("//button[@class='btn df-btn-text ng-scope']");
	
	public Pursuit_Type_Man(WebDriver driver) {
		this.driver=driver;
		
	}
	
	
	/**
	 * click on pursuit tab
	 */
	public void clickOnPursuitTabTypeMan()
	{
		clickWhenElementIsReady(driver, 20, pursuit_TabSelection_TypeMan);
	try
	{
		Pursuit_Type_Man_pageLog.info("Trying to locate the element for pursuit tab");
	}
	catch (Exception e)
	{
		Pursuit_Type_Man_pageLog.info("Unable to locate the element for Pursuit tab");
	}
	}
	
	/**
	 * click on Add button
	 */
	public void pursuitAddbuttonTypeMan()
	{
		clickWhenElementIsReady(driver, 20, pursuit_Type_AddBtn_TypeMan);
	try
	{
		Pursuit_Type_Man_pageLog.info("Trying to locate the element for pursuit plus icon");
	}
	catch (Exception e)
	{
		Pursuit_Type_Man_pageLog.info("Unable to locate the element for pursuit plus icon");
	}
	}
	
	/**
	 * Click on Account dropdown
	 */
	
	public void pursuitAccountDropDownTypeMan()
	{
		clickWhenElementIsReady(driver, 20, pursuit_Account_drpdown_TypeMan);
	try
	{
		Pursuit_Type_Man_pageLog.info("Trying to locate the element for Account Drop down");
	}
	catch (Exception e)
	{
		Pursuit_Type_Man_pageLog.info("Unable to locate the element for Account Drop down");
	}
	}
	
	/**
	 * Select the Account
	 */
	public void pursuitAccoutnSelectionTypeMan()
	{
		clickWhenElementIsReady(driver, 20, pursuit_AccountSelection_TypeMan);
    try
    {
    	Pursuit_Type_Man_pageLog.info("trying to locate the element for Account Selection");
    }
    catch (Exception e)
    {
    	Pursuit_Type_Man_pageLog.info("Unable to locate the element for Account Selection");
    }
	}
	
	
	public void enterPursuitNameAccMan()
	{
		driver.findElement(pursuit_Name_Enter_TypeMan).sendKeys("Test Pursuit Account Mand check");
		
	try
	{
		Pursuit_Type_Man_pageLog.info("Trying to locate the element for entering the Pursuit name");
	}
	catch (Exception e)
	{
		Pursuit_Type_Man_pageLog.info("Unable to locate the element for entering the pursuit name");
	}
	}
	
	/**
	 * click on Status Drop Down
	 */
	public void pursuitStatusDropDownTypeMan()
	{
		clickWhenElementIsReady(driver, 20, pursuit_StatusDropDown_TypeMan);
    try
    {
    	Pursuit_Type_Man_pageLog.info("Trying to locate the element for status drop down");
    }
    catch (Exception e)
    {
    	Pursuit_Type_Man_pageLog.info("Unable to locate the element for Status drop down");
    }
	}
	
	/**
	 * Select the status
	 */
	public void pursuitStatusSelectionTypeMan()
	{
		clickWhenElementIsReady(driver, 20, pursuit_Status_Selection_TypeMan);
    try
    {
    	Pursuit_Type_Man_pageLog.info("Trying to locate the element for Status selection");
    }
    catch (Exception e)
    {
    	Pursuit_Type_Man_pageLog.info("Unable to locate the element for Status selection");
    }
	}
	
	/**
	 * Click on Next button
	 */
	public void nextbuttonTypeMan()
	{
		driver.findElement(nextPress1_TypeMan).click();
	try
	{
		Pursuit_Type_Man_pageLog.info("Trying to locate the element for next button click");
	}
	catch (Exception e)
	{
		Pursuit_Type_Man_pageLog.info("Unable to locate the element for next button click");
	}
	}
	
	/*
	 * Click on cancel button
	 */
	public void cancelButtonTypeMan()
	{
		clickWhenElementIsReady(driver, 20, cancelButtonTypeMan);
	try
	{
		Pursuit_Type_Man_pageLog.info("Trying to locate the element for pursuit cancel button");
	}
	catch (Exception e)
	{
		Pursuit_Type_Man_pageLog.info("Unable to locate the element for pursuit cancel button");
	}
	}
	
}
	
