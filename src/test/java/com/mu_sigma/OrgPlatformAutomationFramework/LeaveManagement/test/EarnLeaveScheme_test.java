package com.mu_sigma.OrgPlatformAutomationFramework.LeaveManagement.test;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.mu_sigma.OrgPlatformAutomationFramework.LeaveManagement.page.CommonElement_page;
import com.mu_sigma.OrgPlatformAutomationFramework.LeaveManagement.page.EarnLeaveScheme_page;
import com.mu_sigma.OrgPlatformAutomationFramework.LeaveManagement.page.LeaveType_page;
import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;

public class EarnLeaveScheme_test extends TestBase {

	EarnLeaveScheme_page EarnLeaveScheme_pageObj;
	LeaveType_page LeaveManagement_pageObj;
	CommonElement_page commonElement_pageObj;
	SoftAssert softAssertObj = new SoftAssert();

	@BeforeClass
	public void setUp() throws Exception {
		init("leaveManagement_OwnServer");
		EarnLeaveScheme_pageObj = new EarnLeaveScheme_page(driver);
		LeaveManagement_pageObj = new LeaveType_page(driver);
		commonElement_pageObj = new CommonElement_page(driver);
		loadProperties("leaveMangement.properties");
		Thread.sleep(8000);
	}

	@DataProvider(name = "validLoginData")
	public String[][] getValidLogInData() {
		String[][] validloginData = getData("leaveManagement.xlsx", "validLoginData");
		return validloginData;
	}

	@DataProvider(name = "earnleaveSchemeData")
	public String[][] getPeriodicLeaveSchemeData() {
		String[][] earnleaveSchemeData = getData("leaveManagement.xlsx", "EarnLeaveSchemeData");
		return earnleaveSchemeData;
	}

	@DataProvider(name = "earnLeaveSchemeSplitData")
	public String[][] getEarnLeaveSchemeSplitData() {
		String[][] earnleaveSchemeSplitDatas = getData("leaveManagement.xlsx", "earnLeaveSchemeSplit");
		return earnleaveSchemeSplitDatas;
	}

	@DataProvider(name = "exceedLeaveValidationData")
	public String[][] getExceedLeaveData() {
		String[][] exceedDatas = getData("leaveManagement.xlsx", "exceedleaveValidationData");
		return exceedDatas;
	}

	@DataProvider(name = "lessLeaveValidationData")
	public String[][] getlessLeaveData() {
		String[][] lessLeavePerYearDatas = getData("leaveManagement.xlsx", "lessLeaveValidationPerYear");
		return lessLeavePerYearDatas;
	}

	@DataProvider(name = "validEarnLeaveSchemeData")
	public String[][] getValidEarnLeaveData() {
		String[][] validEarnLeaveData = getData("leaveManagement.xlsx", "validEarnLeaveSchemeData");
		return validEarnLeaveData;
	}

	@DataProvider(name = "clearQuaterWiseData")
	public String[][] getClearQuaterwiseData() {
		String[][] exceedDatasClear = getData("leaveManagement.xlsx", "clearquaterwisedata");
		return exceedDatasClear;
	}

