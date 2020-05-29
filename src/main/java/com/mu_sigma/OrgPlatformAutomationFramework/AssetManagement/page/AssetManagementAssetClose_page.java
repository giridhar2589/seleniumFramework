package com.mu_sigma.OrgPlatformAutomationFramework.AssetManagement.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;

public class AssetManagementAssetClose_page extends TestBase{
	
	WebDriver driver;
	
	private static final Logger AssetManagementAssetClose_page_pageLog = LogManager
			.getLogger(AssetManagementAssetClose_page.class.getName());
	
	By assAstType = By.xpath("//input[contains(@label,'AssetType.Name')]");
	
	By assAssigned = By.xpath("//a[contains(text(),'Assets Assigned')]");
	
	By assetTypSrch = By.xpath("//tr[1]/td[5]/input");
	
	By astTypFltr = By.xpath("//th[contains(text(),'Asset Type')]");
	
	By assetfltrd = By.xpath("//tr[2]/td[5]");
	
	By assetSel = By.xpath("//tr[2]/td[contains(@class,'priority-1')]");
	
	By assetCls = By.xpath("//span[contains(text(),'Close Request')]");
	
	By asstClsRsn = By.xpath("//textarea[contains(@label,'Comment')]");
	
	By asstSav = By.xpath("//span[contains(text(),'Save')]");
	
	public AssetManagementAssetClose_page(WebDriver driver) {
		this.driver = driver;
	}
	
	/*
	 * Method to close the assigned locker to an user
	 */
	public void asstClose(String reason) throws Exception{
		String assetType = null;
		try
		{
			Thread.sleep(1000);
		    assetType = driver.findElement(assAstType).getAttribute("value");
			AssetManagementAssetClose_page_pageLog.info("Processed asset type value has been captured");
			Thread.sleep(1000);
			clickWhenElementIsReady(driver, 10, assAssigned);
			AssetManagementAssetClose_page_pageLog.info("Assets assigned module has been selected");
			Thread.sleep(1000);
			driver.findElement(assetTypSrch).clear();
			Thread.sleep(1000);
			driver.findElement(assetTypSrch).sendKeys(assetType);
			AssetManagementAssetClose_page_pageLog.info("Assigned asset type value has been provided to filetr");
			Thread.sleep(3000);
			clickWhenElementIsReady(driver, 10, astTypFltr);
			AssetManagementAssetClose_page_pageLog.info("Requiered asset record has been filtered");
			Thread.sleep(3000);
			clickWhenElementIsReady(driver, 10, assetSel);
			AssetManagementAssetClose_page_pageLog.info("Requiered asset record has been selected");
			Thread.sleep(1000);
			clickWhenElementIsReady(driver, 10, assetCls);
			AssetManagementAssetClose_page_pageLog.info("Asset close option has been selected");
			//driver.findElement(asstClsRsn).clear();
			Thread.sleep(1000);
			driver.findElement(asstClsRsn).sendKeys(reason);
			AssetManagementAssetClose_page_pageLog.info("closing reason has been provided");
			Thread.sleep(1000);
			clickWhenElementIsReady(driver, 10, asstSav);
			AssetManagementAssetClose_page_pageLog.info("Save option to close the asset has been selected");
			Thread.sleep(1000);
			
		} catch (Exception e) {
		  e.printStackTrace();
		}
	}

}