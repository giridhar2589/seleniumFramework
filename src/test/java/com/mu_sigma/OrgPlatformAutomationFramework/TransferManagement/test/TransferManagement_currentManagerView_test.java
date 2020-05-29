package com.mu_sigma.OrgPlatformAutomationFramework.TransferManagement.test;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;
import com.mu_sigma.OrgPlatformAutomationFramework.transferManagement.page.TransferManagement_page;

public class TransferManagement_currentManagerView_test extends TestBase {
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

	@Test(priority = 2)
	public void impersonateCurrentManager() throws Exception {
		TransferManagement_pageObj.impersonateEmployee(propetiesOverloadObj.getProperty("currentManager"));
		softAssertObj.assertTrue(TransferManagement_pageObj.getDesignation_text().contains("Apprentice"));
		Thread.sleep(3000);
		softAssertObj.assertAll();
	}

	@DataProvider(name = "specificrequestDetails")
	public String[][] getspecificRequestDetails() {
		String[][] getData = getData("transferManagement.xlsx", "specificrequestDetails");
		return getData;
	}

	@Test(priority = 3, dataProvider = "specificrequestDetails")
	public void selectSpecificRequest(String empID, String joiningDate) throws Exception {
		TransferManagement_pageObj.employeeSearch(empID);
		TransferManagement_pageObj.clickselectSpecificRequest(joiningDate);
		softAssertObj.assertTrue(
				TransferManagement_pageObj.getPendingApprovalFrom_text().contains("Pending Current Manager Approval"));
		//Thread.sleep(3000);
		//softAssertObj.assertAll();
	}

	@DataProvider(name = "modifyrequest")
	public String[][] modifyrequest() {
		String[][] modifyinputData = getData("transferManagement.xlsx", "modifyrequest_currentManager");
		return modifyinputData;
	}

	@Test(priority = 4, dataProvider = "modifyrequest")
	public void modifyTransferRequest(String buttonName, String commentValue, String confirmationButton,
			String newAccountName, String newManagerEmpID, String currentRHEmpID, String newRHEmpID, String designation)
			throws Exception {
		TransferManagement_pageObj.modifyTransferRequest(buttonName, commentValue);
		TransferManagement_pageObj.selectNewAccount(newAccountName);
		TransferManagement_pageObj.selectNewAccountManager(newManagerEmpID);
		TransferManagement_pageObj.selectCurrentRH(currentRHEmpID);
		TransferManagement_pageObj.selectNewRH(newRHEmpID);
		//TransferManagement_pageObj.selectDesignation();
		//TransferManagement_pageObj.selectValueFromAnyDropdown(designation);
		TransferManagement_pageObj.saveModifiedDetails(confirmationButton);
		softAssertObj.assertEquals(TransferManagement_pageObj.successMessage_anyAction_text(),
				"Transfer request has been updated successfully");
		//Thread.sleep(3000);
		//softAssertObj.assertAll();
	}

	@DataProvider(name = "approverequest")
	public String[][] approverequest() {
		String[][] approveData = getData("transferManagement.xlsx", "approverequestdetails");
		return approveData;
	}

	@Test(priority = 5, dataProvider = "approverequest")
	public void approveTransferRequest(String buttonName, String confirmationButton) throws Exception {
		TransferManagement_pageObj.approveTransferRequest(buttonName, confirmationButton);
		softAssertObj.assertEquals(TransferManagement_pageObj.successMessage_anyAction_text(),
				"Transfer request has been updated successfully");
		//Thread.sleep(3000);
		//softAssertObj.assertAll();
	}

	@Test(priority = 6)
	public void logout() throws Exception {
		TransferManagement_pageObj.logout();
		/*softAssertObj.assertEquals(TransferManagement_pageObj.getAlertForLogout(), "Logout successful");
		softAssertObj.assertAll();*/
	}

}
