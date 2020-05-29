package com.mu_sigma.OrgPlatformAutomationFramework.muMoments.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;

import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;
public class Engagement_Status_Mandatory extends TestBase {

	private static final Logger Engagement_Status_Mandatory_pageLog = LogManager
			.getLogger(Engagement_Status_Mandatory.class.getName());

	WebDriver driver;

	By engTabSelectionStatusMandatory=By.xpath("//a[contains(text(),'Engagement')]");

	// xpath for engagement plus icon
	By engPlusIconStatusMandatory=By.xpath("(//span[@class='glyphicon glyphicon-plus-sign ng-scope'])[1]");

	// xpath for engagement name
	By engNameStatusMandatory=By.xpath("(//input[@class='form-control ng-pristine ng-invalid ng-invalid-required'])[1]");

	// xpath for engagement start date selection 1
	By engStartDateSelectionStatusMandatory1=By.xpath("//input[@ng-model='deal.startDate']");

	// xpath for engagement start date selection 2
	By engStartDateSelectionStatusMandatory2=By.xpath("(//button[@class='btn btn-default btn-sm'])[31]");

	// xpath for engagement end date selection 1
	By engEndDateSelectionMandatory1=By.xpath("//input[@ng-model='deal.endDate']");

	// xpath for engagement end date selection 2
	By engEndDateSelectionMandatory2=By.xpath("(//button[@class='btn btn-default btn-sm pull-right'])[2]");

	// xpath for engagement end date selection 3
	By engEndDateSelectionMandatory3=By.xpath("(//button[@class='btn btn-default btn-sm pull-right'])[2]");

	// xpath for end date selection 4
	By engEndDateSelectionMandatory4=By.xpath("(//button[@class='btn btn-default btn-sm pull-right'])[2]");

	// xpath for end date selection 5
	By engEndDateSelectionMandatory5=By.xpath("(//button[@class='btn btn-default btn-sm'])[61]");

	// xpath for sub group drop down
	By engSubgroupDropDownStatusMandatory=By.xpath("(//a[@class='chosen-single chosen-default'])[2]");

	// xpath for subgroup selection
	By engSubGroupSelectionStatusMandatory=By.xpath("//li[contains(text(),'Abbott Laboratories | Abbott - Corporate Development')]");

	// xpath for eng billing drop down
	By engBillingDropDownStatusMandatory=By.xpath("(//a[@class='chosen-single chosen-default'])[3]");

	// xpath for engagement billing selection
	By engBillingSelectionStatusMandatory=By.xpath("//li[contains(text(),'Fixed Cost')]");

	// xpath for eng next button
	By engagementNextBtnStatusMandatory=By.xpath("//button[contains(text(),'Next')]");

	// xpath for Cancel button
	By engagementCancelStatusMandatory=By.xpath("//button[@class='btn df-btn-text ng-scope']");

	public Engagement_Status_Mandatory(WebDriver driver) {
		this.driver = driver;
	
	}

	/*
	 * method for engagement tab click
	 */
	public void clickOnEngagementsTabEngStatusMand() {
		clickWhenElementIsReady(driver, 20, engTabSelectionStatusMandatory);
		try {
			Engagement_Status_Mandatory_pageLog.info("Trying to locate the element for engagement tab");
		} catch (Exception e) {
			Engagement_Status_Mandatory_pageLog.info("unable to locate the element for engagement tab");
		}
	}

	/*
	 * Method for engagement create button
	 */
	public void clickOnPlusIconStatusMandatory() {
		clickWhenElementIsReady(driver, 20, engPlusIconStatusMandatory);
		try {
			Engagement_Status_Mandatory_pageLog.info("Trying to locate the element for engagement create button");
		} catch (Exception e) {
			Engagement_Status_Mandatory_pageLog.info("unable to locate the element for engagement create button");
		}
	}

	/*
	 * Method for the engagement name entering
	 */
	public void enterEngagementNameStatusMandatory() {
		driver.findElement(engNameStatusMandatory).sendKeys("Test Engagement with new framework");
		try {
			Engagement_Status_Mandatory_pageLog.info("Trying to locate the element for engagement name entering");
		} catch (Exception e) {
			Engagement_Status_Mandatory_pageLog.info("unable to locate the element for engagement name entering");
		}
	}

	/*
	 * Method for engagement start date selection 1
	 */
	public void engStartDateSelctionStatusMandatory1() {
		clickWhenElementIsReady(driver, 20, engStartDateSelectionStatusMandatory1);
		try {
			Engagement_Status_Mandatory_pageLog
					.info("Trying to locate the element for engagement start date selection 1");
		} catch (Exception e) {
			Engagement_Status_Mandatory_pageLog
					.info("unable to locate the element for engagement start date selection 1");
		}
	}

	/*
	 * method for engagement start date selection 2
	 */
	public void engStartDateSelctionStatusMandatory2() {
		clickWhenElementIsReady(driver, 20, engStartDateSelectionStatusMandatory2);
		try {
			Engagement_Status_Mandatory_pageLog
					.info("Trying to locate the element for engagement start date selection 2");
		} catch (Exception e) {
			Engagement_Status_Mandatory_pageLog
					.info("unable to locate the element for engagement start date selection 2");
		}
	}

