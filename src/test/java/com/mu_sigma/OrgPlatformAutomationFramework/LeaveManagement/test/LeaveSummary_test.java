package com.mu_sigma.OrgPlatformAutomationFramework.LeaveManagement.test;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mu_sigma.OrgPlatformAutomationFramework.LeaveManagement.page.CommonElement_page;
import com.mu_sigma.OrgPlatformAutomationFramework.LeaveManagement.page.LeaveSummary_page;
import com.mu_sigma.OrgPlatformAutomationFramework.LeaveManagement.page.LeaveType_page;
import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;
/**
 * Created On:16-March-2018
 * @author biswajit.kundu
 * Last Modified On:NA
 */
public class LeaveSummary_test extends TestBase {

	LeaveSummary_page LeaveSummary_pageObj;
	LeaveType_page LeaveManagement_pageObj;
	CommonElement_page commonElement_pageObj;

	@BeforeClass
	public void setUp() throws Exception {
		init("leaveManagement_OwnServer");
		LeaveManagement_pageObj = new LeaveType_page(driver);
		LeaveSummary_pageObj = new LeaveSummary_page(driver);
		commonElement_pageObj= new CommonElement_page(driver);
		loadProperties("leaveMangement.properties");
		Thread.sleep(8000);
	}

	@DataProvider(name = "validLoginData")
	public String[][] getValidLogInData() {
		String[][] validloginData = getData("leaveManagement.xlsx", "validLoginData");
		return validloginData;
	}
	
	@DataProvider(name = "validActiveEmployeeTestdata")
	public String[][] getvalidActiveEmpData() {
		String[][] validactiveemployeeData = getData("leaveManagement.xlsx", "selectValidActiveEmployeeData");
		return validactiveemployeeData;
	}
	
	@DataProvider(name = "invalidActiveEmployeeTestdata")
	public String[][] getInvalidActiveEmpData() {
		String[][] inValidactiveemployeeData = getData("leaveManagement.xlsx", "selectInvalidActiveEmployeeData");
		return inValidactiveemployeeData;
	}
	
	@DataProvider(name = "validInActiveEmployeeTestdata")
	public String[][] getvalidInActiveEmpData() {
		String[][] validInactiveemployeeData = getData("leaveManagement.xlsx", "selectvalidInActiveEmployeeData");
		return validInactiveemployeeData;
	}
	
	@DataProvider(name = "invalidInActiveEmployeeTestdata")
	public String[][] getInvalidInActiveEmpData() {
		String[][] invalidInactiveemployeeData = getData("leaveManagement.xlsx", "selectinValidInActiveEmpData");
		return invalidInactiveemployeeData;
	}

	@Test(priority = 0, dataProvider = "validLoginData")
	public void loginLeaveManagement(String username, String password, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("User marked this Record as No Run");
		}
		commonElement_pageObj.fillLoginDetails(username, password);
	}

	@Test(priority = 1,dataProvider="validActiveEmployeeTestdata")
	public void selectValidActiveEmployee(String actualText,String expectedText) throws Exception {
		commonElement_pageObj.clickOnAdmin_tab();
		LeaveSummary_pageObj.clickLeaveSummary_tab();
		Assert.assertEquals(LeaveSummary_pageObj.leaveSummary_text(), "Leave Summary");
		LeaveSummary_pageObj.selectEmployee(actualText,expectedText);
		LeaveSummary_pageObj.displayedLeaveTypeHeader();
	}
	
	@Test(priority = 2,dataProvider="invalidActiveEmployeeTestdata")
	public void selectInvalidActiveEmployee(String actualText,String expectedText) throws Exception {
		LeaveSummary_pageObj.clearEmployeeField();
		LeaveSummary_pageObj.selectEmployee(actualText, expectedText);
		Assert.assertEquals(LeaveSummary_pageObj.invalid_text(), "Please select an employee");
		Thread.sleep(3000);
	}
	
	@Test(priority = 3,dataProvider="validInActiveEmployeeTestdata")
	public void selectvalidInActiveEmployee(String actualText,String expectedText) throws Exception {
		LeaveSummary_pageObj.clearFiled_emp();
		LeaveSummary_pageObj.selectTypeOfEmployeeDropDown(propetiesOverloadObj.getProperty("leaveSummaryEmployeeType2"));
		LeaveSummary_pageObj.selectEmployee(actualText, expectedText);
		LeaveSummary_pageObj.displayedLeaveTypeHeader();
	}
	
	@Test(priority = 4,dataProvider="invalidInActiveEmployeeTestdata")
	public void selectInvalidInActiveEmployee(String actualText,String expectedText) throws Exception {
		LeaveSummary_pageObj.clearEmployeeField();
		LeaveSummary_pageObj.selectEmployee(actualText,expectedText);
		Assert.assertEquals(LeaveSummary_pageObj.invalid_text(), "Please select an employee");
	}
}
