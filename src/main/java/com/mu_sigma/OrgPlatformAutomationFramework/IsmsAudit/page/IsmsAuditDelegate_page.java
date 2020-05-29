package com.mu_sigma.OrgPlatformAutomationFramework.IsmsAudit.page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;



public class IsmsAuditDelegate_page extends TestBase {
	
	WebDriver driver;
	
	private static final Logger IsmsAuditDelegate_page_pageLog = LogManager
			.getLogger(IsmsAuditDelegate_page.class.getName());
	
	By userOptions = By.xpath("//i[contains(@class,'fa fa-bars')]");
	
	By logOut = By.xpath("//div[contains(text(),'Logout')]");
	
	By configure = By.xpath("//div[contains(text(),'Configure')]");
	
	By selImp = By.xpath("//tr[td[contains(text(),'Impersonate')]]//select");
	
	By selOption = By.xpath("//option[contains(text(),'vishwesh.k')]");
	
	By impersonate = By.xpath("(//td[4]/span)[1]");
	
	By logIn = By.xpath("//a[contains(@id,'LogoutURL')]");
	
	By delegate = By.xpath("//span[text()='Delegate']");
	
	By delegateSearch = By.xpath("//span[@class='Optional formsearchbuttonright fa-search']['before']");
	
	By delegatenameip = By.xpath("//td[4][@class='tablesaw-priority-2']/input");
	
	By delradio = By.xpath("(//input)[27]");
	
	By AddDelegate = By.xpath("//span[text()='Add']");
	
	By ConfirmDelegate = By.xpath("//span[text()='Confirm']");
	
	By selOption1 = By.xpath("//option[contains(text(),'Varsha')]");
	
	By details = By.xpath("//a[contains(text(),'Details')]");
	
	By filterDel = By.xpath("//th[text()='Name']");
	
	public IsmsAuditDelegate_page (WebDriver driver) {
		this.driver = driver;
	}
	
	/*
	 * Impersonates as user whose name is provided in the excel sheet  
	 */
	public void Delegate(String DelegatePerson) throws InterruptedException {
		waitForElement(delegate, 80);
		driver.findElement(delegate).click();
		Thread.sleep(5000);
		IsmsAuditDelegate_page_pageLog.info("User Delagate option Selected");
		Thread.sleep(2000);
		waitForElement(delegateSearch, 80);
		driver.findElement(delegateSearch).click();
		Thread.sleep(5000);
		IsmsAuditDelegate_page_pageLog.info("Delegate Search option has been selected");
		Thread.sleep(2000);
		waitForElement(delegatenameip, 80);
		driver.findElement(delegatenameip).sendKeys(DelegatePerson);
		Thread.sleep(2000);
		driver.findElement(filterDel).click();
		IsmsAuditDelegate_page_pageLog.info("User name has been Filtered");
		Thread.sleep(2000);
		waitForElement(delradio, 80);
		driver.findElement(delradio).click();
		IsmsAuditDelegate_page_pageLog.info("User to be Delegated has been selected");
		Thread.sleep(2000);
		driver.findElement(AddDelegate).click();
		IsmsAuditDelegate_page_pageLog.info("User to be Delegated has been Added");
		Thread.sleep(2000);
		driver.findElement(ConfirmDelegate).click();
		//Thread.sleep(2000);
	}
	public void DelgateImpersonnate() {
		try
		{
			Thread.sleep(2000);
			waitForElement(userOptions, 80);
			driver.findElement(userOptions).click();
			Thread.sleep(5000);
			IsmsAuditDelegate_page_pageLog.info("User options drop down has been selected");
			Thread.sleep(2000);
			waitForElement(configure, 80);
			driver.findElement(configure).click();
			Thread.sleep(5000);
			IsmsAuditDelegate_page_pageLog.info("Configure option has been selected");
			Thread.sleep(2000);
			waitForElement(selImp, 80);
			driver.findElement(selImp).click();
			Thread.sleep(2000);
			IsmsAuditDelegate_page_pageLog.info("Impersonate select option has been selected");
			Thread.sleep(2000);
			driver.findElement(selOption1).click();
			IsmsAuditDelegate_page_pageLog.info("User to be impersonated has been selected");
			Thread.sleep(10000);
			//driver.findElement(impersonate).click();
			//Thread.sleep(2000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
}

