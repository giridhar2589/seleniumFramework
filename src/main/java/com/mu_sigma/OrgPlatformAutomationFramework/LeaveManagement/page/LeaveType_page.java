package com.mu_sigma.OrgPlatformAutomationFramework.LeaveManagement.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;

/**
 * 
 * @author biswajit.kundu
 *
 */
public class LeaveType_page extends TestBase {

	WebDriver driver;

	private static final Logger LeaveType_pageLog = LogManager.getLogger(LeaveType_page.class.getName());

	By leaveTypeTab = By.xpath("//h4[contains(text(),'Leave Type')]");
	By addLeaveTypeBtn = By.xpath("//span[contains(text(),'Add Leave Type')]");
	By leaveTypeName_inputBox = By.xpath("//input[@name='name']");
	By leaveTypeDescription_inputBox = By.xpath("//input[@name='description']");
	By leaveWithOutPay_checkBox = By.xpath("(//div[@class='mat-checkbox-inner-container'])[1]");
	By grantRequired_checkBox = By.xpath("(//div[@class='mat-checkbox-inner-container'])[2]");
	By vissibleToUser_checkBox = By.xpath("(//div[@class='mat-checkbox-inner-container'])[3]");
	By canUserApply_checkBox = By.xpath("(//div[@class='mat-checkbox-inner-container'])[4]");
	By leaveTypeSuccess_msg = By.xpath("//simple-snack-bar[contains(text(),'Leave Type added successfully')]");
	By leaveTypeDuplicate_msg = By.xpath("//simple-snack-bar[contains(@class,'mat-simple-snackbar')]");
	By leaveType_SaveButton = By
			.xpath("//button[@class='mat-button']//preceding-sibling::span[contains(text(),'Save')]");
	By leaveType_CancelButton = By
			.xpath("//button[@class='mat-button']//preceding-sibling::span[contains(text(),'Cancel')]");

