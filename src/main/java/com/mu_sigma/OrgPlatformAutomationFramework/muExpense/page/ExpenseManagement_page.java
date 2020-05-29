package com.mu_sigma.OrgPlatformAutomationFramework.muExpense.page;

import java.text.DateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;

public class ExpenseManagement_page extends TestBase {
	WebDriver driver;
	private static final Logger AddBill_pageLog = LogManager
			.getLogger(ExpenseManagement_page.class.getName());

	By username_inputBox = By.id("username");
	By password_inputBox = By.id("password");
	By submit_btn = By.id("submit");
	By login_btn =By.xpath("//input[@type='submit']");
	By impersonateArrowIcon = By.id("arrow");
	By impersonateBox = By.xpath("//input[@placeholder='User Id']");
	By impersonateSwitch = By.xpath("//input[@value='Switch']");
	By impersonation_designation = By.xpath("//span[@class='mat-caption']");
	//By expenseManagementModuleTail = By.xpath("//a[@href='/muExpense']");
	By expenseManagementModuleTail = By.xpath("//h3[contains(text(),'muExpense')]");
	By addbill_btn = By.xpath("//span[text()=' Add Bill ']");
	By billname_inputfield = By.xpath("//input[@placeholder='Bill Name']");
	By billnumber_inputfield = By.xpath("//input[@placeholder='Bill Number']");
	By category_dropdown = By.xpath("//div[@class='mat-select-value']//span[contains(text(),'Category')]");
	By subcategory_dropdown = By.xpath("//div[@class='mat-select-value']//span[contains(text(),'Sub Category')]");
	By billamount_inputfield = By.xpath("//input[@placeholder='Bill Amount']");
	By comment_inputfield = By.xpath("//input[@placeholder='Comment (Optional)']");
	By choosefile_btn = By.xpath("//input[@type='file']");
	By addbillFormView_text = By.xpath("//div[@class='card']//span[contains(text(),'Add Bill')]");
	By anydropdown_selectValue = By.xpath("//div[@class='mat-select-content ng-trigger ng-trigger-fadeInContent']");
	By save_button = By.xpath("//span[@class='mat-button-wrapper' and contains(text(),'Save Bill')]");
	By successMessage_anyBillAction = By.xpath("//div[@class='cdk-visually-hidden' and contains(text(),'Bill')]");
	By successMessage_anyClaimAction = By.xpath("//div[@class='cdk-visually-hidden' and contains(text(),'Claim')]");
	By errorMessage_oneEmployeeSelection = By.xpath("//div[@class='cdk-visually-hidden' and contains(text(),'Only one')]");
	By dateFrom = By.xpath("//input[@placeholder='Date From']");
	By selectMonthDateCalendarBodyParentElement=By.xpath("//div[@class='mat-calendar-content']//table[@class='mat-calendar-table']/tbody");
	By dateTo = By.xpath("//input[@placeholder='Date To']");
	By makeAClaimBtn = By.xpath("//span[contains(text(),'Make a claim')]");
	By claimPopUp = By.xpath("//div[@class='cdk-overlay-pane']");
	By exceedableClaimPopUp = By.xpath("//div[@class='cdk-overlay-pane']//h1[contains(text(),'Exceeding claimable amount')]");
	By claimName_inputfield = By.xpath("//input[@placeholder='Claim Name']");
	By submitClaim_btn = By.xpath("//span[@class='mat-button-wrapper' and contains(text(),'Submit Claim')]");
	By country_dropdown = By.xpath("//div[@class='mat-select-value']//span[contains(text(),'Country')]");
	By city_dropdown = By.xpath("//div[@class='mat-select-value']//span[contains(text(),'City')]");
	By proceed_btn = By.xpath("//span[@class='mat-button-wrapper'and contains(text(),'Proceed')]");
	By arrow_previousmonth=By.xpath("//button[@aria-label='Previous month']");
	By valuecheck = By.xpath("//div[@class='response-details-2']//div[@class='ng-star-inserted']");
	By approvedAmountValueCheck = By.xpath("//div[@class='response-details-2']//div[@class='ng-star-inserted']//div[2]");
	By monthFromCalender = By.xpath("//div[@class='mat-calendar-controls']//button[@class='mat-calendar-period-button mat-button']//span");
	By datepicker = By.xpath("//input[@placeholder='Date']");
	//By location_dropdown=By.xpath("//div[@class='mat-select-value']//span[contains(text(),'Location')]");
	By location_dropdown=By.xpath("//div[@class='mat-select-trigger']//div[@class='mat-select-arrow']");
	By clickOnResumeToImpersonate=By.xpath("//div[@id='header-login-pop1' and contains(text(),'Resume')]");
	By invalidEmployeesListPopUp=By.xpath("//div[@class='cdk-overlay-pane']//h1[contains(text(),'Invalid Employees List')]");
	By invalidEmployees=By.xpath("//div[@class='response-details-2']//div[@class='ng-star-inserted']");
	By ok_btn=By.xpath("//span[@class='mat-button-wrapper'and contains(text(),' Ok')]");
	By OK_button=By.xpath("//span[@class='mat-button-wrapper'and contains(text(),'Ok')]");
	By AddMember = By.id("empSearch");
	By AddMemberPopUp = By.xpath("//div[@id='mat-autocomplete-0']");
	
	
	/**
	 * Method to initiate the driver
	 * 
	 * @param driver
	 */
	public ExpenseManagement_page(WebDriver driver) {
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
		AddBill_pageLog.info("Filled the Username");
		driver.findElement(password_inputBox).sendKeys(password);
		AddBill_pageLog.info("Filled the Password");
		//driver.findElement(submit_btn).click();
		driver.findElement(login_btn).click();
		AddBill_pageLog.info("Clicked on the Submit button");
	}
	
	

