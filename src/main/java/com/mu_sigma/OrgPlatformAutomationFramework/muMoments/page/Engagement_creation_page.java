package com.mu_sigma.OrgPlatformAutomationFramework.muMoments.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;

import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;

public class Engagement_creation_page extends TestBase {

	
	private static final Logger Engagement_creation_page_pageLog = LogManager
			.getLogger(Engagement_creation_page.class.getName());

	WebDriver driver;
	// xpath for clickin on Engagement tab
	By engagement_Tab_Selection=By.xpath("//a[contains(text(),'Engagement')]");

	// xpath for engagement create icon
	By engagement_PlusIcon=By.xpath("(//span[@class='glyphicon glyphicon-plus-sign ng-scope'])[1]");

	// xpath for entering engagement name
	By engagement_Name=By.xpath("(//input[@class='form-control ng-pristine ng-invalid ng-invalid-required'])[1]");

	// xpath for engagement status drop down
	By engagement_StatusDropDown=By.xpath("(//a[@class='chosen-single chosen-default'])[1]");

	// xpath for engagement status selection
	By engagement_Status_Selection=By.xpath("//li[contains(text(),'Green')]");

	// xpath for engagement start date drop down
	By engagement_StartDateDropDown=By.xpath("//input[@ng-model='deal.startDate']");

	// xpath for clicking on selecting next month
	By engagement_StartDateRightClick=By.xpath("(//button[@class='btn btn-default btn-sm pull-right'])[1]");

	// xpath for engagement start date 1
	By engagement_StartDateSel=By.xpath("(//button[@class='btn btn-default btn-sm'])[23]");

	// xpath for engagement end date calendar drop down
	By engagement_EndDate_CalendarDropDown=By.xpath("//input[@ng-model='deal.endDate']");

	// xpath for engagement end date 1
	By engagement_EndDatesel_click1=By.xpath("(//button[@class='btn btn-default btn-sm pull-right'])[2]");

	// xpath for engagement end date 2
	By engagement_EndDateSel_Click2=By.xpath("(//button[@class='btn btn-default btn-sm pull-right'])[2]");

	// xpath for engagement end date 3
	By engagement_EndDateSel_Click3=By.xpath("(//button[@class='btn btn-default btn-sm pull-right'])[2]");

	// xpath for engagement date 4
	By engagement_EndDateSel_Click4=By.xpath("(//button[@class='btn btn-default btn-sm'])[61]");

	// xpath engagement sub group drop down
	By engagement_SubGroup_DrpDown=By.xpath("(//a[@class='chosen-single chosen-default'])[2]");

	// xpath for engagement subgroup selection
	By engagement_SubGroup_Selection=By.xpath("//li[contains(text(),'Abbott Laboratories | Abbott - Corporate Development')]");

	// xpath for engagement billing drop down
	By engagement_Billing_DropDown=By.xpath("(//a[@class='chosen-single chosen-default'])[3]");

	// xpath for engagement billing selection
	By engagement_Billing_Selection=By.xpath("//li[contains(text(),'Fixed Cost')]");

	// xpath for engagement Nextbtn 1
	By engagement_NextBtn1=By.xpath("//button[contains(text(),'Next')]");

	// xpath for engagement VCM drop down
	By engagement_VCM_DropDown=By.xpath("//span[contains(text(),'Value Chain Mappings')]");

	// xpath for engagement VCM Selection
	By engagement_VCM_Selection=By.xpath("//li[contains(text(),'People')]");

	// xpath for Engagement next btn 2
	By engagement_NextBtn2=By.xpath("//button[contains(text(),'Next')]");

	// xpath for engagement primary contact drop down 1
	By engagement_PrimaryContact_DropDown=By.xpath("//span[contains(text(),'Primary Contact')]");

	// xpath for engagement primary contact selection
	By engagement_PrimaryContact_Selection=By.xpath("//li[contains(text(),'Devjeet Haldar')]");

	// xpath for engagement next btn 3
	By engagement_NextBtn3=By.xpath("//button[contains(text(),'Next')]");

	// xpath for engagement next btn 4
	By engagement_NextBtn4=By.xpath("//button[contains(text(),'Next')]");

