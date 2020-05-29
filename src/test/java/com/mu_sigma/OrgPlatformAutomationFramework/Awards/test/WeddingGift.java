package com.mu_sigma.OrgPlatformAutomationFramework.Awards.test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.mu_sigma.OrgPlatformAutomationFramework.Awards.Page.AwardsPage;
import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;




public class WeddingGift   extends TestBase {

	AwardsPage AwardsPageObj;

	SoftAssert s_assert = new SoftAssert();


	@BeforeClass
	public void setUp() throws IOException, Exception {
		init("Awards_UAT");
		AwardsPageObj = new AwardsPage(driver);
		Runtime.getRuntime().exec(System.getProperty("user.dir") + "\\autoit\\Authentication_Giridhar.exe");
		Thread.sleep(5000);
		loadProperties("Awards.properties");
	}

	@Test(priority=1)
	public void Impersitionation() throws Exception{
		Thread.sleep(3000);
		AwardsPageObj.Impersitionation();
		AwardsPageObj.Enter_Into_Award_request();
		//AwardsPageObj.Create_award_request();
	}

	@Test(priority=2)
	public void Enter_Into_Award_request() throws Exception{
		AwardsPageObj.Enter_Into_Award_request();

	}

	@Test(priority=3)
	public void Create_award_request() throws Exception{
		AwardsPageObj.Create_award_request();
	}

	@Test(priority=4)
	public void WeddingGift() throws Exception{
		Thread.sleep(4000);
		AwardsPageObj.select_Empolyee(propetiesOverloadObj.getProperty("EmpId"));
		AwardsPageObj.select_Awards_WedingGift(propetiesOverloadObj.getProperty("AwardType_WeddingGift"));
		AwardsPageObj.Enter_Citation(propetiesOverloadObj.getProperty("WeddingCitation"));
		Thread.sleep(3000);
		AwardsPageObj.click_Submit_request_btn();
		s_assert.assertEquals(driver.findElements(By.xpath("//tbody/tr[2]/td[4]")),"Wedding Gift");
		s_assert.assertTrue(true);


	}

}
