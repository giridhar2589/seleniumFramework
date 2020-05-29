package com.mu_sigma.OrgPlatformAutomationFramework.LeaveManagement.test;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.mu_sigma.OrgPlatformAutomationFramework.LeaveManagement.page.CommonElement_page;
import com.mu_sigma.OrgPlatformAutomationFramework.LeaveManagement.page.LeaveApplications_page;
import com.mu_sigma.OrgPlatformAutomationFramework.LeaveManagement.page.LeaveScheme_page;
import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;

public class ApplyLeaveFromAdminView_test extends TestBase {

	CommonElement_page commonElement_pageObj;
	LeaveScheme_page leaveScheme_pageObj;
	LeaveApplications_page leaveApplications_pageObj;
	SoftAssert softAssertObj = new SoftAssert();

	@BeforeClass
	public void setUp() throws Exception {
		init("leaveManagement_OwnServer");
		leaveScheme_pageObj = new LeaveScheme_page(driver);
		commonElement_pageObj = new CommonElement_page(driver);
		leaveApplications_pageObj = new LeaveApplications_page(driver);
		Thread.sleep(8000);
		loadProperties("leaveMangement.properties");
	}

	@DataProvider(name = "validLoginData")
	public String[][] getValidLogInData() {
		String[][] validloginData = getData("leaveManagement.xlsx", "validLoginData");
		return validloginData;
	}

