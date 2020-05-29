package com.mu_sigma.OrgPlatformAutomationFramework.AssetManagement.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;

public class AssetManagementAssetRecoverCon_page extends TestBase{
	
WebDriver driver;
	
	private static final Logger AssetManagementAssetRecoverCon_page_pageLog = LogManager
			.getLogger(AssetManagementAssetRecoverCon_page.class.getName());
	
	By assAstType = By.xpath("//input[contains(@label,'AssetType.Name')]");
	
	By adnDet = By.xpath("//a[contains(text(),'Admin Details')]");
	
	By astRecd = By.xpath("//a[contains(text(),'Assets Recovered')]");
	
	By assetTypSrch = By.xpath("//tr[2]/td[7]/input");
	
	By astTypFltr = By.xpath("//th[contains(text(),'Asset Type')]");
	
	By assetfltrd = By.xpath("//tr[3]/td[7]");
	
	public AssetManagementAssetRecoverCon_page(WebDriver driver) {
		this.driver = driver;
	}
	
	/*
	 * This method will confirm the assets recover  
	 */
	
	public boolean asstRecoverCon() throws Exception{
		String assetType = null;
		try
		{
			Thread.sleep(1000);
		    assetType = driver.findElement(assAstType).getAttribute("value");
		    AssetManagementAssetRecoverCon_page_pageLog.info("Recovered asset type value has been captured");
			Thread.sleep(1000);
			clickWhenElementIsReady(driver, 10, adnDet);
			AssetManagementAssetRecoverCon_page_pageLog.info("Admin details module has been selected");
			Thread.sleep(1000);
			clickWhenElementIsReady(driver, 10, astRecd);
			AssetManagementAssetRecoverCon_page_pageLog.info("Assets recovered sub module has been selected");
			Thread.sleep(1000);
			driver.findElement(assetTypSrch).sendKeys(assetType);
			AssetManagementAssetRecoverCon_page_pageLog.info("Recovered asset type value has been provided to filetr");
			Thread.sleep(1000);
			clickWhenElementIsReady(driver, 10, astTypFltr);
			AssetManagementAssetRecoverCon_page_pageLog.info("Requiered asset record has been filtered");
			Thread.sleep(1000);
		} catch (Exception e) {
		  e.printStackTrace();
		}
		
		return(driver.findElement(assetfltrd).getText().contains(assetType));
	}
}
