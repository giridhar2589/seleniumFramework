package com.mu_sigma.OrgPlatformAutomationFramework.transferManagement.page;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;

public class TransferManagement_page extends TestBase {
	WebDriver driver;

	private static final Logger TransferManagement_pageLog = LogManager
			.getLogger(TransferManagement_page.class.getName());

	By username_inputBox=By.id("username");
	By password_inputBox=By.id("password");
	By submit_btn=By.id("submit");
	By errorInvalidUseranamePassword_text=By.xpath("//div[@class='login_message']");
	By transferManagementModuleTail=By.xpath("//a[@href='/transfer']");
	By newAccountName=By.xpath("(//input[@placeholder='Account Name'])[2]");
	By selectNewAccountName=By.xpath("//div[@class='mat-autocomplete-panel mat-autocomplete-visible']");
	By selectEmployee=By.xpath("//div[@class='mat-autocomplete-panel mat-autocomplete-visible']");
	By newManagerInputBox=By.xpath("//input[@placeholder='New Manager']");
	By selectNewManagerName=By.xpath("//div[@class='mat-option-text']");
	By currentRH_inputBox=By.xpath("(//input[@placeholder='RH'])[1]");
	By newRH_inputBox=By.xpath("(//input[@placeholder='RH'])[2]");
	By currentProjectAddress=By.xpath("//input[@placeholder='Current Project Address']");
	By newProjectAddress=By.xpath("//input[@placeholder='New Project Address']");
	By designation_clickDropwdown=By.xpath("//div[@class='mat-select-arrow-wrapper']//div[@class='mat-select-arrow'])[5]");
	By anydropdown_selectValue=By.xpath("//div[@class='mat-select-content ng-trigger ng-trigger-fadeInContent']");
	By currentCountry_clickDropdown=By.xpath("(//div[@class='mat-select-arrow-wrapper']//div[@class='mat-select-arrow'])[2]");
	By currentState_clickDropdown=By.xpath("(//div[@class='mat-select-arrow-wrapper']//div[@class='mat-select-arrow'])[3]");
	By currentCity_clickDropdown=By.xpath("(//div[@class='mat-select-arrow-wrapper']//div[@class='mat-select-arrow'])[4]");
	By newCountry_clickDropdown=By.xpath("(//div[@class='mat-select-arrow-wrapper']//div[@class='mat-select-arrow'])[6]");
	By newState_clickDropdown=By.xpath("(//div[@class='mat-select-arrow-wrapper']//div[@class='mat-select-arrow'])[7]");
	By newCity_clickDropdown=By.xpath("(//div[@class='mat-select-arrow-wrapper']//div[@class='mat-select-arrow'])[8]");
	By visaType_clickDropdown=By.xpath("(//div[@class='mat-select-arrow-wrapper']//div[@class='mat-select-arrow'])[9]");
	By submitTransferRequest=By.xpath("//button[@type='submit']");
	By lastDate_dropdown=By.xpath("(//button[@type='button'])[7]");
	By joiningDate_dropdown=By.xpath("(//button[@type='button'])[8]");
	By withdraw_btn=By.xpath("//span[text()='Withdraw']");
	By comment_inputBox=By.xpath("//div[@class='mat-input-infix mat-form-field-infix']//textarea");
	By clickonarrowtologout=By.xpath("(//button[@class='mat-icon-button'])[1]");
	By clickonlogout=By.xpath("//a[@class='mat-menu-item']");
	By impersonateArrowIcon=By.id("arrow");
	By impersonateBox=By.xpath("//input[@placeholder='User Id']");
	By impersonateSwitch=By.xpath("//input[@value='Switch']");
	By muQuest_icon=By.xpath("//img[@src='assets/images/muquestlogo.png']");
	By employeeSearchBox=By.xpath("//input[@placeholder='Employee Search']");
	By clearSearchBox=By.xpath("//div[@class='mat-toolbar-layout']//mat-icon[2]");
	By selectSpecificRequest=By.xpath("//div[@class='mat-list-text']");
	By approvalConfirmationPopUp=By.xpath("//div[@class='cdk-overlay-pane']//h2[contains(text(),'Request Approval')]");
	By withdrawConfirmationPopUp=By.xpath("//div[@class='cdk-overlay-pane']//h2[contains(text(),'Withdraw Request')]");
	By withdrawapprovalConfirmationPopUp=By.xpath("//div[@class='cdk-overlay-pane']//h2[contains(text(),'Approve Withdrawal')]");
	By withdrawrejectionConfirmationPopUp=By.xpath("//div[@class='cdk-overlay-pane']//h2[contains(text(),'Reject Withdrawal')]");
	By rejectrequestatchecklistPopUP=By.xpath("//div[@class='cdk-overlay-pane']//h2[contains(text(),'Reject Request')]");
	By invalidaterequestPopUP=By.xpath("//div[@class='cdk-overlay-pane']//h2[contains(text(),'Invalidate Request')]");
	By newRequestButton=By.xpath("//button[@class='mat-raised-button mat-accent']");
	By filterButton =By.xpath("//button[@class='mat-fab-position mat-fab mat-warn']");
	By selectWithdraw_checkbox=By.xpath("//*[@id='mat-checkbox-2']/label/div");
	By selectCurrentManager_checkbox=By.xpath("//*[@id='mat-checkbox-3']/label/div");
	By selectNewManager_checkbox=By.xpath("//*[@id='mat-checkbox-4']/label/div");
	By selectImmigration_checkbox=By.xpath("//*[@id='mat-checkbox-5']/label/div");
	By selectChecklist_checkbox=By.xpath("//*[@id='mat-checkbox-6']/label/div");
	By selectHR_checkbox=By.xpath("//*[@id='mat-checkbox-7']/label/div");
	By selectClosed_checkbox=By.xpath("//*[@id='mat-checkbox-9']/label/div");
	By applyFilterButton=By.xpath("//span[contains(text(),'Apply Filters')]");
	By allTab=By.id("mat-tab-label-0-1");
	By selectReasonDropdown=By.id("mat-select-17");
	By selectInvalidReason=By.xpath("//span[@class='mat-option-text']");
	By employeeIDinputbox=By.xpath("//input[@placeholder='Employee ID']");
	By clickOnResumeToImpersonate=By.xpath("//div[@id='header-login-pop1' and contains(text(),'Resume')]");
	By successMessage=By.xpath("//div[@class='cdk-visually-hidden' and contains(text(),'initiated')]");
	By mandatoryinputvalidationMessage=By.xpath("//div[@class='cdk-visually-hidden' and contains(text(),'required details')]");
	By datevalidationMessage=By.xpath("//div[@class='cdk-visually-hidden' and contains(text(),'working date')]");
	By successMessage_anyAction=By.xpath("//div[@class='cdk-visually-hidden' and contains(text(),'updated')]");
	//By successMessage_anyAction=By.xpath("//snack-bar-container[contains(@class,'mat-snack-bar-container ng-tns'))]");
	By successMessage_individualChecklistMarkedComplete=By.xpath("//div[@class='cdk-visually-hidden' and contains(text(),'Checklist')]");
	By newRequest_headerText=By.xpath("//div[contains(text(),'New Request')]");
	By alertmessage_logout=By.xpath("//div[@class='alert alert-success']//h2[contains(text(),'Logout')]");
	By transferManagement_headerText=By.xpath("//span[contains(text(),'Transfer Management')]");
	By impersonation_designation=By.xpath("//span[@class='mat-caption']");
	By pending_headerText=By.xpath("(//div[@class='mat-card-header-text'])[1]");
	By editicon_checklist=By.xpath("//button[@class='mat-mini-fab mat-accent']");
	By addnewlineitem_checklist=By.xpath("//button[@class='mat-mini-fab mat-accent']");
	By item_inputbox=By.xpath("//input[@placeholder='Item']");
	By comments_inputbox=By.xpath("//input[@placeholder='Comments']");
	By submit_indivualchecklist=By.xpath("//span[contains(text(),'Submit')]");
	By checklist_actionitem_clickDropdown=By.xpath("(//div[@class='mat-select-arrow-wrapper']//div[@class='mat-select-arrow'])[2]");
	By triggermail=By.xpath("//div[@id='requestDeatilTimeline']//section");
	By checkbox_TriggerMail=By.xpath("//div[@class='mat-checkbox-inner-container mat-checkbox-inner-container-no-side-margin']");


