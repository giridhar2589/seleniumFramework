package com.mu_sigma.OrgPlatformAutomationFramework.muCab.test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;
import com.mu_sigma.OrgPlatformAutomationFramework.muCab.page.MuCabHome_page;

public class MuCabVehicalDetails_Test  extends TestBase{

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
	public void MuCabVehicalDetailsPage() throws Exception {
		MuCabHome_pageObj.Enter_Into_Vehical_details();

	}


	@Test(priority = 2)
	public void Add_vehical_details() throws Exception {
		MuCabHome_pageObj.Add_vehical();

	}


	@Test(priority = 3)
	public void Enter_Vehical_Details_Vehical_Type() throws Exception {
		Thread.sleep(3000);
		MuCabHome_pageObj.Enter_Vehical_Details_Vehical_Type(propetiesOverloadObj.getProperty("VehicalName"), propetiesOverloadObj.getProperty("CarType"), propetiesOverloadObj.getProperty("RegistrationNumber"), propetiesOverloadObj.getProperty("VendorType"), propetiesOverloadObj.getProperty("Location"));
	}


	@Test(priority = 4)
	public void Vehicle_Document_Tenure_Details() throws Exception {
		Thread.sleep(3000);
		//MuCabHome_pageObj.Vehicle_Document_Tenure_Details(propetiesOverloadObj.getProperty("IDate"), propetiesOverloadObj.getProperty("EDate"),propetiesOverloadObj.getProperty("IDate"), propetiesOverloadObj.getProperty("EDate"),propetiesOverloadObj.getProperty("IDate"), propetiesOverloadObj.getProperty("EDate"),propetiesOverloadObj.getProperty("IDate"), propetiesOverloadObj.getProperty("EDate"),propetiesOverloadObj.getProperty("IDate"), propetiesOverloadObj.getProperty("EDate"));
		MuCabHome_pageObj.Document_Tenure_Details();
	}



	@Test(priority = 5)
	public void Driver_Deatils() throws Exception {
		MuCabHome_pageObj.Driver_details(propetiesOverloadObj.getProperty("DriverName1"),propetiesOverloadObj.getProperty("DriverFatherName1"),propetiesOverloadObj.getProperty("EduDetails"),propetiesOverloadObj.getProperty("Status"),propetiesOverloadObj.getProperty("MobileNumber"),propetiesOverloadObj.getProperty("Taddress"),propetiesOverloadObj.getProperty("Paddress"));

	}
	
	
	@Test(priority = 6)
	public void Driver_Professional_Info() throws Exception {
		MuCabHome_pageObj.Driver_Professional_Info(propetiesOverloadObj.getProperty("badgeNum"),
				propetiesOverloadObj.getProperty("LiceNum"),
				propetiesOverloadObj.getProperty("PerviousCmpyName1"),
				propetiesOverloadObj.getProperty("TtlExperience1"),
				propetiesOverloadObj.getProperty("Offence"),
				propetiesOverloadObj.getProperty("Upload"));

		
		if (driver.findElement(By.xpath("//label[contains(text(),'Cab and driver details added successfully')]")).equals("Cab and driver details added successfully")){
			softAssert.assertTrue(true);

		}
		softAssert.assertAll();
	}




















}
