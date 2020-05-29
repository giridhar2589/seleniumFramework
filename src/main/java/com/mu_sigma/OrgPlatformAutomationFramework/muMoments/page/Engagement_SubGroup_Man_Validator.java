package com.mu_sigma.OrgPlatformAutomationFramework.muMoments.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;

public class Engagement_SubGroup_Man_Validator extends TestBase {

private static final Logger Engagement_SubGroup_Man_Validator = LogManager.getLogger(Engagement_SubGroup_Man_Validator.class.getName());
	
WebDriver driver;
	//xpath for engagement tab selection
	By eng_Tab_SelectionSubGroupMan=By.xpath("//a[contains(text(),'Engagement')]");
	
	//xpath for engagement plus icon
	By eng_PlusIconSubGroupMan=By.xpath("(//span[@class='glyphicon glyphicon-plus-sign ng-scope'])[1]");
	
	//xpath for engagement name
	By eng_EngNameSubGroupMan=By.xpath("(//input[@class='form-control ng-pristine ng-invalid ng-invalid-required'])[1]");
	
	//xpath for status drop down
	By eng_Status_DropDownSubGroupMan=By.xpath("(//a[@class='chosen-single chosen-default'])[1]");
	
	//xpath for status selection
	By eng_Status_SelectionSubGroupMan=By.xpath("//li[contains(text(),'Green')]");
	
	//xpath for engagement start date selection 1
	By eng_StartDate_Selection1SubGroupMan=By.xpath("//input[@ng-model='deal.startDate']");
	
	//xpath for engagement start date selection 2
	By eng_StartDate_Selection2SubGroupMan=By.xpath("(//button[@class='btn btn-default btn-sm'])[31]");
	
	//xpath for engagement end date selection 1
	By eng_EndDate_Selection1SubGroupMan=By.xpath("//input[@ng-model='deal.endDate']");
	
	//xpath for engagement end date selection 2
	By eng_EndDate_Selection2SubGroupMan=By.xpath("(//button[@class='btn btn-default btn-sm pull-right'])[2]");
	
	//xpath for engagement end date selection 3
	By eng_EndDate_Selection3SubGroupMan=By.xpath("(//button[@class='btn btn-default btn-sm pull-right'])[2]");
	
	//xpath for end date selection 4
	By eng_EndDate_Selection4SubGroupMan=By.xpath("(//button[@class='btn btn-default btn-sm pull-right'])[2]");

	//xpath for end date selection 5
	By eng_EndDate_Selection5SubGroupMan=By.xpath("(//button[@class='btn btn-default btn-sm'])[61]");
	
	//xpath for eng billing drop down
	By eng_Billing_DropDownSubGroupMan=By.xpath("(//a[@class='chosen-single chosen-default'])[3]");
	
	//xpath for engagement billing selection
	By eng_Billing_SelectionSubGroupMan=By.xpath("//li[contains(text(),'Fixed Cost')]");
		
	//xpath for eng save and close button
	By eng_SaveNCloseSubGroupMan=By.xpath("//button[contains(text(),'Save & Close')]");
	
	By engagementNextBtnSubGroupMandatory=By.xpath("//button[contains(text(),'Next')]");
	
	By engagementCancelSubGroupMandatory=By.xpath("//button[@class='btn df-btn-text ng-scope']");
	
	public Engagement_SubGroup_Man_Validator(WebDriver driver){
		this.driver=driver;
	
	}
	
	
	/*
	 * method for engagement tab click
	 */
	public void clickOnEngagementsTabSUbGroupMandatory()
    {
		clickWhenElementIsReady(driver, 20, eng_Tab_SelectionSubGroupMan);
	try
	{
		Engagement_SubGroup_Man_Validator.info("Trying to locate the element for engagement tab");
	}
	catch (Exception e)
	{
		Engagement_SubGroup_Man_Validator.info("unable to locate the element for engagement tab");
	}
	}

	/*
	 * Method for engagement create button
	 */
    public void clickOnEngPlusIconSubGroupMandatory()
    {
    	clickWhenElementIsReady(driver, 20, eng_PlusIconSubGroupMan);
    	try
    	{
    		Engagement_SubGroup_Man_Validator.info("Trying to locate the element for engagement create button");
    	}
    	catch (Exception e)
    	{
    		Engagement_SubGroup_Man_Validator.info("unable to locate the element for engagement create button");
    	}
    }

    /*
     * Method for the engagement name entering
     */
    public void enterTheEngagementNameSubGroupMandatory()
    {
    driver.findElement(eng_EngNameSubGroupMan).sendKeys("Test Engagement with new framework");
    try
	{
    	Engagement_SubGroup_Man_Validator.info("Trying to locate the element for engagement name entering");
	}
	catch (Exception e)
	{
		Engagement_SubGroup_Man_Validator.info("unable to locate the element for engagement name entering");
	}
    }
    
    /*
     * Method for engagement status drop down
     */
    public void clickOnEngagementStatusDropDownSubGroupMandatory()
    {
    	clickWhenElementIsReady(driver, 20, eng_Status_DropDownSubGroupMan);
    	try
    	{
    		Engagement_SubGroup_Man_Validator.info("Trying to locate the element for engagement status drop down");
    	}
    	catch (Exception e)
    	{
    		Engagement_SubGroup_Man_Validator.info("unable to locate the element for engagement status drop down");
    	}
    }
    
    /*
     * method for engagement status selection
     */
    public void selectingEngagementStatusSubGroupMandatory()
    {
    	clickWhenElementIsReady(driver, 20, eng_Status_SelectionSubGroupMan);
    	try
    	{
    		Engagement_SubGroup_Man_Validator.info("Trying to locate the element for engagement status selection");
    	}
    	catch (Exception e)
    	{
    		Engagement_SubGroup_Man_Validator.info("unable to locate the element for engagement status selection");
    	}
    }
    
