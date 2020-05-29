package com.mu_sigma.OrgPlatformAutomationFramework.EmployeeLetters.test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.mu_sigma.OrgPlatformAutomationFramework.EmployeeLetters.page.EmployeeLetters_Page;
import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;;




public class NOC_Test extends TestBase {

	EmployeeLetters_Page EmployeeLetters_Page_Obj;

	SoftAssert s_assert = new SoftAssert();

	@BeforeClass
	public void setUp() throws IOException, Exception {
		init("EmployeeLetters_UAT");
		EmployeeLetters_Page_Obj = new EmployeeLetters_Page(driver);
		Runtime.getRuntime().exec(System.getProperty("user.dir") + "\\autoit\\Authentication_Giridhar.exe");
		Thread.sleep(5000);
		loadProperties("EmployeeLetters.properties");
	}

	@Test(priority=1)
	public void EnterHomeTab() throws Exception{
		EmployeeLetters_Page_Obj.Enter_Home_tab();
		Thread.sleep(3000);
	}

	@Test(priority=2)
	public void Enter_EmployeeProofletter() throws Exception{
		EmployeeLetters_Page_Obj.Enter_NOC_tab();
		Thread.sleep(3000);


	}

	@Test(priority=3)
	public void Visa_Application_Approve() throws Exception{
		Select sel = new Select(driver.findElement(By.xpath("//select[@label='NOCReason']")));
		sel.selectByVisibleText(propetiesOverloadObj.getProperty("Options14"));
		Thread.sleep(2000);
		EmployeeLetters_Page_Obj.dates(propetiesOverloadObj.getProperty("FromDate"), propetiesOverloadObj.getProperty("ToDate"));
		EmployeeLetters_Page_Obj.SearchIcon_CountryName();
		EmployeeLetters_Page_Obj.CountryName(propetiesOverloadObj.getProperty("CountryName"));
		Thread.sleep(3000);

	}

	@Test(priority=4)
	public void Visa_Application_Reject() throws Exception{
		Thread.sleep(3000);
		EmployeeLetters_Page_Obj.Enter_Home_tab();
		Thread.sleep(3000);
		EmployeeLetters_Page_Obj.Enter_NOC_tab();
		Select sel = new Select(driver.findElement(By.xpath("//select[@label='NOCReason']")));
		sel.selectByVisibleText(propetiesOverloadObj.getProperty("Options14"));
		Thread.sleep(2000);
		EmployeeLetters_Page_Obj.dates(propetiesOverloadObj.getProperty("FromDate"), propetiesOverloadObj.getProperty("ToDate"));
		EmployeeLetters_Page_Obj.SearchIcon_CountryName();
		EmployeeLetters_Page_Obj.CountryName_reject(propetiesOverloadObj.getProperty("CountryName"),propetiesOverloadObj.getProperty("HRComments") );
		Thread.sleep(3000);

	}
	@Test(priority=5)
	public void Visa_Renewal() throws Exception{
		Thread.sleep(3000);
		EmployeeLetters_Page_Obj.Enter_Home_tab();
		Thread.sleep(3000);
		EmployeeLetters_Page_Obj.Enter_NOC_tab();
		Select sel = new Select(driver.findElement(By.xpath("//select[@label='NOCReason']")));
		sel.selectByVisibleText(propetiesOverloadObj.getProperty("Options15"));
		Thread.sleep(2000);
		EmployeeLetters_Page_Obj.dates(propetiesOverloadObj.getProperty("FromDate"), propetiesOverloadObj.getProperty("ToDate"));
		EmployeeLetters_Page_Obj.SearchIcon_CountryName();
		EmployeeLetters_Page_Obj.CountryName_reject(propetiesOverloadObj.getProperty("CountryName"),propetiesOverloadObj.getProperty("HRComments") );
		Thread.sleep(3000);

	}


	@Test(priority=6)
	public void Immigration_clearance() throws Exception{
		Thread.sleep(3000);
		EmployeeLetters_Page_Obj.Enter_Home_tab();
		Thread.sleep(3000);
		EmployeeLetters_Page_Obj.Enter_NOC_tab();
		Select sel = new Select(driver.findElement(By.xpath("//select[@label='NOCReason']")));
		sel.selectByVisibleText(propetiesOverloadObj.getProperty("Options16"));
		Thread.sleep(2000);
		EmployeeLetters_Page_Obj.dates(propetiesOverloadObj.getProperty("FromDate"), propetiesOverloadObj.getProperty("ToDate"));
		EmployeeLetters_Page_Obj.SearchIcon_CountryName();
		EmployeeLetters_Page_Obj.CountryName_reject(propetiesOverloadObj.getProperty("CountryName"),propetiesOverloadObj.getProperty("HRComments") );
		Thread.sleep(3000);

	}


}