	/**
	 * Method to impersonate as Onsite Employee
	 * 
	 * @param impersonateEmployeeName
	 */

	public void impersonateEmployee(String impersonateEmployeeName) {
		clickWhenElementIsReady(driver, 3, impersonateArrowIcon);
		driver.findElement(impersonateBox).sendKeys(impersonateEmployeeName);
		driver.findElement(impersonateSwitch).click();
		clickWhenElementIsReady(driver, 5, expenseManagementModuleTail);
		switchWindow(1);
		AddBill_pageLog.info("Impersonation successful");
	}
	
	
	
	/**
	 * Method to impersonate after logged into the application
	 * @param impersonateEmployeeName
	 * @throws Exception
	 */
	
	public void impersonate(String impersonateEmployeeName) throws Exception{
		switchWindow(0);
		clickWhenElementIsReady(driver, 3, impersonateArrowIcon);
		clickWhenElementIsReady(driver, 3, clickOnResumeToImpersonate);
		clickWhenElementIsReady(driver, 3, impersonateArrowIcon);
		Thread.sleep(2000);
		driver.findElement(impersonateBox).sendKeys(impersonateEmployeeName);
		driver.findElement(impersonateSwitch).click();
		switchWindow(1);
		Thread.sleep(2000);
		driver.navigate().refresh();
	}
	
	

	/**
	 * Method to return designation text shown on UI on impersonation
	 * 
	 * @return
	 */

	public String getDesignation_text() {
		waitForElement(impersonation_designation, 10);
		return driver.findElement(impersonation_designation).getText();
	}
	

	/**
	 * Method to click on Add Bill button
	 */
	public void clickOnaddBill() {
		clickWhenElementIsReady(driver, 3, addbill_btn);
		AddBill_pageLog.info("Add Bill button clicked successfully");
	}
	
	
	/**
	 * Method to select any value from any dropdown field 
	 * @param optionName
	 * @throws Exception
	 */
	public void selectValueFromAnyDropDown(String optionName) throws Exception{
		Thread.sleep(3000);
		WebElement element=driver.findElement(By.xpath("//span[@class='mat-option-text' and contains(text(),'"+optionName+"')]"));
		waitForElement(element, 20);
		element.click();
	}
	
	/**
	 * Method to enter telephone bill details 
	 * @param billname
	 * @param billnumber
	 * @param category
	 * @param subcategory
	 * @param DateFrom
	 * @param DateTo
	 * @param billamount
	 * @param folderName
	 * @param fileName
	 * @throws Exception
	 */

