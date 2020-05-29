package com.mu_sigma.OrgPlatformAutomationFramework.muMoments.test;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mu_sigma.OrgPlatformAutomationFramework.muMoments.page.MuMoments_Login_page;
import com.mu_sigma.OrgPlatformAutomationFramework.muMoments.page.Pursuit_Account_Mandatory_Validator;
import com.mu_sigma.OrgPlatformAutomationFramework.muMoments.page.Pursuit_Nam_Man_page;
import com.mu_sigma.OrgPlatformAutomationFramework.muMoments.page.Pursuit_Status_Man;
import com.mu_sigma.OrgPlatformAutomationFramework.muMoments.page.Pursuit_Type_Man;
import com.mu_sigma.OrgPlatformAutomationFramework.muMoments.page.Pursuit_creation_page;
import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;

public class MuMoments_pursuitCreation_test extends TestBase {

	MuMoments_Login_page muMomentsLoginPageObj;
	Pursuit_creation_page Pursuit_creation_pageObj;
	Pursuit_Nam_Man_page Pursuit_Nam_Man_pageObj;
	Pursuit_Status_Man Pursuit_Status_Man_pageObj;
	Pursuit_Type_Man Pursuit_Type_Man_pageObj;
	Pursuit_Account_Mandatory_Validator Pursuit_Account_Mandatory_pageObj;

	@BeforeClass
	public void setUp() throws Exception {
		init("muMomemts_testenvironment");
		muMomentsLoginPageObj = new MuMoments_Login_page(driver);
		Pursuit_creation_pageObj = new Pursuit_creation_page(driver);
		Pursuit_Nam_Man_pageObj = new Pursuit_Nam_Man_page(driver);
		Pursuit_Status_Man_pageObj = new Pursuit_Status_Man(driver);
		Pursuit_Type_Man_pageObj = new Pursuit_Type_Man(driver);
		Pursuit_Account_Mandatory_pageObj = new Pursuit_Account_Mandatory_Validator(driver);
		loadProperties("muMoments.properties");
		Thread.sleep(10000);
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
		muMomentsLoginPageObj.lDap_auth();
		muMomentsLoginPageObj.LogIn_box(username);
		muMomentsLoginPageObj.password_input(password);
		muMomentsLoginPageObj.clickbutton();
		Thread.sleep(15000);

	}

	@Test(priority = 1)
	public void createPursuit() throws InterruptedException {
		Pursuit_creation_pageObj.clickOnPursuitEntityName();
		Thread.sleep(8000);
		Pursuit_creation_pageObj.clickOnAddButton();
		Thread.sleep(10000);
		Pursuit_creation_pageObj.clickOnPursuitTypeDropDown();
		Thread.sleep(4000);
		Pursuit_creation_pageObj.selectPursuitType();
		Thread.sleep(4000);
		Pursuit_creation_pageObj.clickOnPursuitStatusDropDown();
		Thread.sleep(4000);
		Pursuit_creation_pageObj.selectPursuitStatus();
		Thread.sleep(4000);
		Pursuit_creation_pageObj.providePursuitName();
		Thread.sleep(10000);
		Pursuit_creation_pageObj.clickOnAccountDropDown();
		Thread.sleep(8000);
		Pursuit_creation_pageObj.accountSubgroupSelection();
		Thread.sleep(5000);
		Pursuit_creation_pageObj.clickOnNextButton();
		Thread.sleep(4000);
		Pursuit_creation_pageObj.clickOnAddContactButton();
		Thread.sleep(5000);
		Pursuit_creation_pageObj.clickOnContactDropDown();
		Thread.sleep(3000);
		Pursuit_creation_pageObj.selectionOfContact();
		Thread.sleep(3000);
		Pursuit_creation_pageObj.clickOnRoleDropDown();
		Thread.sleep(3000);
		Pursuit_creation_pageObj.selectingTheRole();
		Thread.sleep(3000);
		Pursuit_creation_pageObj.saveNClose();
		Thread.sleep(15000);
	}

