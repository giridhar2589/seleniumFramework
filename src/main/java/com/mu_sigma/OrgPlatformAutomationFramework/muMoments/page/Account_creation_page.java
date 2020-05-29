package com.mu_sigma.OrgPlatformAutomationFramework.muMoments.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;

public class Account_creation_page extends TestBase {

	WebDriver driver;
	private static final Logger accountCreation_pageLog = LogManager.getLogger(Account_creation_page.class.getName());

	By account_Tab_Selection = By.xpath("//a[contains(text(),'Accounts')]"); // xpath
																				// for
																				// account
																				// tab
																				// selection

	// By account_PlusIcon_Selection=By.xpath(
	// "//li[@class='df-sub-menu-icon-item ng-scope']//a");//xpath for new
	// account create button
	By account_PlusIcon_Selection = By.xpath("//span[@tooltip='Create Account']");// xpath
																					// for
																					// new
																					// account
																					// create
																					// button

	By account_Name_selection = By.xpath("//input[@ng-model='account.name']"); // xpath
																				// for
																				// pointer
																				// selects
																				// the
																				// text
																				// box
																				// for
																				// entering
																				// Account
																				// name
	// By account_Name_selection=By.xpath("//input[@class='form-control
	// ng-pristine ng-invalid ng-invalid-required']"); //xpath for pointer
	// selects the text box for entering Account name

	By account_Name_Deletion = By.xpath("//input[@ng-model='account.name']"); // xpath
																				// for
																				// deleting
																				// the
																				// entering
																				// text

	By account_Currency_Dropdown = By.xpath("(//a[@class='chosen-single chosen-default'])[5]"); // xpath
																								// and
																								// element
																								// for
																								// currency
																								// drop
																								// down

	By account_Currency_selection = By.xpath("//li[contains(text(),'USD')]"); // xpath
																				// and
																				// element
																				// for
																				// currency
																				// selection
																				// (USD)

	By account_NextBtn_press1 = By.xpath("//button[@class='btn df-btn-primary ng-scope']"); // xpath
																							// and
																							// element
																							// for
																							// pressing
																							// the
																							// 'Next'
																							// button

	By account_Country_DropDown = By.xpath("(//a[@class='chosen-single chosen-default'])[9]"); // xpath
																								// and
																								// element
																								// for
																								// selecting
																								// country
																								// drodown

	By account_Country_selection = By.xpath("//li[contains(text(),'ARGENTINA')]"); // xpath
																					// and
																					// element
																					// for
																					// selecting
																					// country
																					// (Argentina)

	By account_NextBtn_press2 = By.xpath("//button[contains(text(),'Next')]"); // xpath
																				// and
																				// element
																				// for
																				// next
																				// button
																				// 2

	By account_NextBtn_press3 = By.xpath("//button[contains(text(),'Next')]"); // xpath
																				// and
																				// element
																				// for
																				// next
																				// button
																				// 3

	By account_CreateBtn_press = By.xpath("//button[contains(text(),'Create')]"); // xpath
																					// and
																					// element
																					// for
																					// create
																					// button

	By validation_message = By.xpath(
			"//div[@class='df-alerts ng-pristine ng-untouched ng-valid ng-scope ng-isolate-scope alert alert-danger' and contains(text(),'validation errors')]");

	By previous_button = By.xpath("//button[@ng-click='accWizard.previous(false)']");

	By saveNCloseBtn = By.xpath("//button[contains(text(),'Save & Close')]");
	
	By savedAccountName = By.xpath("(//span[@class='ng-binding'])[1]");

	public Account_creation_page(WebDriver driver) {
		this.driver = driver;
	}

	public String errorMessage_Validation() {
		waitForElement(validation_message, 15);
		return driver.findElement(validation_message).getText();
	}
	
	public String accountNameValidationAfterSave() {
		waitForElement(savedAccountName, 15);
		return driver.findElement(savedAccountName).getText();
	}

	/**
	 * This will click on Accounts tab after Logging in
	 */
	public void clickOnAccountsTab() {
		clickWhenElementIsReady(driver, 20, account_Tab_Selection);
		try {
			{
				accountCreation_pageLog.info("Element Located for SELECTING ACCOUNT TAB");
			}
		} catch (Exception e) {
			accountCreation_pageLog.info("Not able to locate the Accounts tab");
		}
	}