	public void enterTelephoneBillDetails(String billname, String billnumber, String category,String subcategory,String DateFrom,String DateTo,
			String billamount,String folderName,String fileName,String monthyearfromdate,String monthyeartodate)
			throws Exception {
		Thread.sleep(3000);
		if (driver.findElement(addbillFormView_text).isDisplayed()) {
			waitForElement(billname_inputfield, 10);
			driver.findElement(billname_inputfield).sendKeys(billname);
			waitForElement(billnumber_inputfield, 10);
			driver.findElement(billnumber_inputfield).sendKeys(billnumber);
			waitForElement(category_dropdown, 10);			
			driver.findElement(category_dropdown).click();
			selectValueFromAnyDropDown(category);
			waitForElement(subcategory_dropdown, 10);
			driver.findElement(subcategory_dropdown).click();
			selectValueFromAnyDropDown(subcategory);
			driver.findElement(dateFrom).click();
			Thread.sleep(3000);
			selectDate(DateFrom,monthyearfromdate);
			Thread.sleep(3000);
			driver.findElement(dateTo).click();
			Thread.sleep(3000);
			selectDate(DateTo,monthyeartodate);
			waitForElement(billamount_inputfield, 10);
			driver.findElement(billamount_inputfield).sendKeys(billamount);
			uploadFile(folderName, fileName, choosefile_btn);
			Thread.sleep(1000);
		} else {
			AddBill_pageLog.info("Unable to view Add Bill Form");}
	}
	
	
	/**
	 * Method to enter the location type for tax entity changes 
	 * @param locationtype
	 * @throws Exception
	 */
	public void selectTaxEntity(String locationtype) throws Exception{
		waitForElement(location_dropdown, 10);
		driver.findElement(location_dropdown).click();
		Thread.sleep(3000);
		WebElement element=driver.findElement(By.xpath("//span[@class='mat-option-text']//span[contains(text(),'"+locationtype+"')]"));
		waitForElement(element, 20);
		element.click();
	}
	
	
	/**
	 * Method to click on Save Button to save draft bill
	 * @throws Exception 
	 * @throws Exception 
	 */
	public void clickSaveButton() throws Exception{
		clickWhenElementIsReady(driver, 10, save_button);
		Thread.sleep(3000);
		AddBill_pageLog.info("clicked on save button");
	}
	
	
	
	/**
	 * Method to click on Save button with exceedable claimable amount validation to save draft bill
	 * @param eligibleAmount
	 * @throws Exception
	 */
	public void clickSaveButtonWithValidation(String eligibleAmount) throws Exception{
		clickWhenElementIsReady(driver, 10, save_button);
		Thread.sleep(3000);
		if(driver.findElement(exceedableClaimPopUp).isDisplayed()){
			String text = driver.findElement(valuecheck).getText();
			System.out.println("text is"+text);
			Thread.sleep(1000);
			if(text.trim().equalsIgnoreCase(eligibleAmount)){
				driver.findElement(proceed_btn).click();
			}
			Thread.sleep(2000);
		}
	}
	
	
	/**
	 * Method for invalidEmployeeList pop up validation
	 * @param invalidemployeelist
	 * @throws Exception
	 */
	public void invalidEmployeeListPopUp(String invalidemployeelist) throws Exception{
		if(driver.findElement(invalidEmployeesListPopUp).isDisplayed()){
			String employeeList=driver.findElement(invalidEmployees).getText();
			System.out.println("invalid employee list"+employeeList);
			Thread.sleep(1000);
			if(employeeList.trim().equalsIgnoreCase(invalidemployeelist)){
				Thread.sleep(1000);
				driver.findElement(ok_btn).click();
			}
			Thread.sleep(4000);
		}
	}
	
	
	/**
	 * Method to return the success message text for any action on bill 
	 * @return
	 */
	public String successMessage_anyBillAction_text() {
		waitForElement(successMessage_anyBillAction, 15);
		return driver.findElement(successMessage_anyBillAction).getText();
	}
	
	
	/**
	 * Method to return the success message text for any action on claim
	 * @return
	 */
	public String successMessage_anyClaimAction_text(){
		waitForElement(successMessage_anyClaimAction, 15);
		return driver.findElement(successMessage_anyClaimAction).getText();
	}
	
