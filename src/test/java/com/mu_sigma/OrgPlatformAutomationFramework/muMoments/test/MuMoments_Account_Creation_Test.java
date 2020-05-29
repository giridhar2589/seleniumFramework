package com.mu_sigma.OrgPlatformAutomationFramework.muMoments.test;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.mu_sigma.OrgPlatformAutomationFramework.muMoments.page.Account_creation_page;
import com.mu_sigma.OrgPlatformAutomationFramework.muMoments.page.MuMoments_Login_page;
import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;

public class MuMoments_Account_Creation_Test extends TestBase {

	MuMoments_Login_page muMoments_Login_pageObj;
	Account_creation_page Accounts_creation_pageObj;
	SoftAssert softAssertObj = new SoftAssert();

	@BeforeClass
	public void setUp() throws Exception {
		init("muMomemts_testenvironment");
		muMoments_Login_pageObj = new MuMoments_Login_page(driver);
		Accounts_creation_pageObj = new Account_creation_page(driver);
		loadProperties("muMoments.properties");
		Thread.sleep(8000);
	}

	@DataProvider(name = "loginTestdata")
	public String[][] getLogInData() {
		String[][] loginData = getData("muMoments.xlsx", "Sheet1");
		return loginData;
	}

	@Test(priority = 0, dataProvider = "loginTestdata")
	public void login(String username, String password, String runmode) throws InterruptedException {
		if (runmode.equalsIgnoreCase("n")) {
			throw new SkipException("user Marked as No Run");
		}
		muMoments_Login_pageObj.lDap_auth();
		muMoments_Login_pageObj.LogIn_box(username);
		muMoments_Login_pageObj.password_input(password);
		muMoments_Login_pageObj.clickbutton();
		Thread.sleep(8000);
	}

	@Test(priority = 1)
	public void accountCurrencyMandatoryFieldValidator() throws InterruptedException {
		Accounts_creation_pageObj.clickOnAccountsTab();
		Thread.sleep(4000);
		Accounts_creation_pageObj.clickOnPlusIcon();
		Thread.sleep(6000);
		Accounts_creation_pageObj.enterAccountName(propetiesOverloadObj.getProperty("accountName"));
		Thread.sleep(5000);
		Accounts_creation_pageObj.accountNextButtonPress1();
		Thread.sleep(4000);
		softAssertObj.assertEquals(Accounts_creation_pageObj.errorMessage_Validation(),
				"There are some validation errors in form below. Please rectify them before proceeding to next step");
	}

	@Test(priority = 2)
	public void accountSaveNCloseMandatoryFieldValidator() throws InterruptedException {

		Accounts_creation_pageObj.accountCurrencyFieldDropDown();
		Thread.sleep(2000);
		Accounts_creation_pageObj.accountCurrencySelection();
		Thread.sleep(2000);
		Accounts_creation_pageObj.saveNCloseButtonPress();
		Thread.sleep(2000);
		softAssertObj.assertEquals(Accounts_creation_pageObj.errorMessage_Validation(),
				"There are some validation errors in form below. Please rectify them before proceeding to next step");
	}

	@Test(priority = 3)
	public void accountNameMandatoryValidator() throws InterruptedException {
		Accounts_creation_pageObj.previousButtonPress();
		Thread.sleep(2000);
		Accounts_creation_pageObj.deleteAccountName();
		Thread.sleep(2000);
		Accounts_creation_pageObj.accountNextButtonPress1();
		Thread.sleep(2000);
		softAssertObj.assertEquals(Accounts_creation_pageObj.errorMessage_Validation(),
				"There are some validation errors in form below. Please rectify them before proceeding to next step");
	}

	@Test(priority = 4)
	public void accountCountryMandatoryFieldValidator() throws InterruptedException {
		Accounts_creation_pageObj.enterAccountName(propetiesOverloadObj.getProperty("accountName"));
		Thread.sleep(3000);
		Accounts_creation_pageObj.accountNextButtonPress1();
		Thread.sleep(2000);
		Accounts_creation_pageObj.accountNextButtonPress2();
		Thread.sleep(2000);
		softAssertObj.assertEquals(Accounts_creation_pageObj.errorMessage_Validation(),
				"There are some validation errors in form below. Please rectify them before proceeding to next step");
	}

	@Test(priority = 5)
	public void accountCreation() throws InterruptedException {
		Accounts_creation_pageObj.accountCountryDropDown();
		Thread.sleep(3000);
		Accounts_creation_pageObj.accountCountrySelection();
		Thread.sleep(2000);
		Accounts_creation_pageObj.accountNextButtonPress2();
		Thread.sleep(2000);
		Accounts_creation_pageObj.accountNextButtonPress3();
		Thread.sleep(2000);
		Accounts_creation_pageObj.accountCreateButtonPress();
		Thread.sleep(10000);
		softAssertObj.assertEquals(Accounts_creation_pageObj.accountNameValidationAfterSave(), "Test Account Selenium framework 1");
		Thread.sleep(2000);
	}
}
