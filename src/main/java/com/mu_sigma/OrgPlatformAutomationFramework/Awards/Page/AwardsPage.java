package com.mu_sigma.OrgPlatformAutomationFramework.Awards.Page;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;



public class AwardsPage {

	WebDriver driver;


	private static final Logger EmployeeLetters_PageLog = LogManager.getLogger(AwardsPage.class.getName());

	By Name_btn = By.xpath("//div[@type='button' and @id='123']");

	By  Configure_btn = By.xpath("//div/a/nobr");

	By OK_btn =  By.xpath("//div[contains(text(),'OK')]");

	By Award_request = By.xpath("//div[contains(text(),'Award Requests')]");

	By Add_button = By.xpath("//span[contains(text(),'Add')]");

	By Add_Approve =By.xpath("//span[contains(text(),'Approve')]");

	By Add_Reject =By.xpath("//span[contains(text(),'Reject')]");

	By create_award_btn= By.xpath("//button[contains(text(),'Create Award Request')]");

	By Issue_vocher_btn= By.xpath("//span[contains(text(),'Issue Voucher')]");

	By Reject_vocher_btn = By.xpath("//span[contains(text(),'Reject Voucher')]");

	By  Navigate_btn  = By.xpath("//span[@title='Click to navigate to a selected view'])[1]");

	By Select_radio_btn =By.xpath("//td[2]/input[@id='MuSigmad65043:AppPoint1231:-1']");

	By Select_radio_btn_Spot_Award= By.xpath("//td[2]/input[@id='MuSigma1530339:EMuSigmaQMS1bc339:-1']");

	By Select_radio_btn_Impact_Award = By.xpath("//input[@id='MuSigma153033a:EMuSigmaQMS1bc339:-1']");

	By Select_radio_btn_WeddingGift_Award =By.xpath("//input[@id='MuSigma159cbdb:EMuSigmaQMS1bc339:-1']");


	By Select_radio_btn_FuID = By.xpath("//input[@id='MuSigma17581a:AppPoint1231:-1']");


	By Select_radio_btn_NewBornGift = By.xpath("//input[@id='MuSigma194f11d:EMuSigmaQMS1bc339:-1']");


	By Search_Icon_FU_leader = By.xpath("//div/span[15]");

	By Search_Icon_Employee = By.xpath("//div/span[4]");

	By Search_Icon_Awards =By.xpath("//div/span[14]");

	By Input_EmpID = By.xpath("(//td[3]/input)[2]");

	By Input_FuID = By.xpath("(//tr[1]/td[3]/input)[2]");

	By Submit_request_btn = By.xpath("//span[contains(text(),'Submit Request')]");

	By Save_btn = By.xpath("//span[contains(text(),'Save')]");

	By Citation = By.xpath("//textarea[@title='Tooltip not available for the field']");

	By Rejection_area = By.xpath("//textarea[@label='RejectionReason']");



	public AwardsPage(WebDriver driver) {
		this.driver = driver;

	}


	public void Impersitionation () throws InterruptedException {
		driver.findElement(Name_btn).click();
		Thread.sleep(3000);
		driver.findElement(Configure_btn).click();
		Thread.sleep(3000);
		Select sel= new Select(driver.findElement(By.xpath("//select[@name='ctl02']")));
		sel.selectByValue("MuSigma6dccca:AppPoint1231:-1");
		Thread.sleep(3000);
		//Navigate_btn.click();

	}

	public void Enter_Into_Award_request() throws InterruptedException{
		Thread.sleep(3000);
		driver.findElement(Award_request).click();
	}

	public void Create_award_request() throws InterruptedException{
		Thread.sleep(3000);
		driver.findElement(create_award_btn).click();
		Thread.sleep(2000);
		//OK_btn.click();
		Thread.sleep(3000);
	}


