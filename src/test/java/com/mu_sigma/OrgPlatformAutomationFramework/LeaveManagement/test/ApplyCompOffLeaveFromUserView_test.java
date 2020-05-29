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

public class ApplyCompOffLeaveFromUserView_test extends TestBase{
	
	UserView_page userView_pageObj;
	LeaveScheme_page LeaveScheme_pageObj;
	CommonElement_page commonElement_pageObj;
	SoftAssert softAssertObj = new SoftAssert();

	@BeforeClass
	public void setUp() throws Exception {
		init("leaveManagement_OwnServer");
		userView_pageObj = new UserView_page(driver);
		LeaveScheme_pageObj = new LeaveScheme_page(driver);
		commonElement_pageObj = new CommonElement_page(driver);
		loadProperties("leaveMangement.properties");
		Thread.sleep(4000);
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
	
	@DataProvider(name = "applyfullDayCompOffLeave")
	public String[][] getValidCopOffData() {
		String[][] validCompOffData = getData("leaveManagement.xlsx", "applyfullDayCompOffLeave");
		return validCompOffData;
	}
	
	@Test(priority = 1, dataProvider = "applyfullDayCompOffLeave")
	public void applyfullDayCompOffLeave(String leaveType, String fromYear, String fromMonth, String fromDate,
			String toYear, String toMonth, String toDate) throws Exception {
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
		userView_pageObj.selectFirstApprover();
		userView_pageObj.editLeaveReason("Testing Comp Off Leave Scheme");
		userView_pageObj.applyLeave();
		softAssertObj.assertEquals(userView_pageObj.getApplyLeave_count(), "(2 Days)");
		userView_pageObj.selectWithdrawPopUp_YesBtn();
		Thread.sleep(2000);
		softAssertObj.assertEquals(userView_pageObj.leaveCreationSucess_msg(), "Success");
		softAssertObj.assertAll();
		Thread.sleep(3000);
	}
	
	@DataProvider(name = "compOffOverLapData")
	public String[][] getCompOffOverLapData() {
		String[][] compOffOverLoadData = getData("leaveManagement.xlsx", "compOffOverLapData");
		return compOffOverLoadData;
	}
	
	@Test(priority = 2,dataProvider="compOffOverLapData")
	public void overlapValidation(String leaveType, String fromYear, String fromMonth, String fromDate,
			String toYear, String toMonth, String toDate) throws Exception {
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
		//softAssertObj.assertEquals(userView_pageObj.overlapLeaveError(), "Overlap of date for leave");
		softAssertObj.assertEquals(commonElement_pageObj.userviewLeaveType_Error(), "Overlap of date for leave");
		Thread.sleep(3000);
		softAssertObj.assertAll();
	}
	
	@DataProvider(name = "compOffWekendData")
	public String[][] getCompOffWeekEndData() {
		String[][] compOffWeekEndData = getData("leaveManagement.xlsx", "compOffWekendData");
		return compOffWeekEndData;
	}
	
	@Test(priority=3,dataProvider="compOffWekendData")
	public void applyLeaveonWeekend(String leaveType, String fromYear, String fromMonth, String fromDate,
			String toYear, String toMonth, String toDate){
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
		//softAssertObj.assertEquals(userView_pageObj.weekendLeaveError(),"Select valid days");
		softAssertObj.assertEquals(commonElement_pageObj.userviewLeaveType_Error(),"Select valid days");
		softAssertObj.assertAll();
	}
	
	@DataProvider(name = "compOffBeforeValidityData")
	public String[][] getCompOffeforeValidityFromDateData() {
		String[][] compOffBeforeValidityData = getData("leaveManagement.xlsx", "compOffBeforeValidityData");
		return compOffBeforeValidityData;
	}
	
	@Test(priority=4,dataProvider="compOffBeforeValidityData")
	public void applyCompOffBeforeValidityFromDate(String leaveType, String fromYear, String fromMonth, String fromDate,
			String toYear, String toMonth, String toDate) throws Exception{
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
		userView_pageObj.selectFirstApprover();
		userView_pageObj.clearEditLeaveReason();
		userView_pageObj.editLeaveReason("Testing Comp Off Before Validity From Date");
		//softAssertObj.assertEquals(userView_pageObj.compOffValidityError(), "For the selected date range, the available number of Comp Off are 0.0");
		softAssertObj.assertEquals(commonElement_pageObj.userviewLeaveType_Error(), "For the selected date range, the available number of Comp Off are 0.0");
		Thread.sleep(2000);
		softAssertObj.assertAll();
	}
	
	@DataProvider(name = "compOffToValidityData")
	public String[][] getCompOffAfterValidityToDateData() {
		String[][] compOffBeforeValidityData = getData("leaveManagement.xlsx", "compOffToValidityData");
		return compOffBeforeValidityData;
	}
	
	@Test(priority=5,dataProvider="compOffToValidityData")
	public void applyCompOffAfterValidityToDate(String leaveType, String fromYear, String fromMonth, String fromDate,
			String toYear, String toMonth, String toDate) throws Exception{
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
		userView_pageObj.selectFirstApprover();
		userView_pageObj.clearEditLeaveReason();
		userView_pageObj.editLeaveReason("Testing Comp Off Before Validity To Date");
		//softAssertObj.assertEquals(userView_pageObj.compOffValidityError(), "For the selected date range, the available number of Comp Off are 0.0");
		softAssertObj.assertEquals(commonElement_pageObj.userviewLeaveType_Error(),"For the selected date range, the available number of Comp Off are 0.0");
		Thread.sleep(2000);
		softAssertObj.assertAll();
	}
	
	@DataProvider(name = "LOPWithOtherLeaveType")
	public String[][] getLOPWithCompOffLeaveData() {
		String[][] compOffBeforeValidityData = getData("leaveManagement.xlsx", "LOPWithOtherLeaveType");
		return compOffBeforeValidityData;
	}
	
	@Test(priority=6,dataProvider="LOPWithOtherLeaveType")
	public void applyLOPWithCompOffLeave(String leaveType, String fromYear, String fromMonth, String fromDate,
			String toYear, String toMonth, String toDate) throws Exception {
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
		Thread.sleep(3000);
		//softAssertObj.assertEquals(userView_pageObj.avilableLeaveLOPError(),"Use available leaves before applying for LOP");
		softAssertObj.assertEquals(commonElement_pageObj.userviewLeaveType_Error(),"Use available leaves before applying for LOP");
		softAssertObj.assertAll();
	}
	
	@Test(priority=7)
	public void logOutFromApplication() throws Exception{
		commonElement_pageObj.click_logOutButton();
	}

}