	// xpath for engagement next btn 5
	By engagement_NextBtn5=By.xpath("//button[contains(text(),'Next')]");

	// xpath for engagement next btn 6
	By engagement_NextBtn6=By.xpath("//button[contains(text(),'Next')]");

	// xpath for engagement Create btn
	By engagement_CreateBtn=By.xpath("//button[contains(text(),'Create')]");

	public Engagement_creation_page(WebDriver driver) {
		this.driver = driver;
	
	}

	/*
	 * method for clicking on engagement tab
	 */
	public void clickOnEngagementsTab() {
		clickWhenElementIsReady(driver, 20, engagement_Tab_Selection);
		try {
			Engagement_creation_page_pageLog.info("Trying to locate the element for Engagement tab");
		} catch (Exception e) {
			Engagement_creation_page_pageLog.info("unable to locate the element for Engagement tab");
		}
	}

	/*
	 * method for clicking on engagement create button
	 */
	public void engagementClickOnPlusIcon() {
		clickWhenElementIsReady(driver, 20, engagement_PlusIcon);
		try {
			Engagement_creation_page_pageLog.info("Trying to locate the element for Engagement create button");
		} catch (Exception e) {
			Engagement_creation_page_pageLog.info("unable to locate the element for Engagement create button");
		}
	}

	/*
	 * method for engagement name entering
	 */
	public void engagementNameSelection() {
		driver.findElement(engagement_Name).sendKeys("Test Engagement with new framework");
		try {
			Engagement_creation_page_pageLog.info("Trying to locate the element for Engagement name");
		} catch (Exception e) {
			Engagement_creation_page_pageLog.info("unable to locate the element for Engagement name");
		}
	}

	/*
	 * method for engagement status drop down
	 */
	public void clickOnEngagementStatusDropDown() {
		clickWhenElementIsReady(driver, 20, engagement_StatusDropDown);
		try {
			Engagement_creation_page_pageLog.info("Trying to locate the element for Engagement status drop down");
		} catch (Exception e) {
			Engagement_creation_page_pageLog.info("unable to locate the element for Engagement status drop down");
		}
	}

	/*
	 * method for engagement status
	 */
	public void selectEngagementStatus() {
		clickWhenElementIsReady(driver, 20, engagement_Status_Selection);
		try {
			Engagement_creation_page_pageLog.info("Trying to locate the element for Engagement status");
		} catch (Exception e) {
			Engagement_creation_page_pageLog.info("unable to locate the element for Engagement status");
		}
	}

	/*
	 * method for engagement date selection 1
	 */
	public void engagementStartDateSelection1() {
		clickWhenElementIsReady(driver, 20, engagement_StartDateDropDown);
		try {
			Engagement_creation_page_pageLog.info("Trying to locate the element for Engagement start date selection 1");
		} catch (Exception e) {
			Engagement_creation_page_pageLog
					.info("unable to locate the element for Engagement  start date selection 1");
		}
	}

	public void engagementStartDateSelection2() {
		clickWhenElementIsReady(driver, 20, engagement_StartDateRightClick);
		try {
			Engagement_creation_page_pageLog
					.info("Trying to locate the element for Engagement start date selecting the next month");
		} catch (Exception e) {
			Engagement_creation_page_pageLog
					.info("unable to locate the element for Engagement  start date selecting the next month");
		}
	}

	/*
	 * method for engagement start date selection 2
	 */
	public void engagementStartDateSelection3() {
		clickWhenElementIsReady(driver, 20, engagement_StartDateSel);
		try {
			Engagement_creation_page_pageLog.info("Trying to locate the element for Engagement start date selection 2");
		} catch (Exception e) {
			Engagement_creation_page_pageLog.info("unable to locate the element for Engagement start date selection 2");
		}
	}

	/*
	 * method for engagement end date selection 1
	 */
	public void engagementEndDateSelection1() {
		clickWhenElementIsReady(driver, 20, engagement_EndDate_CalendarDropDown);
		try {
			Engagement_creation_page_pageLog.info("Trying to locate the element for Engagement end date selection 1");
		} catch (Exception e) {
			Engagement_creation_page_pageLog.info("unable to locate the element for Engagement end date selection 1");
		}
	}

