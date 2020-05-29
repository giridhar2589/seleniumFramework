package com.mu_sigma.OrgPlatformAutomationFramework.muCab.test;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;
import com.mu_sigma.OrgPlatformAutomationFramework.muCab.page.MuCabHome_page;

public class MuCabRequests_Test   extends TestBase{

	private static final Logger MuCabRequests_Test_pageLog = LogManager.getLogger(MuCabRequests_Test.class.getName());
	MuCabHome_page MuCabHome_pageObj;

	@BeforeClass
	public void setUp() throws Exception {
		init("MuCab_Staging");
		MuCabHome_pageObj = new MuCabHome_page(driver);
		Thread.sleep(8000);
		loadProperties("MuCab.properties");
	}

	@DataProvider(name = "validloginTestdata")
	public String[][] getvalidLogInData() {
		String[][] loginData = getData("muCAB.xlsx", "Sheet3");
		return loginData;
	}

	@Test(dataProvider = "validloginTestdata", priority = 0)
	public void LoginTomuCab(String uname, String pwd) throws Exception {
		MuCabHome_pageObj.fillLoginDetails(uname, pwd);
		MuCabRequests_Test_pageLog.info("Filled the Username");
		Thread.sleep(2000);
		Assert.assertEquals((MuCabHome_pageObj.pass()), "Book Your Ride");
		Thread.sleep(2000);
		MuCabRequests_Test_pageLog.info("In home Page");
	}

	@Test(priority = 1)
	public void Modify_Requests() throws Exception {
		MuCabHome_pageObj.Click_modifybutton();
		MuCabRequests_Test_pageLog.info("Clicked modify button");
		Thread.sleep(2000);
		Select  sel = new Select (driver.findElement(By.id("Editdeparture")));
		sel.selectByValue(propetiesOverloadObj.getProperty("1030PMSlot"));
		MuCabHome_pageObj.Click_button_save();
		MuCabRequests_Test_pageLog.info("Clicked save button ");
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		MuCabRequests_Test_pageLog.info("clicked on save button of alert pop-up");

	}

	@Test(priority = 2)
	public void Cancel_Requests() throws Exception {
		MuCabHome_pageObj.Click_button_Cancel();
		MuCabRequests_Test_pageLog.info("clicked on cancel button");
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		MuCabHome_pageObj.logout();
		MuCabRequests_Test_pageLog.info("Clicked on logout options");
	}

}
