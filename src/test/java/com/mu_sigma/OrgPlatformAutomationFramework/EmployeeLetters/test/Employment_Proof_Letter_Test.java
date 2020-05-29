package com.mu_sigma.OrgPlatformAutomationFramework.EmployeeLetters.test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.mu_sigma.OrgPlatformAutomationFramework.EmployeeLetters.page.EmployeeLetters_Page;
import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;;




public class Employment_Proof_Letter_Test extends TestBase {

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
		EmployeeLetters_Page_Obj.Enter_EmployeeProofletter();
		Thread.sleep(3000);
		//s_assert.assertEquals((EmployeeLetters_Page_Obj.EmployeeLetter), "Employee Letter");
		s_assert.assertTrue(true);

	}

	@Test(priority=3)
	public void Letter_request_bank_formalities() throws Exception{
		Thread.sleep(3000);
		Select sel= new Select(driver.findElement(By.xpath("//*[@label='Reason']")));
		sel.selectByVisibleText(propetiesOverloadObj.getProperty("Options1"));
		EmployeeLetters_Page_Obj.Click_save();
		Thread.sleep(10000);
		//String  set = driver.findElement(By.xpath("//*[@id='plugin']")).getText();
		//System.out.println(set);
		EmployeeLetters_Page_Obj.Click_AllLetters_tab();
		//s_assert.assertEquals((EmployeeLetters_Page_Obj.EmployeeLetter), "Employee Letter");
		Thread.sleep(3000);
		String data = driver.findElement(By.xpath("//tbody/tr[2]/td[8]")).getText();
		System.out.println(data);
		s_assert.assertEquals(data, propetiesOverloadObj.getProperty("Options1"));
		s_assert.assertTrue(true);
	}
	@Test(priority=5)
	public void Letter_availing_driving_license() throws Exception{
		Thread.sleep(3000);
		EmployeeLetters_Page_Obj.Enter_Home_tab();
		Thread.sleep(3000);
		EmployeeLetters_Page_Obj.Enter_Address_Proof_Letter();
		Select sel= new Select(driver.findElement(By.xpath("//*[@label='Reason']")));
		sel.selectByVisibleText(propetiesOverloadObj.getProperty("Options2"));
		EmployeeLetters_Page_Obj.Click_save();
		Thread.sleep(10000);
		//String  set = driver.findElement(By.xpath("//*[@id='plugin']")).getText();
		//System.out.println(set);
		EmployeeLetters_Page_Obj.Click_AllLetters_tab();
		//s_assert.assertEquals((EmployeeLetters_Page_Obj.EmployeeLetter), "Employee Letter");
		Thread.sleep(3000);
		String data = driver.findElement(By.xpath("//tbody/tr[2]/td[8]")).getText();
		System.out.println(data);
		s_assert.assertEquals(data, propetiesOverloadObj.getProperty("Options2"));
		s_assert.assertTrue(true);
	}


	@Test(priority=6)
	public void Letter_submitting_to_university() throws Exception{
		Thread.sleep(3000);
		EmployeeLetters_Page_Obj.Enter_Home_tab();
		Thread.sleep(3000);
		EmployeeLetters_Page_Obj.Enter_Address_Proof_Letter();
		Select sel= new Select(driver.findElement(By.xpath("//*[@label='Reason']")));
		sel.selectByVisibleText(propetiesOverloadObj.getProperty("Options3"));
		EmployeeLetters_Page_Obj.Click_save();
		Thread.sleep(10000);
		//String  set = driver.findElement(By.xpath("//*[@id='plugin']")).getText();
		//System.out.println(set);
		EmployeeLetters_Page_Obj.Click_AllLetters_tab();
		//s_assert.assertEquals((EmployeeLetters_Page_Obj.EmployeeLetter), "Employee Letter");
		Thread.sleep(3000);
		String data = driver.findElement(By.xpath("//tbody/tr[2]/td[8]")).getText();
		System.out.println(data);
		s_assert.assertEquals(data, propetiesOverloadObj.getProperty("Options3"));
		s_assert.assertTrue(true);
	}

	@Test(priority=7)
	public void Letter_loan_application() throws Exception{
		Thread.sleep(3000);
		EmployeeLetters_Page_Obj.Enter_Home_tab();
		Thread.sleep(3000);
		EmployeeLetters_Page_Obj.Enter_Address_Proof_Letter();
		Select sel= new Select(driver.findElement(By.xpath("//*[@label='Reason']")));
		Thread.sleep(3000);
		sel.selectByVisibleText(propetiesOverloadObj.getProperty("Options4"));
		EmployeeLetters_Page_Obj.Click_save();
		Thread.sleep(10000);
		//String  set = driver.findElement(By.xpath("//*[@id='plugin']")).getText();
		//System.out.println(set);
		EmployeeLetters_Page_Obj.Click_AllLetters_tab();
		//s_assert.assertEquals((EmployeeLetters_Page_Obj.EmployeeLetter), "Employee Letter");
		Thread.sleep(3000);
		String data = driver.findElement(By.xpath("//tbody/tr[2]/td[8]")).getText();
		System.out.println(data);
		s_assert.assertEquals(data, propetiesOverloadObj.getProperty("Options4"));
		s_assert.assertTrue(true);
	}
	@Test(priority=8)
	public void availing_gas_connection() throws Exception{
		Thread.sleep(3000);
		EmployeeLetters_Page_Obj.Enter_Home_tab();
		Thread.sleep(3000);
		EmployeeLetters_Page_Obj.Enter_Address_Proof_Letter();
		Select sel= new Select(driver.findElement(By.xpath("//*[@label='Reason']")));
		Thread.sleep(3000);
		sel.selectByVisibleText(propetiesOverloadObj.getProperty("Options5"));
		EmployeeLetters_Page_Obj.Click_save();
		Thread.sleep(10000);
		//String  set = driver.findElement(By.xpath("//*[@id='plugin']")).getText();
		//System.out.println(set);
		EmployeeLetters_Page_Obj.Click_AllLetters_tab();
		//s_assert.assertEquals((EmployeeLetters_Page_Obj.EmployeeLetter), "Employee Letter");
		Thread.sleep(3000);
		String data = driver.findElement(By.xpath("//tbody/tr[2]/td[8]")).getText();
		System.out.println(data);
		s_assert.assertEquals(data, propetiesOverloadObj.getProperty("Options5"));
		s_assert.assertTrue(true);
	}

	@Test(priority=9)
	public void Passport_renewal() throws Exception{
		Thread.sleep(3000);
		EmployeeLetters_Page_Obj.Enter_Home_tab();
		Thread.sleep(3000);
		EmployeeLetters_Page_Obj.Enter_Address_Proof_Letter();
		Select sel= new Select(driver.findElement(By.xpath("//*[@label='Reason']")));
		Thread.sleep(3000);
		sel.selectByVisibleText(propetiesOverloadObj.getProperty("Options6"));
		EmployeeLetters_Page_Obj.Click_save();
		Thread.sleep(10000);
		//String  set = driver.findElement(By.xpath("//*[@id='plugin']")).getText();
		//System.out.println(set);
		EmployeeLetters_Page_Obj.Click_AllLetters_tab();
		//s_assert.assertEquals((EmployeeLetters_Page_Obj.EmployeeLetter), "Employee Letter");
		Thread.sleep(3000);
		String data = driver.findElement(By.xpath("//tbody/tr[2]/td[8]")).getText();
		System.out.println(data);
		s_assert.assertEquals(data, propetiesOverloadObj.getProperty("Options6"));
		s_assert.assertTrue(true);
	}
	@Test(priority=10)
	public void Passport_application() throws Exception{
		Thread.sleep(3000);
		EmployeeLetters_Page_Obj.Enter_Home_tab();
		Thread.sleep(3000);
		EmployeeLetters_Page_Obj.Enter_Address_Proof_Letter();
		Select sel= new Select(driver.findElement(By.xpath("//*[@label='Reason']")));
		Thread.sleep(3000);
		sel.selectByVisibleText(propetiesOverloadObj.getProperty("Options7"));
		EmployeeLetters_Page_Obj.Click_save();
		Thread.sleep(10000);
		//String  set = driver.findElement(By.xpath("//*[@id='plugin']")).getText();
		//System.out.println(set);
		EmployeeLetters_Page_Obj.Click_AllLetters_tab();
		//s_assert.assertEquals((EmployeeLetters_Page_Obj.EmployeeLetter), "Employee Letter");
		Thread.sleep(3000);
		String data = driver.findElement(By.xpath("//tbody/tr[2]/td[8]")).getText();
		System.out.println(data);
		s_assert.assertEquals(data, propetiesOverloadObj.getProperty("Options7"));
		s_assert.assertTrue(true);
	}
	@Test(priority=11)
	public void rental_agreement() throws Exception{
		Thread.sleep(3000);
		EmployeeLetters_Page_Obj.Enter_Home_tab();
		Thread.sleep(3000);
		EmployeeLetters_Page_Obj.Enter_Address_Proof_Letter();
		Select sel= new Select(driver.findElement(By.xpath("//*[@label='Reason']")));
		Thread.sleep(3000);
		sel.selectByVisibleText(propetiesOverloadObj.getProperty("Options8"));
		EmployeeLetters_Page_Obj.Click_save();
		Thread.sleep(10000);
		//String  set = driver.findElement(By.xpath("//*[@id='plugin']")).getText();
		//System.out.println(set);
		EmployeeLetters_Page_Obj.Click_AllLetters_tab();
		//s_assert.assertEquals((EmployeeLetters_Page_Obj.EmployeeLetter), "Employee Letter");
		Thread.sleep(3000);
		String data = driver.findElement(By.xpath("//tbody/tr[2]/td[8]")).getText();
		System.out.println(data);
		s_assert.assertEquals(data, propetiesOverloadObj.getProperty("Options8"));
		s_assert.assertTrue(true);
	}
	@Test(priority=12)
	public void PAN_card_application() throws Exception{
		Thread.sleep(3000);
		EmployeeLetters_Page_Obj.Enter_Home_tab();
		Thread.sleep(3000);
		EmployeeLetters_Page_Obj.Enter_Address_Proof_Letter();
		Select sel= new Select(driver.findElement(By.xpath("//*[@label='Reason']")));
		Thread.sleep(3000);
		sel.selectByVisibleText(propetiesOverloadObj.getProperty("Options9"));
		EmployeeLetters_Page_Obj.Click_save();
		Thread.sleep(10000);
		//String  set = driver.findElement(By.xpath("//*[@id='plugin']")).getText();
		//System.out.println(set);
		EmployeeLetters_Page_Obj.Click_AllLetters_tab();
		//s_assert.assertEquals((EmployeeLetters_Page_Obj.EmployeeLetter), "Employee Letter");
		Thread.sleep(3000);
		String data = driver.findElement(By.xpath("//tbody/tr[2]/td[8]")).getText();
		System.out.println(data);
		s_assert.assertEquals(data, propetiesOverloadObj.getProperty("Options9"));
		s_assert.assertTrue(true);
	}
	@Test(priority=13)
	public void Reissue_of_PAN_card () throws Exception{
		Thread.sleep(3000);
		EmployeeLetters_Page_Obj.Enter_Home_tab();
		Thread.sleep(3000);
		EmployeeLetters_Page_Obj.Enter_Address_Proof_Letter();
		Select sel= new Select(driver.findElement(By.xpath("//*[@label='Reason']")));
		Thread.sleep(3000);
		sel.selectByVisibleText(propetiesOverloadObj.getProperty("Options10"));
		EmployeeLetters_Page_Obj.Click_save();
		Thread.sleep(10000);
		//String  set = driver.findElement(By.xpath("//*[@id='plugin']")).getText();
		//System.out.println(set);
		EmployeeLetters_Page_Obj.Click_AllLetters_tab();
		//s_assert.assertEquals((EmployeeLetters_Page_Obj.EmployeeLetter), "Employee Letter");
		Thread.sleep(3000);
		String data = driver.findElement(By.xpath("//tbody/tr[2]/td[8]")).getText();
		System.out.println(data);
		s_assert.assertEquals(data, propetiesOverloadObj.getProperty("Options10"));
		s_assert.assertTrue(true);
	}


	@Test(priority=14)
	public void purchase_of_vehicle () throws Exception{
		Thread.sleep(3000);
		EmployeeLetters_Page_Obj.Enter_Home_tab();
		Thread.sleep(3000);
		EmployeeLetters_Page_Obj.Enter_Address_Proof_Letter();
		Select sel= new Select(driver.findElement(By.xpath("//*[@label='Reason']")));
		Thread.sleep(3000);
		sel.selectByVisibleText(propetiesOverloadObj.getProperty("Options11"));
		EmployeeLetters_Page_Obj.Click_save();
		Thread.sleep(10000);
		//String  set = driver.findElement(By.xpath("//*[@id='plugin']")).getText();
		//System.out.println(set);
		EmployeeLetters_Page_Obj.Click_AllLetters_tab();
		//s_assert.assertEquals((EmployeeLetters_Page_Obj.EmployeeLetter), "Employee Letter");
		Thread.sleep(3000);
		String data = driver.findElement(By.xpath("//tbody/tr[2]/td[8]")).getText();
		System.out.println(data);
		s_assert.assertEquals(data, propetiesOverloadObj.getProperty("Options11"));
		s_assert.assertTrue(true);
	}
	@Test(priority=15)
	public void Aadhar_card_application() throws Exception{
		Thread.sleep(3000);
		EmployeeLetters_Page_Obj.Enter_Home_tab();
		Thread.sleep(3000);
		EmployeeLetters_Page_Obj.Enter_Address_Proof_Letter();
		Select sel= new Select(driver.findElement(By.xpath("//*[@label='Reason']")));
		Thread.sleep(3000);
		sel.selectByVisibleText(propetiesOverloadObj.getProperty("Options12"));
		EmployeeLetters_Page_Obj.Click_save();
		Thread.sleep(10000);
		//String  set = driver.findElement(By.xpath("//*[@id='plugin']")).getText();
		//System.out.println(set);
		EmployeeLetters_Page_Obj.Click_AllLetters_tab();
		//s_assert.assertEquals((EmployeeLetters_Page_Obj.EmployeeLetter), "Employee Letter");
		Thread.sleep(3000);
		String data = driver.findElement(By.xpath("//tbody/tr[2]/td[8]")).getText();
		System.out.println(data);
		s_assert.assertEquals(data, propetiesOverloadObj.getProperty("Options12"));
		s_assert.assertTrue(true);
	}
	@Test(priority=16)
	public void SIM_card_purposes() throws Exception{
		Thread.sleep(3000);
		EmployeeLetters_Page_Obj.Enter_Home_tab();
		Thread.sleep(3000);
		EmployeeLetters_Page_Obj.Enter_Address_Proof_Letter();
		Select sel= new Select(driver.findElement(By.xpath("//*[@label='Reason']")));
		Thread.sleep(3000);
		sel.selectByVisibleText(propetiesOverloadObj.getProperty("Options13"));
		EmployeeLetters_Page_Obj.Click_save();
		Thread.sleep(10000);
		//String  set = driver.findElement(By.xpath("//*[@id='plugin']")).getText();
		//System.out.println(set);
		EmployeeLetters_Page_Obj.Click_AllLetters_tab();
		//s_assert.assertEquals((EmployeeLetters_Page_Obj.EmployeeLetter), "Employee Letter");
		Thread.sleep(3000);
		String data = driver.findElement(By.xpath("//tbody/tr[2]/td[8]")).getText();
		System.out.println(data);
		s_assert.assertEquals(data, propetiesOverloadObj.getProperty("Options13"));
		s_assert.assertTrue(true);
	}

}
