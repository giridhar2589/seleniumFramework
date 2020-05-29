package com.mu_sigma.OrgPlatformAutomationFramework.muMoments.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;
public class Engagement_SavenCloseMan_Validator extends TestBase {

	private static final Logger Engagement_SavenCloseMan_Validator_pageLog = LogManager.getLogger(Engagement_SavenCloseMan_Validator.class.getName());
	
	WebDriver driver;
	
	//xpath for engagement tab selection
	By eng_Tab_SelectionSCM=By.xpath("//a[contains(text(),'Engagement')]");
	
	//xpath for engagement plus icon
	By eng_PlusIconSCM=By.xpath("(//span[@class='glyphicon glyphicon-plus-sign ng-scope'])[1]");
	
	//xpath for engagement name
	By eng_EngNameSCM=By.xpath("(//input[@class='form-control ng-pristine ng-invalid ng-invalid-required'])[1]");
	
	//xpath for status drop down
	By eng_Status_DropDownSCM=By.xpath("(//a[@class='chosen-single chosen-default'])[1]");
	
	//xpath for status selection
	By eng_Status_SelectionSCM=By.xpath("//li[contains(text(),'Green')]");
	
	//xpath for engagement start date selection 1
	By eng_StartDate_SelectionSCM1=By.xpath("//input[@ng-model='deal.startDate']");
	
	//xpath for engagement start date selection 2
	By eng_StartDate_SelectionSCM2=By.xpath("(//button[@class='btn btn-default btn-sm'])[31]");
	
	//xpath for engagement end date selection 1
	By eng_EndDate_SelectionSCM1=By.xpath("//input[@ng-model='deal.endDate']");
	
	//xpath for engagement end date selection 2
	By eng_EndDate_SelectionSCM2=By.xpath("(//button[@class='btn btn-default btn-sm pull-right'])[2]");
	
	//xpath for engagement end date selection 3
	By eng_EndDate_SelectionSCM3=By.xpath("(//button[@class='btn btn-default btn-sm pull-right'])[2]");
	
	//xpath for end date selection 4
	By eng_EndDate_SelectionSCM4=By.xpath("(//button[@class='btn btn-default btn-sm pull-right'])[2]");

	//xpath for end date selection 5
	By eng_EndDate_SelectionSCM5=By.xpath("(//button[@class='btn btn-default btn-sm'])[61]");
	
	//xpath for sub group drop down
	By eng_SubGroup_DropDownSCM=By.xpath("(//a[@class='chosen-single chosen-default'])[2]");
	
	//xpath for subgroup selection
	By eng_SubGroup__SelectionSCM=By.xpath("//li[contains(text(),'Abbott Laboratories | Abbott - Corporate Development')]");
	
	//xpath for eng billing drop down
	By eng_Billing_DropDownSCM=By.xpath("(//a[@class='chosen-single chosen-default'])[3]");
	
	//xpath for engagement billing selection
	By eng_Billing_SelectionSCM=By.xpath("//li[contains(text(),'Fixed Cost')]");
		
	//xpath for eng save and close button
	By eng_SaveNCloseSCM=By.xpath("//button[contains(text(),'Save & Close')]");
	
	//xpath for Cancel button
	By engagementCancelButtonSaveNCloseMan=By.xpath("//button[@class='btn df-btn-text ng-scope']");
	
	public Engagement_SavenCloseMan_Validator(WebDriver driver){
		this.driver=driver;
	
	}
	
	
	/*
	 * method for engagement tab click
	 */
	public void clickOnEngagementsTabSCM()
    {
		clickWhenElementIsReady(driver, 20, eng_Tab_SelectionSCM);
	try
	{
		Engagement_SavenCloseMan_Validator_pageLog.info("Trying to locate the element for engagement tab");
	}
	catch (Exception e)
	{
		Engagement_SavenCloseMan_Validator_pageLog.info("unable to locate the element for engagement tab");
	}
	}

	/*
	 * Method for engagement create button
	 */
    public void clickOnEngPlusIconSCM()
    {
    	clickWhenElementIsReady(driver, 20, eng_PlusIconSCM);
    	try
    	{
    		Engagement_SavenCloseMan_Validator_pageLog.info("Trying to locate the element for engagement create button");
    	}
    	catch (Exception e)
    	{
    		Engagement_SavenCloseMan_Validator_pageLog.info("unable to locate the element for engagement create button");
    	}
    }