	@Test(priority = 2)
	public void createPursuitNameMandatoryCheck() throws InterruptedException {

		Pursuit_Nam_Man_pageObj.pursuitTabSelectionNamMan();
		Thread.sleep(8000);
		Pursuit_Nam_Man_pageObj.clickOnAddButtonNamMan();
		Thread.sleep(10000);
		Pursuit_Nam_Man_pageObj.pursuitTypeDropDownNamMan();
		Thread.sleep(4000);
		Pursuit_Nam_Man_pageObj.pursuitTypeSelectionNamMan();
		Thread.sleep(4000);
		Pursuit_Nam_Man_pageObj.pursuitStatusDropDownNamMan();
		Thread.sleep(4000);
		Pursuit_Nam_Man_pageObj.pursuitStatusSelectionNamMan();
		Thread.sleep(4000);
		Pursuit_Nam_Man_pageObj.pursuitAccountDrpDownNamMan();
		Thread.sleep(3000);
		Pursuit_Nam_Man_pageObj.pursuitAccountSelectionNamMan();
		Thread.sleep(4000);
		Pursuit_Nam_Man_pageObj.nextbuttonPressNamMan();
		Thread.sleep(5000);
		Pursuit_Nam_Man_pageObj.cancelButtonPressNamMan();
		Thread.sleep(9000);
	}

	@Test(priority = 3)
	public void createPursuitStatusMandarotyCheck() throws InterruptedException {
		Pursuit_Status_Man_pageObj.pursuitTabSelectionStatMan();
		Thread.sleep(8000);
		Pursuit_Status_Man_pageObj.clickOnAddButtonStatMan();
		Thread.sleep(10000);
		Pursuit_Status_Man_pageObj.pursuitTypeDropDownStatMan();
		Thread.sleep(3000);
		Pursuit_Status_Man_pageObj.pursuitTypeSelectionStatMan();
		Thread.sleep(3000);
		Pursuit_Status_Man_pageObj.clickOnAccountDropDownStatMan();
		Thread.sleep(2000);
		Pursuit_Status_Man_pageObj.selectAccountStatMan();
		Thread.sleep(3000);
		Pursuit_Status_Man_pageObj.enterPursuitNameStatMan();
		Thread.sleep(3000);
		Pursuit_Status_Man_pageObj.next_btn1StatMan();
		Thread.sleep(3000);
		Pursuit_Status_Man_pageObj.cancelButton1StatMan();
		Thread.sleep(9000);
	}

	@Test(priority = 4)
	public void createPursuitTypeMan() throws InterruptedException {
		Pursuit_Type_Man_pageObj.clickOnPursuitTabTypeMan();
		Thread.sleep(8000);
		Pursuit_Type_Man_pageObj.pursuitAddbuttonTypeMan();
		Thread.sleep(10000);
		Pursuit_Type_Man_pageObj.pursuitStatusDropDownTypeMan();
		Thread.sleep(4000);
		Pursuit_Type_Man_pageObj.pursuitStatusSelectionTypeMan();
		Thread.sleep(4000);
		Pursuit_Type_Man_pageObj.pursuitAccountDropDownTypeMan();
		Thread.sleep(4000);
		Pursuit_Type_Man_pageObj.pursuitAccoutnSelectionTypeMan();
		Thread.sleep(4000);
		Pursuit_Type_Man_pageObj.enterPursuitNameAccMan();
		Thread.sleep(3000);
		Pursuit_Type_Man_pageObj.nextbuttonTypeMan();
		Thread.sleep(4000);
		Pursuit_Type_Man_pageObj.cancelButtonTypeMan();
		Thread.sleep(4000);
	}

	@Test(priority = 5)
	public void createPursuitAccountMandatory() throws InterruptedException {
		Pursuit_Account_Mandatory_pageObj.clickOnPursuitEntityAccMan();
		Thread.sleep(8000);
		Pursuit_Account_Mandatory_pageObj.clickOnAddButtonIconAccMan();
		Thread.sleep(10000);
		Pursuit_Account_Mandatory_pageObj.clickOnPursuitTypedrpdownAccMan();
		Thread.sleep(4000);
		Pursuit_Account_Mandatory_pageObj.pursuitTypeSelAccMan();
		Thread.sleep(4000);
		Pursuit_Account_Mandatory_pageObj.clickOnStatusdrpdownAccMan();
		Thread.sleep(4000);
		Pursuit_Account_Mandatory_pageObj.prsuitStatusSelAccMan();
		Thread.sleep(4000);
		Pursuit_Account_Mandatory_pageObj.enterPursuitNameAccMan();
		Thread.sleep(4000);
		Pursuit_Account_Mandatory_pageObj.nextButtonPress1AccMan();
		Thread.sleep(4000);
		Pursuit_Account_Mandatory_pageObj.cancelButtonPressAccMan();
		Thread.sleep(4000);
	}

}
