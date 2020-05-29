package com.mu_sigma.OrgPlatformAutomationFramework.LeaveManagement.page;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;

public class GrantLeave_page extends TestBase{
	WebDriver driver;
	private static final Logger GrantLeave_pageLog = LogManager.getLogger(GrantLeave_page.class.getName());
	
	
	By grnatLeave_tab=By.xpath("//h4[contains(text(),'Grant Leave')]");
	By grantLeave_btn=By.xpath("//span[@class='mat-button-wrapper' and contains(text(),'Grant Leave')]");
	By grantLeaveAddGrantEditEmpName_inpuBox=By.xpath("(//input[@id='empSearch'])[2]");
	By grantLeaveSelectLeaveTypeDropDown_icon=By.xpath("(//div[@class='mat-select-arrow-wrapper'])[5]//div[@class='mat-select-arrow']");
	By addGrantTimePeriod_dropDownIcon=By.xpath("(//div[@class='mat-select-arrow-wrapper']//div[@class='mat-select-arrow'])[6]");
	By addGrantNoOfLeaves=By.xpath("//input[@formcontrolname='leavesGranted']");
	By grantLeaveAddrGrantSave_btn=By.xpath("//span[@class='mat-button-wrapper' and contains(text(),'Save')]");
	By grantLeaveAddrGrantClose_btn=By.xpath("//span[@class='mat-button-wrapper' and contains(text(),'Close')]");
	By saveSchemePopUpYes_btn=By.xpath("//span[contains(text(),'Yes')]");
	By addGrantNoApplicableLeave_errorMsg=By.xpath("//div[contains(text(),'No applicable leave schemes for this employee')]");
	By addGrantCalendarIcon=By.xpath("(//button[@class='mat-icon-button'])[2]");
	By noofDayToLapse_inputBox=By.xpath("//input[@placeholder='Number of days to lapse']");
	By lapsesComment_inputBox=By.xpath("//input[@placeholder='Comment']");
	By lapse_btn=By.xpath("//span[contains(text(),'Lapse')]");
	By lapseCancel_btn=By.xpath("//span[contains(text(),'Cancel')]");
	By lapseError_msg=By.xpath("//simple-snack-bar[contains(@class,'mat-simple-snackbar')]");
	By lapseSuccess_msg=By.xpath("//simple-snack-bar[contains(@class,'mat-simple-snackbar')]");
	By addGrantClose_btn=By.xpath("//span[@class='mat-button-wrapper' and contains(text(),'Close')]");
	By periodicLeaves_errMsg=By.xpath("//simple-snack-bar[contains(text(),'Cannot grant leaves for past date')]");
	By periodicLeaves_successMsg=By.xpath("//simple-snack-bar[contains(text(),'Success')]");
	By nonPeriodicLeaves_errMsg=By.xpath("//simple-snack-bar[contains(text(),'Reached the maximum quota for the given leave type, you cannot grant more leaves')]");
	By nonPeriodicValidity_errMsg=By.xpath("//simple-snack-bar[contains(text(),'Cannot grant leaves outside scheme validity')]");
	By validFrom_calendarIcon=By.xpath("(//button[@class='mat-icon-button'])[2]");
	
	public GrantLeave_page(WebDriver driver){
		this.driver=driver;
	}
	
	/**
	 * This method is used to click on the Grant Leave Tab
	 */
	public void clickOnGrantLeaveTab() {
		try {
			clickWhenElementIsReady(driver, 20, grnatLeave_tab);
			GrantLeave_pageLog.info("Application Clicked on Grant Leave Tab");
		} catch (Exception e) {
			GrantLeave_pageLog.info("Application Unable to Clicked on Grant Leave Tab");
		}
	}
	
