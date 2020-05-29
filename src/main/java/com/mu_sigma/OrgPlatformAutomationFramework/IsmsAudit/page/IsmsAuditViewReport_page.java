package com.mu_sigma.OrgPlatformAutomationFramework.IsmsAudit.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;

public class IsmsAuditViewReport_page extends TestBase{
	
	WebDriver driver;
	
	private static final Logger IsmsAuditViewReport_page_pageLog = LogManager
			.getLogger(IsmsAuditViewReport_page.class.getName());
	
	By settings = By.xpath("//a[contains(text(),'Settings')]");
	
	By reportview = By.xpath("//a[contains(text(),'Audit Report')]");
	
	By allaudit = By.xpath("//div[contains(text(),'All Audit')]");
	
	By allauditlabel = By.xpath("//h2[contains(text(),'All Audit')]");
	
	By internal = By.xpath("//div[contains(text(),'Internal')]");
	
	By internallabel = By.xpath("//h2[contains(text(),'Internal Audit')]");
	
	By external = By.xpath("//div[contains(text(),'External')]");
	
	By externallabel = By.xpath("//h2[contains(text(),'External Audit')]");
	
	By client = By.xpath("//div[contains(text(),'Client')]");
	
	By clientlabel = By.xpath("//h2[contains(text(),'Client Audit')]");
	
	public IsmsAuditViewReport_page(WebDriver driver) {
		this.driver = driver;
	}
	
	/*
	 * Navigates to the audit report tab 
	 */
	public void navigateAuditViewReport() throws Exception {
		try
		{
			Thread.sleep(1000);
			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(settings)).perform();
			IsmsAuditViewReport_page_pageLog.info("Mouse over for settings tab");
			Thread.sleep(1000);
			clickWhenElementIsReady(driver,500,reportview);
			IsmsAuditViewReport_page_pageLog.info("Navigated to report tab");
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/*
	 * Navigates to the all audits report view
	 */
	public void allAudit() throws Exception {
		try
		{
			Thread.sleep(500);
			clickWhenElementIsReady(driver,20,allaudit);
			IsmsAuditViewReport_page_pageLog.info("Navigated to all audit reports view");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/*
	 * Provides input to validate the presence of all audit report view 
	 */
	public boolean allAuditCheck() throws Exception{
		return(driver.findElement(allaudit).isDisplayed());
	}
	
	/*
	 * Navigates to the internal audits report view
	 */
	public void internalAudit() throws Exception {
		try
		{
			Thread.sleep(500);
			clickWhenElementIsReady(driver,20,internal);
			IsmsAuditViewReport_page_pageLog.info("Navigated to internal audits reports view");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/*
	 * Provides input to validate the presence of internal audit report view
	 */
	public boolean internalAuditCheck() throws Exception{
		Thread.sleep(500);
		return(driver.findElement(internallabel).isDisplayed());
	}
	
	/*
	 * Navigates to the external audits report view
	 */
	public void externalAudit() throws Exception {
		try
		{
			Thread.sleep(500);
			clickWhenElementIsReady(driver,20,external);
			IsmsAuditViewReport_page_pageLog.info("Navigated to external audits reports view");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/*
	 * Provides input to validate the presence of external audit report view 
	 */
	public boolean externalAuditCheck() throws Exception{
		return(driver.findElement(externallabel).isDisplayed());
	}
	
	/*
	 * Navigates to the client audits report view
	 */
	public void clientAudit() throws Exception {
		try
		{
			Thread.sleep(500);
			clickWhenElementIsReady(driver,20,client);
			IsmsAuditViewReport_page_pageLog.info("Navigated to client audits reports view");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/*
	 * Provides input to validate the presence of client audit report view
	 */
	public boolean clientAuditCheck() throws Exception{
		return(driver.findElement(clientlabel).getText().contains(driver.findElement(client).getText()));
	}
}
