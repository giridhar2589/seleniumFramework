package com.mu_sigma.OrgPlatformAutomationFramework.AssetManagement.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;

public class AssetManagementAssetProcess_page extends TestBase{
	
	WebDriver driver;

	private static final Logger AssetManagementAssetProcess_page_pageLog = LogManager
			.getLogger(AssetManagementAssetProcess_page.class.getName());
	
	By adndet = By.xpath("//a[contains(text(),'Admin Details')]");
	
	By nwReq = By.xpath("//a[text()='New Requests']");
	
	By astTypFltrSrt = By.xpath("//th[contains(text(),'Asset Type')]");
	
	By astTypFltr = By.xpath("//td[3]/input[contains(@class,'fftb')]");
	
	By astSel = By.xpath("//tr[contains(@class,'gfr')]");
	
	By process = By.xpath("//span[contains(text(),'Process')]");
	
	
	/*@FindBy(xpath = "//tr[2]/td[5]")
	WebElement asstTyp;*/
	
	public AssetManagementAssetProcess_page(WebDriver driver) {
		this.driver = driver;
	}
	
	
	/*
	 *This method will process the asset request 
	 */
	public void processAsset(String reqBy) throws Exception{
		Thread.sleep(2000);
		clickWhenElementIsReady(driver, 10, adndet);
		AssetManagementAssetProcess_page_pageLog.info("Admin details tab has been selected");
		Thread.sleep(2000);
		//waitForElement(nwReq, 100);
		clickWhenElementIsReady(driver, 10, nwReq);
		AssetManagementAssetProcess_page_pageLog.info("New requests sub module has been selected");
		Thread.sleep(2000);
		//waitForElement(astTypFltr, 1000);
		driver.findElement(astTypFltr).clear();
		Thread.sleep(200);
		driver.findElement(astTypFltr).sendKeys(reqBy);
		Thread.sleep(2000);
		//waitForElement(astTypFltrSrt, 100);
		clickWhenElementIsReady(driver, 10, astTypFltrSrt);
		AssetManagementAssetProcess_page_pageLog.info("Required asset has been filtered");
		Thread.sleep(2000);
		//waitForElement(astSel, 100);
		clickWhenElementIsReady(driver, 10, astSel);
		AssetManagementAssetProcess_page_pageLog.info("Requiered asset has been selected");
		Thread.sleep(2000);
		//waitForElement(process, 100);
		clickWhenElementIsReady(driver, 10, process);
		AssetManagementAssetProcess_page_pageLog.info("Process option has been clicked for selected asset");
		Thread.sleep(1000);
	}
	
}
