package com.mu_sigma.OrgPlatformAutomationFramework.muSocial.test;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;
import com.mu_sigma.OrgPlatformAutomationFramework.muSocial.page.muSocial_Page;

public class Activate_slide_test extends TestBase {

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
	asert.assertEquals(true, muSocialObj.isElementpresent());
	 asert.assertAll();
}

@Test(priority=3)
public void Enter_Into_MuSocial()throws InterruptedException{
	muSocialObj.Enter_Into_MuSocial();
	asert.assertEquals(true, muSocialObj.is_elementpresent());
	 asert.assertAll();

}
@Test(priority=6)
public void slideInHistoryTab() throws InterruptedException{
	muSocialObj.Slide_InHistoryTab();
	asert.assertEquals(muSocialObj.SlideMovedto_Current(), "The slide has been moved to 'Current' tab");
	asert.assertAll();
 }


}

