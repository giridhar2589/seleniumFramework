package com.mu_sigma.OrgPlatformAutomationFramework.muExpense.test;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;
import com.mu_sigma.OrgPlatformAutomationFramework.muExpense.page.ExpenseManagement_page;

public class TelephoneClaimType_Dollar50_test extends TestBase  {
	
	ExpenseManagement_page Expense_pageObj;
	SoftAssert softAssertObj = new SoftAssert();
	
	@BeforeClass
	public void setUp() throws Exception {
		init("muExpense");
		Expense_pageObj = new ExpenseManagement_page(driver);
		loadProperties("muExpenseTelephoneDollar50.properties");
	}
	
	@DataProvider(name = "validlogin")
	public String[][] getvalidLogInData() {
		String[][] loginData = getData("muExpenseTelephoneDollar50Validations.xlsx", "validlogin");
		return loginData;
	}

	@Test(priority = 1, dataProvider = "validlogin")
	public void loginExpenseManagement(String username, String password, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("User marked this Record as No Run");
		}
		Expense_pageObj.fillLoginDetails(username, password);
	}   
	
	@Test(priority = 2)
	public void impersonateOnsiteEmployee_Associate(){
		Expense_pageObj.impersonateEmployee(propetiesOverloadObj.getProperty("Onsite_Employee_Associate"));
		softAssertObj.assertTrue(Expense_pageObj.getDesignation_text().contains("Associate"));
	}
	
	@DataProvider(name = "telephonebill1")
	public String[][] getTelephoneBillDetails1() {
		String[][] telephoneBillDetails1 = getData("muExpenseTelephoneDollar50Validations.xlsx", "telephonebill1");
		return telephoneBillDetails1;
	}
	
	@Test(priority = 3,dataProvider = "telephonebill1")
	public void saveTelephoneBill1(String billname,String billnumber,String category,String subcategory,
			String DateFrom,String DateTo,String billamount,String folderName,String fileName,
			String MonthYearDateFrom,String MonthYearDateTo) throws Exception{
		Expense_pageObj.clickOnaddBill();
		Expense_pageObj.enterTelephoneBillDetails(billname,billnumber,category,subcategory,DateFrom,DateTo,billamount,folderName,fileName,
				MonthYearDateFrom,MonthYearDateTo);
		Thread.sleep(3000);
		Expense_pageObj.clickSaveButton();
		softAssertObj.assertEquals(Expense_pageObj.successMessage_anyBillAction_text(),
				"Bill submitted successfully");
	}
	
	@Test(priority = 4)
	public void makeAClaim1() throws Exception{
		Expense_pageObj.selectBill(propetiesOverloadObj.getProperty("billnumber1"));
		Expense_pageObj.clickOnMakeAClaimButton();
		Expense_pageObj.makeAClaim(propetiesOverloadObj.getProperty("claimnamebill1"));
		softAssertObj.assertEquals(Expense_pageObj.successMessage_anyClaimAction_text(), "Claim is successfully submitted ");
	}
	
	@DataProvider(name = "telephonebill2")
	public String[][] getTelephoneBillDetails2() {
		String[][] telephoneBillDetails2 = getData("muExpenseTelephoneDollar50Validations.xlsx", "telephonebill2");
		return telephoneBillDetails2;
	}

	@Test(priority = 5,dataProvider = "telephonebill2")
	public void saveTelephoneBill2(String billname,String billnumber,String category,String subcategory,
			String DateFrom,String DateTo,String billamount,String folderName,String fileName,String eligibleAmount,
			String MonthYearDateFrom,String MonthYearDateTo) throws Exception{
		Expense_pageObj.clickOnaddBill();
		Expense_pageObj.enterTelephoneBillDetails(billname,billnumber,category,subcategory,DateFrom,DateTo,billamount,folderName,
				fileName,MonthYearDateFrom,MonthYearDateTo);
		Thread.sleep(3000);
		Expense_pageObj.clickSaveButtonWithValidation(eligibleAmount);
		softAssertObj.assertEquals(Expense_pageObj.successMessage_anyBillAction_text(),
				"Bill submitted successfully");
	}

	
	@DataProvider(name = "claim2details")
	public String[][] getclaim2details() {
		String[][] claim2details = getData("muExpenseTelephoneDollar50Validations.xlsx", "claim2details");
		return claim2details;
	}
	
	@Test(priority=6,dataProvider = "claim2details")
	public void makeAClaim2(String claimname,String empClaimDetails) throws Exception{
		Expense_pageObj.selectBill(propetiesOverloadObj.getProperty("billnumber2"));
		Expense_pageObj.clickOnMakeAClaimButton();
		Expense_pageObj.makeAClaimWithValidation(claimname,empClaimDetails);
		softAssertObj.assertEquals(Expense_pageObj.successMessage_anyClaimAction_text(), "Claim is successfully submitted ");
	}
	
	@DataProvider(name = "telephonebill3")
	public String[][] getTelephoneBillDetails3() {
		String[][] telephoneBillDetails3 = getData("muExpenseTelephoneDollar50Validations.xlsx", "telephonebill3");
		return telephoneBillDetails3;
	}
	
	@Test(priority = 7,dataProvider = "telephonebill3")
	public void saveTelephoneBill3(String billname,String billnumber,String category,String subcategory,
			String DateFrom,String DateTo,String billamount,String folderName,String fileName,
			String MonthYearDateFrom,String MonthYearDateTo) throws Exception{
		Expense_pageObj.clickOnaddBill();
		Expense_pageObj.enterTelephoneBillDetails(billname,billnumber,category,subcategory,DateFrom,DateTo,billamount,folderName,
				fileName,MonthYearDateFrom,MonthYearDateTo);
		Thread.sleep(3000);
		Expense_pageObj.clickSaveButton();
		softAssertObj.assertEquals(Expense_pageObj.successMessage_anyBillAction_text(),
				"Bill submitted successfully");
	}
	
	
	@DataProvider(name = "telephonebill4")
	public String[][] getTelephoneBillDetails4() {
		String[][] telephoneBillDetails4 = getData("muExpenseTelephoneDollar50Validations.xlsx", "telephonebill4");
		return telephoneBillDetails4;
	}
	
	@Test(priority = 8,dataProvider = "telephonebill4")
	public void saveTelephoneBill4(String billname,String billnumber,String category,String subcategory,
			String DateFrom,String DateTo,String billamount,String folderName,String fileName,
			String MonthYearDateFrom,String MonthYearDateTo) throws Exception{
		Expense_pageObj.clickOnaddBill();
		Expense_pageObj.enterTelephoneBillDetails(billname,billnumber,category,subcategory,DateFrom,DateTo,billamount,folderName,
				fileName,MonthYearDateFrom,MonthYearDateTo);
		Thread.sleep(3000);
		Expense_pageObj.clickSaveButton();
		softAssertObj.assertEquals(Expense_pageObj.successMessage_anyBillAction_text(),
				"Bill submitted successfully");
	}

	
	@DataProvider(name = "claim34details")
	public String[][] getclaim34details() {
		String[][] claim34details = getData("muExpenseTelephoneDollar50Validations.xlsx", "claim34details");
		return claim34details;
	}
	
	@Test(priority=9,dataProvider = "claim34details")
	public void makeAClaim34(String claimname,String empClaimDetails) throws Exception{
		Expense_pageObj.selectBill(propetiesOverloadObj.getProperty("billnumber3"));
		Expense_pageObj.selectBill(propetiesOverloadObj.getProperty("billnumber4"));
		Expense_pageObj.clickOnMakeAClaimButton();
		Expense_pageObj.makeAClaimWithValidation(claimname,empClaimDetails);
		softAssertObj.assertEquals(Expense_pageObj.successMessage_anyClaimAction_text(), "Claim is successfully submitted ");
	}
	
	
	@DataProvider(name = "telephonebill5")
	public String[][] getTelephoneBillDetails5() {
		String[][] telephoneBillDetails5 = getData("muExpenseTelephoneDollar50Validations.xlsx", "telephonebill5");
		return telephoneBillDetails5;
	}
	
	@Test(priority = 10,dataProvider = "telephonebill5")
	public void saveTelephoneBill5(String billname,String billnumber,String category,String subcategory,
			String DateFrom,String DateTo,String billamount,String folderName,
			String fileName,String MonthYearDateFrom,String MonthYearDateTo) throws Exception{
		Expense_pageObj.clickOnaddBill();
		System.out.println("bill amount is "+billamount);
		Expense_pageObj.enterTelephoneBillDetails(billname,billnumber,category,subcategory,DateFrom,DateTo,billamount,folderName,fileName,MonthYearDateFrom,MonthYearDateTo);
		Thread.sleep(3000);
		Expense_pageObj.clickSaveButton();
		softAssertObj.assertEquals(Expense_pageObj.successMessage_anyBillAction_text(),
				"Bill submitted successfully");
	}
	
	
	@DataProvider(name = "telephonebill6")
	public String[][] getTelephoneBillDetails6() {
		String[][] telephoneBillDetails6 = getData("muExpenseTelephoneDollar50Validations.xlsx", "telephonebill6");
		return telephoneBillDetails6;
	}
	
	@Test(priority = 11,dataProvider = "telephonebill6")
	public void saveTelephoneBill6(String billname,String billnumber,String category,String subcategory,
			String DateFrom,String DateTo,String billamount,String folderName,
			String fileName,String MonthYearDateFrom,String MonthYearDateTo) throws Exception{
		Expense_pageObj.clickOnaddBill();
		System.out.println("bill amount is "+billamount);
		Expense_pageObj.enterTelephoneBillDetails(billname,billnumber,category,subcategory,DateFrom,DateTo,billamount,folderName,
				fileName,MonthYearDateFrom,MonthYearDateTo);
		Thread.sleep(3000);
		Expense_pageObj.clickSaveButton();
		softAssertObj.assertEquals(Expense_pageObj.successMessage_anyBillAction_text(),
				"Bill submitted successfully");
	}
	
	@DataProvider(name = "claim56details")
	public String[][] getclaim56details() {
		String[][] claim56details = getData("muExpenseTelephoneDollar50Validations.xlsx", "claim56details");
		return claim56details;
	}
	
	@Test(priority=12,dataProvider = "claim56details")
	public void makeAClaim56(String claimname,String empClaimDetails) throws Exception{
		Expense_pageObj.selectBill(propetiesOverloadObj.getProperty("billnumber5"));
		Expense_pageObj.selectBill(propetiesOverloadObj.getProperty("billnumber6"));
		Expense_pageObj.clickOnMakeAClaimButton();
		Expense_pageObj.makeAClaimWithValidation(claimname,empClaimDetails);
		softAssertObj.assertEquals(Expense_pageObj.successMessage_anyClaimAction_text(), "Claim is successfully submitted ");
	}
	
