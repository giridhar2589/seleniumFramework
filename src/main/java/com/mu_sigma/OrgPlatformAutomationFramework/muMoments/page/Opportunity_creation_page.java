package com.mu_sigma.OrgPlatformAutomationFramework.muMoments.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;

public class Opportunity_creation_page extends TestBase {
	WebDriver driver;
	
	private static final Logger Opportunity_creation_page_pageLog = LogManager.getLogger(Opportunity_creation_page.class.getName());
	
	/*
	 * xpath for clicking on Opportunity icon
	 */
	By opportunity_TabSelection=By.xpath("//a[contains(text(),'Opportunities')]");
	 
	/*
	 * xpath for clicking on Add icon
	 */
	By opportunity_AddIcon=By.xpath("//span[@class='glyphicon glyphicon-plus-sign ng-scope']");
	
	/*
	 * xpath for entering the Opportunity name
	 */
	By opportunity_Name_Enter=By.xpath("(//input[@class='form-control ng-pristine ng-invalid ng-invalid-required'])[1]");
	
	/*
	 * xpath for expected close date
	 */
	By opporrunity_expectedCloseDateSel1=By.xpath("//input[@ng-model='deal.expectedCloseDate']");
	
	/*
	 * Selecting future month in the calendar
	 */
	//@FindBy(xpath = "(//i[@class='glyphicon glyphicon-chevron-right'])[1]")
	//WebElement opportunity_expectedCloseDateSel2;
	
    /*
     * xpath for expected close date selction
     */
	By opportunity_expectedCloseDateSel3=By.xpath("(//button[@class='btn btn-default btn-sm'])[19]");
		
    /*
     *xpath for clicking on Subgroup dropdown
     */
	By opportunity_SubGroup_DrpDown=By.xpath("(//a[@class='chosen-single chosen-default'])[1]");
	
	/*
	 * xpath for Selecting the subgroup
	 */
	By opportunity_Subgroup_Selection=By.xpath("//li[contains(text(),'Abbott Laboratories | Abbott - Corporate Development')]");

	/*
	 * xpath for clicking on opportunity type drop down
	 */
	By opportunity_Type_DropDown=By.xpath("(//a[@class='chosen-single chosen-default'])[2]");
	
	/*
	 * xpath for selecting opp type
	 */
	By opportunity_Type_New_Selection=By.xpath("//li[contains(text(),'New')]");
	
	/*
	 * click on sales stage drp down
	 */
	
	By opportunity_SalesStage_DropDown=By.xpath("(//a[@class='chosen-single chosen-default'])[3]");
	
	/*
	 * selecting sales stage
	 */
	
	By opportunity_SalesStage_Selection=By.xpath("//li[contains(text(),'Proposal Submitted (40%) | OPEN')]");
	
	/*
	 * click on start date
	 */
	
	By opportunity_StartDate1=By.xpath("(//input[@class='form-control ng-pristine ng-invalid ng-invalid-required'])[3]");
    
	/*
	 * Selecting date
	 */
    By opportunity_StartDate2=By.xpath("(//button[@class='btn btn-default btn-sm'])[63]");
    
    /*
     * Click on End date
     */
    By opportunity_EndDate1=By.xpath("(//input[@class='form-control ng-pristine ng-invalid ng-invalid-required'])[4]");
    
    /*
     * select the future month 
     */
    By opportunity_EndDate2=By.xpath("(//button[@class='btn btn-default btn-sm pull-right'])[3]");
    
    /*
     * select one more future month
     */
    By opportunity_EndDate3=By.xpath("(//button[@class='btn btn-default btn-sm pull-right'])[3]"); 
    
    /*
     * select one date
     */
    By opportunity_EndDate4=By.xpath("(//button[@class='btn btn-default btn-sm'])[99]");    
    
    /*
     * click on billing type drop down
     */
    By opportunity_BillingType_DropDown=By.xpath("(//a[@class='chosen-single chosen-default'])[6]");
    
    /*
     * click on Fixed price
     */
    By opportunity_BillingType_Selection=By.xpath("//li[contains(text(),'Fixed Cost')]");
    
    /*
     * Click on Next button
     */
	By oppotunity_NextBtnPress1=By.xpath("//button[contains(text(),'Next')]");
    
    /*
     * click on vcm drp down
     */
    By opportunity_VCM_DropDown=By.xpath("(//a[@class='chosen-single chosen-default'])[3]");
    
    /*
     * select vcm people
     */
    By opportunity_VCM_Selection=By.xpath("//li[contains(text(),'People')]"); 
    
    /*
     * click on next
     */
    By opportunity_NextBtnPress2=By.xpath("//button[contains(text(),'Next')]");
    