	/**
	 * Click on Create button
	 * 
	 * @throws InterruptedException
	 */
	public void clickOnPlusIcon() throws InterruptedException {
		clickWhenElementIsReady(driver, 100, account_PlusIcon_Selection);
		try {

			accountCreation_pageLog.info("Application located the element CLICKED ON ACCOUNT CREATION");
		} catch (Exception e) {
			accountCreation_pageLog.info("Application unable to locate the element for plus icon");
		}
	}

	/**
	 * Fills out the account name
	 */
	public void enterAccountName(String accName) {
		driver.findElement(account_Name_selection).sendKeys(accName);
		try {
			accountCreation_pageLog.info("Element has been found to PROVIDE ACCOUNT NAME");
		} catch (Exception e) {
			accountCreation_pageLog.info("Not able to find the text box for entering account name");
		}
	}

	public void deleteAccountName() {
		driver.findElement(account_Name_Deletion).clear();
		try {
			accountCreation_pageLog.info("Element found for deleting the Account Name");
		} catch (Exception e) {
			accountCreation_pageLog.info("Not able to locate element for deleting the name");
		}
	}

	/**
	 * Select the currency field
	 */
	public void accountCurrencyFieldDropDown() {
		clickWhenElementIsReady(driver, 20, account_Currency_Dropdown);
		try {
			accountCreation_pageLog.info("Element located for clicking on Currency DropDown");
		} catch (Exception e) {
			accountCreation_pageLog.info("not able to select the currency drop down");
		}
	}

	/**
	 * Selection of country
	 */
	public void accountCurrencySelection() {
		clickWhenElementIsReady(driver, 20, account_Currency_selection);
		try {
			accountCreation_pageLog.info("Clicking on element to select the currency");
		} catch (Exception e) {
			accountCreation_pageLog.info("Unable to select the currency");
		}
	}

	/**
	 * next press
	 */
	public void accountNextButtonPress1() {
		clickWhenElementIsReady(driver, 20, account_NextBtn_press1);
		try {
			accountCreation_pageLog.info("Element located for Next button Press on the 1st screen");
		} catch (Exception e) {
			accountCreation_pageLog.info("Unable to click on 1st page Next button");
		}
	}

	/**
	 * country dropdown
	 */
	public void accountCountryDropDown() {
		clickWhenElementIsReady(driver, 20, account_Country_DropDown);
		try {
			accountCreation_pageLog.info("Element located for Country Drop Down click");
		} catch (Exception e) {
			accountCreation_pageLog.info("Unable to click on on account country dropdown");
		}
	}

	/**
	 * Country selection
	 */
	public void accountCountrySelection() {
		clickWhenElementIsReady(driver, 20, account_Country_selection);
		try {
			// WebElement
			// element=driver.findElement(By.xpath("//li[contains(text(),'"+countryName+"')]"));
			// clickWhenElementIsReady(driver, 19, element);
			accountCreation_pageLog.info("Selected country as");
		} catch (Exception e) {
			accountCreation_pageLog.info("Unable to Select country as");
		}
	}

	/**
	 * pressing the next button
	 */
	public void accountNextButtonPress2() {
		clickWhenElementIsReady(driver, 20, account_NextBtn_press2);
		try {

			accountCreation_pageLog.info("Element located for Next Button press 2");
		} catch (Exception e) {
			accountCreation_pageLog.info("Failed to locate Next button 2");
		}

	}

	/**
	 * pressing the next button2
	 */
	public void accountNextButtonPress3() {
		clickWhenElementIsReady(driver, 20, account_NextBtn_press3);
		try {
			accountCreation_pageLog.info("Element Located for Next Button press 3");
		} catch (Exception e) {
			accountCreation_pageLog.info("Failed to located the element for Next Button 3");
		}
	}

	/**
	 * pressing create button 3
	 */
	public void accountCreateButtonPress() {
		clickWhenElementIsReady(driver, 20, account_CreateBtn_press);
		try {
			accountCreation_pageLog.info("Element located for Create button");
		} catch (Exception e) {
			accountCreation_pageLog.info("Failed to locate element for Account Create Button");
		}
	}

	public void saveNCloseButtonPress() {
		clickWhenElementIsReady(driver, 20, saveNCloseBtn);
		try {
			accountCreation_pageLog.info("Element Located for save and close button");
		} catch (Exception e) {
			accountCreation_pageLog.info("Not able to locate the element for save and close button");
		}
	}

	public void previousButtonPress() {
		clickWhenElementIsReady(driver, 20, previous_button);
	}

}
