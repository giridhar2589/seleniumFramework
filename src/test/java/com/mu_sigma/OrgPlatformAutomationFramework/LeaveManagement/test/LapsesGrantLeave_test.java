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

public class LapsesGrantLeave_test extends TestBase {

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
	public void lapseGrantPeriodicLeaveMoreThanBalance() throws InterruptedException {
		commonElement_pageObj.clickOnAdmin_tab();
		grantLeave_pageObj.clickOnGrantLeaveTab();
		grantLeave_pageObj.clickonLapseButton_icon(2);
		grantLeave_pageObj.editNoOfToLapseLeaveField("3");
		grantLeave_pageObj.editCommentToLapseLeaveField("testing lapse Grant Periodic Leave More Than Balance");
		grantLeave_pageObj.clickOnLapse_btn();
		grantLeave_pageObj.clickOnSaveSchemePopUp();
		softAssertObj.assertEquals(grantLeave_pageObj.getLeaveLapsesError_msg(),
				"Number of grants to be lapsed cannot be more than Balance. Please cancel/reject leave applications of user to lapse the grants");
		Thread.sleep(3000);
		softAssertObj.assertAll();
		grantLeave_pageObj.clickOnLeaveLapseCancel_btn();
	}

	@Test(priority = 2)
	public void lapseGrantNonPeriodicLeaveMoreThanBalance() throws Exception {
		commonElement_pageObj.clickOnAdmin_tab();
		grantLeave_pageObj.clickOnGrantLeaveTab();
		grantLeave_pageObj.clickonLapseButton_icon(1);
		grantLeave_pageObj.editNoOfToLapseLeaveField("3");
		grantLeave_pageObj.editCommentToLapseLeaveField("testing lapse Grant Non Periodic Leave More Than Balance");
		grantLeave_pageObj.clickOnLapse_btn();
		grantLeave_pageObj.clickOnSaveSchemePopUp();
		softAssertObj.assertEquals(grantLeave_pageObj.getLeaveLapsesError_msg(),
				"Number of grants to be lapsed cannot be more than Balance. Please cancel/reject leave applications of user to lapse the grants");
		Thread.sleep(3000);
		softAssertObj.assertAll();
		grantLeave_pageObj.clickOnLeaveLapseCancel_btn();
	}
	
	@Test(priority=3)
	public void lapseGrantPeriodicLeave() throws Exception{
		commonElement_pageObj.clickOnAdmin_tab();
		grantLeave_pageObj.clickOnGrantLeaveTab();
		grantLeave_pageObj.clickonLapseButton_icon(2);
		grantLeave_pageObj.editNoOfToLapseLeaveField("1");
		grantLeave_pageObj.editCommentToLapseLeaveField("testing lapse Grant Periodic Leave More Than Balance");
		grantLeave_pageObj.clickOnLapse_btn();
		grantLeave_pageObj.clickOnSaveSchemePopUp();
		Thread.sleep(3000);
		softAssertObj.assertEquals(grantLeave_pageObj.getLeaveLapsesSuccess_msg(), "Lapsed the grants successfully");
		Thread.sleep(3000);
		softAssertObj.assertAll();
	}
	
	@Test(priority=4)
	public void lapseGrantNonPeriodicLeave() throws Exception{
		commonElement_pageObj.clickOnAdmin_tab();
		grantLeave_pageObj.clickOnGrantLeaveTab();
		grantLeave_pageObj.clickonLapseButton_icon(1);
		grantLeave_pageObj.editNoOfToLapseLeaveField("1");
		grantLeave_pageObj.editCommentToLapseLeaveField("testing lapse Grant Non Periodic Leave More Than Balance");
		grantLeave_pageObj.clickOnLapse_btn();
		grantLeave_pageObj.clickOnSaveSchemePopUp();
		Thread.sleep(2000);
		softAssertObj.assertEquals(grantLeave_pageObj.getLeaveLapsesSuccess_msg(), "Lapsed the grants successfully");
		Thread.sleep(3000);
		softAssertObj.assertAll();
	}
	
	@Test(priority=5)
	public void logOutFromApplication() throws Exception{
		commonElement_pageObj.click_logOutButton();
	}
	
}
