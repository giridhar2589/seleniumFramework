package com.mu_sigma.OrgPlatformAutomationFramework.LeaveManagement.page;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;

public class UserView_page extends TestBase {

	WebDriver driver;

	private static final Logger userVIew_pageLog = LogManager
			.getLogger(UserView_page.class.getName());

	By selectLeaveTypeDropDown_icon=By.xpath("(//div[@class='mat-select-arrow-wrapper'])[1]//div[@class='mat-select-arrow']");

	By fromCalendar_icon=By.xpath("(//button[@class='mat-icon-button'])[2]");
	By toCalendar_icon=By.xpath("(//button[@class='mat-icon-button'])[3]");
	By fromSession1_radioBtn=By.xpath("(//label[@class='mat-radio-label']//div[@class='mat-radio-container'])[1]");
	By fromSession2_radioBtn=By.xpath("(//label[@class='mat-radio-label']//div[@class='mat-radio-container'])[2]");
	By toSession1_radioBtn=By.xpath("(//label[@class='mat-radio-label']//div[@class='mat-radio-container'])[3]");
	By toomSession2_radioBtn=By.xpath("(//label[@class='mat-radio-label']//div[@class='mat-radio-container'])[4]");
	By reasonOfAbsence_inputBox=By.xpath("//input[@formcontrolname='reason']");
	By approver_manager1=By.xpath("(//label[@class='mat-radio-label']//div[@class='mat-radio-container'])[5]");
	By approver_manager2=By.xpath("(//label[@class='mat-radio-label']//div[@class='mat-radio-container'])[6]");
	By leaveApply_btn=By.xpath("//span[@class='mat-button-wrapper' and contains(text(),'Apply')]");
	By getLeave_Count=By.xpath("//small[@class='ng-star-inserted']");
	By clear_btn=By.xpath("//span[@class='mat-button-wrapper' and contains(text(),'Clear')]");
	By leaveWithdraw_btn=By.xpath("//span[@class='mat-button-wrapper' and contains(text(),'Withdraw')]");
	By leaveReminder_btn=By.xpath("//span[@class='mat-button-wrapper' and contains(text(),'Reminder')]");
	By appliedLeave_closebtn=By.xpath("//i[contains(text(),'close')]");
	By withdrawPopUp_YesBtn=By.xpath("//span[contains(text(),'Yes')]");
	By withdrawPopUp_NoBtn=By.xpath("//button[@class='mat-button']//span[contains(text(),'No')]");
	By reminderMsg=By.xpath("//simple-snack-bar[contains(text(),'Reminder sent successfully.')]");
	//By overlapLeave_error=By.xpath("//mat-error[@role='alert' and contains(text(),'Overlap of date for leave')]");
	By overlapLeave_error=By.xpath("//mat-error[@role='alert']");
	By weekendLeave_error=By.xpath("//mat-error[@role='alert' and contains(text(),'Select valid days')]");
	By minimumLeave_error=By.xpath("//mat-error[@role='alert' and contains(text(),'Minimum number of days can be applied is 1.0')]");
	By leaveCreationSuccess_msg=By.xpath("//simple-snack-bar[contains(@class,'mat-simple-snackbar')]");
	By nextYearLOPError_msg=By.xpath("//mat-error[@role='alert' and contains(text(),'Can't be applied for next year')]");
	By leaveWithdraw_msg=By.xpath("//simple-snack-bar[contains(@class,'mat-simple-snackbar')]");
	By lopLeavescehem_errorMsg=By.xpath("//mat-error[@role='alert' and contains(text(),'Use available leaves before applying for LOP')]");
	By reminder_msg=By.xpath("//simple-snack-bar[contains(@class,'mat-simple-snackbar')]");
	By compOffValidity_errorMsg=By.xpath("//mat-error[@role='alert' and contains(text(),'For the selected date range, the available number of Comp Off are 0.0')]");
	public UserView_page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * This method is used to Select the Leave Type 
	 * 
	 * @param leaveTypeName it should be applied leave
	 */
	public void selectTypeofLeave(String leaveTypeName) {
		clickWhenElementIsReady(driver,30, selectLeaveTypeDropDown_icon);
		WebElement element = driver
				.findElement(By.xpath("//mat-option[@role='option']//span[contains(text(),'" + leaveTypeName + "')]"));
		if (element.isDisplayed()) {
			clickWhenElementIsReady(driver, 25, element);
			userVIew_pageLog.info("Clicked on Leave Type as" +leaveTypeName);
		} else {
			userVIew_pageLog
					.info("unable to click on Leave Type as" + leaveTypeName);
		}
	}
	
