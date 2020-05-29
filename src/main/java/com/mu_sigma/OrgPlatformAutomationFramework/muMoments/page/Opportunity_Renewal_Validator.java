package com.mu_sigma.OrgPlatformAutomationFramework.muMoments.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;

public class Opportunity_Renewal_Validator extends TestBase {
	
	WebDriver driver;
	
	private static final Logger Renewal_Opportunity_Validator_pageLog = LogManager.getLogger(Opportunity_Renewal_Validator.class.getName());
	
	//Clicking on opportunities
	By RopportunityR_sel=By.xpath("//a[contains(text(),'Opportunities')]");
	    
	//clicking on Plus icon
	By RoppiconR_sel=By.xpath("//span[@class='glyphicon glyphicon-plus-sign ng-scope']");
	
	//clicking on text box for entering the opportunity name
	By Roppname_entr=By.xpath("(//input[@class='form-control ng-pristine ng-invalid ng-invalid-required'])[1]");
	
	//Entering Expected Close date
	By Recd_sel=By.xpath("//input[@ng-model='deal.expectedCloseDate']");
	
	//Selecting future month in the calendar
	By Recd_sel1=By.xpath("(//i[@class='glyphicon glyphicon-chevron-right'])[1]");
	
    //Selecting date
	By Recd_sel2=By.xpath("(//button[@class='btn btn-default btn-sm'])[20]");
		
    //Clickin on Subgroup link
	By Rsbgrp_drpdwn=By.xpath("(//a[@class='chosen-single chosen-default'])[1]");
	
	//Select the subgroup
	By Rsbgrp_sel=By.xpath("//li[contains(text(),'Abbott Laboratories | Abbott - Corporate Development')]");

	//click on opportunity type drop down
	By Ropptype=By.xpath("(//a[@class='chosen-single chosen-default'])[2]");
	
	//slecting opportunity type
	By ROpptype_sel=By.xpath("//li[contains(text(),'Renewal (Renewal)')]");
	
	//click on sales stage drp down
	By Rslsstage_drpdown=By.xpath("(//a[@class='chosen-single chosen-default'])[3]");
	
	//selecting sales stage
	By Rslsstage_sel=By.xpath("//li[contains(text(),'Proposal Submitted (40%) | OPEN')]");
	
	//click on start date
	By Rstrt_date1=By.xpath("(//input[@class='form-control ng-pristine ng-invalid ng-invalid-required'])[3]");
	    
	//Selecting date
    By Rstrt_date2=By.xpath("(//button[@class='btn btn-default btn-sm'])[63]");
    
    //Click on End date
    By Rend_date1=By.xpath("(//input[@class='form-control ng-pristine ng-invalid ng-invalid-required'])[4]");
    
    //select the future month 
    By Rend_date2=By.xpath("(//button[@class='btn btn-default btn-sm pull-right'])[3]");
    
    //select one more future month
    By Rend_date3=By.xpath("(//button[@class='btn btn-default btn-sm pull-right'])[3]"); 
    
    //select one date
    By Rend_date4=By.xpath("(//button[@class='btn btn-default btn-sm'])[102]");    
    
    //click on billing type drop down
    By Rbilling_type=By.xpath("(//a[@class='chosen-single chosen-default'])[6]");
    
    //click on Fixed price
    By Rbillingtype_sel=By.xpath("//li[contains(text(),'Fixed Cost')]");
    
    //Click on Next button
    By Rnxtpress1=By.xpath("//button[contains(text(),'Next')]");
    
    public Opportunity_Renewal_Validator(WebDriver driver){
    	this.driver=driver;
    	PageFactory.initElements(driver, this);
    }
    
    /*
     * method for clicking on opportunity tab
     */
    public void roppsel_click()
    {
    	clickWhenElementIsReady(driver, 20, RopportunityR_sel);
    	
    try
    {
    	Renewal_Opportunity_Validator_pageLog.info("Trying to locate the element for Opportunity tab");
    }
    catch (Exception e)
    {
    	Renewal_Opportunity_Validator_pageLog.info("Unable to locate the element for Opportunity tab");
    }
    }
    
    /*
     * method for clicking on create button
     */
    public void ropportunityicon_sel()
    {
    	clickWhenElementIsReady(driver, 20, RoppiconR_sel);
    	
    	try
        {
        	Renewal_Opportunity_Validator_pageLog.info("Trying to locate the element for Opportunity create plus button");
        }
        catch (Exception e)
        {
        	Renewal_Opportunity_Validator_pageLog.info("Unable to locate the element for Opportunity create plus button");
        }
    }
    
