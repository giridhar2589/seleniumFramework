package com.mu_sigma.OrgPlatformAutomationFramework.muCab.test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;
import com.mu_sigma.OrgPlatformAutomationFramework.muCab.page.MuCabHome_page;

public class MuCabAllocation_Test extends TestBase{

	private static final Logger MuCabAllocation_Test_pageLog = LogManager.getLogger(MuCabAllocation_Test.class.getName());
	MuCabHome_page MuCabHome_pageObj;

	TestBase objTestBase;
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
		MuCabAllocation_Test_pageLog.info("Filled the Username and password");
		Thread.sleep(2000);
		Assert.assertEquals((MuCabHome_pageObj.pass()), "Book Your Ride");
		MuCabAllocation_Test_pageLog.info("Enter Into the home page");

	}

	@Test(priority = 1)
	public void EnterIntoAllocation() throws Exception {
		Thread.sleep(2000);
		MuCabHome_pageObj.EnterIntoAllcation();
		MuCabAllocation_Test_pageLog.info("Enter Into the Allocation Tab");

	}

	@Test(priority = 2)
	public void Modify_allocation_move_To() throws Exception {
		Thread.sleep(2000);
		Select  sel = new Select (driver.findElement(By.id("dddeparture")));
		sel.selectByValue(propetiesOverloadObj.getProperty("1130PMSlot"));
		Thread.sleep(2000);
		Select sel1 = new Select (driver.findElement(By.id("ddsource")));
		Thread.sleep(2000);
		sel1.selectByVisibleText(propetiesOverloadObj.getProperty("Source"));
		MuCabHome_pageObj.EnterRoasterDetails();
		Thread.sleep(3000);
		MuCabHome_pageObj.GenerateAlloaction();
		Thread.sleep(3000);
		MuCabHome_pageObj.SelectRequest();
		Select sel2 = new Select (driver.findElement(By.id("ddtrip")));
		Thread.sleep(2000);
		//sel2.selectByValue(By.xpath("//option[contains(text(),'Cab 01')]));"
		sel2.selectByIndex(1);
		Thread.sleep(10000);
		MuCabHome_pageObj.btn_Move();
		Thread.sleep(8000);
		if (driver.findElement(By.xpath("(//label[contains(text(),'Requests moved')])[1]")).equals("Requests moved")){
			Assert.assertTrue(true);

		}
	}


	@Test(priority = 3)
	public void Modify_allocation_Create_new_Cab() throws Exception {
		Thread.sleep(2000);
		MuCabHome_pageObj.SelectRequest();
		Thread.sleep(2000);
		MuCabHome_pageObj.btn_Create_new_cab();
		Thread.sleep(2000);
		Select sel = new Select (driver.findElement(By.id("ddroutelist")));
		sel.selectByVisibleText(propetiesOverloadObj.getProperty("TTRoute"));
		Thread.sleep(2000);
		Select sel1 = new Select(driver.findElement(By.id("ddvehiclelist")));
		sel1.selectByVisibleText(propetiesOverloadObj.getProperty("LongRoute"));
		MuCabHome_pageObj.btn_save();
		Thread.sleep(10000);
		if (driver.findElement(By.xpath("(//label[contains(text(),'New Cab created')])[1]")).equals("New Cab created")){
			Assert.assertTrue(true);
		} 
	}


	@Test(priority = 4)
	public void Save_allocation_Create_new_Cab() throws Exception {
		Thread.sleep(5000);
		MuCabHome_pageObj.btn_Save_allocation();
		driver.switchTo().alert().accept();
		//waitForElement(MuCabHome_pageObj.btn_Send_Notification,4500);
		Thread.sleep(10000);
		if (driver.findElement(By.xpath("(//label[contains(text(),'Allocation Saved')])[1]")).equals("Allocation Saved")){
			Assert.assertTrue(true);
		}
	}

	@Test(priority = 5)
	public void Send_notifications() throws Exception {
		((WebElement) MuCabHome_pageObj.btn_Send_Notification).click();
		driver.switchTo().alert().accept();

	}

	@Test(priority = 6)
	public void DownLoadTripSheet() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(MuCabHome_pageObj.btn_DownLoad_TripSheet));
		element.click();
		//MuCabHome_pageObj.btn_DownLoad_TripSheet.click();
		if (driver.findElement(By.xpath("(//label[contains(text(),'Please download the trip sheet for details')])[1]")).equals("Please download the trip sheet for details")){
			Assert.assertTrue(true);
		}

	}

}






