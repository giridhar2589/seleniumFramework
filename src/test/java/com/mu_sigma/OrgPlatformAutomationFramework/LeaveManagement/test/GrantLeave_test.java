package com.mu_sigma.OrgPlatformAutomationFramework.LeaveManagement.test;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.mu_sigma.OrgPlatformAutomationFramework.LeaveManagement.page.CommonElement_page;
import com.mu_sigma.OrgPlatformAutomationFramework.LeaveManagement.page.GrantLeave_page;
import com.mu_sigma.OrgPlatformAutomationFramework.LeaveManagement.page.LeaveScheme_page;
import com.mu_sigma.OrgPlatformAutomationFramework.LeaveManagement.page.LeaveType_page;
import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;

public class GrantLeave_test extends TestBase {

	GrantLeave_page grantLeave_pageObj;
	LeaveType_page LeaveManagement_pageObj;
	LeaveScheme_page LeaveScheme_pageObj;
	CommonElement_page commonElement_pageObj;
	SoftAssert softAssertObj = new SoftAssert();

	@BeforeClass
	public void setUp() throws Exception {
		init("leaveManagement_OwnServer");
		LeaveManagement_pageObj = new LeaveType_page(driver);
		grantLeave_pageObj = new GrantLeave_page(driver);
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

	@DataProvider(name = "grantInvalidPeriodicLeaveData")
	public String[][] getInvalidPeriodicLeaveData() {
		String[][] invalidPeriodicData = getData("leaveManagement.xlsx", "grantInvalidPeriodicLeaveData");
		return invalidPeriodicData;
	}

	@Test(priority = 1, dataProvider = "grantInvalidPeriodicLeaveData")
	public void grantLeaveWithInvalidPeriodicLeave(String partialEmpName, String actualEmpName, String typeOfLeave,
			String periodicLeaveTimePeriod, String grantNoOfLeaves) throws Exception {
		commonElement_pageObj.clickOnAdmin_tab();
		grantLeave_pageObj.clickOnGrantLeaveTab();
		grantLeave_pageObj.clickOnGrantLeaveBtn();
		grantLeave_pageObj.selectEmployeefromAddGrantPopUp(partialEmpName, actualEmpName);
		grantLeave_pageObj.selectTypeofLeave(typeOfLeave);
		grantLeave_pageObj.grantLeaveSelectPeriodicLeaveTimePeriod(periodicLeaveTimePeriod);
		grantLeave_pageObj.grantNoOfLeaves(grantNoOfLeaves);
		grantLeave_pageObj.clickAddGrant_saveBtn();
		grantLeave_pageObj.clickOnSaveSchemePopUp();
		//Thread.sleep(3000);
		softAssertObj.assertEquals(grantLeave_pageObj.pastDateleavesError_msg(), "Cannot grant leaves for past date");
		Thread.sleep(3000);
		softAssertObj.assertAll();
		grantLeave_pageObj.clickOnAddGrantClose();
	}

	@DataProvider(name = "grantValidPeriodicLeave")
	public String[][] getValidPeriodicLeaveData() {
		String[][] validPeriodicData = getData("leaveManagement.xlsx", "grantValidPeriodicLeave");
		return validPeriodicData;
	}

	@Test(priority = 2, dataProvider = "grantValidPeriodicLeave")
	public void grantLeaveWithvalidPeriodicLeave(String partialEmpName, String actualEmpName, String typeOfLeave,
			String periodicLeaveTimePeriod, String grantNoOfLeaves) throws Exception {
		grantLeave_pageObj.clickOnGrantLeaveBtn();
		grantLeave_pageObj.selectEmployeefromAddGrantPopUp(partialEmpName, actualEmpName);
		grantLeave_pageObj.selectTypeofLeave(typeOfLeave);
		grantLeave_pageObj.grantLeaveSelectPeriodicLeaveTimePeriod(periodicLeaveTimePeriod);
		grantLeave_pageObj.grantNoOfLeaves(grantNoOfLeaves);
		grantLeave_pageObj.clickAddGrant_saveBtn();
		grantLeave_pageObj.clickOnSaveSchemePopUp();
		//Thread.sleep(3000);
		softAssertObj.assertEquals(grantLeave_pageObj.successLeaves_msg(), "Success");
		Thread.sleep(3000);
		softAssertObj.assertAll();
		Thread.sleep(3000);
		//grantLeave_pageObj.clickOnAddGrantClose();
	}

	@DataProvider(name = "grantInValidMaxPeriodicLeave")
	public String[][] getInValidNonPeriodicLeaveData() {
		String[][] invalidMaxNonPeriodicLeaveData = getData("leaveManagement.xlsx", "grantInValidMaxPeriodicLeave");
		return invalidMaxNonPeriodicLeaveData;
	}

	@Test(priority = 3, dataProvider = "grantInValidMaxPeriodicLeave")
	public void grantInvalidMaximumNonPeriodicLeaveValidation(String partialEmpName, String actualEmpName,
			String leaveType, String year, String month, String date, String grantNoOfLeave) throws Exception {
		grantLeave_pageObj.clickOnGrantLeaveTab();
		grantLeave_pageObj.clickOnGrantLeaveBtn();
		grantLeave_pageObj.selectEmployeefromAddGrantPopUp(partialEmpName, actualEmpName);
		grantLeave_pageObj.selectTypeofLeave(leaveType);
		grantLeave_pageObj.clickValidFromCalendar_icon();
		commonElement_pageObj.selectYearFromCalendar(year);
		commonElement_pageObj.selectMonthFromCalendar(month);
		commonElement_pageObj.selectMonthDateCalendarBody(date);
		grantLeave_pageObj.grantNoOfLeaves(grantNoOfLeave);
		grantLeave_pageObj.clickAddGrant_saveBtn();
		grantLeave_pageObj.clickOnSaveSchemePopUp();
		softAssertObj.assertEquals(grantLeave_pageObj.nonPeriodicInvalid_msg(),
				"Reached the maximum quota for the given leave type, you cannot grant more leaves");
		Thread.sleep(3000);
		softAssertObj.assertAll();
		grantLeave_pageObj.clickOnAddGrantClose();
		//Thread.sleep(3000);
	}

	@DataProvider(name = "grantInvalidSchemeValidity")
	public String[][] getInValidNonPeriodicLeaveSchemeValidityData() {
		String[][] invalidSchemeValidityNonPeriodicLeaveData = getData("leaveManagement.xlsx",
				"grantInvalidSchemeValidity");
		return invalidSchemeValidityNonPeriodicLeaveData;
	}

	@Test(priority = 4, dataProvider = "grantInvalidSchemeValidity")
	public void grantInvalidNonPeriodicSchemeValidityValidation(String partialEmpName, String actualEmpName,
			String leaveType, String year, String month, String date, String grantNoOfLeave) throws Exception {
		grantLeave_pageObj.clickOnGrantLeaveTab();
		grantLeave_pageObj.clickOnGrantLeaveBtn();
		grantLeave_pageObj.selectEmployeefromAddGrantPopUp(partialEmpName, actualEmpName);
		grantLeave_pageObj.selectTypeofLeave(leaveType);
		grantLeave_pageObj.clickValidFromCalendar_icon();
		commonElement_pageObj.selectYearFromCalendar(year);
		commonElement_pageObj.selectMonthFromCalendar(month);
		commonElement_pageObj.selectMonthDateCalendarBody(date);
		grantLeave_pageObj.grantNoOfLeaves(grantNoOfLeave);
		grantLeave_pageObj.clickAddGrant_saveBtn();
		grantLeave_pageObj.clickOnSaveSchemePopUp();
		softAssertObj.assertEquals(grantLeave_pageObj.nonPeriodicValidityerror_msg(),
				"Cannot grant leaves outside scheme validity");
		Thread.sleep(3000);
		softAssertObj.assertAll();
		grantLeave_pageObj.clickOnAddGrantClose();
	}

	@DataProvider(name = "grantValidNonPeriodicData")
	public String[][] getValidNonPeriodicLeaveSchemeData() {
		String[][] validNonPeriodicLeaveData = getData("leaveManagement.xlsx", "grantValidNonPeriodicData");
		return validNonPeriodicLeaveData;
	}

	@Test(priority = 5, dataProvider = "grantValidNonPeriodicData")
	public void grantvalidNonPeriodicSchemeValidation(String partialEmpName, String actualEmpName, String leaveType,
			String year, String month, String date, String grantNoOfLeave) throws Exception {
		grantLeave_pageObj.clickOnGrantLeaveTab();
		grantLeave_pageObj.clickOnGrantLeaveBtn();
		grantLeave_pageObj.selectEmployeefromAddGrantPopUp(partialEmpName, actualEmpName);
		grantLeave_pageObj.selectTypeofLeave(leaveType);
		grantLeave_pageObj.clickValidFromCalendar_icon();
		commonElement_pageObj.selectYearFromCalendar(year);
		commonElement_pageObj.selectMonthFromCalendar(month);
		commonElement_pageObj.selectMonthDateCalendarBody(date);
		grantLeave_pageObj.grantNoOfLeaves(grantNoOfLeave);
		grantLeave_pageObj.clickAddGrant_saveBtn();
		grantLeave_pageObj.clickOnSaveSchemePopUp();
		softAssertObj.assertEquals(grantLeave_pageObj.successLeaves_msg(), "Success");
		Thread.sleep(3000);
		softAssertObj.assertAll();
	}
}
