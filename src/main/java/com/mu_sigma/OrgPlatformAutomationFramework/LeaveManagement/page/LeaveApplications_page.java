package com.mu_sigma.OrgPlatformAutomationFramework.LeaveManagement.page;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;

public class LeaveApplications_page extends TestBase{

	WebDriver driver;
	
	private static final Logger LeaveApplications_pageLog = LogManager.getLogger(LeaveApplications_page.class.getName());
	
	By leaveApplication_tab=By.xpath("//h4[contains(text(),'Leave Applications')]");
	By leaveApplicationPending_tab=By.xpath("//div[@class='mat-tab-label-content' and contains(text(),'Pending')]");
	By leaveApplicationAll_tab=By.xpath("//div[@class='mat-tab-label-content' and contains(text(),'All')]");
	By leaveApplicationFilter_DropDownIcon=By.xpath("//span[contains(@class,'mat-expansion-indicator ng-tns')]");
	By leaveApplicationApplyLeave_btn=By.xpath("//span[@class='mat-button-wrapper' and contains(text(),'Apply Leave')]");
	By leaveApplicationApplyLeaveApply_btn=By.xpath("(//span[@class='mat-button-wrapper' and contains(text(),'Apply')])[2]");
	By leaveApplicationSelectLeaveTypeDropDown_icon=By.xpath("(//div[@class='mat-select-arrow-wrapper'])[5]//div[@class='mat-select-arrow']");
	By leaveApplication_countryDropDown_icon=By.xpath("(//div[@class='mat-select-arrow-wrapper'])[1]");
	By leaveApplication_stateDropDown_icon=By.xpath("(//div[@class='mat-select-arrow-wrapper'])[2]");
	By leaveApplication_cityDropDown_icon=By.xpath("(//div[@class='mat-select-arrow-wrapper'])[3]");
	By leaveApplication_empTypeDrpDown_icon=By.xpath("(//div[@class='mat-select-arrow-wrapper'])[4]");
	By leaveApplication_AppliedCheckbox=By.xpath("(//input[@type='checkbox'])[1]");
	By leaveApplication_ForwardedCheckbox=By.xpath("(//input[@type='checkbox'])[2]");
	By leaveApplication_ApprovedCheckbox=By.xpath("(//input[@type='checkbox'])[3]");
	By leaveApplication_rejectedCheckbox=By.xpath("(//input[@type='checkbox'])[4]");
	By leaveApplication_withdrawnCheckbox=By.xpath("(//input[@type='checkbox'])[5]");
	By leaveApplicationApplyLeaveEditEmpName_inpuBox=By.xpath("(//input[@id='empSearch'])[2]");
	By leaveApplicationApplyLeaveEditEmpName_inputBoxClear=By.xpath("//span[@class='mat-button-wrapper']//i[contains(text(),'close')]");
	By leaveApplication_cancelCheckbox=By.xpath("(//input[@type='checkbox'])[5]");
	By leaveApplication_clearFilterBtn=By.xpath("//span[contains(text(),'Clear Filter')]");
	By leaveApplicationApplyLeaveFormCalendar_btn=By.xpath("(//button[@class='mat-icon-button'])[4]");
	By leaveApplicationApplyLeaveToCalendar_btn=By.xpath("(//button[@class='mat-icon-button'])[5]");
	By leaveApplicationApplyLeaveFromSession1_radioBtn=By.xpath("(//label[@class='mat-radio-label']//div[@class='mat-radio-container'])[1]");
	By leaveApplicationApplyLeaveFromSession2_radioBtn=By.xpath("(//label[@class='mat-radio-label']//div[@class='mat-radio-container'])[2]");
	By leaveApplicationApplyLeaveToSession1_radioBtn=By.xpath("(//label[@class='mat-radio-label']//div[@class='mat-radio-container'])[3]");
	By leaveApplicationApplyLeaveToSession2_radioBtn=By.xpath("(//label[@class='mat-radio-label']//div[@class='mat-radio-container'])[4]");
	By leaveApplicationapplyLeaveReasonOfAbsence_inputBox=By.xpath("//input[@formcontrolname='reason']");
	By selectMonthFromCalendarParentElement=By.xpath("//div[@class='mat-calendar-content']//tbody[@class='mat-calendar-body']");
	By calendarYearHeader_dropDown=By.xpath("//button[@class='mat-calendar-period-button mat-button']");
	By selectMonthDateCalendarBodyParentElement=By.xpath("//table[@class='mat-calendar-table']//tbody[@class='mat-calendar-body']");
	By minLeave_error=By.xpath("//mat-error[contains(text(),'Minimum number of days can be applied is 1.0')]");
	By noLeave_error=By.xpath("//mat-error[@role='alert']");
	By leaveApplicationsApplyLeaveClose_btn=By.xpath("//span[@class='mat-button-wrapper' and contains(text(),'Close')]");
	By LeaveApplicationAllResponse_msg=By.xpath("//simple-snack-bar[contains(@class,'mat-simple-snackbar')]");
	By leaveApplicationApplyLeaveYes_popUp=By.xpath("//span[contains(text(),'Yes')]");
	By selectEmployeefromApplyLeavePopUpParentElemen=By.xpath("//mat-option[@fxlayoutalign='space-between stretch']//span[@class='mat-option-text']//div[2]");
	By editEmploye_inputBoxInFilter=By.xpath("//input[@id='empSearch']");
	By leaveApplicationRemark_inputBox=By.xpath("//textarea[@name='Remarks']");
	By cancelApplication_btn=By.xpath("//span[@class='mat-button-wrapper' and contains(text(),'Cancel Application')]");
	By applicationReject_btn=By.xpath("//span[@class='mat-button-wrapper' and contains(text(),'Reject')]");
	By leaveApplicationForward_btn=By.xpath("//span[@class='mat-button-wrapper' and contains(text(),'Forward')]");
	By editLeaveApplication_btn=By.xpath("//span[@class='mat-button-wrapper' and contains(text(),'Edit Application')]");
	By editLeaveApplicationRemarks_inputBox=By.xpath("//input[contains(@class,'mat-input-element mat-form-field-autofill-control ng-untouched ng-pristine ng-in')]");
	By editLeaveApplicationSave_btn=By.xpath("//span[@class='mat-button-wrapper' and contains(text(),'Save')]");
	
