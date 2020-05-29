package com.mu_sigma.OrgPlatformAutomationFramework.AssetManagement.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;

public class AssetManagementAssetAssignCon_page extends TestBase{
	
	WebDriver driver;
	
	private static final Logger AssetManagementAssetAssignCon_page_pageLog = LogManager
			.getLogger(AssetManagementAssetAssignCon_page.class.getName());
	
	By assAstType = By.xpath("//input[contains(@label,'AssetType.Name')]");
	
	By assAssigned = By.xpath("//a[contains(text(),'My Requests')]");
	
	By assetTypSrch = By.xpath("//tr[1]/td[5]/input");
	
	By astTypFltr = By.xpath("//th[contains(text(),'Asset Type')]");
	
	By assetfltrd = By.xpath("//tr[2]/td[5]");
	
	By Status = By.xpath("//td[10]//input[@type='text']");
	
	public AssetManagementAssetAssignCon_page(WebDriver driver) {
		this.driver = driver;
	}
	
	
	/*
	 * This method will confirm the assigned assets  
	 */
	
	public boolean asstAssignedCon() throws Exception{
		String assetType = null;
		try
		{
			Thread.sleep(1000);
			
		    assetType = driver.findElement(assAstType).getAttribute("value");
			AssetManagementAssetAssignCon_page_pageLog.info("Processed asset type value has been captured");
			Thread.sleep(1000);
			clickWhenElementIsReady(driver, 10, assAssigned);
			AssetManagementAssetAssignCon_page_pageLog.info("Assets assigned module has been selected");
			Thread.sleep(1000);
			driver.findElement(Status).clear();
			driver.findElement(assetTypSrch).clear();
			Thread.sleep(200);
			driver.findElement(assetTypSrch).sendKeys(assetType);
			AssetManagementAssetAssignCon_page_pageLog.info("Assigned asset type value has been provided to filter");
			Thread.sleep(1000);
			clickWhenElementIsReady(driver, 10, astTypFltr);
			AssetManagementAssetAssignCon_page_pageLog.info("Required asset record has been filtered");
			Thread.sleep(1000);	
		} catch (Exception e) {
		  e.printStackTrace();
		}
		
		return(driver.findElement(assetfltrd).getText().contains(assetType));
	}

}
