package com.mu_sigma.OrgPlatformAutomationFramework.muCab.test;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;
import com.mu_sigma.OrgPlatformAutomationFramework.muCab.page.MuCabHome_page;

public class MuCabAddorEditEmployeeRequest_Test   extends TestBase{

	private static final Logger MuCabAddorEditEmployeeRequest_Test_pageLog = LogManager.getLogger(MuCabAddorEditEmployeeRequest_Test.class.getName());
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
		MuCabAddorEditEmployeeRequest_Test_pageLog.info("Clicked on submit button");
		Thread.sleep(2000);
		Assert.assertEquals((MuCabHome_pageObj.pass()), "Book Your Ride");
		Thread.sleep(2000);
		MuCabAddorEditEmployeeRequest_Test_pageLog.info("In Home Page");
	}


	@DataProvider(name = "AddNewRequestEntirePeriod")
	public String[][] EmpID() {
		String[][] loginData = getData("muCAB.xlsx", "Sheet5");
		return loginData;
	}


	@Test(dataProvider = "AddNewRequestEntirePeriod",priority = 1)
	public void Add_requests_for_entire_booking_period(String Emp) throws Exception {
		Thread.sleep(2000);
		MuCabHome_pageObj.searchEmpdId(Emp);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='EmployeeSelected"+Emp+"']")).click();
		MuCabHome_pageObj.Click_button_CancelpopUP();
		Select sel = new Select(driver.findElement(By.id("ddslot")));
		sel.selectByValue(propetiesOverloadObj.getProperty("1130PMSlot"));
		MuCabHome_pageObj.MuCabHome_pageLog.info("Time slot is selected");
		Thread.sleep(2000);
		Select sel1 = new Select(driver.findElement(By.id("ddlocation")));
		sel1.selectByVisibleText(propetiesOverloadObj.getProperty("Source"));
		Thread.sleep(2000);
		MuCabHome_pageObj.MuCabHome_pageLog.info("Source has been selected");
		MuCabHome_pageObj.Checkbox_EntireBookingperiod();
		MuCabHome_pageObj.MuCabHome_pageLog.info("Check box is selected for entire booking period");
		MuCabHome_pageObj.Btn_AddOrEditRequest();
		MuCabHome_pageObj.MuCabHome_pageLog.info("AddOrEditRequest is clicked");
		driver.switchTo().alert().accept();
		Thread.sleep(4000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(2000);
		WebElement Element = driver.findElement(By.xpath("//td[1]/div/label[contains(text(),'"+Emp+"')]"));

		//This will scroll the page till the element is found		
		js.executeScript("arguments[0].scrollIntoView();", Element);
		Assert.assertTrue(Element.isDisplayed());
	}

	@DataProvider(name = "AddNewRequest")
	public String[][] EmpID1() {
		String[][] loginData = getData("muCAB.xlsx", "Sheet6");
		return loginData;
	}


	@Test(dataProvider = "AddNewRequest",priority = 2)
	public void Add_requests_For_present_day(String Emp1) throws Exception {
		Thread.sleep(2000);
		MuCabHome_pageObj.searchEmpdId(Emp1);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='EmployeeSelected"+Emp1+"']")).click();
		MuCabHome_pageObj.Click_button_CancelpopUP();
		Select sel = new Select(driver.findElement(By.id("ddslot")));
		sel.selectByValue(propetiesOverloadObj.getProperty("10PMSlot"));
		MuCabHome_pageObj.MuCabHome_pageLog.info("Entered slot");
		Thread.sleep(2000);
		Select sel1 = new Select(driver.findElement(By.id("ddlocation")));
		sel1.selectByVisibleText(propetiesOverloadObj.getProperty("Source"));
		MuCabHome_pageObj.MuCabHome_pageLog.info("Enter the source");
		MuCabHome_pageObj.Btn_AddOrEditRequest();
		driver.switchTo().alert().accept();
		Thread.sleep(4000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(By.xpath("//td[1]/div/label[contains(text(),'"+Emp1+"')]"));
		Thread.sleep(4000);
		//This will scroll the page till the element is found		
		js.executeScript("arguments[0].scrollIntoView();", Element);
		Assert.assertTrue(Element.isDisplayed());
		System.err.println(Element);
	}


	@DataProvider(name = "UpdateDestination")
	public String[][] Destination() {
		String[][] loginData = getData("muCAB.xlsx", "Sheet7");
		return loginData;
	}
	@Test(dataProvider = "UpdateDestination",priority = 3)
	public void Update_Employee_Destination(String Emp, String  Destination) throws Exception{
		Thread.sleep(2000);
		MuCabHome_pageObj.UpdateEmpdAddress(Emp,Destination);
		MuCabAddorEditEmployeeRequest_Test_pageLog.info("Updated Employee address");
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
	}

	/*@Test (priority=4)
	public void Logout() throws InterruptedException{
		Thread.sleep(3000);
		MuCabHome_pageObj.logout();

	}*/



}
