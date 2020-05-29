package com.mu_sigma.OrgPlatformAutomationFramework.muCab.test;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;
import com.mu_sigma.OrgPlatformAutomationFramework.muCab.page.MuCabHome_page;

public class MuCabHome_test  extends TestBase{

	private static final Logger MuCabHome_test_TestLog = LogManager.getLogger(MuCabHome_test.class.getName());
	MuCabHome_page MuCabHome_pageObj;

	@BeforeClass
	public void setUp() throws Exception {
		init("MuCab_Staging");
		MuCabHome_pageObj = new MuCabHome_page(driver);
		Thread.sleep(8000);
		loadProperties("MuCab.properties");
	}

	@Test(priority = 0)
	public void Blanck_TomuCab() throws Exception {
		Thread.sleep(5000);
		MuCabHome_pageObj.Enter_Into_Application();
		MuCabHome_test_TestLog.info("Clicked on submit button");
		Thread.sleep(5000);
		String  message = driver.switchTo().alert().getText();	
		System.out.println(message);
		Thread.sleep(5000);
		Assert.assertEquals(message, "UserName or password entered are incorrect !!");
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		MuCabHome_test_TestLog.info("Accepting the alert pop-up");
		System.out.println(message);
	}

	@DataProvider(name = "InvalidUserPasstdata")
	public String[][] getInvalidUserName_ValidPasswordLogInData() {
		String[][] loginData = getData("muCAB.xlsx", "Sheet1");
		return loginData;
	}


	@Test(dataProvider = "InvalidUserPasstdata", priority = 1)
	public void getInvalidUserName_ValidPassword_ToMuCab(String uname, String pwd) throws Exception {

		Thread.sleep(5000);
		MuCabHome_pageObj.fillLoginDetails(uname, pwd);
		Thread.sleep(5000);
		String  message = driver.switchTo().alert().getText();	
		System.out.println(message);
		Thread.sleep(5000);
		Assert.assertEquals(message, "UserName or password entered are incorrect !!");
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		MuCabHome_test_TestLog.info("Accepting the alert pop-up");
		System.out.println(message);
		Thread.sleep(9000);
	}
	@DataProvider(name = "InvalidPassTestdata")
	public String[][] getInvalidLogInData() {
		String[][] loginData = getData("muCAB.xlsx", "Sheet2");
		return loginData;
	}

	@Test(dataProvider = "InvalidPassTestdata", priority = 2)
	public void getvalidUserName_InValidPassword_ToMuCab(String uname, String pwd) throws Exception {

		Thread.sleep(5000);
		MuCabHome_pageObj.fillLoginDetails(uname, pwd);
		Thread.sleep(5000);
		String  message = driver.switchTo().alert().getText();	
		System.out.println(message);
		Thread.sleep(5000);
		Assert.assertEquals(message, "UserName or password entered are incorrect !!");
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		MuCabHome_test_TestLog.info("Accepting the alert pop-up");
		System.out.println(message);
		Thread.sleep(9000);
	}
	@DataProvider(name = "validloginTestdata")
	public String[][] getvalidLogInData() {
		String[][] loginData = getData("muCAB.xlsx", "Sheet3");
		return loginData;
	}

	@Test(dataProvider = "validloginTestdata", priority =3)
	public void LoginTomuCab(String uname, String pwd) throws Exception {
		MuCabHome_pageObj.fillLoginDetails(uname, pwd);
		Thread.sleep(2000);
		MuCabHome_test_TestLog.info("Entered into Home page");
		Assert.assertEquals((MuCabHome_pageObj.pass()), "Book Your Ride");
		Thread.sleep(2000);
		MuCabHome_pageObj.logout();
		MuCabHome_test_TestLog.info("Clicking of logoutbutton");
	}


}
