package com.mu_sigma.OrgPlatformAutomationFramework.AssetManagement.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;

public class AssetManagementAssetReqMand_page extends TestBase {

	WebDriver driver;

	private static final Logger AssetManagementAssetReqMand_page_pageLog = LogManager
			.getLogger(AssetManagementAssetReqMand_page.class.getName());

	By asstReq = By.xpath("//div[contains(text(),'Asset Request')]");
	
	By subReq = By.xpath("//span[contains(text(),'Submit Request')]");
	
	By mandMsg = By.xpath("//pre");

	By clkOk = By.xpath("//div[contains(text(),'OK')]");

	public AssetManagementAssetReqMand_page(WebDriver driver) {
		this.driver = driver;
	}

	/*
	 * This method will validate the mandatory field validation for new asset
	 * request
	 */
	public void assetReqMand() throws Exception {
		Thread.sleep(2000);
		clickWhenElementIsReady(driver, 10, asstReq);
		AssetManagementAssetReqMand_page_pageLog.info("Asset request option has been selected");
		Thread.sleep(3000);
		clickWhenElementIsReady(driver, 10, subReq);
		AssetManagementAssetReqMand_page_pageLog.info("Asset request submit option has been selected");
		Thread.sleep(3000);
	}

	/*
	 * This method will verify the presence of mandatory message for new asset
	 * request
	 */
	public boolean assetCrtMand() {
		waitForElement(mandMsg, 10);
		return (driver.findElement(mandMsg).isDisplayed());
	}

	/*
	 * This method will select OK the mandatory pop up
	 */
	public void clkOk() throws Exception {
		Thread.sleep(3000);
		clickWhenElementIsReady(driver, 10, clkOk);
		Thread.sleep(3000);
		AssetManagementAssetReqMand_page_pageLog.info("OK option has been selecetd on the pop up");
	}

}
