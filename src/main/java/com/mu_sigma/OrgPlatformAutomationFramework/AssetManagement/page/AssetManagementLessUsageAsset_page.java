package com.mu_sigma.OrgPlatformAutomationFramework.AssetManagement.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;

public class AssetManagementLessUsageAsset_page extends TestBase{
	
	WebDriver driver;
	
	private static final Logger AssetManagementLessUsageAsset_page_pageLog = LogManager
			.getLogger(AssetManagementLessUsageAsset_page.class.getName());
	
	By admDetails = By.xpath("//a[contains(text(),'Admin Details')]");
	
	By actvReq = By.xpath("//div[contains(@class,'ActiveRequests')]/a");
	
	By empId = By.xpath("//td[3]/input");
	
	By fltrClk = By.xpath("//th[contains(text(),'Employee ID')]");
	
	By asstSlct = By.xpath("//table[contains(@caption,'Asset Request')]//tr[3]//span");
	
	By asstNum = By.xpath("//input[contains(@label,'AssetNumber')]");
	
	By mdfy = By.xpath("//span[contains(text(),'Modify')]");
	
	By actv = By.xpath("//span[contains(@label,'Active')]/input");
	
	By save = By.xpath("//span[contains(text(),'Save')]");
	
	By logoutIcn = By.xpath("//a[contains(text(),'Welcome')]/i");
	
	By clsIcn = By.xpath("//a[contains(@class,'closebtn')]");
	
	public AssetManagementLessUsageAsset_page(WebDriver driver) {
		this.driver = driver;
	}
	
	/*
	 * Method to make the assigned asset as less usage 
	 */
	public void asstLessUsage(String empid) throws Exception{
		//String astNum = null;
		try
		{
			Thread.sleep(1000);
			clickWhenElementIsReady(driver, 10, admDetails);
			AssetManagementLessUsageAsset_page_pageLog.info("Admin details module has been selected");
			Thread.sleep(1000);
			clickWhenElementIsReady(driver, 10, actvReq);
			AssetManagementLessUsageAsset_page_pageLog.info("Active request sub module has been selected");
			Thread.sleep(1000);
			clickWhenElementIsReady(driver, 10, logoutIcn);
			Thread.sleep(500);
			clickWhenElementIsReady(driver, 10, clsIcn);
			Thread.sleep(500);
			//driver.findElement(empId).clear();
			Thread.sleep(500);
			//driver.findElement(empId).sendKeys(empid);
			AssetManagementLessUsageAsset_page_pageLog.info("Employee id has been provided as filter");
			Thread.sleep(1000);
			clickWhenElementIsReady(driver, 10, fltrClk);
			AssetManagementLessUsageAsset_page_pageLog.info("Required record has been filter");
			Thread.sleep(1000);
			clickWhenElementIsReady(driver, 10, asstSlct);
			AssetManagementLessUsageAsset_page_pageLog.info("Required record has been selected");
			Thread.sleep(1000);
//			astNum = driver.findElement(asstNum).getAttribute("value");
//			AssetManagementLessUsageAsset_page_pageLog.info("Selected records asset number value has been captured");
//			Thread.sleep(1000);
			clickWhenElementIsReady(driver, 10, mdfy);
			AssetManagementLessUsageAsset_page_pageLog.info("Modify option has been selected");
			Thread.sleep(1000);
			clickWhenElementIsReady(driver, 10, actv);
			AssetManagementLessUsageAsset_page_pageLog.info("Less usage option has been selected");
			Thread.sleep(1000);
			clickWhenElementIsReady(driver, 10, save);
			AssetManagementLessUsageAsset_page_pageLog.info("Save option has been selected");
			Thread.sleep(1000);
			
		} catch (Exception e) {
		  e.printStackTrace();
		}
	}
}
