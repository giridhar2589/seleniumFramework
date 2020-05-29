package com.mu_sigma.OrgPlatformAutomationFramework.IsmsAudit.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;

public class IsmsAuditDuplicateAuditType_page extends TestBase{

	WebDriver driver;
	
	private static final Logger IsmsAuditDuplicateAuditType_page_pageLog = LogManager
			.getLogger(IsmsAuditDuplicateAuditType_page.class.getName());
	
	By settings = By.xpath("//a[contains(text(),'Settings')]");
	
	By audittype = By.xpath("//a[contains(text(),'Audit Type')]");
	
	By addaudittype = By.xpath("//div[contains(text(),'Add Audit')]");
	
	By save = By.xpath("//span[contains(text(),'Save')]");
	
	By alert = By.xpath("//pre[contains(text(),'not unique')]");
	
	By ok = By.xpath("//div[contains(text(),'OK')]");
	  
	By selaudittype = By.xpath("//select[contains(@label,'AuditType')]");
	
	By cancel = By.xpath("//span[contains(text(),'Cancel')]");
	
	public IsmsAuditDuplicateAuditType_page(WebDriver driver) {
		this.driver = driver;
	}
	
	/*
	 * Navigates to the audit type and tries to create a duplicate audit type by getting the inputs from excel
	 */
	public void selectAudittype(String newaudittype) throws Exception {
		try
		{
			Thread.sleep(500);
			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(settings)).perform();
			IsmsAuditDuplicateAuditType_page_pageLog.info("Mouse over to settings tab");
			
			clickWhenElementIsReady(driver,20,audittype);
			IsmsAuditDuplicateAuditType_page_pageLog.info("Selected audit type tab");
			clickWhenElementIsReady(driver,20,addaudittype);
			IsmsAuditDuplicateAuditType_page_pageLog.info("Selected add audit type option");
			Thread.sleep(2000);
			waitForElement(selaudittype, 80);
			driver.findElement(selaudittype).click();
			IsmsAuditDuplicateAuditType_page_pageLog.info("Audit type list has been enlarged");
			Select auditSelect=new Select(driver.findElement(selaudittype));
			Thread.sleep(1000);
			auditSelect.selectByVisibleText(newaudittype);
			IsmsAuditDuplicateAuditType_page_pageLog.info("Audit type has been selected");
			Thread.sleep(500);
			clickWhenElementIsReady(driver,20,save);
			IsmsAuditDuplicateAuditType_page_pageLog.info("Save option has been clicked");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/*
	 * Clicks 'OK' on the duplicate audit type pop up
	 */
	public void clickOk() throws Exception {
		try
		{
			Thread.sleep(500);
			clickWhenElementIsReady(driver,20,ok);
			IsmsAuditDuplicateAuditType_page_pageLog.info("Mandatory field pop has been closed");
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/*
	 * Clicks on 'Cancel' to bring back the control to the current web page
	 */    
	public void clickCancel() throws Exception {
		try
		{
			Thread.sleep(500);
			clickWhenElementIsReady(driver,20,cancel);
			IsmsAuditDuplicateAuditType_page_pageLog.info("Closing the add audit type pop up");
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/*
	 * provides input for assertion to validate the presence of mandatory input message 
	 */ 
	public boolean duplicatePopup() throws Exception{
		return(driver.findElement(alert).isDisplayed());
	}
}
