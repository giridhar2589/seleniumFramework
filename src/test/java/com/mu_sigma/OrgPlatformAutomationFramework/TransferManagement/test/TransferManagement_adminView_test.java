package com.mu_sigma.OrgPlatformAutomationFramework.TransferManagement.test;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;
import com.mu_sigma.OrgPlatformAutomationFramework.transferManagement.page.TransferManagement_page;

public class TransferManagement_adminView_test extends TestBase {
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
	
	@Test(priority =2)
	public void impersonateAdmin(){
		TransferManagement_pageObj.impersonateEmployee(propetiesOverloadObj.getProperty("Admin"));
		softAssertObj.assertTrue(TransferManagement_pageObj.getDesignation_text().contains("Senior Executive"));
	}
	
	@Test(priority = 3)
	public void filterCompletedRequests() throws Exception{
		TransferManagement_pageObj.clickAllTab();
		TransferManagement_pageObj.selectFilterForAllTab();
	}
	
	@DataProvider(name = "completedrequestdetails")
	public String[][] completedrequest() {
		String[][] completedData = getData("transferManagement.xlsx", "finalDetails");
		return completedData;
	}
	
	@Test(priority = 4,dataProvider="completedrequestdetails")
	public void clickOnCompletedRequest(String empID,String joiningDate) throws Exception{	
		TransferManagement_pageObj.employeeSearch(empID);
		TransferManagement_pageObj.clickselectSpecificRequest(joiningDate);
		softAssertObj.assertTrue(TransferManagement_pageObj.getPendingApprovalFrom_text().contains("Completed"));		
	}
	
	@DataProvider(name = "rejectcompletedrequestdetails")
	public String[][] rejectcompletedrequest() {
		String[][] rejectcompletedData = getData("transferManagement.xlsx", "rejectcompletedrequest");
		return rejectcompletedData;
	}
	
	@Test(priority = 5,dataProvider="rejectcompletedrequestdetails")
	public void rejectCompletedRequest(String buttonName,String commentValue,String confirmationButton) throws Exception{
		TransferManagement_pageObj.rejectCompletedTransferRequest(buttonName, commentValue, confirmationButton);
		softAssertObj.assertEquals(TransferManagement_pageObj.successMessage_anyAction_text(),"Transfer request has been updated successfully");
	}
	
	
	@DataProvider(name = "newrequestdetails")
	public String[][] newrequest() {
		String[][] newrequestdetails = getData("transferManagement.xlsx", "newRequestDetails");
		return newrequestdetails;
	}
	
	@Test(priority =6,dataProvider="newrequestdetails")
	public void raiseRequestforAnyEmployee(String EmpID,String newManagerEmpID,String lastDate, String joiningDate, String currentAddress, String newAddress,String currentCountryName, String currentStateName, String currentCityName, String newCountryName,
	String newStateName, String newCityName, String VisaName) throws Exception {
			TransferManagement_pageObj.clickOnNewRequest();
			TransferManagement_pageObj.enterEmpID(EmpID);
			TransferManagement_pageObj.selectNewAccountManager(newManagerEmpID);
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
			softAssertObj.assertEquals(TransferManagement_pageObj.successMessage_text(),"Transfer request has been initiated successfully");
	}
	
	@DataProvider(name = "approvenewrequest")
	public String[][] approverequest() {
		String[][] approveData = getData("transferManagement.xlsx", "approverequestdetails");
		return approveData;
	}
	
	@Test(priority = 7,dataProvider="approvenewrequest")
	public void approveTransferRequest(String buttonName,String confirmationButton) throws Exception{
		for(int i=1;i<=3;i++){
			TransferManagement_pageObj.approveTransferRequest(buttonName, confirmationButton);
			softAssertObj.assertEquals(TransferManagement_pageObj.successMessage_anyAction_text(),"Transfer request has been updated successfully");
		}		
	}
	
	/*@Test(priority = 8)
	public void deselectTriggerMail() throws Exception{
		TransferManagement_pageObj.deselectTriggerMailCheckBox();
	}*/
	
	@DataProvider(name = "rejectrequestatchecklistlevel")
	public String[][] rejectrequest() {
		String[][] rejectData = getData("transferManagement.xlsx", "rejectrequestdetails");
		return rejectData;
	}
	
	@Test(priority = 9,dataProvider="rejectrequestatchecklistlevel")
	public void rejectTransferRequestAtChecklistLevel(String buttonName,String commentValue,String confirmationButton) throws Exception{
		TransferManagement_pageObj.rejectTransferRequest(buttonName, commentValue, confirmationButton);
		softAssertObj.assertEquals(TransferManagement_pageObj.successMessage_anyAction_text(),"Transfer request has been updated successfully");
	}
	
	@Test(priority =10)
	public void logout() throws Exception{
		TransferManagement_pageObj.logout();
		/*softAssertObj.assertEquals(TransferManagement_pageObj.getAlertForLogout(), "Logout successful");
		softAssertObj.assertAll();*/
	}
	
}
