package com.mu_sigma.OrgPlatformAutomationFramework.muSocial.test;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;
import com.mu_sigma.OrgPlatformAutomationFramework.muSocial.page.muSocial_Page;

public class Login_test extends TestBase {
	
	SoftAssert asert = new SoftAssert();
	muSocial_Page muSocialObj;
	
	@BeforeClass
	public void setup() throws IOException, Exception {
		init("muSocial_Staging1");
		muSocialObj = new muSocial_Page(driver);
		loadProperties("muSocial.properties");
	}
	
	@Test(priority=1)
	public void Login_Invalid_userName_Invalid_Password() throws InterruptedException{
		muSocialObj.Login_Invalid_userName_Invalid_Password(propetiesOverloadObj.getProperty("InvaliduserName"),propetiesOverloadObj.getProperty("InvalidPassword"));
		asert.assertEquals(muSocialObj.InvalidCredentials_message(), "Invalid credentials.");
		asert.assertAll();}
	
	@Test(priority=2)
	public void Login_Invalid_userName_Valid_Password() throws InterruptedException{
		muSocialObj.Login_Invalid_userName_Valid_Password(propetiesOverloadObj.getProperty("InvaliduserName"),propetiesOverloadObj.getProperty("Password"));
		asert.assertEquals(muSocialObj.InvalidUsername_message(), "Invalid credentials.");
		asert.assertAll();
	}
	
	@Test(priority=3)
	public void Login_Valid_userName_InValid_Password() throws InterruptedException{
		muSocialObj.Login_Valid_userName_InValid_Password(propetiesOverloadObj.getProperty("userName"),propetiesOverloadObj.getProperty("InvalidPassword"));
		asert.assertEquals(muSocialObj.InvalidPassword_message(), "Invalid credentials.");
		asert.assertAll();
	}
	
	@Test(priority=4)
	public void Login_Valid_userName_Valid_Password() throws InterruptedException{
		muSocialObj.Login_page(propetiesOverloadObj.getProperty("userName"),propetiesOverloadObj.getProperty("Password"));
		 asert.assertEquals(true, muSocialObj.isElementPresent());
		 asert.assertAll();
	}
	

}
