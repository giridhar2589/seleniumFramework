package com.mu_sigma.OrgPlatformAutomationFramework.AssetManagement.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;

public class AssetManagementLockerMandatory_page extends TestBase{
	
	WebDriver driver;

	private static final Logger AssetManagementLockerMandatory_page_pageLog = LogManager
			.getLogger(AssetManagementLockerMandatory_page.class.getName());
	
	By mstrDet = By.xpath("//a[contains(text(),'Master Details')]");

	By locker = By.xpath("//a[contains(text(),'Locker')]");

	By crtLocker = By.xpath("//div[contains(text(),'Create Locker')]");

	By save = By.xpath("//span[contains(text(),'Save')]");
	
	By mandText = By.xpath("//pre");
	
	By okClk = By.xpath("//div[contains(text(),'OK')]");
	
	public AssetManagementLockerMandatory_page(WebDriver driver) {
		this.driver = driver;
	}

	/*
	 * This method will verify the validation for the mandatory fields to create lockers
	 */
	public void addLockerMandatory() throws Exception {
		try {
			Thread.sleep(1000);
			clickWhenElementIsReady(driver, 10, mstrDet);
			AssetManagementLockerMandatory_page_pageLog.info("Master details module is seleceted");
			Thread.sleep(1000);
			clickWhenElementIsReady(driver, 10, locker);
			AssetManagementLockerMandatory_page_pageLog.info("Locker sub module has been selected");
			Thread.sleep(1000);
			clickWhenElementIsReady(driver, 10, crtLocker);
			AssetManagementLockerMandatory_page_pageLog.info("create locker option has been selected");
			Thread.sleep(2000);
			clickWhenElementIsReady(driver, 10, save);
			AssetManagementLockerMandatory_page_pageLog.info("A new locker has been created");
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean lockerCreatedMand() {
		waitForElement(mandText, 10);
		return (driver.findElement(mandText).isDisplayed());
	}
	
	/*
	 * This method clicks OK option on mandatory pop up
	 */
	public void clkOk() throws Exception {
		//Thread.sleep(2000);
		clickWhenElementIsReady(driver, 10, okClk);
		AssetManagementLockerMandatory_page_pageLog.info("Ok option has been selected on mandatory pop up");
		//Thread.sleep(1000);
	}	
}