package com.mu_sigma.OrgPlatformAutomationFramework.LeaveManagement.test;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.mu_sigma.OrgPlatformAutomationFramework.LeaveManagement.page.CommonElement_page;
import com.mu_sigma.OrgPlatformAutomationFramework.LeaveManagement.page.LeaveScheme_page;
import com.mu_sigma.OrgPlatformAutomationFramework.LeaveManagement.page.UserView_page;
import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;

public class ApplyLOPFromUserVIew_test extends TestBase {
	UserView_page userView_pageObj;
	LeaveScheme_page LeaveScheme_pageObj;
	CommonElement_page commonElement_pageObj;
	SoftAssert softAssertObj = new SoftAssert();

	@BeforeClass
	public void setUp() throws Exception {
		init("leaveManagement_OwnServer");
		userView_pageObj= new UserView_page(driver);
		LeaveScheme_pageObj= new LeaveScheme_page(driver);
		commonElement_pageObj= new CommonElement_page(driver);
		loadProperties("leaveMangement.properties");
		Thread.sleep(8000);
	}

	
	@DataProvider(name = "appliedLOPTestdata")
	public String[][] getapplyLOPData() {
		String[][] lopData = getData("leaveManagement.xlsx", "appliedLOPTestdata");
		return lopData;
	}
	
	@DataProvider(name = "weekendLOPTestdata")
	public String[][] getWeekendLOPData() {
		String[][] weekendLopData = getData("leaveManagement.xlsx", "weekendLOPTestdata");
		return weekendLopData;
	}
	
	@DataProvider(name = "holidatyLOPTestdata")
	public String[][] getHolidayLOPData() {
		String[][] holidayLOPData = getData("leaveManagement.xlsx", "holidatyLOPTestdata");
		return holidayLOPData;
	}
	