	/**
	 * Method to initiate the driver
	 * 
	 * @param driver
	 */
	public TransferManagement_page(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Method to enter the username and password to login
	 * 
	 * @param username
	 * @param password
	 */

	public void fillLoginDetails(String username, String password) {
		driver.findElement(username_inputBox).sendKeys(username);
		TransferManagement_pageLog.info("Filled the Username");
		driver.findElement(password_inputBox).sendKeys(password);
		TransferManagement_pageLog.info("Filled the Password");
		driver.findElement(submit_btn).click();
		TransferManagement_pageLog.info("Clicked on the Submit button");
	}
	
	/**
	 * Method to navigate to transfer management application
	 */
	public void navigateToTransferManagementApp(){
		driver.findElement(transferManagementModuleTail).click();
		switchWindow(1);
		TransferManagement_pageLog.info("Logged into transfer management application");
	}

	/**
	 * Method to get the error message when invalid credentials are entered
	 * 
	 * @return
	 */

	public String getInvalidUserNamePasswordText() {
		return driver.findElement(errorInvalidUseranamePassword_text).getText();
	}

	/**
	 * Method to enter the current project address of transfer request
	 * @param address
	 */

	public void getCurrentAddress(String address) {
		driver.findElement(currentProjectAddress).sendKeys(address);
		TransferManagement_pageLog.info("Entered current project address");
	}

	/**
	 * Method to enter the new project address of transfer request
	 * 
	 * @param address
	 */

	public void getNewAddress(String address) {
		driver.findElement(newProjectAddress).sendKeys(address);
		TransferManagement_pageLog.info("Entered new project address");
	}
	
	/**
	 * Method to select any value on click of dropdown
	 * 
	 * @param dropdownoption
	 * @throws Exception 
	 */
	
	public void selectValueFromAnyDropdown(String dropdownoption) throws Exception{
		Thread.sleep(3000);
		List<WebElement> childElement = driver.findElement(anydropdown_selectValue).findElements(By.tagName("span"));
		for (WebElement values : childElement) {
			if (values.getText().equals(dropdownoption)) {
				values.click();
				break;
			}
			else{
				TransferManagement_pageLog.info("Unable to select value from the dropdown");
			}
		}
		
	}

	/**
	 * Method to click Country dropdown of the current project
	 * 
	 * @param countryName
	 * @throws Exception
	 */

	public void selectCurrentCountry() throws Exception {
		waitForElement(currentCountry_clickDropdown, 4);
		clickWhenElementIsReady(driver, 5 , currentCountry_clickDropdown);
		TransferManagement_pageLog.info("Current Country dropdown clicked");
		
	}

	/**
	 * Method to click State dropdown of the current project 
	 * 
	 * @param stateName
	 * @throws Exception
	 */

	public void selectCurrentState() throws Exception {
		waitForElement(currentState_clickDropdown, 4);
		clickWhenElementIsReady(driver, 5 , currentState_clickDropdown);
		TransferManagement_pageLog.info("Current State dropdown clicked");

	}

	/**
	 * Method to click City dropdown of the current project
	 * 
	 * @param cityName
	 * @throws Exception
	 */

	public void selectCurrentCity() throws Exception {
		waitForElement(currentCity_clickDropdown, 4);
		clickWhenElementIsReady(driver, 5 , currentCity_clickDropdown);
		TransferManagement_pageLog.info("Current City dropdown clicked");
	}

	/**
	 * Method to click Country dropdown of the new project 
	 * 
	 * @param countryName
	 * @throws Exception
	 */

	public void selectNewCountry() throws Exception {
		Thread.sleep(3000);
		driver.findElement(newCountry_clickDropdown).click();
		TransferManagement_pageLog.info("New Country dropdown clicked");
	}

	/**
	 * Method to click State dropdown of the new project 
	 * 
	 * @param stateName
	 * @throws Exception
	 */

	public void selectNewState() throws Exception {
		waitForElement(newState_clickDropdown, 4);
		clickWhenElementIsReady(driver, 5 , newState_clickDropdown);
		TransferManagement_pageLog.info("New State dropdown clicked");
	}

	/**
	 * Method to click City dropdown of the new project
	 * 
	 * @param cityName
	 * @throws Exception
	 */

	public void selectNewCity() throws Exception {
		//waitForElement(newCity_clickDropdown, 4);
		Thread.sleep(3000);
		clickWhenElementIsReady(driver, 5 , newCity_clickDropdown);
		TransferManagement_pageLog.info("New City dropdown clicked");
	}

	/**
	 * Method to click Visa type dropdown of the new project
	 * 
	 * @param visaType
	 * @throws Exception
	 */

	public void selectVisaType() throws Exception {
		Thread.sleep(3000);
		driver.findElement(visaType_clickDropdown).click();
		TransferManagement_pageLog.info("Visa type dropdown clicked");
	}
	
	/**
	 * Method to click on submit button to raise transfer request
	 * @throws Exception
	 */
	
	public void clickSubmitBtn() throws Exception{
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(submitTransferRequest));
		clickWhenElementIsReady(driver, 5 ,submitTransferRequest);
		Thread.sleep(2000);
	}

