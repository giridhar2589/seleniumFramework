package com.mu_sigma.OrgPlatformAutomationFramework.IsmsAudit.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;

public class IsmsAuditOpen_page extends TestBase{

	WebDriver driver;
	
	private static final Logger IsmsAuditOpen_page_pageLog = LogManager
			.getLogger(IsmsAuditOpen_page.class.getName());
	
	By auditnum = By.xpath("//div[contains(text(),'Audit')]/strong");
	
	By open = By.xpath("//a[contains(text(),'Open')]");
	
	By filter = By.xpath("//div[span[contains(text(),'Filter')]]/input");
	
	By openAudit = By.xpath("//div[1]/div/div/strong");
	
	By selectAudit = By.xpath("//a[contains(text(),'Details')]");
	
	By closeAudit = By.xpath("//span[contains(text(),'Update Evidence/Comment')]");
	
	By closureComment = By.xpath("//fieldset[legend[contains(text(),'Closure')]]//textarea");
	
	By AddEvidence = By.xpath("//div[contains(text(),'Add Evidence')]");
	
	By externallink = By.xpath("(//i[@title='External Link'])[2]"); 
	
	By evidenceInput = By.xpath("(//input[@class='formtextbox fill'])[2]");
	
	By uploadEvidence = By.xpath("(//i[@title='Upload'])[2]");
	
	By save = By.xpath("(//span[contains(text(),'Save')])[2]");
	
	By saveClose = By.xpath("(//span[contains(text(),'Save')])[1]");
	
	By closureCorrection = By.xpath("(//img[@class='ui-datepicker-trigger'])[4]");
	
	By closureCSpoc = By.xpath("(//img[@class='ui-datepicker-trigger'])[1]");
	
	By closureCA = By.xpath("(//img[@class='ui-datepicker-trigger'])[5]");
	
	By closureCASpoc = By.xpath("(//img[@class='ui-datepicker-trigger'])[2]");
	
	By toDate = By.xpath("//button[contains(text(),'Today')]");
	
	By closedAudit = By.xpath("//div[contains(text(),'Audit Number')]/strong");
	
	String auditNum;
	
	public IsmsAuditOpen_page(WebDriver driver) {
		this.driver = driver;
	}
	
