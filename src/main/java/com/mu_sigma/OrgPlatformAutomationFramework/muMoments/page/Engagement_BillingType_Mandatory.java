package com.mu_sigma.OrgPlatformAutomationFramework.muMoments.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;

import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;

public class Engagement_BillingType_Mandatory extends TestBase {

	private static final Logger Engagement_BillingType_Mandatory_pageLog = LogManager
			.getLogger(Engagement_BillingType_Mandatory.class.getName());

	WebDriver driver;

	// xpath for engagement tab selection
	By engTabSelectionBillingTypeMandatory=By.xpath("//a[contains(text(),'Engagement')]");

	// xpath for engagement plus icon
	By engClickOnPlusIconBillingTypeMandatory=By.xpath("(//span[@class='glyphicon glyphicon-plus-sign ng-scope'])[1]");

	// xpath for engagement name
	By engNameBillingTypeMandatory=By.xpath("(//input[@class='form-control ng-pristine ng-invalid ng-invalid-required'])[1]");

	// xpath for status drop down
	By engStatusDropDownBillingTypeMandatory=By.xpath("(//a[@class='chosen-single chosen-default'])[1]");

	// xpath for status selection
	By engStatusSelectionBillingTypeMandatory=By.xpath("//li[contains(text(),'Green')]");

	// xpath for engagement start date selection 1
	By engStartDateBillingTypeManSelection1=By.xpath("//input[@ng-model='deal.startDate']");

	// xpath for engagement start date selection 2
	By engStartDateBillingTypeManSelection2=By.xpath("(//button[@class='btn btn-default btn-sm'])[31]");

	// xpath for engagement end date selection 1
	By engEndDateBillingTypeManSelection1=By.xpath("//input[@ng-model='deal.endDate']");

	// xpath for engagement end date selection 2
	By engEndDateBillingTypeManSelection2=By.xpath("(//button[@class='btn btn-default btn-sm pull-right'])[2]");

	// xpath for engagement end date selection 3
	By engEndDateBillingTypeManSelection3=By.xpath("(//button[@class='btn btn-default btn-sm pull-right'])[2]");

	// xpath for end date selection 4
	By engEndDateBillingTypeManSelection4=By.xpath("(//button[@class='btn btn-default btn-sm pull-right'])[2]");

	// xpath for end date selection 5
	By engEndDateBillingTypeManSelection5=By.xpath("(//button[@class='btn btn-default btn-sm'])[61]");

	// xpath for sub group drop down
	By engSubGroupBillingTypeManDropDownMan=By.xpath("(//a[@class='chosen-single chosen-default'])[2]");

	// xpath for subgroup selection
	By engSubroupBillingTypeManSelection=By.xpath("//li[contains(text(),'Abbott Laboratories | Abbott - Corporate Development')]");

	// xpath for eng next button
	By engagementNextBtnBillingTypeMandatory=By.xpath("//button[contains(text(),'Next')]");

	// xpath for Cancel button
	By engagementCancelBtnBillingTypeMandatory=By.xpath("//button[@class='btn df-btn-text ng-scope']");

	public Engagement_BillingType_Mandatory(WebDriver driver) {
		this.driver = driver;
		
	}

	/*
	 * method for engagement tab click
	 */
	public void clickOnEngagementsTabBillingTypeMan() {
		clickWhenElementIsReady(driver, 20, engTabSelectionBillingTypeMandatory);
		try {
			Engagement_BillingType_Mandatory_pageLog.info("Trying to locate the element for engagement tab");
		} catch (Exception e) {
			Engagement_BillingType_Mandatory_pageLog.info("unable to locate the element for engagement tab");
		}
	}

	/*
	 * Method for engagement create button
	 */
	public void clickOnEngPlusIconBillingTypeMan() {
		clickWhenElementIsReady(driver, 20, engClickOnPlusIconBillingTypeMandatory);
		try {
			Engagement_BillingType_Mandatory_pageLog.info("Trying to locate the element for engagement create button");
		} catch (Exception e) {
			Engagement_BillingType_Mandatory_pageLog.info("unable to locate the element for engagement create button");
		}
	}

	/*
	 * Method for the engagement name entering
	 */
	public void enterTheEngagementNameBillingTypeMan() {
		driver.findElement(engNameBillingTypeMandatory).sendKeys("Test Engagement with new framework");
		try {
			Engagement_BillingType_Mandatory_pageLog.info("Trying to locate the element for engagement name entering");
		} catch (Exception e) {
			Engagement_BillingType_Mandatory_pageLog.info("unable to locate the element for engagement name entering");
		}
	}

	/*
	 * Method for engagement status drop down
	 */
	public void clickOnEngagementStatusDropDownBillingTypeMan() {
		clickWhenElementIsReady(driver, 20, engStatusDropDownBillingTypeMandatory);
		try {
			Engagement_BillingType_Mandatory_pageLog
					.info("Trying to locate the element for engagement status drop down");
		} catch (Exception e) {
			Engagement_BillingType_Mandatory_pageLog
					.info("unable to locate the element for engagement status drop down");
		}
	}

	/*
	 * method for engagement status selection
	 */
	public void selectingEngagementStatusBillingTypeMan() {
		clickWhenElementIsReady(driver, 20, engStatusSelectionBillingTypeMandatory);
		try {
			Engagement_BillingType_Mandatory_pageLog
					.info("Trying to locate the element for engagement status selection");
		} catch (Exception e) {
			Engagement_BillingType_Mandatory_pageLog
					.info("unable to locate the element for engagement status selection");
		}
	}