	/**
	 * Method to click Designation dropdown of the new project
	 * 
	 * @param designationType
	 * @throws Exception
	 */

	public void selectDesignation() throws Exception {
		Thread.sleep(3000);
		driver.findElement(designation_clickDropwdown).click();
		TransferManagement_pageLog.info("Designation dropdown clicked");
	}

	/**
	 * Method to select New Account of transfer request
	 * 
	 * @param newProjectAccountName
	 * @throws Exception
	 */

	public void selectNewAccount(String newProjectAccountName) throws Exception {
		clickWhenElementIsReady(driver, 5, newAccountName);
		driver.findElement(newAccountName).sendKeys(newProjectAccountName);
		TransferManagement_pageLog.info("New Account Name is entered");
		waitForElement(selectNewAccountName, 5);
		List<WebElement> childElement = driver.findElement(selectNewAccountName).findElements(By.tagName("span"));
		for (WebElement values : childElement) {
			if (values.getText().equals(newProjectAccountName)) {
				values.click();
				break;
			}
			else{
				TransferManagement_pageLog.info("Unable to select value from the dropdown");
			}
		}

	}

	/**
	 * Method to select New Manager of transfer request
	 * 
	 * @param newProjectManagerEmpID
	 * @throws Exception
	 */

	public void selectNewAccountManager(String newProjectManagerEmpID) throws Exception {
		Actions action = new Actions(driver);
		clickWhenElementIsReady(driver, 30, newManagerInputBox);
		driver.findElement(newManagerInputBox).sendKeys(newProjectManagerEmpID);
		TransferManagement_pageLog.info("Employee ID of New Manager entered");
		action.moveToElement(driver.findElement(selectEmployee)).click(driver.findElement(selectEmployee)).build().perform();
		TransferManagement_pageLog.info("New Manager selected");
	}