	/**
	 * This method is used to click on the Calendar Icon
	 */
	public void clickValidFromCalendar_icon(){
		try {
			clickWhenElementIsReady(driver, 20, validFrom_calendarIcon);
			GrantLeave_pageLog.info("Application Clicked on Valid from Calendar Icon");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * This method is used to clear the Number of Leave field
	 */
	public void clearNoOfLeavesField(){
		try {
			waitForElement(addGrantNoOfLeaves,30);
			driver.findElement(addGrantNoOfLeaves).clear();
			GrantLeave_pageLog.info("Cleared the Numbers of Leave field");
		} catch (Exception e) {
			GrantLeave_pageLog.info("Unable to clear the Numbers of Leave field");
		}
	}
	
	/**
	 * This method is used to click on the Grant Leave button
	 */
	public void clickOnGrantLeaveBtn() {
		try {
			clickWhenElementIsReady(driver, 20, grantLeave_btn);
			GrantLeave_pageLog.info("Application Clicked on Grant Leave Button");
		} catch (Exception e) {
			GrantLeave_pageLog.info("Application Unable to Clicked on Grant Leave Button");
		}
	}
	
	/**
	 * This method is used to Select the Employee From Grant Leave tab
	 * 
	 * @param employeePartialName
	 * @param employeeActualName
	 * @throws Exception
	 */
	public void selectEmployeefromAddGrantPopUp(String employeePartialName, String employeeActualName) throws Exception {
		try {
			waitForElement(grantLeaveAddGrantEditEmpName_inpuBox, 30);
			driver.findElement(grantLeaveAddGrantEditEmpName_inpuBox).sendKeys(employeePartialName);
			WebElement parentElement = driver.findElement(By.xpath(
					"//mat-option[@fxlayoutalign='space-between stretch']//span[@class='mat-option-text']//div[2]"));
			List<WebElement> celement = parentElement.findElements(By.tagName("div"));
			for (WebElement suggestion : celement) {
				suggestion.getText().equals(employeeActualName);
				suggestion.click();
				break;
			}
			GrantLeave_pageLog.info("Employee Selected");
		} catch (Exception e) {
			GrantLeave_pageLog.info("Application unbale to select the Employee");
		}
	}
	

	/**
	 * This method is used to Select the Leave Type from Grant Leave Type
	 * 
	 * @param leaveTypeName it should be applied leave
	 */
	public void selectTypeofLeave(String leaveTypeName) {
		try {
			clickWhenElementIsReady(driver, 30, grantLeaveSelectLeaveTypeDropDown_icon);
			WebElement element = driver.findElement(
					By.xpath("//mat-option[@role='option']//span[contains(text(),'" + leaveTypeName + "')]"));
			waitForElement(element,20);
			element.click();
			GrantLeave_pageLog.info("Element is displayed and Clicked on Leave Type");
		} catch (Exception e) {
			GrantLeave_pageLog.info("Element is not displayed and unable to click on Leave Type");
		}
	}
	
	/**
	 * This method is used to select the time period data from Add grant pop up message
	 * @param quaterWiseData User needs to giver periodic leave Data (Ex:Q1/Q2 etc..)
	 */
	public void grantLeaveSelectPeriodicLeaveTimePeriod(String quaterWiseData){
		try {
			clickWhenElementIsReady(driver, 20, addGrantTimePeriod_dropDownIcon);
			WebElement element=driver.findElement(By.xpath("//mat-option[@role='option']//span[contains(text(),'"+quaterWiseData+"')]"));
			clickWhenElementIsReady(driver, 20, element);
			GrantLeave_pageLog.info("Clicked on Time period as "+quaterWiseData);
		} catch (Exception e) {
			GrantLeave_pageLog.info("Application unable to clicked on Time period as "+quaterWiseData);
		}
	}
	
	/**
	 * This method is used grant of number of leaves 
	 * @param noOfLeaves
	 */
	public void grantNoOfLeaves(String noOfLeaves){
		try {
			waitForElement(addGrantNoOfLeaves, 16);
			driver.findElement(addGrantNoOfLeaves).sendKeys(noOfLeaves);
			GrantLeave_pageLog.info("Edited the numbers of leave");
		} catch (Exception e) {
			GrantLeave_pageLog.info("Unable to edit the numbers of leave");
		}
	}
	
	/**
	 * This method is used to click on the Save button from Add Grant Leave pop up 
	 */
	public void clickAddGrant_saveBtn() {
		try {
			clickWhenElementIsReady(driver, 10, grantLeaveAddrGrantSave_btn);
			GrantLeave_pageLog.info("Clicked on Save button from Add Grant Leave pop up successfully");
		} catch (Exception e) {
			GrantLeave_pageLog.info("Unable to Click on Save button from Add Grant Leave pop up successfully");
		}
	}
	
	public void clickAddGrant_closeBtn() {
		try {
			clickWhenElementIsReady(driver, 10, grantLeaveAddrGrantClose_btn);
			GrantLeave_pageLog.info("Clicked on Save button from Add Grant Leave pop up successfully");
		} catch (Exception e) {
			GrantLeave_pageLog.info("Unable to Click on Save button from Add Grant Leave pop up successfully");
		}
	}
	
	/**
	 * This method is used to save the Newly Granted leave pop up 
	 */
	public void clickOnSaveSchemePopUp() {
		try {
			clickWhenElementIsReady(driver, 5, saveSchemePopUpYes_btn);
			GrantLeave_pageLog.info("Clicked Yes pop up button");
		} catch (Exception e) {
			GrantLeave_pageLog.info("Unable to click on Yes pop up button");
			e.printStackTrace();
		}
	}
	
	/**
	 * This method is used to click on close button from Add Grant pop up
	 */
	public void clickOnAddGrantClose(){
		try {
			clickWhenElementIsReady(driver, 10, addGrantClose_btn);
			GrantLeave_pageLog.info("Closed the add grant pop up message");
		} catch (Exception e) {
			GrantLeave_pageLog.info("Unable to closed the add grant pop up message");
		}
	}
	
	/**
	 * This method is used to get the "No applicable leave" error message from
	 * Add grant pop up
	 * 
	 * @return This will return text as "No applicable leave schemes for this
	 *         employee"
	 */
	public String noApplicableError_msg() {
			waitForElement(addGrantNoApplicableLeave_errorMsg, 4);
			return driver.findElement(addGrantNoApplicableLeave_errorMsg).getText();
	}
	
	/*
	 * This method is used to click on calendar icon from Add Grant pop up
	 */
	public void clickOnValidForm_icon(){
		try {
			clickWhenElementIsReady(driver, 17, addGrantCalendarIcon);
			GrantLeave_pageLog.info("Application clicked on calendar icon from Add Grant pop up");
		} catch (Exception e) {
			GrantLeave_pageLog.info("Application unable to clicked on calendar icon from Add Grant pop up");
		}
	}
	
	
	/*public boolean checkNoapplicableError_msg(){
		waitForElement(addGrantNoApplicableLeave_errorMsg, 4);
		return addGrantNoApplicableLeave_errorMsg.isDisplayed();
	}*/
	
	/**
	 * This method will return "Cannot grants leaves for past date" 
	 * while granting Periodic leave   
	 * @return
	 */
	public String pastDateleavesError_msg(){
		try {
			waitForElement(periodicLeaves_errMsg,7);
			GrantLeave_pageLog.info("Application able to locate the Message as  "+driver.findElement(periodicLeaves_errMsg).getText());
			return driver.findElement(periodicLeaves_errMsg).getText();
		} catch (Exception e) {
			GrantLeave_pageLog.info("Application unable to locate the Message as  ");
			return null;
		}
	}
	
	/**
	 * This method will return "Success" message
	 * while granting valid Periodic Leave
	 * @return
	 */
	public String successLeaves_msg(){
		try {
			waitForElement(periodicLeaves_successMsg, 8);
			GrantLeave_pageLog.info("Application able to locate the Message as  "+driver.findElement(periodicLeaves_successMsg).getText());
			return driver.findElement(periodicLeaves_successMsg).getText();
		} catch (Exception e) {
			GrantLeave_pageLog.info("Application unable to locate the Message as  ");
			return null;
		}
	}
	
	/**
	 * This method will give the error message when user Reached the maximum quota
	 * for the given leave type
	 * 
	 * @return will return invalid error message
	 */
	public String nonPeriodicInvalid_msg() {
		try {
			waitForElement(nonPeriodicLeaves_errMsg, 8);
			GrantLeave_pageLog.info("Application able to locate the Message as  " + driver.findElement(nonPeriodicLeaves_errMsg).getText());
			return driver.findElement(nonPeriodicLeaves_errMsg).getText();
		} catch (Exception e) {
			GrantLeave_pageLog
					.info("Application unable to locate the Message as  ");
			return null;
		}
	}
	
	/**
	 * This method will give the error message when user try to grant the leave
	 * outside scheme vaidity
	 * 
	 * @return
	 */
	public String nonPeriodicValidityerror_msg() {
		try {
			waitForElement(nonPeriodicValidity_errMsg, 8);
			GrantLeave_pageLog
					.info("Application able to locate the Message as  " + driver.findElement(nonPeriodicValidity_errMsg).getText());
			return driver.findElement(nonPeriodicValidity_errMsg).getText();
		} catch (Exception e) {
			GrantLeave_pageLog
					.info("Application unable to locate the Message as  ");
			return null;
		}
	}
	
	/**
	 * This method is used to lapses the granted leave  
	 * @param lapseGrantNo
	 */
	public void clickonLapseButton_icon(int lapseGrantNo) {
		List<WebElement> elements = driver.findElements(By.xpath("(//i[contains(text(),'cancel')])"));
		int size = elements.size();
		for (int i = 0; i < size; i++) {
			try {
				if (i == (lapseGrantNo - 1)) {
					GrantLeave_pageLog.info("Application lapses granted Leave is given as " + lapseGrantNo + "which is valid");
					elements.get(i).click();
					break;
				}
			} catch (Exception e) {
				GrantLeave_pageLog.info("The lapses granted Leave is given as " + lapseGrantNo + "which is invalid");
			}
		}
	}
	
	/**
	 * This method is used to edit the No of Days Leave to Lapse field 
	 */
	public void editNoOfToLapseLeaveField(String noOfDays){
		try {
			waitForElement(noofDayToLapse_inputBox, 9);
			driver.findElement(noofDayToLapse_inputBox).sendKeys(noOfDays);
			GrantLeave_pageLog.info("Successfully Edit the no of lapse"+noOfDays);
		} catch (Exception e) {
			GrantLeave_pageLog.info("unable to Edit the no of lapse leave");
		}
	}
	
	/**
	 * This method is used to edit the Comments filed while lapses the grant leave
	 * @param comments
	 */
	public void editCommentToLapseLeaveField(String comments){
		try {
			waitForElement(lapsesComment_inputBox, 10);
			driver.findElement(lapsesComment_inputBox).sendKeys(comments);
			GrantLeave_pageLog.info("Successfully edit comments");
		} catch (Exception e) {
			GrantLeave_pageLog.info("unable to edit comments");
		}
	}
	
	/**
	 * This method is used to click on Lapse button
	 */
	public void clickOnLapse_btn(){
		try {
			clickWhenElementIsReady(driver, 9, lapse_btn);
			GrantLeave_pageLog.info("Cliked on Lapse nutton");
		} catch (Exception e) {
			GrantLeave_pageLog.info("Unable to clik on Lapse nutton");
		}
	}
	
	/**
	 * This method is used to retrive leave lapses the error message  
	 * @return
	 */
	public String getLeaveLapsesError_msg(){
		try {
			//waitForElement(lapseError_msg, 6);
			waitForElement(lapseError_msg, 5);
			GrantLeave_pageLog.info("Successfully retrive the error message as "+driver.findElement(lapseError_msg).getText());
			return driver.findElement(lapseError_msg).getText();
		} catch (Exception e) {
			GrantLeave_pageLog.info("Unable to retrive the error message as ");
			return null;
		}
	}
	
	/**
	 * This method is used to retrieve leave lapses the success message  
	 * @return
	 */
	public String getLeaveLapsesSuccess_msg(){
		try {
			waitForElement(lapseSuccess_msg, 6);
			GrantLeave_pageLog.info("Successfully retrive the error message as "+driver.findElement(lapseSuccess_msg).getText());
			return driver.findElement(lapseSuccess_msg).getText();
		} catch (Exception e) {
			GrantLeave_pageLog.info("Unable to retrive the error message as ");
			return null;
		}
	}
	
	/**
	 * This method is used to click on Leave Lapse Cancel button
	 */
	public void clickOnLeaveLapseCancel_btn(){
		try {
			clickWhenElementIsReady(driver, 9, lapseCancel_btn);
			GrantLeave_pageLog.info("Successfully Clicked on leave Lapse Cancel button");
		} catch (Exception e) {
			GrantLeave_pageLog.info("Unable to click on leave Lapse Cancel button");
		}
	}


}