	/**
	 * Method to return the error message text for only one employee can be selected for claim
	 * @return
	 */
	public String errorMessage_oneEmployee_text(){
		waitForElement(errorMessage_oneEmployeeSelection, 15);
		return driver.findElement(errorMessage_oneEmployeeSelection).getText();
	}
	
	
	/**
	 * Method to select specific date from specific month and year 
	 * @param Date
	 * @param MonthYear
	 * @throws Exception
	 */
	public void selectDate(String Date,String MonthYear) throws Exception{
		Thread.sleep(2000);
		while(driver.findElement(monthFromCalender).getText().equalsIgnoreCase(MonthYear)==false)
		{	
			Thread.sleep(1000);
			Actions action = new Actions(driver);	
			action.moveToElement(driver.findElement(arrow_previousmonth)).click(driver.findElement(arrow_previousmonth)).build().perform();
		}
		
		 Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
		 int todayInt = calendar.get(Calendar.DAY_OF_MONTH);
	     String todayStr = Integer.toString(todayInt);
	        if(todayStr.equalsIgnoreCase(Date)==true){
	        	Thread.sleep(2000);
	        	WebElement date = driver.findElement(
	    				By.xpath("//div[@class='mat-calendar-body-cell-content mat-calendar-body-selected mat-calendar-body-today' and contains(text(),'" + Date + "')]"));
	    		date.click(); 	
	        }else{
	        	Thread.sleep(1000);
	        	WebElement date = driver.findElement(
	    				By.xpath("//div[@class='mat-calendar-body-cell-content' and contains(text(),'" + Date + "')]"));
	    		date.click();
	        }
		}
	
	
	/**
	 * Method to click on OK button 
	 */
	public void clickOKbutton(){
		waitForElement(OK_button, 3);
		driver.findElement(OK_button).click();
	}
	
	
	/**
	 * Method to select specific bill based on the bill number 
	 * @param billnumber
	 * @throws Exception
	 */
	public void selectBill(String billnumber) throws Exception{
		Thread.sleep(2000);
		//select 100 dollar designations
		//WebElement element = driver.findElement(By.xpath("(//span[@class='mat-body-1' and contains(text(),'"+billnumber+"')][2])/ancestor::a//label/div"));
		//select 50 dollar designations
		WebElement element = driver.findElement(By.xpath("//span[@class='mat-body-1' and contains(text(),'"+billnumber+"')]/ancestor::a//label/div"));
		clickWhenElementIsReady(driver, 3, element);
		Thread.sleep(2000);
	}
	
	
	/**
	 * Method to select any radio button based on the text of specific radio button
	 * @param radiobuttonOption
	 * @throws Exception
	 */
	public void selectRadiobutton(String radiobuttonOption) throws Exception{
		Thread.sleep(1000);
		WebElement element = driver.findElement(By.xpath("//div[@class='mat-radio-label-content' and contains(text(),'"+radiobuttonOption+"')]/ancestor::label/div[@class='mat-radio-container']"));
		clickWhenElementIsReady(driver, 2, element);
		Thread.sleep(2000);
	}
	
	
	/**
	 * Method to remove any specific employee from the bill form 
	 * @param memberName
	 * @throws Exception
	 */
	public void removeMember(String memberName) throws Exception{
		Thread.sleep(2000);
		WebElement element=driver.findElement(By.xpath("//div[@class='mat-chip-list-wrapper']//mat-chip[contains(text(),'"+memberName+"')]//mat-icon[@class='mat-chip-remove mat-icon material-icons ng-star-inserted']"));
		clickWhenElementIsReady(driver, 2, element);
		Thread.sleep(3000);
	}
	
	/**
	 * Method to add any employee for required bill
	 * @param addmemberName
	 * @throws Exception
	 */
	public void addMember(String addmemberName) throws Exception{
		waitForElement(AddMember, 5);
		driver.findElement(AddMember).sendKeys(addmemberName);
		Thread.sleep(3000);
		selectValueFromAnyDropDown(addmemberName);
	}
	
	
	/**
	 * Method to click on Make a Claim button 
	 */
	public void clickOnMakeAClaimButton(){
		clickWhenElementIsReady(driver, 2, makeAClaimBtn);
	}
	
	
	/**
	 * Method to enter claim name to make a claim
	 * @param claimName
	 * @throws Exception
	 */
	public void makeAClaim(String claimName) throws Exception{
		Thread.sleep(3000);
		if (driver.findElement(claimPopUp).isDisplayed()){
			waitForElement(claimName_inputfield, 2);
			driver.findElement(claimName_inputfield).sendKeys(claimName);
			clickWhenElementIsReady(driver, 10, submitClaim_btn);
			Thread.sleep(3000);
			}
		
	}
	
	
	/**
	 * Method to enter claim name with exceedable claimable amount pop up to make a claim
	 * @param claimName
	 * @param empClaimDetails
	 * @throws Exception
	 */
	public void makeAClaimWithValidation(String claimName,String empClaimDetails) throws Exception{
		Thread.sleep(3000);
		if (driver.findElement(claimPopUp).isDisplayed()){
			waitForElement(claimName_inputfield, 2);
			driver.findElement(claimName_inputfield).sendKeys(claimName);
			clickWhenElementIsReady(driver, 10, submitClaim_btn);
			Thread.sleep(3000);
			if(driver.findElement(exceedableClaimPopUp).isDisplayed())
			{
				String employeeDetails = driver.findElement(approvedAmountValueCheck).getText().replaceAll("\n", " ");
				System.out.println("required details"+employeeDetails);
				Thread.sleep(2000);
				if(employeeDetails.trim().equalsIgnoreCase(empClaimDetails)){
					//System.out.println("hurray");
					driver.findElement(proceed_btn).click();
				}
			}	
			Thread.sleep(1000);
		}
		
		else{
			AddBill_pageLog.info("Unable to find claim pop up");
		}
	}
	
}
