package com.mu_sigma.OrgPlatformAutomationFramework.muMoments.test;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.mu_sigma.OrgPlatformAutomationFramework.muMoments.page.Contact_Acc_Man;
import com.mu_sigma.OrgPlatformAutomationFramework.muMoments.page.Contact_Creation_page;
import com.mu_sigma.OrgPlatformAutomationFramework.muMoments.page.Contact_LasName_Man;
import com.mu_sigma.OrgPlatformAutomationFramework.muMoments.page.Contact_SavenCloseMan_Validator;
import com.mu_sigma.OrgPlatformAutomationFramework.muMoments.page.MuMoments_Login_page;
import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;

public class MuMoments_Contact_Creation_Test extends TestBase {

	MuMoments_Login_page muMoments_Login_pageObj;
	Contact_Creation_page muMoments_Contact_Creation_pageObj;
	Contact_Acc_Man muMoments_Contact_Acc_Man_pageObj;
	Contact_LasName_Man muMoments_Contact_Last_Name_Man_pageObj;
	Contact_SavenCloseMan_Validator muMoments_Contact_SaveNClose_Validator_pageObj;
	SoftAssert contSoftAssertObj;

	@BeforeClass
	public void setUp() throws Exception {
		init("muMomemts_testenvironment");
		muMoments_Login_pageObj = new MuMoments_Login_page(driver);
		muMoments_Contact_Creation_pageObj = new Contact_Creation_page(driver);
		muMoments_Contact_Acc_Man_pageObj = new Contact_Acc_Man(driver);
		muMoments_Contact_Last_Name_Man_pageObj = new Contact_LasName_Man(driver);
		muMoments_Contact_SaveNClose_Validator_pageObj = new Contact_SavenCloseMan_Validator(driver);
		loadProperties("muMoments.properties");
		Thread.sleep(4000);
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
		Thread.sleep(6000);
	}

	@Test(priority = 1)
	public void contactStatusMandatoryFieldValidation() throws InterruptedException {
		muMoments_Contact_Creation_pageObj.clickOnContactsTab();
		Thread.sleep(6000);
		muMoments_Contact_Creation_pageObj.clickOnAddButtonIcon();
		Thread.sleep(7000);
		muMoments_Contact_Creation_pageObj.enterFirstName(propetiesOverloadObj.getProperty("fName"));
		Thread.sleep(2000);
		muMoments_Contact_Creation_pageObj.enterLastName(propetiesOverloadObj.getProperty("lName"));
		Thread.sleep(2000);
		muMoments_Contact_Creation_pageObj.clickOnContactLevelDropDown();
		Thread.sleep(2000);
		muMoments_Contact_Creation_pageObj.selectingTheContactLevel();
		Thread.sleep(2000);
		muMoments_Contact_Creation_pageObj.clickOnNextButton1();
		Thread.sleep(2000);
		contSoftAssertObj.assertEquals(muMoments_Contact_Creation_pageObj.contactValidationMessageCheck(),
				"There are some validation errors in form below. Please rectify them before proceeding to next step");
	}

	@Test(priority = 2)
	public void contactLastNameMandatoryFieldCheck() throws InterruptedException {
		muMoments_Contact_Creation_pageObj.clickOncontactStatusDropDown();
		Thread.sleep(2000);
		muMoments_Contact_Creation_pageObj.selectingContactStatus();
		Thread.sleep(2000);

	}
}