	/*
	 * method for engagement end date selection 2
	 */
	public void engagementEndDateSelection2() {
		clickWhenElementIsReady(driver, 20, engagement_EndDatesel_click1);
		try {
			Engagement_creation_page_pageLog.info("Trying to locate the element for Engagement end date selection 2");
		} catch (Exception e) {
			Engagement_creation_page_pageLog.info("unable to locate the element for Engagement end date selection 2");
		}
	}

	/*
	 * method for engagement end date selection 3
	 */
	public void engagementEndDateSelection3() {
		clickWhenElementIsReady(driver, 20, engagement_EndDateSel_Click2);
		try {
			Engagement_creation_page_pageLog.info("Trying to locate the element for Engagement end date selection 3");
		} catch (Exception e) {
			Engagement_creation_page_pageLog.info("unable to locate the element for Engagement end date selection 3");
		}
	}

	/*
	 * method for engagement end date selection 4
	 */
	public void engagementEndDateSelection4() {
		clickWhenElementIsReady(driver, 20, engagement_EndDateSel_Click3);
		try {
			Engagement_creation_page_pageLog.info("Trying to locate the element for Engagement end date selection 4");
		} catch (Exception e) {
			Engagement_creation_page_pageLog.info("unable to locate the element for Engagement end date selection 4");
		}
	}

	/*
	 * method for engagement end date selection 5
	 */
	public void engagementEndDateSelection5() {
		clickWhenElementIsReady(driver, 20, engagement_EndDateSel_Click4);
		try {
			Engagement_creation_page_pageLog.info("Trying to locate the element for Engagement end date selection 5");
		} catch (Exception e) {
			Engagement_creation_page_pageLog.info("unable to locate the element for Engagement end date selection 5");
		}
	}

	/*
	 * method for engagement Account drop down
	 */
	public void engagementAcoountDropDown() {
		clickWhenElementIsReady(driver, 20, engagement_SubGroup_DrpDown);
		try {
			Engagement_creation_page_pageLog.info("Trying to locate the element for Engagement Account drop down");
		} catch (Exception e) {
			Engagement_creation_page_pageLog.info("unable to locate the element for Engagement account drop down");
		}
	}

	/*
	 * method for Engagement Account Selection
	 */
	public void engagementAccountSelection() {
		clickWhenElementIsReady(driver, 20, engagement_SubGroup_Selection);
		try {
			Engagement_creation_page_pageLog.info("Trying to locate the element for Engagement Account Selection");
		} catch (Exception e) {
			Engagement_creation_page_pageLog.info("unable to locate the element for Engagement Account Selection");
		}
	}

	/*
	 * method for engagement billing drop down
	 */
	public void engagementBillingTypeDropDown() {
		clickWhenElementIsReady(driver, 20, engagement_Billing_DropDown);
		try {
			Engagement_creation_page_pageLog.info("Trying to locate the element for Engagement billing drop down");
		} catch (Exception e) {
			Engagement_creation_page_pageLog.info("unable to locate the element for Engagement billing drop down");
		}
	}

	/*
	 * method for engagement billing type selection
	 */
	public void engagementBillingTypeSelection() {
		clickWhenElementIsReady(driver, 20, engagement_Billing_Selection);
		try {
			Engagement_creation_page_pageLog.info("Trying to locate the element for Engagement billingtype selection");
		} catch (Exception e) {
			Engagement_creation_page_pageLog.info("unable to locate the element for Engagement billing type selection");
		}
	}

	/*
	 * method for engagement next button 1
	 */
	public void engagementNextButton1() {
		clickWhenElementIsReady(driver, 20, engagement_NextBtn1);
		try {
			Engagement_creation_page_pageLog.info("Trying to locate the element for Engagement next button 1");
		} catch (Exception e) {
			Engagement_creation_page_pageLog.info("unable to locate the element for Engagement next button 1");
		}
	}