	/*
	 * Method for engagement date selection 1
	 */
	public void engEndDateSelectionStatusMandatory1() {
		clickWhenElementIsReady(driver, 20, engEndDateSelectionMandatory1);
		try {
			Engagement_Status_Mandatory_pageLog
					.info("Trying to locate the element for engagement eng date selection 1");
		} catch (Exception e) {
			Engagement_Status_Mandatory_pageLog
					.info("unable to locate the element for engagement end date selection 1");
		}
	}

	/*
	 * Method for eng end date selection 2
	 */
	public void engEndDateSelectionStatusMandatory2() {
		clickWhenElementIsReady(driver, 20, engEndDateSelectionMandatory2);
		try {
			Engagement_Status_Mandatory_pageLog
					.info("Trying to locate the element for engagement eng date selection 2");
		} catch (Exception e) {
			Engagement_Status_Mandatory_pageLog
					.info("unable to locate the element for engagement end date selection 2");
		}
	}

	/*
	 * Method for engagement end date selection 3
	 */
	public void engEndDateSelectionStatusMandarotry3() {
		clickWhenElementIsReady(driver, 20, engEndDateSelectionMandatory3);
		try {
			Engagement_Status_Mandatory_pageLog
					.info("Trying to locate the element for engagement end date selection 3");
		} catch (Exception e) {
			Engagement_Status_Mandatory_pageLog
					.info("unable to locate the element for engagement end date selection 3");
		}
	}

	/*
	 * Method for engagement end date selection 4
	 */
	public void engEndDateSelectionStatusMandatory4() {
		clickWhenElementIsReady(driver, 20, engEndDateSelectionMandatory4);
		try {
			Engagement_Status_Mandatory_pageLog
					.info("Trying to locate the element for engagement end date selection 4");
		} catch (Exception e) {
			Engagement_Status_Mandatory_pageLog
					.info("unable to locate the element for engagement end date selection 4");
		}
	}

	/*
	 * Method for end date selection 5
	 */
	public void engEndDateSelectionStatusMandatory5() {
		clickWhenElementIsReady(driver, 20, engEndDateSelectionMandatory5);
		try {
			Engagement_Status_Mandatory_pageLog
					.info("Trying to locate the element for engagement end date selection 5");
		} catch (Exception e) {
			Engagement_Status_Mandatory_pageLog
					.info("unable to locate the element for engagement end date selection 5");
		}
	}

	/*
	 * Method for engagement subgroup drop down
	 */
	public void engSubGroupDropDownStatusMandatory() {
		clickWhenElementIsReady(driver, 20, engSubgroupDropDownStatusMandatory);
		try {
			Engagement_Status_Mandatory_pageLog.info("Trying to locate the element for engagement subgroup drop down");
		} catch (Exception e) {
			Engagement_Status_Mandatory_pageLog.info("unable to locate the element for engagement subgroup drop down");
		}
	}

	/*
	 * Method for engagement subgroup selection
	 */
	public void engSubGroupSelectionStatusMandatory() {
		clickWhenElementIsReady(driver, 20, engSubGroupSelectionStatusMandatory);
		try {
			Engagement_Status_Mandatory_pageLog.info("Trying to locate the element for engagement subgroup selection");
		} catch (Exception e) {
			Engagement_Status_Mandatory_pageLog.info("unable to locate the element for engagement subgroup selection");
		}
	}

	/*
	 * Method for engagement billing typoe drop down
	 */
	public void engBillingTypeDropDownStatusMandatory() {
		clickWhenElementIsReady(driver, 20, engBillingDropDownStatusMandatory);
		try {
			Engagement_Status_Mandatory_pageLog
					.info("Trying to locate the element for engagement billing type drop down");
		} catch (Exception e) {
			Engagement_Status_Mandatory_pageLog
					.info("unable to locate the element for engagement billing type drop down");
		}
	}

	/*
	 * Method for engagement billing type selection
	 */
	public void engBillingTypeSelectionStatusMandatory() {
		clickWhenElementIsReady(driver, 20, engBillingSelectionStatusMandatory);
		try {
			Engagement_Status_Mandatory_pageLog
					.info("Trying to locate the element for engagement billing type selection");
		} catch (Exception e) {
			Engagement_Status_Mandatory_pageLog
					.info("unable to locate the element for engagement billing type selection");
		}
	}

	/*
	 * Method for engagement next
	 */
	public void engNextBtnStatusMandatory() {
		clickWhenElementIsReady(driver, 20, engagementNextBtnStatusMandatory);
		try {
			Engagement_Status_Mandatory_pageLog.info("Trying to locate the element for engagement save and close");
		} catch (Exception e) {
			Engagement_Status_Mandatory_pageLog.info("unable to locate the element for engagement save and close");
		}
	}

	/*
	 * Method for engagement next
	 */
	public void engCancelBtnStatusMandatory() {
		clickWhenElementIsReady(driver, 20, engagementCancelStatusMandatory);
		try {
			Engagement_Status_Mandatory_pageLog.info("Trying to locate the element for engagement Cancel");
		} catch (Exception e) {
			Engagement_Status_Mandatory_pageLog.info("unable to locate the element for engagement Cancel");
		}
	}

}
