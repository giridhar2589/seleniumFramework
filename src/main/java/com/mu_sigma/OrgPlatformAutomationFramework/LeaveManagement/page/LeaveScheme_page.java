package com.mu_sigma.OrgPlatformAutomationFramework.LeaveManagement.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;

public class LeaveScheme_page extends TestBase {
	WebDriver driver;
	private static final Logger LeaveScheme_pageLog = LogManager.getLogger(LeaveScheme_page.class.getName());

	
	By leaveSchemeTab=By.xpath("//h4[contains(text(),'Leave Scheme')]");
	By schemeDefiniton_tab=By.xpath("//div[contains(text(),'Scheme Definition')]");
	By close_menu=By.xpath("//i[@class='material-icons' and contains(text(),'close')]");
	By addLeaveScheme_btn=By.xpath("//span[contains(text(),'Add Leave Scheme')]");
	By allResponse_msg=By.xpath("//simple-snack-bar[contains(@class,'mat-simple-snackbar')]");
	By saveSchemePopUpYes_btn=By.xpath("//span[contains(text(),'Yes')]");
	By leaveApplicationSelectLeaveTypeDropDown_icon=By.xpath("(//div[@class='mat-select-arrow-wrapper'])[5]//div[@class='mat-select-arrow']");
	By schemeDefinationTimeSchemeDropDown_icon=By.xpath("(//div[@class='mat-select-arrow-wrapper'])[6]");
	By leaveSchemefromCalendar_icon=By.xpath("(//button[@class='mat-icon-button'])[2]");
	By toCalendar_icon=By.xpath("(//button[@class='mat-icon-button'])[3]");
	By reasonOfAbsence_inputBox=By.xpath("//input[@formcontrolname='reason']");
	By clear_btn=By.xpath("//span[@class='mat-button-wrapper' and contains(text(),'Clear')]");
	By schemeDefinationSchemeName_inputBox=By.xpath("//input[@formcontrolname='leaveSchemeName']");
	By schemeDefinationLeavePerYear_inputBox=By.xpath("//input[@formcontrolname='leavesPerYear']");
	By schemeDefinationLeavesPerApplictnMinimum_inputBox=By.xpath("//input[@formcontrolname='minApplication']");
	By schemeDefinationLeavesPerApplictnMaximum_inputBox=By.xpath("//input[@formcontrolname='maxApplication']");
	By schemeDefinitionNext_btn=By.xpath("(//span[@class='mat-button-wrapper' and contains(text(),'Next')])[1]");
	By schemDefinationEncashable_checkBox= By.xpath("(//div[@class='mat-checkbox-inner-container'])[2]");
	By schemeDefinationAllowGrantOverLap_checkBox=By.xpath("(//div[@class='mat-checkbox-inner-container'])[3]");
	By schemeDefinationAllowSplitApplication_checkBox=By.xpath("(//div[@class='mat-checkbox-inner-container'])[4]");
	By schemeDefinationGrantValidity_inputBox=By.xpath("//input[@formcontrolname='grantValidityDays']");
	By schemeSplit_tab=By.xpath("//div[contains(text(),'Scheme Split')]");
	By schemePolicies_tab=By.xpath("//div[contains(text(),'Scheme Policies')]");
	By schemePolicies_genderAll= By.xpath("(//label[@class='mat-radio-label']//div[@class='mat-radio-container'])[1]");
	By schemePolicies_genderMale=By.xpath("(//label[@class='mat-radio-label']//div[@class='mat-radio-container'])[2]");
	By schemePolicies_genderFemale=By.xpath("(//label[@class='mat-radio-label']//div[@class='mat-radio-container'])[3]");
	By schemePoliciesCountryDropDown_icon=By.xpath("(//div[@class='mat-select-arrow-wrapper'])[8]");
	By schemePoliciesDesignationDropDown_icon=By.xpath("(//div[@class='mat-select-arrow-wrapper'])[7]");
	By schemePoliciesNext_btn=By.xpath("(//span[@class='mat-button-wrapper' and contains(text(),'Next')])[2]");
	By editLeavesche_saveBtn=By.xpath("//span[@class='mat-button-wrapper' and contains(text(),'Save')]");
	By addSchemeSave_btn=By.xpath("(//button[@type='submit'])[3]");
	By deleteScheme_btn=By.xpath("//span[@class='mat-button-wrapper' and contains(text(),'Delete Scheme')]");
	

	public LeaveScheme_page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	/**
	 * This method is used to edit the Scheme Name from Scheme Defination tab
	 * @param schemeName
	 */
	public void editSchemeName(String schemeName){
		waitForElement(schemeDefinationSchemeName_inputBox, 10);
		driver.findElement(schemeDefinationSchemeName_inputBox).sendKeys(schemeName);
	}
	
