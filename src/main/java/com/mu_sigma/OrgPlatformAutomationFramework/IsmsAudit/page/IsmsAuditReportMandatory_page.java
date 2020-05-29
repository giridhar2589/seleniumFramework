package com.mu_sigma.OrgPlatformAutomationFramework.IsmsAudit.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;

public class IsmsAuditReportMandatory_page extends TestBase {
	
	WebDriver driver;
	
	private static final Logger IsmsAuditReportMandatory_page_pageLog = LogManager
			.getLogger(IsmsAuditReportMandatory_page.class.getName());
	
	By reportTab = By.xpath("//a[text()='Audit Findings']");
	
	By reportAudit = By.xpath("//span[contains(text(),'Add Findings')]");
	
	By alert = By.xpath("//span[contains(text(),'Information')]");
	
	By ok = By.xpath("//div[contains(text(),'OK')]");
	
	By yes = By.xpath("//div[contains(text(),'OK')]");
	
	public IsmsAuditReportMandatory_page(WebDriver driver) {
		this.driver = driver;
	}
	
	/*
	 * Navigate to the report tab and tries to submit the audit without any input 
	 */
	public void navigateReportMand() throws Exception {
		try
		{
			Thread.sleep(500);
			clickWhenElementIsReady(driver,20,reportTab);
			IsmsAuditReportMandatory_page_pageLog.info("Navigated to the Audit Findings Page");
			Thread.sleep(500);
			clickWhenElementIsReady(driver,20,reportAudit);
			IsmsAuditReportMandatory_page_pageLog.info("Clicked on Add Findings without entering any fields");
			Thread.sleep(500);
			clickWhenElementIsReady(driver,20,yes);
			IsmsAuditReportMandatory_page_pageLog.info("Clicked Ok");
			Thread.sleep(2000);
			driver.findElement(alert).isDisplayed();
			IsmsAuditReportMandatory_page_pageLog.info("Mandatory input pop up has displayed");
			Thread.sleep(2000);
			clickWhenElementIsReady(driver,20,ok);
			IsmsAuditReportMandatory_page_pageLog.info("Mandatory input pop up has been closed");
			Thread.sleep(500);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/*
	 * Clicks 'OK' on the mandatory input pop up
	 
	public void clickOk() throws Exception {
		try
		{
			Thread.sleep(500);
			clickWhenElementIsReady(driver,20,ok);
			IsmsAuditReportMandatory_page_pageLog.info("Mandatory input pop up has been closed");
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	 * Provides input for assertion to validate the presence of inputs mandatory message 
	 
	public boolean mandatoryPopup() throws Exception{
		return(driver.findElement(alert).isDisplayed());
	}
	 */
}
