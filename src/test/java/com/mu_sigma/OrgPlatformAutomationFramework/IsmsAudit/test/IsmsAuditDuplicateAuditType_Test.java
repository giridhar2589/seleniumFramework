package com.mu_sigma.OrgPlatformAutomationFramework.IsmsAudit.test;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mu_sigma.OrgPlatformAutomationFramework.IsmsAudit.page.IsmsAuditAssignMandatory_page;
import com.mu_sigma.OrgPlatformAutomationFramework.IsmsAudit.page.IsmsAuditAssign_page;
import com.mu_sigma.OrgPlatformAutomationFramework.IsmsAudit.page.IsmsAuditAuditTypeMandatory_page;
import com.mu_sigma.OrgPlatformAutomationFramework.IsmsAudit.page.IsmsAuditAuditType_page;
import com.mu_sigma.OrgPlatformAutomationFramework.IsmsAudit.page.IsmsAuditAuditYear_page;
import com.mu_sigma.OrgPlatformAutomationFramework.IsmsAudit.page.IsmsAuditCloseMandatory_page;
import com.mu_sigma.OrgPlatformAutomationFramework.IsmsAudit.page.IsmsAuditClosed_page;
import com.mu_sigma.OrgPlatformAutomationFramework.IsmsAudit.page.IsmsAuditDepartment_page;
import com.mu_sigma.OrgPlatformAutomationFramework.IsmsAudit.page.IsmsAuditDuplicateAuditType_page;
import com.mu_sigma.OrgPlatformAutomationFramework.IsmsAudit.page.IsmsAuditImpersonnate_page;
import com.mu_sigma.OrgPlatformAutomationFramework.IsmsAudit.page.IsmsAuditOpenMandatory_page;
import com.mu_sigma.OrgPlatformAutomationFramework.IsmsAudit.page.IsmsAuditOpen_page;
import com.mu_sigma.OrgPlatformAutomationFramework.IsmsAudit.page.IsmsAuditReportMandatory_page;
import com.mu_sigma.OrgPlatformAutomationFramework.IsmsAudit.page.IsmsAuditReport_page;
import com.mu_sigma.OrgPlatformAutomationFramework.IsmsAudit.page.IsmsAuditSubRework_page;
import com.mu_sigma.OrgPlatformAutomationFramework.IsmsAudit.page.IsmsAuditSubmitted_page;
import com.mu_sigma.OrgPlatformAutomationFramework.IsmsAudit.page.IsmsAuditViewReport_page;
import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;

public class IsmsAuditDuplicateAuditType_Test extends TestBase{
	
	IsmsAuditReport_page IsmsAuditReport_pageObj;
	IsmsAuditAssign_page IsmsAuditAssign_pageObj;
	IsmsAuditSubmitted_page IsmsAuditSubmitted_pageObj;
	IsmsAuditOpen_page IsmsAuditOpen_pageObj;
	IsmsAuditClosed_page IsmsAuditClosed_pageObj;
	IsmsAuditDepartment_page IsmsAuditDepartment_pageObj;
	IsmsAuditReportMandatory_page IsmsAuditReportMandatory_pageObj;
	IsmsAuditAssignMandatory_page IsmsAuditAssignMandatory_pageObj;
	IsmsAuditOpenMandatory_page IsmsAuditOpenMandatory_pageObj;
	IsmsAuditCloseMandatory_page IsmsAuditCloseMandatory_pageObj;
	IsmsAuditAuditType_page IsmsAuditAuditType_pageObj;
	IsmsAuditAuditTypeMandatory_page IsmsAuditAuditTypeMandatory_pageObj;
	IsmsAuditViewReport_page IsmsAuditViewReport_pageObj;
	IsmsAuditDuplicateAuditType_page IsmsAuditDuplicateAuditType_pageObj;
	IsmsAuditAuditYear_page IsmsAuditAuditYear_pageObj;
	IsmsAuditImpersonnate_page IsmsAuditImpersonnate_pageObj;
	IsmsAuditSubRework_page IsmsAuditSubRework_pageObj;

	
	
	@BeforeClass
	public void setUp() throws IOException, Exception {
		init("IsmsAudit_Staging");
		IsmsAuditReport_pageObj = new IsmsAuditReport_page(driver);
		IsmsAuditAssign_pageObj = new IsmsAuditAssign_page(driver);
		IsmsAuditSubmitted_pageObj = new IsmsAuditSubmitted_page(driver);
		IsmsAuditOpen_pageObj = new IsmsAuditOpen_page(driver);
		IsmsAuditClosed_pageObj = new IsmsAuditClosed_page(driver);
		IsmsAuditDepartment_pageObj = new IsmsAuditDepartment_page(driver);
		IsmsAuditReportMandatory_pageObj = new IsmsAuditReportMandatory_page(driver);
		IsmsAuditAssignMandatory_pageObj = new IsmsAuditAssignMandatory_page(driver);
		IsmsAuditOpenMandatory_pageObj = new IsmsAuditOpenMandatory_page(driver);
		IsmsAuditCloseMandatory_pageObj = new IsmsAuditCloseMandatory_page(driver);
		IsmsAuditAuditType_pageObj = new IsmsAuditAuditType_page(driver);
		IsmsAuditAuditTypeMandatory_pageObj = new IsmsAuditAuditTypeMandatory_page(driver);
		IsmsAuditViewReport_pageObj = new IsmsAuditViewReport_page(driver);
		IsmsAuditDuplicateAuditType_pageObj = new IsmsAuditDuplicateAuditType_page(driver);
		IsmsAuditAuditYear_pageObj = new IsmsAuditAuditYear_page(driver);
		IsmsAuditImpersonnate_pageObj = new IsmsAuditImpersonnate_page(driver);
		IsmsAuditSubRework_pageObj = new IsmsAuditSubRework_page(driver);
		Runtime.getRuntime().exec(System.getProperty("user.dir") + "\\autoit\\Eraiah_Password.exe");
		Thread.sleep(5000);
	}
	/*
	 * Checks the duplicate audit type validation by getting the duplicate audit type input from excel sheet
	*/  
	@DataProvider(name = "auditTypeDataDup")
	public String[][] getauditTypeDataDup() {
		String[][] auditTypeDataDup = getData("ismsAudit.xlsx","audittype");
		return auditTypeDataDup;
	}
	
	@Test(dataProvider="auditTypeDataDup")
	public void dupAuditType(String newaudittype,String runmode) throws Exception {
		//Thread.sleep(1000);
		//IsmsAuditAuditType_pageObj.navigateAuditType();
		Thread.sleep(1000);
		IsmsAuditDuplicateAuditType_pageObj.selectAudittype(newaudittype);
		Thread.sleep(1000);
		assert(IsmsAuditDuplicateAuditType_pageObj.duplicatePopup()):"Pop up for duplicate audit type is not available";
		Thread.sleep(500);
		IsmsAuditDuplicateAuditType_pageObj.clickOk();
		Thread.sleep(500);
		IsmsAuditDuplicateAuditType_pageObj.clickCancel();
		Thread.sleep(500);
	}
	@AfterClass
	public void exitApp() throws Exception{
		Thread.sleep(1000);
		IsmsAuditReport_pageObj.logOut();
		Thread.sleep(1000);
	}
}