    /*
     * Method for the engagement name entering
     */
    public void enterTheEngagementNameSCM()
    {
    driver.findElement(eng_EngNameSCM).sendKeys("Test Engagement with new framework");
    try
	{
		Engagement_SavenCloseMan_Validator_pageLog.info("Trying to locate the element for engagement name entering");
	}
	catch (Exception e)
	{
		Engagement_SavenCloseMan_Validator_pageLog.info("unable to locate the element for engagement name entering");
	}
    }
    
    /*
     * Method for engagement status drop down
     */
    public void clickOnEngagementStatusDropDownSCM()
    {
    	clickWhenElementIsReady(driver, 20, eng_Status_DropDownSCM);
    	try
    	{
    		Engagement_SavenCloseMan_Validator_pageLog.info("Trying to locate the element for engagement status drop down");
    	}
    	catch (Exception e)
    	{
    		Engagement_SavenCloseMan_Validator_pageLog.info("unable to locate the element for engagement status drop down");
    	}
    }
    
    /*
     * method for engagement status selection
     */
    public void selectingEngagementStatusSCM()
    {
    	clickWhenElementIsReady(driver, 20, eng_Status_SelectionSCM);
    	try
    	{
    		Engagement_SavenCloseMan_Validator_pageLog.info("Trying to locate the element for engagement status selection");
    	}
    	catch (Exception e)
    	{
    		Engagement_SavenCloseMan_Validator_pageLog.info("unable to locate the element for engagement status selection");
    	}
    }
    
    /*
     * Method for engagement start date selection 1
     */
    public void engStartDateSelctionSCM1()
    {
    	clickWhenElementIsReady(driver, 20, eng_StartDate_SelectionSCM1);
    	try
    	{
    		Engagement_SavenCloseMan_Validator_pageLog.info("Trying to locate the element for engagement start date selection 1");
    	}
    	catch (Exception e)
    	{
    		Engagement_SavenCloseMan_Validator_pageLog.info("unable to locate the element for engagement start date selection 1");
    	}
    }
    
    /*
     * method for engagement start date selection 2
     */
    public void engStartDateSelctionSCM2()
    {
    	clickWhenElementIsReady(driver, 20, eng_StartDate_SelectionSCM2);
    	try
    	{
    		Engagement_SavenCloseMan_Validator_pageLog.info("Trying to locate the element for engagement start date selection 2");
    	}
    	catch (Exception e)
    	{
    		Engagement_SavenCloseMan_Validator_pageLog.info("unable to locate the element for engagement start date selection 2");
    	}
    }
    
    /*
     * Method for engagement date selection 1
     */
    public void engEndDateSelectionSCM1()
    {
    	clickWhenElementIsReady(driver, 20, eng_EndDate_SelectionSCM1);
    	try
    	{
    		Engagement_SavenCloseMan_Validator_pageLog.info("Trying to locate the element for engagement eng date selection 1");
    	}
    	catch (Exception e)
    	{
    		Engagement_SavenCloseMan_Validator_pageLog.info("unable to locate the element for engagement end date selection 1");
    	}
    }
    
    /*
     * Method for eng end date selection 2
     */
    public void engEndDateSelectionSCM2()
    {
    	clickWhenElementIsReady(driver, 20, eng_EndDate_SelectionSCM2);
    	try
    	{
    		Engagement_SavenCloseMan_Validator_pageLog.info("Trying to locate the element for engagement eng date selection 2");
    	}
    	catch (Exception e)
    	{
    		Engagement_SavenCloseMan_Validator_pageLog.info("unable to locate the element for engagement end date selection 2");
    	}	
    }
    
    /*
     * Method for engagement end date selection 3
     */
    public void engEndDateSelectionSCM3()
    {
    	clickWhenElementIsReady(driver, 20, eng_EndDate_SelectionSCM3);
    	try
    	{
    		Engagement_SavenCloseMan_Validator_pageLog.info("Trying to locate the element for engagement end date selection 3");
    	}
    	catch (Exception e)
    	{
    		Engagement_SavenCloseMan_Validator_pageLog.info("unable to locate the element for engagement end date selection 3");
    	}	
    }
    
