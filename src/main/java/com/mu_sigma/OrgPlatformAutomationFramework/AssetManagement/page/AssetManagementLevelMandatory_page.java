package com.mu_sigma.OrgPlatformAutomationFramework.AssetManagement.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;

public class AssetManagementLevelMandatory_page extends TestBase {

	WebDriver driver;

	private static final Logger AssetManagementLevelMandatory_page_pageLog = LogManager
			.getLogger(AssetManagementLevelMandatory_page.class.getName());

	By mstrDet = By.xpath("//a[contains(text(),'Master Details')]");

	By level= By.xpath("//a[contains(text(),'Level')]");

	By crtlevel = By.xpath("//div[contains(text(),'Create Level')]");

	By save = By.xpath("//span[contains(text(),'Save')]");

	By mandPopup = By.xpath("//div[contains(text(),'OK')]");

	By mandMsg = By.xpath("//pre[contains(text(),'mandatory')]");
	
	By LevelCancel = By.xpath("//span[contains(text(),'Cancel')]");


	public AssetManagementLevelMandatory_page(WebDriver driver) {
		this.driver = driver;
	}

	/*
	 * This method will verify the mandatory field validation for level module
	 */
	public void addLevelMand() throws Exception {
		try {
			Thread.sleep(1000);
			clickWhenElementIsReady(driver, 10, mstrDet);
			AssetManagementLevelMandatory_page_pageLog.info("Master details module is seleceted");
			Thread.sleep(1000);
			clickWhenElementIsReady(driver, 10, level);
			AssetManagementLevelMandatory_page_pageLog.info("Level sub module has been selected");
			Thread.sleep(1000);
			clickWhenElementIsReady(driver, 10, crtlevel);
			AssetManagementLevelMandatory_page_pageLog.info("create level option has been selected");
			Thread.sleep(2000);
			clickWhenElementIsReady(driver, 10, save);
			AssetManagementLevelMandatory_page_pageLog.info("Save option has been selected");
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean assetLevelCreatedMand() {
		waitForElement(mandMsg, 10);
		return (driver.findElement(mandMsg).isDisplayed());
	}

	/*
	 * This method clicks OK option on mandatory pop up
	 */
	public void clkOk() throws Exception {
		//Thread.sleep(2000);
		clickWhenElementIsReady(driver, 10, mandPopup);
		AssetManagementLevelMandatory_page_pageLog.info("Ok option has been selected on mandatory pop up");
		Thread.sleep(1000);
		clickWhenElementIsReady(driver, 10, LevelCancel);
		AssetManagementLevelMandatory_page_pageLog.info("Clicked on Cancel Button");
		//Thread.sleep(1000);
	}
}