    /*
     * method for entering opportunity Name
     */
    public void roppname_sel()
    {
    	driver.findElement(Roppname_entr).sendKeys("Test Opp with new framework");
    	try
        {
        	Renewal_Opportunity_Validator_pageLog.info("Trying to locate the element for opportunity name enter");
        }
        catch (Exception e)
        {
        	Renewal_Opportunity_Validator_pageLog.info("Unable to locate the element for Opportunity name enter");
        }
    }
    
    /*
     * method for Expected close Date 1
     */
    public void ecd()
    {
    	clickWhenElementIsReady(driver, 20, Recd_sel);
    	
    	try
        {
        	Renewal_Opportunity_Validator_pageLog.info("Trying to locate the element for Opportunity Expected Close Date 1");
        }
        catch (Exception e)
        {
        	Renewal_Opportunity_Validator_pageLog.info("Unable to locate the element for Opportunity Expected Close Date 1");
        }
    }
    
    /*
     * method for Expected close date 2
     */
    public void ecd1()
    {
    	clickWhenElementIsReady(driver, 20, Recd_sel1);
    	
    	try
        {
        	Renewal_Opportunity_Validator_pageLog.info("Trying to locate the element for Opportunity Expected Close Date 2");
        }
        catch (Exception e)
        {
        	Renewal_Opportunity_Validator_pageLog.info("Unable to locate the element for Opportunity Expected Close Date 2");
        }
    }
    
    /*
     * method for Expected Close Date 3
     */
    public void ecd2()
    {
    	clickWhenElementIsReady(driver, 20, Recd_sel2);
    	
    	try
        {
        	Renewal_Opportunity_Validator_pageLog.info("Trying to locate the element for Opportunity Expected Close Date 3");
        }
        catch (Exception e)
        {
        	Renewal_Opportunity_Validator_pageLog.info("Unable to locate the element for Opportunity Expected Close Date 3");
        }
    }
    
    /*
     * Method for Subgroup Drop Down
     */
    public void subgroup_drop()
    {
    	clickWhenElementIsReady(driver, 20, Rsbgrp_drpdwn);
    	
    	try
        {
        	Renewal_Opportunity_Validator_pageLog.info("Trying to locate the element for Opportunity Sungroup Drop Down");
        }
        catch (Exception e)
        {
        	Renewal_Opportunity_Validator_pageLog.info("Unable to locate the element for Opportunity Subgroup Drop Down");
        }
    }
    
    /*
     * Method for Subgroup Selection
     */
    public void subgroup_sel()
    {
    	clickWhenElementIsReady(driver, 20, Rsbgrp_sel);
    	
    	try
        {
        	Renewal_Opportunity_Validator_pageLog.info("Trying to locate the element for Opportunity Subgroup Selection");
        }
        catch (Exception e)
        {
        	Renewal_Opportunity_Validator_pageLog.info("Unable to locate the element for Opportunity Subgroup Selection");
        }
    }
    
    /*
     * Method Opp type drop down
     */
    public void oppdrpdown()
    {
    	clickWhenElementIsReady(driver, 20, Ropptype);
    	
    	try
        {
        	Renewal_Opportunity_Validator_pageLog.info("Trying to locate the element for Opportunity type Drop Down");
        }
        catch (Exception e)
        {
        	Renewal_Opportunity_Validator_pageLog.info("Unable to locate the element for Opportunity type drop Down");
        }
    }
    
    /*
     * Method for Opp type Selection
     */
    public void opptype_sel()
    {
    	clickWhenElementIsReady(driver, 20, ROpptype_sel);
    	
    	try
        {
        	Renewal_Opportunity_Validator_pageLog.info("Trying to locate the element for Opportunity type Selection");
        }
        catch (Exception e)
        {
        	Renewal_Opportunity_Validator_pageLog.info("Unable to locate the element for Opportunity type Selection");
        }
    }
    
    /*
     * Method for Sales Stage drop down
     */
    public void slsstage1()
    {
    	clickWhenElementIsReady(driver, 20, Rslsstage_drpdown);
    	
    	try
        {
        	Renewal_Opportunity_Validator_pageLog.info("Trying to locate the element for Opportunity Sales Stage drop down");
        }
        catch (Exception e)
        {
        	Renewal_Opportunity_Validator_pageLog.info("Unable to locate the element for Opportunity sales stage drop down");
        }
    }
    
