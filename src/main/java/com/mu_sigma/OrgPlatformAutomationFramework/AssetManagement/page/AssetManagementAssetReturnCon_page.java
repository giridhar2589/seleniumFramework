package com.mu_sigma.OrgPlatformAutomationFramework.AssetManagement.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;

public class AssetManagementAssetReturnCon_page extends TestBase{
	
	WebDriver driver;
	
	private static final Logger AssetManagementAssetReturnCon_page_pageLog = LogManager
			.getLogger(AssetManagementAssetReturnCon_page.class.getName());
	
	By assAstType = By.xpath("//input[contains(@label,'AssetType.Name')]");
	
	By adnDet = By.xpath("//a[contains(text(),'Admin Details')]");
	
	By astRetd = By.xpath("//a[contains(text(),'Assets Returned')]");
	
	By assetTypSrch = By.xpath("//tr[2]/td[6]/input");
	
	By astTypFltr = By.xpath("//th[contains(text(),'Asset Type')]");
	
	By assetfltrd = By.xpath("//tr[3]/td[6]");
	
	public AssetManagementAssetReturnCon_page(WebDriver driver) {
		this.driver = driver;
	}
	
	/*
	 * This method will confirm the assets return 
	 */
	
	public boolean asstReturnCon() throws Exception{
		String assetType = null;
		try
		{
			Thread.sleep(1000);
		    assetType = driver.findElement(assAstType).getAttribute("value");
		    AssetManagementAssetReturnCon_page_pageLog.info("Returned asset type value has been captured");
			Thread.sleep(1000);
			clickWhenElementIsReady(driver, 10, adnDet);
			AssetManagementAssetReturnCon_page_pageLog.info("Admin details module has been selected");
			Thread.sleep(1000);
			clickWhenElementIsReady(driver, 10, astRetd);
			AssetManagementAssetReturnCon_page_pageLog.info("Assets returned sub module has been selected");
			Thread.sleep(1000);
			driver.findElement(assetTypSrch).sendKeys(assetType);
			AssetManagementAssetReturnCon_page_pageLog.info("Returned asset type value has been provided to filetr");
			Thread.sleep(1000);
			clickWhenElementIsReady(driver, 10, astTypFltr);
			AssetManagementAssetReturnCon_page_pageLog.info("Requiered asset record has been filtered");
			Thread.sleep(1000);
		} catch (Exception e) {
		  e.printStackTrace();
		}
		
		return(driver.findElement(assetfltrd).getText().contains(assetType));
	}

}
