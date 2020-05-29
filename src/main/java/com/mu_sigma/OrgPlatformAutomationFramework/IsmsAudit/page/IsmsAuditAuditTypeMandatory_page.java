package com.mu_sigma.OrgPlatformAutomationFramework.IsmsAudit.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;

public class IsmsAuditAuditTypeMandatory_page extends TestBase{

	WebDriver driver;
	
	private static final Logger IsmsAuditAuditTypeMandatory_page_pageLog = LogManager
			.getLogger(IsmsAuditAuditTypeMandatory_page.class.getName());
	
	By settings = By.xpath("//a[contains(text(),'Settings')]");
	
	By audittype = By.xpath("//a[contains(text(),'Audit Type')]");
	
	By addaudittype = By.xpath("//div[contains(text(),'Add Audit')]");
	
	By save = By.xpath("//span[contains(text(),'Save')]");
	
	By alert = By.xpath("//pre[contains(text(),'mandatory field')]");
	
	By ok = By.xpath("//div[contains(text(),'OK')]");
	
	By cancel = By.xpath("//span[text()='Cancel']");
	
	public IsmsAuditAuditTypeMandatory_page(WebDriver driver) {
		this.driver = driver;
	}
	
	/*
	 * Navigates to the audit type tab and tries to create a audit type without providing any input
	 */
	public void navigateAuditType() throws Exception {
		try
		{
			Thread.sleep(1000);
			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(settings)).perform();
			IsmsAuditAuditTypeMandatory_page_pageLog.info("Mouse over to settings tab");
			Thread.sleep(1000);
			clickWhenElementIsReady(driver,20,audittype);
			IsmsAuditAuditTypeMandatory_page_pageLog.info("Selected audit type tab");
			Thread.sleep(1000);
			clickWhenElementIsReady(driver,20,addaudittype);
			IsmsAuditAuditTypeMandatory_page_pageLog.info("Selected add audit type option");
			Thread.sleep(500);
			clickWhenElementIsReady(driver,20,save);
			IsmsAuditAuditTypeMandatory_page_pageLog.info("Clicked on saved option without and input");
			Thread.sleep(500);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/*
	 * Clicks 'OK' on mandatory input pop up and brings the control back to the current web page
	 */  
	public void clickOk() throws Exception {
		try
		{
			Thread.sleep(500);
			clickWhenElementIsReady(driver,20,ok);
			IsmsAuditAuditTypeMandatory_page_pageLog.info("Closing the mandatory field pop up");
			Thread.sleep(1000);
			clickWhenElementIsReady(driver,20, cancel);
			IsmsAuditAuditTypeMandatory_page_pageLog.info("Clicked on Cancel option and returned to Previous Page");
			Thread.sleep(500);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/*
	 * Provides input for the assertion to validate the presence of mandatory input message
	 */
	public boolean mandatoryPopup() throws Exception{
		return(driver.findElement(alert).isDisplayed());
	}
}