    /*
     * Method for engagement start date selection 1
     */
    public void engStartDateSelctionSubGroupMandatory1()
    {
    	clickWhenElementIsReady(driver, 20, eng_StartDate_Selection1SubGroupMan);
    	try
    	{
    		Engagement_SubGroup_Man_Validator.info("Trying to locate the element for engagement start date selection 1");
    	}
    	catch (Exception e)
    	{
    		Engagement_SubGroup_Man_Validator.info("unable to locate the element for engagement start date selection 1");
    	}
    }
    
    /*
     * method for engagement start date selection 2
     */
    public void engStartDateSelctionSubGroupMandatory2()
    {
    	clickWhenElementIsReady(driver, 20, eng_StartDate_Selection2SubGroupMan);
    	try
    	{
    		Engagement_SubGroup_Man_Validator.info("Trying to locate the element for engagement start date selection 2");
    	}
    	catch (Exception e)
    	{
    		Engagement_SubGroup_Man_Validator.info("unable to locate the element for engagement start date selection 2");
    	}
    }
    
    /*
     * Method for engagement date selection 1
     */
    public void engEndDateSelectionSubGroupMandatory1()
    {
    	clickWhenElementIsReady(driver, 20, eng_EndDate_Selection1SubGroupMan);
    	try
    	{
    		Engagement_SubGroup_Man_Validator.info("Trying to locate the element for engagement eng date selection 1");
    	}
    	catch (Exception e)
    	{
    		Engagement_SubGroup_Man_Validator.info("unable to locate the element for engagement end date selection 1");
    	}
    }
    
    /*
     * Method for eng end date selection 2
     */
    public void engEndDateSelectionSubGroupMandatory2()
    {
    	clickWhenElementIsReady(driver, 20, eng_EndDate_Selection2SubGroupMan);
    	try
    	{
    		Engagement_SubGroup_Man_Validator.info("Trying to locate the element for engagement eng date selection 2");
    	}
    	catch (Exception e)
    	{
    		Engagement_SubGroup_Man_Validator.info("unable to locate the element for engagement end date selection 2");
    	}	
    }
    
    /*
     * Method for engagement end date selection 3
     */
    public void engEndDateSelectionSubGroupMandatory3()
    {
    	clickWhenElementIsReady(driver, 20, eng_EndDate_Selection3SubGroupMan);
    	try
    	{
    		Engagement_SubGroup_Man_Validator.info("Trying to locate the element for engagement end date selection 3");
    	}
    	catch (Exception e)
    	{
    		Engagement_SubGroup_Man_Validator.info("unable to locate the element for engagement end date selection 3");
    	}	
    }
    
    /*
     * Method for engagement end date selection 4
     */
    public void engEndDateSelectionSubGroupMandatory4()
    {
    	clickWhenElementIsReady(driver, 20, eng_EndDate_Selection4SubGroupMan);
    	try
    	{
    		Engagement_SubGroup_Man_Validator.info("Trying to locate the element for engagement end date selection 4");
    	}
    	catch (Exception e)
    	{
    		Engagement_SubGroup_Man_Validator.info("unable to locate the element for engagement end date selection 4");
    	}	
    }
    
    /*
     * Method for end date selection 5
     */
    public void engEndDateSelectionSubGroupMandatory5()
    {
    	clickWhenElementIsReady(driver, 20, eng_EndDate_Selection5SubGroupMan);
    	try
    	{
    		Engagement_SubGroup_Man_Validator.info("Trying to locate the element for engagement end date selection 5");
    	}
    	catch (Exception e)
    	{
    		Engagement_SubGroup_Man_Validator.info("unable to locate the element for engagement end date selection 5");
    	}
    }
    
    
    /*
     * Method for engagement billing type drop down
     */
    public void engBillingTypeDropDownSubGroupMandatory()
    {
    	clickWhenElementIsReady(driver, 20, eng_Billing_DropDownSubGroupMan);
    	try
    	{
    		Engagement_SubGroup_Man_Validator.info("Trying to locate the element for engagement billing type drop down");
    	}
    	catch (Exception e)
    	{
    		Engagement_SubGroup_Man_Validator.info("unable to locate the element for engagement billing type drop down");
    	}
    }
    
    /*
     * Method for engagement billing type selection
     */
    public void engBillingTypeSelectionSubGroupMandatory()
    {
    	clickWhenElementIsReady(driver, 20, eng_Billing_SelectionSubGroupMan);
    	try
    	{
    		Engagement_SubGroup_Man_Validator.info("Trying to locate the element for engagement billing type selection");
    	}
    	catch (Exception e)
    	{
    		Engagement_SubGroup_Man_Validator.info("unable to locate the element for engagement billing type selection");
    	}
    }
    
    /*
     * Method for engagement save and close
     */
    public void engnxtbuttonclickSubGroupMandatory()
    {
    	clickWhenElementIsReady(driver, 20, engagementNextBtnSubGroupMandatory);
    	try
    	{
    		Engagement_SubGroup_Man_Validator.info("Trying to locate the element for engagement next button");
    	}
    	catch (Exception e)
    	{
    		Engagement_SubGroup_Man_Validator.info("unable to locate the element for engagement next button");
    	}
    }
    
    public void engCancelSubgroupMan()
    {
    	clickWhenElementIsReady(driver, 20,engagementCancelSubGroupMandatory);
    	try
    	{
    		Engagement_SubGroup_Man_Validator.info("Trying to locate the element for engagement Cancel button");
    	}
    	catch (Exception e)
    	{
    		Engagement_SubGroup_Man_Validator.info("unable to locate the element for engagement Cancel Button");
    	}
    }
}

	


