package com.mu_sigma.OrgPlatformAutomationFramework.TransferManagement.test;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;
import com.mu_sigma.OrgPlatformAutomationFramework.transferManagement.page.TransferManagement_page;

public class TransferManagement_rejectRequests_differentLevels_test extends TestBase {
	TransferManagement_page TransferManagement_pageObj;
	SoftAssert softAssertObj = new SoftAssert();
	
	@BeforeClass
	public void setUp() throws Exception {
		init("transferManagement_OwnServer");
		TransferManagement_pageObj = new TransferManagement_page(driver);
		loadProperties("transferManagement.properties");
	}
	
	@DataProvider(name = "validloginTestdata")
	public String[][] getvalidLogInData() {
		String[][] loginData = getData("transferManagement.xlsx", "validlogin");
		return loginData;
	}

	@Test(priority = 1, dataProvider = "validloginTestdata")
	public void loginTransferManagement(String username, String password, String runMode) {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("User marked this Record as No Run");
		}
		TransferManagement_pageObj.fillLoginDetails(username, password);
	}
	
	@Test(priority =2 )
	public void impersonateCurrentManager(){
		TransferManagement_pageObj.impersonateEmployee(propetiesOverloadObj.getProperty("currentManager"));
		softAssertObj.assertTrue(TransferManagement_pageObj.getDesignation_text().contains("Apprentice"));
	}
	
	@DataProvider(name = "specificrequestDetails1")
	public String[][] requestDetails1(){
		String[][] getData = getData("transferManagement.xlsx", "transferrequestdetails1");
		return getData;
	}
	
	@Test(priority = 3,dataProvider="specificrequestDetails1")
	public void selectSpecificRequestCurrentManagerLevel(String empID,String joiningDate) throws Exception{	
		TransferManagement_pageObj.employeeSearch(empID);
		TransferManagement_pageObj.clickselectSpecificRequest(joiningDate);
		softAssertObj.assertTrue(TransferManagement_pageObj.getPendingApprovalFrom_text().contains("Pending Current Manager Approval"));
	}
	
	@DataProvider(name = "rejecttransferrequest")
	public String[][] rejectrequestbyCurrentManager() {
		String[][] rejectcompletedData = getData("transferManagement.xlsx", "rejectrequestdetails");
		return rejectcompletedData;
	}
	
	@Test(priority = 4,dataProvider="rejecttransferrequest")
	public void rejectTransferRequestAtCurentManagerLevel(String buttonName,String commentValue,String confirmationButton) throws Exception{
		TransferManagement_pageObj.rejectTransferRequest(buttonName, commentValue, confirmationButton);
		softAssertObj.assertEquals(TransferManagement_pageObj.successMessage_anyAction_text(),"Transfer request has been updated successfully");
	}
	
	@DataProvider(name = "specificrequestDetails2")
	public String[][] requestDetails2(){
		String[][] getData = getData("transferManagement.xlsx", "transferrequestdetails2");
		return getData;
	}
	
	@Test(priority = 5,dataProvider="specificrequestDetails2")
	public void selectSpecificRequest1(String empID,String joiningDate) throws Exception{	
		TransferManagement_pageObj.clearSearchBox();
		TransferManagement_pageObj.employeeSearch(empID);
		TransferManagement_pageObj.clickselectSpecificRequest(joiningDate);
		softAssertObj.assertTrue(TransferManagement_pageObj.getPendingApprovalFrom_text().contains("Pending Current Manager Approval"));
	}
	
	@DataProvider(name = "approverequest")
	public String[][] approverequest1() {
		String[][] approveData = getData("transferManagement.xlsx", "approverequestdetails");
		return approveData;
	}
	
	@Test(priority = 6,dataProvider="approverequest")
	public void approveTransferRequest1(String buttonName,String confirmationButton) throws Exception{
		TransferManagement_pageObj.approveTransferRequest(buttonName, confirmationButton);
		softAssertObj.assertEquals(TransferManagement_pageObj.successMessage_anyAction_text(),"Transfer request has been updated successfully");
	}
	
	@DataProvider(name = "specificrequestDetails3")
	public String[][] requestDetails3(){
		String[][] getData = getData("transferManagement.xlsx", "transferrequestdetails3");
		return getData;
	}
	
	@Test(priority = 7,dataProvider="specificrequestDetails3")
	public void selectSpecificRequest2(String empID,String joiningDate) throws Exception{
		TransferManagement_pageObj.clearSearchBox();
		TransferManagement_pageObj.employeeSearch(empID);
		TransferManagement_pageObj.clickselectSpecificRequest(joiningDate);
		softAssertObj.assertTrue(TransferManagement_pageObj.getPendingApprovalFrom_text().contains("Pending Current Manager Approval"));
	}
	
	
	@Test(priority = 8,dataProvider="approverequest")
	public void approveTransferRequest2(String buttonName,String confirmationButton) throws Exception{
		TransferManagement_pageObj.approveTransferRequest(buttonName, confirmationButton);
		softAssertObj.assertEquals(TransferManagement_pageObj.successMessage_anyAction_text(),"Transfer request has been updated successfully");
	}
	
	@DataProvider(name = "specificrequestDetails4")
	public String[][] requestDetails4(){
		String[][] getData = getData("transferManagement.xlsx", "transferrequestdetails4");
		return getData;
	}
	
	@Test(priority = 9,dataProvider="specificrequestDetails4")
	public void selectSpecificRequest3(String empID,String joiningDate) throws Exception{	
		TransferManagement_pageObj.clearSearchBox();
		TransferManagement_pageObj.employeeSearch(empID);
		TransferManagement_pageObj.clickselectSpecificRequest(joiningDate);
		softAssertObj.assertTrue(TransferManagement_pageObj.getPendingApprovalFrom_text().contains("Pending Current Manager Approval"));
	}
	
	
	@Test(priority = 10,dataProvider="approverequest")
	public void approveTransferRequest3(String buttonName,String confirmationButton) throws Exception{
		TransferManagement_pageObj.approveTransferRequest(buttonName, confirmationButton);
		softAssertObj.assertEquals(TransferManagement_pageObj.successMessage_anyAction_text(),"Transfer request has been updated successfully");
	}
	
	@Test(priority =11 )
	public void impersonateNewManager(){
		TransferManagement_pageObj.impersonate(propetiesOverloadObj.getProperty("newManager"));
		softAssertObj.assertTrue(TransferManagement_pageObj.getDesignation_text().contains("Apprentice"));
	}
	
	
	@Test(priority = 12,dataProvider="specificrequestDetails2")
	public void selectSpecificRequestNewManagerLevel(String empID,String joiningDate) throws Exception{
		TransferManagement_pageObj.employeeSearch(empID);
		TransferManagement_pageObj.clickselectSpecificRequest(joiningDate);
		softAssertObj.assertTrue(TransferManagement_pageObj.getPendingApprovalFrom_text().contains("Pending Current Manager Approval"));
	}
	
	@Test(priority = 13,dataProvider="rejecttransferrequest")
	public void rejectTransferRequestAtNewManagerLevel(String buttonName,String commentValue,String confirmationButton) throws Exception{
		TransferManagement_pageObj.rejectTransferRequest(buttonName, commentValue, confirmationButton);
		softAssertObj.assertEquals(TransferManagement_pageObj.successMessage_anyAction_text(),"Transfer request has been updated successfully");
	}
	
	
	@Test(priority = 14,dataProvider="specificrequestDetails3")
	public void selectSpecificRequest6(String empID,String joiningDate) throws Exception{
		TransferManagement_pageObj.clearSearchBox();
		TransferManagement_pageObj.employeeSearch(empID);
		TransferManagement_pageObj.clickselectSpecificRequest(joiningDate);
		softAssertObj.assertTrue(TransferManagement_pageObj.getPendingApprovalFrom_text().contains("Pending Current Manager Approval"));
	}
	
	
	@Test(priority = 15,dataProvider="approverequest")
	public void approveTransferRequest4(String buttonName,String confirmationButton) throws Exception{
		TransferManagement_pageObj.approveTransferRequest(buttonName, confirmationButton);
		softAssertObj.assertEquals(TransferManagement_pageObj.successMessage_anyAction_text(),"Transfer request has been updated successfully");
	}

	@Test(priority = 16,dataProvider="specificrequestDetails4")
	public void selectSpecificRequest7(String empID,String joiningDate) throws Exception{	
		TransferManagement_pageObj.clearSearchBox();
		TransferManagement_pageObj.employeeSearch(empID);
		TransferManagement_pageObj.clickselectSpecificRequest(joiningDate);
		softAssertObj.assertTrue(TransferManagement_pageObj.getPendingApprovalFrom_text().contains("Pending Current Manager Approval"));
	}
	
	
	@Test(priority = 17,dataProvider="approverequest")
	public void approveTransferRequest5(String buttonName,String confirmationButton) throws Exception{
		TransferManagement_pageObj.approveTransferRequest(buttonName, confirmationButton);
		softAssertObj.assertEquals(TransferManagement_pageObj.successMessage_anyAction_text(),"Transfer request has been updated successfully");
	}
	
	@Test(priority =18)
	public void impersonateImmigration(){
		TransferManagement_pageObj.impersonate(propetiesOverloadObj.getProperty("immigration"));
		softAssertObj.assertTrue(TransferManagement_pageObj.getDesignation_text().contains("Executive"));
	}
	
	
	@Test(priority = 19,dataProvider="specificrequestDetails3")
	public void selectSpecificRequestImmigrationLevel(String empID,String joiningDate) throws Exception{	
		TransferManagement_pageObj.employeeSearch(empID);
		TransferManagement_pageObj.clickselectSpecificRequest(joiningDate);
		softAssertObj.assertTrue(TransferManagement_pageObj.getPendingApprovalFrom_text().contains("Pending Current Manager Approval"));
	}
	
	
	@Test(priority = 20,dataProvider="rejecttransferrequest")
	public void rejectTransferRequestAtImmigrationLevel(String buttonName,String commentValue,String confirmationButton) throws Exception{
		TransferManagement_pageObj.rejectTransferRequest(buttonName, commentValue, confirmationButton);
		softAssertObj.assertEquals(TransferManagement_pageObj.successMessage_anyAction_text(),"Transfer request has been updated successfully");
	}
	
		
	@Test(priority = 21,dataProvider="specificrequestDetails4")
	public void selectSpecificRequest9(String empID,String joiningDate) throws Exception{	
		TransferManagement_pageObj.clearSearchBox();
		TransferManagement_pageObj.employeeSearch(empID);
		TransferManagement_pageObj.clickselectSpecificRequest(joiningDate);
		softAssertObj.assertTrue(TransferManagement_pageObj.getPendingApprovalFrom_text().contains("Pending Current Manager Approval"));
	}
	
	@Test(priority = 22,dataProvider="approverequest")
	public void approveTransferRequest6(String buttonName,String confirmationButton) throws Exception{
		TransferManagement_pageObj.approveTransferRequest(buttonName, confirmationButton);
		softAssertObj.assertEquals(TransferManagement_pageObj.successMessage_anyAction_text(),"Transfer request has been updated successfully");
	}
	
	@Test(priority = 23)
	public void clickOnNewTransferRequest() throws Exception{
		TransferManagement_pageObj.clickOnNewRequest();
		Thread.sleep(1000);
		softAssertObj.assertEquals(TransferManagement_pageObj.newrequest_header_text(), "New Request");
	}
	
	@DataProvider(name = "inputsToraisenewRequest")
	public String[][] getinputs() {
		String[][] inputData = getData("transferManagement.xlsx", "transferrequestdetails5");
		return inputData;
	}

	@Test(priority = 24,dataProvider = "inputsToraisenewRequest")
	public void inputsToraisenewTransferRequest(String lastDate, String joiningDate, String currentAddress, String newAddress,
			String currentCountryName, String currentStateName, String currentCityName, String newCountryName,
			String newStateName, String newCityName, String VisaName) throws Exception {
		TransferManagement_pageObj.selectLastDate(lastDate);
		TransferManagement_pageObj.selectJoiningDate(joiningDate);
		TransferManagement_pageObj.getCurrentAddress(currentAddress);
		TransferManagement_pageObj.getNewAddress(newAddress);
		TransferManagement_pageObj.selectCurrentCountry();
		TransferManagement_pageObj.selectValueFromAnyDropdown(currentCountryName);
		TransferManagement_pageObj.selectCurrentState();
		TransferManagement_pageObj.selectValueFromAnyDropdown(currentStateName);
		TransferManagement_pageObj.selectCurrentCity();
		TransferManagement_pageObj.selectValueFromAnyDropdown(currentCityName);
		TransferManagement_pageObj.selectNewCountry();
		TransferManagement_pageObj.selectValueFromAnyDropdown(newCountryName);
		TransferManagement_pageObj.selectNewState();
		TransferManagement_pageObj.selectValueFromAnyDropdown(newStateName);
		TransferManagement_pageObj.selectNewCity();
		TransferManagement_pageObj.selectValueFromAnyDropdown(newCityName);
		TransferManagement_pageObj.selectVisaType();
		TransferManagement_pageObj.selectValueFromAnyDropdown(VisaName);
		TransferManagement_pageObj.clickSubmitBtn();
	}
	
	@DataProvider(name = "withdrawrequest")
	public String[][] withdrawrequest () {
		String[][] withdrawinputData = getData("transferManagement.xlsx", "withdrawrequestdetails");
		return withdrawinputData;
	}
	
	@Test(priority = 25,dataProvider="withdrawrequest")
	public void withdrawTransferRequest(String buttonName,String commentValue,String confirmationButton) throws InterruptedException{
		TransferManagement_pageObj.withdrawTransferRequest(buttonName,commentValue,confirmationButton);
		softAssertObj.assertEquals(TransferManagement_pageObj.successMessage_anyAction_text(),"Transfer request has been updated successfully");
	}
	
	@Test(priority =26)
	public void impersonateChecklist(){
		TransferManagement_pageObj.impersonate(propetiesOverloadObj.getProperty("checklist"));
		softAssertObj.assertTrue(TransferManagement_pageObj.getDesignation_text().contains("Executive"));
	}
	
	@Test(priority = 27,dataProvider="specificrequestDetails4")
	public void selectSpecificRequestChecklistLevel(String empID,String joiningDate) throws Exception{	
		TransferManagement_pageObj.employeeSearch(empID);
		TransferManagement_pageObj.clickselectSpecificRequest(joiningDate);
		softAssertObj.assertTrue(TransferManagement_pageObj.getPendingApprovalFrom_text().contains("Pending Current Manager Approval"));
	}
	
	@DataProvider(name = "checklistDetails")
	public String[][] getchecklistDetails(){
		String[][] getchecklistData = getData("transferManagement.xlsx", "checklistdetails");
		return getchecklistData;
	}
	
	@Test(priority = 28 ,dataProvider="checklistDetails")
	public void checklistApproval(String checklistName,String buttonName,String indexvalue,String iteminput,String commentsinput) throws Exception{
		TransferManagement_pageObj.clickOnChecklist(checklistName, buttonName,indexvalue,iteminput,commentsinput);
		Thread.sleep(2000);
		softAssertObj.assertEquals(TransferManagement_pageObj.successMessage_individualChecklistMarkedComplete_text(), "Checklist has been marked as complete");
	}
	
	@Test(priority = 29)
	public void impersonateHR(){
		TransferManagement_pageObj.impersonate(propetiesOverloadObj.getProperty("HR"));
		softAssertObj.assertTrue(TransferManagement_pageObj.getDesignation_text().contains("Decision Scientist"));
	}	
	
	@Test(priority = 30,dataProvider="specificrequestDetails4")
	public void selectSpecificRequestHRLevel(String empID,String joiningDate) throws Exception{	
		TransferManagement_pageObj.employeeSearch(empID);
		TransferManagement_pageObj.clickselectSpecificRequest(joiningDate);
		softAssertObj.assertTrue(TransferManagement_pageObj.getPendingApprovalFrom_text().contains("Pending Current Manager Approval"));
	}
	
	@Test(priority = 31,dataProvider="rejecttransferrequest")
	public void rejectTransferRequestAtHRLevel(String buttonName,String commentValue,String confirmationButton) throws Exception{
		TransferManagement_pageObj.rejectTransferRequest(buttonName, commentValue, confirmationButton);
		softAssertObj.assertEquals(TransferManagement_pageObj.successMessage_anyAction_text(),"Transfer request has been updated successfully");
		TransferManagement_pageObj.clearSearchBox();
	}
	
	@Test(priority = 32)
	public void selectFilters() throws InterruptedException{
		TransferManagement_pageObj.selectFilter();
	}

	@DataProvider(name = "withdrawrequestDetailsPendingApproval")
	public String[][] getwithdrawRequestDetails(){
		String[][] getwithdrawdetails = getData("transferManagement.xlsx", "withdrawrejectiondetails");
		return getwithdrawdetails;
	}
	
	
	@Test(priority = 33,dataProvider="withdrawrequestDetailsPendingApproval")
	public void selectWithdrawRequest(String empID,String joiningDate) throws Exception{
		TransferManagement_pageObj.employeeSearch(empID);
		TransferManagement_pageObj.clickselectSpecificRequest(joiningDate);
		softAssertObj.assertTrue(TransferManagement_pageObj.getPendingApprovalFrom_text().contains("Withdrawn Request"));
	}
	
	@DataProvider(name = "rejectwithdrawrequest")
	public String[][] rejectwithdrawequest() {
		String[][] rejectwithdrawData = getData("transferManagement.xlsx", "rejectwithdrawrequestdetails");
		return rejectwithdrawData;
	}
	
	@Test(priority = 34,dataProvider="rejectwithdrawrequest")
	public void rejectWithdrawTransferRequest(String buttonName,String commentValue,String confirmationButton) throws Exception{
		TransferManagement_pageObj.rejectwithdrawalTransferRequest(buttonName, commentValue, confirmationButton);
		softAssertObj.assertEquals(TransferManagement_pageObj.successMessage_anyAction_text(),"Transfer request has been updated successfully");
	}
	
	@Test(priority = 35)
	public void logout() throws Exception{
		TransferManagement_pageObj.logout();
		/*softAssertObj.assertEquals(TransferManagement_pageObj.getAlertForLogout(), "Logout successful");
		softAssertObj.assertAll();*/
	}

}
