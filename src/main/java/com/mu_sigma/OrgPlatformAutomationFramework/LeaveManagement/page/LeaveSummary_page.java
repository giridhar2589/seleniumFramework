package com.mu_sigma.OrgPlatformAutomationFramework.LeaveManagement.page;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;
/**
 * Created On:16-March-2018
 * @author biswajit.kundu
 * Last Modified On:NA
 */
public class LeaveSummary_page extends TestBase {

	WebDriver driver;

	private static final Logger LeaveSummary_page_pageLog = LogManager.getLogger(LeaveSummary_page.class.getName());

	
	By leaveSummary_tab=By.xpath("//h4[contains(text(),'Leave Summary')]");
	By employeeName_inputBox=By.xpath("//input[@placeholder='Employee Name']");
	By employeeTypedropDown_icon=By.xpath("(//div[@class='mat-select-arrow-wrapper'])");
	By leaveSummary_text=By.xpath("//h2[contains(text(),'Leave Summary')]");
	By employeeName_clear_btn=By.xpath("//div[contains(@class,'mat-input-suffix mat-form-field-suffix ng-tns')]//i[contains(text(),'close')]");
	By invalidError_text=By.xpath("//div[contains(text(),'Please select an employee')]");
	By leaveTypeHeader=By.xpath("//td[contains(text(),'Opening Balance')]");
	By employeeNameClear=By.xpath("//input[@id='empSearch']");
	
	public LeaveSummary_page(WebDriver driver) {
		this.driver = driver;
	}



	/**
	 * This method is used to click on Leave Summary Tab
	 */
	public void clickLeaveSummary_tab() {
		
		waitForElement(leaveSummary_tab, 8);
		driver.findElement(leaveSummary_tab).click();
		//clickWhenElementIsReady(driver, 15, leaveSummary_tab);
	}

	/**
	 * This method is used to Select the Employee
	 * 
	 * @param employeePartialName
	 * @param employeeActualName
	 * @throws Exception
	 */
	public void selectEmployee(String employeePartialName, String employeeActualName) throws Exception {
		try {
			waitForElement(employeeName_inputBox, 14);
			driver.findElement(employeeName_inputBox).sendKeys(employeePartialName);
			WebElement parentElement = driver.findElement(By.xpath(
					"//mat-option[@fxlayoutalign='space-between stretch']//span[@class='mat-option-text']//div[2]"));
			List<WebElement> celement = parentElement.findElements(By.tagName("div"));
			Thread.sleep(3000);
			for (WebElement suggestion : celement) {
				suggestion.getText().equals(employeeActualName);
				suggestion.click();
				break;
			}
			LeaveSummary_page_pageLog.info("Employee Selected");
		} catch (Exception e) {
			LeaveSummary_page_pageLog.info("Application unbale to select the Employee");
		}
	}

	/**
	 * This method is used to select Type of Employee from the Drop down
	 * 
	 * @param typeOfEmployee
	 *            Data type Will be String which will select the employee type
	 *            from the Drop down
	 */
	public void selectTypeOfEmployeeDropDown(String typeOfEmployee) {
		try {
			clickWhenElementIsReady(driver, 30, employeeTypedropDown_icon);
			WebElement element = driver.findElement(By
					.xpath("//div[@class='mat-select-content ng-trigger ng-trigger-fadeInContent']//span[contains(text(),'"
							+ typeOfEmployee + "')]"));
			clickWhenElementIsReady(driver, 20, element);
			LeaveSummary_page_pageLog
					.info("Application selected the" + typeOfEmployee + "Option from the Typeof Employe drop Down");
		} catch (Exception e) {
			LeaveSummary_page_pageLog.info(
					"Application unable to select the" + typeOfEmployee + "Option from the Typeof Employe drop Down");
			e.printStackTrace();
		}
	}

	/**
	 * This method is used to clear the Employee field
	 */
	public void clearEmployeeField() {
		clickWhenElementIsReady(driver, 90, employeeName_clear_btn);
	}
	
	/**
	 * This method is used to clear the employee input box
	 */
	public void clearFiled_emp(){
		waitForElement(employeeNameClear, 30);
		driver.findElement(employeeNameClear).clear();
	}
	
	/**
	 * This method will return leave Summary Page text
	 * @return
	 */
	public String leaveSummary_text(){
		waitForElement(leaveSummary_text, 15);
		return driver.findElement(leaveSummary_text).getText();
	}
	
	/**
	 * This method will return the "Please Select an employee" text on valid employee selection 
	 * @return
	 */
	public String invalid_text(){
		waitForElement(invalidError_text, 10);
		return driver.findElement(invalidError_text).getText();
	}
	
	/**
	 * This method is used to Locate the Leave type Header
	 */
	public void displayedLeaveTypeHeader(){
		waitForElement(leaveTypeHeader, 30);
		if(driver.findElement(leaveTypeHeader).isDisplayed()){
			LeaveSummary_page_pageLog.info("Application Located the Leave Type header in the Leave Summary Balance");
		}else{
			LeaveSummary_page_pageLog.info("Application Unable to Locate the Leave Type header in the Leave Summary Balance");
		}
	}
}
