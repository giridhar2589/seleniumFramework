package com.mu_sigma.OrgPlatformAutomationFramework.IsmsAudit.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;

public class IsmsAuditOpenMandatory_page extends TestBase {
	
	WebDriver driver;
	
	private static final Logger IsmsAuditOpenMandatory_page_pageLog = LogManager
			.getLogger(IsmsAuditOpenMandatory_page.class.getName());
	
	By openTab = By.xpath("//a[contains(text(),'Open')]");
	
	By filter = By.xpath("//div[span[contains(text(),'Filter')]]/input");
	
	By details = By.xpath("//div[contains(@class,'bza_al_dc')]/table/tbody/tr/td/table/tbody/tr[1]//a[contains(text(),'Details')]");
	
	By close = By.xpath("//span[contains(text(),'Update Evidence/Comment')]");
	
	By save = By.xpath("//span[contains(text(),'Save')]");
	
	By alert = By.xpath("//pre[contains(text(),'mandatory field')]");
	
	By ok = By.xpath("//div[contains(text(),'OK')]");
	
	public IsmsAuditOpenMandatory_page(WebDriver driver) {
		this.driver = driver;
	}
	
	/*
	 * Navigates to the open tab and tries to close an audit by without providing any inputs
	 */
	public void navigateOpenMand() throws Exception {
		try
		{
			Thread.sleep(500);
			clickWhenElementIsReady(driver,20,openTab);
			IsmsAuditOpenMandatory_page_pageLog.info("Navigated to open tab");
			Thread.sleep(500);
			driver.findElement(filter).clear();
			Thread.sleep(500);
			driver.findElement(filter).sendKeys(Keys.ENTER);
			IsmsAuditOpenMandatory_page_pageLog.info("Provided input for the filter");
			Thread.sleep(1000);
			clickWhenElementIsReady(driver,20,details);
			IsmsAuditOpenMandatory_page_pageLog.info("Required audit number has been filtered out");
			Thread.sleep(500);
			clickWhenElementIsReady(driver,20,close);
			IsmsAuditOpenMandatory_page_pageLog.info("Selected the close option");
			Thread.sleep(500);
			clickWhenElementIsReady(driver,20,save);
			IsmsAuditOpenMandatory_page_pageLog.info("Audit closure has been performed without any input");
			Thread.sleep(500);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/*
	 * Clicks 'OK' on the pop up and navigates the control back to the current web page
	 */
	public void clickOk() throws Exception {
		try
		{
			Thread.sleep(500);
			clickWhenElementIsReady(driver,20,ok);
			IsmsAuditOpenMandatory_page_pageLog.info("Mandatory inputs pop up has been close");
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/*
	 * Provides input to assertions to validate the presence of mandatory field message
	 */
	public boolean mandatoryPopup() throws Exception{
		return(driver.findElement(alert).isDisplayed());
	}

}
