package com.mu_sigma.OrgPlatformAutomationFramework.AssetManagement.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;

public class AssetManagementAssetRecover_page extends TestBase{

	WebDriver driver;
	
	private static final Logger AssetManagementAssetRecover_page_pageLog = LogManager
			.getLogger(AssetManagementAssetRecover_page.class.getName());
	
	By adnDet = By.xpath("//a[contains(text(),'Admin')]");
	
	By asstActiveReq = By.xpath("//div[contains(@id,'ActiveRequests')]//a");
	
    By LogoutIcn = By.xpath("//i[contains(@class,'fa-bars')]");
	
	By LogoutCls = By.xpath("//a[contains(@class,'closebtn')]");
	
	By reqByFltr = By.xpath("//td[4]/input[contains(@class,'fftb')]");
	
	By asstAssgndRec = By.xpath("//td[contains(@class,'griditemtext')]");
	
	By assFltr = By.xpath("//th[contains(text(),'Requested')]");
	
	By assRcr = By.xpath("//span[contains(text(),'Recover Asset')]");
	
	By astTypFltr = By.xpath("//td[7]/input[contains(@class,'fftb')]");
	
	By assttyp = By.xpath("//tr[contains(@class,'gfr')]/td[contains(@class,'priority-4')]");
	
	public AssetManagementAssetRecover_page(WebDriver driver) {
		this.driver = driver;
	}
	
	/*
	 *Method to recover the assigned asset request 
	 */
	public void assRecover(String assReqby) throws Exception {
		    String assettype = null;
		try {
			assettype = driver.findElement(assttyp).getText();
			Thread.sleep(1000);
			clickWhenElementIsReady(driver, 10, adnDet);
			Thread.sleep(1000);
			AssetManagementAssetRecover_page_pageLog.info("admin details module is seleceted");
			Thread.sleep(1000);
			clickWhenElementIsReady(driver, 10, asstActiveReq);
			AssetManagementAssetRecover_page_pageLog.info("Active assets sub module has been selected");
			Thread.sleep(1000);
			driver.findElement(reqByFltr).sendKeys(assReqby);
			AssetManagementAssetRecover_page_pageLog.info("Input for the required assigned asset has been provided");
			Thread.sleep(1000);
			driver.findElement(astTypFltr).sendKeys(assettype);
			AssetManagementAssetRecover_page_pageLog.info("Required assigned asset type record has been sorted");
			Thread.sleep(1000);
			clickWhenElementIsReady(driver, 10, assFltr);
			AssetManagementAssetRecover_page_pageLog.info("Required asset request has been filtered");
			Thread.sleep(1000);
			clickWhenElementIsReady(driver, 10, asstAssgndRec);
			AssetManagementAssetRecover_page_pageLog.info("Required asset request has been selected");
			Thread.sleep(1000);
			clickWhenElementIsReady(driver, 10, assRcr);
			AssetManagementAssetRecover_page_pageLog.info("Asset request has been recovered");
			Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
   }
}