	@Test(priority = 0, dataProvider = "validLoginData")
	public void loginLeaveManagement(String username, String password, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("User marked this Record as No Run");
		}
		commonElement_pageObj.fillLoginDetails(username, password);
	}

	@Test(priority = 1)
	public void applyLeaveExemptionfromAdminView() throws Exception {
		commonElement_pageObj.clickOnAdmin_tab();
		leaveApplications_pageObj.clickOnLeaveApplicationsTab();
		leaveApplications_pageObj.clickOnApplyLeave_btn();
		leaveApplications_pageObj.clearEmployeeName();
		leaveApplications_pageObj.selectEmployeefromApplyLeavePopUp("bis", "5554 - Biswajit Kundu ");
		leaveApplications_pageObj.selectTypeofLeave("Leave Exemption");
		leaveApplications_pageObj.clickFromCalendar_icon();
		commonElement_pageObj.selectYearFromCalendar("2018");
		commonElement_pageObj.selectMonthFromCalendar("SEP");
		commonElement_pageObj.selectMonthDateCalendarBody("21");
		leaveApplications_pageObj.selectFromSession1fromApplyLeavePopUp();
		leaveApplications_pageObj.clickToCalendar_icon();
		commonElement_pageObj.selectYearFromCalendar("2018");
		commonElement_pageObj.selectMonthFromCalendar("SEP");
		commonElement_pageObj.selectMonthDateCalendarBody("21");
		leaveApplications_pageObj.selectToSession2fromApplyLeavePopUp();
		leaveApplications_pageObj.editApplyLeaveReasonofAbsence("Testing Leave exemption schem from Admin view");
		leaveApplications_pageObj.clickOnLeaveApply_btn();
		leaveApplications_pageObj.clickOnApplyLeaveYes_popUp();
		softAssertObj.assertEquals(leaveApplications_pageObj.getLeaveApplicationAllResponse_msg(),
				"The leave has been applied and approved");
		Thread.sleep(3000);
		softAssertObj.assertAll();
	}

	@Test(priority = 2)
	public void overLapValidationForLeaveExemptionScheme() throws Exception {
		commonElement_pageObj.clickOnAdmin_tab();
		leaveApplications_pageObj.clickOnLeaveApplicationsTab();
		leaveApplications_pageObj.clickOnApplyLeave_btn();
		leaveApplications_pageObj.clearEmployeeName();
		leaveApplications_pageObj.selectEmployeefromApplyLeavePopUp("bis", "5554 - Biswajit Kundu ");
		leaveApplications_pageObj.selectTypeofLeave("Leave Exemption");
		leaveApplications_pageObj.clickFromCalendar_icon();
		commonElement_pageObj.selectYearFromCalendar("2018");
		commonElement_pageObj.selectMonthFromCalendar("SEP");
		commonElement_pageObj.selectMonthDateCalendarBody("21");
		leaveApplications_pageObj.selectFromSession1fromApplyLeavePopUp();
		leaveApplications_pageObj.clickToCalendar_icon();
		commonElement_pageObj.selectYearFromCalendar("2018");
		commonElement_pageObj.selectMonthFromCalendar("SEP");
		commonElement_pageObj.selectMonthDateCalendarBody("21");
		leaveApplications_pageObj.selectToSession2fromApplyLeavePopUp();
		leaveApplications_pageObj.editApplyLeaveReasonofAbsence("Testing Leave exemption overlap validation");
		softAssertObj.assertEquals(commonElement_pageObj.adminviewLeaveType_Error(), "Overlap of date for leave");
		Thread.sleep(3000);
		softAssertObj.assertAll();
		leaveApplications_pageObj.clickOnApplyLeaveClose_btn();
	}

	@Test(priority = 3)
	public void applyLeaveExemptionforFutureYear() throws Exception {
		commonElement_pageObj.clickOnAdmin_tab();
		leaveApplications_pageObj.clickOnLeaveApplicationsTab();
		leaveApplications_pageObj.clickOnApplyLeave_btn();
		leaveApplications_pageObj.clearEmployeeName();
		leaveApplications_pageObj.selectEmployeefromApplyLeavePopUp("bis", "5554 - Biswajit Kundu ");
		leaveApplications_pageObj.selectTypeofLeave("Leave Exemption");
		leaveApplications_pageObj.clickFromCalendar_icon();
		commonElement_pageObj.selectYearFromCalendar("2019");
		commonElement_pageObj.selectMonthFromCalendar("SEP");
		commonElement_pageObj.selectMonthDateCalendarBody("23");
		leaveApplications_pageObj.selectFromSession1fromApplyLeavePopUp();
		leaveApplications_pageObj.clickToCalendar_icon();
		commonElement_pageObj.selectYearFromCalendar("2019");
		commonElement_pageObj.selectMonthFromCalendar("SEP");
		commonElement_pageObj.selectMonthDateCalendarBody("23");
		leaveApplications_pageObj.selectToSession2fromApplyLeavePopUp();
		leaveApplications_pageObj.editApplyLeaveReasonofAbsence("Testing Leave exemption schem for future year");
		leaveApplications_pageObj.clickOnLeaveApply_btn();
		leaveApplications_pageObj.clickOnApplyLeaveYes_popUp();
		softAssertObj.assertEquals(leaveApplications_pageObj.getLeaveApplicationAllResponse_msg(),
				"The leave has been applied and approved");
		Thread.sleep(3000);
		softAssertObj.assertAll();
		
	}
	
	@Test(priority = 4)
	public void applyOnDutyLeaveScheme() throws Exception {
		commonElement_pageObj.clickOnAdmin_tab();
		leaveApplications_pageObj.clickOnLeaveApplicationsTab();
		leaveApplications_pageObj.clickOnApplyLeave_btn();
		leaveApplications_pageObj.clearEmployeeName();
		leaveApplications_pageObj.selectEmployeefromApplyLeavePopUp("mad", "8736 - Madan S ");
		leaveApplications_pageObj.selectTypeofLeave("On Duty");
		leaveApplications_pageObj.clickFromCalendar_icon();
		commonElement_pageObj.selectYearFromCalendar("2018");
		commonElement_pageObj.selectMonthFromCalendar("SEP");
		commonElement_pageObj.selectMonthDateCalendarBody("21");
		leaveApplications_pageObj.selectFromSession1fromApplyLeavePopUp();
		leaveApplications_pageObj.clickToCalendar_icon();
		commonElement_pageObj.selectYearFromCalendar("2018");
		commonElement_pageObj.selectMonthFromCalendar("SEP");
		commonElement_pageObj.selectMonthDateCalendarBody("21");
		leaveApplications_pageObj.selectToSession2fromApplyLeavePopUp();
		leaveApplications_pageObj.editApplyLeaveReasonofAbsence("Testing Leave exemption schem from Admin view");
		leaveApplications_pageObj.clickOnLeaveApply_btn();
		leaveApplications_pageObj.clickOnApplyLeaveYes_popUp();
		softAssertObj.assertEquals(leaveApplications_pageObj.getLeaveApplicationAllResponse_msg(),
				"The leave has been applied and approved");
		Thread.sleep(3000);
		softAssertObj.assertAll();
	}
	
	@Test(priority = 5)
	public void applyOnDutyLeaveSchemeforFutureYear() throws Exception {
		commonElement_pageObj.clickOnAdmin_tab();
		leaveApplications_pageObj.clickOnLeaveApplicationsTab();
		leaveApplications_pageObj.clickOnApplyLeave_btn();
		leaveApplications_pageObj.clearEmployeeName();
		leaveApplications_pageObj.selectEmployeefromApplyLeavePopUp("mad", "8736 - Madan S ");
		leaveApplications_pageObj.selectTypeofLeave("On Duty");
		leaveApplications_pageObj.clickFromCalendar_icon();
		commonElement_pageObj.selectYearFromCalendar("2019");
		commonElement_pageObj.selectMonthFromCalendar("DEC");
		commonElement_pageObj.selectMonthDateCalendarBody("6");
		leaveApplications_pageObj.selectFromSession1fromApplyLeavePopUp();
		leaveApplications_pageObj.clickToCalendar_icon();
		commonElement_pageObj.selectYearFromCalendar("2019");
		commonElement_pageObj.selectMonthFromCalendar("DEC");
		commonElement_pageObj.selectMonthDateCalendarBody("6");
		leaveApplications_pageObj.selectToSession2fromApplyLeavePopUp();
		leaveApplications_pageObj.editApplyLeaveReasonofAbsence("Testing Leave exemption schem for future year");
		leaveApplications_pageObj.clickOnLeaveApply_btn();
		leaveApplications_pageObj.clickOnApplyLeaveYes_popUp();
		softAssertObj.assertEquals(leaveApplications_pageObj.getLeaveApplicationAllResponse_msg(),
				"The leave has been applied and approved");
		Thread.sleep(3000);
		softAssertObj.assertAll();
	}
	
	
	@Test(priority=6)
	public void cancellApprovedApplication() throws Exception{
		commonElement_pageObj.clickOnAdmin_tab();
		leaveApplications_pageObj.clickOnLeaveApplicationsTab();
		leaveApplications_pageObj.clickLeaveApplicationAll_tab();
		leaveApplications_pageObj.clickOnFilterIcon();
		leaveApplications_pageObj.selectCountryFilters("India");
		leaveApplications_pageObj.selectEmployeeNamefromFilter("bisw", "5554 - Biswajit Kundu ");
		leaveApplications_pageObj.selectLeaveApplicationLeaveTypeStatusAll_tab("Approved ", 2);
		leaveApplications_pageObj.selectLeaveApplicationUnderAll_tab("5554",2);
		leaveApplications_pageObj.editRemarksField("Canceling the applied leave");
		leaveApplications_pageObj.clickOnCancelApplication_btn();
		leaveApplications_pageObj.clickOnApplyLeaveYes_popUp();
		softAssertObj.assertEquals(leaveApplications_pageObj.getLeaveApplicationAllResponse_msg(), "Leave cancelled successfully");
		Thread.sleep(3000);
		softAssertObj.assertAll();
		leaveApplications_pageObj.clickOnClearFilter_btnFromFilter();
		leaveApplications_pageObj.clickOnFilterIcon();
	}
	
	
	@Test(priority=7)
	public void rejectAppliedApplication() throws Exception{
		leaveApplications_pageObj.clickLeaveApplicationAll_tab();
		leaveApplications_pageObj.clickOnFilterIcon();
		leaveApplications_pageObj.selectCountryFilters("India");
		leaveApplications_pageObj.selectEmployeeNamefromFilter("bisw", "5554 - Biswajit Kundu ");
		leaveApplications_pageObj.selectLeaveApplicationLeaveTypeStatusAll_tab("Applied ", 4);
		leaveApplications_pageObj.selectLeaveApplicationUnderAll_tab("5554",4);
		leaveApplications_pageObj.editRemarksField("Rejecting the applied leave");
		leaveApplications_pageObj.clickOnRejectApplication_btn();
		leaveApplications_pageObj.clickOnApplyLeaveYes_popUp();
		softAssertObj.assertEquals(leaveApplications_pageObj.getLeaveApplicationAllResponse_msg(), "Leave rejected successfully");
		Thread.sleep(3000);
		softAssertObj.assertAll();
		leaveApplications_pageObj.clickOnClearFilter_btnFromFilter();
		leaveApplications_pageObj.clickOnFilterIcon();
	}
	
	@Test(priority=8)
	public void forwardAppliedLeaveApplication() throws Exception{
		leaveApplications_pageObj.clickLeaveApplicationAll_tab();
		leaveApplications_pageObj.clickOnFilterIcon();
		leaveApplications_pageObj.selectCountryFilters("India");
		leaveApplications_pageObj.selectEmployeeNamefromFilter("bisw", "5554 - Biswajit Kundu ");
		leaveApplications_pageObj.selectLeaveApplicationLeaveTypeStatusAll_tab("Applied ", 3);
		leaveApplications_pageObj.selectLeaveApplicationUnderAll_tab("5554",3);
		leaveApplications_pageObj.editRemarksField("Forwarding the applied leave");
		leaveApplications_pageObj.clickOnForwardLeaveApplication_btn();
		leaveApplications_pageObj.clickOnApplyLeaveYes_popUp();
		softAssertObj.assertEquals(leaveApplications_pageObj.getLeaveApplicationAllResponse_msg(), "Leave forwarded successfully");
		Thread.sleep(3000);
		softAssertObj.assertAll();
		leaveApplications_pageObj.clickOnClearFilter_btnFromFilter();
		leaveApplications_pageObj.clickOnFilterIcon();
	}
	
	@Test(priority=9)
	public void editForwardApplicationLeave() throws Exception{
		leaveApplications_pageObj.clickLeaveApplicationAll_tab();
		leaveApplications_pageObj.clickOnFilterIcon();
		leaveApplications_pageObj.selectCountryFilters("India");
		leaveApplications_pageObj.selectEmployeeNamefromFilter("bisw", "5554 - Biswajit Kundu ");
		leaveApplications_pageObj.selectLeaveApplicationLeaveTypeStatusAll_tab("Forwarded ", 3);
		leaveApplications_pageObj.selectLeaveApplicationUnderAll_tab("5554",3);
		leaveApplications_pageObj.clickOnEditLeaveApplications();
		leaveApplications_pageObj.clickFromCalendar_icon();
		commonElement_pageObj.selectYearFromCalendar("2018");
		commonElement_pageObj.selectMonthFromCalendar("SEP");
		commonElement_pageObj.selectMonthDateCalendarBody("3");
		leaveApplications_pageObj.clickToCalendar_icon();
		commonElement_pageObj.selectYearFromCalendar("2018");
		commonElement_pageObj.selectMonthFromCalendar("SEP");
		commonElement_pageObj.selectMonthDateCalendarBody("3");
		leaveApplications_pageObj.editLeaveApplicationRemarks_inputBox("Editing the Forward Leave application");
		leaveApplications_pageObj.clickOnEditLeaveApplicationSave_btn();
		//leaveApplications_pageObj.clickOnApplyLeaveYes_popUp();
		//Thread.sleep(3000);
		softAssertObj.assertEquals(leaveApplications_pageObj.getLeaveApplicationAllResponse_msg(), "Leave edited successfully");
		Thread.sleep(3000);
		softAssertObj.assertAll();
		leaveApplications_pageObj.clickOnClearFilter_btnFromFilter();
		leaveApplications_pageObj.clickOnFilterIcon();
	}
	
	
}