	public LeaveApplications_page(WebDriver driver){
		this.driver=driver;
	}
	
	
	/**
	 * This method is used to click on the Leave Application tab
	 */
	public void clickOnLeaveApplicationsTab() {
		try {
			clickWhenElementIsReady(driver, 20, leaveApplication_tab);
			LeaveApplications_pageLog.info("Application Clicked on Leave Application button");
		} catch (Exception e) {
			LeaveApplications_pageLog.info("Application Unable to Clicked on Leave Application button");
		}
	}
	
	/**
	 * This method is used to Clicked on Apply Leave button from Leave Application tab
	 */
	public void clickOnApplyLeave_btn(){
		try {
			clickWhenElementIsReady(driver, 20, leaveApplicationApplyLeave_btn);
			LeaveApplications_pageLog.info("Clicked on Apply Leave button from Leave Application tab");
		} catch (Exception e) {
			LeaveApplications_pageLog.info("Unable to clicked on Apply Leave button from Leave Application tab");
		}
	}
	
	/**
	 * This method is used to Select the Leave Type from Apply Leave Type pop up
	 * 
	 * @param leaveTypeName it should be applied leave
	 */
	public void selectTypeofLeave(String leaveTypeName) {
		clickWhenElementIsReady(driver,30, leaveApplicationSelectLeaveTypeDropDown_icon);
		 WebElement element = driver
				.findElement(By.xpath("//mat-option[@role='option']//span[contains(text(),'" + leaveTypeName + "')]"));
		if (element.isDisplayed()) {
			clickWhenElementIsReady(driver, 25, element);
			LeaveApplications_pageLog.info("Element is displayed and Clicked on Leave Type" + element.getText());
		} else {
			LeaveApplications_pageLog
					.info("Element is not displayed and unable to click on Leave Type" + element.getText());
		}
	}
	
	/**
	 * This method is used to click on Select Leave Type drop down from Apply
	 * Leave Pop up under Leave Application tab
	 * 
	 */
	public void clickOnSelectLeaveTypeDropDown() {
		try {
			clickWhenElementIsReady(driver, 30, leaveApplicationSelectLeaveTypeDropDown_icon);
			LeaveApplications_pageLog.info("Clicked on Leave type Drop Down");
		} catch (Exception e) {
			LeaveApplications_pageLog.info("Unable to click on Leave type Drop Down");
		}
	}
	