    /*
     * Method for Sales Stage selection
     */
    public void slsstage2()
    {
    	clickWhenElementIsReady(driver, 20, Rslsstage_sel);
    	
    	try
        {
        	Renewal_Opportunity_Validator_pageLog.info("Trying to locate the element for Opportunity Sales Stage Selection");
        }
        catch (Exception e)
        {
        	Renewal_Opportunity_Validator_pageLog.info("Unable to locate the element for Opportunity Sales Stage Selection");
        }
    }
    
    /*
     * Method for Opp Start Date 1
     */
    public void strtdt1()
    {
    	clickWhenElementIsReady(driver, 20, Rstrt_date1);
    	try
        {
        	Renewal_Opportunity_Validator_pageLog.info("Trying to locate the element for Opportunity start date 1");
        }
        catch (Exception e)
        {
        	Renewal_Opportunity_Validator_pageLog.info("Unable to locate the element for Opportunity start date 1");
        }
    }
    
    /*
     * method for Opp start date 2
     */
    public void strtdt2()
    {
    	clickWhenElementIsReady(driver, 20, Rstrt_date2);
    	
    	try
        {
        	Renewal_Opportunity_Validator_pageLog.info("Trying to locate the element for Opportunity start date 2");
        }
        catch (Exception e)
        {
        	Renewal_Opportunity_Validator_pageLog.info("Unable to locate the element for Opportunity start date 2");
        }
    }
    
    /*
     * method for Opp end date 1
     */
    public void enddt1()
    {
    	clickWhenElementIsReady(driver, 20, Rend_date1);
    	
    	try
        {
        	Renewal_Opportunity_Validator_pageLog.info("Trying to locate the element for Opportunity end date 1");
        }
        catch (Exception e)
        {
        	Renewal_Opportunity_Validator_pageLog.info("Unable to locate the element for Opportunity end date 1");
        }
    }
    
    /*
     * method for Opp end date 2
     */
    public void enddt2()
    {
    	clickWhenElementIsReady(driver, 20, Rend_date2);
    	
    	try
        {
        	Renewal_Opportunity_Validator_pageLog.info("Trying to locate the element for Opportunity end date 2");
        }
        catch (Exception e)
        {
        	Renewal_Opportunity_Validator_pageLog.info("Unable to locate the element for Opportunity end date 2");
        }
    }
   
    /*
     * method for Opp End Date 3
     */
    public void enddt3()
    {
    	clickWhenElementIsReady(driver, 20, Rend_date3);
    	
    	try
        {
        	Renewal_Opportunity_Validator_pageLog.info("Trying to locate the element for Opportunity end date 3");
        }
        catch (Exception e)
        {
        	Renewal_Opportunity_Validator_pageLog.info("Unable to locate the element for Opportunity end date 3");
        }
    }
    
    /*
     * method for Opp End date 4
     */
    public void enddt4()
    {
    	clickWhenElementIsReady(driver, 20, Rend_date4);
    	
    	try
        {
        	Renewal_Opportunity_Validator_pageLog.info("Trying to locate the element for Opportunity end date 4");
        }
        catch (Exception e)
        {
        	Renewal_Opportunity_Validator_pageLog.info("Unable to locate the element for Opportunity end date 4");
        }
    }
    
    /*
     * method for billing type drop down
     */
    public void billingtype()
    {
    	clickWhenElementIsReady(driver, 20, Rbilling_type);
    	
    	try
        {
        	Renewal_Opportunity_Validator_pageLog.info("Trying to locate the element for Opportunity billin type drop down");
        }
        catch (Exception e)
        {
        	Renewal_Opportunity_Validator_pageLog.info("Unable to locate the element for Opportunity billing type drop down");
        }
    }
    
    /*
     * method for billing type selection
     */
    public void billingtype2()
    {
    	clickWhenElementIsReady(driver, 20, Rbillingtype_sel);
    	
    	try
        {
        	Renewal_Opportunity_Validator_pageLog.info("Trying to locate the element for Opportunity billing type selection");
        }
        catch (Exception e)
        {
        	Renewal_Opportunity_Validator_pageLog.info("Unable to locate the element for Opportunity billing type selection");
        }
    }
    
    /*
     * method for Next button press
     */
    public void next1()
    {
    	clickWhenElementIsReady(driver, 20, Rnxtpress1);
    	
    	try
        {
        	Renewal_Opportunity_Validator_pageLog.info("Trying to locate the element for Opportunity next button press1");
        }
        catch (Exception e)
        {
        	Renewal_Opportunity_Validator_pageLog.info("Unable to locate the element for Opportunity next button press 1");
        }
    }

}

