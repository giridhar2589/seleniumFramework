package com.mu_sigma.OrgPlatformAutomationFramework.LeaveManagement.test;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.mu_sigma.OrgPlatformAutomationFramework.LeaveManagement.page.CommonElement_page;
import com.mu_sigma.OrgPlatformAutomationFramework.LeaveManagement.page.LeaveScheme_page;
import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;

public class OnDutyLeaveScheme_test extends TestBase {
	
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
	
	@DataProvider(name = "OnDutyLeaveScheme")
	public String[][] getValidOnDutyData() {
		String[][] validOnDutyData = getData("leaveManagement.xlsx", "OnDutyLeaveScheme");
		return validOnDutyData;
	}
	
	
	@Test(priority = 0, dataProvider = "validLoginData")
	public void loginLeaveManagement(String username, String password, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("User marked this Record as No Run");
		}
		commonElement_pageObj.fillLoginDetails(username, password);
	}
	
	@Test(priority=1,dataProvider="OnDutyLeaveScheme")
	public void createOnDutyScheme(String leaveSchemeName,String existingLeaveType,String year,String month,String date,String country) throws Exception{
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
		//Thread.sleep(3000);
		leaveScheme_pageObj.selectCountry(country);
		leaveScheme_pageObj.clickSchemePoliciesNext_btn();
		leaveScheme_pageObj.clickOnSave_btn();
		leaveScheme_pageObj.clickOnSaveSchemePopUp();
		softAssertObj.assertEquals(leaveScheme_pageObj.getAllResponse_msg(), "Leave Scheme added successfully");
		Thread.sleep(3000);
		softAssertObj.assertAll();
	}
	
	@Test(priority=2,dataProvider="OnDutyLeaveScheme")
	public void createDuplicateOnDutyScheme(String leaveSchemeName,String existingLeaveType,String year,String month,String date,String country) throws Exception{
		leaveScheme_pageObj.clickAddLeaveScheme_btn();
		leaveScheme_pageObj.editSchemeName(leaveSchemeName);
		leaveScheme_pageObj.selectExistingLeaveType(existingLeaveType);
		leaveScheme_pageObj.editminimumLeavesPerApplication_inputBox(propetiesOverloadObj.getProperty("halfDayLeavePerApplication"));
		leaveScheme_pageObj.clickOnFormCalendarIcon();
		commonElement_pageObj.selectYearFromCalendar(year);
		commonElement_pageObj.selectMonthFromCalendar(month);
		commonElement_pageObj.selectMonthDateCalendarBody(date);
		leaveScheme_pageObj.clickSchemeDefinationNext_btn();
		//Thread.sleep(3000);
		leaveScheme_pageObj.selectCountry(country);
		leaveScheme_pageObj.clickSchemePoliciesNext_btn();
		leaveScheme_pageObj.clickOnSave_btn();
		leaveScheme_pageObj.clickOnSaveSchemePopUp();
		softAssertObj.assertEquals(leaveScheme_pageObj.getAllResponse_msg(), "Leave scheme name already in use. Please choose a different one");
		Thread.sleep(2000);
		softAssertObj.assertAll();
		leaveScheme_pageObj.closePopUp();
	}
	
	@Test(priority=3)
	public void deleteOnDutyScheme() throws InterruptedException {
		leaveScheme_pageObj.selectExistingLeaveScheme(propetiesOverloadObj.getProperty("onDutySchemeCreation"));
		leaveScheme_pageObj.clickOndeleteScheme_btn();
		Thread.sleep(3000);
		leaveScheme_pageObj.clickOnSaveSchemePopUp();
		softAssertObj.assertEquals(leaveScheme_pageObj.getAllResponse_msg(), "Leave Scheme deleted successfully");
		Thread.sleep(3000);
		softAssertObj.assertAll();
	}
	
	@Test(priority=4,dataProvider="OnDutyLeaveScheme")
	public void againCreateOnDutyScheme(String leaveSchemeName,String existingLeaveType,String year,String month,String date,String country) throws Exception{
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
