package com.mu_sigma.OrgPlatformAutomationFramework.AssetManagement.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;

public class AssetManagementAssetsMandatory_page extends TestBase {

	WebDriver driver;

	private static final Logger AssetManagementAssetsMandatory_page_pageLog = LogManager
			.getLogger(AssetManagementAssetsMandatory_page.class.getName());

	By mstrDet = By.xpath("//a[contains(text(),'Master Details')]");

	By assets = By.xpath("//a[text()='Assets']");
	
	By crtAsset = By.xpath("//div[contains(text(),'Create Asset')]");

	By asstSave = By.xpath("//span[contains(text(),'Save')]");

	By mandPopUp = By.xpath("//div[contains(text(),'OK')]");

	By mandMsg = By.xpath("//pre[contains(text(),'mandatory')]");
	
    By userOptions = By.xpath("//i[contains(@class,'fa fa-bars')]");
	
	By logOut = By.xpath("//div[contains(text(),'Logout')]");
	
	By configure = By.xpath("//div[contains(text(),'Configure')]");
	
	By asstCancel = By.xpath("//span[contains(text(),'Cancel')]");

	public AssetManagementAssetsMandatory_page(WebDriver driver) {
		this.driver = driver;
	}

	/*
	 * This method will check the mandatory field validation for assets module
	 */
	public void addAssetMand() throws Exception {
		try {
			Thread.sleep(1000);
			clickWhenElementIsReady(driver, 10, mstrDet);
			AssetManagementAssetsMandatory_page_pageLog.info("Master details module is seleceted");
			Thread.sleep(1000);
			clickWhenElementIsReady(driver, 10, assets);
			AssetManagementAssetsMandatory_page_pageLog.info("Assets sub module has been selected");
			Thread.sleep(1000);
			clickWhenElementIsReady(driver, 10, crtAsset);
			AssetManagementAssetsMandatory_page_pageLog.info("create asset option has been selected");
			Thread.sleep(500);
			clickWhenElementIsReady(driver, 10, asstSave);
			AssetManagementAssetsMandatory_page_pageLog.info("Save option has been selected");
			Thread.sleep(500);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean assetCreatedMand() throws Exception {
		Thread.sleep(500);
		waitForElement(mandMsg, 10);
		return (driver.findElement(mandMsg).isDisplayed());
	}
	
	public void clkOk() throws Exception {
		Thread.sleep(500);
		waitForElement(mandPopUp, 10);
		clickWhenElementIsReady(driver, 10, mandPopUp);
		AssetManagementAssetsMandatory_page_pageLog.info("OK has been selected on mandatory pop up");
		Thread.sleep(1000);
		clickWhenElementIsReady(driver, 10, asstCancel);
		AssetManagementAssetsMandatory_page_pageLog.info("Clicked on Cancel Button");
	}
	

	public void logout() {
		// TODO Auto-generated method stub
		try
		{
			Thread.sleep(5000);
			waitForElement(userOptions, 10);
			clickWhenElementIsReady(driver, 2000,userOptions);
			AssetManagementAssetsMandatory_page_pageLog.info("User options drop down has been selected");
			Thread.sleep(1000);
			waitForElement(logOut, 10);
			clickWhenElementIsReady(driver, 2000, logOut);
			AssetManagementAssetsMandatory_page_pageLog.info("Logout option has been selected");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
