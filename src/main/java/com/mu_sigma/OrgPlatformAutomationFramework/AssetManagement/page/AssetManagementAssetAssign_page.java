package com.mu_sigma.OrgPlatformAutomationFramework.AssetManagement.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;

public class AssetManagementAssetAssign_page extends TestBase{
	
	WebDriver driver;
	
	private static final Logger AssetManagementAssetAssign_page_pageLog = LogManager
			.getLogger(AssetManagementAssetAssign_page.class.getName());
	
	By adnDet = By.xpath("//a[contains(text(),'Admin')]");
	
	By asstInProg = By.xpath("//a[contains(text(),'In-Process')]");
	
	By LogoutIcn = By.xpath("//i[contains(@class,'fa-bars')]");
	
	By LogoutCls = By.xpath("//a[contains(@class,'closebtn')]");
	
	By reqByFltr = By.xpath("//td[3]/input[contains(@class,'fftb')]");
	
	By asstInProgRec = By.xpath("//td[contains(@class,'griditemtext')]");
	
	By assFltr = By.xpath("//th[contains(text(),'Requested')]");
	
	By assAsst = By.xpath("//span[contains(text(),'Assign Asset')]");
	
	By lkrImg = By.xpath("//span[contains(@title,'Pick')]");
	
	By lkrNum = By.xpath("//td[contains(@class,'griditemtext')]");
	
	By assFrmDtimg = By.xpath("//div[contains(@label,'AssignedFromDate')]//img");
	
	By assfrmDtSel = By.xpath("//button[contains(text(),'Today')]");
	
	By assTillDtimg = By.xpath("//div[contains(@label,'TillDate')]/img");
	
	By assTillDtSel = By.xpath("//button[contains(text(),'Today')]");
	
	By assSave = By.xpath("//span[contains(text(),'Save')]");
	
	By activereqst = By.xpath("//a[contains(text(),'Active Requests')]");
	
	By assigndreqst = By.xpath("//td[contains(text(),'Eraiah')]");
	
	public AssetManagementAssetAssign_page(WebDriver driver) {
		this.driver = driver;
	}
	
	/*
	 *Method to assign the in-process asset request 
	 */
	public void assAsset(String assReqby) throws Exception {
		try {
			Thread.sleep(1000);
			clickWhenElementIsReady(driver, 10, adnDet);
			Thread.sleep(1000);
			AssetManagementAssetAssign_page_pageLog.info("admin details module is seleceted");
			Thread.sleep(1000);
			clickWhenElementIsReady(driver, 10, asstInProg);
			AssetManagementAssetAssign_page_pageLog.info("assets in progress sub module has been selected");
			driver.findElement(reqByFltr).clear();
			Thread.sleep(1000);
			driver.findElement(reqByFltr).sendKeys(assReqby);
			AssetManagementAssetAssign_page_pageLog.info("Required asset in progress record has been selected");
			Thread.sleep(1000);
			clickWhenElementIsReady(driver, 10, assFltr);
			AssetManagementAssetAssign_page_pageLog.info("Required asset request has been filtered");
			Thread.sleep(1000);
			clickWhenElementIsReady(driver, 10, asstInProgRec);
			AssetManagementAssetAssign_page_pageLog.info("Required asset request has been selected");
			Thread.sleep(1000);
			clickWhenElementIsReady(driver, 10, assAsst);
			AssetManagementAssetAssign_page_pageLog.info("Option to assign has been selected");
			Thread.sleep(1000);
			clickWhenElementIsReady(driver, 10, lkrImg);
			AssetManagementAssetAssign_page_pageLog.info("Locker number list  has been selected");
			Thread.sleep(1000);
			clickWhenElementIsReady(driver, 10, lkrNum);
			AssetManagementAssetAssign_page_pageLog.info("Locker number has been selected");
			Thread.sleep(1000);
			clickWhenElementIsReady(driver, 10, assFrmDtimg);
			AssetManagementAssetAssign_page_pageLog.info("From date option has been selected");
			Thread.sleep(1000);
			clickWhenElementIsReady(driver, 10, assfrmDtSel);
			AssetManagementAssetAssign_page_pageLog.info("From date has been selected");
			Thread.sleep(1000);
			clickWhenElementIsReady(driver, 10, assTillDtimg);
			AssetManagementAssetAssign_page_pageLog.info("Till data option has been selected");
			Thread.sleep(1000);
			clickWhenElementIsReady(driver, 10, assTillDtSel);
			AssetManagementAssetAssign_page_pageLog.info("Till date has been selected");
			Thread.sleep(1000);
			clickWhenElementIsReady(driver, 10, assSave);
			AssetManagementAssetAssign_page_pageLog.info("Assign save option has been selected");
			Thread.sleep(1000);
			clickWhenElementIsReady(driver, 10, adnDet );
			AssetManagementAssetAssign_page_pageLog.info("Admin details has  been selected");
			clickWhenElementIsReady(driver, 10, activereqst );
			AssetManagementAssetAssign_page_pageLog.info("Active requests has  been selected");
			clickWhenElementIsReady(driver, 10, assigndreqst );
			AssetManagementAssetAssign_page_pageLog.info("Active requests has  been selected");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
