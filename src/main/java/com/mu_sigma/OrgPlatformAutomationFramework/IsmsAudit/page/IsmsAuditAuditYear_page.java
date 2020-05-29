package com.mu_sigma.OrgPlatformAutomationFramework.IsmsAudit.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;

public class IsmsAuditAuditYear_page extends TestBase{
	
	WebDriver driver;
	
	private static final Logger IsmsAuditAuditYear_page_pageLog = LogManager
			.getLogger(IsmsAuditAuditYear_page.class.getName());
	
	By settings = By.xpath("//a[contains(text(),'Settings')]");
	
	By audityear = By.xpath("//a[contains(text(),'Audit Year')]");

	By addyear = By.xpath("//div[contains(text(),'Add Year')]");
	
	By yearselect = By.xpath("//select[contains(@label,'Year')]");
	
	By save = By.xpath("//span[contains(text(),'Save')]");
	
	By details = By.xpath("//td[contains(@class,' tablesaw-priority-1')]");
	
	By ok = By.xpath("//div[text()='OK']");
	
	By cancel = By.xpath("//span[text()='Cancel']");

		
	public IsmsAuditAuditYear_page(WebDriver driver) {
		this.driver = driver;
	}
	
	/*
	 * Navigates to the audit year tab and adds a selected year
	 */  
	public void selectAuditYear(String yearaudit) throws Exception {
		try
		{
			Thread.sleep(1000);
			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(settings)).perform();
			IsmsAuditAuditYear_page_pageLog.info("Mouse over to settings tab");
			Thread.sleep(1000);
			clickWhenElementIsReady(driver,20,audityear);
			IsmsAuditAuditYear_page_pageLog.info("Selected audit year tab");
			Thread.sleep(1000);
			clickWhenElementIsReady(driver,20,addyear);
			IsmsAuditAuditYear_page_pageLog.info("Selected add year option");
			Thread.sleep(2000);
			waitForElement(yearselect, 20);
			driver.findElement(yearselect).click();
			IsmsAuditAuditYear_page_pageLog.info("Year drop down list");
			Select audityearSelect=new Select(driver.findElement(yearselect));
			Thread.sleep(1000);
			audityearSelect.selectByVisibleText(yearaudit);
			IsmsAuditAuditYear_page_pageLog.info("Required year selected");
			Thread.sleep(500);
			clickWhenElementIsReady(driver,20,save);
			IsmsAuditAuditYear_page_pageLog.info("Audit year has not been added");
			clickWhenElementIsReady(driver,20,ok);
			IsmsAuditAuditYear_page_pageLog.info("Mandatory displayed and Clicked on OK");
			clickWhenElementIsReady(driver,20,cancel);
			IsmsAuditAuditYear_page_pageLog.info("Returned to Audit Year Page");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/*
	 * Provides input to the assertion to validate the presence of added year 
	 */
	public boolean auditYearAdded(){
		return(driver.findElement(details).isDisplayed());
	}

}
