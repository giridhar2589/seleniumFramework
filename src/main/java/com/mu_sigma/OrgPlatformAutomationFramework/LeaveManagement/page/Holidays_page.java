package com.mu_sigma.OrgPlatformAutomationFramework.LeaveManagement.page;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;

public class Holidays_page extends TestBase {

	WebDriver driver;
	private static final Logger Holidays_pageLog = LogManager.getLogger(Holidays_page.class.getName());

	CommonElement_page commonElement_pageObj;
	
	By holidaysTab=By.xpath("//h4[contains(text(),'Holidays')]");
	By addHoliday_btn=By.xpath("//span[@class='mat-button-wrapper' and contains(text(),'Add Holiday')]");
	By addHoliday_HeaderText=By.xpath("//h2[contains(text(),'Add Holiday')]");
	By addHolidayName_inputBox=By.xpath("//input[@name='name']");
	By addHoliday_SaveButton=By.xpath("//button[@class='mat-button']//preceding-sibling::span[contains(text(),'Save')]");
	By addHoliday_CloseButton=By.xpath("//button[@class='mat-button']//preceding-sibling::span[contains(text(),'Cancel')]");
	By addHolidayCountry_dropDown=By.xpath("(//div[@class='mat-select-arrow-wrapper'])[5]");
	By addHolidaySuccess_msg=By.xpath("//simple-snack-bar[contains(text(),'Holiday added successfully')]");
	By duplicateHoliday_msg=By.xpath("//simple-snack-bar[contains(text(),'Duplicate Entry')]");
	By hloidayDeleteSuccess_msg=By.xpath("//simple-snack-bar[contains(text(),'Holiday Deleted')]");
	By clickleaveDeleteYes_popUp=By.xpath("//span[@class='mat-button-wrapper' and contains(text(),'Yes')]");
	By holidayCountry_dropDown=By.xpath("(//div[@class='mat-select-arrow-wrapper'])[5]");
	By holidayfilterCountry_dropDown=By.xpath("(//div[@class='mat-select-arrow-wrapper'])[1]");
	By holidayfilterState_dropDown=By.xpath("(//div[@class='mat-select-arrow-wrapper'])[2]");
	By holidayfilterCity_dropDown=By.xpath("(//div[@class='mat-select-arrow-wrapper'])[3]");
	By holidayfilterYear_dropDown=By.xpath("(//div[@class='mat-select-arrow-wrapper'])[4]");
	By holidayClearFilter_btn=By.xpath("//span[contains(text(),'Clear Filter')]");
	By holidayfilterBlank_msg=By.xpath("//div[@class='ng-star-inserted' and contains(text(),'No Data Available.')]");

	By holiday=By.xpath("(//i[contains(text(),'delete')])");
	public Holidays_page(WebDriver driver) {
		this.driver = driver;
		commonElement_pageObj = new CommonElement_page(this.driver = driver);
	}

	/**
	 * This method is used to Navigate to Holiday tab
	 */
	public void clickedOnHolidayTab() {
		try {
			clickWhenElementIsReady(driver,14, holidaysTab);
			Holidays_pageLog.info("Application Clicked on Holiday Tab");
		} catch (Exception e) {
			Holidays_pageLog.info("Application Unable to Clicked on Holiday Tab");
		}
	}

	/**
	 * This method is used to select the country
	 * 
	 * @param countryname
	 */
	public void selectCountryFromDropDown(String countryname) {
		try {
			driver.findElement(addHolidayCountry_dropDown).click();
			 WebElement element = driver.findElement(
					By.xpath("//span[@class='mat-option-text' and contains(text(),'" + countryname + "')]"));
			 element.click();
			Holidays_pageLog.info("Application selected the Country Name");
		} catch (Exception e) {
			Holidays_pageLog.info("Application unable to select the Country Name");
		}
	}

