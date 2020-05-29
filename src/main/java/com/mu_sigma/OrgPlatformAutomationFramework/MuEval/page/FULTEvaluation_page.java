package com.mu_sigma.OrgPlatformAutomationFramework.MuEval.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;

public class FULTEvaluation_page extends TestBase {
	WebDriver driver;
	
	private static final Logger FULTEvaluation_page_pageLog = LogManager
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
	
	By ESearch = By.xpath("//input");
	
	By selectTag = By.xpath("(//span[contains(text(),'Select Answer')])[1]");
	
	By Selecttag1 = By.xpath("(//span[contains(text(),'Select Answer')])[1]");
	
	By Yes1 = By.xpath("(//span[contains(text(),'Yes')])[1]"); 
	
	By Yes2 = By.xpath("(//span[contains(text(),'Yes')])[2]");
	
	By Commentbox = By.xpath("//textarea[@id='mat-input-1']");
	
	By SubmitBtn = By.xpath("//div[2]/mat-card-content/div/form/div[2]/button");
	
	By Continue = By.xpath("//span[contains(text(),'CONTINUE')]");
	
	By Title = By.xpath("((//span[@class='mat-body-2'])[2]");
	
	By History = By.xpath("//div[contains(text(),'History')]");
	
	By Hsearch = By.xpath("//input");
	
	By SearchConfirm = By.xpath("//mat-card-title[@class='mat-card-title']");
	
	public FULTEvaluation_page(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public void VerifyTeamPage() {
		
		clickWhenElementIsReady(driver, 30, Teamtab);
		FULTEvaluation_page_pageLog.info("Clicked on Team tab");
		clickWhenElementIsReady(driver, 20, HelpIcon);
		FULTEvaluation_page_pageLog.info("Clicked on Help Icon");
		System.out.println("The table name is:"+ driver.findElement(Tableheader).getText());
		FULTEvaluation_page_pageLog.info("Table Name is Printed");
		clickWhenElementIsReady(driver, 30, Closebtn);
		FULTEvaluation_page_pageLog.info("Clicked on Close Button");
	}

	public void FultEvaluation(String EmployeeName, String Comment) throws InterruptedException {
		driver.findElement(ESearch).clear();
		driver.findElement(ESearch).sendKeys(EmployeeName);
		FULTEvaluation_page_pageLog.info("Filterd Employee Name");
		clickWhenElementIsReady(driver, 20, record);
		FULTEvaluation_page_pageLog.info("Clicked on Employee record");
		String EmpName = driver.findElement(EName1).getText();
		FULTEvaluation_page_pageLog.info("Employee Name is Stored");
		System.out.println("Employee Name:"+EmpName);
		clickWhenElementIsReady(driver, 20, selectTag );
		FULTEvaluation_page_pageLog.info("Clicked on Select Answer");
		clickWhenElementIsReady(driver, 20, Yes1);
		FULTEvaluation_page_pageLog.info("Clicked on Yes for Q1");
		Thread.sleep(2000);
		clickWhenElementIsReady(driver, 20, Selecttag1);
		FULTEvaluation_page_pageLog.info("Clicked on Select Answer");
		clickWhenElementIsReady(driver, 20, Yes2);
		FULTEvaluation_page_pageLog.info("Clicked on Yes for Q2");
		Thread.sleep(4000);
		driver.findElement(Commentbox).sendKeys(Comment);
		FULTEvaluation_page_pageLog.info("text sent in Comment box");
		clickWhenElementIsReady(driver, 20, SubmitBtn);
		Thread.sleep(4000);
		FULTEvaluation_page_pageLog.info("Clicked on Submit Button");
		clickWhenElementIsReady(driver, 20, History);
		FULTEvaluation_page_pageLog.info("Clicked on History Tab");
		Thread.sleep(4000);
		driver.findElement(Hsearch).sendKeys(EmpName);
		FULTEvaluation_page_pageLog.info("Searched for Employee in History Tab");
		Thread.sleep(3000);
		
	}
	public boolean FultEvalConfirm() {
		waitForElement(SearchConfirm, 10);
		return (driver.findElement(SearchConfirm).isDisplayed());
	}
	
	
	
	
}
