package com.mu_sigma.OrgPlatformAutomationFramework.LeaveManagement.test;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.mu_sigma.OrgPlatformAutomationFramework.LeaveManagement.page.CommonElement_page;
import com.mu_sigma.OrgPlatformAutomationFramework.LeaveManagement.page.LeaveType_page;
import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;

public class LeaveType_test extends TestBase {

	LeaveType_page leaveType_pageObj;
	CommonElement_page commonElement_pageObj;
	SoftAssert softAssertObj= new SoftAssert();

	@BeforeClass
	public void setUp() throws Exception {
		init("leaveManagement_OwnServer");
		leaveType_pageObj = new LeaveType_page(driver);
		commonElement_pageObj=new CommonElement_page(driver);
		loadProperties("leaveMangement.properties");
		Thread.sleep(8000);
	}
	

	@DataProvider(name = "invalidLoginData")
	public String[][] getInvalidLogInData() {
		String[][] invalidloginData = getData("leaveManagement.xlsx", "invalidLoginData");
		return invalidloginData;
	}
	
	@DataProvider(name = "validLoginData")
	public String[][] getValidLogInData() {
		String[][] validloginData = getData("leaveManagement.xlsx", "validLoginData");
		return validloginData;
	}

	
	@Test(priority = 0, dataProvider = "invalidLoginData")
	public void loginValidationWithInavlidUser(String username, String password, String runMode) throws Exception, Throwable {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("User marked this Record as No Run");
		}
		commonElement_pageObj.fillLoginDetails(username, password);
		softAssertObj.assertEquals(commonElement_pageObj.getInvalidUserNamePasswordText(),
				"Sorry, we were not able to find a user with that username and password.");
		softAssertObj.assertAll();
	}
	
	@Test(priority = 1, dataProvider = "validLoginData")
	public void loginLeaveManagement(String username, String password, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("User marked this Record as No Run");
		}
		commonElement_pageObj.fillLoginDetails(username, password);
	}
	
	@Test(priority=2)
	public void createEarnLeave() throws Exception{
		commonElement_pageObj.clickOnAdmin_tab();
		leaveType_pageObj.clickOnLeaveTypeTab();
		leaveType_pageObj.createEarnLeaveType(propetiesOverloadObj.getProperty("earnLeaveType"));
		softAssertObj.assertEquals(leaveType_pageObj.getLeaveTypeAddedSuccess_msg(), "Leave Type added successfully");
		Thread.sleep(2000);
		softAssertObj.assertAll();
	}
	
	@Test(priority=3)
	public void createCompOff() throws Exception{
		leaveType_pageObj.createCompOffLeaveType(propetiesOverloadObj.getProperty("compOffLeaveType"));
		softAssertObj.assertEquals(leaveType_pageObj.getLeaveTypeAddedSuccess_msg(), "Leave Type added successfully");
		Thread.sleep(2000);
		softAssertObj.assertAll();
	}
	
	@Test(priority=4)
	public void createOnDuty() throws Exception{
		leaveType_pageObj.createOnDutyLeaveScheme(propetiesOverloadObj.getProperty("onDutyLeaveType"));
		softAssertObj.assertEquals(leaveType_pageObj.getLeaveTypeAddedSuccess_msg(), "Leave Type added successfully");
		Thread.sleep(2000);
		softAssertObj.assertAll();
	}
	
	@Test(priority=5)
	public void createLop() throws Exception{
		leaveType_pageObj.createLOPLeaveScheme(propetiesOverloadObj.getProperty("lopLeaveType"));
		softAssertObj.assertEquals(leaveType_pageObj.getLeaveTypeAddedSuccess_msg(), "Leave Type added successfully");
		Thread.sleep(2000);
		softAssertObj.assertAll();
	}
	
	@Test(priority=6)
	public void createLeaveExemption() throws InterruptedException{
		leaveType_pageObj.createLeaveExemption(propetiesOverloadObj.getProperty("leaveExemptionLeaveType"));
		softAssertObj.assertEquals(leaveType_pageObj.getLeaveTypeAddedSuccess_msg(), "Leave Type added successfully");
		softAssertObj.assertAll();
		Thread.sleep(4000);
	}
	
	@Test(priority=7)
	public void duplicateLeaveValidation() throws Exception{
		leaveType_pageObj.createEarnLeaveType(propetiesOverloadObj.getProperty("earnLeaveType"));
		softAssertObj.assertEquals(leaveType_pageObj.getDuplicateLeaveTypeError_msg(), "Duplicate Leave type can't be added");
		Thread.sleep(2000);
		softAssertObj.assertAll();
		leaveType_pageObj.clickOnLeaveTypeCancel_btn();
	}

	
	@Test(priority=10)
	public void logOutFromApplication() throws Exception{
		commonElement_pageObj.click_logOutButton();
	}
}