/*	@Test(priority=13)
	public void impersonateEmployee_Associate() throws Exception{
		Expense_pageObj.impersonate(propetiesOverloadObj.getProperty("Impersonate_Onsite_Employee_Associate"));
		softAssertObj.assertTrue(Expense_pageObj.getDesignation_text().contains("Associate"));
		
	}
	
	@DataProvider(name = "telephonebill7")
	public String[][] getTelephoneBillDetails7() {
		String[][] telephoneBillDetails7 = getData("muExpenseTelephoneDollar50Validations.xlsx", "telephonebill7");
		return telephoneBillDetails7;
	}
	
	@Test(priority = 14,dataProvider = "telephonebill7")
	public void checkValidationTelephoneBill7(String locationtype,String billname,String billnumber,String category,String subcategory,
			String DateFrom,String DateTo,String billamount,String folderName,
			String fileName,String MonthYearDateFrom,String MonthYearDateTo,String invalidemployee) throws Exception{
		Expense_pageObj.clickOnaddBill();
		Expense_pageObj.selectTaxEntity(locationtype);
		Expense_pageObj.enterTelephoneBillDetails(billname,billnumber,category,subcategory,DateFrom,DateTo,billamount,folderName,
				fileName,MonthYearDateFrom,MonthYearDateTo);
		Thread.sleep(3000);
		Expense_pageObj.clickSaveButton();
		Expense_pageObj.invalidEmployeeListPopUp(invalidemployee);
	}
	
	@Test(priority =15,dataProvider = "telephonebill7")
	public void saveTelephoneBill7(String locationtype,String billname,String billnumber,String category,String subcategory,
			String DateFrom,String DateTo,String billamount,String folderName,
			String fileName,String MonthYearDateFrom,String MonthYearDateTo,String invalidemployee) throws Exception{
		//Expense_pageObj.selectTaxEntity(propetiesOverloadObj.getProperty("locationtype1"));
		Expense_pageObj.clickOnaddBill();
		Expense_pageObj.selectTaxEntity(locationtype);
		Expense_pageObj.enterTelephoneBillDetails(billname,billnumber,category,subcategory,DateFrom,DateTo,billamount,folderName,
				fileName,MonthYearDateFrom,MonthYearDateTo);
		Thread.sleep(3000);
		Expense_pageObj.clickSaveButton();
		softAssertObj.assertEquals(Expense_pageObj.successMessage_anyBillAction_text(),
				"Bill submitted successfully");
	}
	
	@DataProvider(name = "telephonebill8")
	public String[][] getTelephoneBillDetails8() {
		String[][] telephoneBillDetails8 = getData("muExpenseTelephoneDollar50Validations.xlsx", "telephonebill8");
		return telephoneBillDetails8;
	}
	
	@Test(priority = 16,dataProvider = "telephonebill8")
	public void saveTelephoneBill8(String locationtype,String billname,String billnumber,String category,String subcategory,
			String DateFrom,String DateTo,String billamount,String folderName,
			String fileName,String MonthYearDateFrom,String MonthYearDateTo) throws Exception{
		Expense_pageObj.clickOnaddBill();
		Expense_pageObj.selectTaxEntity(locationtype);
		Expense_pageObj.enterTelephoneBillDetails(billname,billnumber,category,subcategory,DateFrom,DateTo,billamount,folderName,
				fileName,MonthYearDateFrom,MonthYearDateTo);
		Thread.sleep(3000);
		Expense_pageObj.clickSaveButton();
		softAssertObj.assertEquals(Expense_pageObj.successMessage_anyBillAction_text(),
				"Bill submitted successfully");
	}
	
	@Test(priority=17)
	public void checkValidationmakeAClaim7() throws Exception{
		Expense_pageObj.selectBill(propetiesOverloadObj.getProperty("billnumber7"));
		Expense_pageObj.selectBill(propetiesOverloadObj.getProperty("billnumber8"));
		Expense_pageObj.clickOnMakeAClaimButton();
		Expense_pageObj.makeAClaim(propetiesOverloadObj.getProperty("claimnamebill78"));
		Expense_pageObj.clickOKbutton();
	}
	
	@Test(priority=18)
	public void makeAClaim7() throws Exception{
		Expense_pageObj.selectBill(propetiesOverloadObj.getProperty("billnumber8"));
		Expense_pageObj.clickOnMakeAClaimButton();
		Expense_pageObj.makeAClaim(propetiesOverloadObj.getProperty("claimnamebill7"));
		softAssertObj.assertEquals(Expense_pageObj.successMessage_anyClaimAction_text(), "Claim is successfully submitted ");
	}
	
	@Test(priority=19)
	public void makeAClaim8() throws Exception{
		Expense_pageObj.selectBill(propetiesOverloadObj.getProperty("billnumber8"));
		Expense_pageObj.clickOnMakeAClaimButton();
		Expense_pageObj.makeAClaim(propetiesOverloadObj.getProperty("claimnamebill8"));
		softAssertObj.assertEquals(Expense_pageObj.successMessage_anyClaimAction_text(), "Claim is successfully submitted ");
	}
	
	@Test(priority=20)
	public void impersonate_Employee_Associate() throws Exception{
		Expense_pageObj.impersonate(propetiesOverloadObj.getProperty("Onsite_Employee_Associate"));
		softAssertObj.assertTrue(Expense_pageObj.getDesignation_text().contains("Associate"));	
	}*/
	
	@DataProvider(name = "telephonebill9")
	public String[][] getTelephoneBillDetails9() {
		String[][] telephoneBillDetails9 = getData("muExpenseTelephoneDollar50Validations.xlsx", "telephonebill9");
		return telephoneBillDetails9;
	}
	
	@Test(priority=21,dataProvider = "telephonebill9")
	public void checkValidationTelephoneBill9(String billname,String billnumber,String category,String subcategory,
				String DateFrom,String DateTo,String billamount,String folderName,
				String fileName,String MonthYearDateFrom,String MonthYearDateTo,String radiobuttonOption,String addmemberName) throws Exception{
		Expense_pageObj.clickOnaddBill();
		Expense_pageObj.enterTelephoneBillDetails(billname,billnumber,category,subcategory,DateFrom,DateTo,billamount,folderName,
					fileName,MonthYearDateFrom,MonthYearDateTo);
		Expense_pageObj.selectRadiobutton(radiobuttonOption);
		Expense_pageObj.addMember(addmemberName);
		Thread.sleep(3000);
		softAssertObj.assertEquals(Expense_pageObj.errorMessage_oneEmployee_text(),"Only one employee can be selected");
	}
	
	@Test(priority=22)
	public void saveTelephoneBill9() throws Exception{
		Expense_pageObj.removeMember(propetiesOverloadObj.getProperty("removeEmployeeName1"));
		Expense_pageObj.addMember(propetiesOverloadObj.getProperty("addEmployeeName1"));
		Expense_pageObj.clickSaveButton();
		softAssertObj.assertEquals(Expense_pageObj.successMessage_anyBillAction_text(),
				"Bill submitted successfully");
	}
	
	@Test(priority=23)
	public void makeAClaim9() throws Exception{
		Expense_pageObj.selectBill(propetiesOverloadObj.getProperty("billnumber9"));
		Expense_pageObj.clickOnMakeAClaimButton();
		Expense_pageObj.makeAClaim(propetiesOverloadObj.getProperty("claimnamebill9"));
		softAssertObj.assertEquals(Expense_pageObj.successMessage_anyClaimAction_text(), "Claim is successfully submitted ");
	}
	
	@Test(priority=24)
	public void impersonateTrainee() throws Exception{
		Expense_pageObj.impersonate(propetiesOverloadObj.getProperty("Onsite_Employee_Trainee"));
		softAssertObj.assertTrue(Expense_pageObj.getDesignation_text().contains("Trainee"));
		
	}
	
	@DataProvider(name = "telephonebill10")
	public String[][] getTelephoneBillDetails10() {
		String[][] telephoneBillDetails10 = getData("muExpenseTelephoneDollar50Validations.xlsx", "telephonebill10");
		return telephoneBillDetails10;
	}
	
	@Test(priority = 25,dataProvider = "telephonebill10")
	public void saveTelephoneBill10(String billname,String billnumber,String category,String subcategory,
			String DateFrom,String DateTo,String billamount,String folderName,String fileName,
			String eligibleAmount,String MonthYearDateFrom,String MonthYearDateTo) throws Exception{
		Expense_pageObj.clickOnaddBill();
		Expense_pageObj.enterTelephoneBillDetails(billname,billnumber,category,subcategory,DateFrom,DateTo,billamount,folderName,fileName,
				MonthYearDateFrom,MonthYearDateTo);
		Thread.sleep(3000);
		Expense_pageObj.clickSaveButtonWithValidation(eligibleAmount);
		softAssertObj.assertEquals(Expense_pageObj.successMessage_anyBillAction_text(),
				"Bill submitted successfully");
	}
	
	@DataProvider(name = "claim10details")
	public String[][] getclaim10details() {
		String[][] claim10details = getData("muExpenseTelephoneDollar50Validations.xlsx", "claim10details");
		return claim10details;
	}
	
	@Test(priority=26,dataProvider = "claim10details")
	public void makeAClaim10(String claimname,String empClaimDetails) throws Exception{
		Expense_pageObj.selectBill(propetiesOverloadObj.getProperty("billnumber10"));
		Expense_pageObj.clickOnMakeAClaimButton();
		Expense_pageObj.makeAClaimWithValidation(claimname,empClaimDetails);
		softAssertObj.assertEquals(Expense_pageObj.successMessage_anyClaimAction_text(), "Claim is successfully submitted ");
	}	
	
	
	
	@DataProvider(name = "telephonebill11")
	public String[][] getTelephoneBillDetails11() {
		String[][] telephoneBillDetails11 = getData("muExpenseTelephoneDollar50Validations.xlsx", "telephonebill11");
		return telephoneBillDetails11;
	}
	
	@Test(priority = 27,dataProvider = "telephonebill11")
	public void saveTelephoneBill11(String billname,String billnumber,String category,String subcategory,
			String DateFrom,String DateTo,String billamount,String folderName,String fileName,
			String MonthYearDateFrom,String MonthYearDateTo) throws Exception{
		Expense_pageObj.clickOnaddBill();
		Expense_pageObj.enterTelephoneBillDetails(billname,billnumber,category,subcategory,DateFrom,DateTo,billamount,folderName,
				fileName,MonthYearDateFrom,MonthYearDateTo);
		Thread.sleep(3000);
		Expense_pageObj.clickSaveButton();
		softAssertObj.assertEquals(Expense_pageObj.successMessage_anyBillAction_text(),
				"Bill submitted successfully");
	}
	
	
	@DataProvider(name = "telephonebill12")
	public String[][] getTelephoneBillDetails12() {
		String[][] telephoneBillDetails12 = getData("muExpenseTelephoneDollar50Validations.xlsx", "telephonebill12");
		return telephoneBillDetails12;
	}
	
	@Test(priority = 28,dataProvider = "telephonebill12")
	public void saveTelephoneBill12(String billname,String billnumber,String category,String subcategory,
			String DateFrom,String DateTo,String billamount,String folderName,String fileName,
			String MonthYearDateFrom,String MonthYearDateTo) throws Exception{
		Expense_pageObj.clickOnaddBill();
		Expense_pageObj.enterTelephoneBillDetails(billname,billnumber,category,subcategory,DateFrom,DateTo,billamount,folderName,
				fileName,MonthYearDateFrom,MonthYearDateTo);
		Thread.sleep(3000);
		Expense_pageObj.clickSaveButton();
		softAssertObj.assertEquals(Expense_pageObj.successMessage_anyBillAction_text(),
				"Bill submitted successfully");
	}

	
	@DataProvider(name = "claim1112details")
	public String[][] getclaim1112details() {
		String[][] claim1112details = getData("muExpenseTelephoneDollar50Validations.xlsx", "claim1112details");
		return claim1112details;
	}
	
	@Test(priority=29,dataProvider = "claim1112details")
	public void makeAClaim1112(String claimname,String empClaimDetails) throws Exception{
		Expense_pageObj.selectBill(propetiesOverloadObj.getProperty("billnumber11"));
		Expense_pageObj.selectBill(propetiesOverloadObj.getProperty("billnumber12"));
		Expense_pageObj.clickOnMakeAClaimButton();
		Expense_pageObj.makeAClaimWithValidation(claimname,empClaimDetails);
		softAssertObj.assertEquals(Expense_pageObj.successMessage_anyClaimAction_text(), "Claim is successfully submitted ");
	}
	
	
	@DataProvider(name = "telephonebill13")
	public String[][] getTelephoneBillDetails13() {
		String[][] telephoneBillDetails13 = getData("muExpenseTelephoneDollar50Validations.xlsx", "telephonebill13");
		return telephoneBillDetails13;
	}
	
	@Test(priority = 30,dataProvider = "telephonebill13")
	public void saveTelephoneBill13(String billname,String billnumber,String category,String subcategory,
			String DateFrom,String DateTo,String billamount,String folderName,
			String fileName,String MonthYearDateFrom,String MonthYearDateTo) throws Exception{
		Expense_pageObj.clickOnaddBill();
		System.out.println("bill amount is "+billamount);
		Expense_pageObj.enterTelephoneBillDetails(billname,billnumber,category,subcategory,DateFrom,DateTo,billamount,folderName,fileName,MonthYearDateFrom,MonthYearDateTo);
		Thread.sleep(3000);
		Expense_pageObj.clickSaveButton();
		softAssertObj.assertEquals(Expense_pageObj.successMessage_anyBillAction_text(),
				"Bill submitted successfully");
	}
	
	
	@DataProvider(name = "telephonebill14")
	public String[][] getTelephoneBillDetails14() {
		String[][] telephoneBillDetails14 = getData("muExpenseTelephoneDollar50Validations.xlsx", "telephonebill14");
		return telephoneBillDetails14;
	}
	
	@Test(priority = 31,dataProvider = "telephonebill14")
	public void saveTelephoneBill14(String billname,String billnumber,String category,String subcategory,
			String DateFrom,String DateTo,String billamount,String folderName,
			String fileName,String MonthYearDateFrom,String MonthYearDateTo) throws Exception{
		Expense_pageObj.clickOnaddBill();
		System.out.println("bill amount is "+billamount);
		Expense_pageObj.enterTelephoneBillDetails(billname,billnumber,category,subcategory,DateFrom,DateTo,billamount,folderName,
				fileName,MonthYearDateFrom,MonthYearDateTo);
		Thread.sleep(3000);
		Expense_pageObj.clickSaveButton();
		softAssertObj.assertEquals(Expense_pageObj.successMessage_anyBillAction_text(),
				"Bill submitted successfully");
	}
	
	@DataProvider(name = "claim1314details")
	public String[][] getclaim1314details() {
		String[][] claim1314details = getData("muExpenseTelephoneDollar50Validations.xlsx", "claim1314details");
		return claim1314details;
	}
	
	@Test(priority=32,dataProvider = "claim1314details")
	public void makeAClaim1314(String claimname,String empClaimDetails) throws Exception{
		Expense_pageObj.selectBill(propetiesOverloadObj.getProperty("billnumber13"));
		Expense_pageObj.selectBill(propetiesOverloadObj.getProperty("billnumber14"));
		Expense_pageObj.clickOnMakeAClaimButton();
		Expense_pageObj.makeAClaimWithValidation(claimname,empClaimDetails);
		softAssertObj.assertEquals(Expense_pageObj.successMessage_anyClaimAction_text(), "Claim is successfully submitted ");
	}
	
	/*@Test(priority=33)
	public void impersonateEmployee_Trainee() throws Exception{
		Expense_pageObj.impersonate(propetiesOverloadObj.getProperty("Impersonate_Onsite_Employee_Trainee"));
		softAssertObj.assertTrue(Expense_pageObj.getDesignation_text().contains("Trainee"));
		
	}
	
	@DataProvider(name = "telephonebill15")
	public String[][] getTelephoneBillDetails15() {
		String[][] telephoneBillDetails15 = getData("muExpenseTelephoneDollar50Validations.xlsx", "telephonebill15");
		return telephoneBillDetails15;
	}*/
	
	/*@Test(priority = 34,dataProvider = "telephonebill15")
	public void checkValidationTelephoneBill15(String locationtype,String billname,String billnumber,String category,String subcategory,
			String DateFrom,String DateTo,String billamount,String folderName,
			String fileName,String MonthYearDateFrom,String MonthYearDateTo,String invalidemployee) throws Exception{
		Expense_pageObj.clickOnaddBill();
		Expense_pageObj.selectTaxEntity(locationtype);
		Expense_pageObj.enterTelephoneBillDetails(billname,billnumber,category,subcategory,DateFrom,DateTo,billamount,folderName,
				fileName,MonthYearDateFrom,MonthYearDateTo);
		Thread.sleep(3000);
		Expense_pageObj.clickSaveButton();
		Expense_pageObj.invalidEmployeeListPopUp(invalidemployee);
	}*/
	
	/*@Test(priority =35,dataProvider = "telephonebill15")
	public void saveTelephoneBill15(String locationtype,String billname,String billnumber,String category,String subcategory,
			String DateFrom,String DateTo,String billamount,String folderName,
			String fileName,String MonthYearDateFrom,String MonthYearDateTo,String invalidemployee) throws Exception{
		//Expense_pageObj.selectTaxEntity(propetiesOverloadObj.getProperty("locationtype2"));
		Expense_pageObj.clickOnaddBill();
		Expense_pageObj.selectTaxEntity(locationtype);
		Expense_pageObj.enterTelephoneBillDetails(billname,billnumber,category,subcategory,DateFrom,DateTo,billamount,folderName,
				fileName,MonthYearDateFrom,MonthYearDateTo);
		Thread.sleep(3000);
		Expense_pageObj.clickSaveButton();
		softAssertObj.assertEquals(Expense_pageObj.successMessage_anyBillAction_text(),
				"Bill submitted successfully");
	}
	
	@DataProvider(name = "telephonebill16")
	public String[][] getTelephoneBillDetails16() {
		String[][] telephoneBillDetails16 = getData("muExpenseTelephoneDollar50Validations.xlsx", "telephonebill16");
		return telephoneBillDetails16;
	}
	
	@Test(priority = 36,dataProvider = "telephonebill16")
	public void saveTelephoneBill16(String locationtype,String billname,String billnumber,String category,String subcategory,
			String DateFrom,String DateTo,String billamount,String folderName,
			String fileName,String MonthYearDateFrom,String MonthYearDateTo) throws Exception{
		Expense_pageObj.clickOnaddBill();
		Expense_pageObj.selectTaxEntity(locationtype);
		Expense_pageObj.enterTelephoneBillDetails(billname,billnumber,category,subcategory,DateFrom,DateTo,billamount,folderName,
				fileName,MonthYearDateFrom,MonthYearDateTo);
		Thread.sleep(3000);
		Expense_pageObj.clickSaveButton();
		softAssertObj.assertEquals(Expense_pageObj.successMessage_anyBillAction_text(),
				"Bill submitted successfully");
	}
	
	@Test(priority=37)
	public void checkValidationmakeAClaim15() throws Exception{
		Expense_pageObj.selectBill(propetiesOverloadObj.getProperty("billnumber15"));
		Expense_pageObj.selectBill(propetiesOverloadObj.getProperty("billnumber16"));
		Expense_pageObj.clickOnMakeAClaimButton();
		Expense_pageObj.makeAClaim(propetiesOverloadObj.getProperty("claimnamebill1516"));
		Expense_pageObj.clickOKbutton();
	}
	
	@Test(priority=38)
	public void makeAClaim15() throws Exception{
		Expense_pageObj.selectBill(propetiesOverloadObj.getProperty("billnumber16"));
		Expense_pageObj.clickOnMakeAClaimButton();
		Expense_pageObj.makeAClaim(propetiesOverloadObj.getProperty("claimnamebill15"));
		softAssertObj.assertEquals(Expense_pageObj.successMessage_anyClaimAction_text(), "Claim is successfully submitted ");
	}
	
	@Test(priority=39)
	public void makeAClaim16() throws Exception{
		Expense_pageObj.selectBill(propetiesOverloadObj.getProperty("billnumber16"));
		Expense_pageObj.clickOnMakeAClaimButton();
		Expense_pageObj.makeAClaim(propetiesOverloadObj.getProperty("claimnamebill16"));
		softAssertObj.assertEquals(Expense_pageObj.successMessage_anyClaimAction_text(), "Claim is successfully submitted ");
	}
	
	@Test(priority=40)
	public void impersonate_Employee_Trainee() throws Exception{
		Expense_pageObj.impersonate(propetiesOverloadObj.getProperty("Onsite_Employee_Trainee"));
		softAssertObj.assertTrue(Expense_pageObj.getDesignation_text().contains("Trainee"));	
	}*/
	
	@DataProvider(name = "telephonebill17")
	public String[][] getTelephoneBillDetails17() {
		String[][] telephoneBillDetails17 = getData("muExpenseTelephoneDollar50Validations.xlsx", "telephonebill17");
		return telephoneBillDetails17;
	}
	
	@Test(priority=41,dataProvider = "telephonebill17")
	public void checkValidationTelephoneBill17(String billname,String billnumber,String category,String subcategory,
				String DateFrom,String DateTo,String billamount,String folderName,
				String fileName,String MonthYearDateFrom,String MonthYearDateTo,String radiobuttonOption,String addmemberName) throws Exception{
		Expense_pageObj.clickOnaddBill();
		Expense_pageObj.enterTelephoneBillDetails(billname,billnumber,category,subcategory,DateFrom,DateTo,billamount,folderName,
					fileName,MonthYearDateFrom,MonthYearDateTo);
		Expense_pageObj.selectRadiobutton(radiobuttonOption);
		Expense_pageObj.addMember(addmemberName);
		Thread.sleep(3000);
		softAssertObj.assertEquals(Expense_pageObj.errorMessage_oneEmployee_text(),"Only one employee can be selected");
	}
	
	@Test(priority=42)
	public void saveTelephoneBill17() throws Exception{
		Expense_pageObj.removeMember(propetiesOverloadObj.getProperty("removeEmployeeName2"));
		Expense_pageObj.addMember(propetiesOverloadObj.getProperty("addEmployeeName2"));
		Expense_pageObj.clickSaveButton();
		softAssertObj.assertEquals(Expense_pageObj.successMessage_anyBillAction_text(),
				"Bill submitted successfully");
	}
	
	@Test(priority=43)
	public void makeAClaim17() throws Exception{
		Expense_pageObj.selectBill(propetiesOverloadObj.getProperty("billnumber17"));
		Expense_pageObj.clickOnMakeAClaimButton();
		Expense_pageObj.makeAClaim(propetiesOverloadObj.getProperty("claimnamebill17"));
		softAssertObj.assertEquals(Expense_pageObj.successMessage_anyClaimAction_text(), "Claim is successfully submitted ");
	}
	
	@Test(priority=44)
	public void impersonateJuniorAssociate() throws Exception{
		Expense_pageObj.impersonate(propetiesOverloadObj.getProperty("Onsite_Employee_JuniorAssociate"));
		softAssertObj.assertTrue(Expense_pageObj.getDesignation_text().contains("Junior Associate"));
		
	}
	
	@DataProvider(name = "telephonebill18")
	public String[][] getTelephoneBillDetails18() {
		String[][] telephoneBillDetails18 = getData("muExpenseTelephoneDollar50Validations.xlsx", "telephonebill18");
		return telephoneBillDetails18;
	}
	
	@Test(priority = 45,dataProvider = "telephonebill18")
	public void saveTelephoneBill18(String billname,String billnumber,String category,String subcategory,
			String DateFrom,String DateTo,String billamount,String folderName,String fileName,
			String eligibleAmount,String MonthYearDateFrom,String MonthYearDateTo) throws Exception{
		Expense_pageObj.clickOnaddBill();
		Expense_pageObj.enterTelephoneBillDetails(billname,billnumber,category,subcategory,DateFrom,DateTo,billamount,folderName,fileName,
				MonthYearDateFrom,MonthYearDateTo);
		Thread.sleep(3000);
		Expense_pageObj.clickSaveButtonWithValidation(eligibleAmount);
		softAssertObj.assertEquals(Expense_pageObj.successMessage_anyBillAction_text(),
				"Bill submitted successfully");
	}
	
	@DataProvider(name = "claim18details")
	public String[][] getclaim18details() {
		String[][] claim18details = getData("muExpenseTelephoneDollar50Validations.xlsx", "claim18details");
		return claim18details;
	}
	
	@Test(priority=46,dataProvider = "claim18details")
	public void makeAClaim18(String claimname,String empClaimDetails) throws Exception{
		Expense_pageObj.selectBill(propetiesOverloadObj.getProperty("billnumber18"));
		Expense_pageObj.clickOnMakeAClaimButton();
		Expense_pageObj.makeAClaimWithValidation(claimname,empClaimDetails);
		softAssertObj.assertEquals(Expense_pageObj.successMessage_anyClaimAction_text(), "Claim is successfully submitted ");
	}	
	
	@DataProvider(name = "telephonebill19")
	public String[][] getTelephoneBillDetails19() {
		String[][] telephoneBillDetails19 = getData("muExpenseTelephoneDollar50Validations.xlsx", "telephonebill19");
		return telephoneBillDetails19;
	}
	
	@Test(priority = 47,dataProvider = "telephonebill19")
	public void saveTelephoneBill19(String billname,String billnumber,String category,String subcategory,
			String DateFrom,String DateTo,String billamount,String folderName,String fileName,
			String MonthYearDateFrom,String MonthYearDateTo) throws Exception{
		Expense_pageObj.clickOnaddBill();
		Expense_pageObj.enterTelephoneBillDetails(billname,billnumber,category,subcategory,DateFrom,DateTo,billamount,folderName,
				fileName,MonthYearDateFrom,MonthYearDateTo);
		Thread.sleep(3000);
		Expense_pageObj.clickSaveButton();
		softAssertObj.assertEquals(Expense_pageObj.successMessage_anyBillAction_text(),
				"Bill submitted successfully");
	}
	
	
	@DataProvider(name = "telephonebill20")
	public String[][] getTelephoneBillDetails20() {
		String[][] telephoneBillDetails20 = getData("muExpenseTelephoneDollar50Validations.xlsx", "telephonebill20");
		return telephoneBillDetails20;
	}
	
	@Test(priority = 48,dataProvider = "telephonebill20")
	public void saveTelephoneBill20(String billname,String billnumber,String category,String subcategory,
			String DateFrom,String DateTo,String billamount,String folderName,String fileName,
			String MonthYearDateFrom,String MonthYearDateTo) throws Exception{
		Expense_pageObj.clickOnaddBill();
		Expense_pageObj.enterTelephoneBillDetails(billname,billnumber,category,subcategory,DateFrom,DateTo,billamount,folderName,
				fileName,MonthYearDateFrom,MonthYearDateTo);
		Thread.sleep(3000);
		Expense_pageObj.clickSaveButton();
		softAssertObj.assertEquals(Expense_pageObj.successMessage_anyBillAction_text(),
				"Bill submitted successfully");
	}

	
	@DataProvider(name = "claim1920details")
	public String[][] getclaim1920details() {
		String[][] claim1920details = getData("muExpenseTelephoneDollar50Validations.xlsx", "claim1920details");
		return claim1920details;
	}
	
	@Test(priority=49,dataProvider = "claim1920details")
	public void makeAClaim1920(String claimname,String empClaimDetails) throws Exception{
		Expense_pageObj.selectBill(propetiesOverloadObj.getProperty("billnumber19"));
		Expense_pageObj.selectBill(propetiesOverloadObj.getProperty("billnumber20"));
		Expense_pageObj.clickOnMakeAClaimButton();
		Expense_pageObj.makeAClaimWithValidation(claimname,empClaimDetails);
		softAssertObj.assertEquals(Expense_pageObj.successMessage_anyClaimAction_text(), "Claim is successfully submitted ");
	}
	
	
	@DataProvider(name = "telephonebill21")
	public String[][] getTelephoneBillDetails21() {
		String[][] telephoneBillDetails21 = getData("muExpenseTelephoneDollar50Validations.xlsx", "telephonebill21");
		return telephoneBillDetails21;
	}
	
	@Test(priority = 50,dataProvider = "telephonebill21")
	public void saveTelephoneBill21(String billname,String billnumber,String category,String subcategory,
			String DateFrom,String DateTo,String billamount,String folderName,
			String fileName,String MonthYearDateFrom,String MonthYearDateTo) throws Exception{
		Expense_pageObj.clickOnaddBill();
		System.out.println("bill amount is "+billamount);
		Expense_pageObj.enterTelephoneBillDetails(billname,billnumber,category,subcategory,DateFrom,DateTo,billamount,folderName,fileName,MonthYearDateFrom,MonthYearDateTo);
		Thread.sleep(3000);
		Expense_pageObj.clickSaveButton();
		softAssertObj.assertEquals(Expense_pageObj.successMessage_anyBillAction_text(),
				"Bill submitted successfully");
	}
	
	
	@DataProvider(name = "telephonebill22")
	public String[][] getTelephoneBillDetails22() {
		String[][] telephoneBillDetails22 = getData("muExpenseTelephoneDollar50Validations.xlsx", "telephonebill22");
		return telephoneBillDetails22;
	}
	
	@Test(priority = 51,dataProvider = "telephonebill22")
	public void saveTelephoneBill22(String billname,String billnumber,String category,String subcategory,
			String DateFrom,String DateTo,String billamount,String folderName,
			String fileName,String MonthYearDateFrom,String MonthYearDateTo) throws Exception{
		Expense_pageObj.clickOnaddBill();
		System.out.println("bill amount is "+billamount);
		Expense_pageObj.enterTelephoneBillDetails(billname,billnumber,category,subcategory,DateFrom,DateTo,billamount,folderName,
				fileName,MonthYearDateFrom,MonthYearDateTo);
		Thread.sleep(3000);
		Expense_pageObj.clickSaveButton();
		softAssertObj.assertEquals(Expense_pageObj.successMessage_anyBillAction_text(),
				"Bill submitted successfully");
	}
	
	@DataProvider(name = "claim2122details")
	public String[][] getclaim2122details() {
		String[][] claim2122details = getData("muExpenseTelephoneDollar50Validations.xlsx", "claim2122details");
		return claim2122details;
	}
	
	@Test(priority=52,dataProvider = "claim2122details")
	public void makeAClaim2122(String claimname,String empClaimDetails) throws Exception{
		Expense_pageObj.selectBill(propetiesOverloadObj.getProperty("billnumber21"));
		Expense_pageObj.selectBill(propetiesOverloadObj.getProperty("billnumber22"));
		Expense_pageObj.clickOnMakeAClaimButton();
		Expense_pageObj.makeAClaimWithValidation(claimname,empClaimDetails);
		softAssertObj.assertEquals(Expense_pageObj.successMessage_anyClaimAction_text(), "Claim is successfully submitted ");
	}
	
	/*@Test(priority=53)
	public void impersonate_Employee_Junior_Associate() throws Exception{
		Expense_pageObj.impersonate(propetiesOverloadObj.getProperty("Impersonate_Onsite_Employee_JuniorAssociate"));
		softAssertObj.assertTrue(Expense_pageObj.getDesignation_text().contains("Junior Associate"));
		
	}
	
	@DataProvider(name = "telephonebill23")
	public String[][] getTelephoneBillDetails23() {
		String[][] telephoneBillDetails23 = getData("muExpenseTelephoneDollar50Validations.xlsx", "telephonebill23");
		return telephoneBillDetails23;
	}
	
	@Test(priority = 54,dataProvider = "telephonebill23")
	public void checkValidationTelephoneBill23(String locationtype,String billname,String billnumber,String category,String subcategory,
			String DateFrom,String DateTo,String billamount,String folderName,
			String fileName,String MonthYearDateFrom,String MonthYearDateTo,String invalidemployee) throws Exception{
		Expense_pageObj.clickOnaddBill();
		Expense_pageObj.selectTaxEntity(locationtype);
		Expense_pageObj.enterTelephoneBillDetails(billname,billnumber,category,subcategory,DateFrom,DateTo,billamount,folderName,
				fileName,MonthYearDateFrom,MonthYearDateTo);
		Thread.sleep(3000);
		Expense_pageObj.clickSaveButton();
		Expense_pageObj.invalidEmployeeListPopUp(invalidemployee);
	}
	
	@Test(priority =55,dataProvider = "telephonebill23")
	public void saveTelephoneBill23(String locationtype,String billname,String billnumber,String category,String subcategory,
			String DateFrom,String DateTo,String billamount,String folderName,
			String fileName,String MonthYearDateFrom,String MonthYearDateTo,String invalidemployee) throws Exception{
		//Expense_pageObj.selectTaxEntity(propetiesOverloadObj.getProperty("locationtype3"));
		Expense_pageObj.clickOnaddBill();
		Expense_pageObj.selectTaxEntity(locationtype);
		Expense_pageObj.enterTelephoneBillDetails(billname,billnumber,category,subcategory,DateFrom,DateTo,billamount,folderName,
				fileName,MonthYearDateFrom,MonthYearDateTo);
		Thread.sleep(3000);
		Expense_pageObj.clickSaveButton();
		softAssertObj.assertEquals(Expense_pageObj.successMessage_anyBillAction_text(),
				"Bill submitted successfully");
	}
	
	@DataProvider(name = "telephonebill24")
	public String[][] getTelephoneBillDetails24() {
		String[][] telephoneBillDetails24 = getData("muExpenseTelephoneDollar50Validations.xlsx", "telephonebill24");
		return telephoneBillDetails24;
	}
	
	@Test(priority = 56,dataProvider = "telephonebill24")
	public void saveTelephoneBill24(String locationtype,String billname,String billnumber,String category,String subcategory,
			String DateFrom,String DateTo,String billamount,String folderName,
			String fileName,String MonthYearDateFrom,String MonthYearDateTo) throws Exception{
		Expense_pageObj.clickOnaddBill();
		Expense_pageObj.selectTaxEntity(locationtype);
		Expense_pageObj.enterTelephoneBillDetails(billname,billnumber,category,subcategory,DateFrom,DateTo,billamount,folderName,
				fileName,MonthYearDateFrom,MonthYearDateTo);
		Thread.sleep(3000);
		Expense_pageObj.clickSaveButton();
		softAssertObj.assertEquals(Expense_pageObj.successMessage_anyBillAction_text(),
				"Bill submitted successfully");
	}
	
	@Test(priority=57)
	public void checkValidationmakeAClaim23() throws Exception{
		Expense_pageObj.selectBill(propetiesOverloadObj.getProperty("billnumber23"));
		Expense_pageObj.selectBill(propetiesOverloadObj.getProperty("billnumber24"));
		Expense_pageObj.clickOnMakeAClaimButton();
		Expense_pageObj.makeAClaim(propetiesOverloadObj.getProperty("claimnamebill2324"));
		Expense_pageObj.clickOKbutton();
	}
	
	@Test(priority=58)
	public void makeAClaim23() throws Exception{
		Expense_pageObj.selectBill(propetiesOverloadObj.getProperty("billnumber24"));
		Expense_pageObj.clickOnMakeAClaimButton();
		Expense_pageObj.makeAClaim(propetiesOverloadObj.getProperty("claimnamebill23"));
		softAssertObj.assertEquals(Expense_pageObj.successMessage_anyClaimAction_text(), "Claim is successfully submitted ");
	}
	
	@Test(priority=59)
	public void makeAClaim24() throws Exception{
		Expense_pageObj.selectBill(propetiesOverloadObj.getProperty("billnumber24"));
		Expense_pageObj.clickOnMakeAClaimButton();
		Expense_pageObj.makeAClaim(propetiesOverloadObj.getProperty("claimnamebill24"));
		softAssertObj.assertEquals(Expense_pageObj.successMessage_anyClaimAction_text(), "Claim is successfully submitted ");
	}
	
	@Test(priority=60)
	public void impersonate_EmployeeJuniorAssociate() throws Exception{
		Expense_pageObj.impersonate(propetiesOverloadObj.getProperty("Onsite_Employee_JuniorAssociate"));
		softAssertObj.assertTrue(Expense_pageObj.getDesignation_text().contains("Junior Associate"));	
	}*/
	
	@DataProvider(name = "telephonebill25")
	public String[][] getTelephoneBillDetails25() {
		String[][] telephoneBillDetails25 = getData("muExpenseTelephoneDollar50Validations.xlsx", "telephonebill25");
		return telephoneBillDetails25;
	}
	
	@Test(priority=61,dataProvider = "telephonebill25")
	public void checkValidationTelephoneBill25(String billname,String billnumber,String category,String subcategory,
				String DateFrom,String DateTo,String billamount,String folderName,
				String fileName,String MonthYearDateFrom,String MonthYearDateTo,String radiobuttonOption,String addmemberName) throws Exception{
		Expense_pageObj.clickOnaddBill();
		Expense_pageObj.enterTelephoneBillDetails(billname,billnumber,category,subcategory,DateFrom,DateTo,billamount,folderName,
					fileName,MonthYearDateFrom,MonthYearDateTo);
		Expense_pageObj.selectRadiobutton(radiobuttonOption);
		Expense_pageObj.addMember(addmemberName);
		Thread.sleep(3000);
		softAssertObj.assertEquals(Expense_pageObj.errorMessage_oneEmployee_text(),"Only one employee can be selected");
	}
	
	@Test(priority=62)
	public void saveTelephoneBill25() throws Exception{
		Expense_pageObj.removeMember(propetiesOverloadObj.getProperty("removeEmployeeName3"));
		Expense_pageObj.addMember(propetiesOverloadObj.getProperty("addEmployeeName3"));
		Expense_pageObj.clickSaveButton();
		softAssertObj.assertEquals(Expense_pageObj.successMessage_anyBillAction_text(),
				"Bill submitted successfully");
	}
	
	@Test(priority=63)
	public void makeAClaim25() throws Exception{
		Expense_pageObj.selectBill(propetiesOverloadObj.getProperty("billnumber25"));
		Expense_pageObj.clickOnMakeAClaimButton();
		Expense_pageObj.makeAClaim(propetiesOverloadObj.getProperty("claimnamebill25"));
		softAssertObj.assertEquals(Expense_pageObj.successMessage_anyClaimAction_text(), "Claim is successfully submitted ");
	}
	
	
	
	
	@Test(priority=64)
	public void impersonateEmployeeApprenticeEngagementManager() throws Exception{
		Expense_pageObj.impersonate(propetiesOverloadObj.getProperty("Onsite_Employee_ApprenticeEngagementManager"));
		softAssertObj.assertTrue(Expense_pageObj.getDesignation_text().contains("Apprentice Engagement Manager"));	
	}
	
	@DataProvider(name = "telephonebill26")
	public String[][] getTelephoneBillDetails26() {
		String[][] telephoneBillDetails26 = getData("muExpenseTelephoneDollar50Validations.xlsx", "telephonebill26");
		return telephoneBillDetails26;
	}
	@Test(priority = 65,dataProvider = "telephonebill26")
	public void saveTelephoneBill26(String billname,String billnumber,String category,String subcategory,
			String DateFrom,String DateTo,String billamount,String folderName,String fileName,
			String MonthYearDateFrom,String MonthYearDateTo) throws Exception{
		Expense_pageObj.clickOnaddBill();
		Expense_pageObj.enterTelephoneBillDetails(billname,billnumber,category,subcategory,DateFrom,DateTo,billamount,folderName,fileName,
				MonthYearDateFrom,MonthYearDateTo);
		Thread.sleep(3000);
		Expense_pageObj.clickSaveButton();
		softAssertObj.assertEquals(Expense_pageObj.successMessage_anyBillAction_text(),
				"Bill submitted successfully");
	}
	
	@Test(priority=66)
	public void makeAClaim26() throws Exception{
		Expense_pageObj.selectBill(propetiesOverloadObj.getProperty("billnumber26"));
		Expense_pageObj.clickOnMakeAClaimButton();
		Expense_pageObj.makeAClaim(propetiesOverloadObj.getProperty("claimnamebill26"));
		softAssertObj.assertEquals(Expense_pageObj.successMessage_anyClaimAction_text(), "Claim is successfully submitted ");
	}
	
	@DataProvider(name = "telephonebill27")
	public String[][] getTelephoneBillDetails27() {
		String[][] telephoneBillDetails27 = getData("muExpenseTelephoneDollar50Validations.xlsx", "telephonebill27");
		return telephoneBillDetails27;
	}

	@Test(priority = 67,dataProvider = "telephonebill27")
	public void saveTelephoneBill27(String billname,String billnumber,String category,String subcategory,
			String DateFrom,String DateTo,String billamount,String folderName,String fileName,String eligibleAmount,
			String MonthYearDateFrom,String MonthYearDateTo) throws Exception{
		Expense_pageObj.clickOnaddBill();
		Expense_pageObj.enterTelephoneBillDetails(billname,billnumber,category,subcategory,DateFrom,DateTo,billamount,folderName,
				fileName,MonthYearDateFrom,MonthYearDateTo);
		Thread.sleep(3000);
		Expense_pageObj.clickSaveButtonWithValidation(eligibleAmount);
		softAssertObj.assertEquals(Expense_pageObj.successMessage_anyBillAction_text(),
				"Bill submitted successfully");
	}

	
	@DataProvider(name = "claim27details")
	public String[][] getclaim27details() {
		String[][] claim27details = getData("muExpenseTelephoneDollar50Validations.xlsx", "claim27details");
		return claim27details;
	}
	
	@Test(priority=68,dataProvider = "claim27details")
	public void makeAClaim27(String claimname,String empClaimDetails) throws Exception{
		Expense_pageObj.selectBill(propetiesOverloadObj.getProperty("billnumber27"));
		Expense_pageObj.clickOnMakeAClaimButton();
		Expense_pageObj.makeAClaimWithValidation(claimname,empClaimDetails);
		softAssertObj.assertEquals(Expense_pageObj.successMessage_anyClaimAction_text(), "Claim is successfully submitted ");
	}
	
	/*@DataProvider(name = "telephonebill28")
	public String[][] getTelephoneBillDetails28() {
		String[][] telephoneBillDetails28 = getData("muExpenseTelephoneDollar50Validations.xlsx", "telephonebill28");
		return telephoneBillDetails28;
	}
	
	@Test(priority = 69,dataProvider = "telephonebill28")
	public void saveTelephoneBill28(String billname,String billnumber,String category,String subcategory,
			String DateFrom,String DateTo,String billamount,String folderName,String fileName,
			String MonthYearDateFrom,String MonthYearDateTo) throws Exception{
		Expense_pageObj.clickOnaddBill();
		Expense_pageObj.enterTelephoneBillDetails(billname,billnumber,category,subcategory,DateFrom,DateTo,billamount,folderName,
				fileName,MonthYearDateFrom,MonthYearDateTo);
		Thread.sleep(3000);
		Expense_pageObj.clickSaveButton();
		softAssertObj.assertEquals(Expense_pageObj.successMessage_anyBillAction_text(),
				"Bill submitted successfully");
	}
	
	
	@DataProvider(name = "telephonebill29")
	public String[][] getTelephoneBillDetails29() {
		String[][] telephoneBillDetails29 = getData("muExpenseTelephoneDollar50Validations.xlsx", "telephonebill29");
		return telephoneBillDetails29;
	}
	
	@Test(priority = 70,dataProvider = "telephonebill29")
	public void saveTelephoneBill29(String billname,String billnumber,String category,String subcategory,
			String DateFrom,String DateTo,String billamount,String folderName,String fileName,
			String MonthYearDateFrom,String MonthYearDateTo) throws Exception{
		Expense_pageObj.clickOnaddBill();
		Expense_pageObj.enterTelephoneBillDetails(billname,billnumber,category,subcategory,DateFrom,DateTo,billamount,folderName,
				fileName,MonthYearDateFrom,MonthYearDateTo);
		Thread.sleep(3000);
		Expense_pageObj.clickSaveButton();
		softAssertObj.assertEquals(Expense_pageObj.successMessage_anyBillAction_text(),
				"Bill submitted successfully");
	}

	
	@DataProvider(name = "claim2829details")
	public String[][] getclaim2829details() {
		String[][] claim2829details = getData("muExpenseTelephoneDollar50Validations.xlsx", "claim2829details");
		return claim2829details;
	}
	
	@Test(priority=71,dataProvider = "claim2829details")
	public void makeAClaim2829(String claimname,String empClaimDetails) throws Exception{
		Expense_pageObj.selectBill(propetiesOverloadObj.getProperty("billnumber28"));
		Expense_pageObj.selectBill(propetiesOverloadObj.getProperty("billnumber29"));
		Expense_pageObj.clickOnMakeAClaimButton();
		Expense_pageObj.makeAClaimWithValidation(claimname,empClaimDetails);
		softAssertObj.assertEquals(Expense_pageObj.successMessage_anyClaimAction_text(), "Claim is successfully submitted ");
	}
	*/
	
	/*@DataProvider(name = "telephonebill30")
	public String[][] getTelephoneBillDetails30() {
		String[][] telephoneBillDetails30 = getData("muExpenseTelephoneDollar50Validations.xlsx", "telephonebill30");
		return telephoneBillDetails30;
	}
	
	@Test(priority = 72,dataProvider = "telephonebill30")
	public void saveTelephoneBill30(String billname,String billnumber,String category,String subcategory,
			String DateFrom,String DateTo,String billamount,String folderName,
			String fileName,String MonthYearDateFrom,String MonthYearDateTo) throws Exception{
		Expense_pageObj.clickOnaddBill();
		System.out.println("bill amount is "+billamount);
		Expense_pageObj.enterTelephoneBillDetails(billname,billnumber,category,subcategory,DateFrom,DateTo,billamount,folderName,fileName,MonthYearDateFrom,MonthYearDateTo);
		Thread.sleep(3000);
		Expense_pageObj.clickSaveButton();
		softAssertObj.assertEquals(Expense_pageObj.successMessage_anyBillAction_text(),
				"Bill submitted successfully");
	}
	
	
	@DataProvider(name = "telephonebill31")
	public String[][] getTelephoneBillDetails31() {
		String[][] telephoneBillDetails31 = getData("muExpenseTelephoneDollar50Validations.xlsx", "telephonebill31");
		return telephoneBillDetails31;
	}
	
	@Test(priority = 73,dataProvider = "telephonebill31")
	public void saveTelephoneBill31(String billname,String billnumber,String category,String subcategory,
			String DateFrom,String DateTo,String billamount,String folderName,
			String fileName,String MonthYearDateFrom,String MonthYearDateTo) throws Exception{
		Expense_pageObj.clickOnaddBill();
		System.out.println("bill amount is "+billamount);
		Expense_pageObj.enterTelephoneBillDetails(billname,billnumber,category,subcategory,DateFrom,DateTo,billamount,folderName,
				fileName,MonthYearDateFrom,MonthYearDateTo);
		Thread.sleep(3000);
		Expense_pageObj.clickSaveButton();
		softAssertObj.assertEquals(Expense_pageObj.successMessage_anyBillAction_text(),
				"Bill submitted successfully");
	}
	
	@DataProvider(name = "claim3031details")
	public String[][] getclaim3031details() {
		String[][] claim3031details = getData("muExpenseTelephoneDollar50Validations.xlsx", "claim3031details");
		return claim3031details;
	}
	
	@Test(priority=74,dataProvider = "claim3031details")
	public void makeAClaim3031(String claimname,String empClaimDetails) throws Exception{
		Expense_pageObj.selectBill(propetiesOverloadObj.getProperty("billnumber30"));
		Expense_pageObj.selectBill(propetiesOverloadObj.getProperty("billnumber31"));
		Expense_pageObj.clickOnMakeAClaimButton();
		Expense_pageObj.makeAClaimWithValidation(claimname,empClaimDetails);
		softAssertObj.assertEquals(Expense_pageObj.successMessage_anyClaimAction_text(), "Claim is successfully submitted ");
	}*/
	
	/*@Test(priority=75)
	public void impersonateEmployee_ApprenticeEngagementManager() throws Exception{
		Expense_pageObj.impersonate(propetiesOverloadObj.getProperty("Impersonate_Onsite_Employee_ApprenticeEngagementManager"));
		softAssertObj.assertTrue(Expense_pageObj.getDesignation_text().contains("Apprentice Engagement Manager"));
		
	}
	
	@DataProvider(name = "telephonebill32")
	public String[][] getTelephoneBillDetails32() {
		String[][] telephoneBillDetails32 = getData("muExpenseTelephoneDollar50Validations.xlsx", "telephonebill32");
		return telephoneBillDetails32;
	}
	
	@Test(priority = 76,dataProvider = "telephonebill32")
	public void checkValidationTelephoneBill32(String locationtype,String billname,String billnumber,String category,String subcategory,
			String DateFrom,String DateTo,String billamount,String folderName,
			String fileName,String MonthYearDateFrom,String MonthYearDateTo,String invalidemployee) throws Exception{
		Expense_pageObj.clickOnaddBill();
		Expense_pageObj.selectTaxEntity(locationtype);
		Expense_pageObj.enterTelephoneBillDetails(billname,billnumber,category,subcategory,DateFrom,DateTo,billamount,folderName,
				fileName,MonthYearDateFrom,MonthYearDateTo);
		Thread.sleep(3000);
		Expense_pageObj.clickSaveButton();
		Expense_pageObj.invalidEmployeeListPopUp(invalidemployee);
	}
	
	@Test(priority =77,dataProvider = "telephonebill32")
	public void saveTelephoneBill32(String locationtype,String billname,String billnumber,String category,String subcategory,
			String DateFrom,String DateTo,String billamount,String folderName,
			String fileName,String MonthYearDateFrom,String MonthYearDateTo,String invalidemployee) throws Exception{
		//Expense_pageObj.selectTaxEntity(propetiesOverloadObj.getProperty("locationtype4"));
		Expense_pageObj.clickOnaddBill();
		Expense_pageObj.selectTaxEntity(locationtype);
		Expense_pageObj.enterTelephoneBillDetails(billname,billnumber,category,subcategory,DateFrom,DateTo,billamount,folderName,
				fileName,MonthYearDateFrom,MonthYearDateTo);
		Thread.sleep(3000);
		Expense_pageObj.clickSaveButton();
		softAssertObj.assertEquals(Expense_pageObj.successMessage_anyBillAction_text(),
				"Bill submitted successfully");
	}
	
	@DataProvider(name = "telephonebill33")
	public String[][] getTelephoneBillDetails33() {
		String[][] telephoneBillDetails33 = getData("muExpenseTelephoneDollar50Validations.xlsx", "telephonebill33");
		return telephoneBillDetails33;
	}
	
	@Test(priority = 78,dataProvider = "telephonebill33")
	public void saveTelephoneBill33(String locationtype,String billname,String billnumber,String category,String subcategory,
			String DateFrom,String DateTo,String billamount,String folderName,
			String fileName,String MonthYearDateFrom,String MonthYearDateTo) throws Exception{
		Expense_pageObj.clickOnaddBill();
		Expense_pageObj.selectTaxEntity(locationtype);
		Expense_pageObj.enterTelephoneBillDetails(billname,billnumber,category,subcategory,DateFrom,DateTo,billamount,folderName,
				fileName,MonthYearDateFrom,MonthYearDateTo);
		Thread.sleep(3000);
		Expense_pageObj.clickSaveButton();
		softAssertObj.assertEquals(Expense_pageObj.successMessage_anyBillAction_text(),
				"Bill submitted successfully");
	}
	
	@Test(priority=79)
	public void checkValidationmakeAClaim32() throws Exception{
		Expense_pageObj.selectBill(propetiesOverloadObj.getProperty("billnumber32"));
		Expense_pageObj.selectBill(propetiesOverloadObj.getProperty("billnumber33"));
		Expense_pageObj.clickOnMakeAClaimButton();
		Expense_pageObj.makeAClaim(propetiesOverloadObj.getProperty("claimnamebill3233"));
		Expense_pageObj.clickOKbutton();
	}
	
	@Test(priority=80)
	public void makeAClaim32() throws Exception{
		Expense_pageObj.selectBill(propetiesOverloadObj.getProperty("billnumber33"));
		Expense_pageObj.clickOnMakeAClaimButton();
		Expense_pageObj.makeAClaim(propetiesOverloadObj.getProperty("claimnamebill32"));
		softAssertObj.assertEquals(Expense_pageObj.successMessage_anyClaimAction_text(), "Claim is successfully submitted ");
	}
	
	@Test(priority=81)
	public void makeAClaim33() throws Exception{
		Expense_pageObj.selectBill(propetiesOverloadObj.getProperty("billnumber33"));
		Expense_pageObj.clickOnMakeAClaimButton();
		Expense_pageObj.makeAClaim(propetiesOverloadObj.getProperty("claimnamebill33"));
		softAssertObj.assertEquals(Expense_pageObj.successMessage_anyClaimAction_text(), "Claim is successfully submitted ");
	}
	
	@Test(priority=82)
	public void impersonate_Employee_ApprenticeEngagementManager() throws Exception{
		Expense_pageObj.impersonate(propetiesOverloadObj.getProperty("Onsite_Employee_ApprenticeEngagementManager"));
		softAssertObj.assertTrue(Expense_pageObj.getDesignation_text().contains("Apprentice Engagement Manager"));	
	}*/
	
	@DataProvider(name = "telephonebill34")
	public String[][] getTelephoneBillDetails34() {
		String[][] telephoneBillDetails34 = getData("muExpenseTelephoneDollar50Validations.xlsx", "telephonebill34");
		return telephoneBillDetails34;
	}
	
	@Test(priority=83,dataProvider = "telephonebill34")
	public void checkValidationTelephoneBill34(String billname,String billnumber,String category,String subcategory,
				String DateFrom,String DateTo,String billamount,String folderName,
				String fileName,String MonthYearDateFrom,String MonthYearDateTo,String radiobuttonOption,String addmemberName) throws Exception{
		Expense_pageObj.clickOnaddBill();
		Expense_pageObj.enterTelephoneBillDetails(billname,billnumber,category,subcategory,DateFrom,DateTo,billamount,folderName,
					fileName,MonthYearDateFrom,MonthYearDateTo);
		Expense_pageObj.selectRadiobutton(radiobuttonOption);
		Expense_pageObj.addMember(addmemberName);
		Thread.sleep(3000);
		softAssertObj.assertEquals(Expense_pageObj.errorMessage_oneEmployee_text(),"Only one employee can be selected");
	}
	
	@Test(priority=84)
	public void saveTelephoneBill34() throws Exception{
		Expense_pageObj.removeMember(propetiesOverloadObj.getProperty("removeEmployeeName4"));
		Expense_pageObj.addMember(propetiesOverloadObj.getProperty("addEmployeeName4"));
		Expense_pageObj.clickSaveButton();
		softAssertObj.assertEquals(Expense_pageObj.successMessage_anyBillAction_text(),
				"Bill submitted successfully");
	}
	
	@Test(priority=85)
	public void makeAClaim34() throws Exception{
		Expense_pageObj.selectBill(propetiesOverloadObj.getProperty("billnumber34"));
		Expense_pageObj.clickOnMakeAClaimButton();
		Expense_pageObj.makeAClaim(propetiesOverloadObj.getProperty("claimnamebill34"));
		softAssertObj.assertEquals(Expense_pageObj.successMessage_anyClaimAction_text(), "Claim is successfully submitted ");
	}
	
	@Test(priority=86)
	public void impersonateHRGeneralist() throws Exception{
		Expense_pageObj.impersonate(propetiesOverloadObj.getProperty("Onsite_Employee_HRGeneralist"));
		softAssertObj.assertTrue(Expense_pageObj.getDesignation_text().contains("HR Generalist"));
		
	}
	
	@DataProvider(name = "telephonebill35")
	public String[][] getTelephoneBillDetails35() {
		String[][] telephoneBillDetails35 = getData("muExpenseTelephoneDollar50Validations.xlsx", "telephonebill35");
		return telephoneBillDetails35;
	}
	
	@Test(priority = 87,dataProvider = "telephonebill35")
	public void saveTelephoneBill35(String billname,String billnumber,String category,String subcategory,
			String DateFrom,String DateTo,String billamount,String folderName,String fileName,
			String eligibleAmount,String MonthYearDateFrom,String MonthYearDateTo) throws Exception{
		Expense_pageObj.clickOnaddBill();
		Expense_pageObj.enterTelephoneBillDetails(billname,billnumber,category,subcategory,DateFrom,DateTo,billamount,folderName,fileName,
				MonthYearDateFrom,MonthYearDateTo);
		Thread.sleep(3000);
		Expense_pageObj.clickSaveButtonWithValidation(eligibleAmount);
		softAssertObj.assertEquals(Expense_pageObj.successMessage_anyBillAction_text(),
				"Bill submitted successfully");
	}
	
	@DataProvider(name = "claim35details")
	public String[][] getclaim35details() {
		String[][] claim35details = getData("muExpenseTelephoneDollar50Validations.xlsx", "claim35details");
		return claim35details;
	}
	
	@Test(priority=88,dataProvider = "claim35details")
	public void makeAClaim35(String claimname,String empClaimDetails) throws Exception{
		Expense_pageObj.selectBill(propetiesOverloadObj.getProperty("billnumber35"));
		Expense_pageObj.clickOnMakeAClaimButton();
		Expense_pageObj.makeAClaimWithValidation(claimname,empClaimDetails);
		softAssertObj.assertEquals(Expense_pageObj.successMessage_anyClaimAction_text(), "Claim is successfully submitted ");
	}	
	
	@DataProvider(name = "telephonebill36")
	public String[][] getTelephoneBillDetails36() {
		String[][] telephoneBillDetails36 = getData("muExpenseTelephoneDollar50Validations.xlsx", "telephonebill36");
		return telephoneBillDetails36;
	}
	
	@Test(priority = 89,dataProvider = "telephonebill36")
	public void saveTelephoneBill36(String billname,String billnumber,String category,String subcategory,
			String DateFrom,String DateTo,String billamount,String folderName,String fileName,
			String MonthYearDateFrom,String MonthYearDateTo) throws Exception{
		Expense_pageObj.clickOnaddBill();
		Expense_pageObj.enterTelephoneBillDetails(billname,billnumber,category,subcategory,DateFrom,DateTo,billamount,folderName,
				fileName,MonthYearDateFrom,MonthYearDateTo);
		Thread.sleep(3000);
		Expense_pageObj.clickSaveButton();
		softAssertObj.assertEquals(Expense_pageObj.successMessage_anyBillAction_text(),
				"Bill submitted successfully");
	}
	
	
	@DataProvider(name = "telephonebill37")
	public String[][] getTelephoneBillDetails37() {
		String[][] telephoneBillDetails37 = getData("muExpenseTelephoneDollar50Validations.xlsx", "telephonebill37");
		return telephoneBillDetails37;
	}
	
	@Test(priority = 90,dataProvider = "telephonebill37")
	public void saveTelephoneBill37(String billname,String billnumber,String category,String subcategory,
			String DateFrom,String DateTo,String billamount,String folderName,String fileName,
			String MonthYearDateFrom,String MonthYearDateTo) throws Exception{
		Expense_pageObj.clickOnaddBill();
		Expense_pageObj.enterTelephoneBillDetails(billname,billnumber,category,subcategory,DateFrom,DateTo,billamount,folderName,
				fileName,MonthYearDateFrom,MonthYearDateTo);
		Thread.sleep(3000);
		Expense_pageObj.clickSaveButton();
		softAssertObj.assertEquals(Expense_pageObj.successMessage_anyBillAction_text(),
				"Bill submitted successfully");
	}

	
	@DataProvider(name = "claim3637details")
	public String[][] getclaim3637details() {
		String[][] claim3637details = getData("muExpenseTelephoneDollar50Validations.xlsx", "claim3637details");
		return claim3637details;
	}
	
	@Test(priority=91,dataProvider = "claim3637details")
	public void makeAClaim3637(String claimname,String empClaimDetails) throws Exception{
		Expense_pageObj.selectBill(propetiesOverloadObj.getProperty("billnumber36"));
		Expense_pageObj.selectBill(propetiesOverloadObj.getProperty("billnumber37"));
		Expense_pageObj.clickOnMakeAClaimButton();
		Expense_pageObj.makeAClaimWithValidation(claimname,empClaimDetails);
		softAssertObj.assertEquals(Expense_pageObj.successMessage_anyClaimAction_text(), "Claim is successfully submitted ");
	}
	
	
	@DataProvider(name = "telephonebill38")
	public String[][] getTelephoneBillDetails38() {
		String[][] telephoneBillDetails38 = getData("muExpenseTelephoneDollar50Validations.xlsx", "telephonebill38");
		return telephoneBillDetails38;
	}
	
	@Test(priority = 92,dataProvider = "telephonebill38")
	public void saveTelephoneBill38(String billname,String billnumber,String category,String subcategory,
			String DateFrom,String DateTo,String billamount,String folderName,
			String fileName,String MonthYearDateFrom,String MonthYearDateTo) throws Exception{
		Expense_pageObj.clickOnaddBill();
		System.out.println("bill amount is "+billamount);
		Expense_pageObj.enterTelephoneBillDetails(billname,billnumber,category,subcategory,DateFrom,DateTo,billamount,folderName,fileName,MonthYearDateFrom,MonthYearDateTo);
		Thread.sleep(3000);
		Expense_pageObj.clickSaveButton();
		softAssertObj.assertEquals(Expense_pageObj.successMessage_anyBillAction_text(),
				"Bill submitted successfully");
	}
	
	
	@DataProvider(name = "telephonebill39")
	public String[][] getTelephoneBillDetails39() {
		String[][] telephoneBillDetails39 = getData("muExpenseTelephoneDollar50Validations.xlsx", "telephonebill39");
		return telephoneBillDetails39;
	}
	
	@Test(priority = 93,dataProvider = "telephonebill39")
	public void saveTelephoneBill39(String billname,String billnumber,String category,String subcategory,
			String DateFrom,String DateTo,String billamount,String folderName,
			String fileName,String MonthYearDateFrom,String MonthYearDateTo) throws Exception{
		Expense_pageObj.clickOnaddBill();
		System.out.println("bill amount is "+billamount);
		Expense_pageObj.enterTelephoneBillDetails(billname,billnumber,category,subcategory,DateFrom,DateTo,billamount,folderName,
				fileName,MonthYearDateFrom,MonthYearDateTo);
		Thread.sleep(3000);
		Expense_pageObj.clickSaveButton();
		softAssertObj.assertEquals(Expense_pageObj.successMessage_anyBillAction_text(),
				"Bill submitted successfully");
	}
	
	@DataProvider(name = "claim3839details")
	public String[][] getclaim3839details() {
		String[][] claim3839details = getData("muExpenseTelephoneDollar50Validations.xlsx", "claim3839details");
		return claim3839details;
	}
	
	@Test(priority=94,dataProvider = "claim3839details")
	public void makeAClaim3839(String claimname,String empClaimDetails) throws Exception{
		Expense_pageObj.selectBill(propetiesOverloadObj.getProperty("billnumber38"));
		Expense_pageObj.selectBill(propetiesOverloadObj.getProperty("billnumber39"));
		Expense_pageObj.clickOnMakeAClaimButton();
		Expense_pageObj.makeAClaimWithValidation(claimname,empClaimDetails);
		softAssertObj.assertEquals(Expense_pageObj.successMessage_anyClaimAction_text(), "Claim is successfully submitted ");
	}
	
	/*@Test(priority=95)
	public void impersonateEmployee_HRGeneralist() throws Exception{
		Expense_pageObj.impersonate(propetiesOverloadObj.getProperty("Impersonate_Onsite_Employee_HRGeneralist"));
		softAssertObj.assertTrue(Expense_pageObj.getDesignation_text().contains("HR Generalist"));
		
	}
	
	@DataProvider(name = "telephonebill40")
	public String[][] getTelephoneBillDetails40() {
		String[][] telephoneBillDetails40 = getData("muExpenseTelephoneDollar50Validations.xlsx", "telephonebill40");
		return telephoneBillDetails40;
	}
	
	@Test(priority = 96,dataProvider = "telephonebill40")
	public void checkValidationTelephoneBill40(String locationtype,String billname,String billnumber,String category,String subcategory,
			String DateFrom,String DateTo,String billamount,String folderName,
			String fileName,String MonthYearDateFrom,String MonthYearDateTo,String invalidemployee) throws Exception{
		Expense_pageObj.clickOnaddBill();
		Expense_pageObj.selectTaxEntity(locationtype);
		Expense_pageObj.enterTelephoneBillDetails(billname,billnumber,category,subcategory,DateFrom,DateTo,billamount,folderName,
				fileName,MonthYearDateFrom,MonthYearDateTo);
		Thread.sleep(3000);
		Expense_pageObj.clickSaveButton();
		Expense_pageObj.invalidEmployeeListPopUp(invalidemployee);
	}
	
	@Test(priority =97,dataProvider = "telephonebill40")
	public void saveTelephoneBill40(String locationtype,String billname,String billnumber,String category,String subcategory,
			String DateFrom,String DateTo,String billamount,String folderName,
			String fileName,String MonthYearDateFrom,String MonthYearDateTo,String invalidemployee) throws Exception{
		//Expense_pageObj.selectTaxEntity(propetiesOverloadObj.getProperty("locationtype5"));
		Expense_pageObj.clickOnaddBill();
		Expense_pageObj.selectTaxEntity(locationtype);
		Expense_pageObj.enterTelephoneBillDetails(billname,billnumber,category,subcategory,DateFrom,DateTo,billamount,folderName,
				fileName,MonthYearDateFrom,MonthYearDateTo);
		Thread.sleep(3000);
		Expense_pageObj.clickSaveButton();
		softAssertObj.assertEquals(Expense_pageObj.successMessage_anyBillAction_text(),
				"Bill submitted successfully");
	}
	
	@DataProvider(name = "telephonebill41")
	public String[][] getTelephoneBillDetails41() {
		String[][] telephoneBillDetails41 = getData("muExpenseTelephoneDollar50Validations.xlsx", "telephonebill41");
		return telephoneBillDetails41;
	}
	
	@Test(priority = 98,dataProvider = "telephonebill41")
	public void saveTelephoneBill41(String locationtype,String billname,String billnumber,String category,String subcategory,
			String DateFrom,String DateTo,String billamount,String folderName,
			String fileName,String MonthYearDateFrom,String MonthYearDateTo) throws Exception{
		Expense_pageObj.clickOnaddBill();
		Expense_pageObj.selectTaxEntity(locationtype);
		Expense_pageObj.enterTelephoneBillDetails(billname,billnumber,category,subcategory,DateFrom,DateTo,billamount,folderName,
				fileName,MonthYearDateFrom,MonthYearDateTo);
		Thread.sleep(3000);
		Expense_pageObj.clickSaveButton();
		softAssertObj.assertEquals(Expense_pageObj.successMessage_anyBillAction_text(),
				"Bill submitted successfully");
	}
	
	@Test(priority=99)
	public void checkValidationmakeAClaim40() throws Exception{
		Expense_pageObj.selectBill(propetiesOverloadObj.getProperty("billnumber40"));
		Expense_pageObj.selectBill(propetiesOverloadObj.getProperty("billnumber41"));
		Expense_pageObj.clickOnMakeAClaimButton();
		Expense_pageObj.makeAClaim(propetiesOverloadObj.getProperty("claimnamebill4041"));
		Expense_pageObj.clickOKbutton();
	}
	
	@Test(priority=100)
	public void makeAClaim40() throws Exception{
		Expense_pageObj.selectBill(propetiesOverloadObj.getProperty("billnumber41"));
		Expense_pageObj.clickOnMakeAClaimButton();
		Expense_pageObj.makeAClaim(propetiesOverloadObj.getProperty("claimnamebill40"));
		softAssertObj.assertEquals(Expense_pageObj.successMessage_anyClaimAction_text(), "Claim is successfully submitted ");
	}
	
	@Test(priority=101)
	public void makeAClaim41() throws Exception{
		Expense_pageObj.selectBill(propetiesOverloadObj.getProperty("billnumber41"));
		Expense_pageObj.clickOnMakeAClaimButton();
		Expense_pageObj.makeAClaim(propetiesOverloadObj.getProperty("claimnamebill41"));
		softAssertObj.assertEquals(Expense_pageObj.successMessage_anyClaimAction_text(), "Claim is successfully submitted ");
	}
	
	@Test(priority=102)
	public void impersonate_Employee_HRGeneralist() throws Exception{
		Expense_pageObj.impersonate(propetiesOverloadObj.getProperty("Onsite_Employee_HRGeneralist"));
		softAssertObj.assertTrue(Expense_pageObj.getDesignation_text().contains("HR Generalist"));	
	}
	*/
	@DataProvider(name = "telephonebill42")
	public String[][] getTelephoneBillDetails42() {
		String[][] telephoneBillDetails42 = getData("muExpenseTelephoneDollar50Validations.xlsx", "telephonebill42");
		return telephoneBillDetails42;
	}
	
	@Test(priority=103,dataProvider = "telephonebill42")
	public void checkValidationTelephoneBill42(String billname,String billnumber,String category,String subcategory,
				String DateFrom,String DateTo,String billamount,String folderName,
				String fileName,String MonthYearDateFrom,String MonthYearDateTo,String radiobuttonOption,String addmemberName) throws Exception{
		Expense_pageObj.clickOnaddBill();
		Expense_pageObj.enterTelephoneBillDetails(billname,billnumber,category,subcategory,DateFrom,DateTo,billamount,folderName,
					fileName,MonthYearDateFrom,MonthYearDateTo);
		Expense_pageObj.selectRadiobutton(radiobuttonOption);
		Expense_pageObj.addMember(addmemberName);
		Thread.sleep(3000);
		softAssertObj.assertEquals(Expense_pageObj.errorMessage_oneEmployee_text(),"Only one employee can be selected");
	}
	
	@Test(priority=104)
	public void saveTelephoneBill42() throws Exception{
		Expense_pageObj.removeMember(propetiesOverloadObj.getProperty("removeEmployeeName5"));
		Expense_pageObj.addMember(propetiesOverloadObj.getProperty("addEmployeeName5"));
		Expense_pageObj.clickSaveButton();
		softAssertObj.assertEquals(Expense_pageObj.successMessage_anyBillAction_text(),
				"Bill submitted successfully");
	}
	
	@Test(priority=105)
	public void makeAClaim42() throws Exception{
		Expense_pageObj.selectBill(propetiesOverloadObj.getProperty("billnumber42"));
		Expense_pageObj.clickOnMakeAClaimButton();
		Expense_pageObj.makeAClaim(propetiesOverloadObj.getProperty("claimnamebill42"));
		softAssertObj.assertEquals(Expense_pageObj.successMessage_anyClaimAction_text(), "Claim is successfully submitted ");
	}

}
