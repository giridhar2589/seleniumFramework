package com.mu_sigma.OrgPlatformAutomationFramework.MuEval.test;

import org.testng.annotations.Test;
import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.asserts.SoftAssert;

import com.mu_sigma.OrgPlatformAutomationFramework.MuEval.page.HomePageSelfAssesment_page;
import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;


public class HomePageSelfAssesment_test extends TestBase{
	
	HomePageSelfAssesment_page HomePageSelfAssesment_page_pageObj;
	
	SoftAssert SoftAssertobj = new SoftAssert();
	
	@BeforeClass
	public void setUp() throws IOException, Exception {
		init("muEval_Staging");
		HomePageSelfAssesment_page_pageObj = new HomePageSelfAssesment_page(driver);
		
	}
	@DataProvider(name = "validloginTestdata")
	public String[][] getvalidLogInData() {
		String[][] loginData = getData("muEval.xlsx", "validlogin");
		return loginData;
	}

	@Test(priority = 1, dataProvider = "validloginTestdata")
	public void login_muEval(String username, String password, String runMode) {
//		if (runMode.equalsIgnoreCase("n")) {
//			throw new SkipException("User marked this Record as No Run");
//		}
		HomePageSelfAssesment_page_pageObj.fillLoginDetails(username, password);
	}
	@DataProvider(name = "SwitchUser")
	public String[][] getUserIdData() {
		String[][] SwitchUser = getData("muEval.xlsx", "UserId1");
		return SwitchUser;	
		}
	@Test(priority = 2, dataProvider = "SwitchUser")
	public void ImpersonateAsManager(String UserName, String runmode)throws InterruptedException
	{
		HomePageSelfAssesment_page_pageObj.SwitchUser(UserName);
		SoftAssertobj.assertAll();
		
	}
	@Test(priority = 3)
	public void SubmitSelfassesment() throws InterruptedException
	{
		HomePageSelfAssesment_page_pageObj.Enter_muEval();
		HomePageSelfAssesment_page_pageObj.SubmitSelfAssesmentform();
		HomePageSelfAssesment_page_pageObj.logout();
		
	}
}
