package com.mu_sigma.OrgPlatformAutomationFramework.MuEval.test;

import org.testng.annotations.Test;
import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.asserts.SoftAssert;

import com.mu_sigma.OrgPlatformAutomationFramework.MuEval.page.FULTEvaluation_page;
import com.mu_sigma.OrgPlatformAutomationFramework.MuEval.page.HomePageSelfAssesment_page;
import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;

public class FULTEvaluation_test extends TestBase{
	
	HomePageSelfAssesment_page HomePageSelfAssesment_page_pageObj;
	FULTEvaluation_page FULTEvaluation_page_pageObj;
	

	SoftAssert SoftAssertobj = new SoftAssert();
	
	@BeforeClass
	public void setUp() throws IOException, Exception {
		init("muEval_Staging");
		HomePageSelfAssesment_page_pageObj = new HomePageSelfAssesment_page(driver);
		FULTEvaluation_page_pageObj = new FULTEvaluation_page(driver);
		
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
		String[][] SwitchUser = getData("muEval.xlsx", "UserId2");
		return SwitchUser;	
		}
	@Test(priority = 2, dataProvider = "SwitchUser")
	public void ImpersonateAsManager(String UserName, String runmode)throws InterruptedException
	{
		HomePageSelfAssesment_page_pageObj.SwitchUser(UserName);
		SoftAssertobj.assertAll();
	}
	@Test(priority = 3)
	public void FULTEvaluation() throws InterruptedException
	{
		HomePageSelfAssesment_page_pageObj.Enter_muEval();
		FULTEvaluation_page_pageObj.VerifyTeamPage();
		SoftAssertobj.assertAll();
	}
	@DataProvider(name = "FultEvaluationdata")
	public String[][] getFultEvaluation() {
		String[][] Empldetails = getData("muEval.xlsx", "FultEvaluation" );
		return Empldetails;	
		}
	@Test(priority = 4, dataProvider = "FultEvaluationdata")
	public void OpenFultEvaluation(String EmployeeName,String Comment, String runmode) throws InterruptedException
	{
		FULTEvaluation_page_pageObj.FultEvaluation(EmployeeName, Comment);
		SoftAssertobj.assertTrue(FULTEvaluation_page_pageObj.FultEvalConfirm(),"Employee Record not found in History Tab");
		HomePageSelfAssesment_page_pageObj.logout();
		SoftAssertobj.assertAll();
	}
	
	
}
