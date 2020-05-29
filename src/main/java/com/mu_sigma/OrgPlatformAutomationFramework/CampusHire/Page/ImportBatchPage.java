package com.mu_sigma.OrgPlatformAutomationFramework.CampusHire.Page;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ImportBatchPage {

	WebDriver driver;

	int i=1,j=1,k=1;

	private static final Logger EmployeeLetters_PageLog = LogManager.getLogger(ImportBatchPage.class.getName());	

	
	By Name_btn = By.xpath("//div[@type='button' and @id='123']");

    By Configure_btn =By.xpath("//span[contains(text(),'Configure')]");

	By Batch_Details_Tab = By.xpath("//div[contains(text(),'Batch Details')]");
	
	By Add_batch_btn =By.xpath("(//div[contains(text(),'Add Batch')])[1]");

	By BatchDate_1 = By.xpath("(//div[1]/img)[8]");

	By BatchDate_2 = By.xpath("//button[contains(text(),'Today')]");
	
	By Import_btn = By.xpath("//span[@title='Import data from file']");
	
	By OK_btn= By.xpath("//div[contains(text(),'OK')]");

	By Batch_name = By.xpath("//input[@label='BatchName']");

	By UploadFromFile = By.xpath("//span[@class='uploadimage']");

    By Import_CSV = By.xpath("//div[contains(text(),'Import from CSV')]");
	
    By Groups_tab = By.xpath("//div[contains(text(),'Groups')]");
	
    By Finish_btn = By.xpath("//a[@class='buttonFinish']");
	
    By CSVFileUpoad = By.xpath("//input[@name='CSVFileUpoad']");
	
	By ViewDetails_btn = By.xpath("//div[contains(text(),'View Details')]");

	By ViewDetails_btn_Group = By.xpath("(//div[contains(text(),'View Details')])[1]");

    By Save_Btn = By.xpath("//span[contains(text(),'Save')]");
	
    By Batch_Date = By.xpath("//input[@name='ctl02']");
	
	By Check_RunAsJob = By.xpath("//input[@id='RunAsJob']");
	
	By  Upload_btn = By.xpath("//input[@value='Upload']");
	
	By Group_Details = By.xpath("//div[contains(text(),'Group Details')]");

	By Candidate_detials_tab = By.xpath("//div[contains(text(),'Candidates')]");
	
	By Modify_Btn = By.xpath("//span[contains(text(),'Modify')]");

	By Search_emp = By.xpath("//span[@title='Select from Available List']");

	By Search_Text_box_emp_Id = By.xpath("(//tr[1]/td[3]/input)[2]");
	
    By Add_Btn = By.xpath("//span[contains(text(),'Add')]");
	
	By Check_box_emp_Id = By.xpath("//input[@id='MuSigmad65043:AppPoint1231:-1']");



	//Xpath's is For Providing Group Assessment 


	By Group_Assessment_Tab = By.xpath("//div[text()='Group Assessment']");

	By Pending_Group_Assessment_Tab = By.xpath("//div[text()='Pending Group Assessment']");
	
	By Provide_Assessment_Btn =  By.xpath("//div[text()='Provide Assessment']");
	

	//Xpath for Provide Feedback 

	By Provide_Feedback_Tab = By.xpath("//div[text()='  Provide Feedback']");
	
	By Pending_Interview_Tab = By.xpath("//div[text()='Pending Interview']");	

	By Provide_feedBack =  By.xpath("(//div[text()='Provide Feedback'])[1]");

	By OverAllComments = By.xpath("//textarea[@label='OverallComments']");

	By Yes_Btn = By.xpath("//label[text()='YES']");
	



	//xpath for Generate ID

	By Candidate_details_Tab = By.xpath("//div[text()='  Candidate Details']");
	
	By Hired_Candidates_Tab = By.xpath("//div[text()='Hired Candidates']");
	
	By GenerateID_Btn = By.xpath("//div[text()='Generate ID']");



	public ImportBatchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	private By xpath(String string) {
		// TODO Auto-generated method stub
		return null;
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

	public void Enter_Batch_Details_Tab(){
		driver.findElement(Batch_Details_Tab).click();
	}


	public void Add_Batch( String BatchName, String BatchDate) throws InterruptedException{
		Thread.sleep(3000);
		driver.findElement(Add_batch_btn).click();
		Thread.sleep(6000);
		driver.findElement(Batch_name).click();
		driver.findElement(Batch_name).clear();
		driver.findElement(Batch_name).sendKeys(BatchName);
		Thread.sleep(3000);
		driver.findElement(Batch_Date).click();
		driver.findElement(Batch_Date).sendKeys(BatchDate);
		driver.findElement(Save_Btn).click();
	}


	public void Add_Batch_1( String BatchName) throws InterruptedException{
		Thread.sleep(3000);
		driver.findElement(Add_batch_btn).click();
		Thread.sleep(6000);
		driver.findElement(Batch_name).click();
		driver.findElement(Batch_name).clear();
		driver.findElement(Batch_name).sendKeys(BatchName);
		Thread.sleep(3000);
		driver.findElement(BatchDate_1).click();
		Thread.sleep(3000);
		driver.findElement(BatchDate_2).click();
		Thread.sleep(2000);
		driver.findElement(OK_btn).click();
		driver.findElement(Save_Btn).click();
		Thread.sleep(2000);


	}


	public void Import_Data() throws InterruptedException{
		Thread.sleep(3000);
		driver.findElement(Batch_Details_Tab).click();
		Thread.sleep(3000);
		driver.findElement(ViewDetails_btn).click();
		Thread.sleep(2000);
		driver.findElement(Groups_tab).click();
	}




	public void Import_csv_Groups() throws InterruptedException, IOException{
		Thread.sleep(2000);
		driver.findElement(Groups_tab).click();
		Thread.sleep(2000);
		driver.findElement(Import_btn).click();
		Thread.sleep(2000);
		driver.findElement(Import_CSV).click();
		Thread.sleep(2000);
		driver.switchTo().frame(3);
		Thread.sleep(6000);
		Actions builder = new Actions(driver);
		Action mouseOver = builder.moveToElement(driver.findElement(By.xpath("//span[@class='uploadimage']"))).build();
		mouseOver.perform();
		
		driver.findElement(UploadFromFile).click();
		Thread.sleep(3000);
		driver.findElement(CSVFileUpoad).click();
		Thread.sleep(2000);
		Runtime.getRuntime().exec(System.getProperty("user.dir") + "\\autoit\\group.exe");
		Thread.sleep(2000);
		driver.findElement(Check_RunAsJob).click();
		Thread.sleep(3000);
		driver.findElement(Upload_btn).click();
		Thread.sleep(4000);
		driver.findElement(Finish_btn).click();
	}

	public void Import_CsV_CandidateDetails()throws InterruptedException, IOException{
		Thread.sleep(3000);
		driver.findElement(Candidate_detials_tab).click();
		Thread.sleep(3000);
		driver.findElement(Import_btn).click();
		Thread.sleep(2000);
		driver.findElement(Import_CSV).click();
		Thread.sleep(2000);
		driver.switchTo().frame(3);
		Thread.sleep(6000);
		Actions builder = new Actions(driver);
		Action mouseOver = builder.moveToElement(driver.findElement(By.xpath("//span[@class='uploadimage']"))).build();
		mouseOver.perform();
		driver.findElement(UploadFromFile).click();
		Thread.sleep(3000);
		driver.findElement(CSVFileUpoad).click();
		Thread.sleep(2000);
		Runtime.getRuntime().exec(System.getProperty("user.dir") + "\\autoit\\Batch1.exe");
		Thread.sleep(2000);
		driver.findElement(Check_RunAsJob).click();
		Thread.sleep(3000);
		driver.findElement(Upload_btn).click();
		Thread.sleep(4000);
		driver.findElement(Finish_btn).click();
		Thread.sleep(5000);
		driver.findElement(Candidate_detials_tab).click();

	}
	public void ADD_GA_Panel_Member(String EmpID) throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(Group_Details).click();
		Thread.sleep(2000);
		driver.findElement(ViewDetails_btn_Group).click();
		Thread.sleep(2000);
		driver.findElement(Modify_Btn).click();
		Thread.sleep(2000);
		driver.findElement(Search_emp).click();
		Thread.sleep(3000);
		driver.findElement(Search_Text_box_emp_Id).click();
		driver.findElement(Search_Text_box_emp_Id).sendKeys(EmpID);
		driver.findElement(Search_Text_box_emp_Id).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(Check_box_emp_Id).click();
		Thread.sleep(2000);
		driver.findElement(Add_Btn).click();
		Thread.sleep(3000);
		driver.findElement(Save_Btn).click();
	}

	public void  Provide_Group_assesment() throws InterruptedException{
		Thread.sleep(3000);
		driver.findElement(Group_Assessment_Tab).click();
		Thread.sleep(3000);
		driver.findElement(Pending_Group_Assessment_Tab).click();
		Thread.sleep(3000);
		driver.findElement(Provide_Assessment_Btn).click();
		for (int i=8;i<=10;i++){
			driver.findElement(By.xpath("//tr["+i+"]/td/select")).click();
			Thread.sleep(3000);
			Select sel = new Select(driver.findElement(By.xpath("//tr["+i+"]/td/select")));
			sel.selectByIndex(1);
		}

		Thread.sleep(3000);
		driver.findElement(Save_Btn).click();
	}


	public void Provide_FeedBack(String Comments) throws InterruptedException
	{
		Thread.sleep(3000);	
		driver.findElement(Provide_Feedback_Tab).click();
		Thread.sleep(3000);
		driver.findElement(Pending_Interview_Tab).click();
		Thread.sleep(4000);
		driver.findElement(Provide_feedBack).click();
		Thread.sleep(9000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//Find element by link text and store in variable "Element"        		
		WebElement Element = driver.findElement(By.xpath("(//div/span/label[text()='1'])[1]"));
		//This will scroll the page till the element is found		
		js.executeScript("arguments[0].scrollIntoView();", Element);
		Thread.sleep(3000);
		do{
			driver.findElement(By.xpath("(//div/span/label[text()='"+i+"'])["+j+"]")).click();
			i++;
			j++;
		}while(i==j && i!=6);

		do{
			driver.findElement(By.xpath("(//div/span/label[text()='"+k+"'])["+j+"]")).click();
			k++;
			j++;
		}while(k!=j && k!=3);

		driver.findElement(OverAllComments).click();
		driver.findElement(OverAllComments).sendKeys(Comments);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		//Find element by link text and store in variable "Element"        		
		//This will scroll the page till the element is found	
		js.executeScript("arguments[0].scrollIntoView();", Save_Btn);
		driver.findElement(Yes_Btn).click();
		Thread.sleep(2000);
		driver.findElement(Save_Btn).click();
		Thread.sleep(3000);
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public void GenerateID() throws InterruptedException{
		Thread.sleep(3000);
		driver.findElement(Candidate_details_Tab).click();
		Thread.sleep(2000);
		driver.findElement(Hired_Candidates_Tab).click();
		Thread.sleep(3000);
		driver.findElement(GenerateID_Btn).click();
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		alert.accept();

	}





































}
