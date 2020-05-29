package com.mu_sigma.OrgPlatformAutomationFramework.muExpense.test;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;
import com.mu_sigma.OrgPlatformAutomationFramework.muExpense.page.AddBill_page;
import com.mu_sigma.OrgPlatformAutomationFramework.muExpense.page.MyBills_page;
import com.mu_sigma.OrgPlatformAutomationFramework.muExpense.page.Approvals_page;

public class Approvals_test extends TestBase{
	AddBill_page AddBill_pageObj;
	MyBills_page MyBill_pageObj;
	Approvals_page Approvals_pageObj;
	SoftAssert softAssertObj = new SoftAssert();
	
	@BeforeClass
	public void setUp() throws Exception {
		init("muExpense");
		AddBill_pageObj = new AddBill_page(driver);
		MyBill_pageObj = new MyBills_page(driver);
		Approvals_pageObj = new Approvals_page(driver);
		loadProperties("muExpense.properties");
	}
	
	@DataProvider(name = "validloginTestdata")
	public String[][] getvalidLogInData() {
		String[][] loginData = getData("muExpense.xlsx", "validlogin");
		return loginData;
	}

	@Test(priority = 1, dataProvider = "validloginTestdata")
	public void loginExpenseManagement(String username, String password, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("User marked this Record as No Run");
		}
		 AddBill_pageObj.fillLoginDetails(username, password);
	}
	
	@Test(priority = 2)
	public void impersonateOnsiteEmployee(){
		 AddBill_pageObj.impersonateEmployee(propetiesOverloadObj.getProperty("Onsite_Manager"));
		softAssertObj.assertTrue(AddBill_pageObj.getDesignation_text().contains("Engagement Manager"));
	}
	
	@Test(priority = 3)
	public void approvals() throws Exception{
		Approvals_pageObj.clickApprovalsTab();
		Approvals_pageObj.clickOnSpecificClaim(propetiesOverloadObj.getProperty("Claim_Name"));
		Approvals_pageObj.approveClaim(propetiesOverloadObj.getProperty("approvedcomments"));
	}

}
