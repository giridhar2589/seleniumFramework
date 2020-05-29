package com.mu_sigma.OrgPlatformAutomationFramework.IsmsAudit.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;



public class IsmsAuditImpersonnate_page extends TestBase {
	
	WebDriver driver;
	
	private static final Logger IsmsAuditImpersonnate_page_pageLog = LogManager
			.getLogger(IsmsAuditViewReport_page.class.getName());
	
	By userOptions = By.xpath("//i[contains(@class,'fa fa-bars')]");
	
	By logOut = By.xpath("//div[contains(text(),'Logout')]");
	
	By configure = By.xpath("//div[contains(text(),'Configure')]");
	
	By selImp = By.xpath("//tr[td[contains(text(),'Impersonate')]]//select");
	
	By selOption = By.xpath("//option[contains(text(),'ashna.shah')]");
	
	By impersonate = By.xpath("//tr[td[contains(text(),'Impersonate')]]//span[contains(@class,'opnavigate')]");
	
	By logIn = By.xpath("//a[contains(@id,'LogoutURL')]");
	
	public IsmsAuditImpersonnate_page(WebDriver driver) {
		this.driver = driver;
	}
	
	/*
	 * Impersonates as user whose name is provided in the excel sheet  
	 */
	public void impersonate() throws Exception {
		try
		{
			Thread.sleep(2000);
			waitForElement(userOptions, 80);
			driver.findElement(userOptions).click();
			Thread.sleep(5000);
			IsmsAuditImpersonnate_page_pageLog.info("User options drop down has been selected");
			Thread.sleep(2000);
			waitForElement(configure, 80);
			driver.findElement(configure).click();
			Thread.sleep(5000);
			IsmsAuditImpersonnate_page_pageLog.info("Configure option has been selected");
			Thread.sleep(2000);
			waitForElement(selImp, 80);
			driver.findElement(selImp).click();
			Thread.sleep(2000);
			IsmsAuditImpersonnate_page_pageLog.info("Impersonate select option has been selected");
			Thread.sleep(2000);
			driver.findElement(selOption).click();
			IsmsAuditImpersonnate_page_pageLog.info("User to be impersonated has been selected");
			Thread.sleep(10000);
			//driver.findElement(impersonate).click();
			//Thread.sleep(2000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}
	
	public void impLogOut() throws Exception {
		
		try
		{
			Thread.sleep(2000);
			waitForElement(userOptions, 80);
			driver.findElement(userOptions).click();
			Thread.sleep(5000);
			IsmsAuditImpersonnate_page_pageLog.info("User options drop down has been selected");
			Thread.sleep(2000);
			waitForElement(logOut, 80);
			driver.findElement(logOut).click();
			Thread.sleep(5000);
			IsmsAuditImpersonnate_page_pageLog.info("Logout option has been selected");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public void impLogin() throws Exception {
		try
		{
			Thread.sleep(2000);
			waitForElement(logIn, 80);
			driver.findElement(logIn).click();
			Thread.sleep(5000);
			IsmsAuditImpersonnate_page_pageLog.info("Admin user loggedin again");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
}
