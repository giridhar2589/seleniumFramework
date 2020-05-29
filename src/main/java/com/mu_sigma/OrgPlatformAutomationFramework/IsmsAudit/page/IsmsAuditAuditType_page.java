package com.mu_sigma.OrgPlatformAutomationFramework.IsmsAudit.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;

public class IsmsAuditAuditType_page extends TestBase {

	WebDriver driver;
	
	private static final Logger IsmsAuditAuditType_page_pageLog = LogManager
			.getLogger(IsmsAuditAuditType_page.class.getName());
	By settings = By.xpath("//a[contains(text(),'Settings')]");
	
	By audittype = By.xpath("//a[contains(text(),'Audit Type')]");
	
	
	By selaudittype = By.xpath("//select[contains(@label,'AuditType')]");
	
	By save = By.xpath("//span[contains(text(),'Save')]");
	
	By details = By.xpath("//div[contains(text(),'View Details')]");
	
	By addaudittype = By.xpath("//div[contains(text(),'Add Audit')]");
	
	By ok = By.xpath("//div[contains(text(),'OK')]");
	
	By cancel = By.xpath("//span[text()='Cancel']");
	
	public IsmsAuditAuditType_page(WebDriver driver) {
		this.driver = driver;
	}
	
	/*
	 * Adds new audit type by selecting it from the drop down list which was provided as an input from excel sheet 
	 */
	public void selectAudittype(String newaudittype) throws Exception {
		try
		{
			//select component for text inputs
			//Thread.sleep(500);
			Actions action = new Actions(driver);
			Thread.sleep(2000);
			action.moveToElement(driver.findElement(settings)).perform();
			IsmsAuditAuditType_page_pageLog.info("Mouse over to settings tab");
			Thread.sleep(4000);
			clickWhenElementIsReady(driver,20,audittype);
			IsmsAuditAuditType_page_pageLog.info("Selected audit type tab");
			Thread.sleep(2000);
			clickWhenElementIsReady(driver,500,addaudittype);
			Thread.sleep(2000);
			//waitForElement(addaudittype, 80);
			Thread.sleep(1000);
			//driver.findElement(selaudittype).click();
			Thread.sleep(2000);
			IsmsAuditAuditType_page_pageLog.info("Navigated to add Audit type tab");
			Select auditSelect=new Select(driver.findElement(selaudittype));
			Thread.sleep(1000);
			auditSelect.selectByVisibleText(newaudittype);
			IsmsAuditAuditType_page_pageLog.info("Selected required audit type");
			Thread.sleep(1000);
			clickWhenElementIsReady(driver,1000,save);
			IsmsAuditAuditType_page_pageLog.info("Selected audit type has not been created");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	
	/*
	 * Provides the input for the assertion to verify the audit type addition
	 */
	public boolean auditAdded(){
		return(driver.findElement(details).isDisplayed());
	}

	public void clickOk() {
		// TODO Auto-generated method stub
		try
		{
			Thread.sleep(500);
			clickWhenElementIsReady(driver,20,ok);
			IsmsAuditAuditType_page_pageLog.info("Closing the mandatory field pop up");
			Thread.sleep(1000);
			clickWhenElementIsReady(driver,20, cancel);
			IsmsAuditAuditType_page_pageLog.info("Clicked on Cancel option and returned to Previous Page");
			Thread.sleep(500);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