	/**
	 * This method is used to click on Add Leave scheme button
	 */
	public void clickAddLeaveScheme_btn(){
		try {
			clickWhenElementIsReady(driver, 8, addLeaveScheme_btn);
			LeaveScheme_pageLog.info("Clicked on Add Leave Scheme button");
		} catch (Exception e) {
			LeaveScheme_pageLog.info("unable to click on Add Leave Scheme button");
		}
	}
	
	/**
	 * This method is used to select the Existing leave type from Add Scheme pop up
	 * @param existingLeaveTypeName
	 */
	public void selectExistingLeaveType(String existingLeaveTypeName){
		try {
			clickWhenElementIsReady(driver, 10, leaveApplicationSelectLeaveTypeDropDown_icon);
			 WebElement element = driver.findElement(By.xpath("//span[contains(text(),'" + existingLeaveTypeName + "')]"));
			clickWhenElementIsReady(driver, 9, element);
			LeaveScheme_pageLog.info("Application Clicked on  "+existingLeaveTypeName+"as leave Type");
		} catch (Exception e) {
			LeaveScheme_pageLog.info("Application unable to select the existing leave Type");
		}
	}
	
	/**
	 * This method is used to create to select the Time scheme from Add Scheme pop up
	 * @param timeSchemeName
	 */
	public void selectTimeScheme(String timeSchemeName){
		try {
			clickWhenElementIsReady(driver, 9, schemeDefinationTimeSchemeDropDown_icon);
			 WebElement element = driver.findElement(By.xpath("//span[contains(text(),'" + timeSchemeName + "')]"));
			clickWhenElementIsReady(driver, 9, element);
			LeaveScheme_pageLog.info("Application Clicked on  "+timeSchemeName+"as Time scheme");
		} catch (Exception e) {
			LeaveScheme_pageLog.info("Unable Clicked on  "+timeSchemeName+"as Time scheme");
		}
	}
	
	/**
	 * This method is used to Edit the leave per year
	 * @param leavePerYear it will  accept integer
	 */
	public void editLeavesPerYear(String leavePerYear){
		waitForElement(schemeDefinationLeavePerYear_inputBox,8);
		driver.findElement(schemeDefinationLeavePerYear_inputBox).sendKeys(leavePerYear);
	}
	
	/**
	 * This method is used to click on the Next button from scheme definition page
	 */
	public void clickSchemeDefinationNext_btn(){
		try {
			clickWhenElementIsReady(driver, 8, schemeDefinitionNext_btn);
			LeaveScheme_pageLog.info("clicked on Scheme Defination Next button");
		} catch (Exception e) {
			LeaveScheme_pageLog.info("unable to clicked on Scheme Defination Next button");
		}
	}
	
	/**
	 * This method is used to click on the Next button from scheme Policies page
	 */
	public void clickSchemePoliciesNext_btn(){
		try {
			clickWhenElementIsReady(driver, 8, schemePoliciesNext_btn);
			LeaveScheme_pageLog.info("clicked on Scheme Policies Next button");
		} catch (Exception e) {
			LeaveScheme_pageLog.info("unable to clicked on Scheme Policies Next button");
		}
	}
	
	/**
	 * This method is used to select the Existing Leave Scheme from LEave scheme
	 * tab
	 * 
	 * @param leaveSchemeName
	 */
	public void selectExistingLeaveScheme(String leaveSchemeName) {
		try {
			 WebElement element = driver.findElement(By.xpath("//td[contains(text(),'" + leaveSchemeName + "')]"));
			clickWhenElementIsReady(driver,20, element);
		} catch (Exception e) {
			LeaveScheme_pageLog.info("Application unable to select the existing leave scheme");
		}
	}

	/**
	 * This method is used to click on the Scheme Definition tab from Add Scheme
	 * pop up under Leave Scheme tab pop up
	 */
	public void clickOnSchemeDefinition_tab() {
		try {
			clickWhenElementIsReady(driver, 10, schemeDefiniton_tab);
			LeaveScheme_pageLog.info("Clicked on Scheme Definiton Tab");
		} catch (Exception e) {
			LeaveScheme_pageLog.info("Unable to clicked on Scheme Definiton Tab");
		}
	}
	
	/**
	 * This method is used to Select the Allow Grant OverLapCheck Box
	 */
	public void selectAllowGrantOverLap_checkBox(){
		try {
			clickWhenElementIsReady(driver, 8, schemeDefinationAllowGrantOverLap_checkBox);
			LeaveScheme_pageLog.info("Selected the Grant Overlap check box");
		} catch (Exception e) {
			LeaveScheme_pageLog.info("Unable to select the Grant Overlap check box");
		}
	}
	
