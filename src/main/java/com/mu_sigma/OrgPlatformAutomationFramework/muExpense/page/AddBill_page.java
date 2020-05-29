package com.mu_sigma.OrgPlatformAutomationFramework.muExpense.page;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;

public class AddBill_page extends TestBase {
	WebDriver driver;
	private static final Logger AddBill_pageLog = LogManager
			.getLogger(AddBill_page.class.getName());

	By username_inputBox = By.id("username");
	By password_inputBox = By.id("password");
	By submit_btn = By.id("submit");
	By impersonateArrowIcon = By.id("arrow");
	By impersonateBox = By.xpath("//input[@placeholder='User Id']");
	By impersonateSwitch = By.xpath("//input[@value='Switch']");
	By impersonation_designation = By.xpath("//span[@class='mat-caption']");
	By expenseManagementModuleTail = By.xpath("//a[@href='/muExpense']");
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
	By successMessage_anyAction = By.xpath("//div[@class='cdk-visually-hidden' and contains(text(),'Bill')]");
	By dateFrom = By.xpath("//input[@placeholder='Date From']");
	By selectMonthDateCalendarBodyParentElement=By.xpath("//div[@class='mat-calendar-content']//table[@class='mat-calendar-table']");
	By dateTo = By.xpath("//input[@placeholder='Date To']");
	By radioButtons = By.xpath("//div[@class='mat-radio-outer-circle']");
	By AddMember = By.id("empSearch");
	By AddMemberPopUp = By.xpath("//div[@id='mat-autocomplete-0']");
	By country_dropdown = By.xpath("//div[@class='mat-select-value']//span[contains(text(),'Country')]");
	By city_dropdown = By.xpath("//div[@class='mat-select-value']//span[contains(text(),'City')]");
	By checkbox = By.xpath("//div[@class='mat-checkbox-inner-container']");
		
	
	
	/**
	 * Method to initiate the driver
	 * 
	 * @param driver
	 */
	public AddBill_page(WebDriver driver) {
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
		driver.findElement(submit_btn).click();
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
	public void addBill() {
		clickWhenElementIsReady(driver, 3, addbill_btn);
		AddBill_pageLog.info("Add Bill button clicked successfully");
	}

	/**
	 * Method to select any value on click of dropdown
	 * 
	 * @param dropdownoption
	 * @throws Exception 
	 * @throws Exception
	 */

	/*public void selectValueFromAnyDropdown(String dropdownoption) throws Exception {
		//Thread.sleep(3000);
		waitForElement(anydropdown_selectValue, 5);
		List<WebElement> childElement = driver.findElement(anydropdown_selectValue).findElements(By.tagName("span"));
		for (WebElement values : childElement) {
			if (values.getText().equals(dropdownoption)) {
				//JavascriptExecutor js = (JavascriptExecutor) driver;
				//js.executeScript("arguments[0].scrollIntoView();", values);
				values.click();
				break;
			} else {
				AddBill_pageLog.info("Unable to select value from the dropdown");
			}
		}
	}*/
	
	public void selectValueFromAnyDropDown(String optionName) throws Exception{
		Thread.sleep(3000);
		WebElement element=driver.findElement(By.xpath("//span[@class='mat-option-text' and contains(text(),'"+optionName+"')]"));
		waitForElement(element, 20);
		element.click();
	}
	
	/**
	 * Method to enter bill details 
	 * @param billname
	 * @param billnumber
	 * @param category
	 * @param billamount
	 * @param folderName
	 * @param fileName
	 * @throws Exception
	 */

	public void enterBillDetails(String billname, String billnumber, String category, String billamount,String folderName,String fileName)
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
			waitForElement(billamount_inputfield, 10);
			driver.findElement(billamount_inputfield).sendKeys(billamount);
			uploadFile(folderName, fileName, choosefile_btn);
			Thread.sleep(1000);
		} else {
			AddBill_pageLog.info("Unable to view Add Bill Form");}
	}
	
	public void enterTelephoneBillDetails(String subcategory,String DateFrom,String DateTo) throws Exception
	{
		waitForElement(subcategory_dropdown, 10);
		driver.findElement(subcategory_dropdown).click();
		selectValueFromAnyDropDown(subcategory);
		driver.findElement(dateFrom).click();
		selectMonthDateCalendarBody(DateFrom);
		driver.findElement(dateTo).click();
		selectMonthDateCalendarBody(DateTo);
		
	}
	
	public void enterQuarterlyTeamOutingBillDetails(String addmember) throws Exception{
		waitForElement(AddMember, 5);
		driver.findElement(AddMember).click();
		
		List<WebElement> childElement = driver.findElement(AddMemberPopUp).findElements(By.tagName("span"));
		for (WebElement values : childElement) {
			if (values.getText().equals(addmember)) {
				values.click();
				break;
			} else {
				AddBill_pageLog.info("Unable to select value from the dropdown");
			}
		}
	}
	
	public void enterRelocationBillDetails(String subcategory,String country,String city,String DateFrom,String DateTo) throws Exception{
		waitForElement(subcategory_dropdown, 10);
		driver.findElement(subcategory_dropdown).click();
		selectValueFromAnyDropDown(subcategory);
		waitForElement(country_dropdown, 10);
		driver.findElement(country_dropdown).click();
		selectValueFromAnyDropDown(country);
		waitForElement(city_dropdown, 10);
		driver.findElement(city_dropdown).click();
		selectValueFromAnyDropDown(city);
		driver.findElement(dateFrom).click();
		selectMonthDateCalendarBody(DateFrom);
		driver.findElement(dateTo).click();
		selectMonthDateCalendarBody(DateTo);
		
	}
	
	/**
	 * Method to click on Save Button to save draft bill
	 */
	
	public void clickSaveButton(){
		clickWhenElementIsReady(driver, 10, save_button);
		AddBill_pageLog.info("clicked on save button");
	}
	
	/**
	 * Method to return the success message text for any action on bill 
	 * @return
	 */
	public String successMessage_anyAction_text() {
		waitForElement(successMessage_anyAction, 15);
		return driver.findElement(successMessage_anyAction).getText();
	}
	
	/**
	 * This method is used to Select the date
	 * 
	 * @param monthName
	 */
	public void selectMonthDateCalendarBody(String date) {
		try {
			waitForElement(selectMonthDateCalendarBodyParentElement, 10);
			WebElement ele = driver.findElement(selectMonthDateCalendarBodyParentElement);
			List<WebElement> childElement = ele.findElements(By.tagName("td"));
			/**
			 * This method is used to select the date from calendar body
			 */
			for (WebElement values : childElement) {
				if (values.getText().equals(date)) {
					values.click();
					//CommonElement_pageLog.info("Selected the date as "+date);
					break;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//CommonElement_pageLog.info("Application unable to select the date");
		}
	}
	
	public void selectRadioButton(int buttonNo) throws Exception{
		waitForElement(radioButtons, 10);
		List<WebElement> elements = driver.findElements(radioButtons);
		for(int i=0;i<elements.size();i++){
			if(i==(buttonNo-1)){
				System.out.println("element name---------------------------------->"+elements.get(i));
				elements.get(i).click();
				Thread.sleep(3000);
				break;
			}
		}
		
	}
	
	public void selectCheckBox(int checkboxNo){
		List<WebElement> checkboxes = driver.findElements(checkbox);
		for(int i=0;i<checkboxes.size();i++){
			if(i==checkboxNo){
				checkboxes.get(i).click();
				break;
			}
		}
	}

	

}