	/**
	 * This method is used to create the holiday List
	 * @param holidayName
	 * @param yearName
	 * @param monthName
	 * @param monthDate
	 * @param countryname
	 * @throws InterruptedException
	 */
	public void createHolidays(String holidayName, String yearName, String monthName, String monthDate,
			String countryname) throws InterruptedException {

		driver.findElement(addHoliday_btn).click();
		waitForElement(addHoliday_HeaderText, 70);
		if (driver.findElement(addHoliday_HeaderText).getText().equals("Add Holiday")) {
			waitForElement(addHolidayName_inputBox, 70);
			driver.findElement(addHolidayName_inputBox).sendKeys(holidayName);
			//Thread.sleep(3000);
			commonElement_pageObj.clickOnCalendar_icon();
			//Thread.sleep(3000);
			commonElement_pageObj.selectYearFromCalendar(yearName);
			//Thread.sleep(3000);
			commonElement_pageObj.selectMonthFromCalendar(monthName);
			//Thread.sleep(3000);
			commonElement_pageObj.selectMonthDateCalendarBody(monthDate);
			//Thread.sleep(3000);
			selectCountryFromDropDown(countryname);
			//Thread.sleep(3000);
			driver.findElement(addHoliday_SaveButton).click();
		}
	}
	
	/**
	 * This method is used to get the success message after holiday creation
	 * @return
	 */
	public String getHolidaySuccess_msg(){
		try {
			Holidays_pageLog.info("successfuly retrive the success message");
			return driver.findElement(addHolidaySuccess_msg).getText();
		} catch (Exception e) {
			Holidays_pageLog.info("unable to  retrive the success message as  ");
			return null;
		}
	}
	
	/**
	 * This method is used to get the error message after duplicate holiday creation
	 * @return String data type
	 */
	public String getduplicateHolidayErr_msg(){
		try {
			waitForElement(duplicateHoliday_msg, 8);
			Holidays_pageLog.info("successfuly retrive the error message from application");
			return driver.findElement(duplicateHoliday_msg).getText();
		} catch (Exception e) {
			Holidays_pageLog.info("unable to  retrive the error message as  ");
			return null;
		}
	}
	
	/**
	 * This method is used to get the holiday delete message 
	 * @return String data type
	 */
	public String gethloidayDeleteSuccess_msg(){
		try {
			waitForElement(hloidayDeleteSuccess_msg, 5);
			Holidays_pageLog.info("successfuly retrive Holiday deleted message");
			return driver.findElement(hloidayDeleteSuccess_msg).getText();
		} catch (Exception e) {
			Holidays_pageLog.info("unable to retrive Holiday deleted message");
			return null;
		}
	}
	
	/**
	 * This method is used to click on Add holiday Cancel button
	 */
	public void clickOnAddHolidayCancel_btn(){
		try {
			clickWhenElementIsReady(driver, 14, addHoliday_CloseButton);
			Holidays_pageLog.info("Clicked on close button");
		} catch (Exception e) {
			Holidays_pageLog.info("Unable to click on close button");
		}
	}
	
	/**
	 * This method is used to delete the existing holiday list
	 * @param existingHolidayLeaveNo user should give position of existing leave
	 */
	public void deleteExistingLeave(int existingHolidayLeaveNo){
		 List<WebElement> holidayList = driver.findElements(holiday);
		for(int i=0;i<holidayList.size();i++){
			if(i==(existingHolidayLeaveNo-1)){
				holidayList.get(i).click();
				break;
			}else{
				Holidays_pageLog.info("Please give the valid Existing Leave No");
			}
		}
	}
	
	/**
	 * This method is used to select Yes button from delete Holiday list pop up
	 */
	public void clickDeleteHolidayYesConfimation_popUp(){
		try {
			clickWhenElementIsReady(driver, 9, clickleaveDeleteYes_popUp);
			Holidays_pageLog.info("Clicked on Yes button from delete pop up");
		} catch (Exception e) {
			Holidays_pageLog.info("Unable to Clicked on Yes button from delete pop up");
		}
	}
}
