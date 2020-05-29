package com.mu_sigma.OrgPlatformAutomationFramework.LeaveManagement.test;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.mu_sigma.OrgPlatformAutomationFramework.LeaveManagement.page.CommonElement_page;
import com.mu_sigma.OrgPlatformAutomationFramework.LeaveManagement.page.EarnLeaveScheme_page;
import com.mu_sigma.OrgPlatformAutomationFramework.LeaveManagement.page.LeaveApplications_page;
import com.mu_sigma.OrgPlatformAutomationFramework.LeaveManagement.page.LeaveScheme_page;
import com.mu_sigma.OrgPlatformAutomationFramework.LeaveManagement.page.UserView_page;
import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;

public class LOPLeaveSchemeValidation_test extends TestBase {
	LeaveScheme_page LeaveScheme_pageObj;
	EarnLeaveScheme_page LeaveSchemeObj;
	LeaveApplications_page LeaveApplications_pageObj;
	UserView_page userView_pageObj;
	CommonElement_page commonElement_pageObj;
	SoftAssert softAssertObj = new SoftAssert();

	@BeforeClass
	public void setUp() throws Exception {
		init("leaveManagement_OwnServer");
		LeaveScheme_pageObj = new LeaveScheme_page(driver);
		LeaveSchemeObj = new EarnLeaveScheme_page(driver);
		commonElement_pageObj= new CommonElement_page(driver);
		userView_pageObj= new UserView_page(driver);
		LeaveApplications_pageObj= new LeaveApplications_page(driver);
		loadProperties("leaveMangement.properties");
		Thread.sleep(8000);
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
	public void editLeaveScheme() throws Exception {
		commonElement_pageObj.clickOnAdmin_tab();
		LeaveScheme_pageObj.clickOnLeaveScheme_tab();
		LeaveScheme_pageObj.selectExistingLeaveScheme("LOP");
		LeaveScheme_pageObj.clearminimumLeavesPerApplication_inputBox();
		LeaveScheme_pageObj.editminimumLeavesPerApplication_inputBox(
				propetiesOverloadObj.getProperty("oneDayLeavePerApplication"));
		LeaveScheme_pageObj.clickEditLeavesche_saveBtn();
		LeaveScheme_pageObj.clickOnSaveSchemePopUp();
		softAssertObj.assertEquals(LeaveScheme_pageObj.getAllResponse_msg(), "Scheme edited successfully");
		commonElement_pageObj.clickOnHome_tab();
		userView_pageObj.selectTypeofLeave("LOP");
		userView_pageObj.clickOnFormCalendarIcon();
		commonElement_pageObj.selectYearFromCalendar("2018");
		commonElement_pageObj.selectMonthFromCalendar("AUG");
		commonElement_pageObj.selectMonthDateCalendarBody("13");
		userView_pageObj.selectFromsession1();
		userView_pageObj.clickOnToCalendarIcon();
		commonElement_pageObj.selectYearFromCalendar("2018");
		commonElement_pageObj.selectMonthFromCalendar("AUG");
		commonElement_pageObj.selectMonthDateCalendarBody("13");
		userView_pageObj.selectTosession1();
		userView_pageObj.selectFirstApprover();
		userView_pageObj.editLeaveReason("testing edit leave application feature");
		/*userView_pageObj.applyLeave();
		userView_pageObj.selectWithdrawPopUp_YesBtn();*/
		Thread.sleep(2000);
		softAssertObj.assertEquals(userView_pageObj.minimumLeaveError(), "Minimum number of days can be applied is 1.0");
		softAssertObj.assertAll();
	}

	@Test(priority = 2)
	public void nothingEditedLeaveSchemeValidation() throws Exception {
		commonElement_pageObj.clickOnAdmin_tab();
		LeaveScheme_pageObj.clickOnLeaveScheme_tab();
		LeaveScheme_pageObj.selectExistingLeaveScheme("LOP");
		LeaveScheme_pageObj.clearminimumLeavesPerApplication_inputBox();
		LeaveScheme_pageObj.editminimumLeavesPerApplication_inputBox(
				propetiesOverloadObj.getProperty("oneDayLeavePerApplication"));
		LeaveScheme_pageObj.clickEditLeavesche_saveBtn();
		LeaveScheme_pageObj.clickOnSaveSchemePopUp();
		softAssertObj.assertEquals(LeaveScheme_pageObj.getAllResponse_msg(), "Nothing is edited");
		softAssertObj.assertAll();
		LeaveScheme_pageObj.closePopUp();
		Thread.sleep(3000);
	}
	
	@Test(priority=3)
	public void editLeaveSchemeWithHalfdayValidation(){
		LeaveScheme_pageObj.clickOnLeaveScheme_tab();
		LeaveScheme_pageObj.selectExistingLeaveScheme("LOP");
		LeaveScheme_pageObj.clearminimumLeavesPerApplication_inputBox();
		LeaveScheme_pageObj.editminimumLeavesPerApplication_inputBox(
				propetiesOverloadObj.getProperty("halfDayLeavePerApplication"));
		LeaveScheme_pageObj.clickEditLeavesche_saveBtn();
		LeaveScheme_pageObj.clickOnSaveSchemePopUp();
		softAssertObj.assertEquals(LeaveScheme_pageObj.getAllResponse_msg(), "Scheme edited successfully");
		softAssertObj.assertAll();
	}
	
	@Test(priority=4)
	public void designationChnageValidation() throws Exception{
		LeaveScheme_pageObj.clickOnLeaveScheme_tab();
		LeaveScheme_pageObj.selectExistingLeaveScheme("LOP");
		LeaveScheme_pageObj.clickOnSchemePolicies_tab();
		LeaveScheme_pageObj.leaveSchemeSelectDesignation("Account Manager");
		Thread.sleep(3000);
		LeaveScheme_pageObj.clickOnSchemeSplit_tab();
		LeaveScheme_pageObj.clickOnSchemePolicies_tab();
		LeaveScheme_pageObj.clickEditLeavesche_saveBtn();
		LeaveScheme_pageObj.clickOnSaveSchemePopUp();
		Thread.sleep(3000);
		/*LeaveApplications_pageObj.clickOnLeaveApplicationsTab();
		LeaveApplications_pageObj.clickOnApplyLeave_btn();
		LeaveApplications_pageObj.selectEmployeefromApplyLeavePopUp("bis","5554 - Biswajit Kundu ");
		LeaveApplications_pageObj.clickOnSelectLeaveTypeDropDown();
		LeaveApplications_pageObj.selectFromSession1fromApplyLeavePopUp();
		softAssertObj.assertEquals(LeaveApplications_pageObj.getNoLeaveError_msg(),"No leaves available");
		LeaveApplications_pageObj.clickOnApplyLeaveClose_btn();
		LeaveScheme_pageObj.clickOnLeaveScheme_tab();
		LeaveScheme_pageObj.selectExistingLeaveScheme("LOP");
		LeaveScheme_pageObj.clickOnSchemePolicies_tab();
		LeaveScheme_pageObj.leaveSchemeSelectDesignation("Account Manager");
		LeaveScheme_pageObj.clickOnSchemeSplit_tab();
		LeaveScheme_pageObj.clickOnSchemePolicies_tab();
		LeaveScheme_pageObj.clickEditLeavesche_saveBtn();
		LeaveScheme_pageObj.clickOnSaveSchemePopUp();
		softAssertObj.assertEquals(LeaveScheme_pageObj.getAllResponse_msg(), "Scheme edited successfully");*/
	}
	
	/*@Test(priority=3)
	public void afterEditLeaveSchemeFullDayValidation() throws Exception{
		LeaveApplications_pageObj.clickOnLeaveApplicationsTab();
		LeaveApplications_pageObj.clickOnApplyLeave_btn();
		LeaveApplications_pageObj.selectEmployeefromApplyLeavePopUp("bisw","5554 - Biswajit Kundu ");
		LeaveApplications_pageObj.selectTypeofLeave("LOP");
		LeaveApplications_pageObj.clickFromCalendar_icon();
		LeaveApplications_pageObj.selectYearFromCalendar("2018");
		LeaveApplications_pageObj.selectMonthFromCalendar("DEC");
		LeaveApplications_pageObj.selectMonthDateCalendarBody("7");
		LeaveApplications_pageObj.selectFromSession1fromApplyLeavePopUp();
		LeaveApplications_pageObj.clickToCalendar_icon();
		LeaveApplications_pageObj.selectYearFromCalendar("2018");
		LeaveApplications_pageObj.selectMonthFromCalendar("DEC");
		LeaveApplications_pageObj.selectMonthDateCalendarBody("7");
		LeaveApplications_pageObj.selectToSession1fromApplyLeavePopUp();
		softAssertObj.assertEquals(LeaveApplications_pageObj.getMinimumLeaveError_msg(), "Minimum number of days can be applied is 1.0");
		LeaveApplications_pageObj.clickOnApplyLeaveClose_btn();
	}
	
	@Test(priority=4)
	public void applyFullDayLeave() throws Exception{
		LeaveApplications_pageObj.clickOnLeaveApplicationsTab();
		LeaveApplications_pageObj.clickOnApplyLeave_btn();
		LeaveApplications_pageObj.selectEmployeefromApplyLeavePopUp("bisw","5554 - Biswajit Kundu ");
		LeaveApplications_pageObj.selectTypeofLeave("LOP");
		LeaveApplications_pageObj.clickFromCalendar_icon();
		LeaveApplications_pageObj.selectYearFromCalendar("2018");
		LeaveApplications_pageObj.selectMonthFromCalendar("DEC");
		LeaveApplications_pageObj.selectMonthDateCalendarBody("7");
		LeaveApplications_pageObj.selectFromSession1fromApplyLeavePopUp();
		LeaveApplications_pageObj.clickToCalendar_icon();
		LeaveApplications_pageObj.selectYearFromCalendar("2018");
		LeaveApplications_pageObj.selectMonthFromCalendar("DEC");
		LeaveApplications_pageObj.selectMonthDateCalendarBody("7");
		LeaveApplications_pageObj.selectToSession2fromApplyLeavePopUp();
		LeaveApplications_pageObj.editApplyLeaveReasonofAbsence("Testing Full day Leave");
		LeaveApplications_pageObj.clickOnApplyLeaveApply_btn();
		Thread.sleep(2000);
		LeaveApplications_pageObj.clickOnApplyLeaveYes_popUp();
		softAssertObj.assertEquals(LeaveApplications_pageObj.getLeaveApplicationAllResponse_msg(), "The leave has been applied and approved");
	}
	
	@Test(priority=4)
	public void againEditLeaveScheme(){
		LeaveScheme_pageObj.clickOnLeaveScheme_tab();
		LeaveScheme_pageObj.selectExistingLeaveScheme("LOP");
		LeaveScheme_pageObj.clearminimumLeavesPerApplication_inputBox();
		LeaveScheme_pageObj.editminimumLeavesPerApplication_inputBox(
				propetiesOverloadObj.getProperty("halfDayLeavePerApplication"));
		LeaveScheme_pageObj.clickEditLeavesche_saveBtn();
		LeaveScheme_pageObj.clickOnSaveSchemePopUp();
		softAssertObj.assertEquals(LeaveScheme_pageObj.getAllResponse_msg(), "Scheme edited successfully");
	}
	
	@Test(priority=6)
	public void applyHalfDayLeave() throws Exception{
		LeaveApplications_pageObj.clickOnLeaveApplicationsTab();
		LeaveApplications_pageObj.clickOnApplyLeave_btn();
		LeaveApplications_pageObj.selectEmployeefromApplyLeavePopUp("bisw","5554 - Biswajit Kundu ");
		LeaveApplications_pageObj.selectTypeofLeave("LOP");
		LeaveApplications_pageObj.clickFromCalendar_icon();
		LeaveApplications_pageObj.selectYearFromCalendar("2018");
		LeaveApplications_pageObj.selectMonthFromCalendar("AUG");
		LeaveApplications_pageObj.selectMonthDateCalendarBody("24");
		LeaveApplications_pageObj.selectFromSession1fromApplyLeavePopUp();
		LeaveApplications_pageObj.clickToCalendar_icon();
		LeaveApplications_pageObj.selectYearFromCalendar("2018");
		LeaveApplications_pageObj.selectMonthFromCalendar("AUG");
		LeaveApplications_pageObj.selectMonthDateCalendarBody("24");
		LeaveApplications_pageObj.selectToSession1fromApplyLeavePopUp();
		LeaveApplications_pageObj.editApplyLeaveReasonofAbsence("Testing half day day Leave");
		LeaveApplications_pageObj.clickOnApplyLeaveApply_btn();
		Thread.sleep(2000);
		LeaveApplications_pageObj.clickOnApplyLeaveYes_popUp();
		softAssertObj.assertEquals(LeaveApplications_pageObj.getLeaveApplicationAllResponse_msg(), "The leave has been applied and approved");
	}
	
	@Test(priority=5)
	public void designationChnageValidation() throws Exception{
		LeaveScheme_pageObj.clickOnLeaveScheme_tab();
		LeaveScheme_pageObj.selectExistingLeaveScheme("LOP");
		LeaveScheme_pageObj.clickOnSchemePolicies_tab();
		LeaveScheme_pageObj.leaveSchemeSelectDesignation("Account Manager");
		LeaveScheme_pageObj.clickEditLeavesche_saveBtn();
		LeaveScheme_pageObj.clickOnSaveSchemePopUp();
		Thread.sleep(3000);
		LeaveApplications_pageObj.clickOnLeaveApplicationsTab();
		LeaveApplications_pageObj.clickOnApplyLeave_btn();
		LeaveApplications_pageObj.selectEmployeefromApplyLeavePopUp("bisw","5554");
		LeaveApplications_pageObj.clickOnSelectLeaveTypeDropDown();
		LeaveApplications_pageObj.selectFromSession1fromApplyLeavePopUp();
		softAssertObj.assertEquals(LeaveApplications_pageObj.getNoLeaveError_msg(),"No leaves available");
		LeaveApplications_pageObj.clickOnApplyLeaveClose_btn();
		LeaveScheme_pageObj.clickOnLeaveScheme_tab();
		LeaveScheme_pageObj.selectExistingLeaveScheme("LOP");
		LeaveScheme_pageObj.clickOnSchemePolicies_tab();
		LeaveScheme_pageObj.leaveSchemeSelectDesignation("Apprentice Leader");
		LeaveScheme_pageObj.clickEditLeavesche_saveBtn();
		LeaveScheme_pageObj.clickOnSaveSchemePopUp();
		softAssertObj.assertEquals(LeaveScheme_pageObj.getAllResponse_msg(), "Scheme edited successfully");
	}
	
	@Test(priority=8)
	public void genderValidationOnLeaveScheme(){
		LeaveScheme_pageObj.selectExistingLeaveScheme("LOP");
		LeaveScheme_pageObj.clickOnSchemePolicies_tab();
		LeaveScheme_pageObj.selectGenderFromSchemePolicies("Female");
		LeaveScheme_pageObj.clickEditLeavesche_saveBtn();
		LeaveScheme_pageObj.clickOnSaveSchemePopUp();
		softAssertObj.assertEquals(LeaveScheme_pageObj.getAllResponse_msg(), "Scheme edited successfully");
	}*/
}