	/**
	 * This method is used to click on clear button
	 */
	public void clickOnClear_btn(){
		try {
			clickWhenElementIsReady(driver, 9, clear_btn);
			userVIew_pageLog.info("Application clicked on clear button");
		} catch (Exception e) {
			userVIew_pageLog.info("Application unable to clicked on clear button");
		}
		
	}

	/**
	 * This method is used to click on Scheme Validity Form Date Icon
	 */
	public void clickOnFormCalendarIcon() {
		try {
			clickWhenElementIsReady(driver, 80, fromCalendar_icon);
			userVIew_pageLog.info("Application able to clicked on Form Claendar Icon");
		} catch (Exception e) {
			userVIew_pageLog.info("Application Unable to clicked on Form Claendar Icon");
			e.printStackTrace();
		}
	}

	/**
	 * This method is used to click on Scheme Validity Form Date Icon
	 */
	public void clickOnToCalendarIcon() {
		try {
			clickWhenElementIsReady(driver, 80, toCalendar_icon);
			userVIew_pageLog.info("Application able to clicked on To Claendar Icon");
		} catch (Exception e) {
			userVIew_pageLog.info("Application Unable to clicked on To Claendar Icon");
			e.printStackTrace();
		}
	}


	/**
	 * This method is used to select the manager
	 */
	public void selectFirstApprover() {
		try {
			clickWhenElementIsReady(driver, 50, approver_manager1);
			userVIew_pageLog.info("Application able to select the First Manager");
		} catch (Exception e) {
			userVIew_pageLog.info("Application Unable to select the First Manager");
		}
	}

	/**
	 * This method is used to click on Apply Leave button
	 */
	public void applyLeave() {
		try {
			clickWhenElementIsReady(driver, 60, leaveApply_btn);
			userVIew_pageLog.info("Application Clicked on Apply button");
		} catch (Exception e) {
			userVIew_pageLog.info("Application Unable to click on Apply button");
		}
	}
	
	/**
	 * This method is used to check the Recent applied leave 
	 * @param appliedLeaveTypeName should be the Applied leave Name
	 * @param leaveNo the position of the applied leave
	 */
	public void recentActivity(String appliedLeaveTypeName, int leaveNo) {
		try {
			List<WebElement> ele = driver.findElements(By
					.xpath("//mat-nav-list[@role='navigation']//div[contains(text(),'" + appliedLeaveTypeName + "')]"));
			userVIew_pageLog.info(appliedLeaveTypeName + " Leave is applied" + "  " + ele.size() + "Times");
			for (int i = 0; i < ele.size(); i++) {
				if (i == leaveNo - 1) {
					userVIew_pageLog.info("Application is going to click on" + ele.get(i) + "th Element");
					ele.get(i).click();
					userVIew_pageLog.info("Application click on" + ele.get(i) + "th Element Successfully");
					break;
				}
			}
		} catch (Exception e) {
			userVIew_pageLog.info("Application unable to click on recent Activity Leave");
			e.printStackTrace();
		}
	}

	/**
	 * This method is used to Withdraw the applied leave
	 */
	public void withDrawAppliedLeave() {
		try {
			clickWhenElementIsReady(driver, 80, leaveWithdraw_btn);
			userVIew_pageLog.info("Application Withdraw the applied Leave");
		} catch (Exception e) {
			userVIew_pageLog.info("Application Unable Withdraw the applied Leave");
			e.printStackTrace();
		}
	}

