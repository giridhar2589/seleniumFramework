package com.mu_sigma.OrgPlatformAutomationFramework.muSocial.test;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;
import com.mu_sigma.OrgPlatformAutomationFramework.muSocial.page.muSocial_Page;

public class Add_Content extends TestBase {
	SoftAssert asert = new SoftAssert();
	muSocial_Page muSocialObj;

	@BeforeClass
	public void setup() throws IOException, Exception {
		init("muSocial_Staging1");
		muSocialObj = new muSocial_Page(driver);
		loadProperties("muSocial.properties");
	}
	@Test(priority=1)
	public void Login_page() throws InterruptedException{
		muSocialObj.Login_page(propetiesOverloadObj.getProperty("userName"),propetiesOverloadObj.getProperty("Password"));
		asert.assertEquals(true, muSocialObj.isElementPresent());
		asert.assertAll();
	}

	@Test(priority=2)
	public void Impersonation() throws InterruptedException{
		muSocialObj.impersonation(propetiesOverloadObj.getProperty("EmpName"));

	}

	@Test(priority=3)
	public void Enter_Into_MuSocial()throws InterruptedException{
		muSocialObj.Enter_Into_MuSocial();
		asert.assertEquals(true, muSocialObj.is_elementpresent());
		asert.assertAll();
	}

	@Test(priority=4)
	public void Click_On_Content()throws InterruptedException{
		muSocialObj.Click_On_Content(propetiesOverloadObj.getProperty("ContentTitle"),propetiesOverloadObj.getProperty("ContentDescription"),
				propetiesOverloadObj.getProperty("Content_URL"),
				propetiesOverloadObj.getProperty("Fb_URL"),propetiesOverloadObj.getProperty("Insta_Url"),propetiesOverloadObj.getProperty("Twitter_URL"));
		Thread.sleep(2000);
		muSocialObj.uploadImage(propetiesOverloadObj.getProperty("ImageLocation"),propetiesOverloadObj.getProperty("folderName"), propetiesOverloadObj.getProperty("Image1"));
		Thread.sleep(3000);
		muSocialObj.click_save();


	}

}
