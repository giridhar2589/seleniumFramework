package com.mu_sigma.OrgPlatformAutomationFramework.muMoments.test;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mu_sigma.OrgPlatformAutomationFramework.muMoments.page.Engagement_BillingType_Mandatory;
import com.mu_sigma.OrgPlatformAutomationFramework.muMoments.page.Engagement_SavenCloseMan_Validator;
import com.mu_sigma.OrgPlatformAutomationFramework.muMoments.page.Engagement_Status_Mandatory;
import com.mu_sigma.OrgPlatformAutomationFramework.muMoments.page.Engagement_SubGroup_Man_Validator;
import com.mu_sigma.OrgPlatformAutomationFramework.muMoments.page.Engagement_creation_page;
import com.mu_sigma.OrgPlatformAutomationFramework.muMoments.page.MuMoments_Login_page;
import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;

public class MuMoments_Engagement_Creation_Test extends TestBase {

	MuMoments_Login_page muMoments_Login_pageObj;
	Engagement_creation_page muMoments_Engagement_Creation_pageObj;
	Engagement_SavenCloseMan_Validator muMoments_SaveNClose_Validation_pageObj;
	Engagement_Status_Mandatory muMoments_Status_Mandatory_Validator_pageObj;
	Engagement_BillingType_Mandatory muMoments_Engagement_BillingType_Mandatory_pageObj;
	Engagement_SubGroup_Man_Validator muMoments_Engagement_SubGroup_Mandatory_pageObj;

	@BeforeClass
	public void setUp() throws Exception {
		init("muMomemts_testenvironment");
		muMoments_Login_pageObj = new MuMoments_Login_page(driver);
		muMoments_Engagement_Creation_pageObj = new Engagement_creation_page(driver);
		muMoments_SaveNClose_Validation_pageObj = new Engagement_SavenCloseMan_Validator(driver);
		muMoments_Status_Mandatory_Validator_pageObj = new Engagement_Status_Mandatory(driver);
		muMoments_Engagement_BillingType_Mandatory_pageObj = new Engagement_BillingType_Mandatory(driver);
		muMoments_Engagement_SubGroup_Mandatory_pageObj = new Engagement_SubGroup_Man_Validator(driver);
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
		Thread.sleep(13000);
	}

	@Test(priority = 1)
	public void engagementCreation() throws InterruptedException {
		muMoments_Engagement_Creation_pageObj.clickOnEngagementsTab();
		Thread.sleep(9000);
		muMoments_Engagement_Creation_pageObj.engagementClickOnPlusIcon();
		Thread.sleep(9000);
		muMoments_Engagement_Creation_pageObj.engagementAcoountDropDown();
		Thread.sleep(4000);
		muMoments_Engagement_Creation_pageObj.engagementAccountSelection();
		Thread.sleep(4000);
		muMoments_Engagement_Creation_pageObj.engagementBillingTypeDropDown();
		Thread.sleep(4000);
		muMoments_Engagement_Creation_pageObj.engagementBillingTypeSelection();
		Thread.sleep(4000);
		muMoments_Engagement_Creation_pageObj.engagementEndDateSelection1();
		Thread.sleep(4000);
		muMoments_Engagement_Creation_pageObj.engagementEndDateSelection2();
		Thread.sleep(4000);
		muMoments_Engagement_Creation_pageObj.engagementEndDateSelection3();
		Thread.sleep(4000);
		muMoments_Engagement_Creation_pageObj.engagementEndDateSelection4();
		Thread.sleep(4000);
		muMoments_Engagement_Creation_pageObj.engagementEndDateSelection5();
		Thread.sleep(4000);
		muMoments_Engagement_Creation_pageObj.clickOnEngagementStatusDropDown();
		Thread.sleep(4000);
		muMoments_Engagement_Creation_pageObj.selectEngagementStatus();
		Thread.sleep(4000);
		muMoments_Engagement_Creation_pageObj.engagementNameSelection();
		Thread.sleep(4000);
		muMoments_Engagement_Creation_pageObj.engagementStartDateSelection1();
		Thread.sleep(4000);
		muMoments_Engagement_Creation_pageObj.engagementStartDateSelection2();
		Thread.sleep(4000);
		muMoments_Engagement_Creation_pageObj.engagementStartDateSelection3();
		Thread.sleep(4000);
		muMoments_Engagement_Creation_pageObj.engagementNextButton1();
		Thread.sleep(4000);
		muMoments_Engagement_Creation_pageObj.clickOnVCMDropDown();
		Thread.sleep(4000);
		muMoments_Engagement_Creation_pageObj.selectingVCM();
		Thread.sleep(4000);
		muMoments_Engagement_Creation_pageObj.engagementNextButton2();
		Thread.sleep(4000);
		muMoments_Engagement_Creation_pageObj.clickOnPrimaryContactDropDown();
		Thread.sleep(4000);
		muMoments_Engagement_Creation_pageObj.primaryContactSelection();
		Thread.sleep(4000);
		muMoments_Engagement_Creation_pageObj.engagementNextButton3();
		Thread.sleep(4000);
		muMoments_Engagement_Creation_pageObj.engagementNextButton4();
		Thread.sleep(4000);
		muMoments_Engagement_Creation_pageObj.engagementNextButton5();
		Thread.sleep(4000);
		muMoments_Engagement_Creation_pageObj.engagementNextButton6();
		Thread.sleep(4000);
		muMoments_Engagement_Creation_pageObj.createbttn();
		Thread.sleep(7000);
	}