	/**
	 * This method is used to Select the Employee From Apply Leave pop up
	 * 
	 * @param employeePartialName
	 * @param employeeActualName
	 * @throws Exception
	 */
	public void selectEmployeefromApplyLeavePopUp(String employeePartialName, String employeeActualName) throws Exception {
		try {
			waitForElement(leaveApplicationApplyLeaveEditEmpName_inpuBox, 30);
			driver.findElement(leaveApplicationApplyLeaveEditEmpName_inpuBox).sendKeys(employeePartialName);
			//By parentElement=driver.findElement(By.xpath("//mat-option[@fxlayoutalign='space-between stretch']//span[@class='mat-option-text']//div[2]"));
			WebElement ele = driver.findElement(selectEmployeefromApplyLeavePopUpParentElemen);
			
			//List<By> celement = parentElement.findElements(By.tagName("div"));
			List<WebElement> allElements = ele.findElements(By.tagName("div"));
			/*for (By suggestion : celement) {
				suggestion.getText().equals(employeeActualName);
				suggestion.click();
				break;
			}*/
			
			for(WebElement e1:allElements){
				e1.getText().equals(employeeActualName);
				e1.click();
				break;
			}
			LeaveApplications_pageLog.info("Employee Selected");
		} catch (Exception e) {
			LeaveApplications_pageLog.info("Application unbale to select the Employee");
		}
	}
	

	/**
	 * This method is used to click on the From calendar icon From Apply Leave pop up under leave application tab
	 */
	public void clickFromCalendar_icon(){
		try {
			clickWhenElementIsReady(driver, 18, leaveApplicationApplyLeaveFormCalendar_btn);
			LeaveApplications_pageLog.info("Application clicked on From calendar icon from Apply Leave pop up");
		} catch (Exception e) {
			LeaveApplications_pageLog.info("Application unable to clicked on From claendar icon from Apply Leave pop up");
		}
	}
	
	/**
	 * This method is used to click on the TO calendar icon From Apply Leave pop up under leave application tab
	 */
	public void clickToCalendar_icon(){
		try {
			clickWhenElementIsReady(driver, 18, leaveApplicationApplyLeaveToCalendar_btn);
			LeaveApplications_pageLog.info("Application clicked on To calendar icon from Apply Leave pop up");
		} catch (Exception e) {
			LeaveApplications_pageLog.info("Application unable clicked on To calendar icon from Apply Leave pop up");
		}
	}
	
	/**
	 * This method is used to select the From Session 1 from Apply Leave pop up under Leave Application tab
	 */
	public void selectFromSession1fromApplyLeavePopUp(){
		try {
			clickWhenElementIsReady(driver, 19, leaveApplicationApplyLeaveFromSession1_radioBtn);
			LeaveApplications_pageLog.info("Application Select the From Session 1 option");
		} catch (Exception e) {
			LeaveApplications_pageLog.info("Application unable to Select From Session 1 option");
		}
	}
	
	/**
	 * This method is used to select the From Session 2 from Apply Leave pop up under Leave Application tab
	 */
	public void selectFromSession2fromApplyLeavePopUp(){
		try {
			clickWhenElementIsReady(driver, 19, leaveApplicationApplyLeaveFromSession2_radioBtn);
			LeaveApplications_pageLog.info("Application Select the From Session 2 option");
		} catch (Exception e) {
			LeaveApplications_pageLog.info("Application unable to Select From Session 2 option");
		}
	}
	
	/**
	 * This method is used to select the To Session 1 from Apply Leave pop up under Leave Application tab
	 */
	public void selectToSession1fromApplyLeavePopUp(){
		try {
			clickWhenElementIsReady(driver, 19, leaveApplicationApplyLeaveToSession1_radioBtn);
			LeaveApplications_pageLog.info("Application Select the To Session 1 option");
		} catch (Exception e) {
			LeaveApplications_pageLog.info("Application unable to Select To Session 1 option");
		}
	}
	
	/**
	 * This method is used to select the To Session 2 from Apply Leave pop up under Leave Application tab
	 */
	public void selectToSession2fromApplyLeavePopUp(){
		try {
			clickWhenElementIsReady(driver, 19, leaveApplicationApplyLeaveToSession2_radioBtn);
			LeaveApplications_pageLog.info("Application Select the To Session 2 option");
		} catch (Exception e) {
			LeaveApplications_pageLog.info("Application unable to Select To Session 2 option");
		}
	}
	