	@DataProvider(name = "editLeaveSchemeDate")
	public String[][] getEditLOPLeaveSchemeData() {
		String[][] editLOPLeaveScheme = getData("leaveManagement.xlsx", "editLeaveSchemeDate");
		return editLOPLeaveScheme;
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
	
	@Test(priority=1,dataProvider="appliedLOPTestdata")
	public void applyLopLeave(String leaveType,String fromYear,String fromMonth,String fromDate,String toYear,String toMonth,String toDate,String reason) throws Exception{
		commonElement_pageObj.clickOnHome_tab();
		userView_pageObj.selectTypeofLeave(leaveType);
		userView_pageObj.clickOnFormCalendarIcon();
		commonElement_pageObj.selectYearFromCalendar(fromYear);
		commonElement_pageObj.selectMonthFromCalendar(fromMonth);
		commonElement_pageObj.selectMonthDateCalendarBody(fromDate);
		userView_pageObj.selectFromsession1();
		userView_pageObj.clickOnToCalendarIcon();
		commonElement_pageObj.selectYearFromCalendar(toYear);
		commonElement_pageObj.selectMonthFromCalendar(toMonth);
		commonElement_pageObj.selectMonthDateCalendarBody(toDate);
		userView_pageObj.selectTosession1();
		userView_pageObj.selectFirstApprover();
		userView_pageObj.editLeaveReason(reason);
		userView_pageObj.applyLeave();
		Thread.sleep(3000);
		softAssertObj.assertEquals(userView_pageObj.getApplyLeave_count(), "(0.5 Day)");
		userView_pageObj.selectWithdrawPopUp_YesBtn();
		Thread.sleep(2000);
		softAssertObj.assertEquals(userView_pageObj.leaveCreationSucess_msg(), "Success");
		Thread.sleep(3000);
		softAssertObj.assertAll();
	}
	
	@Test(priority=2,dataProvider="appliedLOPTestdata")
	public void overlapValidation(String leaveType,String fromYear,String fromMonth,String fromDate,String toYear,String toMonth,String toDate,String reason) throws InterruptedException{
		commonElement_pageObj.clickOnHome_tab();
		userView_pageObj.selectTypeofLeave(leaveType);
		userView_pageObj.clickOnFormCalendarIcon();
		commonElement_pageObj.selectYearFromCalendar(fromYear);
		commonElement_pageObj.selectMonthFromCalendar(fromMonth);
		commonElement_pageObj.selectMonthDateCalendarBody(fromDate);
		userView_pageObj.selectFromsession1();
		userView_pageObj.clickOnToCalendarIcon();
		commonElement_pageObj.selectYearFromCalendar(toYear);
		commonElement_pageObj.selectMonthFromCalendar(toMonth);
		commonElement_pageObj.selectMonthDateCalendarBody(toDate);
		userView_pageObj.selectTosession2();
		softAssertObj.assertEquals(userView_pageObj.overlapLeaveError(),"Overlap of date for leave");
		Thread.sleep(3000);
		softAssertObj.assertAll();
	}
	@Test(priority=3,dataProvider="weekendLOPTestdata")
	public void applyLeaveonWeekend(String leaveType,String fromYear,String fromMonth,String fromDate,String toYear ,String toMonth,String 	toDate) throws Exception{
		userView_pageObj.selectTypeofLeave(leaveType);
		userView_pageObj.clickOnFormCalendarIcon();
		commonElement_pageObj.selectYearFromCalendar(fromYear);
		commonElement_pageObj.selectMonthFromCalendar(fromMonth);
		commonElement_pageObj.selectMonthDateCalendarBody(fromDate);
		userView_pageObj.selectFromsession1();
		userView_pageObj.clickOnToCalendarIcon();
		commonElement_pageObj.selectYearFromCalendar(toYear);
		commonElement_pageObj.selectMonthFromCalendar(toMonth);
		commonElement_pageObj.selectMonthDateCalendarBody(toDate);
		userView_pageObj.selectTosession2();
		softAssertObj.assertEquals(userView_pageObj.weekendLeaveError(),"Select valid days");
		Thread.sleep(3000);
		softAssertObj.assertAll();
	}
	
	@Test(priority=4,dataProvider="holidatyLOPTestdata")
	public void applyLeaveOnHoliday(String leaveType,String fromYear,String fromMonth,String fromDate,String toYear ,String toMonth,String 	toDate) throws Exception{
		userView_pageObj.selectTypeofLeave(leaveType);
		userView_pageObj.clickOnFormCalendarIcon();
		commonElement_pageObj.selectYearFromCalendar(fromYear);
		commonElement_pageObj.selectMonthFromCalendar(fromMonth);
		commonElement_pageObj.selectMonthDateCalendarBody(fromDate);
		userView_pageObj.selectFromsession1();
		userView_pageObj.clickOnToCalendarIcon();
		commonElement_pageObj.selectYearFromCalendar(toYear);
		commonElement_pageObj.selectMonthFromCalendar(toMonth);
		commonElement_pageObj.selectMonthDateCalendarBody(toDate);
		userView_pageObj.selectTosession2();
		softAssertObj.assertEquals(userView_pageObj.weekendLeaveError(),"Select valid days");
		Thread.sleep(3000);
		softAssertObj.assertAll();
	}
	
	@Test(priority=5,dataProvider="editLeaveSchemeDate")
	public void editLeaveSchemeValidation(String leaveType,String fromYear,String fromMonth,String fromDate,String toYear,String toMonth,String toDate) throws Exception{
		commonElement_pageObj.clickOnAdmin_tab();
		LeaveScheme_pageObj.clickOnLeaveScheme_tab();
		LeaveScheme_pageObj.selectExistingLeaveScheme("LOP");
		LeaveScheme_pageObj.clearminimumLeavesPerApplication_inputBox();
		LeaveScheme_pageObj.editminimumLeavesPerApplication_inputBox(propetiesOverloadObj.getProperty("oneDayLeavePerApplication"));
		LeaveScheme_pageObj.clickEditLeavesche_saveBtn();
		LeaveScheme_pageObj.clickOnSaveSchemePopUp();
		Thread.sleep(3000);
		commonElement_pageObj.clickOnHome_tab();
		userView_pageObj.selectTypeofLeave(leaveType);
		userView_pageObj.clickOnFormCalendarIcon();
		commonElement_pageObj.selectYearFromCalendar(fromYear);
		commonElement_pageObj.selectMonthFromCalendar(fromMonth);
		commonElement_pageObj.selectMonthDateCalendarBody(fromDate);
		userView_pageObj.selectFromsession1();
		userView_pageObj.clickOnToCalendarIcon();
		commonElement_pageObj.selectYearFromCalendar(toYear);
		commonElement_pageObj.selectMonthFromCalendar(toMonth);
		commonElement_pageObj.selectMonthDateCalendarBody(toDate);
		userView_pageObj.selectTosession1();
		userView_pageObj.selectFirstApprover();
		softAssertObj.assertEquals(userView_pageObj.minimumLeaveError(), "Minimum number of days can be applied is 1.0");
		Thread.sleep(3000);
		softAssertObj.assertAll();
	}
	
	
	
	@Test(priority=6)
	public void remindAppliedLeave() throws Exception{
		userView_pageObj.recentActivity(propetiesOverloadObj.getProperty("recentActivityasLOPleave"), 1);
		userView_pageObj.clickReminder_btn();
		userView_pageObj.selectWithdrawPopUp_YesBtn();
		Thread.sleep(2000);
		softAssertObj.assertEquals(userView_pageObj.leaveReminder_msg(),"Reminder sent successfully.");
		Thread.sleep(3000);
		softAssertObj.assertAll();
		userView_pageObj.closeAppliedLeave_popUp();
	}
	
	@Test(priority=7)
	public void withdrawAppliedLeave() throws Exception{
		commonElement_pageObj.clickOnAdmin_tab();
		LeaveScheme_pageObj.clickOnLeaveScheme_tab();
		LeaveScheme_pageObj.selectExistingLeaveScheme(propetiesOverloadObj.getProperty("selectLeaveSchemeAsLOP"));
		LeaveScheme_pageObj.clearminimumLeavesPerApplication_inputBox();
		LeaveScheme_pageObj.editminimumLeavesPerApplication_inputBox(propetiesOverloadObj.getProperty("halfDayLeavePerApplication"));
		LeaveScheme_pageObj.clickEditLeavesche_saveBtn();
		LeaveScheme_pageObj.clickOnSaveSchemePopUp();
		Thread.sleep(3000);
		commonElement_pageObj.clickOnHome_tab();
		userView_pageObj.recentActivity(propetiesOverloadObj.getProperty("recentActivityasLOPleave"), 1);
		userView_pageObj.withDrawAppliedLeave();
		userView_pageObj.selectWithdrawPopUp_YesBtn();
		Thread.sleep(2000);
		softAssertObj.assertEquals(userView_pageObj.getWithdraw_msg(),"Success");
		Thread.sleep(3000);
		softAssertObj.assertAll();
		userView_pageObj.closeAppliedLeave_popUp();
	}
	
	/*@Test(priority=8)
	public void applyLOPNextYear() throws Exception{
		commonElement_pageObj.clickOnHome_tab();
		userView_pageObj.selectTypeofLeave("LOP");
		userView_pageObj.clickOnFormCalendarIcon();
		commonElement_pageObj.selectYearFromCalendar("2019");
		commonElement_pageObj.selectMonthFromCalendar("JAN");
		commonElement_pageObj.selectMonthDateCalendarBody("3");
		userView_pageObj.selectFromsession1();
		userView_pageObj.clickOnToCalendarIcon();
		commonElement_pageObj.selectYearFromCalendar("2019");
		commonElement_pageObj.selectMonthFromCalendar("JAN");
		commonElement_pageObj.selectMonthDateCalendarBody("3");
		userView_pageObj.selectTosession2();
		userView_pageObj.selectFirstApprover();
		userView_pageObj.editLeaveReason("Applying LOP for next year");
		softAssertObj.assertEquals(userView_pageObj.getnextYearLOPError_msg(), "Can't be applied for next year");
		softAssertObj.assertAll();
		Thread.sleep(4000);
	}*/
	
	/*@Test(priority=8)
	public void sandwhichLeaveValidation() throws Exception{
		commonElement_pageObj.clickOnHome_tab();
		userView_pageObj.clickOnClear_btn();
		userView_pageObj.selectTypeofLeave("LOP");
		userView_pageObj.clickOnFormCalendarIcon();
		commonElement_pageObj.selectYearFromCalendar("2018");
		commonElement_pageObj.selectMonthFromCalendar("DEC");
		commonElement_pageObj.selectMonthDateCalendarBody("21");
		userView_pageObj.selectFromsession1();
		userView_pageObj.clickOnToCalendarIcon();
		commonElement_pageObj.selectYearFromCalendar("2018");
		commonElement_pageObj.selectMonthFromCalendar("DEC");
		commonElement_pageObj.selectMonthDateCalendarBody("24");
		userView_pageObj.selectTosession2();
		userView_pageObj.selectFirstApprover();
		userView_pageObj.clearEditLeaveReasonField();
		userView_pageObj.editLeaveReason("Testing sandwich leave");
		userView_pageObj.applyLeave();
		softAssertObj.assertEquals(userView_pageObj.getApplyLeave_count(), "(4 Days)");
		Thread.sleep(3000);
		userView_pageObj.selectWithdrawPopUp_YesBtn();
		Thread.sleep(2000);
		softAssertObj.assertEquals(userView_pageObj.leaveCreationSucess_msg(), "Success");
		Thread.sleep(2000);
		softAssertObj.assertAll();
	}*/
	
	@Test(priority=9)
	public void logOutFromApplication() throws Exception{
		commonElement_pageObj.click_logOutButton();
	}
	
}
