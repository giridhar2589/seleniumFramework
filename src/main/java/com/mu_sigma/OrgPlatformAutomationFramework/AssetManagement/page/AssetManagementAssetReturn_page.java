package com.mu_sigma.OrgPlatformAutomationFramework.AssetManagement.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;

public class AssetManagementAssetReturn_page extends TestBase{
	
	WebDriver driver;
	
	private static final Logger AssetManagementAssetReturn_page_pageLog = LogManager
			.getLogger(AssetManagementAssetReturn_page.class.getName());
	
	By adnDet = By.xpath("//a[contains(text(),'Admin')]");
	
	By asstRecvrdReq = By.xpath("//a[contains(text(),'Assets Recovered')]");
	
    By LogoutIcn = By.xpath("//i[contains(@class,'fa-bars')]");
	
	By LogoutCls = By.xpath("//a[contains(@class,'closebtn')]");
	
	By reqByFltr = By.xpath("//td[4]/input[contains(@class,'fftb')]");
	
	By asstRecovrdRec = By.xpath("//td[contains(@class,'griditemtext')]");
	
	By assFltr = By.xpath("//th[contains(text(),'Requested')]");
	
	By assRet = By.xpath("//span[contains(text(),'Return Asset')]");

	
	public AssetManagementAssetReturn_page(WebDriver driver) {
		this.driver = driver;
	}
	
	/*
	 *Method to recover the assigned asset request 
	 */
	public void assReturn(String assReqby) throws Exception {
		try {
			Thread.sleep(1000);
			clickWhenElementIsReady(driver, 10, adnDet);
			Thread.sleep(1000);
			AssetManagementAssetReturn_page_pageLog.info("admin details module is seleceted");
			Thread.sleep(1000);
			clickWhenElementIsReady(driver, 10, asstRecvrdReq);
			Thread.sleep(1000);
			AssetManagementAssetReturn_page_pageLog.info("Recovered assets sub module has been selected");
			Thread.sleep(1000);
			driver.findElement(reqByFltr).sendKeys(assReqby);
			AssetManagementAssetReturn_page_pageLog.info("Required recovered asset record has been selected");
			Thread.sleep(1000);
			clickWhenElementIsReady(driver, 10, assFltr);
			AssetManagementAssetReturn_page_pageLog.info("Required asset request has been filtered");
			Thread.sleep(1000);
			clickWhenElementIsReady(driver, 10, asstRecovrdRec);
			AssetManagementAssetReturn_page_pageLog.info("Required asset request has been selected");
			Thread.sleep(1000);
			clickWhenElementIsReady(driver, 10, assRet);
			AssetManagementAssetReturn_page_pageLog.info("Asset request has been recovered");
			Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
   }
	
}
