package com.mu_sigma.OrgPlatformAutomationFramework.LeaveManagement.page;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;

/**
 * Created On :28-June-2018
 * 
 * @author Biswajit.Kundu
 *
 */
public class CommonElement_page extends TestBase {
	WebDriver driver;
	private static final Logger CommonElement_pageLog = LogManager.getLogger(CommonElement_page.class.getName());

	
	By username_inputBox=By.id("username");
	By password_inputBox=By.id("password");
	By submit_btn=By.id("submit");
	By errorInvalidUseranamePassword_text=By.xpath("//div[@class='login_message']");
	By home_Tab=By.xpath("//button[@class='mat-button']//div[contains(text(),'Home')]");
	By team_Tab=By.xpath("//button[@class='mat-button']//div[contains(text(),'Team')]");
	By admin_Tab=By.xpath("//button[@class='mat-button']//div[contains(text(),'Admin')]");
	By calendar_icon=By.xpath("(//button[@class='mat-icon-button'])[2]");
	By logoutDropDown_icon=By.xpath("//button[@class='mat-icon-button']");
	//By calendarYearHeader_dropDown=By.xpath("//button[@class='mat-calendar-period-button mat-button']");
	By calendarYearHeader_dropDown=By.xpath("//div[@class='mat-calendar-arrow']");
	By selectMonthFromCalendarParentElement=By.xpath("//div[@class='mat-calendar-content']//tbody[@class='mat-calendar-body']");
	By selectMonthDateCalendarBodyParentElement=By.xpath("//div[@class='mat-calendar-content']//table[@class='mat-calendar-table']");
	By logout_btn=By.xpath("//span[contains(text(),'Log Out')]");
	By commonLeaveError_userview=By.xpath("//mat-error[@role='alert']");
	By commonLeaveError_adminView=By.xpath("//mat-error[@role='alert']");

	public CommonElement_page(WebDriver driver) {
		this.driver = driver;
	}
	
	
	/**
	 * This method is used to click on calendar icon
	 */
	public void clickOnCalendar_icon(){
		try {
			clickWhenElementIsReady(driver, 15, calendar_icon);
			CommonElement_pageLog.info("Clicked on Calendar icon");
		} catch (Exception e) {
			CommonElement_pageLog.info("unable to Clicked on Calendar icon");
		}
	}
	
	/**
	 * This method is used to click on Home tab
	 */
	public void clickOnHome_tab(){
		try {
			clickWhenElementIsReady(driver, 8, home_Tab);
			CommonElement_pageLog.info("Click on home tab");
		} catch (Exception e) {
			CommonElement_pageLog.info("Unable to click on home tab");
		}
	}

	/**
	 * This method is used to return error message
	 * 
	 * @return
	 */
	public String getInvalidUserNamePasswordText() {
		try {
			CommonElement_pageLog.info("Returned Error message as" + driver.findElement(errorInvalidUseranamePassword_text).getText());
			return driver.findElement(errorInvalidUseranamePassword_text).getText();
		} catch (Exception e) {
			CommonElement_pageLog
					.info("Unable to return the message");
			return null;
		}
	}

	/**
	 * This method is used to Fill the Login Details
	 * 
	 * @param username
	 * @param password
	 */
	public void fillLoginDetails(String username, String password) {

		driver.findElement(username_inputBox).sendKeys(username);
		CommonElement_pageLog.info("Filled the Username");
		driver.findElement(password_inputBox).sendKeys(password);
		CommonElement_pageLog.info("Filled the Password");
		driver.findElement(submit_btn).click();
		CommonElement_pageLog.info("Clicked on the Submit button");
	}
	
	/**
	 * This method is used to click on Admin tab
	 */
	public void clickOnAdmin_tab(){
		try {
			clickWhenElementIsReady(driver, 13, admin_Tab);
			CommonElement_pageLog.info("Application clicked on Admin tab");
		} catch (Exception e) {
			CommonElement_pageLog.info("Admin tab is not clickable");
		}
	}
	
	
	
