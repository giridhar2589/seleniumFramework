package com.mu_sigma.OrgPlatformAutomationFramework.IsmsAudit.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;

public class IsmsAuditSubRework_page extends TestBase{
	
	WebDriver driver;
	
	private static final Logger IsmsAuditSubRework_page_pageLog = LogManager
			.getLogger(IsmsAuditSubmitted_page.class.getName());
	
	By auditnum = By.xpath("//div[contains(text(),'Audit')]/strong");
	
	By submittedTab = By.xpath("//a[contains(text(),'Submitted')]");
	
	By filter = By.xpath("//div[span[contains(text(),'Filter')]]/input");
	
	By submittedAudit = By.xpath("//div[1]/div/div/strong");
	
	By selectaudit = By.xpath("//a[contains(text(),'Details')]");
	
	By reworkAudit = By.xpath("//span[contains(text(),'Reassign')]");
	
	By reworkCommnt = By.xpath("//div[contains(@class,'Optional')]//textarea");
	
	By confirm = By.xpath("//span[contains(text(),'Confirm')]");
	
	By reworkaudit = By.xpath("//div[contains(text(),'Audit Number')]/strong");
	
	String auditNum;
	
	public IsmsAuditSubRework_page(WebDriver driver) {
		this.driver = driver;
	}
	
	/*
	 * Gets the reported audit number for validation 
	 */
	public void auditNum() throws Exception {
		try
		{
			Thread.sleep(1000);
			auditNum = driver.findElement(auditnum).getText();
			IsmsAuditSubRework_page_pageLog.info("Gets the reported audit finding number");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/*
	 * Navigates to the submitted tab
	 */
	public void navigateSubmitted() throws Exception {
		try
		{
			Thread.sleep(1000);
			clickWhenElementIsReady(driver,20,submittedTab);
			IsmsAuditSubRework_page_pageLog.info("Navigated to the submitted tab");
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/*
	 * Filters out the required audit number for submission 
	 */
	public void filterAudit() throws Exception {
		try
		{
			Thread.sleep(1000);
			driver.findElement(filter).sendKeys(auditNum);
			IsmsAuditSubRework_page_pageLog.info("Provided input for the filter");
			Thread.sleep(500);
			driver.findElement(filter).sendKeys(Keys.ENTER);
			IsmsAuditSubRework_page_pageLog.info("Requiered audit record has been filtered");
			Thread.sleep(3000);
			clickWhenElementIsReady(driver,20,selectaudit);
			IsmsAuditSubRework_page_pageLog.info("Required audit has been selected");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/*
	 * provides input for assertion to validate the audit selection
	 */
	public boolean auditSubmitted(){
		return(driver.findElement(submittedAudit).getText().equals(auditNum));
	}
	
	/*
	 * Selects the required audit and sends for rework
	 */
	public void reworkAudit() throws Exception {
		try
		{
			Thread.sleep(3000);
			clickWhenElementIsReady(driver,20,reworkAudit);
			Thread.sleep(3000);
			driver.findElement(reworkCommnt).sendKeys("audit finding has been sent for rework");
			Thread.sleep(3000);
			clickWhenElementIsReady(driver,20,confirm);
			Thread.sleep(3000);
			IsmsAuditSubRework_page_pageLog.info("Submitted audit has been sent for rework");
			Thread.sleep(3000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/*
	 * Provides input for assertion to validate the audit submission
	 */
	public boolean reworkedAudit(){
		return(driver.findElement(reworkaudit).isDisplayed());
	}

}
