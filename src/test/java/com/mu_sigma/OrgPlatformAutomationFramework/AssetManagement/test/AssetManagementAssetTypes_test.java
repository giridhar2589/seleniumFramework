package com.mu_sigma.OrgPlatformAutomationFramework.AssetManagement.test;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.mu_sigma.OrgPlatformAutomationFramework.AssetManagement.page.AssetManagementAssetAssignCon_page;
import com.mu_sigma.OrgPlatformAutomationFramework.AssetManagement.page.AssetManagementAssetAssign_page;
import com.mu_sigma.OrgPlatformAutomationFramework.AssetManagement.page.AssetManagementAssetClose_page;
import com.mu_sigma.OrgPlatformAutomationFramework.AssetManagement.page.AssetManagementAssetProcessCon_page;
import com.mu_sigma.OrgPlatformAutomationFramework.AssetManagement.page.AssetManagementAssetProcess_page;
import com.mu_sigma.OrgPlatformAutomationFramework.AssetManagement.page.AssetManagementAssetRecoverCon_page;
import com.mu_sigma.OrgPlatformAutomationFramework.AssetManagement.page.AssetManagementAssetRecover_page;
import com.mu_sigma.OrgPlatformAutomationFramework.AssetManagement.page.AssetManagementAssetReqMand_page;
import com.mu_sigma.OrgPlatformAutomationFramework.AssetManagement.page.AssetManagementAssetReq_page;
import com.mu_sigma.OrgPlatformAutomationFramework.AssetManagement.page.AssetManagementAssetReturnCon_page;
import com.mu_sigma.OrgPlatformAutomationFramework.AssetManagement.page.AssetManagementAssetReturn_page;
import com.mu_sigma.OrgPlatformAutomationFramework.AssetManagement.page.AssetManagementAssetTypesMandatory_page;
import com.mu_sigma.OrgPlatformAutomationFramework.AssetManagement.page.AssetManagementAssetTypes_page;
import com.mu_sigma.OrgPlatformAutomationFramework.AssetManagement.page.AssetManagementAssetsMandatory_page;
import com.mu_sigma.OrgPlatformAutomationFramework.AssetManagement.page.AssetManagementAssets_page;
import com.mu_sigma.OrgPlatformAutomationFramework.AssetManagement.page.AssetManagementLessUsageAssetCon_page;
import com.mu_sigma.OrgPlatformAutomationFramework.AssetManagement.page.AssetManagementLessUsageAsset_page;
import com.mu_sigma.OrgPlatformAutomationFramework.AssetManagement.page.AssetManagementLevelMandatory_page;
import com.mu_sigma.OrgPlatformAutomationFramework.AssetManagement.page.AssetManagementLevel_page;
import com.mu_sigma.OrgPlatformAutomationFramework.AssetManagement.page.AssetManagementLockerMandatory_page;
import com.mu_sigma.OrgPlatformAutomationFramework.AssetManagement.page.AssetManagementLocker_page;
import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;

public class AssetManagementAssetTypes_test extends TestBase{
	AssetManagementAssets_page AssetManagementAssets_pageObj;
	AssetManagementAssetTypes_page AssetManagementAssetTypes_pageObj;
	AssetManagementLevel_page AssetManagementLevel_pageObj;
	AssetManagementLocker_page AssetManagementLocker_pageObj;
	AssetManagementAssetsMandatory_page AssetManagementAssetsMandatory_pageObj;
	AssetManagementAssetTypesMandatory_page AssetManagementAssetTypesMandatory_pageObj;
	AssetManagementLevelMandatory_page AssetManagementLevelMandatory_pageObj;
	AssetManagementLockerMandatory_page AssetManagementLockerMandatory_pageObj;
	AssetManagementAssetReqMand_page AssetManagementAssetReqMand_pageObj;
	AssetManagementAssetReq_page AssetManagementAssetReq_pageObj;
	AssetManagementAssetProcess_page AssetManagementAssetProcess_pageObj;
	AssetManagementAssetProcessCon_page AssetManagementAssetProcessCon_pageObj;
	AssetManagementAssetAssign_page AssetManagementAssetAssign_pageObj;
	AssetManagementAssetAssignCon_page AssetManagementAssetAssignCon_pageObj;
	AssetManagementAssetRecover_page AssetManagementAssetRecover_pageObj;
	AssetManagementAssetRecoverCon_page AssetManagementAssetRecoverCon_pageObj;
	AssetManagementAssetReturn_page AssetManagementAssetReturn_pageObj;
	AssetManagementAssetReturnCon_page AssetManagementAssetReturnCon_pageObj;
	AssetManagementAssetClose_page AssetManagementAssetClose_pageObj;
	AssetManagementLessUsageAsset_page AssetManagementLessUsageAsset_pageObj;
	AssetManagementLessUsageAssetCon_page AssetManagementLessUsageAssetCon_pageObj;

