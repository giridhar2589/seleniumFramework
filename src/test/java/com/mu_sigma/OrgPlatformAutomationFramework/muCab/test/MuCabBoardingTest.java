package com.mu_sigma.OrgPlatformAutomationFramework.muCab.test;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;
import com.mu_sigma.OrgPlatformAutomationFramework.muCab.page.MuCabHome_page;

public class MuCabBoardingTest  extends TestBase{

	private static final Logger MuCabBoardingTest_pageLog = LogManager.getLogger(MuCabHome_test.class.getName());
	MuCabHome_page MuCabHome_pageObj;

	TestBase objTestBase;
	SoftAssert softAssert;

	@BeforeClass
	public void setUp() throws Exception {
		init("MuCab_Staging");
		MuCabHome_pageObj = new MuCabHome_page(driver);
		softAssert = new SoftAssert();
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
		MuCabBoardingTest_pageLog.info("Filled the Username and password");

		Thread.sleep(2000);
		softAssert.assertEquals((MuCabHome_pageObj.pass()), "Book Your Ride");
		MuCabBoardingTest_pageLog.info("Enter into the home page");
		softAssert.assertAll();
	}

	@Test(priority = 1)
	public void EnterIntoBoardingPage() throws Exception {
		Thread.sleep(2000);
		((WebElement) MuCabHome_pageObj.Boarding_tab).click();
		MuCabBoardingTest_pageLog.info("ENtered into boarding page");
		//	MuCabHome_pageObj.Source.click();
		Select sel = new Select (driver.findElement(By.id("source")));
		Thread.sleep(2000);
		sel.selectByVisibleText("ITPL");
		Select sel1 = new Select (driver.findElement(By.id("slot")));
		sel1.selectByValue(propetiesOverloadObj.getProperty("1130PMSlot"));
		//sel1.selectByVisibleText("");
		Thread.sleep(8000);
		if (driver.findElement(By.xpath("(//td/h3[contains(text(),'Boarding Changes')])[2]")).equals("Boarding Changes")){
			softAssert.assertTrue(true);
		}
		softAssert.assertAll();
	}
	@Test(priority=2)
	public void Add_Walk_In() throws Exception{
		Thread.sleep(2000);
		MuCabHome_pageObj.TextBob_EmpID();
		Thread.sleep(3000);
		((WebElement) MuCabHome_pageObj.TextBob_EmpID).clear();
		Thread.sleep(2000);
		((WebElement) MuCabHome_pageObj.TextBob_EmpID).sendKeys(propetiesOverloadObj.getProperty("EmpID"));
		Thread.sleep(2000);
		((WebElement) MuCabHome_pageObj.SearchIcon_EmpID).click();
		Thread.sleep(2000);
		((WebElement) MuCabHome_pageObj.Btn_AddSelected).click();
		Thread.sleep(2000);
		((WebElement) MuCabHome_pageObj.CancelPopUp_EmpID).click();
		Select sel = new Select (driver.findElement(By.id("TripWalkin")));
		Thread.sleep(2000);
		sel.selectByIndex(1);
		Thread.sleep(2000);
		((WebElement) MuCabHome_pageObj.Btn_add).click();

		if (driver.findElement(By.xpath("//label[contains(text(),'Employees added successfully')]")).equals("Employees added successfully")){
			softAssert.assertTrue(true);

		}
		softAssert.assertAll();
	}


	@Test(priority=3)
	public void Change_Cab() throws Exception{
		Thread.sleep(2000);
		MuCabHome_pageObj.SelectRequest_Single();
		Select sel = new Select (driver.findElement(By.id("Trip")));
		Thread.sleep(2000);
		sel.selectByIndex(1);
		Thread.sleep(2000);
		MuCabHome_pageObj.btn_Move_cab();
		if (driver.findElement(By.xpath("//label[contains(text(),'requests merged')]")).equals("requests merged")){
			softAssert.assertTrue(true);

		}
		softAssert.assertAll();
	}

	@Test(priority=4)
	public void Split_trip() throws Exception{
		Thread.sleep(2000);
		MuCabHome_pageObj.SelectRequest_multiple();
		((WebElement) MuCabHome_pageObj.btn_Create_new_trip).click();
		Select sel = new Select (driver.findElement(By.id("Capacity")));
		Thread.sleep(2000);
		sel.selectByVisibleText(propetiesOverloadObj.getProperty("LongRoute"));
		Thread.sleep(2000);
		Select sel1 = new Select (driver.findElement(By.id("RouteList")));
		Thread.sleep(2000);
		sel1.selectByVisibleText(propetiesOverloadObj.getProperty("Route"));
		Thread.sleep(2000);
		((WebElement) MuCabHome_pageObj.btn_Save).click();
		if (driver.findElement(By.xpath("//label[contains(text(),'requests moved to new trip')]")).equals("requests moved to new trip")){
			softAssert.assertTrue(true);

		}
		softAssert.assertAll();
	}
	@Test(priority=5)
	public void Mark_Attendance() throws Exception{
		Thread.sleep(3000);
		MuCabHome_pageObj.btn_yes();
		Thread.sleep(2000);
		MuCabHome_pageObj.btn_Save_boarding_status();
		Thread.sleep(2000);
		if (driver.findElement(By.xpath("//label[contains(text(),'Boarding updates saved successfully')]")).equals("Boarding updates saved successfully")){
			softAssert.assertTrue(true);

		}
		softAssert.assertAll();

	}


}