    /*
     * click on contacts drop down
     */
    By opportunity_Contact_DropDown=By.xpath("(//a[@class='chosen-single chosen-default'])[4]");
    
    /*
     * select  contact name
     */
    By opportunity_Contact_Selection=By.xpath("//li[contains(text(),'Devjeet Haldar')]");   
    
    /*
     * Click on Save N Close button
     */
    By opportunity_SaveNClose=By.xpath("//button[contains(text(),'Save & Close')]");
    
    public Opportunity_creation_page(WebDriver driver){
    	this.driver=driver;
    	PageFactory.initElements(driver, this);
    }
   
    /**
     * Click on Opp tab
     */
    public void clickOnOpportunityTab()
    {
    	clickWhenElementIsReady(driver, 20, opportunity_TabSelection);
    try
    {
    	Opportunity_creation_page_pageLog.info("Trying to locate the element for Opportunity tab");
    }
    catch (Exception e)
    {
    	Opportunity_creation_page_pageLog.info("Unable to locate the element for Opportunity tab");
    }
    }
    
    /**
     * click on Add icon
     */
    
    public void clickOnOpportunityAddIcon()
    {
    	clickWhenElementIsReady(driver, 20, opportunity_AddIcon);
    	 try
    	    {
    	    	Opportunity_creation_page_pageLog.info("Trying to locate the element for Opportunity plus icon");
    	    }
    	    catch (Exception e)
    	    {
    	    	Opportunity_creation_page_pageLog.info("Unable to locate the element for Opportunity plus icon");
    	    }
    }
    
    /**
     * Enter the Opportunity name
     */
    public void enterOpportunityName()
    {
    	driver.findElement(opportunity_Name_Enter).sendKeys("Test Opp with new framework");
    	 try
    	    {
    	    	Opportunity_creation_page_pageLog.info("Trying to locate the element for Opportunity name text box");
    	    }
    	    catch (Exception e)
    	    {
    	    	Opportunity_creation_page_pageLog.info("Unable to locate the element for Opportunity name text box");
    	    }
    }
    
    /*
     * Method for expected close date 1
     */
    public void expectedCloseDate1()
    {
    	clickWhenElementIsReady(driver, 20, opporrunity_expectedCloseDateSel1);
    	 try
    	    {
    	    	Opportunity_creation_page_pageLog.info("Trying to locate the element for Opportunity expected close date 1");
    	    }
    	    catch (Exception e)
    	    {
    	    	Opportunity_creation_page_pageLog.info("Unable to locate the element for Opportunity expected close date 2");
    	    }
    }
    
    /*public void expectedCloseDate2()
    {
    	clickWhenElementIsReady(driver, 20, opportunity_expectedCloseDateSel2);
    	//opportunity_expectedCloseDateSel2.click();
    }*/
    
    /*
     * Method for expected close date 3
     */
    public void expectedCloseDate3()
    {
    	clickWhenElementIsReady(driver, 20, opportunity_expectedCloseDateSel3);
    	 try
    	    {
    	    	Opportunity_creation_page_pageLog.info("Trying to locate the element for Opportunity expected close date 3");
    	    }
    	    catch (Exception e)
    	    {
    	    	Opportunity_creation_page_pageLog.info("Unable to locate the element for Opportunity expected close date 3");
    	    }
    }
    
    /*
     * Method for opp subgroup drop down
     */
    public void clickOnOpportunitySubgroupDropDown()
    {
    	clickWhenElementIsReady(driver, 20, opportunity_SubGroup_DrpDown);
    	 try
    	    {
    	    	Opportunity_creation_page_pageLog.info("Trying to locate the element for Opportunity subgroup drop down");
    	    }
    	    catch (Exception e)
    	    {
    	    	Opportunity_creation_page_pageLog.info("Unable to locate the element for Opportunity subgroup drop down");
    	    }
    }
    
    /*
     * Method for Selection of Subgroup
     */
    public void selectOpportunitySubGroup()
    {
    	clickWhenElementIsReady(driver, 20, opportunity_Subgroup_Selection);
    	 try
    	    {
    	    	Opportunity_creation_page_pageLog.info("Trying to locate the element for Opportunity subgroup selection");
    	    }
    	    catch (Exception e)
    	    {
    	    	Opportunity_creation_page_pageLog.info("Unable to locate the element for Opportunity subgroup selection");
    	    }
    }
    
