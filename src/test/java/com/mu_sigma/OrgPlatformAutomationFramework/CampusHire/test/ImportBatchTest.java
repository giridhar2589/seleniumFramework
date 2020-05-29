package com.mu_sigma.OrgPlatformAutomationFramework.CampusHire.test;
import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.mu_sigma.OrgPlatformAutomationFramework.CampusHire.Page.ImportBatchPage;
import com.mu_sigma.OrgPlatformAutomationFramework.Awards.Page.AwardsPage;
import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;



public class ImportBatchTest  extends TestBase {

	AwardsPage AwardsPageObj;
	ImportBatchPage ImportBatchPageObj;

	SoftAssert s_assert = new SoftAssert();



	@BeforeClass
	public void setUp() throws IOException, Exception {
		init("Campus_UAT");
		AwardsPageObj = new AwardsPage(driver);
		ImportBatchPageObj = new ImportBatchPage(driver);
		Runtime.getRuntime().exec(System.getProperty("user.dir") + "\\autoit\\Authentication_Giridhar.exe");
		Thread.sleep(5000);
		loadProperties("Campus.properties");
	}

	@Test(priority=1)
	public void Impersitionation() throws Exception{
		Thread.sleep(3000);
		ImportBatchPageObj.Impersitionation();

	}


	@Test(priority=2)
	public void EnterIntoBatchDetails() throws Exception{
		Thread.sleep(3000);
		ImportBatchPageObj.Enter_Batch_Details_Tab();
		Thread.sleep(3000);
		//ImportBatchPageObj.Add_Batch(propetiesOverloadObj.getProperty("BatchName"),propetiesOverloadObj.getProperty("BatchDate"));
		//	ImportBatchPageObj.Add_Batch_1(propetiesOverloadObj.getProperty("BatchName"));
	}

	/*@Test(priority=3)
	public void ImportDetails() throws InterruptedException, IOException{
		Thread.sleep(3000);
		//ImportBatchPageObj.ViewDetails_btn.click();
		Thread.sleep(2000);
		ImportBatchPageObj.Import_Data();
		//ImportBatchPageObj.Import_csv_Groups();
		//ImportBatchPageObj.Import_CsV_CandidateDetails();
		ImportBatchPageObj.ADD_GA_Panel_Member(propetiesOverloadObj.getProperty("EmpID"));
	}*/


	/*@Test(priority=4)
	public void ADD_GA_Panel_Member() throws InterruptedException, IOException{
		Thread.sleep(3000);
		//ImportBatchPageObj.ADD_GA_Panel_Member(propetiesOverloadObj.getProperty("EmpID"));
	}*/

	/*@Test(priority=5)
	public void Provide_Group_assesment() throws InterruptedException, IOException{
		Thread.sleep(3000);
		ImportBatchPageObj.Provide_Group_assesment();
		Thread.sleep(9000);
		 driver.findElement(By.xpath("//tr[3]/td/select")).click();
		Select sel = new Select(driver.findElement(By.xpath("//tr[3]/td/select")));
		sel.selectByIndex(1);
	}*/

	
	
	@Test(priority=5)
	public void Provide_FeedBack() throws InterruptedException, IOException{
		Thread.sleep(3000);
		//ImportBatchPageObj.Provide_FeedBack(propetiesOverloadObj.getProperty("Comments"));
		
	}
	
	
	
	@Test(priority=6)
	public void Generate_ID_Hired_candidate_details() throws InterruptedException, IOException{
		Thread.sleep(3000);
		ImportBatchPageObj.GenerateID();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	





}