	public void select_Empolyee(String empid) throws InterruptedException{
		driver.findElement(Search_Icon_Employee).click();
		Thread.sleep(3000);
		driver.findElement(Input_EmpID).click();
		driver.findElement(Input_EmpID).sendKeys(empid);
		driver.findElement(Input_EmpID).sendKeys(Keys.ENTER);
		driver.findElement(Select_radio_btn).click();
		driver.findElement(Add_button).click();
	}


	public void select_Awards_Spot(String AwardType) throws InterruptedException{
		Thread.sleep(3000);
		driver.findElement(Search_Icon_Awards).click();
		Thread.sleep(3000);
		driver.findElement(Input_EmpID).click();
		driver.findElement(Input_EmpID).sendKeys(AwardType);
		driver.findElement(Input_EmpID).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(Select_radio_btn_Spot_Award).click();
		driver.findElement(Add_button).click();
	}

	public void select_Awards_Impact(String AwardType) throws InterruptedException{
		Thread.sleep(3000);
		driver.findElement(Search_Icon_Awards).click();
		Thread.sleep(3000);
		driver.findElement(Input_EmpID).click();
		driver.findElement(Input_EmpID).sendKeys(AwardType);
		driver.findElement(Input_EmpID).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(Select_radio_btn_Impact_Award).click();
		driver.findElement(Add_button).click();
	}

	public void select_Awards_WedingGift(String AwardType) throws InterruptedException{
		Thread.sleep(3000);
		driver.findElement(Search_Icon_Awards).click();
		Thread.sleep(3000);
		driver.findElement(Input_EmpID).click();
		driver.findElement(Input_EmpID).sendKeys(AwardType);
		driver.findElement(Input_EmpID).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(Select_radio_btn_WeddingGift_Award).click();
		driver.findElement(Add_button).click();

	}

	public void select_Awards_NewBornGift(String AwardType) throws InterruptedException{
		Thread.sleep(3000);
		driver.findElement(Search_Icon_Awards).click();
		Thread.sleep(3000);
		driver.findElement(Input_EmpID).click();
		driver.findElement(Input_EmpID).sendKeys(AwardType);
		driver.findElement(Input_EmpID).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(Select_radio_btn_NewBornGift).click();
		driver.findElement(Add_button).click();
		Thread.sleep(3000);

	}

	public void Issue_vocher () throws InterruptedException{
		Thread.sleep(3000);
		driver.findElement(Issue_vocher_btn).click();
	}

	public void Reject_vocher () throws InterruptedException{
		Thread.sleep(3000);
		driver.findElement(Reject_vocher_btn).click();
	}

	public void Enter_Citation(String Textarea) throws InterruptedException{
		Thread.sleep(3000);
		driver.findElement(Citation).click();
		driver.findElement(Citation).clear();
		Thread.sleep(3000);
		driver.findElement(Citation).sendKeys(Textarea);

	}
	public void Enter_FU_permission (String FUID) throws InterruptedException{
		Thread.sleep(4000);
		driver.findElement(Search_Icon_FU_leader).click();
		driver.findElement(Input_FuID).click();
		driver.findElement(Input_FuID).clear();
		driver.findElement(Input_FuID).sendKeys(FUID);
		driver.findElement(Input_FuID).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(Select_radio_btn_FuID).click();
		Thread.sleep(2000);
		driver.findElement(Add_button).click();

	}

	public void click_Submit_request_btn() throws InterruptedException{
		Thread.sleep(3000);
		driver.findElement(Submit_request_btn).click();
	}


	public void click_Approve() throws InterruptedException{
		Thread.sleep(3000);
		driver.findElement(Add_Approve).click();
	}

	public void click_Reject(String Rejection) throws InterruptedException{
		Thread.sleep(3000);
		driver.findElement(Add_Reject).click();
		Thread.sleep(3000);
		driver.findElement(Rejection_area).click();
		driver.findElement(Rejection_area).sendKeys(Rejection);
		driver.findElement(Save_btn).click();

	}



}