	@Test(priority = 0, dataProvider = "validLoginData")
	public void loginLeaveManagement(String username, String password, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("User marked this Record as No Run");
		}
		commonElement_pageObj.fillLoginDetails(username, password);
	}

	@Test(priority = 1, dataProvider = "earnleaveSchemeData")
	public void createEarnLeaveSchemeDefinition(String schemeName, String leaveTypeName, String timeSchemeName,
			String leavePerYear, String yearName, String monthName, String date) throws Exception {
		commonElement_pageObj.clickOnAdmin_tab();
		EarnLeaveScheme_pageObj.clickonLeaveScheme_tab();
		EarnLeaveScheme_pageObj.clickOnAddLeaveScheme_btn();
		EarnLeaveScheme_pageObj.editSchemeName(schemeName);
		EarnLeaveScheme_pageObj.selectLeaveTypeFromDrop_down(leaveTypeName);
		EarnLeaveScheme_pageObj.selectTimeSchemeFromDrop_down(timeSchemeName);
		EarnLeaveScheme_pageObj.editLeavesPerYear(leavePerYear);
		EarnLeaveScheme_pageObj.selectEncashable_checkBox();
		EarnLeaveScheme_pageObj.editLeavesPerApplication_inputBox(propetiesOverloadObj.getProperty("halfDayLeavePerApplication"));
		EarnLeaveScheme_pageObj.clickonSchemeValidityFormCalendar_icon();
		commonElement_pageObj.selectYearFromCalendar(yearName);
		commonElement_pageObj.selectMonthFromCalendar(monthName);
		commonElement_pageObj.selectMonthDateCalendarBody(date);
		EarnLeaveScheme_pageObj.clickSchemeDefinationNext_btn();
	}

	@Test(priority = 2)
	public void editEarnLeaveSchemePolicies() throws Exception {
		EarnLeaveScheme_pageObj.selectCountryfromSchemePolicy(propetiesOverloadObj.getProperty("schemePolicyCountryasIndia"));
		EarnLeaveScheme_pageObj.clickNextButtonFromSchemePolicy();
	}

	@Test(priority = 3, dataProvider = "exceedLeaveValidationData")
	public void exceedLeaveValidation(String quatarno, String noOfleaveallowedperquater,
			String caryforwardleaveforQuater, String maxcarryforwardLeave) {
		EarnLeaveScheme_pageObj.quaterlySchemeSplitForLeavesGranted(quatarno, noOfleaveallowedperquater);
		EarnLeaveScheme_pageObj.quaterlySchemeSplitForLeavesCarryForward(caryforwardleaveforQuater, maxcarryforwardLeave);
	}

	@Test(priority = 4)
	public void saveExceedLeaveScheme() throws Exception {
		EarnLeaveScheme_pageObj.clickOnSchemeSplitSave_btn();
		EarnLeaveScheme_pageObj.clickOnSaveSchemePopUp();
		softAssertObj.assertEquals(EarnLeaveScheme_pageObj.getExceedDataTextValidation(), "Leaves granted exceed leaves per year");
		Thread.sleep(3000);
		softAssertObj.assertAll();
		EarnLeaveScheme_pageObj.navigateToSchemeSplit_tab();
	}

	@Test(priority = 5, dataProvider = "clearQuaterWiseData")
	public void clearQuaterwiseFieldExceedLearnLeaveScheme(String quaterno, String caryforwardleaveforquater) throws Exception {
		EarnLeaveScheme_pageObj.clearquaterlySchemeSplitForLeavesGranted(quaterno);
		EarnLeaveScheme_pageObj.clearquaterlySchemeSplitForLeavesCarryForward(caryforwardleaveforquater);
		Thread.sleep(2000);
	}

	@Test(priority = 6, dataProvider = "lessLeaveValidationData")
	public void lessLeaveValidationLeavePerYear(String quatarno, String noOfleaveallowedperquater,
			String caryforwardleaveforQuater, String maxcarryforwardLeave) {
		EarnLeaveScheme_pageObj.quaterlySchemeSplitForLeavesGranted(quatarno, noOfleaveallowedperquater);
		EarnLeaveScheme_pageObj.quaterlySchemeSplitForLeavesCarryForward(caryforwardleaveforQuater, maxcarryforwardLeave);
	}

	@Test(priority = 7)
	public void saveLessLeavePerYearLeaveScheme() throws Exception {
		EarnLeaveScheme_pageObj.clickOnSchemeSplitSave_btn();
		EarnLeaveScheme_pageObj.clickOnSaveSchemePopUp();
		softAssertObj.assertEquals(EarnLeaveScheme_pageObj.getLessLeavePerYearDataTextValidation(),"Leaves granted don't add up to leaves per year");
		Thread.sleep(2000);
		EarnLeaveScheme_pageObj.navigateToSchemeSplit_tab();
		softAssertObj.assertAll();
	}

	@Test(priority = 8, dataProvider = "clearQuaterWiseData")
	public void clearQuaterwiseFieldLessLeavePerYearearnLeaveScheme(String quaterno, String caryforwardleaveforquater) {
		//EarnLeaveScheme_pageObj.navigateToSchemeSplit_tab();
		EarnLeaveScheme_pageObj.clearquaterlySchemeSplitForLeavesGranted(quaterno);
		EarnLeaveScheme_pageObj.clearquaterlySchemeSplitForLeavesCarryForward(caryforwardleaveforquater);
	}

	@Test(priority = 9, dataProvider = "validEarnLeaveSchemeData")
	public void editValidEarnLeaveScheme(String quatarno, String noOfleaveallowedperquater,
			String caryforwardleaveforQuater, String maxcarryforwardLeave) {
		EarnLeaveScheme_pageObj.quaterlySchemeSplitForLeavesGranted(quatarno, noOfleaveallowedperquater);
		EarnLeaveScheme_pageObj.quaterlySchemeSplitForLeavesCarryForward(caryforwardleaveforQuater, maxcarryforwardLeave);
	}

	@Test(priority = 10)
	public void saveEditedValidEarnLeaveScheme() throws Exception {
		EarnLeaveScheme_pageObj.clickOnSchemeSplitSave_btn();
		EarnLeaveScheme_pageObj.clickOnSaveSchemePopUp();
		softAssertObj.assertEquals(EarnLeaveScheme_pageObj.getSuccessLeaveCreationMsg(), "Leave Scheme added successfully");
		softAssertObj.assertAll();
		
	}

	@Test(priority = 11, dataProvider = "earnleaveSchemeData")
	public void createDuplicateEarnLeaveScheme(String schemeName, String leaveTypeName, String timeSchemeName,
			String leavePerYear, String yearName, String monthName, String date) throws Exception {
		EarnLeaveScheme_pageObj.clickOnAddLeaveScheme_btn();
		EarnLeaveScheme_pageObj.editSchemeName(schemeName);
		EarnLeaveScheme_pageObj.selectLeaveTypeFromDrop_down(leaveTypeName);
		EarnLeaveScheme_pageObj.selectTimeSchemeFromDrop_down(timeSchemeName);
		EarnLeaveScheme_pageObj.editLeavesPerYear(leavePerYear);
		EarnLeaveScheme_pageObj.selectEncashable_checkBox();
		EarnLeaveScheme_pageObj
				.editLeavesPerApplication_inputBox(propetiesOverloadObj.getProperty("halfDayLeavePerApplication"));
		EarnLeaveScheme_pageObj.clickonSchemeValidityFormCalendar_icon();
		commonElement_pageObj.selectYearFromCalendar(yearName);
		commonElement_pageObj.selectMonthFromCalendar(monthName);
		commonElement_pageObj.selectMonthDateCalendarBody(date);
		EarnLeaveScheme_pageObj.clickSchemeDefinationNext_btn();
	}

	@Test(priority = 12)
	public void editDuplicateEarnLeaveSchemePolicies() throws Exception {
		EarnLeaveScheme_pageObj.selectCountryfromSchemePolicy(propetiesOverloadObj.getProperty("schemePolicyCountryasIndia"));
		EarnLeaveScheme_pageObj.clickNextButtonFromSchemePolicy();
	}

	@Test(priority = 13, dataProvider = "validEarnLeaveSchemeData")
	public void editDuplicateEarnLeaveScheme(String quatarno, String noOfleaveallowedperquater,
			String caryforwardleaveforQuater, String maxcarryforwardLeave) {
		EarnLeaveScheme_pageObj.quaterlySchemeSplitForLeavesGranted(quatarno, noOfleaveallowedperquater);
		EarnLeaveScheme_pageObj.quaterlySchemeSplitForLeavesCarryForward(caryforwardleaveforQuater, maxcarryforwardLeave);
	}

	@Test(priority = 14)
	public void saveDuplicateEarnLeaveScheme() throws Exception {
		EarnLeaveScheme_pageObj.clickOnSchemeSplitSave_btn();
		EarnLeaveScheme_pageObj.clickOnSaveSchemePopUp();
		softAssertObj.assertEquals(EarnLeaveScheme_pageObj.getDuplicateLeaveCreationMsg(),
				"Leave scheme name already in use. Please choose a different one");
		Thread.sleep(3000);
		softAssertObj.assertAll();
	}

	@Test(priority = 15)
	public void applyValidCountryFilter() throws Exception {
		EarnLeaveScheme_pageObj.close_AddSchemePopUp();
		EarnLeaveScheme_pageObj.clickonLeaveScheme_tab();
		EarnLeaveScheme_pageObj.selectLeaveSchemeValidContryFilter(propetiesOverloadObj.getProperty("filterAsValidCountry"));
		softAssertObj.assertEquals(EarnLeaveScheme_pageObj.verifyHolidayFilter("Earn Leave Scheme"), "Earn Leave Scheme");
		Thread.sleep(3000);
		softAssertObj.assertAll();
	}

	@Test(priority = 16)
	public void applyInvalidCountryFilter() throws InterruptedException {
		EarnLeaveScheme_pageObj
				.selectLeaveSchemeInvalidCountryFilter(propetiesOverloadObj.getProperty("filterAsInvalidCountry"));
		softAssertObj.assertEquals(EarnLeaveScheme_pageObj.getBlnakMessageforContryFilter(), "No Data Available.");
		softAssertObj.assertAll();
		Thread.sleep(3000);
	}

	@Test(priority = 17)
	public void validApplyLeaveTypeFilter() {
		EarnLeaveScheme_pageObj.clickOnclearFilter_btn();
		EarnLeaveScheme_pageObj
				.selectLeaveTypeFilterfromLeaveScheme(propetiesOverloadObj.getProperty("leaveSchemeLeaveTypeFilter"));
		softAssertObj.assertEquals(EarnLeaveScheme_pageObj.verifyHolidayFilter("Earn Leave Scheme"), "Earn Leave Scheme");
		softAssertObj.assertAll();
	}

	/*@Test(priority = 18)
	public void inValidApplyLeaveTypeFilter() throws Exception {
		EarnLeaveScheme_pageObj.clickOnclearFilter_btn();
		EarnLeaveScheme_pageObj.selectLeaveTypeFilterfromLeaveScheme(
				propetiesOverloadObj.getProperty("invalidLeaveSchemeLeaveTypeFilter"));
		softAssertObj.assertEquals(EarnLeaveScheme_pageObj.getBlnakMessageforContryFilter(), "No Data Available.");
		Thread.sleep(2000);
		softAssertObj.assertAll();
	}*/
	
	@Test(priority=19)
	public void logOutFromApplication() throws Exception{
		commonElement_pageObj.click_logOutButton();
	}

}