	/**
	 * This method is used to select the Allow split application check box
	 */
	public void selectAllowSplitApplication_checkBox(){
		try {
			clickWhenElementIsReady(driver, 8, schemeDefinationAllowSplitApplication_checkBox);
			LeaveScheme_pageLog.info("Selected Allow split application check box");
		} catch (Exception e) {
			LeaveScheme_pageLog.info("unable to clicked on Allow split application check box");
		}
	}
	
	/**
	 * This method is used to Edit the Grant validity number with non periodic leaves
	 * @param grantValidityNumber
	 */
	public void editGrantValidationDays_inputBox(String grantValidityNumber){
		try {
			driver.findElement(schemeDefinationGrantValidity_inputBox).sendKeys(grantValidityNumber);
			LeaveScheme_pageLog.info("Edited the scheme validity field");
		} catch (Exception e) {
			LeaveScheme_pageLog.info("Unable to edit the scheme validity field");
		}
	}

	/**
	 * This method is used to click on the Scheme Policies tab from Add Scheme
	 * pop up under Leave Scheme tab pop up
	 */
	public void clickOnSchemePolicies_tab() {
		try {
			clickWhenElementIsReady(driver, 10, schemePolicies_tab);
			LeaveScheme_pageLog.info("Clicked on Scheme Policies Tab");
		} catch (Exception e) {
			LeaveScheme_pageLog.info("Unable to clicked on Scheme Policies Tab");
		}
	}

	/**
	 * This method is used to click on the Scheme Split tab from Add Scheme pop
	 * up under Leave Scheme tab
	 */
	public void clickOnSchemeSplit_tab() {
		try {
			clickWhenElementIsReady(driver, 10, schemeDefiniton_tab);
			LeaveScheme_pageLog.info("Clicked on Scheme Split Tab");
		} catch (Exception e) {
			LeaveScheme_pageLog.info("Unable to clicked on Scheme Split Tab");
		}
	}

	

	/**
	 * This method is used to save the Newly created Scheme
	 */
	public void clickOnSaveSchemePopUp() {
		try {
			clickWhenElementIsReady(driver, 5, saveSchemePopUpYes_btn);
			LeaveScheme_pageLog.info("Clicked Yes pop up button");
		} catch (Exception e) {
			LeaveScheme_pageLog.info("Unable to click on Yes pop up button");
		}
	}

	/**
	 * It Will Close the Add Leave Scheme Pop up
	 */
	public void closePopUp() {
		try {
			clickWhenElementIsReady(driver, 8, close_menu);
			LeaveScheme_pageLog.info("Add scheme pop up closed");
		} catch (Exception e) {
			LeaveScheme_pageLog.info("Unable to close Add scheme pop up");
		}
	}

	/**
	 * This method is used to get all the text response messages which all are
	 * coming from Rest API
	 * 
	 * @return
	 */
	public String getAllResponse_msg() {
		try {
			waitForElement(allResponse_msg, 8);
			LeaveScheme_pageLog.info("Message returned as "+driver.findElement(allResponse_msg).getText());
			return driver.findElement(allResponse_msg).getText();
		} catch (Exception e) {
			LeaveScheme_pageLog.info("Unable to retrive the message");
			return null;
		}
	}

	/**
	 * This method is used to click on Leave Scheme Tab
	 */
	public void clickOnLeaveScheme_tab() {
		try {
			clickWhenElementIsReady(driver, 10, leaveSchemeTab);
			LeaveScheme_pageLog.info("Clicked on Leave scheme tab");
		} catch (Exception e) {
			LeaveScheme_pageLog.info("Application unable to click on Leave scheme tab");
		}
	}

	/**
	 * This method is used to Edit the Leaves Per application
	 * 
	 * @param minLeaveValue
	 *            Data type will be Integer
	 */
	public void editminimumLeavesPerApplication_inputBox(String minLeaveValue) {
		try {
			driver.findElement(schemeDefinationLeavesPerApplictnMinimum_inputBox).sendKeys(minLeaveValue);
			LeaveScheme_pageLog.info("Edit the Leaves Per application successfully");
		} catch (Exception e) {
			LeaveScheme_pageLog.info("Unable to Edit the Leaves Per application");
		}
	}

	/**
	 * This method is used to clear the minimum Application field from Add
	 * Scheme pop up under Leave Scheme tab
	 */
	public void clearminimumLeavesPerApplication_inputBox() {
		try {
			driver.findElement(schemeDefinationLeavesPerApplictnMinimum_inputBox).clear();
			LeaveScheme_pageLog.info("Field Clear successfully");
		} catch (Exception e) {
			LeaveScheme_pageLog.info("Application unable to clear the Field successfully");
		}
	}

