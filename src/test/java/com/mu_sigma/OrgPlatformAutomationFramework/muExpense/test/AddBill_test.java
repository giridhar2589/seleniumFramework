package com.mu_sigma.OrgPlatformAutomationFramework.muExpense.test;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;
import com.mu_sigma.OrgPlatformAutomationFramework.muExpense.page.AddBill_page;

public class AddBill_test extends TestBase {
	AddBill_page AddBill_pageObj;
	SoftAssert softAssertObj = new SoftAssert();
	
	@BeforeClass
	public void setUp() throws Exception {
		init("muExpense");
		AddBill_pageObj = new AddBill_page(driver);
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
		softAssertObj.assertTrue(AddBill_pageObj.getDesignation_text().contains("Associate"));
	}
	
	@Test(priority = 3)
	public void addBill(){
		AddBill_pageObj.addBill();
	}
	
	/*@DataProvider(name = "billdetails")
	public String[][] getBillDetails() {
		String[][] loginData = getData("muExpense.xlsx", "billdetails");
		return loginData;
	}
	
	@Test(priority = 4, dataProvider = "billdetails")
	public void saveDraftBill(String billname,String billnumber,String category,String billamount,String folderName,String fileName) throws Exception{
		AddBill_pageObj.enterBillDetails(billname,billnumber,category,billamount,folderName,fileName);
		AddBill_pageObj.clickSaveButton();
		softAssertObj.assertEquals(AddBill_pageObj.successMessage_anyAction_text(),
				"Bill submitted successfully");
	}*/
	
	/*@DataProvider(name = "telephonebilldetails")
	public String[][] getTelephoneBillDetails() {
		String[][] telephoneBillDetails = getData("muExpense.xlsx", "telephonebilldetails");
		return telephoneBillDetails;
	}
	@Test(priority =5,dataProvider = "telephonebilldetails")
	public void saveTelephoneDraftBill(String billname,String billnumber,String category,String subcategory,
			String DateFrom,String DateTo,String billamount,String folderName,String fileName) throws Exception{
		AddBill_pageObj.enterBillDetails(billname,billnumber,category,billamount,folderName,fileName);
		AddBill_pageObj.enterTelephoneBillDetails(subcategory, DateFrom, DateTo);
		Thread.sleep(3000);
		AddBill_pageObj.clickSaveButton();
		softAssertObj.assertEquals(AddBill_pageObj.successMessage_anyAction_text(),
				"Bill submitted successfully");
	}*/
	
	/*@DataProvider(name = "teamoutingbilldetails")
	public String[][] getTeamOutingBillDetails() {
		String[][] TeamOutingBillDetails = getData("muExpense.xlsx", "teamoutingbilldetails");
		return TeamOutingBillDetails;
	}
	
	@Test(priority=6,dataProvider = "teamoutingbilldetails")
	public void saveQuarterlyTeamOutingBill(String billname,String billnumber,String category,
			String billamount,String folderName,String fileName,String buttonNo,String addmember) throws Exception{
		AddBill_pageObj.enterBillDetails(billname, billnumber, category, billamount, folderName, fileName);
		AddBill_pageObj.selectRadioButton(Integer.parseInt(buttonNo));
		AddBill_pageObj.enterQuarterlyTeamOutingBillDetails(addmember);
		Thread.sleep(3000);
		AddBill_pageObj.clickSaveButton();
		softAssertObj.assertEquals(AddBill_pageObj.successMessage_anyAction_text(),
				"Bill submitted successfully");
	}*/
	
	@DataProvider(name = "relocationbilldetails")
	public String[][] getRelocationBillDetails() {
		String[][] RelocationBillDetails = getData("muExpense.xlsx", "relocationbilldetails");
		return RelocationBillDetails;
	}
	
	@Test(priority=7,dataProvider="relocationbilldetails")
	public void saveRelocationBill(String billname,String billnumber,String category,String subcategory,String country,String city,
			String DateFrom,String DateTo,String billamount,String folderName,String fileName,String checkboxNo) throws Exception{
		AddBill_pageObj.enterBillDetails(billname, billnumber, category, billamount, folderName, fileName);
		AddBill_pageObj.enterRelocationBillDetails(subcategory, country, city,DateFrom,DateTo);
		AddBill_pageObj.selectCheckBox(Integer.parseInt(checkboxNo));
		Thread.sleep(3000);
		AddBill_pageObj.clickSaveButton();
		softAssertObj.assertEquals(AddBill_pageObj.successMessage_anyAction_text(),
				"Bill submitted successfully");
	}
	

}