	@Test(priority = 2)
	public void engagementSavenCloseValidator() throws InterruptedException {
		muMoments_SaveNClose_Validation_pageObj.clickOnEngagementsTabSCM();
		Thread.sleep(9000);
		muMoments_SaveNClose_Validation_pageObj.clickOnEngPlusIconSCM();
		Thread.sleep(9000);
		muMoments_SaveNClose_Validation_pageObj.engSubGroupDropDownSCM();
		Thread.sleep(4000);
		muMoments_SaveNClose_Validation_pageObj.engSubGroupSelectionSCM();
		Thread.sleep(4000);
		muMoments_SaveNClose_Validation_pageObj.engBillingTypeDropDownSCM();
		Thread.sleep(4000);
		muMoments_SaveNClose_Validation_pageObj.engBillingTypeSelectionSCM();
		Thread.sleep(4000);
		muMoments_SaveNClose_Validation_pageObj.engEndDateSelectionSCM1();
		Thread.sleep(4000);
		muMoments_SaveNClose_Validation_pageObj.engEndDateSelectionSCM2();
		Thread.sleep(4000);
		muMoments_SaveNClose_Validation_pageObj.engEndDateSelectionSCM3();
		Thread.sleep(4000);
		muMoments_SaveNClose_Validation_pageObj.engEndDateSelectionSCM4();
		Thread.sleep(4000);
		muMoments_SaveNClose_Validation_pageObj.engEndDateSelectionSCM5();
		Thread.sleep(4000);
		muMoments_SaveNClose_Validation_pageObj.clickOnEngagementStatusDropDownSCM();
		Thread.sleep(4000);
		muMoments_SaveNClose_Validation_pageObj.selectingEngagementStatusSCM();
		Thread.sleep(4000);
		muMoments_SaveNClose_Validation_pageObj.enterTheEngagementNameSCM();
		Thread.sleep(4000);
		muMoments_SaveNClose_Validation_pageObj.engStartDateSelctionSCM1();
		Thread.sleep(4000);
		muMoments_SaveNClose_Validation_pageObj.engStartDateSelctionSCM2();
		Thread.sleep(4000);
		muMoments_SaveNClose_Validation_pageObj.engSaveNCloseSCM();
		Thread.sleep(4000);
		muMoments_SaveNClose_Validation_pageObj.engCancelButtonSaveNCloseSCM();
		Thread.sleep(4000);

	}

	@Test(priority = 3)
	public void engagementStatusMandatory() throws InterruptedException {
		muMoments_Status_Mandatory_Validator_pageObj.clickOnEngagementsTabEngStatusMand();
		Thread.sleep(9000);
		muMoments_Status_Mandatory_Validator_pageObj.clickOnPlusIconStatusMandatory();
		Thread.sleep(9000);
		muMoments_Status_Mandatory_Validator_pageObj.engSubGroupDropDownStatusMandatory();
		Thread.sleep(4000);
		muMoments_Status_Mandatory_Validator_pageObj.engSubGroupSelectionStatusMandatory();
		Thread.sleep(4000);
		muMoments_Status_Mandatory_Validator_pageObj.engBillingTypeDropDownStatusMandatory();
		Thread.sleep(4000);
		muMoments_Status_Mandatory_Validator_pageObj.engBillingTypeSelectionStatusMandatory();
		Thread.sleep(4000);
		muMoments_Status_Mandatory_Validator_pageObj.engEndDateSelectionStatusMandatory1();
		Thread.sleep(4000);
		muMoments_Status_Mandatory_Validator_pageObj.engEndDateSelectionStatusMandatory2();
		Thread.sleep(4000);
		muMoments_Status_Mandatory_Validator_pageObj.engEndDateSelectionStatusMandarotry3();
		Thread.sleep(4000);
		muMoments_Status_Mandatory_Validator_pageObj.engEndDateSelectionStatusMandatory4();
		Thread.sleep(4000);
		muMoments_Status_Mandatory_Validator_pageObj.engEndDateSelectionStatusMandatory5();
		Thread.sleep(4000);
		muMoments_Status_Mandatory_Validator_pageObj.enterEngagementNameStatusMandatory();
		Thread.sleep(4000);
		muMoments_Status_Mandatory_Validator_pageObj.engStartDateSelctionStatusMandatory1();
		Thread.sleep(4000);
		muMoments_Status_Mandatory_Validator_pageObj.engStartDateSelctionStatusMandatory2();
		Thread.sleep(4000);
		muMoments_Status_Mandatory_Validator_pageObj.engNextBtnStatusMandatory();
		Thread.sleep(4000);
		muMoments_Status_Mandatory_Validator_pageObj.engCancelBtnStatusMandatory();
		Thread.sleep(4000);
	}

