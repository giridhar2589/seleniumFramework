package com.mu_sigma.OrgPlatformAutomationFramework.IsmsAudit.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;

public class IsmsAuditCloseMandatory_page extends TestBase {

	WebDriver driver;
	
	private static final Logger IsmsAuditCloseMandatory_page_pageLog = LogManager
			.getLogger(IsmsAuditCloseMandatory_page.class.getName());
	
	By closed = By.xpath("//a[contains(text(),'Closed')]");
	
	By filter = By.xpath("//div[span[contains(text(),'Filter')]]/input");
	
	By details = By.xpath("(//a[contains(text(),'Details')])[1]");
	
	By auditclose = By.xpath("//span[contains(text(),'Audit Close')]");
	
	By save = By.xpath("//span[contains(text(),'Save')]");
	
	By alert = By.xpath("//pre[contains(text(),'mandatory field')]");
	
	By ok = By.xpath("//div[contains(text(),'OK')]");
	
	By approve = By.xpath("//span[contains(text(),'Approve')]");
	
	public IsmsAuditCloseMandatory_page(WebDriver driver) {
		this.driver = driver;
	}
	
	
	/*
	 * Navigates to the closed tab and tries to close the selected audit without providing any inputs
	 */
	public void navigateCloseMand() throws Exception {
		try
		{
			Thread.sleep(1000);
			clickWhenElementIsReady(driver,1000,closed);
			IsmsAuditCloseMandatory_page_pageLog.info("Navigated to closed tab");
			Thread.sleep(1000);
			driver.findElement(filter).clear();
			Thread.sleep(1000);
			driver.findElement(filter).sendKeys("open");
			IsmsAuditCloseMandatory_page_pageLog.info("Provided input for filter");
			Thread.sleep(1000);
			driver.findElement(filter).sendKeys(Keys.ENTER);
			IsmsAuditCloseMandatory_page_pageLog.info("Successfully filtered out the required record");
			Thread.sleep(1000);
			clickWhenElementIsReady(driver,20,details);
			IsmsAuditCloseMandatory_page_pageLog.info("Selected the required audit record");
			Thread.sleep(1000);
			clickWhenElementIsReady(driver,20,approve);
			IsmsAuditCloseMandatory_page_pageLog.info("Approving the audit to be closed");
			Thread.sleep(1000);
			clickWhenElementIsReady(driver,20,auditclose);
			IsmsAuditCloseMandatory_page_pageLog.info("Audit close option has been selected");
			Thread.sleep(1000);
			clickWhenElementIsReady(driver,20,save);
			IsmsAuditCloseMandatory_page_pageLog.info("Closure of the audit without any inputs");
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/*
	 * clicks 'OK' on mandatory input pop up and brings the control back to the current web page
	 */
	public void clickOk() throws Exception {
		try
		{
			Thread.sleep(1000);
			clickWhenElementIsReady(driver,20,ok);
			IsmsAuditCloseMandatory_page_pageLog.info("Mandatory field pop up has been closed");
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/*
	 * provides input for the assertion to validate the presence of required mandatory input message
	 */
	public boolean mandatoryPopup() throws Exception{
		return(driver.findElement(alert).isDisplayed());
	}
}
