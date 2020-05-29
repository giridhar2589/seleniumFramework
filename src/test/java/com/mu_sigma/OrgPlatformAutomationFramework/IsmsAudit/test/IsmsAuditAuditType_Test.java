package com.mu_sigma.OrgPlatformAutomationFramework.IsmsAudit.test;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mu_sigma.OrgPlatformAutomationFramework.IsmsAudit.page.IsmsAuditAuditType_page;
import com.mu_sigma.OrgPlatformAutomationFramework.IsmsAudit.page.IsmsAuditReport_page;
import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;

public class IsmsAuditAuditType_Test extends TestBase {
	
	IsmsAuditAuditType_page IsmsAuditAuditType_pageObj;
	IsmsAuditReport_page IsmsAuditReport_pageObj;
	
	
	
	@BeforeClass
	public void setUp() throws IOException, Exception {
		init("IsmsAudit_Staging");
		IsmsAuditReport_pageObj = new IsmsAuditReport_page(driver);
		IsmsAuditAuditType_pageObj = new IsmsAuditAuditType_page(driver);
		Runtime.getRuntime().exec(System.getProperty("user.dir") + "\\autoit\\Eraiah_Password.exe");
		Thread.sleep(5000);
	}
	
	/*
	 * Adds a new audit type by getting the audit type input from excel sheet
	 */
	
	
	@DataProvider(name = "auditTypeData")
	public String[][] getauditTypeData() {
		String[][] auditTypeData = getData("ismsAudit.xlsx","audittype");
		return auditTypeData;
	}
	
	@Test(dataProvider="auditTypeData")
	public void addAuditType(String newaudittype,String runmode) throws Exception {
		//Thread.sleep(1000);
		//IsmsAuditAuditType_pageObj.navigateAuditType();
		Thread.sleep(3000);
		IsmsAuditAuditType_pageObj.selectAudittype(newaudittype);
		Thread.sleep(1000);
		assert(IsmsAuditAuditType_pageObj.auditAdded()):"Audit type has not been created";
		IsmsAuditAuditType_pageObj.clickOk();
	}
	@AfterClass
	public void exitApp() throws Exception{
		Thread.sleep(1000);
		IsmsAuditReport_pageObj.logOut();
		Thread.sleep(1000);
	}
}
