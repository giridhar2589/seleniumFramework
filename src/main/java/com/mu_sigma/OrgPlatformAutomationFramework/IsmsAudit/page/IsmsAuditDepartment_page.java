package com.mu_sigma.OrgPlatformAutomationFramework.IsmsAudit.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;

public class IsmsAuditDepartment_page extends TestBase {

	WebDriver driver;
	
	private static final Logger IsmsAuditDepartment_page_pageLog = LogManager
			.getLogger(IsmsAuditDepartment_page.class.getName());
	
	By settings = By.xpath("//a[contains(text(),'Settings')]");
	
	By dept = By.xpath("//a[contains(text(),'Department')]");
	
	By createDept = By.xpath("//div[contains(text(),'Create Department')]");
	
	By searchIcon = By.xpath("//span[contains(@title,'Select from Available List')][2]");
	
	By deptSelect = By.xpath("//input[@id='MuSigma1cc5f9:EAppPoint58921:-1']");
	
	By deprtName = By.xpath("//tbody/tr[2]/td[3]");
	
	By Pspocsearch = By.xpath("//span[contains(@title,'Select from Available List')][3]");
	
	By Pspoc = By.xpath("//input[@id='MuSigma11633701:AppPoint1231:-1']");
	
	By deptAdd = By.xpath("//span[contains(text(),'Add')]");
	
	By deptSave = By.xpath("//span[contains(text(),'Save')]");
	
	By tableSearch = By.xpath("//td[contains(@class,'tablesaw-priority-1')]/input");
	
	By tableValue = By.xpath("//tr[contains(@class,'gfr')]/td/span");
	
	By modify = By.xpath("//span[contains(text(),'Modify')]");
	
	By deptValue = By.xpath("//input[contains(@label,'Account.Name')]");
	
	public IsmsAuditDepartment_page(WebDriver driver) {
		this.driver = driver;
	}
	
	/*
	 * Navigates to the department tab
	 */
	public void navigateDepatment() throws Exception {
		try
		{
			Thread.sleep(1000);
			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(settings)).perform();
			IsmsAuditDepartment_page_pageLog.info("Mouse over for settings tab");
			Thread.sleep(1000);
			clickWhenElementIsReady(driver,20,dept);
			IsmsAuditDepartment_page_pageLog.info("Navigated to the department tab");
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/*
	 * Selects a department from the available list to be added
	 */  
	public void addDepartment() throws Exception {
		try
		{
			Thread.sleep(500);
			clickWhenElementIsReady(driver,20,createDept);
			IsmsAuditDepartment_page_pageLog.info("Create department option has been selected");
			Thread.sleep(500);
			clickWhenElementIsReady(driver,20,searchIcon);
			IsmsAuditDepartment_page_pageLog.info("Department list has been selected");
			Thread.sleep(500);
			clickWhenElementIsReady(driver,20,deptSelect);
			IsmsAuditDepartment_page_pageLog.info("Select the department from the list");
			Thread.sleep(500);
			clickWhenElementIsReady(driver,20,deptAdd);
			IsmsAuditDepartment_page_pageLog.info("Department has been selected");
			Thread.sleep(500);
			clickWhenElementIsReady(driver,20,Pspocsearch);
			IsmsAuditDepartment_page_pageLog.info("Clicked on Spoc search");
			Thread.sleep(500);
			clickWhenElementIsReady(driver,20,Pspoc);
			IsmsAuditDepartment_page_pageLog.info("Spoc selected");
			Thread.sleep(500);
			clickWhenElementIsReady(driver,20,deptAdd);
			IsmsAuditDepartment_page_pageLog.info("Spoc has been added");
			//clickWhenElementIsReady(driver,20,deptSave);
			IsmsAuditDepartment_page_pageLog.info("Department has been added");
			Thread.sleep(500);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/*
	 * provides input for assertion to be validated for department addition
	 */ 
	public boolean deptCreated() throws Exception{
		return(driver.findElement(deptValue).isDisplayed());
	}
		
}
