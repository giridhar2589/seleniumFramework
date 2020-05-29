package com.mu_sigma.OrgPlatformAutomationFramework.muExpense.test;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;
import com.mu_sigma.OrgPlatformAutomationFramework.muExpense.page.AddBill_page;
import com.mu_sigma.OrgPlatformAutomationFramework.muExpense.page.MyBills_page;

public class MyBills_test extends TestBase {
	AddBill_page AddBill_pageObj;
	MyBills_page MyBills_pageObj;
	SoftAssert softAssertObj = new SoftAssert();
	
	@BeforeClass
	public void setUp() throws Exception {
		init("muExpense");
		AddBill_pageObj = new AddBill_page(driver);
		MyBills_pageObj = new MyBills_page(driver);
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
		 AddBill_pageObj.impersonateEmployee(propetiesOverloadObj.getProperty("Onsite_Employee"));
		softAssertObj.assertTrue(AddBill_pageObj.getDesignation_text().contains("Geography Head"));
	}
	
	/*@Test(priority = 3)
	public void editBill() throws Exception{
		MyBills_pageObj.clickOnSpecificBill(propetiesOverloadObj.getProperty("Bill_Name"));
		MyBills_pageObj.editBill();
		Thread.sleep(3000);
		MyBills_pageObj.selectRadioButton(1);
		Thread.sleep(3000);
	}*/
	
	@Test(priority = 4)
	public void selectBill() throws Exception{
		MyBills_pageObj.selectSpecificBill();
		//AddBill_pageObj.selectAllBills();
	}
	
	@Test(priority = 5)
	public void makeAClaim() throws Exception{
		MyBills_pageObj.clickOnMakeAClaimButton();
		MyBills_pageObj.makeAClaim(propetiesOverloadObj.getProperty("Claim_Name"));
		
	}

}