	public LeaveType_page(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * This method is used to navigate Leave Type tab
	 */
	public void clickOnLeaveTypeTab() {
		try {
			clickWhenElementIsReady(driver, 20, leaveTypeTab);
			LeaveType_pageLog.info("Clicked on Leave Type tab");
		} catch (Exception e) {
			LeaveType_pageLog.info("Unable to clicked on Leave Type tab");
		}
	}

	/**
	 * This method is used to create the Earn Leave Type
	 * 
	 * @param leavetypeName
	 *            it should be in String data type
	 */
	public void createEarnLeaveType(String leavetypeName) {
		try {
			clickWhenElementIsReady(driver, 10, addLeaveTypeBtn);
			waitForElement(leaveTypeName_inputBox, 8);
			driver.findElement(leaveTypeName_inputBox).sendKeys(leavetypeName);
			clickWhenElementIsReady(driver, 10, leaveType_SaveButton);
			LeaveType_pageLog.info("Created Earn Leave type");
		} catch (Exception e) {
			LeaveType_pageLog.info("Unable to create Earn Leave type");
		}
	}

	/**
	 * This method is used to create the Comp off Leave Type
	 * 
	 * @param leavetypeName
	 *            it should be in String data type
	 */
	public void createCompOffLeaveType(String leavetypeName) {
		try {
			clickWhenElementIsReady(driver, 10, addLeaveTypeBtn);
			waitForElement(leaveTypeName_inputBox, 8);
			driver.findElement(leaveTypeName_inputBox).sendKeys(leavetypeName);
			clickWhenElementIsReady(driver, 10, leaveType_SaveButton);
			LeaveType_pageLog.info("Created Comp off Leave type");
		} catch (Exception e) {
			LeaveType_pageLog.info("Unable to create Comp off Leave type");
		}
	}

	/**
	 * This method is used to create the On Duty Leave Type
	 * 
	 * @param leavetypeName
	 *            leavetypeName it should be in String data type
	 */
	public void createOnDutyLeaveScheme(String leavetypeName) {
		try {
			clickWhenElementIsReady(driver, 10, addLeaveTypeBtn);
			waitForElement(leaveTypeName_inputBox, 8);
			driver.findElement(leaveTypeName_inputBox).sendKeys(leavetypeName);
			clickWhenElementIsReady(driver, 10, grantRequired_checkBox);
			clickWhenElementIsReady(driver, 10, canUserApply_checkBox);
			clickWhenElementIsReady(driver, 10, leaveType_SaveButton);
			LeaveType_pageLog.info("Created On Duty Leave type");
		} catch (Exception e) {
			LeaveType_pageLog.info("Unable to create On Duty Leave type");
		}
	}

	/**
	 * This method is used to create the On Duty Leave Type
	 * 
	 * @param leavetypeName
	 *            leavetypeName it should be in String data type
	 */
	public void createLOPLeaveScheme(String leavetypeName) {
		try {
			clickWhenElementIsReady(driver, 10, addLeaveTypeBtn);
			waitForElement(leaveTypeName_inputBox, 8);
			driver.findElement(leaveTypeName_inputBox).sendKeys(leavetypeName);
			clickWhenElementIsReady(driver, 10, leaveWithOutPay_checkBox);
			clickWhenElementIsReady(driver, 10, grantRequired_checkBox);
			clickWhenElementIsReady(driver, 10, leaveType_SaveButton);
			LeaveType_pageLog.info("Created LOP Leave type");
		} catch (Exception e) {
			LeaveType_pageLog.info("Unable to create LOP Leave type");
		}
	}

	/**
	 * This method is used to create the Leave Exemption Leave Type
	 * 
	 * @param leavetypeName
	 *            leavetypeName it should be in String data type
	 */
	public void createLeaveExemption(String leavetypeName) {
		try {
			clickWhenElementIsReady(driver, 10, addLeaveTypeBtn);
			waitForElement(leaveTypeName_inputBox, 8);
			driver.findElement(leaveTypeName_inputBox).sendKeys(leavetypeName);
			clickWhenElementIsReady(driver, 10, grantRequired_checkBox);
			clickWhenElementIsReady(driver, 10, vissibleToUser_checkBox);
			clickWhenElementIsReady(driver, 10, canUserApply_checkBox);
			clickWhenElementIsReady(driver, 10, leaveType_SaveButton);
			LeaveType_pageLog.info("Created Leave Exemption Leave type");
		} catch (Exception e) {
			LeaveType_pageLog.info("Unable to create Leave Exemption Leave type");
		}
	}

	/**
	 * This method is used to get the success message after leave type
	 * 
	 * @return
	 */
	public String getLeaveTypeAddedSuccess_msg() {
		try {
			LeaveType_pageLog.info("successfuly retrive the success message");
			waitForElement(leaveTypeSuccess_msg, 9);
			return driver.findElement(leaveTypeSuccess_msg).getText();
		} catch (Exception e) {
			LeaveType_pageLog.info("unable to  retrive the success message as");
			return null;
		}
	}

	/**
	 * This method is used to get the duplicate leave type creation error
	 * message
	 * 
	 * @return
	 */
	public String getDuplicateLeaveTypeError_msg() {
		try {
			waitForElement(leaveTypeDuplicate_msg, 5);
			LeaveType_pageLog.info("successfuly retrive the Error message");
			return driver.findElement(leaveTypeDuplicate_msg).getText();
		} catch (Exception e) {
			LeaveType_pageLog.info("successfuly retrive the Error message");
			return null;
		}
	}

	/**
	 * This method is used to click on Leave Type Cancel button
	 */
	public void clickOnLeaveTypeCancel_btn() {
		try {
			clickWhenElementIsReady(driver, 10, leaveType_CancelButton);
			LeaveType_pageLog.info("successfuly clicked on Leave Type Cancel button");
		} catch (Exception e) {
			LeaveType_pageLog.info("unable to clicked on Leave Type Cancel button");
		}
	}
}