	@Test(priority = 4)
	public void engagementBillingTypeMandatoryValidator() throws InterruptedException {
		muMoments_Engagement_BillingType_Mandatory_pageObj.clickOnEngagementsTabBillingTypeMan();
		Thread.sleep(9000);
		muMoments_Engagement_BillingType_Mandatory_pageObj.clickOnEngPlusIconBillingTypeMan();
		Thread.sleep(9000);
		muMoments_Engagement_BillingType_Mandatory_pageObj.engSubGroupDropDownBillingTypeMan();
		Thread.sleep(4000);
		muMoments_Engagement_BillingType_Mandatory_pageObj.engSubGroupSelectionBillingTypeMan();
		Thread.sleep(4000);
		muMoments_Engagement_BillingType_Mandatory_pageObj.engEndDateSelectionBillingTypeMan1();
		Thread.sleep(4000);
		muMoments_Engagement_BillingType_Mandatory_pageObj.engEndDateSelectionBillingTypeMan2();
		Thread.sleep(4000);
		muMoments_Engagement_BillingType_Mandatory_pageObj.engEndDateSelectionBillingTypeMan3();
		Thread.sleep(4000);
		muMoments_Engagement_BillingType_Mandatory_pageObj.engEndDateSelectionBillingTypeMan4();
		Thread.sleep(4000);
		muMoments_Engagement_BillingType_Mandatory_pageObj.engEndDateSelectionBillingTypeMan5();
		Thread.sleep(4000);
		muMoments_Engagement_BillingType_Mandatory_pageObj.clickOnEngagementStatusDropDownBillingTypeMan();
		Thread.sleep(4000);
		muMoments_Engagement_BillingType_Mandatory_pageObj.selectingEngagementStatusBillingTypeMan();
		Thread.sleep(4000);
		muMoments_Engagement_BillingType_Mandatory_pageObj.enterTheEngagementNameBillingTypeMan();
		Thread.sleep(4000);
		muMoments_Engagement_BillingType_Mandatory_pageObj.engStartDateSelctionBillingTypeManSelection1();
		Thread.sleep(4000);
		muMoments_Engagement_BillingType_Mandatory_pageObj.engStartDateSelctionBillingTypeManSelection2();
		Thread.sleep(4000);
		muMoments_Engagement_BillingType_Mandatory_pageObj.engNextBtnBillingTypeMan();
		Thread.sleep(4000);
		muMoments_Engagement_BillingType_Mandatory_pageObj.engCancelBtnBillingTypeMan();
		Thread.sleep(4000);
	}

	@Test(priority = 5)
	public void engagementSubGroupMandatoryValidator() throws InterruptedException {
		muMoments_Engagement_SubGroup_Mandatory_pageObj.clickOnEngagementsTabSUbGroupMandatory();
		Thread.sleep(9000);
		muMoments_Engagement_SubGroup_Mandatory_pageObj.clickOnEngPlusIconSubGroupMandatory();
		Thread.sleep(9000);
		muMoments_Engagement_SubGroup_Mandatory_pageObj.engEndDateSelectionSubGroupMandatory1();
		Thread.sleep(4000);
		muMoments_Engagement_SubGroup_Mandatory_pageObj.engEndDateSelectionSubGroupMandatory2();
		Thread.sleep(4000);
		muMoments_Engagement_SubGroup_Mandatory_pageObj.engEndDateSelectionSubGroupMandatory3();
		Thread.sleep(4000);
		muMoments_Engagement_SubGroup_Mandatory_pageObj.engEndDateSelectionSubGroupMandatory4();
		Thread.sleep(4000);
		muMoments_Engagement_SubGroup_Mandatory_pageObj.engEndDateSelectionSubGroupMandatory5();
		Thread.sleep(4000);
		muMoments_Engagement_SubGroup_Mandatory_pageObj.clickOnEngagementStatusDropDownSubGroupMandatory();
		Thread.sleep(4000);
		muMoments_Engagement_SubGroup_Mandatory_pageObj.selectingEngagementStatusSubGroupMandatory();
		Thread.sleep(4000);
		muMoments_Engagement_SubGroup_Mandatory_pageObj.enterTheEngagementNameSubGroupMandatory();
		Thread.sleep(4000);
		muMoments_Engagement_SubGroup_Mandatory_pageObj.engStartDateSelctionSubGroupMandatory1();
		Thread.sleep(4000);
		muMoments_Engagement_SubGroup_Mandatory_pageObj.engStartDateSelctionSubGroupMandatory2();
		Thread.sleep(4000);
		muMoments_Engagement_SubGroup_Mandatory_pageObj.engBillingTypeDropDownSubGroupMandatory();
		Thread.sleep(4000);
		muMoments_Engagement_SubGroup_Mandatory_pageObj.engBillingTypeSelectionSubGroupMandatory();
		Thread.sleep(4000);
		muMoments_Engagement_SubGroup_Mandatory_pageObj.engnxtbuttonclickSubGroupMandatory();
		Thread.sleep(4000);
	}
}
