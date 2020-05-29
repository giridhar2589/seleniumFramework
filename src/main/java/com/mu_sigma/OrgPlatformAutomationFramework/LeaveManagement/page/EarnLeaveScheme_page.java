package com.mu_sigma.OrgPlatformAutomationFramework.LeaveManagement.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;

/**
 * Created On: 13-Jan-2018
 * 
 * @author biswajit.kundu Modified On: 13-Jan-2018
 * 
 */
public class EarnLeaveScheme_page extends TestBase {

	WebDriver driver;
	private static final Logger EarnLeaveSchemepage_pageLog = LogManager
			.getLogger(EarnLeaveScheme_page.class.getName());

	By leaveSchemeTab=By.xpath("//h4[contains(text(),'Leave Scheme')]");
	By addLeaveScheme_btn=By.xpath("//span[contains(text(),'Add Leave Scheme')]");
	By schemeDefinationSchemeName_inputBox=By.xpath("//input[@formcontrolname='leaveSchemeName']");
	By schemeDefinationLeaveType_dropDownIcon=By.xpath("(//div[@class='mat-select-arrow-wrapper'])[5]");
	By schemeDefinationTimeScheme_dropDown=By.xpath("(//div[@class='mat-select-arrow-wrapper'])[6]");
	By schemeDefinationLeavePerYear_inputBox=By.xpath("//input[@formcontrolname='leavesPerYear']");
	By schemeDefinationNonWorkingDays_checkBox=By.xpath("(//div[@class='mat-checkbox-inner-container'])[1]");
	By schemeDefinationEncashable_checkBox=By.xpath("(//div[@class='mat-checkbox-inner-container'])[2]");
	By schemeDefinationallowGrantOverLap_checkBox=By.xpath("(//div[@class='mat-checkbox-inner-container'])[3]");
	By schemeDefinationallowSplitApplication_checkBox=By.xpath("(//div[@class='mat-checkbox-inner-container'])[4]");
	By schemeDefinationLeavesPerApplictnMinimum_inputBox=By.xpath("//input[@formcontrolname='minApplication']");
	By schemeDefinationLeavesPerApplictnMaximum_inputBox=By.xpath("//input[@formcontrolname='maxApplication']");
	By schemeDefinationFormCalendar_Icon=By.xpath("(//button[@class='mat-icon-button'])[2]");
	By schemeDefinationToCalendar_Icon=By.xpath("(//button[@class='mat-icon-button'])[3]");
	By calendarYearHeader_dropDown=By.xpath("//button[@class='mat-calendar-period-button mat-button']");
	By selectMonthFromCalendarParentElement=By.xpath("//div[@class='mat-calendar-content']//tbody[@class='mat-calendar-body']");
	By addSchemepopUp_close_btn=By.xpath("//i[contains(text(),'close')]");
	By selectMonthDateCalendarBodyParentElement=By.xpath("//table[@class='mat-calendar-table']//tbody[@class='mat-calendar-body']");
	By schemeDefinationClear_btn=By.xpath("(//span[contains(text(),'Clear')])[2]");
	By schemeDefinationNext_btn=By.xpath("(//span[contains(text(),'Next')])[1]");
	By schemePoliciesDesignation_dropDown=By.xpath("(//div[@class='mat-select-arrow-wrapper'])[7]");
	By schemePoliciesCountry_dropDown=By.xpath("(//div[@class='mat-select-arrow-wrapper'])[8]");
	By schemePoliciesState_dropDown=By.xpath("(//div[@class='mat-select-arrow-wrapper'])[9]");
	By schemePoliciesCity_dropDown=By.xpath("(//div[@class='mat-select-arrow-wrapper'])[10]");
	By schemePolicyClear_btn=By.xpath("(//span[contains(text(),'Clear')])[3]");
	By schemePolicyNext_btn=By.xpath("(//span[contains(text(),'Next')])[2]");
	By schemeSplitSave_btn=By.xpath("//span[contains(text(),'Save')]");
	By saveSchemeYes_btn=By.xpath("//span[contains(text(),'Yes')]");
	By validationTextForNoData_txt=By.xpath("//div[@class='ng-star-inserted' and contains(text(),'No Data Available.')]");
	By leaveSchemFilter_dropDown_icon=By.xpath("//span[contains(@class,'mat-expansion-indicator ng-tns')]");
	By filterCountry_dropDown_icon=By.xpath("(//div[@class='mat-select-arrow-wrapper'])[1]");
	By filterState_dropDown_icon=By.xpath("(//div[@class='mat-select-arrow-wrapper'])[2]");
	By filterCity_dropDown_icon=By.xpath("(//div[@class='mat-select-arrow-wrapper'])[3]");
	By filterLeaveType_dropDown_icon=By.xpath("(//div[@class='mat-select-arrow-wrapper'])[4]");
	By filterClearButton=By.xpath("//span[contains(text(),'Clear Filter')]");
	By exceedError_msg=By.xpath("//simple-snack-bar[contains(text(),'Leaves granted exceed leaves per year')]");
	By invalidfilterBlank_msg=By.xpath("//div[@class='ng-star-inserted' and contains(text(),'No Data Available.')]");
	By lessLeavePerYearError_msg=By.xpath("//snack-bar-container[contains(@class,'mat-snack-bar-container')]");
	By leaveCreationSuccess_msg=By.xpath("//simple-snack-bar[contains(text(),'Leave Scheme added successfully')]");
	By duplicateLeaveSchemeError_msg=By.xpath("//simple-snack-bar[contains(text(),'Leave scheme name already in use. Please choose a different one')]");
	By schemeSplit_tab=By.xpath("//div[contains(text(),'Scheme Split')]");