    /*
     * Method for selecting Opportunity type
     */
    public void selectingOpportunityTypeAsNew() throws InterruptedException
    {
    	driver.findElement(opportunity_Type_DropDown).click();
    	 try
    	    {
    	    	Opportunity_creation_page_pageLog.info("Trying to locate the element for Opportunity type drop down ");
    	    }
    	    catch (Exception e)
    	    {
    	    	Opportunity_creation_page_pageLog.info("Unable to locate the element for Opportunity type drop down");
    	    }
		Thread.sleep(1000);
		
		driver.findElement(opportunity_Type_New_Selection).click();
		 try
		    {
		    	Opportunity_creation_page_pageLog.info("Trying to locate the element for Opportunity type selection");
		    }
		    catch (Exception e)
		    {
		    	Opportunity_creation_page_pageLog.info("Unable to locate the element for Opportunity type selection");
		    }
    }
    
    /*
     * Method for selecting Sales stage
     */
    public void selectingSalesStageDropDownForOpportunity() throws InterruptedException
    {
    	clickWhenElementIsReady(driver, 20, opportunity_SalesStage_DropDown);
    	
    	 try
    	    {
    	    	Opportunity_creation_page_pageLog.info("Trying to locate the element for Opportunity sales stage drop down");
    	    }
    	    catch (Exception e)
    	    {
    	    	Opportunity_creation_page_pageLog.info("Unable to locate the element for Opportunity sales stage drop down");
    	    }
    }
    	
    public void selectingSalesStageForOpportunity()
    {
    	clickWhenElementIsReady(driver, 20, opportunity_SalesStage_Selection);
    	
    	try
        {
        	Opportunity_creation_page_pageLog.info("Trying to locate the element for Opportunity sales stage selection");
        }
        catch (Exception e)
        {
        	Opportunity_creation_page_pageLog.info("Unable to locate the element for Opportunity sales stage selection");
        }
    	
    }
    
    /*
     * Method for Opp start Date 1
     */
    public void opportunityStartDate1()
    {
    	clickWhenElementIsReady(driver, 20, opportunity_StartDate1);
    	 try
    	    {
    	    	Opportunity_creation_page_pageLog.info("Trying to locate the element for Opportunity start date 1");
    	    }
    	    catch (Exception e)
    	    {
    	    	Opportunity_creation_page_pageLog.info("Unable to locate the element for Opportunity start date 1");
    	    }
    }
    
    /*
     * Method for Opp Start Date 2
     */
    public void opportunityStartDate2()
    {
    	clickWhenElementIsReady(driver, 20, opportunity_StartDate2);
    	 try
    	    {
    	    	Opportunity_creation_page_pageLog.info("Trying to locate the element for Opportunity start date 2");
    	    }
    	    catch (Exception e)
    	    {
    	    	Opportunity_creation_page_pageLog.info("Unable to locate the element for Opportunity start date 2");
    	    }
    }
    
    /*
     * Method for Opp End Date 1
     */
    public void opportunityEndDate1()
    {
    	clickWhenElementIsReady(driver, 20, opportunity_EndDate1);
    	//opportunity_EndDate1.click();
    	 try
    	    {
    	    	Opportunity_creation_page_pageLog.info("Trying to locate the element for Opportunity end date 1");
    	    }
    	    catch (Exception e)
    	    {
    	    	Opportunity_creation_page_pageLog.info("Unable to locate the element for Opportunity end date 1");
    	    }
    }
    
    /*
     * Method for Opp End Date 2
     */
    public void opportunityEndDate2()
    {
    	clickWhenElementIsReady(driver, 20, opportunity_EndDate2);
    	
    	 try
    	    {
    	    	Opportunity_creation_page_pageLog.info("Trying to locate the element for Opportunity end date 2");
    	    }
    	    catch (Exception e)
    	    {
    	    	Opportunity_creation_page_pageLog.info("Unable to locate the element for Opportunity end date 2");
    	    }
    }
    
    /*
     * Method for Opp End Date 3
     */
    public void opportunityEndDate3()
    {
    	clickWhenElementIsReady(driver, 20, opportunity_EndDate3);
    	//opportunity_EndDate3.click();
    	 try
    	    {
    	    	Opportunity_creation_page_pageLog.info("Trying to locate the element for Opportunity end date 3");
    	    }
    	    catch (Exception e)
    	    {
    	    	Opportunity_creation_page_pageLog.info("Unable to locate the element for Opportunity end date 3");
    	    }
    }
    
    /*
     * Method for Opp End Date 4
     */
    public void opportunityEndDate4()
    {
    	clickWhenElementIsReady(driver, 20, opportunity_EndDate4);
    	//opportunity_EndDate4.click();
    	 try
    	    {
    	    	Opportunity_creation_page_pageLog.info("Trying to locate the element for Opportunity end date 4");
    	    }
    	    catch (Exception e)
    	    {
    	    	Opportunity_creation_page_pageLog.info("Unable to locate the element for Opportunity end date 4");
    	    }
    }
    
