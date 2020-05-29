package com.mu_sigma.OrgPlatformAutomationFramework.IsmsAudit.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;

public class IsmsAuditReport_page extends TestBase {

	WebDriver driver;
	
	private static final Logger IsmsAuditReport_page_pageLog = LogManager
			.getLogger(IsmsAuditReport_page.class.getName());
	
	//private static final Logger IsmsAuditReport_pagelog = LogManager.getLogger(IsmsAuditReport_page.class.getName());
	
By reportTab = By.xpath("//a[text()='Audit Findings']");
	
	By reportAudit = By.xpath("//span[contains(text(),'Add Findings')]");
	
	By alert = By.xpath("//span[contains(text(),'Information')]");
	
	By ok = By.xpath("//div[contains(text(),'OK')]");
	
	By yes = By.xpath("//div[contains(text(),'OK')]");
	
	
	By report_icon = By.xpath("//a[@class='dropbtn'][contains(text(),'Audit Findings')]");
	
	By logout_icon = By.xpath("//i[@class='fa fa-bars']");
	
	By logoutLink_icon = By.xpath("//div[contains(text(),'Logout')]");
	
	By editablepopup_icon = By.xpath("//div[contains(text(),'OK')]");
	
	By logoutPopUp_icon = By.xpath("//button[@class='formbutton'][@mode='dontsave']");
	
	By auditType = By.xpath("//select[@label='AuditType']");
	
	By logout = By.xpath("//h3[contains(text(),'You Are Now Logged Out.')]");
	
	By auditDatePicker = By.xpath("//div[contains(@label,'AuditDate')]/img");
	
	By auditPrev = By.xpath("//span[contains(text(),'Prev')]");
	
	By auditDate = By.xpath("//a[contains(text(),'28')]");
	
	By todayDate = By.xpath("//button[contains(text(),'Today')]");
	
	By deptSrch = By.xpath("//span[contains(@class,'Mandatory formsearchbuttonright fa-search')]");
    
	By deptNameSrch = By.xpath("//td[3][contains(@class,'tablesaw-priority-1')]/input");
	
	By sortDept = By.xpath("//th[contains(text(),'Department Name')]");
	
	By deptRadiosel = By.xpath("//input[contains(@type,'radio')]");
	
	By Department = By.xpath("//table/tbody/tr[3]/td/table/tbody/tr[2]/td/table/tbody/tr/td[2]/div/span");
	
	By clause = By.xpath("//input[@label='Clause']");
	
	By auditCycle = By.xpath("//select[@label='AuditQcycle']");
	
	By findingType = By.xpath("//select[@label='FindingType']");
	
	By tartgetdatecorrection = By.xpath("//div[@label='TargetDateForRCA']/input");
	
	By targetdatecorrectiveaction = By.xpath("//div[@label='TargetDateForAuditCompletion']/input");
	
	By Findings = By.xpath("//textarea[@label='Findings']");
	
	By TDC = By.xpath("//div[contains(@label,'TargetDateForRCA')]/img");
	
	By TDCA = By.xpath("//div[contains(@label,'TargetDateForAuditCompletion')]/img");
	
	By Report = By.xpath("//span[contains(text(),'Add Findings')]");
	
	By createdRep = By.xpath("//div[contains(text(),'Audit Number')]/strong");
	
	public IsmsAuditReport_page(WebDriver driver) {
		this.driver = driver;
	}
	