	/*
	 * method for clickign on VCM Drop down
	 */
	public void clickOnVCMDropDown() {
		clickWhenElementIsReady(driver, 20, engagement_VCM_DropDown);
		try {
			Engagement_creation_page_pageLog.info("Trying to locate the element for Engagement VCM Drop Down");
		} catch (Exception e) {
			Engagement_creation_page_pageLog.info("unable to locate the element for Engagement VCM Drop down");
		}
	}

	/*
	 * method for selecting VCM
	 */
	public void selectingVCM() {
		clickWhenElementIsReady(driver, 20, engagement_VCM_Selection);
		try {
			Engagement_creation_page_pageLog.info("Trying to locate the element for Engagement VCM Selection");
		} catch (Exception e) {
			Engagement_creation_page_pageLog.info("unable to locate the element for Engagement VCM Selection");
		}
	}

	/*
	 * method for engagement next button 2
	 */
	public void engagementNextButton2() {
		clickWhenElementIsReady(driver, 20, engagement_NextBtn2);
		try {
			Engagement_creation_page_pageLog.info("Trying to locate the element for Engagement next button 2");
		} catch (Exception e) {
			Engagement_creation_page_pageLog.info("unable to locate the element for Engagement next button 2");
		}
	}

	/*
	 * method for primary contact drop down
	 */
	public void clickOnPrimaryContactDropDown() {
		clickWhenElementIsReady(driver, 20, engagement_PrimaryContact_DropDown);
		try {
			Engagement_creation_page_pageLog
					.info("Trying to locate the element for Engagement primary contact drop down");
		} catch (Exception e) {
			Engagement_creation_page_pageLog
					.info("unable to locate the element for Engagement primary contact drop down");
		}
	}

	/*
	 * method for primary contact selection
	 */
	public void primaryContactSelection() {
		clickWhenElementIsReady(driver, 20, engagement_PrimaryContact_Selection);
		try {
			Engagement_creation_page_pageLog
					.info("Trying to locate the element for Engagement primary contact selection");
		} catch (Exception e) {
			Engagement_creation_page_pageLog
					.info("unable to locate the element for Engagement primary contact selection");
		}
	}

	/*
	 * method for engagement next button 3
	 */
	public void engagementNextButton3() {
		clickWhenElementIsReady(driver, 20, engagement_NextBtn3);
		try {
			Engagement_creation_page_pageLog.info("Trying to locate the element for Engagement next button 3");
		} catch (Exception e) {
			Engagement_creation_page_pageLog.info("unable to locate the element for Engagement next button 3");
		}
	}

	/*
	 * method for engagement next button 4
	 */
	public void engagementNextButton4() {
		clickWhenElementIsReady(driver, 20, engagement_NextBtn4);
		try {
			Engagement_creation_page_pageLog.info("Trying to locate the element for Engagement next button 4");
		} catch (Exception e) {
			Engagement_creation_page_pageLog.info("unable to locate the element for Engagement next button 4");
		}
	}

	/*
	 * method for engagement next button 5
	 */
	public void engagementNextButton5() {
		clickWhenElementIsReady(driver, 20, engagement_NextBtn5);
		try {
			Engagement_creation_page_pageLog.info("Trying to locate the element for Engagement next button 5");
		} catch (Exception e) {
			Engagement_creation_page_pageLog.info("unable to locate the element for Engagement next button 5");
		}
	}

	/*
	 * method for engagement next button 6
	 */
	public void engagementNextButton6() {
		clickWhenElementIsReady(driver, 20, engagement_NextBtn6);
		try {
			Engagement_creation_page_pageLog.info("Trying to locate the element for Engagement next button 6");
		} catch (Exception e) {
			Engagement_creation_page_pageLog.info("unable to locate the element for Engagement next button 6");
		}
	}

	/*
	 * method for engagement create btn
	 */
	public void createbttn() {
		clickWhenElementIsReady(driver, 20, engagement_CreateBtn);
		try {
			Engagement_creation_page_pageLog.info("Trying to locate the element for Engagement Create btn");
		} catch (Exception e) {
			Engagement_creation_page_pageLog.info("unable to locate the element for Engagement Create btn");
		}
	}
}
