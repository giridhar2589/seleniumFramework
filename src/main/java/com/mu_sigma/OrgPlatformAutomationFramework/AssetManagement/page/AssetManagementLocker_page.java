package com.mu_sigma.OrgPlatformAutomationFramework.AssetManagement.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;

public class AssetManagementLocker_page extends TestBase {

	WebDriver driver;

	private static final Logger AssetManagementLocker_page_pageLog = LogManager
			.getLogger(AssetManagementLocker_page.class.getName());

	By mstrDet = By.xpath("//a[contains(text(),'Master Details')]");

	By locker = By.xpath("//a[contains(text(),'Locker')]");

	By crtLocker = By.xpath("//div[contains(text(),'Create Locker')]");

	By levelSrch = By.xpath("//span[contains(@title,'List')]");

	By levelSel = By.xpath("//td[contains(text(),'Level: 14')]");

	By lckrnum = By.xpath("//input[contains(@label,'LockerNumber')]");
	
	By verify = By.xpath("");

	By save = By.xpath("//span[contains(text(),'Save')]");
	
	By mandPopUp = By.xpath("//div[contains(text(),'OK')]");

	By mandMsg = By.xpath("//pre[contains(text(),'mandatory')]");
	
	By LockerCancel = By.xpath("//span[contains(text(),'Cancel')]");

	public AssetManagementLocker_page(WebDriver driver) {
		this.driver = driver;
	}

	/*
	 * This method check for duplicate locker provided by excel sheet
	 */
	public void addLocker(String lockernum) throws Exception {
		try {
			Thread.sleep(1000);
			clickWhenElementIsReady(driver, 10, mstrDet);
			AssetManagementLocker_page_pageLog.info("Master details module is seleceted");
			Thread.sleep(1000);
			clickWhenElementIsReady(driver, 10, locker);
			AssetManagementLocker_page_pageLog.info("Locker sub module has been selected");
			Thread.sleep(1000);
			clickWhenElementIsReady(driver, 10, crtLocker);
			AssetManagementLocker_page_pageLog.info("create locker option has been selected");
			Thread.sleep(1000);
			clickWhenElementIsReady(driver, 10, levelSrch);
			AssetManagementLocker_page_pageLog.info("Level search option has been selected");
			Thread.sleep(1000);
			clickWhenElementIsReady(driver, 10, levelSel);
			AssetManagementLocker_page_pageLog.info("Level has been selected");
			Thread.sleep(2000);
			waitForElement(lckrnum, 10);
			driver.findElement(lckrnum).sendKeys(lockernum);
			AssetManagementLocker_page_pageLog.info("Input for locker number has been given");
			Thread.sleep(1000);
			clickWhenElementIsReady(driver, 10, save);
			AssetManagementLocker_page_pageLog.info("A new locker has not been created");
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clkOk() throws Exception {
		// TODO Auto-generated method stub
		Thread.sleep(500);
		waitForElement(mandPopUp, 10);
		clickWhenElementIsReady(driver, 10, mandPopUp);
		AssetManagementLocker_page_pageLog.info("OK has been selected on mandatory pop up");
		clickWhenElementIsReady(driver, 10, LockerCancel);
		AssetManagementLocker_page_pageLog.info("Clicked on Cancel Button");
	}

}