    /*
     * Method for engagement end date selection 4
     */
    public void engEndDateSelectionSCM4()
    {
    	clickWhenElementIsReady(driver, 20, eng_EndDate_SelectionSCM4);
    	try
    	{
    		Engagement_SavenCloseMan_Validator_pageLog.info("Trying to locate the element for engagement end date selection 4");
    	}
    	catch (Exception e)
    	{
    		Engagement_SavenCloseMan_Validator_pageLog.info("unable to locate the element for engagement end date selection 4");
    	}	
    }
    
    /*
     * Method for end date selection 5
     */
    public void engEndDateSelectionSCM5()
    {
    	clickWhenElementIsReady(driver, 20, eng_EndDate_SelectionSCM5);
    	try
    	{
    		Engagement_SavenCloseMan_Validator_pageLog.info("Trying to locate the element for engagement end date selection 5");
    	}
    	catch (Exception e)
    	{
    		Engagement_SavenCloseMan_Validator_pageLog.info("unable to locate the element for engagement end date selection 5");
    	}
    }
    
    /*
     * MEthod for engagement subgroup drop down 
     */
    public void engSubGroupDropDownSCM()
    {
    	clickWhenElementIsReady(driver, 20, eng_SubGroup_DropDownSCM);
    	try
    	{
    		Engagement_SavenCloseMan_Validator_pageLog.info("Trying to locate the element for engagement subgroup drop down");
    	}
    	catch (Exception e)
    	{
    		Engagement_SavenCloseMan_Validator_pageLog.info("unable to locate the element for engagement subgroup drop down");
    	}
    }
    
    /*
     * Method for engagement subgroup selection
     */
    public void engSubGroupSelectionSCM()
    {
     clickWhenElementIsReady(driver, 20, eng_SubGroup__SelectionSCM);
     try
 	{
 		Engagement_SavenCloseMan_Validator_pageLog.info("Trying to locate the element for engagement subgroup selection");
 	}
 	catch (Exception e)
 	{
 		Engagement_SavenCloseMan_Validator_pageLog.info("unable to locate the element for engagement subgroup selection");
 	}
    }
    
    /*
     * Method for engagement billing typoe drop down
     */
    public void engBillingTypeDropDownSCM()
    {
    	clickWhenElementIsReady(driver, 20, eng_Billing_DropDownSCM);
    	try
    	{
    		Engagement_SavenCloseMan_Validator_pageLog.info("Trying to locate the element for engagement billing type drop down");
    	}
    	catch (Exception e)
    	{
    		Engagement_SavenCloseMan_Validator_pageLog.info("unable to locate the element for engagement billing type drop down");
    	}
    }
    
    /*
     * Method for engagement billing type selection
     */
    public void engBillingTypeSelectionSCM()
    {
    	clickWhenElementIsReady(driver, 20, eng_Billing_SelectionSCM);
    	try
    	{
    		Engagement_SavenCloseMan_Validator_pageLog.info("Trying to locate the element for engagement billing type selection");
    	}
    	catch (Exception e)
    	{
    		Engagement_SavenCloseMan_Validator_pageLog.info("unable to locate the element for engagement billing type selection");
    	}
    }
    
    /*
     * Method for engagement save and close
     */
    public void engSaveNCloseSCM()
    {
    	clickWhenElementIsReady(driver, 20, eng_SaveNCloseSCM);
    	try
    	{
    		Engagement_SavenCloseMan_Validator_pageLog.info("Trying to locate the element for engagement save and close");
    	}
    	catch (Exception e)
    	{
    		Engagement_SavenCloseMan_Validator_pageLog.info("unable to locate the element for engagement save and close");
    	}
    }
    
    /*
     * Method for engagement save and close
     */
    public void engCancelButtonSaveNCloseSCM()
    {
    	clickWhenElementIsReady(driver, 20, engagementCancelButtonSaveNCloseMan);
    	try
    	{
    		Engagement_SavenCloseMan_Validator_pageLog.info("Trying to locate the element for engagement save and close");
    	}
    	catch (Exception e)
    	{
    		Engagement_SavenCloseMan_Validator_pageLog.info("unable to locate the element for engagement save and close");
    	}
    }
}

    