	/*
	 * Gets the approved audit number to be closed 
	 */
	public void auditNum() throws Exception {
		try
		{
			Thread.sleep(1000);
			auditNum = driver.findElement(auditnum).getText();
			IsmsAuditOpen_page_pageLog.info("Got the approved audit number");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/*
	 * Navigates to the open tab
	 */
	public void navigateOpen() throws Exception {
		try
		{
			Thread.sleep(1000);
			clickWhenElementIsReady(driver,20,open);
			IsmsAuditOpen_page_pageLog.info("Navigate to the open tab");
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/*
	 * Filters out the required audit to be closed
	 */
	public void filterAudit() throws Exception {
		try
		{
			Thread.sleep(500);
			driver.findElement(filter).clear();
			Thread.sleep(500);
			driver.findElement(filter).sendKeys(auditNum);
			IsmsAuditOpen_page_pageLog.info("Providing input for the filter");
			Thread.sleep(500);
			driver.findElement(filter).sendKeys(Keys.ENTER);
			IsmsAuditOpen_page_pageLog.info("Required audit record has been filtered");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/*
	 * Provides input to the assertion to validate the audit selection for closure
	 */
	public boolean auditOpen(){
		return(driver.findElement(openAudit).getText().equals(auditNum));
	}
	
	/*
	 * Selects the required audit to be closed
	 */ 
	public void openAudit() throws Exception {
		try
		{
			Thread.sleep(1000);
			clickWhenElementIsReady(driver,20,selectAudit);
			IsmsAuditOpen_page_pageLog.info("Required audit has been selected");
			Thread.sleep(1000);
			//clickWhenElementIsReady(driver,500,closeAudit);
			//Thread.sleep(1000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/*
	 * Selects close option
	 */ 
	public void openAuditClose() throws Exception {
		try
		{
			Thread.sleep(2000);
			clickWhenElementIsReady(driver,20,closeAudit);
			Thread.sleep(3000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/*
	 * provides input for the closure comment field which is provided by the excel sheet
	 */
	public void closureComment(String closurecomment) throws Exception {
		try
		{
			Thread.sleep(500);
			waitForElement(closureComment, 90);
			driver.findElement(closureComment).sendKeys(closurecomment);
			IsmsAuditOpen_page_pageLog.info("Providing inputs for the closure comment field");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/*
	 * provides input for the evidence field which is provided by the excel sheet
	 */
	public void evidence(String Evidence) throws Exception {
		try
		{
			//select component for text inputs
			Thread.sleep(1000);
			clickWhenElementIsReady(driver,20,AddEvidence);
			Thread.sleep(4000);
			clickWhenElementIsReady(driver,40,externallink);
			Thread.sleep(4000);
			waitForElement(evidenceInput, 90);
			driver.findElement(evidenceInput).sendKeys(Evidence);
			IsmsAuditOpen_page_pageLog.info("Providing path for the document upload");
			Thread.sleep(500);
			clickWhenElementIsReady(driver,20,uploadEvidence);
			IsmsAuditOpen_page_pageLog.info("Clicked on upload button");
			Thread.sleep(500);
			clickWhenElementIsReady(driver,20,save);
			IsmsAuditOpen_page_pageLog.info("Evidence has been uploaded successfully");
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/*
	 * provides input for the correction field
	 */
	public void selectCorrection() throws Exception{
		try
		{
			Thread.sleep(3000);
			driver.findElement(closureCorrection).click();
			Thread.sleep(3000);
			driver.findElement(toDate).click();
			IsmsAuditOpen_page_pageLog.info("Closure date for correction has been selected");
			Thread.sleep(1000);
			//clickWhenElementIsReady(driver,90, editablepopup_icon);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/*
	 * provides input for the corrective action field
	 */
	public void selectCorrectAction() throws Exception{
		try
		{
			Thread.sleep(3000);
			driver.findElement(closureCA).click();
			Thread.sleep(3000);
			driver.findElement(toDate).click();
			IsmsAuditOpen_page_pageLog.info("Closure date for corrective action has been selected");
			Thread.sleep(1000);
			//clickWhenElementIsReady(driver,90, editablepopup_icon);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/*
	 * Submits the audit closure
	 */
	public void saveClose() throws Exception {
		try
		{
			//select component for text inputs
			Thread.sleep(1000);
			clickWhenElementIsReady(driver,20,saveClose);
			IsmsAuditOpen_page_pageLog.info("Audit has been closed at first level");
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/*
	 * Provides input for assertion to validate the audit first level closure
	 */
	public boolean closeAudit(){
		return(driver.findElement(closedAudit).isDisplayed());
	}
	
	/*
	 * provides input for the correction field
	 */
	public void spocselectCorrection() throws Exception{
		try
		{
			Thread.sleep(3000);
			driver.findElement(closureCSpoc).click();
			Thread.sleep(3000);
			driver.findElement(toDate).click();
			IsmsAuditOpen_page_pageLog.info("Closure date for correction has been selected");
			Thread.sleep(1000);
			//clickWhenElementIsReady(driver,90, editablepopup_icon);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/*
	 * provides input for the corrective action field
	 */
	public void spocselectCorrectAction() throws Exception{
		try
		{
			Thread.sleep(3000);
			driver.findElement(closureCASpoc).click();
			Thread.sleep(3000);
			driver.findElement(toDate).click();
			IsmsAuditOpen_page_pageLog.info("Closure date for corrective action has been selected");
			Thread.sleep(1000);
			//clickWhenElementIsReady(driver,90, editablepopup_icon);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
}