	public EarnLeaveScheme_page(WebDriver driver) {
		this.driver = driver;
		
	}

	/**
	 * This method is used to click on Leave Scheme Tab
	 */
	public void clickonLeaveScheme_tab() {
		try {
			clickWhenElementIsReady(driver, 10, leaveSchemeTab);
			EarnLeaveSchemepage_pageLog.info("Clicked on Leave scheme tab");
		} catch (Exception e) {
			EarnLeaveSchemepage_pageLog.info("Application unable to click on Leave scheme tab");
			e.printStackTrace();
		}
	}

	/**
	 * This method is used to click on Add Leave Scheme button
	 */
	public void clickOnAddLeaveScheme_btn() {
		try {
			clickWhenElementIsReady(driver, 90, addLeaveScheme_btn);
			EarnLeaveSchemepage_pageLog.info("Clicked on Add Leave scheme Button");
		} catch (Exception e) {
			EarnLeaveSchemepage_pageLog.info("Application unable to click on Add Leave scheme button");
		}

	}

	/**
	 * This method is used edit the Leave Scheme Name in Scheme Definition pop
	 * up
	 * 
	 * @param schemeName
	 */
	public void editSchemeName(String schemeName) {
		waitForElement(schemeDefinationSchemeName_inputBox, 80);
		driver.findElement(schemeDefinationSchemeName_inputBox).sendKeys(schemeName);
	}

	/**
	 * This method is used to select the Encashable Check box from Scheme
	 * Defination pop up
	 */
	public void selectEncashable_checkBox() {
		clickWhenElementIsReady(driver, 80, schemeDefinationEncashable_checkBox);
	}

	/**
	 * This method is used to Edit the Leaves Per application
	 * 
	 * @param minLeaveValue
	 *            Data type will be Integer
	 */
	public void editLeavesPerApplication_inputBox(String minLeaveValue) {
		driver.findElement(schemeDefinationLeavesPerApplictnMinimum_inputBox).sendKeys(minLeaveValue);
	}

	/**
	 * This method is used to click On Scheme Definition Next button
	 */
	public void clickSchemeDefinationNext_btn() {
		clickWhenElementIsReady(driver, 80, schemeDefinationNext_btn);
	}

	/**
	 * This method is used to select the Leave Type from Scheme definition page
	 * 
	 * @throws InterruptedException
	 */
	public void selectLeaveTypeFromDrop_down(String leaveTypeName) throws InterruptedException {
		clickWhenElementIsReady(driver, 60, schemeDefinationLeaveType_dropDownIcon);
		Thread.sleep(3000);
		WebElement ele = driver.findElement(
				By.xpath("//mat-option[@role='option']//span[@class='mat-option-text' and contains(text(),'"
						+ leaveTypeName + "')]"));
		ele.click();
	}