    /*
     * Method for Opp Billing type
     */
    public void opportunityBillingType() throws InterruptedException
    {
    	clickWhenElementIsReady(driver, 20, opportunity_BillingType_DropDown);
    	//opportunity_BillingType_DropDown.click();
    	 try
    	    {
    	    	Opportunity_creation_page_pageLog.info("Trying to locate the element for Opportunity billing type drop down");
    	    }
    	    catch (Exception e)
    	    {
    	    	Opportunity_creation_page_pageLog.info("Unable to locate the element for Opportunity billing type drop down");
    	    }
    	Thread.sleep(2000);
    	//opportunity_BillingType_Selection.click();
    	 try
    	    {
    	    	Opportunity_creation_page_pageLog.info("Trying to locate the element for Opportunity billing type selection");
    	    }
    	    catch (Exception e)
    	    {
    	    	Opportunity_creation_page_pageLog.info("Unable to locate the element for Opportunity billing type selection");
    	    }
    	
    }
    
    /*
     * Method for Opp Next button press 1
     */
    public void opporunityNextButtonPress1()
    {
    	clickWhenElementIsReady(driver, 20, oppotunity_NextBtnPress1);
    	 try
    	    {
    	    	Opportunity_creation_page_pageLog.info("Trying to locate the element for Opportunity next button 1");
    	    }
    	    catch (Exception e)
    	    {
    	    	Opportunity_creation_page_pageLog.info("Unable to locate the element for Opportunity next button 1");
    	    }
    }
    
    /*
     * Method for Clicking on VCM Drop Down
     */
    public void clickOnVCMDropDown()
    {
    	clickWhenElementIsReady(driver, 20, opportunity_VCM_DropDown);
    	 try
    	    {
    	    	Opportunity_creation_page_pageLog.info("Trying to locate the element for Opportunity vcm drop down");
    	    }
    	    catch (Exception e)
    	    {
    	    	Opportunity_creation_page_pageLog.info("Unable to locate the element for Opportunity VCM Drop down");
    	    }
    }
    
    /*
     * Method for Selecting VCM
     */
    public void selectVCM()
    {
    	clickWhenElementIsReady(driver, 20, opportunity_VCM_Selection);
    	 try
    	    {
    	    	Opportunity_creation_page_pageLog.info("Trying to locate the element for Opportunity VCM Selection");
    	    }
    	    catch (Exception e)
    	    {
    	    	Opportunity_creation_page_pageLog.info("Unable to locate the element for Opportunity VCM Selection");
    	    }
    }
    
    /*
     * Method for opp Next button press 2
     */
    public void opporunityNextButtonPress2()
    {
    	clickWhenElementIsReady(driver, 20, opportunity_NextBtnPress2);
    	 try
    	    {
    	    	Opportunity_creation_page_pageLog.info("Trying to locate the element for Opportunity Next button press 2");
    	    }
    	    catch (Exception e)
    	    {
    	    	Opportunity_creation_page_pageLog.info("Unable to locate the element for Opportunity next button press 2");
    	    }
    }
    
    /*
     * Method for Opp Contact Drop Down
     */
    public void opportunityContactDropDown()
    {
    	clickWhenElementIsReady(driver, 20, opportunity_Contact_DropDown);
    	 try
    	    {
    	    	Opportunity_creation_page_pageLog.info("Trying to locate the element for Opportunity contact drop down");
    	    }
    	    catch (Exception e)
    	    {
    	    	Opportunity_creation_page_pageLog.info("Unable to locate the element for Opportunity contact drop down");
    	    }
    }
    
    /*
     * Method for Opp Contact Selection
     */
    public void opportunityContactSelection()
    {
    	clickWhenElementIsReady(driver, 20, opportunity_Contact_Selection);
    	 try
    	    {
    	    	Opportunity_creation_page_pageLog.info("Trying to locate the element for Opportunity contact selection");
    	    }
    	    catch (Exception e)
    	    {
    	    	Opportunity_creation_page_pageLog.info("Unable to locate the element for Opportunity contact selection");
    	    }
    }
    
    /*
     * Method for Opp Save N Close
     */
    public void clickOnOpportunitySaveNClose()
    {
    	driver.findElement(opportunity_SaveNClose).click();
    	 try
    	    {
    	    	Opportunity_creation_page_pageLog.info("Trying to locate the element for Opportunity Save N Close");
    	    }
    	    catch (Exception e)
    	    {
    	    	Opportunity_creation_page_pageLog.info("Unable to locate the element for Opportunity Save N Close");
    	    }
    }
    
}

