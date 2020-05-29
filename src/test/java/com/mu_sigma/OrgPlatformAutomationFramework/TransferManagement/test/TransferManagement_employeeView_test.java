package com.mu_sigma.OrgPlatformAutomationFramework.TransferManagement.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;
import com.mu_sigma.OrgPlatformAutomationFramework.transferManagement.page.TransferManagement_page;

public class TransferManagement_employeeView_test extends TestBase {
	TransferManagement_page TransferManagement_pageObj;
	private static final Logger TransferManagement_test_pageLog = LogManager
			.getLogger(TransferManagement_employeeView_test.class.getName());
	SoftAssert softAssertObj = new SoftAssert();

	@BeforeClass
	public void setUp() throws Exception {
		init("transferManagement_OwnServer");
		TransferManagement_pageObj = new TransferManagement_page(driver);
		loadProperties("transferManagement.properties");
		Thread.sleep(8000);
	}

	@DataProvider(name = "loginTestdata")
	public String[][] getLogInData() {
		String[][] loginData = getData("transferManagement.xlsx", "invalidlogin");
		return loginData;
	}

	@Test(priority = 0, dataProvider = "loginTestdata")
	public void loginValidation(String username, String password, String runMode) throws Exception, Throwable {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("User marked this Record as No Run");
		}
		TransferManagement_pageObj.fillLoginDetails(username, password);
		softAssertObj.assertEquals(TransferManagement_pageObj.getInvalidUserNamePasswordText(),
				"Sorry, we were not able to find a user with that username and password.");
		TransferManagement_test_pageLog.info("User unable to login with invalid username and password");
	}

	@DataProvider(name = "validloginTestdata")
	public String[][] getvalidLogInData() {
		String[][] loginData = getData("transferManagement.xlsx", "validlogin");
		return loginData;
	}

	@Test(priority = 1, dataProvider = "validloginTestdata")
	public void loginTransferManagement(String username, String password, String runMode) throws Exception {
		if (runMode.equalsIgnoreCase("n")) {
			throw new SkipException("User marked this Record as No Run");
		}
		TransferManagement_pageObj.fillLoginDetails(username, password);
		TransferManagement_pageObj.navigateToTransferManagementApp();
		softAssertObj.assertEquals(TransferManagement_pageObj.transferManagementPage_header_text(), "Transfer Management");
		Thread.sleep(3000);
		softAssertObj.assertAll();
	}

	@DataProvider(name = "mandatoryinputs_transferrequest")
	public String[][] getinputData() {
		String[][] inputData = getData("transferManagement.xlsx", "mandatoryinputs_transferrequest");
		return inputData;
	}


	@Test(priority = 2, dataProvider = "mandatoryinputs_transferrequest")
	public void raiseTransferRequest(String lastDate, String joiningDate, String currentAddress, String newAddress,
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
		TransferManagement_pageObj.clickSubmitBtn();
		softAssertObj.assertEquals(TransferManagement_pageObj.mandatoryFieldsMessage_text(),"Please fill the required details");
		Thread.sleep(3000);
		softAssertObj.assertAll();
		TransferManagement_pageObj.selectVisaType();
		TransferManagement_pageObj.selectValueFromAnyDropdown(VisaName);
		TransferManagement_pageObj.clickSubmitBtn();
		softAssertObj.assertEquals(TransferManagement_pageObj.successMessage_text(),"Transfer request has been initiated successfully");
		Thread.sleep(3000);
		softAssertObj.assertAll();
	}

	@DataProvider(name = "withdrawrequest")
	public String[][] withdrawrequest () {
		String[][] withdrawinputData = getData("transferManagement.xlsx", "withdrawrequestdetails");
		return withdrawinputData;
	}
	@Test(priority = 3,dataProvider="withdrawrequest")
	public void withdrawTransferRequest(String buttonName,String commentValue,String confirmationButton) throws InterruptedException{
		TransferManagement_pageObj.withdrawTransferRequest(buttonName,commentValue,confirmationButton);
		softAssertObj.assertEquals(TransferManagement_pageObj.successMessage_anyAction_text(),"Transfer request has been updated successfully");
		Thread.sleep(3000);
		softAssertObj.assertAll();
	}

	@Test(priority =4)
	public void clickOnNewTransferRequest() throws Exception{
		TransferManagement_pageObj.clickOnNewRequest();
		softAssertObj.assertEquals(TransferManagement_pageObj.newrequest_header_text(), "New Request");
		Thread.sleep(3000);
		softAssertObj.assertAll();
	}

	@DataProvider(name = "inputsToraisenewRequest")
	public String[][] getinputs() {
		String[][] inputData = getData("transferManagement.xlsx", "inputsToraisenewRequest");
		return inputData;
	}

	@Test(priority = 5,dataProvider = "inputsToraisenewRequest")
	public void inputsToraisenewTransferRequest(String lastDate, String joiningDate, String currentAddress, String newAddress,
			String currentCountryName, String currentStateName, String currentCityName, String newCountryName,
			String newStateName, String newCityName, String VisaName,String newjoiningDate) throws Exception {
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
		softAssertObj.assertEquals(TransferManagement_pageObj.datavalidationMessage_text(),"A request for the same joining/last working date is present");
		Thread.sleep(3000);
		softAssertObj.assertAll();
		TransferManagement_pageObj.selectJoiningDate(newjoiningDate);
		TransferManagement_pageObj.clickSubmitBtn();
		softAssertObj.assertEquals(TransferManagement_pageObj.successMessage_text(),"Transfer request has been initiated successfully");
		Thread.sleep(3000);
		softAssertObj.assertAll();
	}

	@Test(priority = 6)
	public void logout() throws Exception{
		TransferManagement_pageObj.logout();
		/*softAssertObj.assertEquals(TransferManagement_pageObj.getAlertForLogout(), "Logout successful");
		softAssertObj.assertAll();*/
	}
}
