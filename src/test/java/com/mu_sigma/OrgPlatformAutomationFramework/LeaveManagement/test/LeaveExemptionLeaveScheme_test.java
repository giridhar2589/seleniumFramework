package com.mu_sigma.OrgPlatformAutomationFramework.LeaveManagement.test;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.mu_sigma.OrgPlatformAutomationFramework.LeaveManagement.page.CommonElement_page;
import com.mu_sigma.OrgPlatformAutomationFramework.LeaveManagement.page.LeaveScheme_page;
import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;

public class LeaveExemptionLeaveScheme_test extends TestBase{

	CommonElement_page commonElement_pageObj;
	LeaveScheme_page leaveScheme_pageObj;
	SoftAssert softAssertObj = new SoftAssert();
	
	@BeforeClass
	public void setUp() throws Exception {
		init("leaveManagement_OwnServer");
		leaveScheme_pageObj = new LeaveScheme_page(driver);
		commonElement_pageObj = new CommonElement_page(driver);
		Thread.sleep(8000);
		loadProperties("leaveMangement.properties");
	}
	
	@DataProvider(name = "validLoginData")
	public String[][] getValidLogInData() {
		String[][] validloginData = getData("leaveManagement.xlsx", "validLoginData");
		return validloginData;
	}
	
	@DataProvider(name = "LeaveExemptionLeaveScheme")
	public String[][] getValidLeaveExemptionData() {
		String[][] validLeaveExemptionData = getData("leaveManagement.xlsx", "LeaveExemptionLeaveScheme");
		return validLeaveExemptionData;
	}
	
	@Test(priority = 0, dataProvider = "validLoginData")
	public void loginLeaveManagement(String username, String password, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("User marked this Record as No Run");
		}
		commonElement_pageObj.fillLoginDetails(username, password);
	}
	
	@Test(priority=1,dataProvider="LeaveExemptionLeaveScheme")
	public void createLeaveExemptionScheme(String leaveSchemeName,String existingLeaveType,String year,String month,String date,String country) throws Exception{
		commonElement_pageObj.clickOnAdmin_tab();
		leaveScheme_pageObj.clickOnLeaveScheme_tab();
		leaveScheme_pageObj.clickAddLeaveScheme_btn();
		leaveScheme_pageObj.editSchemeName(leaveSchemeName);
		leaveScheme_pageObj.selectExistingLeaveType(existingLeaveType);
		leaveScheme_pageObj.editminimumLeavesPerApplication_inputBox(propetiesOverloadObj.getProperty("halfDayLeavePerApplication"));
		leaveScheme_pageObj.clickOnFormCalendarIcon();
		commonElement_pageObj.selectYearFromCalendar(year);
		commonElement_pageObj.selectMonthFromCalendar(month);
		commonElement_pageObj.selectMonthDateCalendarBody(date);
		leaveScheme_pageObj.clickSchemeDefinationNext_btn();
		Thread.sleep(3000);
		leaveScheme_pageObj.selectCountry(country);
		leaveScheme_pageObj.clickSchemePoliciesNext_btn();
		leaveScheme_pageObj.clickOnSave_btn();
		leaveScheme_pageObj.clickOnSaveSchemePopUp();
		softAssertObj.assertEquals(leaveScheme_pageObj.getAllResponse_msg(), "Leave Scheme added successfully");
		softAssertObj.assertAll();
		Thread.sleep(3000);
	}
	
	@Test(priority=2,dataProvider="LeaveExemptionLeaveScheme")
	public void createDuplicateLeaveExemptionScheme(String leaveSchemeName,String existingLeaveType,String year,String month,String date,String country) throws Exception{
		leaveScheme_pageObj.clickAddLeaveScheme_btn();
		leaveScheme_pageObj.editSchemeName(leaveSchemeName);
		leaveScheme_pageObj.selectExistingLeaveType(existingLeaveType);
		leaveScheme_pageObj.editminimumLeavesPerApplication_inputBox(propetiesOverloadObj.getProperty("halfDayLeavePerApplication"));
		leaveScheme_pageObj.clickOnFormCalendarIcon();
		commonElement_pageObj.selectYearFromCalendar(year);
		commonElement_pageObj.selectMonthFromCalendar(month);
		commonElement_pageObj.selectMonthDateCalendarBody(date);
		leaveScheme_pageObj.clickSchemeDefinationNext_btn();
		Thread.sleep(3000);
		leaveScheme_pageObj.selectCountry(country);
		leaveScheme_pageObj.clickSchemePoliciesNext_btn();
		leaveScheme_pageObj.clickOnSave_btn();
		leaveScheme_pageObj.clickOnSaveSchemePopUp();
		softAssertObj.assertEquals(leaveScheme_pageObj.getAllResponse_msg(), "Leave scheme name already in use. Please choose a different one");
		softAssertObj.assertAll();
		Thread.sleep(2000);
		leaveScheme_pageObj.closePopUp();
	}
	
	@Test(priority=3)
	public void deleteLeaveExemptionScheme() throws InterruptedException {
		leaveScheme_pageObj.selectExistingLeaveScheme(propetiesOverloadObj.getProperty("leaveExemptionSchemeCreation"));
		leaveScheme_pageObj.clickOndeleteScheme_btn();
		leaveScheme_pageObj.clickOnSaveSchemePopUp();
		Thread.sleep(3000);
		softAssertObj.assertEquals(leaveScheme_pageObj.getAllResponse_msg(), "Leave Scheme deleted successfully");
		softAssertObj.assertAll();
	}
	
	@Test(priority=4,dataProvider="LeaveExemptionLeaveScheme")
	public void againCreateLeaveExemptionScheme(String leaveSchemeName,String existingLeaveType,String year,String month,String date,String country) throws Exception{
		leaveScheme_pageObj.clickAddLeaveScheme_btn();
		leaveScheme_pageObj.editSchemeName(leaveSchemeName);
		leaveScheme_pageObj.selectExistingLeaveType(existingLeaveType);
		leaveScheme_pageObj.editminimumLeavesPerApplication_inputBox(propetiesOverloadObj.getProperty("halfDayLeavePerApplication"));
		leaveScheme_pageObj.clickOnFormCalendarIcon();
		commonElement_pageObj.selectYearFromCalendar(year);
		commonElement_pageObj.selectMonthFromCalendar(month);
		commonElement_pageObj.selectMonthDateCalendarBody(date);
		leaveScheme_pageObj.clickSchemeDefinationNext_btn();
		Thread.sleep(3000);
		leaveScheme_pageObj.selectCountry(country);
		leaveScheme_pageObj.clickSchemePoliciesNext_btn();
		leaveScheme_pageObj.clickOnSave_btn();
		leaveScheme_pageObj.clickOnSaveSchemePopUp();
		softAssertObj.assertEquals(leaveScheme_pageObj.getAllResponse_msg(), "Leave Scheme added successfully");
		Thread.sleep(3000);
		softAssertObj.assertAll();
	}
	
	@Test(priority=5)
	public void logOutFromApplication() throws Exception{
		commonElement_pageObj.click_logOutButton();
	}
}
