
package com.mu_sigma.OrgPlatformAutomationFramework.IsmsAudit.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;


public class IsmsAuditClosed_page extends TestBase {
	
	WebDriver driver;
	
	private static final Logger IsmsAuditClosed_page_pageLog = LogManager
			.getLogger(IsmsAuditClosed_page.class.getName());
	
	By auditnum = By.xpath("//div[contains(text(),'Audit')]/strong");
	
	By closed = By.xpath("//a[contains(text(),'Closed')]");
	
	By filter = By.xpath("//div[span[contains(text(),'Filter')]]/input");
	
	By closedAudit = By.xpath("//div[1]/div/div/strong");
	
	By selectAudit = By.xpath("//a[contains(text(),'Details')]");
	
	By approve = By.xpath("//span[contains(text(),'Approve')]");
	
	By close = By.xpath("//span[contains(text(),'Audit Close')]");
	
	By reviewRemark = By.xpath("(//fieldset/div/textarea)[8]");
	
	By save = By.xpath("//span[contains(text(),'Save')]");
	
	By finalclosedAudit = By.xpath("//div[contains(text(),'Audit')]/strong");
	
	By closedstatus1 = By.xpath("//div[@class='value']/strong");
	
	By closedstatus2 = By.xpath("//div[@class='value2']/strong");
	
	By closedRework = By.xpath("//span[contains(text(),'Reassign')]");
	
	By reworkCommnt = By.xpath("//div[contains(@class,'Optional')]//textarea[contains(@label,'Rework')]");
	
	By reworkConfirm = By.xpath("//span[contains(text(),'Confirm')]");
	
	
	public IsmsAuditClosed_page(WebDriver driver) {
		this.driver = driver;
	}
	
	String auditNum;
	
	/*
	 * Gets the audit number closed at first level 
	 */
	public void auditNum() throws Exception {
		try
		{
			Thread.sleep(1000);
			auditNum = driver.findElement(auditnum).getText();
			IsmsAuditClosed_page_pageLog.info("Got the closed audit number");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/*
	 * Navigates to the closed tab
	 */ 
	public void navigateClose() throws Exception {
		try
		{
			Thread.sleep(1000);
			clickWhenElementIsReady(driver,20,closed);
			IsmsAuditClosed_page_pageLog.info("Navigated to closed tab");
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/*
	 * Filters out the required audit finding for final closure
	 */ 
	public void filterAudit() throws Exception {
		try
		{
			Thread.sleep(1000);
			driver.findElement(filter).clear();
			Thread.sleep(1000);
			driver.findElement(filter).sendKeys(auditNum);
			IsmsAuditClosed_page_pageLog.info("Provided input for the filter");
			Thread.sleep(1000);
			driver.findElement(filter).sendKeys(Keys.ENTER);
			IsmsAuditClosed_page_pageLog.info("Required filter has been filtered out");
			Thread.sleep(1000);
			clickWhenElementIsReady(driver,20,selectAudit);
			IsmsAuditClosed_page_pageLog.info("clicked on Details");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/*
	 * Provides input for the assertion to validate the audit selection for closure 
	 */ 
	public boolean auditClosed(){
		return(driver.findElement(closedAudit).getText().equals(auditNum));
	}
	
	/*
	 * Final closure of the selected audit finding by providing inputs from excel
	 */
	public void closeAudit(String reviewremark) throws Exception {
		try
		{
			Thread.sleep(1000);
			clickWhenElementIsReady(driver, 20, approve);
			IsmsAuditClosed_page_pageLog.info("Required audit has been closed");
			Thread.sleep(1000);  
			clickWhenElementIsReady(driver, 20,close);
			Thread.sleep(2000);
			driver.findElement(reviewRemark).sendKeys(reviewremark);
			IsmsAuditClosed_page_pageLog.info("provided input for the review remark field");
			Thread.sleep(1000);
			clickWhenElementIsReady(driver,20,save);
			IsmsAuditClosed_page_pageLog.info("Audit has been closed successfully");
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/*
	 * Final closure of the selected audit finding by SPOC providing inputs from excel 
	 */
	public void closeAuditSpoc(String reviewremark) throws Exception {
		try
		{
	
			
			Thread.sleep(2000);
			clickWhenElementIsReady(driver,20,approve);
			IsmsAuditClosed_page_pageLog.info("Clicked on Approve");
			Thread.sleep(2000);
			clickWhenElementIsReady(driver,20,close);
			IsmsAuditClosed_page_pageLog.info("Required audit has been closed");
			Thread.sleep(2000);
			driver.findElement(reviewRemark).sendKeys(reviewremark);
			Thread.sleep(2000);
			IsmsAuditClosed_page_pageLog.info("provided input for the review remark field");
			Thread.sleep(1000);
			clickWhenElementIsReady(driver,20,save);
			IsmsAuditClosed_page_pageLog.info("Audit has been closed successfully");
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	/*
	 * Sending the Closed audit for rework by admin 
	 */
	public void closeAuditSpocRework() throws Exception {
		try
		{
			Thread.sleep(2000);
			clickWhenElementIsReady(driver,20,closedRework);
			Thread.sleep(2000);
			driver.findElement(reworkCommnt).sendKeys("Closure has been rejected hence sent for rework");
			Thread.sleep(2000);
			clickWhenElementIsReady(driver,20,reworkConfirm);
			Thread.sleep(2000);
			IsmsAuditClosed_page_pageLog.info("Audit has been sent for the rework successfully");
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/*
	 * Provides input for assertion to validate the audit final closure
	 */
	public boolean closedAuditCheck(){
		return(driver.findElement(finalclosedAudit).isDisplayed() && driver.findElement(closedstatus1).getText().equalsIgnoreCase(driver.findElement(closedstatus2).getText()));
	}
	
	
	
}