	/**
	 * Method to select RH of Current project of transfer request
	 * 
	 * @param currentRHEmpID
	 * @throws Exception
	 */

	public void selectCurrentRH(String currentRHEmpID) throws InterruptedException {
		Actions action = new Actions(driver);
		clickWhenElementIsReady(driver, 30, currentRH_inputBox);
		driver.findElement(currentRH_inputBox).sendKeys(currentRHEmpID);
		TransferManagement_pageLog.info("Employee ID of Current RH entered");
		action.moveToElement(driver.findElement(selectEmployee)).click(driver.findElement(selectEmployee)).build().perform();
		TransferManagement_pageLog.info("Current RH selected");
	}

	/**
	 * Method to select RH of New project of transfer request
	 * 
	 * @param newRHEmpID
	 * @throws Exception
	 */

	public void selectNewRH(String newRHEmpID) throws InterruptedException {
		Actions action = new Actions(driver);
		clickWhenElementIsReady(driver, 30, newRH_inputBox);
		driver.findElement(newRH_inputBox).sendKeys(newRHEmpID);
		TransferManagement_pageLog.info("Employee ID of New RH entered");
		action.moveToElement(driver.findElement(selectEmployee)).click(driver.findElement(selectEmployee)).build().perform();
		TransferManagement_pageLog.info("Employee ID of New RH entered");
	}

	/**
	 * Method to select Last date of Current project of transfer request
	 * 
	 * @param lastDateValue
	 * @throws Exception
	 */
	
	public void selectLastDate(String lastDateValue) throws Exception{
		waitForElement(lastDate_dropdown, 3);
		driver.findElement(lastDate_dropdown).click();
		TransferManagement_pageLog.info("Last date dropdown clicked");
		WebElement lastdate = driver.findElement(
				By.xpath("//div[@class='mat-calendar-body-cell-content' and contains(text(),'" + lastDateValue + "')]"));
		lastdate.click();
		TransferManagement_pageLog.info("last date value selected");
		
	}

	/**
	 * Method to select Joining date of New project of transfer request
	 * 
	 * @param joiningDateValue
	 * @throws Exception
	 */

	public void selectJoiningDate(String joiningDateValue) throws Exception{
		driver.findElement(joiningDate_dropdown).click();
		TransferManagement_pageLog.info("Last date dropdown clicked");
		WebElement joiningdate = driver.findElement(
				By.xpath("//div[@class='mat-calendar-body-cell-content' and contains(text(),'" +joiningDateValue + "')]"));
		joiningdate.click();
		TransferManagement_pageLog.info("joining date value selected");
		
	}

	/**
	 * Method to impersonate any employee and navigate to transfer management
	 * 
	 * @param impersonateEmployeeName
	 * @throws Exception
	 */

	public void impersonateEmployee(String impersonateEmployeeName) {
		clickWhenElementIsReady(driver, 1, impersonateArrowIcon);
		driver.findElement(impersonateBox).sendKeys(impersonateEmployeeName);
		driver.findElement(impersonateSwitch).click();
		clickWhenElementIsReady(driver, 10, transferManagementModuleTail);
		switchWindow(1);
		TransferManagement_pageLog.info("Impersonation successful");

	}
	
