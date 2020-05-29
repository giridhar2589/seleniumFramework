package com.mu_sigma.OrgPlatformAutomationFramework.muMoments.test;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mu_sigma.OrgPlatformAutomationFramework.muMoments.page.MuMoments_Login_page;
import com.mu_sigma.OrgPlatformAutomationFramework.muMoments.page.Opportunity_creation_page;
import com.mu_sigma.OrgPlatformAutomationFramework.muMoments.page.Opportunity_Renewal_Validator;
import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;

public class MuMoments_Opportunity_Creation_Test extends TestBase {

	
		MuMoments_Login_page muMoments_Login_pageObj;
		Opportunity_creation_page Opportunity_creation_Obj;
		Opportunity_Renewal_Validator Renewal_Opportunity_Validator_Obj;
		
		@BeforeClass
		public void setUp() throws Exception {
			init("muMomemts_testenvironment");
			muMoments_Login_pageObj = new MuMoments_Login_page(driver);
			Opportunity_creation_Obj= new Opportunity_creation_page(driver);
			Renewal_Opportunity_Validator_Obj = new Opportunity_Renewal_Validator(driver);
			loadProperties("muMoments.properties");
			Thread.sleep(4000);
		}
		
		@DataProvider(name = "loginTestdata")
		public String[][] getLogInData() {
			String[][] loginData = getData("muMoments.xlsx", "Sheet1");
			return loginData;
		}
		
		@Test(priority = 0,dataProvider="loginTestdata")
		public void login(String username, String password, String runmode) throws InterruptedException {
			if(runmode.equalsIgnoreCase("n")){
				throw new SkipException("user Marked as No Run");
			}
			muMoments_Login_pageObj.lDap_auth();
			muMoments_Login_pageObj.LogIn_box(username);
			muMoments_Login_pageObj.password_input(password);
			muMoments_Login_pageObj.clickbutton();
			Thread.sleep(13000);
		}
		
		
		@Test(priority = 1)
		public void opportunityCreation() throws InterruptedException{
			Opportunity_creation_Obj.clickOnOpportunityTab();
			Thread.sleep(10000);
			Opportunity_creation_Obj.clickOnOpportunityAddIcon();
			Thread.sleep(8000);			
			Opportunity_creation_Obj.selectingSalesStageDropDownForOpportunity();;
			Thread.sleep(4000);
			Opportunity_creation_Obj.selectingSalesStageForOpportunity();
			Thread.sleep(4000);
			Opportunity_creation_Obj.selectingOpportunityTypeAsNew();
			Thread.sleep(4000);
			Opportunity_creation_Obj.opportunityBillingType();			
			Opportunity_creation_Obj.opportunityEndDate1();
			Thread.sleep(3000);
			Opportunity_creation_Obj.opportunityEndDate2();
			Opportunity_creation_Obj.opportunityEndDate3();
			Opportunity_creation_Obj.opportunityEndDate4();
			Opportunity_creation_Obj.opportunityStartDate1();
			Thread.sleep(1000);
			Opportunity_creation_Obj.opportunityStartDate2();
			Thread.sleep(1000);			
			Opportunity_creation_Obj.enterOpportunityName();
			Opportunity_creation_Obj.expectedCloseDate1();
			Opportunity_creation_Obj.expectedCloseDate3();
			Opportunity_creation_Obj.clickOnOpportunitySubgroupDropDown();
			Opportunity_creation_Obj.selectOpportunitySubGroup();
			Thread.sleep(3000);
			Opportunity_creation_Obj.opporunityNextButtonPress1();
			Thread.sleep(2000);
			Opportunity_creation_Obj.clickOnVCMDropDown();
			Opportunity_creation_Obj.selectVCM();
			Opportunity_creation_Obj.opporunityNextButtonPress2();
			Thread.sleep(2000);
			Opportunity_creation_Obj.opportunityContactDropDown();
			Opportunity_creation_Obj.opportunityContactSelection();
			Thread.sleep(2000);
			Opportunity_creation_Obj.clickOnOpportunitySaveNClose();
			Thread.sleep(15000);
			}

/*
           @Test(priority = 1)
           public void opportunityRenewalValidator() throws InterruptedException
           {
        	   Renewal_Opportunity_Validator_Obj.roppsel_click(); 
        	   Thread.sleep(9000);
        	   Renewal_Opportunity_Validator_Obj.ropportunityicon_sel();
        	   Thread.sleep(9000);
        	   Renewal_Opportunity_Validator_Obj.billingtype();
        	   Thread.sleep(4000);
        	   Renewal_Opportunity_Validator_Obj.billingtype2();
        	   Thread.sleep(4000);
        	   Renewal_Opportunity_Validator_Obj.slsstage1();
        	   Thread.sleep(4000);
        	   Renewal_Opportunity_Validator_Obj.slsstage2();
        	   Thread.sleep(4000);
        	   Renewal_Opportunity_Validator_Obj.oppdrpdown();
        	   Thread.sleep(4000);
        	   Renewal_Opportunity_Validator_Obj.opptype_sel();
        	   Thread.sleep(4000);        	    	   
        	   Renewal_Opportunity_Validator_Obj.enddt1();
        	   Thread.sleep(4000);
        	   Renewal_Opportunity_Validator_Obj.enddt2();
        	   Thread.sleep(4000);
        	   Renewal_Opportunity_Validator_Obj.enddt3();
        	   Thread.sleep(4000);
        	   Renewal_Opportunity_Validator_Obj.enddt4();
        	   Thread.sleep(4000);
        	   Renewal_Opportunity_Validator_Obj.strtdt1();
        	   Thread.sleep(4000);
        	   Renewal_Opportunity_Validator_Obj.strtdt2();
        	   Thread.sleep(4000);
        	   Renewal_Opportunity_Validator_Obj.roppname_sel();
        	   Thread.sleep(4000);
        	   Renewal_Opportunity_Validator_Obj.ecd();
        	   Thread.sleep(4000);
        	   Renewal_Opportunity_Validator_Obj.ecd1();
        	   Thread.sleep(4000);
        	   Renewal_Opportunity_Validator_Obj.ecd2();
        	   Thread.sleep(4000);        	   
        	   Renewal_Opportunity_Validator_Obj.subgroup_drop();
        	   Thread.sleep(4000);
        	   Renewal_Opportunity_Validator_Obj.subgroup_sel();
        	   Thread.sleep(4000); 
        	   Renewal_Opportunity_Validator_Obj.next1();
        	   Thread.sleep(8000);
           }
           */
           
}
