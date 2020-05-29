package com.mu_sigma.OrgPlatformAutomationFramework.AssetManagement.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;

public class AssetManagementAssetReq_page extends TestBase{
	
	WebDriver driver;

	private static final Logger AssetManagementAssetReq_page_pageLog = LogManager
			.getLogger(AssetManagementAssetReq_page.class.getName());

	By asstReq = By.xpath("//div/div[contains(text(),'Asset Request')]");
	
	By locSel = By.xpath("//select[contains(@label,'Location')]");

	By loc = By.xpath("//option[contains(@value,'ITPL')]");
	
	By asstTypSrch = By.xpath("//span[contains(@class,'search')][2]");
	
	By asstTypeSel = By.xpath("//tr[contains(@class,'gfr')]//input");
	
	By add = By.xpath("//span[contains(text(),'Add')]");

	By asstSrch = By.xpath("//span[contains(@class,'search')][3]");//
	
	By asstSel = By.xpath("//input[contains(@id,'MuSigma139c801:EAppPointfd8ba:-1')]");

	By lvlSrch = By.xpath("//span[contains(@class,'search')][4]");
	
	By lvlSel = By.xpath("//tr[9]/td[contains(@class,'1') and contains(text(),'14')]");
	
	By subAsst = By.xpath("//span[contains(text(),'Submit')]");
	
	By MyRequest = By.xpath("//a[contains(text(),'My Requests')]");
	
	By asstfltr = By.xpath("(//input)[9]");
	
	By fltrclk = By.xpath("//th[contains(text(),'Asset Type')]");
	
	By asstReqtdTyp = By.xpath("//input[contains(@label,'AssetType.Name')]");////tr[contains(@roid,'MuSigma193183d5:EAppPointfd898:-1')]
	
	By asstreq = By.xpath("//tr[contains(@class,'gfr')]/td[contains(@class,'5')]");
	
	By status = By.xpath("//input[@bizappid='Status,Filter_vd_asset:viewControl1:vm1:QueryAssetRequestMy']");
	public AssetManagementAssetReq_page(WebDriver driver) {
		this.driver = driver;
	}
	
	/*
	 * This method will create a new asset request for admin
	 */
	public void assetReq() throws Exception {
		Thread.sleep(5000);
		clickWhenElementIsReady(driver, 20, asstReq);
		AssetManagementAssetReq_page_pageLog.info("Asset request option has been selected");
		Thread.sleep(5000);
		waitForElement(locSel, 10);
		clickWhenElementIsReady(driver, 10, locSel);
		AssetManagementAssetReq_page_pageLog.info("Location search option is selected");
		Thread.sleep(1000);
		waitForElement(loc, 10);
		clickWhenElementIsReady(driver, 10, loc);
		AssetManagementAssetReq_page_pageLog.info("Location is selected");
		Thread.sleep(2000);
		waitForElement(asstTypSrch, 20);
		clickWhenElementIsReady(driver, 10, asstTypSrch);
		AssetManagementAssetReq_page_pageLog.info("Asset type search option is selected");
		Thread.sleep(2000);
		waitForElement(asstTypeSel, 20);
		clickWhenElementIsReady(driver, 10, asstTypeSel);
		AssetManagementAssetReq_page_pageLog.info("Asset type is selected");
		Thread.sleep(3000);
		waitForElement(add, 20);
		clickWhenElementIsReady(driver, 10, add);
		Thread.sleep(2000);
		AssetManagementAssetReq_page_pageLog.info("Asset type is added");
		waitForElement(asstSrch, 20);
		clickWhenElementIsReady(driver, 20, asstSrch);
		AssetManagementAssetReq_page_pageLog.info("Asset search option is selected");
		Thread.sleep(3000);
		waitForElement(asstSel, 20);
		clickWhenElementIsReady(driver, 20, asstSel);
		AssetManagementAssetReq_page_pageLog.info("Asset is selected");
		waitForElement(add, 20);
		clickWhenElementIsReady(driver, 10, add);
		AssetManagementAssetReq_page_pageLog.info("Asset is added");
		Thread.sleep(2000);
		waitForElement(lvlSrch, 20);
		clickWhenElementIsReady(driver, 10, lvlSrch);
		AssetManagementAssetReq_page_pageLog.info("Level search option is selected");
		Thread.sleep(2000);
		//waitForElement(lvlSel, 20);
		clickWhenElementIsReady(driver, 20, lvlSel);
		AssetManagementAssetReq_page_pageLog.info("Level is selected");
		waitForElement(subAsst, 20);
		clickWhenElementIsReady(driver, 10, subAsst);
		AssetManagementAssetReq_page_pageLog.info("Submit asset request is selected");
		//Thread.sleep(2000);
	}
	
	/*
	 * This method will verify the presence of created asset request
	 */
	public boolean assetCrt() throws Exception{
		Thread.sleep(500);
		waitForElement(asstReqtdTyp, 20);
		String asstcrtd = driver.findElement(asstReqtdTyp).getAttribute("value");
		AssetManagementAssetReq_page_pageLog.info("Asset Value saved");
		Thread.sleep(500);
		clickWhenElementIsReady(driver, 20, MyRequest);
		Thread.sleep(500);
		waitForElement(asstfltr, 20);
		driver.findElement(asstfltr).clear();
		Thread.sleep(200);
		driver.findElement(asstfltr).sendKeys(asstcrtd);
		Thread.sleep(500);
		driver.findElement(status).sendKeys("Requested");
		clickWhenElementIsReady(driver, 20, fltrclk);
		Thread.sleep(500);
		waitForElement(asstreq, 20);
		return(driver.findElement(asstreq).getText().contains(asstcrtd));
		
	}
}
