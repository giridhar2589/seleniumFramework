package com.mu_sigma.OrgPlatformAutomationFramework.muMoments.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.PageFactory;

import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;

public class Contact_LasName_Man extends TestBase {

	WebDriver driver;
	private static final Logger Contact_LasName_Man_pageLog = LogManager.getLogger(Contact_LasName_Man.class.getName());

	/*
	 * xpath for contact tab select
	 */
	By contact_Tab_SelectionLastNamMan=By.xpath("//a[contains(text(),'Contacts')]");

	/*
	 * xpath for plus icon click
	 */
	By contact_PlusIconLastNamMan=By.xpath("//span[@tooltip='Create Contact']");

	/*
	 * xpath for contact first name
	 */
	By contact_FirstNameLastNamMan=By.xpath("//input[@ng-model='contact.firstName']");

	/*
	 * xpath for Account Drop Down
	 */
	By contact_AccountDropDownLastNamMan=By.xpath("(//a[@class='chosen-single chosen-default'])[1]");

	/*
	 * xpath for Account Selection
	 */
	By contact_AccountSelectionLastNamMan=By.xpath("//li[contains(text(),'Abbott Laboratories')][1]");

	/*
	 * xpath for Contact Level Drop Down
	 */
	By contact_LevelDropDownLastNamMan=By.xpath("(//a[@class='chosen-single chosen-default'])[2]");

	/*
	 * xpath for Contact level selection
	 */
	By contact_LevelSelectionLastNamMan=By.xpath("//li[contains(text(),'Staff')]");

	/*
	 * xpath for Contact Status Drop Down
	 */
	By contact_StatusDropDownLastNamMan=By.xpath("(//a[@class='chosen-single chosen-default'])[3]");

	/*
	 * xpath for Contact status selection
	 */
	By contact_StatusSelectionLastNamMan=By.xpath("//li[contains(text(),'CHAMPION')]");

	// Click on Next button
	By contact_NextButtonPress1LastNamMan=By.xpath("//button[contains(text(),'Next')]");
	
	//click on Cancel button
	By contact_CancelButtonLastNamMan=By.xpath("//button[@class='btn df-btn-text ng-scope']");
	
	public Contact_LasName_Man(WebDriver driver)
	{
		this.driver=driver;
		
	}

	/*
	 * Method for clicking on contacts tab
	 */
	public void clickOnContactsTabLastNamMan() {
		clickWhenElementIsReady(driver, 20, contact_Tab_SelectionLastNamMan);
		try {
			Contact_LasName_Man_pageLog.info("Trying to locate the element for Contacts tab");

		} catch (Exception e) {
			Contact_LasName_Man_pageLog.info("Unable to locate the element for Contacts tab");
		}

	}
 
	/*
	 * method for clicking on Plus icon
	 */
	public void clickOnPlusbuttonLasNamMan() {
		clickWhenElementIsReady(driver, 20, contact_PlusIconLastNamMan);
		try {
			Contact_LasName_Man_pageLog.info("Trying to locate the element for plus icon");
		} catch (Exception e) {
			Contact_LasName_Man_pageLog.info("Unable to locate the element for plus icon");
		}
	}

	/*
	 * method for clicking on contact first name
	 */
	public void contactFirstNameLastNamMan() {
		driver.findElement(contact_FirstNameLastNamMan).sendKeys("Test");
		try {
			Contact_LasName_Man_pageLog.info("Trying to locate the element for first name entering");
		} catch (Exception e) {
			Contact_LasName_Man_pageLog.info("Unable to locate the element for entering the first name");
		}
	}

	/*
	 * method for clicking on Account Drop down
	 */
	public void contactAccountDropDownLastNamMan() {
		clickWhenElementIsReady(driver, 20, contact_AccountDropDownLastNamMan);
		try {
			Contact_LasName_Man_pageLog.info("trying to locate the element for Account drop down");
		} catch (Exception e) {
			Contact_LasName_Man_pageLog.info("Unable to locate the elment for account drop down");
		}
	}

	/*
	 * method for clicking on Account selection
	 */
	public void contactAccountSelectionLastNamMan() {
		clickWhenElementIsReady(driver, 20, contact_AccountSelectionLastNamMan);
		try {
			Contact_LasName_Man_pageLog.info("Trying to locate the element for Account Selection");
		} catch (Exception e) {
			Contact_LasName_Man_pageLog.info("Unable to locate the element for Account Selection");
		}
	}

	/*
	 * method for clicking on Contact Level Drop down
	 */
	public void contactLevelDropDownLastNamMan() {
		clickWhenElementIsReady(driver, 20, contact_LevelDropDownLastNamMan);
		try {
			Contact_LasName_Man_pageLog.info("Trying to locate the element for Level Drop Down");
		} catch (Exception e) {
			Contact_LasName_Man_pageLog.info("Unable to locate the element for level drop down");
		}
	}

	/*
	 * method for clicking on contact level selection
	 */
	public void contactLevelSelectionLastNamMan() {
		clickWhenElementIsReady(driver, 20, contact_LevelSelectionLastNamMan);
		try {
			Contact_LasName_Man_pageLog.info("Trying to locate the element for Level Selection");
		} catch (Exception e) {
			Contact_LasName_Man_pageLog.info("Unable to locate the element for level selection");
		}
	}

	/*
	 * method for clicking on contact status drop down
	 */
	public void contactStatusDropDownLastNamMan() {
		clickWhenElementIsReady(driver, 20, contact_StatusDropDownLastNamMan);
		try {
			Contact_LasName_Man_pageLog.info("Trying to locate the element for contact status drop down");
		} catch (Exception e) {
			Contact_LasName_Man_pageLog.info("unable to locate the element for contact status drop down");
		}
	}

	/*
	 * method for clicking on Contact Status selection
	 */
	public void contactStatusSelectionLastNamMan() {
		clickWhenElementIsReady(driver, 20, contact_StatusSelectionLastNamMan);
		try {
			Contact_LasName_Man_pageLog.info("Trying to locate the element for status selection");
		} catch (Exception e) {
			Contact_LasName_Man_pageLog.info("Unable to locate the element for status selection");
		}
	}

	/*
	 * method for clickin on Next button
	 */
	public void contactClickOnNextButtonLastNamMan() {
		clickWhenElementIsReady(driver, 20, contact_NextButtonPress1LastNamMan);
		try {
			Contact_LasName_Man_pageLog.info("Trying to locate the element for next button");
		} catch (Exception e) {
			Contact_LasName_Man_pageLog.info("Unable to locate the element for next button");
		}
	}
	
	/*
	 * method for clicking on Next button
	 */
	public void contactClickOnCancelButtonLastNamMan() {
		clickWhenElementIsReady(driver, 20, contact_CancelButtonLastNamMan);
		try {
			Contact_LasName_Man_pageLog.info("Trying to locate the element for next button");
		} catch (Exception e) {
			Contact_LasName_Man_pageLog.info("Unable to locate the element for next button");
		}
	}

}
