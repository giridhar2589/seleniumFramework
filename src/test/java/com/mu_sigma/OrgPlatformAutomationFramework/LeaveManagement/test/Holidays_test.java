package com.mu_sigma.OrgPlatformAutomationFramework.LeaveManagement.test;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.mu_sigma.OrgPlatformAutomationFramework.LeaveManagement.page.CommonElement_page;
import com.mu_sigma.OrgPlatformAutomationFramework.LeaveManagement.page.Holidays_page;
import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;

public class Holidays_test extends TestBase {

	CommonElement_page commonElement_pageObj;
	Holidays_page holidays_pageObj;
	SoftAssert softAssertObj= new SoftAssert();
	
	@BeforeClass
	public void setUp() throws Exception {
		init("leaveManagement_OwnServer");
		commonElement_pageObj=new CommonElement_page(driver);
		holidays_pageObj= new com.mu_sigma.OrgPlatformAutomationFramework.LeaveManagement.page.Holidays_page(driver);
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
	
	@DataProvider(name = "holidayListData")
	public String[][] getholidayListData() {
		String[][] holidayListData = getData("leaveManagement.xlsx", "holidayListData");
		return holidayListData;
	}
	
	@DataProvider(name = "duplicateHolidayListData")
	public String[][] getDuplicateHolidayListData() {
		String[][] duplicateHolidayListData = getData("leaveManagement.xlsx", "holidayListData");
		return duplicateHolidayListData;
	}
	
	@Test(priority = 0, dataProvider = "invalidLoginData")
	public void loginValidationWithInavlidUser(String username, String password, String runMode) throws Exception, Throwable {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("User marked this Record as No Run");
		}
		commonElement_pageObj.fillLoginDetails(username, password);
		Assert.assertEquals(commonElement_pageObj.getInvalidUserNamePasswordText(),
				"Sorry, we were not able to find a user with that username and password.");
	}
	
	@Test(priority = 1, dataProvider = "validLoginData")
	public void loginLeaveManagement(String username, String password, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("User marked this Record as No Run");
		}
		commonElement_pageObj.fillLoginDetails(username, password);
	}
	
	@Test(priority=2,dataProvider="holidayListData")
	public void createValidHolidayList(String holidayname, String yearName,String monthName, String monthDate, String countrycode,String runmode) throws InterruptedException{
		if(runmode.equalsIgnoreCase("n")){
			throw new SkipException("User marked this Record as No Run");
		}
		commonElement_pageObj.clickOnAdmin_tab();
		holidays_pageObj.clickedOnHolidayTab();
		holidays_pageObj.createHolidays(holidayname,yearName,monthName,monthDate,countrycode);
		softAssertObj.assertEquals(holidays_pageObj.getHolidaySuccess_msg(), "Holiday added successfully");
		softAssertObj.assertAll();
	}
	
	@Test(priority=3,dataProvider="duplicateHolidayListData")
	public void createDuplicateHolidayList(String holidayname,String yearName,String monthName,String monthDate,String countrycode,String runmode) throws InterruptedException{
		if(runmode.equalsIgnoreCase("n")){
			throw new SkipException("User marked this Record as No Run");
		}
		commonElement_pageObj.clickOnAdmin_tab();
		holidays_pageObj.clickedOnHolidayTab();
		holidays_pageObj.createHolidays(holidayname,yearName,monthName,monthDate,countrycode);
		softAssertObj.assertEquals(holidays_pageObj.getduplicateHolidayErr_msg(), "Duplicate Entry");
		holidays_pageObj.clickOnAddHolidayCancel_btn();
		softAssertObj.assertAll();
	}
	
	@Test(priority=4)
	public void deleteExistingHoliday() throws Exception{
		holidays_pageObj.clickedOnHolidayTab();
		holidays_pageObj.deleteExistingLeave(Integer.parseInt(propetiesOverloadObj.getProperty("existingHolidayLeaveNo")));
		holidays_pageObj.clickDeleteHolidayYesConfimation_popUp();
		softAssertObj.assertEquals(holidays_pageObj.gethloidayDeleteSuccess_msg(), "Holiday Deleted");
		softAssertObj.assertAll();
		Thread.sleep(4000);
	}
	
	@Test(priority=5,dataProvider="holidayListData")
	public void againCreateValidHolidayList(String holidayname, String yearName,String monthName, String monthDate, String countrycode,String runmode) throws InterruptedException{
		if(runmode.equalsIgnoreCase("n")){
			throw new SkipException("User marked this Record as No Run");
		}
		commonElement_pageObj.clickOnAdmin_tab();
		holidays_pageObj.clickedOnHolidayTab();
		holidays_pageObj.createHolidays(holidayname,yearName,monthName,monthDate,countrycode);
		softAssertObj.assertEquals(holidays_pageObj.getHolidaySuccess_msg(), "Holiday added successfully");
		Thread.sleep(3000);
		softAssertObj.assertAll();
	}
	@Test(priority=6)
	public void logOutFromApplication() throws Exception{
		commonElement_pageObj.click_logOutButton();
	}
}