	/*
	 * Navigates to the report tab and highlights the element
	 */
	public void navigateReport() throws Exception {
		try
		{
			Thread.sleep(3000);
			clickWhenElementIsReady(driver,20, report_icon);
			IsmsAuditReport_page_pageLog.info("Navigated to the audit report view");
			Thread.sleep(3000);
			highlightElement(driver, driver.findElement(report_icon));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/*
	 * provides input for assertion to validate the report audit view
	 */ 
	public boolean reportPresent() throws InterruptedException{
		Thread.sleep(3000);
		return(driver.findElement(auditType).isDisplayed());
	}
	
	/*
	 * Logs out of the application by not saving the changes.
	 */
	public void logOut() throws Exception {
		try
		{
			//Logout function
			Thread.sleep(1000);
			clickWhenElementIsReady(driver,20, logout_icon);
			IsmsAuditReport_page_pageLog.info("Logout option has been selected");
			Thread.sleep(2000);
			clickWhenElementIsReady(driver,20, logoutLink_icon);
			IsmsAuditReport_page_pageLog.info("Logout link has been selected");
			//clickWhenElementIsReady(driver,90, editablepopup_icon);
			//clickWhenElementIsReady(driver,90,logoutPopUp_icon);
			//IsmsAuditReport_page_pageLog.info("Don't save option has been selected on bizapp frameworks pop up");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/*
	 * Provides the input for the audit type field which is provided by the excel sheet
	 */
	public void selectAudittype(String audittype) throws Exception {
		try
		{
			//select component for text inputs
			Thread.sleep(2000);
			waitForElement(auditType, 80);
			driver.findElement(auditType).click();
			Thread.sleep(500);
			IsmsAuditReport_page_pageLog.info("Audit type drop down has been selected");
			Select auditSelect=new Select(driver.findElement(auditType));
			Thread.sleep(1000);
			auditSelect.selectByVisibleText(audittype);
			IsmsAuditReport_page_pageLog.info("Audit type has been selected from the list");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/*
	 * Provides input for the audit date field
	 */
	public void selectAuditDate() throws Exception{
		try
		{
			Thread.sleep(1000);
			driver.findElement(auditDatePicker).click();
			IsmsAuditReport_page_pageLog.info("Date picker icon has been selected for audit date");
			Thread.sleep(1000);
			driver.findElement(auditPrev).click();
			IsmsAuditReport_page_pageLog.info("Navigated to the previous month on date picker");
			Thread.sleep(1000);
			driver.findElement(auditDate).click();
			IsmsAuditReport_page_pageLog.info("Audit date has been selected");
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/*
	 * Provides the input for the department field which is provided by the excel sheet
	 */
	public void selectDepttype(String department) throws Exception {
		try
		{
			//select component for text inputs
			clickWhenElementIsReady(driver,20, deptSrch);
			Thread.sleep(500);
			IsmsAuditReport_page_pageLog.info("Department list has been selected");
			Thread.sleep(1000);
			driver.findElement(deptNameSrch).sendKeys(department);
			IsmsAuditReport_page_pageLog.info("Input for the required departname has been given");
			clickWhenElementIsReady(driver,20, sortDept);
			Thread.sleep(500);
			clickWhenElementIsReady(driver,20, deptRadiosel);
			Thread.sleep(500);
			clickWhenElementIsReady(driver,20, Department);
			IsmsAuditReport_page_pageLog.info("Department has been selected from the list");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/*
	 * Provides the input for the clause number field which is provided by the excel sheet
	 */
	public void clauseNumber(String clausenumber) throws Exception {
		try
		{
			//select component for text inputs
			clickWhenElementIsReady(driver,20, clause);
			driver.findElement(clause).sendKeys(clausenumber);
			IsmsAuditReport_page_pageLog.info("Providing input for the clause field");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/*
	 * Provides the input for the audit cycle field which is provided by the excel sheet
	 
	public void selectAuditcycle(String auditcycle) throws Exception {
		try
		{
			//select component for text inputs
			Thread.sleep(1000);
			driver.findElement(auditCycle).click();
			IsmsAuditReport_page_pageLog.info("Selected audit cycle list");
			waitForElement(auditCycle, 80);
			Select auditcycleSelect=new Select(driver.findElement(auditCycle));
			Thread.sleep(1000);
			auditcycleSelect.selectByVisibleText(auditcycle);
			IsmsAuditReport_page_pageLog.info("Requiered audit cycle has been selected");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	*/
	/*
	 * Provides the input for the finding type field which is provided by the excel sheet
	 */
	public void selectFindingtype(String findingtype) throws Exception {
		try
		{
			//select component for text inputs
			Thread.sleep(1000);
			driver.findElement(findingType).click();
			IsmsAuditReport_page_pageLog.info("Finding type list has been selected");
			waitForElement(findingType, 80);
			Select auditcycleSelect=new Select(driver.findElement(findingType));
			Thread.sleep(1000);
			auditcycleSelect.selectByVisibleText(findingtype);
			IsmsAuditReport_page_pageLog.info("Required finding type has been selected");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/*
	 * Provides the input for findings field which is provided by the excel sheet
	 */
	public void findingsDesc(String findings) throws Exception {
		try
		{
			//select component for text inputs
			clickWhenElementIsReady(driver,20, Findings);
			driver.findElement(Findings).sendKeys(findings);
			IsmsAuditReport_page_pageLog.info("Input for the findings description field has been provided");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/*
	 * Provides the input for the target date for correction field
	 */
	public void selectTDCDate() throws Exception{
		try
		{
			Thread.sleep(1000);
			driver.findElement(TDC).click();
			IsmsAuditReport_page_pageLog.info("Date picker for the target date correction");
			Thread.sleep(1000);
			driver.findElement(todayDate).click();
			IsmsAuditReport_page_pageLog.info("Todays date has been selcetd for target date correction");
			Thread.sleep(1000);
			//clickWhenElementIsReady(driver,90, editablepopup_icon);
			//Thread.sleep(1000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/*
	 * Provides the input for the target date for corrective action field
	 */
    public void selectTDCADate() throws Exception{
    	try
    	{
    		Thread.sleep(1000);
    		driver.findElement(TDCA).click();
    		IsmsAuditReport_page_pageLog.info("Date picker for the target date corrective action");
    		Thread.sleep(1000);
    		driver.findElement(todayDate).click();
    		IsmsAuditReport_page_pageLog.info("Todays date has been selcetd for target date corrective action");
    		Thread.sleep(1000);
    		//clickWhenElementIsReady(driver,90, editablepopup_icon);
    		//Thread.sleep(1000);
    	}
    	catch(Exception e)
		{
			e.printStackTrace();
		}
	}
   
    
    /*
     * Submits the audit report
     */
    public void raiseReport() throws Exception{
    	try
    	{
    		Thread.sleep(1000);
    		driver.findElement(Report).click();
    		IsmsAuditReport_page_pageLog.info("Confirmation Pop-up displayed");
    		Thread.sleep(1000);
    		driver.findElement(ok).click();
    		IsmsAuditReport_page_pageLog.info("Audit finding has been successfully reported");
    	}
    	catch(Exception e)
		{
			e.printStackTrace();
		}
	}
    
   /*
    * Provides the input for assertion to validate the reported audit
    */
    public boolean reportCreated(){
		return(driver.findElement(createdRep).isDisplayed());
	}
    public void Close() {
    	driver.quit();
    }
	
}