	SoftAssert SoftAssertobj = new SoftAssert();

	@BeforeClass
	public void setUp() throws IOException, Exception {
		init("AssetManagement_Staging");
		AssetManagementAssets_pageObj = new AssetManagementAssets_page(driver);
		AssetManagementAssetTypes_pageObj = new AssetManagementAssetTypes_page(driver);
		AssetManagementLevel_pageObj = new AssetManagementLevel_page(driver);
		AssetManagementLocker_pageObj = new AssetManagementLocker_page(driver);
		AssetManagementAssetsMandatory_pageObj = new AssetManagementAssetsMandatory_page(driver);
		AssetManagementAssetTypesMandatory_pageObj = new AssetManagementAssetTypesMandatory_page(driver);
		AssetManagementLevelMandatory_pageObj = new AssetManagementLevelMandatory_page(driver);
		AssetManagementLockerMandatory_pageObj = new AssetManagementLockerMandatory_page(driver);
		AssetManagementAssetReqMand_pageObj = new AssetManagementAssetReqMand_page(driver);
		AssetManagementAssetReq_pageObj = new AssetManagementAssetReq_page(driver);
		AssetManagementAssetProcess_pageObj = new AssetManagementAssetProcess_page(driver);
		AssetManagementAssetProcessCon_pageObj = new AssetManagementAssetProcessCon_page(driver);
		AssetManagementAssetAssign_pageObj = new AssetManagementAssetAssign_page(driver);
		AssetManagementAssetAssignCon_pageObj = new AssetManagementAssetAssignCon_page(driver);
		AssetManagementAssetRecover_pageObj = new AssetManagementAssetRecover_page(driver);
		AssetManagementAssetRecoverCon_pageObj = new AssetManagementAssetRecoverCon_page(driver);
		AssetManagementAssetReturn_pageObj = new AssetManagementAssetReturn_page(driver);
		AssetManagementAssetReturnCon_pageObj = new AssetManagementAssetReturnCon_page(driver);
		AssetManagementAssetClose_pageObj = new AssetManagementAssetClose_page(driver);
		AssetManagementLessUsageAsset_pageObj = new AssetManagementLessUsageAsset_page(driver);
		AssetManagementLessUsageAssetCon_pageObj = new AssetManagementLessUsageAssetCon_page(driver);
		Runtime.getRuntime().exec(System.getProperty("user.dir") + "\\autoit\\Eraiah_Password.exe");
		Thread.sleep(8000);
	}
	// Creates a asset type

		@DataProvider(name = "assetTypeData")
		public String[][] getassetTypeData() {
			String[][] assetTypeData = getData("assetManagement.xlsx", "assettype");
			return assetTypeData;
		}

		@Test(priority = 4, dataProvider = "assetTypeData")
		public void assetTypeAdd(String assttype, String runmode) throws Exception {
			Thread.sleep(5000);
			AssetManagementAssetTypes_pageObj.addAssetType(assttype);
			Thread.sleep(2000);
			SoftAssertobj.assertTrue(AssetManagementAssetTypes_pageObj.assetTypeCreated(),"asset type has not been created");

			SoftAssertobj.assertAll();
			Thread.sleep(2000);
			AssetManagementAssets_pageObj.assetLogOut();
		}
	
}
