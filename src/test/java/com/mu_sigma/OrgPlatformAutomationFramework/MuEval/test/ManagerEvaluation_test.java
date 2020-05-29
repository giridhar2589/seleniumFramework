package com.mu_sigma.OrgPlatformAutomationFramework.MuEval.test;

import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.mu_sigma.OrgPlatformAutomationFramework.MuEval.page.FULTEvaluation_page;
import com.mu_sigma.OrgPlatformAutomationFramework.MuEval.page.HomePageSelfAssesment_page;
import com.mu_sigma.OrgPlatformAutomationFramework.MuEval.page.ManagerEvaluation_page;
import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;

public class ManagerEvaluation_test extends TestBase {
	HomePageSelfAssesment_page HomePageSelfAssesment_page_pageObj;
	FULTEvaluation_page FULTEvaluation_page_pageObj;
	ManagerEvaluation_page ManagerEvaluation_page_pageObj;
	

	SoftAssert SoftAssertobj = new SoftAssert();
	
	@BeforeClass
	public void setUp() throws IOException, Exception {
		init("muEval_Staging");
		HomePageSelfAssesment_page_pageObj = new HomePageSelfAssesment_page(driver);
		FULTEvaluation_page_pageObj = new FULTEvaluation_page(driver);
		ManagerEvaluation_page_pageObj = new ManagerEvaluation_page(driver);
		
	}
	@DataProvider(name = "validloginTestdata")
	public String[][] getvalidLogInData() {
		String[][] loginData = getData("muEval.xlsx", "validlogin");
		return loginData;
	}

	@Test(priority = 1, dataProvider = "validloginTestdata")
	public void login_muEval(String username, String password, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("User marked this Record as No Run");
		}
		HomePageSelfAssesment_page_pageObj.fillLoginDetails(username, password);
	}
	@DataProvider(name = "SwitchUser")
	public String[][] getUserIdData() {
		String[][] SwitchUser = getData("muEval.xlsx", "UserId3");
		return SwitchUser;	
		}
	@Test(priority = 2, dataProvider = "SwitchUser")
	public void ImpersonateAsManager(String UserName, String runmode)throws InterruptedException
	{
		HomePageSelfAssesment_page_pageObj.SwitchUser(UserName);
		SoftAssertobj.assertAll();
	}
	@Test(priority = 3)
	public void ManagerEvaluation() throws InterruptedException
	{
		HomePageSelfAssesment_page_pageObj.Enter_muEval();
		ManagerEvaluation_page_pageObj.VerifyTeamPage();
		SoftAssertobj.assertAll();
	}
	@DataProvider(name = "ManagerEvaluationdata")
	public String[][] getEmployeeDetails1() {
		String[][] Empldetails1 = getData("muEval.xlsx", "ManagerEvaluation" );
		return Empldetails1;	
		}
	@Test(priority = 4, dataProvider = "ManagerEvaluationdata")
	public void OpenManagerEvaluation(String EmployeeName1,String Comment1, String runmode) throws InterruptedException
	{
		ManagerEvaluation_page_pageObj.ManagerEvaluation(EmployeeName1, Comment1);
		SoftAssertobj.assertTrue(ManagerEvaluation_page_pageObj.ManagerEvalConfirm(),"Employee Record not found in History Tab");

		HomePageSelfAssesment_page_pageObj.logout();
		SoftAssertobj.assertAll();
	}
	
}