	/**
	 * This method is will return minimum error message to the user 
	 */
	public String getMinimumLeaveError_msg(){
		try {
			waitForElement(minLeave_error, 4);
			LeaveApplications_pageLog.info("Application returned the error message");
			return driver.findElement(minLeave_error).getText();
			
		} catch (Exception e) {
			LeaveApplications_pageLog.info("Application unable to returned the error message");
			return null;
		}
	}
	
	/**
	 * This method is used to returned the No Leave error message
	 * @return
	 */
	public String getNoLeaveError_msg(){
		try{
			waitForElement(noLeave_error, 4);
			LeaveApplications_pageLog.info("Application returned the No Leave error message");
			return driver.findElement(noLeave_error).getText();
		}catch (Exception e) {
			LeaveApplications_pageLog.info("Application unable to returned the No Leave error message");
			return null;
		}
	}
	
	/**
	 * This method is used to click on close button from Apply Leave pop up under Leave Applications tab
	 */
	public void clickOnApplyLeaveClose_btn(){
		try {
			clickWhenElementIsReady(driver, 19, leaveApplicationsApplyLeaveClose_btn);
			LeaveApplications_pageLog.info("Closed the apply leave pop up message");
		} catch (Exception e) {
			LeaveApplications_pageLog.info("Unable to closed the apply leave pop up message");
		}
	}
	
	/**
	 * This method is used to clear the Employee Name From Apply Leave pop up under Leave Application tab
	 */
	public void clearEmployeeName(){
		try {
			driver.findElement(leaveApplicationApplyLeaveEditEmpName_inputBoxClear).clear();
			LeaveApplications_pageLog.info("Clear the Employee Field from Aplly Leave pop up");
		} catch (Exception e) {
			LeaveApplications_pageLog.info("Unable to Clear the Employee Field from Aplly Leave pop up");
		}
	}
	
	/**
	 * This method is used to get all the text response messages which all are
	 * coming from Rest API Under Leave Application tab
	 * 
	 * @return
	 */
	public String getLeaveApplicationAllResponse_msg() {
		try {
			waitForElement(LeaveApplicationAllResponse_msg, 8);
			LeaveApplications_pageLog.info("Application found the error message");
			return driver.findElement(LeaveApplicationAllResponse_msg).getText();
		} catch (Exception e) {
			LeaveApplications_pageLog.info("Application unable to retrive the error message");
			return null;
		}
	}
	
	/**
	 * This method is used to click on the Apply button from Apply Leave pop up
	 */
	public void clickOnLeaveApply_btn(){
		try {
			clickWhenElementIsReady(driver, 10, leaveApplicationApplyLeaveApply_btn);
			LeaveApplications_pageLog.info("Clicked on the Apply button");
		} catch (Exception e) {
			LeaveApplications_pageLog.info("Clicked on the Apply button");
		}
	}
	
	/**
	 * This method is used to Edit the reason of Absence in Apply Leave pop up
	 */
	public void editApplyLeaveReasonofAbsence(String reasonofAbsence){
		try {
			driver.findElement(leaveApplicationapplyLeaveReasonOfAbsence_inputBox).sendKeys(reasonofAbsence);
			LeaveApplications_pageLog.info("Edited the reason of absence");
		} catch (Exception e) {
			LeaveApplications_pageLog.info("Unable to edit the reason of absence");
		}
	}
	
	/**
	 * This method is used to save the Newly Applied leave yes pop up
	 */
	public void clickOnApplyLeaveYes_popUp(){
		try {
			clickWhenElementIsReady(driver, 17, leaveApplicationApplyLeaveYes_popUp);
			LeaveApplications_pageLog.info("Clicked Yes pop up button");
		} catch (Exception e) {
			LeaveApplications_pageLog.info("Unable to click on Yes pop up button");
		}
	}
	
	
	/**
	 * This method is used to select the employee from Leave Applications Tab
	 */
	public void selectLeaveApplicationUnderAll_tab(String employeeID,int no){
		try {
			//List<WebElement> parentelement = driver.findElements(By.xpath("//td[contains(text(),'"+employeeID+"')]"));
			List<WebElement> parentelement = driver.findElements(By.xpath("//tr[@class='ng-star-inserted']//td[contains(text(),'"+employeeID+"')]"));
			int size=parentelement.size();
			for(int i=0;i<size;i++){
				if(i==(no-1)){
					LeaveApplications_pageLog.info("Application selected the Employee to edit leave application");
					parentelement.get(i).click();
					break;
				}
			}
		} catch (Exception e) {
			LeaveApplications_pageLog.info("Application unable to select the Employee to edit leave application");
		}
	}
	
