package com.mu_sigma.OrgPlatformAutomationFramework.AssetManagement.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;

public class AssetManagementAssetProcessCon_page extends TestBase{

	WebDriver driver;

	private static final Logger AssetManagementAssetProcessCon_page_pageLog = LogManager
			.getLogger(AssetManagementAssetProcessCon_page.class.getName());
	
	By asstType = By.xpath("//input[contains(@label,'AssetType.Name')]");
	
	By adnDet = By.xpath("//a[contains(text(),'Admin Details')]");
	
	By inProsAsst = By.xpath("//a[contains(text(),'In-Process')]");

	By astTypSrch = By.xpath("//tr[2]/td[6]/input");
	
	By astTypFltr = By.xpath("//th[contains(text(),'Asset Type')]");
	
	By filtrdAsst = By.xpath("//tr[3]/td[6]");
	
	public AssetManagementAssetProcessCon_page(WebDriver driver) {
		this.driver = driver;
	}
	
	/*
	 * This method will confirm the asset under process 
	 */
	public boolean asstprocessd() throws Exception{
		String assetType = null;
		try
		{
			Thread.sleep(1000);
			assetType = driver.findElement(asstType).getAttribute("value");
			AssetManagementAssetProcessCon_page_pageLog.info("Processed asset type value has been captured");
			Thread.sleep(1000);
			clickWhenElementIsReady(driver, 10, adnDet);
			AssetManagementAssetProcessCon_page_pageLog.info("Admin details option has been selected");
			Thread.sleep(1000);
			clickWhenElementIsReady(driver, 10, inProsAsst);
			AssetManagementAssetProcessCon_page_pageLog.info("in process asset sub module has been selected");
			Thread.sleep(1000);
			driver.findElement(astTypSrch).clear();
			Thread.sleep(200);
			driver.findElement(astTypSrch).sendKeys(assetType);
			AssetManagementAssetProcessCon_page_pageLog.info("Processed asset type value has been provided to filetr");
			Thread.sleep(1000);
			clickWhenElementIsReady(driver, 10, astTypFltr);
			AssetManagementAssetProcessCon_page_pageLog.info("Requiered filetr has been filtered");
			Thread.sleep(1000);	
		} catch (Exception e) {
			  e.printStackTrace();
		}
		
		return(driver.findElement(filtrdAsst).getText().contains(assetType));
	}
}
