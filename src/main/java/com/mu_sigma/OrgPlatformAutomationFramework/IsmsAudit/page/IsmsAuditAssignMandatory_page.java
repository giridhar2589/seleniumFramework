package com.mu_sigma.OrgPlatformAutomationFramework.IsmsAudit.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;

public class IsmsAuditAssignMandatory_page extends TestBase {
	
	WebDriver driver;
	
	private static final Logger IsmsAuditAssignMandatory_page_pageLog = LogManager
			.getLogger(IsmsAuditAssignMandatory_page.class.getName());
	
	By assignTab = By.xpath("//a[contains(text(),'Assigned')]");
	
	By filter = By.xpath("//div[span[contains(text(),'Filter')]]/input");
	
	By details = By.xpath("//div[contains(@class,'bza_al_dc')]/table/tbody/tr/td/table/tbody/tr[1]//a[contains(text(),'Details')]");
	
	By modify = By.xpath("//span[contains(text(),'Update')]");
	
	By submit = By.xpath("//span[contains(text(),'Submit')]");
	
	By alert = By.xpath("//span[contains(text(),'Information')]");
	
	By ok = By.xpath("//div[contains(text(),'OK')]");
	
	public IsmsAuditAssignMandatory_page(WebDriver driver) {
		this.driver = driver;
	}
	
	/*
	 * Navigates to the assigned tab and tries to submit the selected audit finding without any inputs for mandatory fields
	 */
	public void navigateAssignMand() throws Exception {
		try
		{
			Thread.sleep(500);
			clickWhenElementIsReady(driver,20,assignTab);
			IsmsAuditAssignMandatory_page_pageLog.info("Navigated to assigned tab");
			Thread.sleep(500);
			driver.findElement(filter).clear();
			Thread.sleep(500);
			driver.findElement(filter).sendKeys(Keys.ENTER);
			IsmsAuditAssignMandatory_page_pageLog.info("Navigated to assigned tab");
			Thread.sleep(1000);
			clickWhenElementIsReady(driver,20,details);
			IsmsAuditAssignMandatory_page_pageLog.info("Selected the required record");
			Thread.sleep(500);
			clickWhenElementIsReady(driver,20,modify);
			IsmsAuditAssignMandatory_page_pageLog.info("Clicked on Upadte option");
			Thread.sleep(500);
			clickWhenElementIsReady(driver,20,submit);
			IsmsAuditAssignMandatory_page_pageLog.info("Clicked on Submit Button");
			Thread.sleep(500);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/*
	 * Clicks 'OK' on the mandatory fields pop up to bring the control back to the current web page
	 */
	public void clickOk() throws Exception {
		try
		{
			Thread.sleep(1000);
			driver.findElement(alert).isDisplayed();
			IsmsAuditAssignMandatory_page_pageLog.info("Mandatory pop-up displayed");
			Thread.sleep(500);
			clickWhenElementIsReady(driver,20,ok);
			IsmsAuditAssignMandatory_page_pageLog.info("Closed the mandatory input pop up");
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/*
	 * Provides the input for the assertion to validate the presence of 'mandatory fields should be filled' message
	 
	public boolean mandatoryPopup() throws Exception{
		return(driver.findElement(alert).isDisplayed());
	}
	 */ 
}