	/*
	 * Method for engagement start date selection 1
	 */
	public void engStartDateSelctionBillingTypeManSelection1() {
		clickWhenElementIsReady(driver, 20, engStartDateBillingTypeManSelection1);
		try {
			Engagement_BillingType_Mandatory_pageLog
					.info("Trying to locate the element for engagement start date selection 1");
		} catch (Exception e) {
			Engagement_BillingType_Mandatory_pageLog
					.info("unable to locate the element for engagement start date selection 1");
		}
	}

	/*
	 * method for engagement start date selection 2
	 */
	public void engStartDateSelctionBillingTypeManSelection2() {
		clickWhenElementIsReady(driver, 20, engStartDateBillingTypeManSelection2);
		try {
			Engagement_BillingType_Mandatory_pageLog
					.info("Trying to locate the element for engagement start date selection 2");
		} catch (Exception e) {
			Engagement_BillingType_Mandatory_pageLog
					.info("unable to locate the element for engagement start date selection 2");
		}
	}

	/*
	 * Method for engagement date selection 1
	 */
	public void engEndDateSelectionBillingTypeMan1() {
		clickWhenElementIsReady(driver, 20, engEndDateBillingTypeManSelection1);
		try {
			Engagement_BillingType_Mandatory_pageLog
					.info("Trying to locate the element for engagement eng date selection 1");
		} catch (Exception e) {
			Engagement_BillingType_Mandatory_pageLog
					.info("unable to locate the element for engagement end date selection 1");
		}
	}

	/*
	 * Method for eng end date selection 2
	 */
	public void engEndDateSelectionBillingTypeMan2() {
		clickWhenElementIsReady(driver, 20, engEndDateBillingTypeManSelection2);
		try {
			Engagement_BillingType_Mandatory_pageLog
					.info("Trying to locate the element for engagement eng date selection 2");
		} catch (Exception e) {
			Engagement_BillingType_Mandatory_pageLog
					.info("unable to locate the element for engagement end date selection 2");
		}
	}

	/*
	 * Method for engagement end date selection 3
	 */
	public void engEndDateSelectionBillingTypeMan3() {
		clickWhenElementIsReady(driver, 20, engEndDateBillingTypeManSelection3);
		try {
			Engagement_BillingType_Mandatory_pageLog
					.info("Trying to locate the element for engagement end date selection 3");
		} catch (Exception e) {
			Engagement_BillingType_Mandatory_pageLog
					.info("unable to locate the element for engagement end date selection 3");
		}
	}

	/*
	 * Method for engagement end date selection 4
	 */
	public void engEndDateSelectionBillingTypeMan4() {
		clickWhenElementIsReady(driver, 20, engEndDateBillingTypeManSelection4);
		try {
			Engagement_BillingType_Mandatory_pageLog
					.info("Trying to locate the element for engagement end date selection 4");
		} catch (Exception e) {
			Engagement_BillingType_Mandatory_pageLog
					.info("unable to locate the element for engagement end date selection 4");
		}
	}

	/*
	 * Method for end date selection 5
	 */
	public void engEndDateSelectionBillingTypeMan5() {
		clickWhenElementIsReady(driver, 20, engEndDateBillingTypeManSelection5);
		try {
			Engagement_BillingType_Mandatory_pageLog
					.info("Trying to locate the element for engagement end date selection 5");
		} catch (Exception e) {
			Engagement_BillingType_Mandatory_pageLog
					.info("unable to locate the element for engagement end date selection 5");
		}
	}

	/*
	 * MEthod for engagement subgroup drop down
	 */
	public void engSubGroupDropDownBillingTypeMan() {
		clickWhenElementIsReady(driver, 20, engSubGroupBillingTypeManDropDownMan);
		try {
			Engagement_BillingType_Mandatory_pageLog
					.info("Trying to locate the element for engagement subgroup drop down");
		} catch (Exception e) {
			Engagement_BillingType_Mandatory_pageLog
					.info("unable to locate the element for engagement subgroup drop down");
		}
	}

	/*
	 * Method for engagement subgroup selection
	 */
	public void engSubGroupSelectionBillingTypeMan() {
		clickWhenElementIsReady(driver, 20, engSubroupBillingTypeManSelection);
		try {
			Engagement_BillingType_Mandatory_pageLog
					.info("Trying to locate the element for engagement subgroup selection");
		} catch (Exception e) {
			Engagement_BillingType_Mandatory_pageLog
					.info("unable to locate the element for engagement subgroup selection");
		}
	}

	/*
	 * Method for engagement save and close
	 */
	public void engNextBtnBillingTypeMan() {
		clickWhenElementIsReady(driver, 20, engagementNextBtnBillingTypeMandatory);
		try {
			Engagement_BillingType_Mandatory_pageLog.info("Trying to locate the element for engagement save and close");
		} catch (Exception e) {
			Engagement_BillingType_Mandatory_pageLog.info("unable to locate the element for engagement save and close");
		}
	}

	/*
	 * Method for engagement save and close
	 */
	public void engCancelBtnBillingTypeMan() {
		clickWhenElementIsReady(driver, 20, engagementCancelBtnBillingTypeMandatory);
		try {
			Engagement_BillingType_Mandatory_pageLog.info("Trying to locate the element for engagement save and close");
		} catch (Exception e) {
			Engagement_BillingType_Mandatory_pageLog.info("unable to locate the element for engagement save and close");
		}
	}
}
