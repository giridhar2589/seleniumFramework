package com.mu_sigma.OrgPlatformAutomationFramework.TransferManagement.test;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;
import com.mu_sigma.OrgPlatformAutomationFramework.transferManagement.page.TransferManagement_page;

public class TransferManagement_HRView_test extends TestBase {
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
	public void impersonateHR(){
		TransferManagement_pageObj.impersonateEmployee(propetiesOverloadObj.getProperty("HR"));
		softAssertObj.assertTrue(TransferManagement_pageObj.getDesignation_text().contains("Decision Scientist"));
	}	

	@DataProvider(name = "specificrequestDetails")
	public String[][] getspecificRequestDetails(){
		String[][] getData = getData("transferManagement.xlsx", "finalDetails");
		return getData;
	}

	@Test(priority = 3,dataProvider="specificrequestDetails")
	public void selectSpecificRequest(String empID,String joiningDate) throws Exception{	
		TransferManagement_pageObj.employeeSearch(empID);
		TransferManagement_pageObj.clickselectSpecificRequest(joiningDate);
		softAssertObj.assertTrue(TransferManagement_pageObj.getPendingApprovalFrom_text().contains("Pending HR Approval"));
	}


	@DataProvider(name = "approverequest")
	public String[][] approverequest() {
		String[][] approveData = getData("transferManagement.xlsx", "approverequestdetails");
		return approveData;
	}

	@Test(priority = 4,dataProvider="approverequest")
	public void approveTransferRequest(String buttonName,String confirmationButton) throws Exception{
		TransferManagement_pageObj.approveTransferRequest(buttonName, confirmationButton);
		softAssertObj.assertEquals(TransferManagement_pageObj.successMessage_anyAction_text(),"Transfer request has been updated successfully");
		TransferManagement_pageObj.clearSearchBox();
	}
	
	@Test(priority = 5)
	public void selectFilters() throws InterruptedException{
		TransferManagement_pageObj.selectFilter();
	}

	@DataProvider(name = "withdrawrequestDetailsPendingApproval")
	public String[][] getwithdrawRequestDetails(){
		String[][] getwithdrawdetails = getData("transferManagement.xlsx", "withdrawspecificdetails");
		return getwithdrawdetails;
	}
	
	
	@Test(priority = 6,dataProvider="withdrawrequestDetailsPendingApproval")
	public void selectWithdrawRequest(String empID,String joiningDate) throws Exception{
		TransferManagement_pageObj.employeeSearch(empID);
		TransferManagement_pageObj.clickselectSpecificRequest(joiningDate);
		softAssertObj.assertTrue(TransferManagement_pageObj.getPendingApprovalFrom_text().contains("Withdrawn Request"));
	}
	
	@DataProvider(name = "approvewithdrawrequest")
	public String[][] approverwithdrawequest() {
		String[][] approvewithdrawData = getData("transferManagement.xlsx", "approvewithdrawrequestdetails");
		return approvewithdrawData;
	}
	
	@Test(priority = 7,dataProvider="approvewithdrawrequest")
	public void approveWithdrawTransferRequest(String buttonName,String commentValue,String confirmationButton) throws Exception{
		TransferManagement_pageObj.approvewithdrawalTransferRequest(buttonName, commentValue, confirmationButton);
		softAssertObj.assertEquals(TransferManagement_pageObj.successMessage_anyAction_text(),"Transfer request has been updated successfully");
	}


	@Test(priority = 8)
	public void logout() throws Exception{
		TransferManagement_pageObj.logout();
		softAssertObj.assertEquals(TransferManagement_pageObj.getAlertForLogout(), "Logout successful");
	}

}
