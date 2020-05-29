package com.mu_sigma.OrgPlatformAutomationFramework.AssetManagement.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;

public class AssetManagementAssetTypes_page extends TestBase {

	WebDriver driver;

	private static final Logger AssetManagementAssetTypes_page_pageLog = LogManager
			.getLogger(AssetManagementAssetTypes_page.class.getName());

	By mstrDet = By.xpath("//a[contains(text(),'Master Details')]");

	By assetTypes = By.xpath("//a[contains(text(),'Asset Types')]");
	
	By crtAsstType = By.xpath("//div[contains(text(),'Create Asset Type')]");

	By typeName = By.xpath("//input[@label='Name']");

	By srcList = By.xpath("//div/span[contains(@title,'List')]");

	By selType = By.xpath("//td[text()='Locker']");

	By addSel = By.xpath("//span[contains(text(),'Add')]");

	By addType = By.xpath("//span[contains(text(),'Save')]");
	
	By AssetTypeName = By.xpath("//td[contains(text(),'test')]");
	


	public AssetManagementAssetTypes_page(WebDriver driver) {
		this.driver = driver;
	}

	/*
	 * This method will add the new asset provided by excel sheet
	 */
	public void addAssetType(String assttype) throws Exception {
		try {
			Thread.sleep(5000);
			clickWhenElementIsReady(driver, 10, mstrDet);
			AssetManagementAssetTypes_page_pageLog.info("Master details module is seleceted");
			Thread.sleep(1000);
			clickWhenElementIsReady(driver, 10, assetTypes);
			AssetManagementAssetTypes_page_pageLog.info("Asset types sub module has been selected");
			Thread.sleep(1000);
			clickWhenElementIsReady(driver, 10, crtAsstType);
			AssetManagementAssetTypes_page_pageLog.info("create asset type option has been selected");
			Thread.sleep(2000);
			waitForElement(typeName, 10);
			driver.findElement(typeName).sendKeys(assttype);
			AssetManagementAssetTypes_page_pageLog.info("Input for asset type name has been given");
			Thread.sleep(1000);
			clickWhenElementIsReady(driver, 10, srcList);
			AssetManagementAssetTypes_page_pageLog.info("Search icon for asset has been clicked");
			Thread.sleep(1000);
			clickWhenElementIsReady(driver, 10, selType);
			AssetManagementAssetTypes_page_pageLog.info("Asset has been selected to be mapped");
			// Thread.sleep(1000);
			// waitForElement(addSel, 80);
			// addSel.click();
			// AssetManagementAssetTypes_page_pageLog.info("Selected asset has
			// been added to the field");
			//Thread.sleep(1000);
			clickWhenElementIsReady(driver, 10, addType);
			AssetManagementAssetTypes_page_pageLog.info("Asset type has been created");
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean assetTypeCreated() {
		waitForElement(AssetTypeName, 10);
		return (driver.findElement(AssetTypeName).isDisplayed());
	}
}