	/**
	 * This method is used to select the employee Applied Leave Status from Leave Applications Tab
	 */
	public void selectLeaveApplicationLeaveTypeStatusAll_tab(String leaveTypeStatus,int no){
		try {
			//List<WebElement> parentelement = driver.findElements(By.xpath("//td[contains(text(),'"+employeeID+"')]"));
			List<WebElement> parentelement = driver.findElements(By.xpath("//tr[@class='ng-star-inserted']//td[contains(text(),'"+leaveTypeStatus+"')]"));
			int size=parentelement.size();
			for(int i=0;i<size;i++){
				if(i==(no-1)){
					LeaveApplications_pageLog.info("Application found the Employee leave type as "+leaveTypeStatus);
					 parentelement.get(i).getText().equals(leaveTypeStatus);
					break;
				}
			}
		} catch (Exception e) {
			LeaveApplications_pageLog.info("Application unable to found the Employee leave type as  "+leaveTypeStatus);
		}
	}
	
	/**
	 * This method is used to select the Country as filter
	 */
	public void selectCountryFilters(String countryName){
		try {
			clickWhenElementIsReady(driver, 12, leaveApplication_countryDropDown_icon);
			WebElement element = driver.findElement(By.xpath("//span[contains(text(),'"+countryName+"')]"));
			clickWhenElementIsReady(driver, 15, element);
			LeaveApplications_pageLog.info("Application clicked on Coutry as "+countryName);
		} catch (Exception e) {
			LeaveApplications_pageLog.info("Application unable to clicked on Coutry as "+countryName);
		}
	}
	
	/**
	 * This method is used to select the employee from the Filter drop down
	 * @param employeePartialName
	 * @param employeeActualName
	 */
	public void selectEmployeeNamefromFilter(String employeePartialName, String employeeActualName) {

		try {
			waitForElement(editEmploye_inputBoxInFilter, 30);
			driver.findElement(editEmploye_inputBoxInFilter).sendKeys(employeePartialName);
			WebElement ele = driver.findElement(selectEmployeefromApplyLeavePopUpParentElemen);
			List<WebElement> allElements = ele.findElements(By.tagName("div"));

			for (WebElement e1 : allElements) {
				e1.getText().equals(employeeActualName);
				e1.click();
				break;
			}
			LeaveApplications_pageLog.info("Employee Selected");
		} catch (Exception e) {
			LeaveApplications_pageLog.info("Application unbale to select the Employee");
		}
	}
	
	/**
	 * This method is used to click on the filters button
	 */
	public void clickOnFilterIcon(){
		try {
			clickWhenElementIsReady(driver, 12, leaveApplicationFilter_DropDownIcon);
			LeaveApplications_pageLog.info("Clicked on the filter button");
		} catch (Exception e) {
			LeaveApplications_pageLog.info("Unable to clicked on the filter button");
		}
	}
	
	/**
	 * This method is used to click on the Leave Application All tab
	 */
	public void clickLeaveApplicationAll_tab(){
		try {
			clickWhenElementIsReady(driver, 15, leaveApplicationAll_tab);
			LeaveApplications_pageLog.info("Clicked on the Leave Application All Tab");
		} catch (Exception e) {
			LeaveApplications_pageLog.info("Unable to click on Leave Application All Tab");
		}
	}
	
	/**
	 * This method is used to check and uncheck the Applied Filter option
	 */
	public void clickOnAppliedFilter_checkBox(){
		try {
			clickWhenElementIsReady(driver, 13, leaveApplication_AppliedCheckbox);
			LeaveApplications_pageLog.info("Applied Filter Check Box Located");
		} catch (Exception e) {
			LeaveApplications_pageLog.info("Unable to locate applied Filter Check Box");
		}
	}
	
	/**
	 * This method is used to check and un-check the Forwarded Filter option 
	 */
	public void clickOnForwarded_checkBox(){
		try {
			clickWhenElementIsReady(driver, 13,leaveApplication_ForwardedCheckbox);
			LeaveApplications_pageLog.info("Forwarded Filter Check Box Located");
		} catch (Exception e) {
			LeaveApplications_pageLog.info("Unable to locate Forwarded Filter Check Box");
		}
	}
	