	/**
	 * This method is used to select the Time scheme from drop down
	 * 
	 * @param timeSchemeName
	 * @throws InterruptedException
	 */
	public void selectTimeSchemeFromDrop_down(String timeSchemeName) throws InterruptedException {
		clickWhenElementIsReady(driver, 60, schemeDefinationTimeScheme_dropDown);
		Thread.sleep(3000);
		 WebElement element = driver.findElement(
				By.xpath("//span[@class='mat-option-text' and contains(text(),'" + timeSchemeName + "')]"));
		 element.click();
	}

	/**
	 * This method is used Edit the Leave Scheme Per Year
	 * 
	 * @param leavePerYear
	 */
	public void editLeavesPerYear(String leavePerYear) {
		waitForElement(schemeDefinationLeavePerYear_inputBox, 80);
		try {
			if (driver.findElement(schemeDefinationLeavePerYear_inputBox).isDisplayed()) {
				driver.findElement(schemeDefinationLeavePerYear_inputBox).sendKeys(leavePerYear);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * This method is used to click on Scheme Validity Form Date Icon
	 */
	public void clickonSchemeValidityFormCalendar_icon() {
		clickWhenElementIsReady(driver, 80, schemeDefinationFormCalendar_Icon);
	}

	/**
	 * This method is used to click on Next button from Scheme Policy Page
	 */
	public void clickNextButtonFromSchemePolicy() {
		clickWhenElementIsReady(driver, 80, schemePolicyNext_btn);
	}

	/**
	 * This method is used to select the Country from the Scheme Policy page
	 * country Drop Down
	 * 
	 * @throws InterruptedException
	 */
	public void selectCountryfromSchemePolicy(String schemePolicyCountry) throws InterruptedException {
		clickWhenElementIsReady(driver, 90, schemePoliciesCountry_dropDown);
		Thread.sleep(3000);
		 WebElement childDropDown = driver.findElement(
				By.xpath("//span[@class='mat-option-text' and contains(text(),'" + schemePolicyCountry + "')]"));
		childDropDown.click();
	}

	/**
	 * This method is used to split the quarterly leave
	 * 
	 * @param quaterNo
	 *            USer need to pass quarter no(For ex:for Q1->user needs to pass
	 *            1)
	 */
	public void quaterlySchemeSplitForLeavesGranted(String quaterNo, String noOfLeaveallowedPerquater) {
		try {
			 WebElement element = driver
					.findElement(By.xpath("(//input[@formcontrolname='leavesGranted'])[ " + quaterNo + " ]"));
			element.sendKeys(noOfLeaveallowedPerquater);
			EarnLeaveSchemepage_pageLog.info("Filled the quatarley Leave Granted Input box");
		} catch (Exception e) {
			EarnLeaveSchemepage_pageLog.info("Application unable to Filled the quatarley Leave Granted Input box");
			e.printStackTrace();
		}
	}

	/**
	 * This method is used to clear the field quarterly
	 * 
	 * @param quaterNo
	 */
	public void clearquaterlySchemeSplitForLeavesGranted(String quaterNo) {
		try {
			 WebElement element = driver
					.findElement(By.xpath("(//input[@formcontrolname='leavesGranted'])[ " + quaterNo + " ]"));
			waitForElement(element, 9);
			element.clear();
			EarnLeaveSchemepage_pageLog.info("Clearing the field by Quaterwise");
		} catch (Exception e) {
			EarnLeaveSchemepage_pageLog.info("Application unable to Clearing the field by Quaterwise");
		}
	}

	/**
	 * This method is used to split the carry forward leave
	 * 
	 * @param quaterNo
	 *            User need to pass quarter no(For ex:for Q1->user can carry
	 *            maximum is 5)
	 */
	public void quaterlySchemeSplitForLeavesCarryForward(String caryyForwardLeaveforQuater,
			String maxCarryForwardLeave) {
		try {
			WebElement element = driver.findElement(
					By.xpath("(//input[@formcontrolname='carryForward'])[" + caryyForwardLeaveforQuater + "]"));
			element.sendKeys(maxCarryForwardLeave);
			EarnLeaveSchemepage_pageLog.info("Filled the quatarley crarry forward Leave Granted Input box");
		} catch (Exception e) {
			EarnLeaveSchemepage_pageLog
					.info("Application unable to fill the quatarley crarry forward Leave Granted Input box");
			e.printStackTrace();
		}
	}

	/**
	 * This method is used to clear the carry forward leave field
	 * 
	 * @param caryyForwardLeaveforQuater
	 */
	public void clearquaterlySchemeSplitForLeavesCarryForward(String caryyForwardLeaveforQuater) {
		try {
			 WebElement element = driver.findElement(
					By.xpath("(//input[@formcontrolname='carryForward'])[" + caryyForwardLeaveforQuater + "]"));
			//waitForElement(element, 20);
			element.clear();
			EarnLeaveSchemepage_pageLog.info("Clearing carry forward leave scheme");
		} catch (Exception e) {
			EarnLeaveSchemepage_pageLog.info("Application unable to Clearing carry forward leave scheme");
		}
	}

	/**
	 * This method is used to split the quarterly leave
	 * 
	 * @param quaterNo
	 *            USer need to pass quarter no(For ex:for H1->user needs to pass
	 *            1)
	 */
	public void yearlyAndHalfYearlySchemeSplitForLeavesGranted(int quaterNo, int noOfLeaveallowedPerquater) {
		try {
			WebElement element = driver
					.findElement(By.xpath("(//input[@formcontrolname='leavesGranted'])[" + quaterNo + "]"));
			element.sendKeys(String.valueOf(noOfLeaveallowedPerquater));
			EarnLeaveSchemepage_pageLog.info("Filled the Half-yearly OR Yearly Leaves Granted Input box");
		} catch (Exception e) {
			EarnLeaveSchemepage_pageLog
					.info("Application unable to Fill the Half-yearly OR Yearly Leaves Granted Input box");
			e.printStackTrace();
		}
	}

	/**
	 * This method is used to split the carry forward leave
	 * 
	 * @param quaterNo
	 *            User need to pass quarter no(For ex:for Q1->user can carry
	 *            maximum is 5)
	 */
	public void yearlyAndHalfYearlySchemeSplitForLeavesCarryForward(int caryyForwardLeaveforQuater,
			int maxCarryForwardLeave) {
		try {
			 WebElement element = driver.findElement(
					By.xpath("(//input[@formcontrolname='carryForward'])[" + caryyForwardLeaveforQuater + "]"));
			element.sendKeys(String.valueOf(maxCarryForwardLeave));
			EarnLeaveSchemepage_pageLog.info("Filled the Half-yearly OR Yearly Leaves Carry Forward Input box");
		} catch (Exception e) {
			EarnLeaveSchemepage_pageLog.info("Filled the Half-yearly OR Yearly Leaves Carry Forward Input box");
			e.printStackTrace();
		}
	}

	/**
	 * This method is used to Click on the Save button from Scheme Split Page
	 */
	public void clickOnSchemeSplitSave_btn() {
		clickWhenElementIsReady(driver, 90, schemeSplitSave_btn);
	}

	/**
	 * This method is used to save the Newly created Scheme
	 */
	public void clickOnSaveSchemePopUp() {
		clickWhenElementIsReady(driver, 5, saveSchemeYes_btn);
	}

	/**
	 * This method will return Leaves granted exceed leaves per year message
	 * from when user exceed maximum of leave per year
	 * 
	 * @return
	 */
	public String getExceedDataTextValidation() {
		waitForElement(exceedError_msg, 6);
		return driver.findElement(exceedError_msg).getText();
	}

	/**
	 * This method will return Leaves granted do not add up to leaves per year
	 * message from when user give less leave per year
	 * 
	 * @return
	 */
	public String getLessLeavePerYearDataTextValidation() {
		waitForElement(lessLeavePerYearError_msg, 8);
		return driver.findElement(lessLeavePerYearError_msg).getText();
	}

	/**
	 * This Method is used to get the Success message after Leave creation
	 * 
	 * @return
	 */
	public String getSuccessLeaveCreationMsg() {
		waitForElement(leaveCreationSuccess_msg, 8);
		return driver.findElement(leaveCreationSuccess_msg).getText();
	}

	/**
	 * This Method is used to get the duplicate error message after Leave
	 * creation
	 * 
	 * @return
	 */
	public String getDuplicateLeaveCreationMsg() {
		waitForElement(duplicateLeaveSchemeError_msg, 3);
		return driver.findElement(duplicateLeaveSchemeError_msg).getText();
	}

	/**
	 * This Method is used to Navigate to Scheme Split tab This method only work
	 * if all other required tabs are filled
	 */
	public void navigateToSchemeSplit_tab() {
		clickWhenElementIsReady(driver, 10, schemeSplit_tab);
	}

	/**
	 * This method is used to select the valid Country from Leave Scheme Filter
	 * 
	 * @param countryname
	 */
	public void selectLeaveSchemeValidContryFilter(String countryname) {
		try {
			clickWhenElementIsReady(driver, 20, leaveSchemFilter_dropDown_icon);
			clickWhenElementIsReady(driver, 20, filterCountry_dropDown_icon);
			 WebElement element = driver.findElement(
					By.xpath("//span[@class='mat-option-text' and contains(text(),'" + countryname + "')]"));
			//clickWhenElementIsReady(driver, 20, element);
			 element.click();
			EarnLeaveSchemepage_pageLog.info("Application able to select the Valid Contry Filter");
		} catch (Exception e) {
			EarnLeaveSchemepage_pageLog.info("Application Unable to select the Valid Contry Filter");
			e.printStackTrace();
		}
	}

	/**
	 * This method is used to select the Invalid Country from Leave Scheme
	 * Filter
	 * 
	 * @param countryname
	 */
	public void selectLeaveSchemeInvalidCountryFilter(String countryname) {
		try {
			clickWhenElementIsReady(driver, 20, filterCountry_dropDown_icon);
			 WebElement element = driver.findElement(
					By.xpath("//span[@class='mat-option-text' and contains(text(),'" + countryname + "')]"));
			//clickWhenElementIsReady(driver, 20, element);
			 element.click();
			EarnLeaveSchemepage_pageLog.info("Application able to select the InValid Contry Filter");
		} catch (Exception e) {
			EarnLeaveSchemepage_pageLog.info("Application Unable to select the InValid Contry Filter");
			e.printStackTrace();
		}
	}

	/**
	 * This method is used to verify the Created Earn Leave scheme with country
	 * filter
	 * 
	 * @param schemeName
	 * @return
	 */
	public String verifyHolidayFilter(String schemeName) {
		 WebElement element = driver.findElement(
				By.xpath("(//div[@class='ng-star-inserted'])[4]//td[contains(text(),'" + schemeName + "')]"));
		return element.getText();
	}

	/**
	 * This method will return text as "No data available" when user select a
	 * country for whom data is not there
	 * 
	 * @return This method will return text as "No data available"
	 */
	public String getBlnakMessageforContryFilter() {
		try {
			waitForElement(invalidfilterBlank_msg, 9);
			EarnLeaveSchemepage_pageLog.info("Application retrive the message as "+driver.findElement(invalidfilterBlank_msg).getText());
			return driver.findElement(invalidfilterBlank_msg).getText();
		} catch (Exception e) {
			EarnLeaveSchemepage_pageLog.info("unable to retrive the error message");
			return null;
		}
	}

	/**
	 * This method is used to clear the filter
	 */
	public void clickOnclearFilter_btn() {
		waitForElement(filterClearButton, 6);
		driver.findElement(filterClearButton).click();
	}

	/**
	 * This method is used to Select the Leave Type Filter from Leave Scheme
	 * 
	 * @param leaveTypeName
	 */
	public void selectLeaveTypeFilterfromLeaveScheme(String leaveTypeName) {
		try {

			clickWhenElementIsReady(driver, 10, filterLeaveType_dropDown_icon);
			 WebElement element = driver.findElement(
					By.xpath("//span[@class='mat-option-text' and contains(text(),'" + leaveTypeName + "')]"));
			 element.click();;
			EarnLeaveSchemepage_pageLog.info("Application able to select leave type Filter");
		} catch (Exception e) {
			EarnLeaveSchemepage_pageLog.info("Application Unable to select leave type Filter");
			e.printStackTrace();
		}
	}

	/**
	 * This method is used to close the Add Leave Scheme pop up message
	 */
	public void close_AddSchemePopUp() {
		try {
			clickWhenElementIsReady(driver, 20, addSchemepopUp_close_btn);
			EarnLeaveSchemepage_pageLog.info("Application closed the Add Leave Scheme pop up message");
		} catch (Exception e) {
			EarnLeaveSchemepage_pageLog.info("Application unable to close Add Leave Scheme pop up message");
		}
	}

}