	/**
	 * This method is used to click No button from withdraw pop up message
	 */
	public void clickOnNoWithdrwaPop_msg() {
		try {
			clickWhenElementIsReady(driver, 30, withdrawPopUp_NoBtn);
			userVIew_pageLog.info("Application clicked on No button from Withdraw pop up message");
		} catch (Exception e) {
			userVIew_pageLog.info("Application unable clicked on No button from Withdrwa pop up message");
		}
	}

	/**
	 * This method is used to close the Applied leave pop up message
	 */
	public void closeAppliedLeave_popUp() {
		try {
			clickWhenElementIsReady(driver, 30, appliedLeave_closebtn);
			userVIew_pageLog.info("Closed the applied leave pop up message");
		} catch (Exception e) {
			userVIew_pageLog.info("Unable to Close the applied leave pop up message");
		}
	}
	
	/**
	 * This method is used to click on the reminder button
	 */
	public void clickReminder_btn(){
		try {
			clickWhenElementIsReady(driver, 30,leaveReminder_btn);
			userVIew_pageLog.info("Clicked on reminder button");
		} catch (Exception e) {
			userVIew_pageLog.info("Unable to clicked on reminder button");
			e.printStackTrace();
		}
	}
	
	/**
	 * This method is used to edit leave reason
	 * @param reason need to give the leave reason as string
	 */
	public void editLeaveReason(String reason){
		waitForElement(reasonOfAbsence_inputBox, 30);
		driver.findElement(reasonOfAbsence_inputBox).sendKeys(reason);
	}
	
	/**
	 * This method is used to clean edit leave reason
	 * @param reason need to give the leave reason as string
	 */
	public void clearEditLeaveReason(){
		waitForElement(reasonOfAbsence_inputBox, 30);
		driver.findElement(reasonOfAbsence_inputBox).clear();
	}
	
	/**
	 * This method is used to clear the edit leave reason field
	 */
	public void clearEditLeaveReasonField(){
		try {
			waitForElement(reasonOfAbsence_inputBox, 30);
			driver.findElement(reasonOfAbsence_inputBox).clear();
			userVIew_pageLog.info("Cleared the edit leave reason field");
		} catch (Exception e) {
			userVIew_pageLog.info("Unable to clear the edit leave reason field");
		}
	}
	
	/**
	 * This method is used to select the From session 1
	 */
	public void selectFromsession1(){
		try {
			waitForElement(fromSession1_radioBtn, 20);
			driver.findElement(fromSession1_radioBtn).click();
			userVIew_pageLog.info("Clicked on From Session 1");
		} catch (Exception e) {
			userVIew_pageLog.info("Unable to Clicked on From Session 1");
		}
	}
	
	/**
	 * This method is used to select the From session 2
	 */
	public void selectFromsession2(){
		try {
			//clickWhenElementIsReady(driver, 30, fromSession2_radioBtn);
			waitForElement(fromSession2_radioBtn, 20);
			driver.findElement(fromSession2_radioBtn).click();
			userVIew_pageLog.info("Clicked on From Session 2");
		} catch (Exception e) {
			userVIew_pageLog.info("Unable to Clicked on From Session 2");
		}
	}
	
	/**
	 * This method is used to select the To session 1
	 */
	public void selectTosession1(){
		try {
			//clickWhenElementIsReady(driver, 30, toSession1_radioBtn);
			waitForElement(toSession1_radioBtn, 20);
			driver.findElement(toSession1_radioBtn).click();
			userVIew_pageLog.info("Clicked on To Session 1");
		} catch (Exception e) {
			userVIew_pageLog.info("Unable to Clicked on To Session 1");
		}
	}
	
	/**
	 * This method is used to select the To session 1
	 */
	public void selectTosession2(){
		try {
			//clickWhenElementIsReady(driver, 30, toomSession2_radioBtn);
			waitForElement(toomSession2_radioBtn, 20);
			driver.findElement(toomSession2_radioBtn).click();
			userVIew_pageLog.info("Clicked on To Session 2");
		} catch (Exception e) {
			userVIew_pageLog.info("Unable to Clicked on To Session 2");
		}
	
	}
	