	/**
	 * This method is used to check and un-check the Rejected Filter option 
	 */
	public void clickOnrejected_checkBox(){
		try {
			clickWhenElementIsReady(driver, 13,leaveApplication_rejectedCheckbox);
			LeaveApplications_pageLog.info("Rejected Filter Check Box Located");
		} catch (Exception e) {
			LeaveApplications_pageLog.info("Unable to locate Rejected Filter Check Box");
		}
	}
	
	
	/**
	 * This method is used to check and un-check the Withdraw Filter option 
	 */
	public void clickOnWithdraw_checkBox(){
		try {
			clickWhenElementIsReady(driver, 13,leaveApplication_withdrawnCheckbox);
			LeaveApplications_pageLog.info("Withdraw Filter Check Box Located");
		} catch (Exception e) {
			LeaveApplications_pageLog.info("Unable to locate Withdraw Filter Check Box");
		}
	}
	
	/**
	 * This method is used to edit the Remarks Field for Leave Application
	 */
	public void editRemarksField(String editInputText){
		try {
			waitForElement(leaveApplicationRemark_inputBox, 14);
			driver.findElement(leaveApplicationRemark_inputBox).sendKeys(editInputText);
			LeaveApplications_pageLog.info("Edited the remarke field");
		} catch (Exception e) {
			LeaveApplications_pageLog.info("Unable to edit the remarke field");
		}
	}
	
	/**
	 * This method is used to click on Leave Application Cancel button
	 */
	public void clickOnCancelApplication_btn(){
		try {
			clickWhenElementIsReady(driver, 14, cancelApplication_btn);
			LeaveApplications_pageLog.info("Clicked on Cancel Application button");
		} catch (Exception e) {
			LeaveApplications_pageLog.info("Cancel Application button not found");
		}
	}
	
	/**
	 * This method is used to reject applied leave application from admin view 
	 */
	public void clickOnRejectApplication_btn(){
		try {
			clickWhenElementIsReady(driver, 14, applicationReject_btn);
			LeaveApplications_pageLog.info("Clicked on Application Reject button");
		} catch (Exception e) {
			LeaveApplications_pageLog.info("Unable to clicked on Application Reject button");
		}
	}
	
	/**
	 * This method is used to click on the clear button to clear filter 
	 */
	public void clickOnClearFilter_btnFromFilter(){
		try {
			clickWhenElementIsReady(driver, 12, leaveApplication_clearFilterBtn);
			LeaveApplications_pageLog.info("Clicked filter clear button");
		} catch (Exception e) {
			LeaveApplications_pageLog.info("Unable to locate filter clear button");
		}
	}
	
	/**
	 * This method is used to click on Forward button to forward to leave application ti the skip manager
	 */
	public void clickOnForwardLeaveApplication_btn(){
		try {
			clickWhenElementIsReady(driver, 12, leaveApplicationForward_btn);
			LeaveApplications_pageLog.info("Clicked forward leave application button");
		} catch (Exception e) {
			LeaveApplications_pageLog.info("Unable to locate the forward leave application button");
		}
	}
	
	/**
	 * This method is used to click on Edit leave Application button to edit the leave
	 */
	public void clickOnEditLeaveApplications(){
		try {
			clickWhenElementIsReady(driver, 13, editLeaveApplication_btn);
			LeaveApplications_pageLog.info("Clicked edit leave application button");
		} catch (Exception e) {
			LeaveApplications_pageLog.info("Unable to click on edit leave application button");
		}
	}
	
	/**
	 * This method is used to edit the existing leave application 
	 * @param remarks
	 */
	public void editLeaveApplicationRemarks_inputBox(String remarks){
		try {
			waitForElement(editLeaveApplicationRemarks_inputBox, 13);
			driver.findElement(editLeaveApplicationRemarks_inputBox).sendKeys(remarks);
			LeaveApplications_pageLog.info("Edit remarks field with text");
		} catch (Exception e) {
			LeaveApplications_pageLog.info("Unable to edit remarks field with text");
		}
	}
	
	/**
	 * This method is used to save the Edit leave application save  button
	 */
	public void clickOnEditLeaveApplicationSave_btn(){
		try {
			clickWhenElementIsReady(driver, 13, editLeaveApplicationSave_btn);
			LeaveApplications_pageLog.info("Clicked on edit leave application Save button");
		} catch (Exception e) {
			LeaveApplications_pageLog.info("Unable to click on edit leave application Save button");
		}
	}

}
