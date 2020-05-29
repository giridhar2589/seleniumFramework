package com.mu_sigma.OrgPlatformAutomationFramework.IsmsAudit.test;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import com.mu_sigma.OrgPlatformAutomationFramework.IsmsAudit.page.IsmsAuditAuditTypeMandatory_page;

import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;

public class IsmsAuditAuditTypeMandatory_Test extends TestBase {
	
	IsmsAuditAuditTypeMandatory_page IsmsAuditAuditTypeMandatory_pageObj;

	
	@BeforeClass
	public void setUp() throws IOException, Exception {
		init("IsmsAudit_Staging");
		
		IsmsAuditAuditTypeMandatory_pageObj = new IsmsAuditAuditTypeMandatory_page(driver);
	
		Runtime.getRuntime().exec(System.getProperty("user.dir") + "\\autoit\\Eraiah_Password.exe");
		Thread.sleep(5000);
	}
	
	/*
	 * Checks the mandatory fields validation for add audit type functionality 
	 */	
	@Test
	public void audiTypeMand() throws Exception {
		Thread.sleep(500);
		IsmsAuditAuditTypeMandatory_pageObj.navigateAuditType();
		Thread.sleep(500);
		assert(IsmsAuditAuditTypeMandatory_pageObj.mandatoryPopup()):"Alert for mandatory fields is not displyed";
		Thread.sleep(500);
		IsmsAuditAuditTypeMandatory_pageObj.clickOk();
		Thread.sleep(500);
	}
}
