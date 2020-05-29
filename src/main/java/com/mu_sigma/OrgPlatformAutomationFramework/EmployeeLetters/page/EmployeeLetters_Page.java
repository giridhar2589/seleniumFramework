package com.mu_sigma.OrgPlatformAutomationFramework.EmployeeLetters.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class EmployeeLetters_Page {

	WebDriver driver;


	private static final Logger EmployeeLetters_PageLog = LogManager.getLogger(EmployeeLetters_Page.class.getName());



	By Home_Tab = By.xpath("//div[contains(text(),'Home')]");


	By Address_Proof_Letter = By.xpath("//h4/center/strong[contains(text(),'Address Proof Letter')]");


	By EmployeeLetter = By.xpath("//h2[contains(text();,'Employee Letter')]");



	By Savebtn = By.xpath("//span[contains(text(),'Save')]");

	By EmployeeProofletter_tab = By.xpath("//h4/center/strong[contains(text(),'Employment Proof Letter')]");

	By AllLetters_tab = By.xpath("//div[contains(text(),'All Letters')]");

	By AllLetters_Btn = By.xpath("//span[contains(text(),'Save')]");


	By Approve_btn = By.xpath("//span[contains(text(),'Approve')]");



	By NOC_Tab = By.xpath("//h4/center/strong[contains(text(),'NOC')]");


	By  From_Date = By.xpath("(//input[@name='ctl02'])[1]");


	By To_Date = By.xpath("(//input[@name='ctl02'])[2]");

	By HRComment_TextArea = By.xpath("//textarea[@label='HRcomment']");



	By SearchIcon_CountryName = By.xpath("//span[@title='Select from Available List']");



	By SearchTextBox_CountryName = By.xpath("//input[@class='fftb']");

	By Select_radio_button = By.xpath("//input[@type='radio']");

	By Reject_Btn = By.xpath("//span[contains(text(),'Reject')]");



	By Add_Btn = By.xpath("//span[contains(text(),'Add')]");


	public EmployeeLetters_Page(WebDriver driver) {
		this.driver = driver;

	}



	public void Enter_Home_tab() {

		driver.findElement(Home_Tab).click();

	}
	public void Enter_NOC_tab() {
		driver.findElement(NOC_Tab).click();

	}


	/**
	 * This Method is used to Enter Inside the HomeTab
	 * 
	 * @param policyNo
	 *            its only accept Integer value
	 */
	public void Enter_Address_Proof_Letter() {
		driver.findElement(Address_Proof_Letter).click();

	}
	public void Enter_EmployeeProofletter() {
		driver.findElement(EmployeeProofletter_tab).click();

	}

	public void Click_save(){
		driver.findElement(Savebtn).click();
	}

	public void Click_AllLetters_tab(){
		driver.findElement(AllLetters_tab).click();
	}



	public void SearchIcon_CountryName(){
		driver.findElement(SearchIcon_CountryName).click();
	}

	public void dates(String FromDate, String ToDate) throws InterruptedException{
		driver.findElement(From_Date).click();
		driver.findElement(From_Date).sendKeys(FromDate);
		Thread.sleep(3000);
		driver.findElement(To_Date).click();
		driver.findElement(To_Date).sendKeys(ToDate);

	}

	public void CountryName(String CountryName) throws InterruptedException{
		Thread.sleep(3000);
		driver.findElement(SearchTextBox_CountryName).clear();
		Thread.sleep(3000);
		driver.findElement(SearchTextBox_CountryName).click();
		Thread.sleep(3000);
		driver.findElement(SearchTextBox_CountryName).sendKeys(CountryName);
		driver.findElement(SearchTextBox_CountryName).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(Select_radio_button).click();
		Thread.sleep(2000);
		driver.findElement(Add_Btn).click();
		Thread.sleep(2000);
		driver.findElement(Savebtn).click();
		Thread.sleep(3000);
		driver.findElement(Approve_btn).click();

	}
	public void CountryName_reject(String CountryName, String Comments) throws InterruptedException{
		Thread.sleep(3000);
		driver.findElement(SearchTextBox_CountryName).clear();
		Thread.sleep(3000);
		driver.findElement(SearchTextBox_CountryName).click();
		Thread.sleep(3000);
		driver.findElement(SearchTextBox_CountryName).sendKeys(CountryName);
		driver.findElement(SearchTextBox_CountryName).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(Select_radio_button).click();
		Thread.sleep(2000);
		driver.findElement(Add_Btn).click();
		Thread.sleep(2000);
		driver.findElement(Savebtn).click();
		Thread.sleep(3000);
		driver.findElement(Reject_Btn).click();
		Thread.sleep(3000);
		driver.findElement(HRComment_TextArea).click();
		driver.findElement(HRComment_TextArea).sendKeys(Comments);
		Thread.sleep(3000);
		driver.findElement(Savebtn).click();

	}
}
