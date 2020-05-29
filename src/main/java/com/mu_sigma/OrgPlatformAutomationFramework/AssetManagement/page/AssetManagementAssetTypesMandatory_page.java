package com.mu_sigma.OrgPlatformAutomationFramework.AssetManagement.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;

public class AssetManagementAssetTypesMandatory_page extends TestBase {

	WebDriver driver;

	private static final Logger AssetManagementAssetTypesMandatory_page_pageLog = LogManager
			.getLogger(AssetManagementAssetTypesMandatory_page.class.getName());
	
	By mstrDet = By.xpath("//a[contains(text(),'Master Details')]");

	By assetTypes = By.xpath("//a[contains(text(),'Asset Types')]");

	By crtAsstType = By.xpath("//div[contains(text(),'Create Asset Type')]");
	
	By addType = By.xpath("//span[contains(text(),'Save')]");
	
	By mandPopUp = By.xpath("//div[contains(text(),'OK')]");
	
	By mandMsg = By.xpath("//pre[contains(text(),'mandatory')]");
	
	By asstCancel = By.xpath("//span[contains(text(),'Cancel')]");
	
	public AssetManagementAssetTypesMandatory_page(WebDriver driver) {
		this.driver = driver;
	}
	
	/*
	 * This method will verify the mandatory field validation for asset type field
	 */
	public void addAssetTypeMand() throws Exception {
		try {
			Thread.sleep(1000);
			clickWhenElementIsReady(driver, 10, mstrDet);
			AssetManagementAssetTypesMandatory_page_pageLog.info("Master details module is seleceted");
			Thread.sleep(1000);
			clickWhenElementIsReady(driver, 10, assetTypes);
			AssetManagementAssetTypesMandatory_page_pageLog.info("Asset types sub module has been selected");
			Thread.sleep(1000);
			clickWhenElementIsReady(driver, 10, crtAsstType);
			AssetManagementAssetTypesMandatory_page_pageLog.info("create asset type option has been selected");
			Thread.sleep(1000);
			clickWhenElementIsReady(driver, 10, addType);
			AssetManagementAssetTypesMandatory_page_pageLog.info("Save option has been selected for asset type creation");
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean assetTypeCreatedMand() {
		waitForElement(mandMsg, 10);
		return (driver.findElement(mandMsg).isDisplayed());
	}
	
	public void clkOk() throws Exception{
		Thread.sleep(1000);
		clickWhenElementIsReady(driver, 10, mandPopUp);
		AssetManagementAssetTypesMandatory_page_pageLog.info("Ok option has been selected on mandatory pop up");
		Thread.sleep(2000);
		clickWhenElementIsReady(driver, 10, asstCancel);
		AssetManagementAssetTypesMandatory_page_pageLog.info("Clicked on Cancel Button");
	}
}
