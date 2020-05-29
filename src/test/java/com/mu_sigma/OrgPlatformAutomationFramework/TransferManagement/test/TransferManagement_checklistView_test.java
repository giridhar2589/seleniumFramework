package com.mu_sigma.OrgPlatformAutomationFramework.TransferManagement.test;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;
import com.mu_sigma.OrgPlatformAutomationFramework.transferManagement.page.TransferManagement_page;

public class TransferManagement_checklistView_test extends TestBase {
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
	public void impersonateChecklist(){
		TransferManagement_pageObj.impersonateEmployee(propetiesOverloadObj.getProperty("checklist"));
		softAssertObj.assertTrue(TransferManagement_pageObj.getDesignation_text().contains("Executive"));
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
		softAssertObj.assertTrue(TransferManagement_pageObj.getPendingApprovalFrom_text().contains("Pending Checklist Approval"));
	}
	
	@DataProvider(name = "checklistDetails")
	public String[][] getchecklistDetails(){
		String[][] getchecklistData = getData("transferManagement.xlsx", "checklistdetails");
		return getchecklistData;
	}
	
	@Test(priority = 4 ,dataProvider="checklistDetails")
	public void checklistApproval(String checklistName,String buttonName,String indexvalue,String iteminput,String commentsinput) throws Exception{
		TransferManagement_pageObj.clickOnChecklist(checklistName, buttonName,indexvalue,iteminput,commentsinput);
		Thread.sleep(2000);
		softAssertObj.assertEquals(TransferManagement_pageObj.successMessage_individualChecklistMarkedComplete_text(), "Checklist has been marked as complete");
	}
	
	
	@Test(priority =5)
	public void logout() throws Exception{
		TransferManagement_pageObj.logout();
		/*softAssertObj.assertEquals(TransferManagement_pageObj.getAlertForLogout(), "Logout successful");
		softAssertObj.assertAll();*/
	}
	

}
