package com.mu_sigma.OrgPlatformAutomationFramework.AssetManagement.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;


public class AssetManagementLessUsageAssetCon_page extends TestBase{

	WebDriver driver;
	
	private static final Logger AssetManagementLessUsageAssetCon_page_pageLog = LogManager
			.getLogger(AssetManagementLessUsageAssetCon_page.class.getName());

	By reqByid = By.xpath("//input[contains(@label,'EmployeeID')]");
	
	By asstype = By.xpath("//input[contains(@label,'AssetType')]");
	
	By admDetails = By.xpath("//a[contains(text(),'Admin Details')]");
	
	By lesUsg = By.xpath("//a[contains(text(),'Less Usage')]");
	
	By fltrId = By.xpath("//td[contains(@class,'1')]/input");
	
	By fltrAstTp = By.xpath("//td[contains(@class,'5')]/input");
	
	By selId = By.xpath("//tr[contains(@class,'gfr')]/td[contains(@class,'1')]");
	
	By selAstType = By.xpath("//tr[contains(@class,'gfr')]/td[contains(@class,'5')]");
	
	By filter = By.xpath("//th[contains(text(),'Requested By')]");
	
	public AssetManagementLessUsageAssetCon_page(WebDriver driver) {
		this.driver = driver;
	}	
	public boolean asstLessUsgCon() throws Exception{
		String assetType = null;
		String reqID = null;
		try{
			Thread.sleep(1000);
			assetType = driver.findElement(asstype).getAttribute("value");
			AssetManagementLessUsageAssetCon_page_pageLog.info("Leass usage asset type value has been captured");
			Thread.sleep(1000);
			reqID = driver.findElement(reqByid).getAttribute("value");
			AssetManagementLessUsageAssetCon_page_pageLog.info("Leass usage user ID value has been captured");
			Thread.sleep(1000);
			clickWhenElementIsReady(driver, 10, admDetails);
			AssetManagementLessUsageAssetCon_page_pageLog.info("Admin details module has been selected");
			Thread.sleep(1000);
			clickWhenElementIsReady(driver, 10, lesUsg);
			AssetManagementLessUsageAssetCon_page_pageLog.info("Less usage sub module has been selected");
			Thread.sleep(1000);
			driver.findElement(fltrAstTp).sendKeys(assetType);
			AssetManagementLessUsageAssetCon_page_pageLog.info("Povided input for the asset type filter");
			Thread.sleep(1000);
			driver.findElement(fltrId).sendKeys(reqID);
			AssetManagementLessUsageAssetCon_page_pageLog.info("provided input value for user ID filter");
			Thread.sleep(1000);
			clickWhenElementIsReady(driver, 10, filter);
			AssetManagementLessUsageAssetCon_page_pageLog.info("provided input value for user ID filter");
			Thread.sleep(1000);
		}
		catch (Exception e) {
			  e.printStackTrace();
		}
		
		return(driver.findElement(selId).getText().contains(reqID) && driver.findElement(selAstType).getText().contains(assetType));
	}
}