	/**
	 * This method is used to click on the Yes pop up button
	 */
	public void selectWithdrawPopUp_YesBtn(){
		try {
			clickWhenElementIsReady(driver, 30, withdrawPopUp_YesBtn);
			userVIew_pageLog.info("Clicked on Withdraw Yes button");
		} catch (Exception e) {
			userVIew_pageLog.info("Unable to Clicked on Withdraw Yes button");
		}
	}
	
	/**
	 * This method is used to get the overlap error message
	 * @return
	 */
	public String overlapLeaveError(){
		waitForElement(overlapLeave_error, 10);
		return driver.findElement(overlapLeave_error).getText();
	}
	

	
	/**
	 * This method is used to get the success message on leave creation
	 * @return
	 */
	public String leaveCreationSucess_msg(){
		//waitForElement(leaveCreationSuccess_msg, 3);
		return driver.findElement(leaveCreationSuccess_msg).getText();
	}
	
	/**
	 * This method is used to get Weekend error message
	 * @return It will return String
	 */
	public String weekendLeaveError(){
		waitForElement(weekendLeave_error, 10);
		return driver.findElement(weekendLeave_error).getText();
	}
	
	/**
	 * This method will give error message when user try to apply LOP when he/she has other leaves
	 * @return
	 */
	public String avilableLeaveLOPError(){
		try {
			waitForElement(lopLeavescehem_errorMsg,10);
			userVIew_pageLog.info("Application found the error message as  "+driver.findElement(lopLeavescehem_errorMsg).getText());
			return driver.findElement(lopLeavescehem_errorMsg).getText();
		} catch (Exception e) {
			userVIew_pageLog.info("Application unable found the error message as  ");
			return null;
		}
	}
	
	/**
	 * This method is used to get the error message for comp off leave scheme when user try to apply comp off before valid from date 
	 */
	public String compOffValidityError(){
		try {
			waitForElement(compOffValidity_errorMsg,10);
			userVIew_pageLog.info("Application found the error message as  "+driver.findElement(compOffValidity_errorMsg).getText());
			return driver.findElement(compOffValidity_errorMsg).getText();
		} catch (Exception e) {
			userVIew_pageLog.info("Application unable found the error message as  ");
			return null;
		}
	}
	
	/**
	 * This method is used to get Minimum leave Error
	 * @return
	 */
	public String minimumLeaveError(){
		waitForElement(minimumLeave_error, 10);
		return driver.findElement(minimumLeave_error).getText();
	}
	
	/**
	 * This method is used to get the Leave Withdraw message
	 * @return It will will return String 
	 */
	public String getWithdraw_msg(){
		waitForElement(leaveWithdraw_msg, 3);
		return driver.findElement(leaveWithdraw_msg).getText();
	}
	
	/**
	 * This method is used to get the Leave Reminder message
	 * @return
	 */
	public String leaveReminder_msg(){
		waitForElement(reminder_msg, 3);
		return driver.findElement(reminder_msg).getText();
	}
	
	/*
	 * This method is used to get the count of 
	 */
	public String getApplyLeave_count(){
		try {
			waitForElement(getLeave_Count, 20);
			userVIew_pageLog.info("Application return the Count of Leave As  :"+driver.findElement(getLeave_Count).getText());
			return driver.findElement(getLeave_Count).getText();
		} catch (Exception e) {
			userVIew_pageLog.info("Application unable return the Count of Leave ");
			return null;
		}
	}
	
	/**
	 * This method will return the error message when user try to apply LOP
	 * leave scheme to the next year
	 * 
	 * @return
	 */
	public String getnextYearLOPError_msg() {
		try {
			waitForElement(nextYearLOPError_msg, 20);
			userVIew_pageLog
					.info("Application return the next year LOP error msg as   :" + driver.findElement(nextYearLOPError_msg).getText());
			return driver.findElement(nextYearLOPError_msg).getText();
		} catch (Exception e) {
			userVIew_pageLog.info("Application unable to return the next year LOP error msg");
			return null;
		}
	}
	
}
