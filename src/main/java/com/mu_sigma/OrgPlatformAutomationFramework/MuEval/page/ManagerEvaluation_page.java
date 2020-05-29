package com.mu_sigma.OrgPlatformAutomationFramework.MuEval.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;

public class ManagerEvaluation_page extends TestBase {
WebDriver driver;
	
	private static final Logger ManagerEvaluation_page_pageLog = LogManager
			.getLogger(FULTEvaluation_page.class.getName());
	
	By Teamtab = By.xpath("//a[2]/button/span/div");
	
	By HelpIcon = By.xpath("//div/h2/mat-icon");
	
	By Tableheader = By.xpath("//div[1]/h1/center");
	
	By Closebtn = By.xpath("//div[2]/mat-dialog-actions/button/span");
	
	By record = By.xpath("//div[3]/mat-card-subtitle[2]"); 
	
	By record1 = By.xpath("//mat-card-title[@class='mat-card-title']");
	
	By EName = By.xpath("//div[2]/div[3]/span[1]");
	
	By EName1 = By.xpath("//div[3]/span[1]");
	
	By EType = By.xpath("//div[2]/mat-card-content/div/div/h2");
	
	By ESearch = By.xpath("//input[@id='mat-input-0']");
	
	By Selecttag1 = By.xpath("(//span[contains(text(),'Select Answer')])[1]");
	
	By Selecttag2 = By.xpath("(//span[contains(text(),'Select Answer')])[1]");
	
	By Selecttag3 = By.xpath("(//span[contains(text(),'Select Answer')])[1]");
	
	By Selecttag4 = By.xpath("(//span[contains(text(),'Select Answer')])[1]");
	
	By Selecttag5 = By.xpath("(//span[contains(text(),'Select Answer')])[1]");
	
	By Selecttag6 = By.xpath("(//span[contains(text(),'Select Answer')])[1]");
	
	By q1yes = By.xpath("//span[contains(text(),'Yes')]");// /*[@id='mat-option-0']/span[contains(text(),'Yes')]
	
	By q2yes = By.xpath("(//span[contains(text(),'Yes')])[2]");
	
	By q3yes = By.xpath("(//span[contains(text(),'Yes')])[3]");
	
	By q4yes = By.xpath("(//span[contains(text(),'Yes')])[4]");
	
	By q5yes = By.xpath("(//span[contains(text(),'Yes')])[5]");
	
	By q6yes = By.xpath("(//span[contains(text(),'Yes')])[6]");
	
	By Commentbox = By.xpath("//textarea[@id='mat-input-1']");
	
	By SubmitBtn = By.xpath("//div[2]/mat-card-content/div/form/div[2]/button");
	
	By Continue = By.xpath("//span[contains(text(),'CONTINUE')]");
	
    By Title = By.xpath("(//span[@class='mat-body-2'])[2]");
	
	By History = By.xpath("//div[contains(text(),'History')]");
	
	By Hsearch = By.xpath("//input");
	
	By SearchConfirm = By.xpath("//mat-card-title[@class='mat-card-title']");
	
	
	public ManagerEvaluation_page(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public void VerifyTeamPage() {
		
		clickWhenElementIsReady(driver, 30, Teamtab);
		ManagerEvaluation_page_pageLog.info("Clicked on Team tab");
		clickWhenElementIsReady(driver, 20, HelpIcon);
		ManagerEvaluation_page_pageLog.info("Clicked on Help Icon");
		System.out.println("The table name is:"+ driver.findElement(Tableheader).getText());
		ManagerEvaluation_page_pageLog.info("Table Name is Printed");
		clickWhenElementIsReady(driver, 30, Closebtn);
		ManagerEvaluation_page_pageLog.info("Clicked on Close Button");
	}	
	public void ManagerEvaluation(String EmployeeName1, String Comment1) throws InterruptedException {
		driver.findElement(ESearch).clear();
		driver.findElement(ESearch).sendKeys(EmployeeName1);
		ManagerEvaluation_page_pageLog.info("Filterd Employee Name");
		clickWhenElementIsReady(driver, 20, record1);
		ManagerEvaluation_page_pageLog.info("Clicked on Employee record");
		String EmpName1 = driver.findElement(EName1).getText();
		ManagerEvaluation_page_pageLog.info("Employee Name is Stored");
		System.out.println("Employee Name:"+EmpName1);
		Thread.sleep(5000);
		clickWhenElementIsReady(driver, 20, Selecttag1 );
		ManagerEvaluation_page_pageLog.info("Clicked on Select Answer");
		Thread.sleep(2000);
		clickWhenElementIsReady(driver, 30, q1yes);
		ManagerEvaluation_page_pageLog.info("Clicked on Yes for Q1");
		Thread.sleep(2000);
		clickWhenElementIsReady(driver, 30, Selecttag2);
		ManagerEvaluation_page_pageLog.info("Clicked on Select Answer");
		clickWhenElementIsReady(driver, 30, q2yes);
		ManagerEvaluation_page_pageLog.info("Clicked on Yes for Q2");
		Thread.sleep(4000);
		clickWhenElementIsReady(driver, 30, Selecttag3 );
		ManagerEvaluation_page_pageLog.info("Clicked on Select Answer");
		clickWhenElementIsReady(driver, 30, q3yes);
		ManagerEvaluation_page_pageLog.info("Clicked on Yes for Q3");
		Thread.sleep(2000);
		clickWhenElementIsReady(driver, 30, Selecttag4);
		ManagerEvaluation_page_pageLog.info("Clicked on Select Answer");
		clickWhenElementIsReady(driver, 20, q4yes);
		ManagerEvaluation_page_pageLog.info("Clicked on Yes for Q4");
		Thread.sleep(4000);
		clickWhenElementIsReady(driver, 20, Selecttag5);
		ManagerEvaluation_page_pageLog.info("Clicked on Select Answer");
		clickWhenElementIsReady(driver, 20, q5yes);
		ManagerEvaluation_page_pageLog.info("Clicked on Yes for Q5");
		Thread.sleep(3000);
		clickWhenElementIsReady(driver, 20, Selecttag6);
		ManagerEvaluation_page_pageLog.info("Clicked on Select Answer");
		clickWhenElementIsReady(driver, 30, q6yes);
		ManagerEvaluation_page_pageLog.info("Clicked on Yes for Q6");
		Thread.sleep(4000);
		driver.findElement(Commentbox).sendKeys(Comment1);
		ManagerEvaluation_page_pageLog.info("text sent in Comment box");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		WebElement Element = driver.findElement(SubmitBtn);
		Thread.sleep(4000);
		js.executeScript("arguments[0].scrollIntoView();", Element);
		Thread.sleep(4000);
		ManagerEvaluation_page_pageLog.info("Scrollbar moved down upto element");
		Thread.sleep(4000);
		Element.click();
		//clickWhenElementIsReady(driver, 20, SubmitBtn);
		Thread.sleep(4000);
		ManagerEvaluation_page_pageLog.info("Clicked on Submit Button");
		clickWhenElementIsReady(driver, 20, History);
		ManagerEvaluation_page_pageLog.info("Clicked on History Tab");
		Thread.sleep(4000);
		driver.findElement(Hsearch).sendKeys(EmpName1);
		ManagerEvaluation_page_pageLog.info("Searched for Employee in History Tab");
		Thread.sleep(3000);
		
	}


	public boolean ManagerEvalConfirm() {
		waitForElement(SearchConfirm, 10);
		return (driver.findElement(SearchConfirm).isDisplayed());
	}
	

}
