package com.mu_sigma.OrgPlatformAutomationFramework.AssetManagement.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;

public class AssetManagementLevel_page extends TestBase {

	WebDriver driver;

	private static final Logger AssetManagementLevel_page_pageLog = LogManager
			.getLogger(AssetManagementLevel_page.class.getName());

	By mstrDet = By.xpath("//a[contains(text(),'Master Details')]");
	
	By level = By.xpath("//a[contains(text(),'Level')]");

	By crtlevel = By.xpath("//div[contains(text(),'Create Level')]");

	By levelval = By.xpath("//input[@label='Level']");

	By save = By.xpath("//span[contains(text(),'Save')]");
	
	By mandPopUp = By.xpath("//div[contains(text(),'OK')]");
	
	By LevelCancel = By.xpath("//span[contains(text(),'Cancel')]");


	public AssetManagementLevel_page(WebDriver driver) {
		this.driver = driver;
	}

	/*
	 * This method will add the new level provided by excel sheet
	 */
	public void CantaddDuplicateLevel(String levelVal) throws Exception {
		try {
			Thread.sleep(1000);
			clickWhenElementIsReady(driver, 10, mstrDet);
			AssetManagementLevel_page_pageLog.info("Master details module is seleceted");
			Thread.sleep(1000);
			clickWhenElementIsReady(driver, 10, level);
			AssetManagementLevel_page_pageLog.info("Level sub module has been selected");
			Thread.sleep(1000);
			clickWhenElementIsReady(driver, 10, crtlevel);
			AssetManagementLevel_page_pageLog.info("create level option has been selected");
			Thread.sleep(2000);
			waitForElement(levelval, 10);
			driver.findElement(levelval).sendKeys(levelVal);
			AssetManagementLevel_page_pageLog.info("Input for assets level has been given");
			Thread.sleep(1000);
			clickWhenElementIsReady(driver, 10, save);
			AssetManagementLevel_page_pageLog.info("Clicked on Save");
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
		AssetManagementLevel_page_pageLog.info("OK has been selected on mandatory pop up");
		Thread.sleep(1000);
		clickWhenElementIsReady(driver, 10, LevelCancel);
		AssetManagementLevel_page_pageLog.info("Clicked on Cancel Button");
	}

	public boolean assetLevelCreated() {
		waitForElement(levelval, 10);
		return (driver.findElement(levelval).isDisplayed());
	}

}
