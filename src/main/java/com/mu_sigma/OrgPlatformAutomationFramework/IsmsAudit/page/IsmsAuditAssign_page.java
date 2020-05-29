package com.mu_sigma.OrgPlatformAutomationFramework.IsmsAudit.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;


public class IsmsAuditAssign_page extends TestBase {
	
	WebDriver driver;
	
	private static final Logger IsmsAuditAssign_page_pageLog = LogManager
			.getLogger(IsmsAuditAssign_page.class.getName());
	
	By auditnum = By.xpath("//div[contains(text(),'Audit')]/strong");
	
	By assigned = By.xpath("//a[contains(text(),'Assigned')]");
	
	By filter = By.xpath("//div[span[contains(text(),'Filter')]]/input");
	
	By assignedAudit = By.xpath("//div[1]/div/div/strong");
	
	By selectAudit = By.xpath("//a[contains(text(),'Details')]");
	
	By auditModify = By.xpath("//span[contains(text(),'Update')]");
	
	By Correction = By.xpath("//div[span[contains(text(),'Correction')]]/textarea[1]");
	
	By rootCause = By.xpath("//div[span[contains(text(),'Correction')]]/textarea[2]");
	
	By correctiveAction = By.xpath("//div[span[contains(text(),'Correction')]]/textarea[3]");
	
	By submit = By.xpath("//span[contains(text(),'Submit')]");
	
	By submittedRep = By.xpath("//div[contains(text(),'Audit Number')]/strong");
	
	By Resubmit = By.xpath("//span[contains(text(),'Resubmit')]");
	
	
	String auditnumber;
	
	public IsmsAuditAssign_page(WebDriver driver) {
		this.driver = driver;
	}
	
	/*
	 * Gets the reported audit number to verify its assignment 
	 */
	public void auditNum() throws Exception {
		try
		{
			Thread.sleep(1000);
			auditnumber = driver.findElement(auditnum).getText();
			IsmsAuditAssign_page_pageLog.info("Got the reported audit number to verify its assignment");
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/*
	 * Navigates to the assigned tab
	 */
	public void navigateAssign() throws Exception {
		try
		{
			Thread.sleep(1000);
			clickWhenElementIsReady(driver,20,assigned);
			IsmsAuditAssign_page_pageLog.info("Successfully navigated to assigned tab");
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/*
	 * Filters out the required audit finding number 
	 */
	public void filterAudit() throws Exception {
		try
		{
			Thread.sleep(500);
			driver.findElement(filter).clear();
			Thread.sleep(1000);
			driver.findElement(filter).sendKeys(auditnumber);
			IsmsAuditAssign_page_pageLog.info("Successfully sent input for filter");
			Thread.sleep(500);
			driver.findElement(filter).sendKeys(Keys.ENTER);
			IsmsAuditAssign_page_pageLog.info("Successfully filtered out the required records");
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/*
	 * Provides the input for the assertion to validate the reported audit finding assignment
	 */ 
	public boolean auditAssigned(){
		IsmsAuditAssign_page_pageLog.info("Validating the audit numbers");
		return(driver.findElement(assignedAudit).getText().equals(auditnumber));
	}
	
	/*
	 * Selects the filtered audit finding
	 */
	public void modifyAudit() throws Exception {
		try
		{
			Thread.sleep(3000);
			clickWhenElementIsReady(driver,20,selectAudit);
			IsmsAuditAssign_page_pageLog.info("Selected the required filtered record");
			//Thread.sleep(500);
			//clickWhenElementIsReady(driver,500,auditModify);
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/*
	 * Clicks modify option
	 */
	public void modifyClickAudit() throws Exception {
		try
		{
			Thread.sleep(500);
			clickWhenElementIsReady(driver,20,auditModify);
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/*
	 * Provides input for the correction field given by the excel sheet
	 */ 
	public void correction(String correction) throws Exception {
		try
		{
			//select component for text inputs
			waitForElement(Correction, 20);
			driver.findElement(Correction).sendKeys(correction);
			IsmsAuditAssign_page_pageLog.info("Provided input for correction field");
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/*
	 * Provides input for the root cause field given by the excel sheet
	 */
	public void rootcause(String rootcause) throws Exception {
		try
		{
			//select component for text inputs
			waitForElement(rootCause, 20);
			driver.findElement(rootCause).sendKeys(rootcause);
			IsmsAuditAssign_page_pageLog.info("Provided input for rootcause field");
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/*
	 * Provides input for the corrective action field given by the excel sheet
	 */	
	public void coorectAction(String correctiveaction) throws Exception {
		try
		{
			//select component for text inputs
			waitForElement(correctiveAction, 90);
			driver.findElement(correctiveAction).sendKeys(correctiveaction);
			IsmsAuditAssign_page_pageLog.info("Provided input for corrective action field");
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/*
	 * Submits the assigned audit for approval
	 */
	public void submit() throws Exception {
		try
		{
			Thread.sleep(1000);
			clickWhenElementIsReady(driver,40,submit);
			IsmsAuditAssign_page_pageLog.info("Successfully submitted the assigned report");
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/*
	 * ReSubmits the reworked audit for approval
	 */
	public void resubmit() throws Exception {
		try
		{
			Thread.sleep(1000);
			clickWhenElementIsReady(driver,20,Resubmit);
			IsmsAuditAssign_page_pageLog.info("Successfully Resubmitted the assigned report");
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/*
	 * Provides the input for the assertion to validate the assigned audit submission
	 */
	 public boolean reportSubmitted(){
			return(driver.findElement(submittedRep).isDisplayed());
	}
}