	/**
	 * This method is used to click on the Edit Leave Scheme Save button
	 */
	public void clickEditLeavesche_saveBtn() {
		try {
			clickWhenElementIsReady(driver, 10, editLeavesche_saveBtn);
			LeaveScheme_pageLog.info("Clicked on Edit Leave scheme Yes button successfully");
		} catch (Exception e) {
			LeaveScheme_pageLog.info("Unable to Clicked on Edit Leave scheme Yes button successfully");
		}
	}

	

	/**
	 * This method is used to select the Designation Under Scheme policies
	 * Tab(Leave Scheme Tab)
	 * 
	 * @param desigNationName
	 *            It should get the designation as it as mentioned in
	 *            designation drop down
	 */
	public void leaveSchemeSelectDesignation(String desigNationName) {
		try {
			clickWhenElementIsReady(driver, 20, schemePoliciesDesignationDropDown_icon);
			LeaveScheme_pageLog.info("Application clicked on the Designation drop down");
			 WebElement element = driver.findElement(
					By.xpath("//mat-option[@role='option']//span[contains(text(),'" + desigNationName + "')]"));
			clickWhenElementIsReady(driver, 20, element);
			LeaveScheme_pageLog.info("Application clicked on Designation as :" + desigNationName);
		} catch (Exception e) {
			LeaveScheme_pageLog.info("Application unable to Select the Designation as :" + desigNationName);
		}
	}

	/**
	 * This method is used to click on Scheme Validity Form Date Icon from Apply
	 * Leave pop up
	 */
	public void clickOnFormCalendarIcon() {
		try {
			clickWhenElementIsReady(driver, 80, leaveSchemefromCalendar_icon);
			LeaveScheme_pageLog.info("Application able to clicked on Form Claendar Icon");
		} catch (Exception e) {
			LeaveScheme_pageLog.info("Application Unable to clicked on Form Claendar Icon");
		}
	}

	/**
	 * This method is used to click on Scheme Validity Form Date Icon from Apply
	 * Leave pop up
	 */
	public void clickOnToCalendarIcon() {
		try {
			clickWhenElementIsReady(driver, 80, toCalendar_icon);
			LeaveScheme_pageLog.info("Application able to clicked on To Claendar Icon");
		} catch (Exception e) {
			LeaveScheme_pageLog.info("Application Unable to clicked on To Claendar Icon");
		}
	}
	
	/**
	 * This method is used to select the country from scheme policies
	 * @param countryName
	 */
	public void selectCountry(String countryName){
		try {
			clickWhenElementIsReady(driver,20, schemePoliciesCountryDropDown_icon);
			 WebElement element = driver.findElement(By.xpath("//span[@class='mat-option-text' and contains(text(),'" + countryName + "')]"));
			clickWhenElementIsReady(driver, 15, element);
			LeaveScheme_pageLog.info("Selected the Country as "+countryName);
		} catch (Exception e) {
			LeaveScheme_pageLog.info("unable to select the Country as "+countryName);
		}
	}
	
	
	/**
	 * This method is used to select the gender from Scheme Policies page
	 * @param gender
	 */
	public void selectGenderFromSchemePolicies(String gender){
		try {
			if(gender.equalsIgnoreCase("All")){
				clickWhenElementIsReady(driver, 17, schemePolicies_genderAll);
				LeaveScheme_pageLog.info("Clicked on Gender As All");
			}else if(gender.equalsIgnoreCase("Male")){
				clickWhenElementIsReady(driver, 17, schemePolicies_genderMale);
				LeaveScheme_pageLog.info("Clicked on Gender As Male");
			}else if (gender.equalsIgnoreCase("Female")) {
				clickWhenElementIsReady(driver, 17, schemePolicies_genderMale);
				LeaveScheme_pageLog.info("Clicked on Gender As Female");
			}
		} catch (Exception e) {
			LeaveScheme_pageLog.info("Given Gender is not avilable");
		}
	}
	
	/**
	 * This method is used to click on Save button to save the leave scheme
	 */
	public void clickOnSave_btn(){
		try {
			clickWhenElementIsReady(driver, 8, addSchemeSave_btn);
			LeaveScheme_pageLog.info("Clicked on Save button");
		} catch (Exception e) {
			LeaveScheme_pageLog.info("Unable to click on Save button");
		}
	}
	
	/**
	 * This method is used to click on delete scheme button
	 */
	public void clickOndeleteScheme_btn(){
		try {
			clickWhenElementIsReady(driver, 9, deleteScheme_btn);
			LeaveScheme_pageLog.info("Clicked on Delete Scheme button");
		} catch (Exception e) {
			LeaveScheme_pageLog.info("Unable to click on Delete Scheme button");
		}
	}

}