	public void impersonate(String impersonateEmployeeName){
		switchWindow(0);
		clickWhenElementIsReady(driver, 3, impersonateArrowIcon);
		clickWhenElementIsReady(driver, 3, clickOnResumeToImpersonate);
		clickWhenElementIsReady(driver, 3, impersonateArrowIcon);
		driver.findElement(impersonateBox).sendKeys(impersonateEmployeeName);
		driver.findElement(impersonateSwitch).click();
		switchWindow(1);
		driver.navigate().refresh();
		TransferManagement_pageLog.info("Impersonation successful");
	}

	/**
	 * Method to enter employee ID in search option
	 * 
	 * @param employeeID
	 * @throws Exception 
	 */

	public void employeeSearch(String employeeID) throws Exception {
		Thread.sleep(1000);
		Actions action = new Actions(driver);
		driver.findElement(employeeSearchBox).sendKeys(employeeID);
		TransferManagement_pageLog.info("Employee ID to search transfer request entered");
		action.moveToElement(driver.findElement(selectEmployee)).click(driver.findElement(selectEmployee)).build().perform();
	}

	/**
	 * Method to select specific transfer request based on joining date
	 * 
	 * @param joiningDate
	 * @throws Exception
	 */

	public void clickselectSpecificRequest(String joiningDate) throws Exception {
		Thread.sleep(2000);
		List<WebElement> childElement = driver.findElement(selectSpecificRequest).findElements(By.tagName("span"));
		for (WebElement values : childElement) {
			if (values.getText().equals(joiningDate)) {
				values.click();
				break;
			}
			else{
					TransferManagement_pageLog.info("Unable to select the specific request");
				}
		}
	}


	/**
	 * Method to approve raised transfer request
	 * 
	 * @param approvebutton
	 * @param confirmationbutton
	 * @throws Exception
	 */