	/**
	 * This method is used to click on Log out button
	 * @throws InterruptedException 
	 */
	public void click_logOutButton() throws InterruptedException{
		clickWhenElementIsReady(driver, 80, logoutDropDown_icon);
		Thread.sleep(3000);
		clickWhenElementIsReady(driver, 9, logout_btn);
		// Switch the control of 'driver' to the Alert from main window
		Alert promptAlert = driver.switchTo().alert();
		Thread.sleep(4000);
		promptAlert.accept();
	}
	
	/** NEW CODE **/
	/**
	 * This method is used to Select the Year from the Calendar 
	 * 
	 * @param yearName
	 */
	public void selectYearFromCalendar(String yearName) {
		driver.findElement(calendarYearHeader_dropDown).click();
		//clickWhenElementIsReady(driver, 10, calendarYearHeader_dropDown);
		waitForElement(selectMonthFromCalendarParentElement, 20);
		WebElement ele = driver.findElement(selectMonthFromCalendarParentElement);
		List<WebElement> childElement = ele.findElements(By.tagName("td"));
		
		for (WebElement values : childElement) {
			if (values.getText().equals(yearName)) {
				values.click();
				CommonElement_pageLog.info("Selected the date as "+yearName);
				break;
			}
		}
	}
	
	/**
	 * This method is used to Select the Month Name
	 * 
	 * @param monthName
	 */
	public void selectMonthFromCalendar(String monthName) {
		//calendarYearHeader_dropDown.click();
		waitForElement(selectMonthFromCalendarParentElement, 20);
		WebElement ele = driver.findElement(selectMonthFromCalendarParentElement);
		List<WebElement> childElement = ele.findElements(By.tagName("td"));
		
		 //This method will iterate over all the element
		 
		for (WebElement values : childElement) {
			if (values.getText().equals(monthName)) {
				values.click();
				CommonElement_pageLog.info("Selected the Month as "+monthName);
				break;
			}
		}
	}
	
	/**
	 * This method is used to Select the date
	 * 
	 * @param monthName
	 */
	public void selectMonthDateCalendarBody(String date) {
		try {
			waitForElement(selectMonthDateCalendarBodyParentElement, 30);
			WebElement ele = driver.findElement(selectMonthDateCalendarBodyParentElement);
			List<WebElement> childElement = ele.findElements(By.tagName("td"));
			/**
			 * This method is used to select the date from calendar body
			 */
			for (WebElement values : childElement) {
				if (values.getText().equals(date)) {
					values.click();
					CommonElement_pageLog.info("Selected the date as "+date);
					break;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			CommonElement_pageLog.info("Application unable to select the date");
		}
	}
	
	/**
	 * This method is used to clear the Login Forms
	 */
	public void clearLoginDetails() {
		driver.findElement(username_inputBox).clear();
		driver.findElement(password_inputBox).clear();
	}
	
	/**
	 * This method is used to get the all error message from user view
	 * @return
	 */
	public String userviewLeaveType_Error(){
		try {
			waitForElement(commonLeaveError_userview, 10);
			CommonElement_pageLog.info("Application got the error message from userview");
			return driver.findElement(commonLeaveError_userview).getText();
		} catch (Exception e) {
			CommonElement_pageLog.info("Application unable to get the error message");
			return null;
		}
	}
	
	/**
	 * This method is used to get the all error message from Admin view in Leave application tab
	 * @return
	 */
	public String adminviewLeaveType_Error(){
		try {
			waitForElement(commonLeaveError_adminView, 10);
			CommonElement_pageLog.info("Application got the error message from userview");
			return driver.findElement(commonLeaveError_adminView).getText();
		} catch (Exception e) {
			CommonElement_pageLog.info("Application unable to get the error message");
			return null;
		}
	}
	
}
