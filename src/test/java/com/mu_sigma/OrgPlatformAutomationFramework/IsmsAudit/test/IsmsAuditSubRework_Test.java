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

public class IsmsAuditSubRework_Test extends TestBase{
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
	}/*
	 * Reports a audit finding by ISMS audit admin for SPOC's to handle for rework
	 */
	
	@DataProvider(name = "auditReportDataRework")
	public String[][] getauditReportDataRework() {
		String[][] auditReportDataRework = getData("ismsAudit.xlsx","Report");
		return auditReportDataRework;
	}
	
	@Test(priority=1,dataProvider="auditReportDataRework")
	public void reportAuditRework(String audittype,String department,String clausenumber,String auditcycle,String findingtype,String findings,String runmode) throws Exception{
		Thread.sleep(1000);
		IsmsAuditReport_pageObj.navigateReport();
		Thread.sleep(1000);
		assert(IsmsAuditReport_pageObj.reportPresent()):"Report page is not displayed";
		Thread.sleep(1000);
		IsmsAuditReport_pageObj.selectAudittype(audittype);
		Thread.sleep(1000);
		IsmsAuditReport_pageObj.selectDepttype(department);
		Thread.sleep(1000);
		IsmsAuditReport_pageObj.clauseNumber(clausenumber);
		Thread.sleep(1000);
		//IsmsAuditReport_pageObj.selectAuditcycle(auditcycle);
		Thread.sleep(1000);
		IsmsAuditReport_pageObj.selectFindingtype(findingtype);
		Thread.sleep(1000);
		IsmsAuditReport_pageObj.findingsDesc(findings);
		Thread.sleep(1000);
		IsmsAuditReport_pageObj.selectTDCDate();
		Thread.sleep(1000);
		IsmsAuditReport_pageObj.selectTDCADate();
		Thread.sleep(1000);
		IsmsAuditReport_pageObj.selectAuditDate();
		Thread.sleep(1000);
		IsmsAuditReport_pageObj.raiseReport();
		Thread.sleep(1000);
		assert(IsmsAuditReport_pageObj.reportCreated()):"Admin has not reported a finding";
		
	}
	
	
	/*
	 * Submits the reported audit finding by getting the inputs from excel sheet to handle rework
	 */
	
	@DataProvider(name = "auditAssignDataRework")
	public String[][] getauditAssignDataRework() {
		String[][] auditAssignDataRework = getData("ismsAudit.xlsx","assign");
		return auditAssignDataRework;
	}
	
	@Test(priority=2,dataProvider="auditAssignDataRework")
	public void assignAuditRework(String correction,String rootcause,String correctiveaction,String runmode) throws Exception {
		Thread.sleep(1000);
		IsmsAuditAssign_pageObj.auditNum();
		Thread.sleep(3000);
		IsmsAuditImpersonnate_pageObj.impersonate();
		Thread.sleep(3000);
		IsmsAuditAssign_pageObj.navigateAssign();
		Thread.sleep(1000);
		IsmsAuditAssign_pageObj.filterAudit();
		Thread.sleep(1000);
		IsmsAuditAssign_pageObj.modifyAudit();
		Thread.sleep(1000);
		assert(IsmsAuditAssign_pageObj.auditAssigned()):"Reported audit finding has not been assigned";
		Thread.sleep(1000);
		IsmsAuditAssign_pageObj.modifyClickAudit();
		Thread.sleep(1000);
		IsmsAuditAssign_pageObj.correction(correction);
		Thread.sleep(1000);
		IsmsAuditAssign_pageObj.coorectAction(correctiveaction);
		Thread.sleep(1000);
		IsmsAuditAssign_pageObj.rootcause(rootcause);
		Thread.sleep(1000);
		IsmsAuditAssign_pageObj.submit();
		Thread.sleep(1000);
		assert(IsmsAuditAssign_pageObj.reportSubmitted()):"Admin has not submitted a finding";
	}
	
	
	/*
	 * Verifying the audit finding submission and send for rework by ISMS audit admin
	 */
	
	@Test(priority=3)
	public void submitAuditRework() throws Exception {
		Thread.sleep(1000);
		IsmsAuditSubRework_pageObj.auditNum();
		Thread.sleep(3000);
		IsmsAuditImpersonnate_pageObj.impLogOut();
		Thread.sleep(3000);
		IsmsAuditImpersonnate_pageObj.impLogin();
		Thread.sleep(3000);
		IsmsAuditSubRework_pageObj.navigateSubmitted();
		Thread.sleep(1000);
		IsmsAuditSubRework_pageObj.filterAudit();
		Thread.sleep(1000);
		assert(IsmsAuditSubRework_pageObj.auditSubmitted()):"Assigned audit finding has not been submitted";
		Thread.sleep(1000);
		IsmsAuditSubRework_pageObj.reworkAudit();
		Thread.sleep(1000);
		assert(IsmsAuditSubRework_pageObj.reworkedAudit()):"Admin has not sent the audit finding for rework";
	}
	
	/*
	 * Verifying the sent for rework and resubmitting the same   
	 */ 
	
	@Test(priority=4)
	public void assignAuditReworked() throws Exception {
		Thread.sleep(1000);
		IsmsAuditAssign_pageObj.auditNum();
		Thread.sleep(3000);
		IsmsAuditImpersonnate_pageObj.impersonate();
		Thread.sleep(3000);
		IsmsAuditAssign_pageObj.navigateAssign();
		Thread.sleep(1000);
		IsmsAuditAssign_pageObj.filterAudit();
		Thread.sleep(1000);
		IsmsAuditAssign_pageObj.modifyAudit();
		Thread.sleep(1000);
		assert(IsmsAuditAssign_pageObj.auditAssigned()):"Reported audit finding has not been sent for rework";
		Thread.sleep(1000);
		IsmsAuditAssign_pageObj.modifyClickAudit();
		Thread.sleep(1000);
		IsmsAuditAssign_pageObj.resubmit();
		Thread.sleep(1000);
		assert(IsmsAuditAssign_pageObj.reportSubmitted()):"Admin has not Resubmitted a finding";
	}
	
	
	/*
	 * Verifying the audit finding re submission and its approval by ISMS audit admin.
	 */
	
	@Test(priority=5)
	public void resubmitAudit() throws Exception {
		Thread.sleep(1000);
		IsmsAuditSubmitted_pageObj.auditNum();
		Thread.sleep(3000);
		IsmsAuditImpersonnate_pageObj.impLogOut();
		Thread.sleep(3000);
		IsmsAuditImpersonnate_pageObj.impLogin();
		Thread.sleep(3000);
		IsmsAuditSubmitted_pageObj.navigateSubmitted();
		Thread.sleep(1000);
		IsmsAuditSubmitted_pageObj.filterAudit();
		Thread.sleep(1000);
		assert(IsmsAuditSubmitted_pageObj.auditSubmitted()):"Assigned audit finding has not been resubmitted";
		Thread.sleep(1000);
		IsmsAuditSubmitted_pageObj.approveAudit();
		Thread.sleep(1000);
		assert(IsmsAuditSubmitted_pageObj.approvedAudit()):"Admin has not approved the resubmitted finding";
	}
	
	
	/*
	 * Validates the resubmitted audit finding presence under open tab and its first level closure by SPOC
	 */
	
	@DataProvider(name = "auditOpenDataSPOCRework")
	public String[][] getauditOpenDataSPOCRework() {
		String[][] auditOpenDataSPOCRework = getData("ismsAudit.xlsx","open");
		return auditOpenDataSPOCRework;
	}
	
	@Test(priority=6,dataProvider="auditOpenDataSPOCRework")
	public void openAuditSPOCRework(String closurecomment,String Evidence,String runmode) throws Exception {
		Thread.sleep(1000);
		IsmsAuditOpen_pageObj.auditNum();
		Thread.sleep(1000);
		IsmsAuditImpersonnate_pageObj.impersonate();
		Thread.sleep(3000);
		IsmsAuditOpen_pageObj.navigateOpen();
		Thread.sleep(1000);
		IsmsAuditOpen_pageObj.filterAudit();
		Thread.sleep(1000);
		IsmsAuditOpen_pageObj.openAudit();
		Thread.sleep(1000);
		assert(IsmsAuditOpen_pageObj.auditOpen()):"Reported audit finding has not been sent for first level closure";
		Thread.sleep(1000);
		IsmsAuditOpen_pageObj.openAuditClose();
		Thread.sleep(2000);
		IsmsAuditOpen_pageObj.closureComment(closurecomment);
		Thread.sleep(1000);
		IsmsAuditOpen_pageObj.evidence(Evidence);
		Thread.sleep(1000);
		IsmsAuditOpen_pageObj.spocselectCorrection();
		Thread.sleep(1000);
		IsmsAuditOpen_pageObj.spocselectCorrectAction();
		Thread.sleep(1000);
		IsmsAuditOpen_pageObj.saveClose();
		Thread.sleep(1000);
		assert(IsmsAuditOpen_pageObj.closeAudit()):"Admin has not closed a finding";
	}
	
	
	/*
	 * Verifying the first level closure by SPOC and rework functionalities by admin
	 */
	
	@DataProvider(name = "auditCloseDataSPOCRework")
	public String[][] getauditCloseDataSPOCRework() {
		String[][] auditCloseDataSPOCRework = getData("ismsAudit.xlsx","close");
		return auditCloseDataSPOCRework;
	}
	
	@Test(priority=7, dataProvider="auditCloseDataSPOCRework")
	public void closedAuditSPOCRework(String reviewremark,String runmode) throws Exception {
		Thread.sleep(1000);
		IsmsAuditClosed_pageObj.auditNum();
		Thread.sleep(3000);
		IsmsAuditImpersonnate_pageObj.impLogOut();
		Thread.sleep(3000);
		IsmsAuditImpersonnate_pageObj.impLogin();
		Thread.sleep(3000);
		IsmsAuditClosed_pageObj.navigateClose();
		Thread.sleep(1000);
		IsmsAuditClosed_pageObj.filterAudit();
		Thread.sleep(1000);
		assert(IsmsAuditClosed_pageObj.auditClosed()):"Reported audit finding has not been closed";
		Thread.sleep(1000);
		IsmsAuditClosed_pageObj.closeAuditSpocRework();
		Thread.sleep(1000);
	}
	
	/*
	 * closing the rejected closed audit again by SPOC's
	 */
	
	@Test(priority=8)
	public void reopenAuditSPOCRework() throws Exception {
		Thread.sleep(1000);
		IsmsAuditOpen_pageObj.auditNum();
		Thread.sleep(1000);
		IsmsAuditImpersonnate_pageObj.impersonate();
		Thread.sleep(3000);
		IsmsAuditOpen_pageObj.navigateOpen();
		Thread.sleep(1000);
		IsmsAuditOpen_pageObj.filterAudit();
		Thread.sleep(1000);
		IsmsAuditOpen_pageObj.openAudit();
		Thread.sleep(1000);
		assert(IsmsAuditOpen_pageObj.auditOpen()):"Reported audit finding has not been sent for first level reclosure";
		Thread.sleep(1000);
		IsmsAuditOpen_pageObj.openAuditClose();
		Thread.sleep(2000);
		IsmsAuditOpen_pageObj.saveClose();
		Thread.sleep(1000);
		assert(IsmsAuditOpen_pageObj.closeAudit()):"Admin has not reclosed a finding";
	}
	
	
	/*
	 * Verifying the first level re closure by SPOC and final closure functionalities by admin
	 */
	
	@DataProvider(name = "auditCloseDataSPOCReworkApp")
	public String[][] getauditCloseDataSPOCReworkApp() {
		String[][] auditCloseDataSPOCReworkApp = getData("ismsAudit.xlsx","close");
		return auditCloseDataSPOCReworkApp;
	}
	
	@Test(priority=9, dataProvider="auditCloseDataSPOCReworkApp")
	public void closedAuditSPOCReworkApp(String reviewremark,String runmode) throws Exception {
		Thread.sleep(1000);
		IsmsAuditClosed_pageObj.auditNum();
		Thread.sleep(3000);
		IsmsAuditImpersonnate_pageObj.impLogOut();
		Thread.sleep(3000);
		IsmsAuditImpersonnate_pageObj.impLogin();
		Thread.sleep(3000);
		IsmsAuditClosed_pageObj.navigateClose();
		Thread.sleep(1000);
		IsmsAuditClosed_pageObj.filterAudit();
		Thread.sleep(1000);
		assert(IsmsAuditClosed_pageObj.auditClosed()):"Reported audit finding has not been closed";
		Thread.sleep(1000);
		IsmsAuditClosed_pageObj.closeAuditSpoc(reviewremark);
		Thread.sleep(1000);
		assert(IsmsAuditClosed_pageObj.closedAuditCheck()):"Closed audit finding has not been reviewed and not permanantly closed";
		Thread.sleep(1000);
	}
	@AfterClass
	public void exitApp() throws Exception{
		Thread.sleep(1000);
		IsmsAuditReport_pageObj.logOut();
		Thread.sleep(1000);
	}
}
