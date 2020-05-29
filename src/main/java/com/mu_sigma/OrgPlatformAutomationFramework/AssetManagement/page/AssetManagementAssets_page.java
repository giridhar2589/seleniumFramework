package com.mu_sigma.OrgPlatformAutomationFramework.AssetManagement.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;


public class AssetManagementAssets_page extends TestBase {

	WebDriver driver;

	private static final Logger AssetManagementAssets_page_pageLog = LogManager
			.getLogger(AssetManagementAssets_page.class.getName());

	By mstrDet = By.xpath("//a[contains(text(),'Master Details')]");


	By assets = By.xpath("//a[text()='Assets']");

	By crtAsset = By.xpath("//div[contains(text(),'Create Asset')]");
	
	By asstName = By.xpath("//input[contains(@label,'Name')]");

	By asstSave = By.xpath("//span[contains(text(),'Save')]");
	
	By asstCancel = By.xpath("//span[contains(text(),'Cancel')]");

	By logouticon = By.xpath("//i[contains(@class,'fa-bars')]");

	By logout = By.xpath ("//div[contains(text(),'Logout')]");

	By mandPopUp = By.xpath("//div[contains(text(),'OK')]");

	By mandMsg = By.xpath("//pre[contains(text(),'mandatory')]");

	public AssetManagementAssets_page(WebDriver driver) {
		this.driver = driver;
	}

	/*
	 * This method will add the new asset provided by excel sheet
	 */
	public void addAsset(String asstname) throws Exception {
		try {
			Thread.sleep(1000);
			clickWhenElementIsReady(driver, 10, mstrDet);
			AssetManagementAssets_page_pageLog.info("Master details module is seleceted");
			Thread.sleep(1000);
			clickWhenElementIsReady(driver, 10, assets);
			AssetManagementAssets_page_pageLog.info("Assets sub module has been selected");
			Thread.sleep(1000);
			clickWhenElementIsReady(driver, 10, crtAsset);
			AssetManagementAssets_page_pageLog.info("create asset option has been selected");
			Thread.sleep(2000);
			waitForElement(asstName, 10);
			driver.findElement(asstName).sendKeys(asstname);
			Thread.sleep(1000);
			clickWhenElementIsReady(driver, 10, asstSave);
			AssetManagementAssets_page_pageLog.info("Clicked on Save");
			
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		

	public void clkOk() throws Exception {
		// TODO Auto-generated method stub
		Thread.sleep(500);
		waitForElement(mandPopUp, 10);
		clickWhenElementIsReady(driver, 10, mandPopUp);
		AssetManagementAssets_page_pageLog.info("OK has been selected on mandatory pop up");
		clickWhenElementIsReady(driver, 10, asstCancel);
		AssetManagementAssets_page_pageLog.info("Clicked on Cancel Button");
	}
	

	/*
	 * Logout function for asset management app
	 */
	public void assetLogOut() throws Exception {
		Thread.sleep(2000);
		waitForElement(logouticon, 10);
		clickWhenElementIsReady(driver, 2000, logouticon);
		AssetManagementAssets_page_pageLog.info("Clicked on user menu");
		Thread.sleep(2000);
		waitForElement(logout, 10);
		clickWhenElementIsReady(driver, 2000, logout);
		AssetManagementAssets_page_pageLog.info("Logged out from the Application");
	}

	public boolean assetCreated() {
		waitForElement(asstName, 10);
		return (driver.findElement(asstName).isDisplayed());
	}
}