	public void approveTransferRequest(String approvebutton, String confirmationbutton) throws Exception {
		Thread.sleep(3000);
		WebElement approvebtn = driver.findElement(
				By.xpath("//span[@class='mat-button-wrapper' and contains(text(),'" + approvebutton + "')]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", approvebtn);
		clickWhenElementIsReady(driver, 13, approvebtn);
		if (driver.findElement(approvalConfirmationPopUp).isDisplayed()) {
			WebElement yesbtn = driver.findElement(
					By.xpath("//span[@class='mat-button-wrapper' and contains(text(),'" + confirmationbutton + "')]"));
			clickWhenElementIsReady(driver, 30, yesbtn);
			Thread.sleep(1000);
		} else {
			TransferManagement_pageLog.info("Unable to approve request");
		}

	}

	/**
	 * Method to modify the details of raised transfer request
	 * 
	 * @param modifybutton
	 * @param commentvalue
	 * @throws Exception 
	 */

	public void modifyTransferRequest(String modifybutton, String commentvalue) throws Exception {
		WebElement modifybtn = driver.findElement(
				By.xpath("//span[@class='mat-button-wrapper' and contains(text(),'" + modifybutton + "')]"));
		clickWhenElementIsReady(driver, 13, modifybtn);
		clickWhenElementIsReady(driver, 13, comment_inputBox);
		driver.findElement(comment_inputBox).sendKeys(commentvalue);
		TransferManagement_pageLog.info("Modified transfer request details");
	}

	/**
	 * Method to save the modified details of raised transfer request
	 * 
	 * @param confirmbutton
	 */

	public void saveModifiedDetails(String confirmbutton) {
		WebElement savebtn = driver.findElement(
				By.xpath("//span[@class='mat-button-wrapper' and contains(text(),'" + confirmbutton + "')]"));
		clickWhenElementIsReady(driver, 13, savebtn);
		TransferManagement_pageLog.info("Save button clicked to update modified details");
	}

	/**
	 * Method to withdraw raised transfer request
	 * 
	 * @param withdrawbutton
	 * @param commentvalue
	 * @param confirmationbutton
	 * @throws InterruptedException
	 */

	public void withdrawTransferRequest(String withdrawbutton, String commentvalue, String confirmationbutton)
			throws InterruptedException {
		WebElement withdrawbtn = driver.findElement(
				By.xpath("//span[@class='mat-button-wrapper' and contains(text(),'" + withdrawbutton + "')]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", withdrawbtn);
		clickWhenElementIsReady(driver, 13, comment_inputBox);
		driver.findElement(comment_inputBox).sendKeys(commentvalue);
		clickWhenElementIsReady(driver, 13, withdrawbtn);
		if (driver.findElement(withdrawConfirmationPopUp).isDisplayed()) {
			WebElement yesbtn = driver.findElement(
					By.xpath("//span[@class='mat-button-wrapper' and contains(text(),'" + confirmationbutton + "')]"));
			clickWhenElementIsReady(driver, 30, yesbtn);
		} else {
			TransferManagement_pageLog.info("Unable to withdrawrequest");
		}
	}

	/**
	 * Method to click on generated checklists and mark as complete to approve
	 * transfer request at checklist level
	 * 
	 * @param checklistName
	 * @param buttonName
	 * @param indexvalue
	 * @throws Exception 
	 */

	public void clickOnChecklist(String checklistName, String buttonName, String indexvalue,String iteminput,String commentsinput) throws Exception {

		WebElement checklistelement = driver
				.findElement(By.xpath("(//div[contains(text(),'" + checklistName + "')])[" + indexvalue + "]"));
		clickWhenElementIsReady(driver, 20, checklistelement);
		TransferManagement_pageLog.info("Checklist tile clicked successfully");
		clickWhenElementIsReady(driver, 10, editicon_checklist);
		TransferManagement_pageLog.info("edit icon of checklist clicked successfully");
		clickWhenElementIsReady(driver, 10, addnewlineitem_checklist);
		TransferManagement_pageLog.info("add new line item clicked successfully");
		driver.findElement(item_inputbox).sendKeys(iteminput);
		driver.findElement(comments_inputbox).sendKeys(commentsinput);
		clickWhenElementIsReady(driver, 10, submit_indivualchecklist);
		TransferManagement_pageLog.info("dynamic line item added and submitted successfully");
		WebElement markascompletebutton = driver
				.findElement(By.xpath("//span[@class='mat-button-wrapper' and contains(text(),'" + buttonName + "')]"));
		clickWhenElementIsReady(driver, 20, markascompletebutton);
		TransferManagement_pageLog.info("checklist marked complete");
	}

	/**
	 * Method to raise new request by clicking New Request button
	 * 
	 * @throws Exception
	 */

	public void clickOnNewRequest() throws Exception {
		Thread.sleep(1000);
		clickWhenElementIsReady(driver, 10, newRequestButton);
		TransferManagement_pageLog.info("New Request button clicked");
		Thread.sleep(1000);
	}

	/**
	 * Method to filter out withdraw transfer requests using filter option
	 * 
	 * @throws InterruptedException
	 */

	public void selectFilter() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(filterButton).click();
		TransferManagement_pageLog.info("Filter button clicked");
		waitForElement(selectWithdraw_checkbox, 2);
		driver.findElement(selectWithdraw_checkbox).click();
		TransferManagement_pageLog.info("Withdraw option is selected");
		waitForElement(applyFilterButton, 2);
		clickWhenElementIsReady(driver, 10, applyFilterButton);
		TransferManagement_pageLog.info("Apply Filter button clicked");
		Thread.sleep(2000);
	}

	/**
	 * Method to approve withdrawn transfer request
	 * 
	 * @param withdrawapprovalbutton
	 * @param commentvalue
	 * @param confirmationbutton
	 * @throws InterruptedException
	 */

	public void approvewithdrawalTransferRequest(String withdrawapprovalbutton, String commentvalue,
			String confirmationbutton) throws InterruptedException {
		WebElement withdrawapprovalbtn = driver.findElement(
				By.xpath("//span[@class='mat-button-wrapper' and contains(text(),'" + withdrawapprovalbutton + "')]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", withdrawapprovalbtn);
		clickWhenElementIsReady(driver, 13, comment_inputBox);
		driver.findElement(comment_inputBox).sendKeys(commentvalue);
		clickWhenElementIsReady(driver, 13, withdrawapprovalbtn);
		if (driver.findElement(withdrawapprovalConfirmationPopUp).isDisplayed()) {
			WebElement yesbtn = driver.findElement(
					By.xpath("//span[@class='mat-button-wrapper' and contains(text(),'" + confirmationbutton + "')]"));
			clickWhenElementIsReady(driver, 30, yesbtn);
		} else {
			TransferManagement_pageLog.info("Unable to approve withdrawrequest");
		}
	}
	
	/**
	 * Method to reject withdrawn transfer request
	 * @param withdrawrejectionbutton
	 * @param commentvalue
	 * @param confirmationbutton
	 * @throws InterruptedException
	 */
	public void rejectwithdrawalTransferRequest(String withdrawrejectionbutton, String commentvalue,
			String confirmationbutton) throws InterruptedException {
		Thread.sleep(3000);
		WebElement withdrawrejectionbtn = driver.findElement(
				By.xpath("//span[@class='mat-button-wrapper' and contains(text(),'" + withdrawrejectionbutton + "')]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", withdrawrejectionbtn);
		clickWhenElementIsReady(driver, 13, comment_inputBox);
		driver.findElement(comment_inputBox).sendKeys(commentvalue);
		clickWhenElementIsReady(driver, 13, withdrawrejectionbtn);
		if (driver.findElement(withdrawrejectionConfirmationPopUp).isDisplayed()) {
			WebElement yesbtn = driver.findElement(
					By.xpath("//span[@class='mat-button-wrapper' and contains(text(),'" + confirmationbutton + "')]"));
			clickWhenElementIsReady(driver, 30, yesbtn);
		} else {
			TransferManagement_pageLog.info("Unable to reject withdrawrequest");
		}
	}
	
	

	/**
	 * Method to reject the transfer request
	 * 
	 * @param rejectbutton
	 * @param commentvalue
	 * @param confirmationbutton
	 * @throws InterruptedException
	 */

	public void rejectTransferRequest(String rejectbutton, String commentvalue,
			String confirmationbutton) throws InterruptedException {
		WebElement rejectbtn = driver.findElement(
				By.xpath("//span[@class='mat-button-wrapper' and contains(text(),'" + rejectbutton + "')]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", rejectbtn);
		clickWhenElementIsReady(driver, 13, comment_inputBox);
		driver.findElement(comment_inputBox).sendKeys(commentvalue);
		clickWhenElementIsReady(driver, 13, rejectbtn);
		if (driver.findElement(rejectrequestatchecklistPopUP).isDisplayed()) {
			WebElement yesbtn = driver.findElement(
					By.xpath("//span[@class='mat-button-wrapper' and contains(text(),'" + confirmationbutton + "')]"));
			clickWhenElementIsReady(driver, 30, yesbtn);
		} else {
			TransferManagement_pageLog.info("Unable to reject request at checklist level");
		}

	}

	/**
	 * Method to click on All tab to view all requests
	 * 
	 * @throws Exception
	 */

	public void clickAllTab() throws Exception {
		clickWhenElementIsReady(driver, 20, allTab);
		TransferManagement_pageLog.info("All tab to view all requests is clicked");
		Thread.sleep(1000);
	}

	/**
	 * Method to filter out Completed transfer requests of All tab using filter
	 * option
	 * 
	 * @throws Exception
	 */

	public void selectFilterForAllTab() throws Exception {
		driver.findElement(filterButton).click();
		TransferManagement_pageLog.info("Filter button clicked");
		Thread.sleep(1000);
		driver.findElement(selectClosed_checkbox).click();
		TransferManagement_pageLog.info("Closed checkbox clicked");
		driver.findElement(selectCurrentManager_checkbox).click();
		TransferManagement_pageLog.info("Current Manager checkbox clicked");
		driver.findElement(selectNewManager_checkbox).click();
		TransferManagement_pageLog.info("New Manager checkbox clicked");
		driver.findElement(selectImmigration_checkbox).click();
		TransferManagement_pageLog.info("Immigration checkbox clicked");
		driver.findElement(selectChecklist_checkbox).click();
		TransferManagement_pageLog.info("Checklist checkbox clicked");
		driver.findElement(selectHR_checkbox).click();
		TransferManagement_pageLog.info("HR checkbox clicked");
		Thread.sleep(1000);
		driver.findElement(applyFilterButton).click();
		TransferManagement_pageLog.info("Apply Filter button clicked");
	}

	/**
	 * Method to reject Completed transfer request by Admin
	 * 
	 * @param rejectbutton
	 * @param commentvalue
	 * @param confirmationbutton
	 * @throws InterruptedException
	 */

	public void rejectCompletedTransferRequest(String rejectbutton, String commentvalue, String confirmationbutton)
			throws InterruptedException {
		Thread.sleep(3000);
		WebElement rejectbtn = driver.findElement(
				By.xpath("//span[@class='mat-button-wrapper' and contains(text(),'" + rejectbutton + "')]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", rejectbtn);
		clickWhenElementIsReady(driver, 13, rejectbtn);
		driver.findElement(selectReasonDropdown).click();
		driver.findElement(selectInvalidReason).click();
		clickWhenElementIsReady(driver, 13, comment_inputBox);
		driver.findElement(comment_inputBox).sendKeys(commentvalue);
		clickWhenElementIsReady(driver, 13, rejectbtn);
		if (driver.findElement(invalidaterequestPopUP).isDisplayed()) {
			WebElement yesbtn = driver.findElement(
					By.xpath("//span[@class='mat-button-wrapper' and contains(text(),'" + confirmationbutton + "')]"));
			clickWhenElementIsReady(driver, 30, yesbtn);
		} else {
			TransferManagement_pageLog.info("Unable to reject completed request");
		}

	}
	
	/**
	 * Method to select valid reason from the dropdown for modification by immigration
	 * @param validReason
	 */
	
	public void modifyRequestAtImmigrationLevel(){
		driver.findElement(selectReasonDropdown).click();
		TransferManagement_pageLog.info("select valid reason dropdown clicked for modification by immigartion");
	}

	/**
	 * Method to logout from the transfer management screen
	 * 
	 * @throws Exception
	 */

	public void logout() throws Exception {
		clickWhenElementIsReady(driver, 10, clickonarrowtologout);
		Thread.sleep(2000);
		clickWhenElementIsReady(driver, 10, clickonlogout);
		TransferManagement_pageLog.info("user logged out successfully");
	}
	
	/**
	 * Method to return the validation message that is shown when user tries to raise request without entering all the mandatory inputs
	 * @return
	 */
	
	public String mandatoryFieldsMessage_text(){
		waitForElement(mandatoryinputvalidationMessage, 15);
		return driver.findElement(mandatoryinputvalidationMessage).getText();
	}
	
	/**
	 * Method to return the validation message to check if there exists a request with same joining/last working date
	 * @return
	 */
	public String datavalidationMessage_text(){
		waitForElement(datevalidationMessage, 10);
		return driver.findElement(datevalidationMessage).getText();
	}

	/**
	 * Method to return the success message text that is shown after transfer
	 * request has been submitted successfully
	 * 
	 * @return
	 */
	public String successMessage_text() {
		waitForElement(successMessage, 15);
		return driver.findElement(successMessage).getText();
	}

	/**
	 * Method to return the success message text that is shown for any action
	 * button like approve or reject or modify or withdraw is clicked
	 * 
	 * @return
	 */

	public String successMessage_anyAction_text() {
		waitForElement(successMessage_anyAction, 15);
		return driver.findElement(successMessage_anyAction).getText();
	}

	/**
	 * Method to return the success message text that is shown when individual
	 * checklist is clicked and marked as complete
	 * 
	 * @return
	 */

	public String successMessage_individualChecklistMarkedComplete_text() {
		waitForElement(successMessage_individualChecklistMarkedComplete, 15);
		return driver.findElement(successMessage_individualChecklistMarkedComplete).getText();
	}

	/**
	 * Method to return the header text that appears on UI on click of New
	 * Request button
	 * 
	 * @return
	 */

	public String newrequest_header_text() {
		waitForElement(newRequest_headerText, 15);
		return driver.findElement(newRequest_headerText).getText();
	}

	/**
	 * Method to return the header text that confirms that user has logged into
	 * transfer management screen
	 * 
	 * @return
	 */

	public String transferManagementPage_header_text() {
		waitForElement(transferManagement_headerText, 10);
		return driver.findElement(transferManagement_headerText).getText();
	}

	/**
	 * Method to check if login is enabled and return boolean value for assert
	 * function
	 * 
	 * @return
	 */

	public boolean checkifloginisEnabled() {
		boolean value = driver.findElement(submit_btn).isEnabled();
		return value;

	}
	
	/**
	 * Method to return the logout message from the alert pop up shown on logging out
	 * @return
	 */
	public String getAlertForLogout(){
		waitForElement(alertmessage_logout,5);
		return driver.findElement(alertmessage_logout).getText();
	}
	
	
	/**
	 * Method to return designation text shown on UI on impersonation
	 * @return
	 */
	
	public String getDesignation_text(){
		waitForElement(impersonation_designation, 10);
		return driver.findElement(impersonation_designation).getText();
	}
	
	/**
	 * Method to return pending approval from text shown on click of specific request for approval 
	 * @return
	 */
	
	public String getPendingApprovalFrom_text(){
		waitForElement(pending_headerText, 10);
		return driver.findElement(pending_headerText).getText();
	}
	
	/**
	 * Method to enter the employee ID while raising request for any employee by admin
	 * @param empID
	 * @throws Exception
	 */

	public void enterEmpID(String empID) throws Exception {
		waitForElement(employeeIDinputbox, 2);
		driver.findElement(employeeIDinputbox).click();
		driver.findElement(employeeIDinputbox).sendKeys(empID);
		TransferManagement_pageLog.info("employee id entered successfully");
		Thread.sleep(1000);
	}
	
	/**
	 * Metdhod to clear the search box by clicking on the close button 
	 * @throws Exception
	 */
	
	public void clearSearchBox() throws Exception{
		waitForElement(clearSearchBox, 2);
		driver.findElement(clearSearchBox).click();
		TransferManagement_pageLog.info("employee search button clicked successfully");
		Thread.sleep(2000);
	}
	
	/**
	 * Method to deselect Trigger Mail checkbox that is shown for an admin
	 * @throws Exception
	 */
	
	public void deselectTriggerMailCheckBox() throws Exception{
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", triggermail);
		clickWhenElementIsReady(driver, 5, checkbox_TriggerMail);
		TransferManagement_pageLog.info("Trigger mail checkbox deselected");
		Thread.sleep(1000);
	}

}