package com.mu_sigma.OrgPlatformAutomationFramework.muMoments.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;

/**
 * Created On: 20-March-2018
 * @author Aditya.Narayan
 * Modified On:
 */
public class Pursuit_creation_page extends TestBase {
	
	private static final Logger Pursuit_creation_page_pageLog = LogManager.getLogger(Pursuit_creation_page.class.getClass());

	WebDriver driver;
	
	//xpath for pursuit tab selection
	By pursuit_Select=By.xpath("//a[contains(text(),'Pursuits')]");

	/*@FindBy(xpath = "//span[@class='glyphicon glyphicon-plus-sign ng-scope']")
	WebElement pursuit_addbtn;*/
	
	//xpath for clicking on add button
	By pursuit_addbtn=By.xpath("//span[@tooltip='Create Pursuit']");

	//xpath for clicking on Account DropDown
	By accountsubgroup_drpdwn=By.xpath("//span[contains(text(),'Account/Sub Group')]");

	//xpath for selecting account selection
	By accountsubgroup_selection=By.xpath("//li[contains(text(),'Abbott Laboratories | Abbott - Corporate Development')]");

	//xpath for entering pursuit name
	By pursuitName_enter=By.xpath("//input[@class ='form-control ng-pristine ng-invalid ng-invalid-required']");

	//xpath for Pursuit status drop down
	By pursuitstatus_drpdwn=By.xpath("(//a[@class='chosen-single chosen-default'])[3]");

	//xpath for pursuit status selection
	By pursuitstatus_selection=By.xpath("//li[contains(text(),'Target')]");

	//xpath for Pursuit type drop down
	By pursuittype=By.xpath("(//a[@class='chosen-single chosen-default'])[4]");

	//xpath for pursuit type selection
	By pursuitype_selection=By.xpath("//li[contains(text(),'Mining | Initial Attempt')]");

	//xpath for Next button press
	By nextpress1=By.xpath("//button[@class='btn df-btn-primary ng-scope']");

	//xpath for clicking on Contact add icon click
	By contactaddicon=By.xpath("//span[@class='glyphicon glyphicon-plus']");

	
    //xpth for contact drop down
	By contactdrpdwn=By.xpath("(//a[@class='chosen-single chosen-default'])[2]");

	//xpath for Contact Value selection
	By contactvalue_selection=By.xpath("//li[contains(text(),'Devjeet Haldar')]");

	//xpath for Role drop down
	By roledropdown=By.xpath("(//a[@class='chosen-single chosen-default'])[2]");

	//xpath for role selection
	By roleSelection=By.xpath("//li[contains(text(),'Influencer')]");

	//xpath for Save and Close
	By savenclose=By.xpath("//button[contains(text(),'Save & Close')]");

	public Pursuit_creation_page(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * click on Pursuit 
	 */
	public void clickOnPursuitEntityName() 
	{
		clickWhenElementIsReady(driver, 20, pursuit_Select);
    try
    {
        Pursuit_creation_page_pageLog.info("Trying to locate the element for pursuit  tab");
    }
    catch (Exception e)
    {
    	Pursuit_creation_page_pageLog.info("Unable to locate the element for pursuit tab");
    }
	}

	/**
	 * Click on Plus Add Icon
	 */
	public void clickOnAddButton() {
		clickWhenElementIsReady(driver, 80, pursuit_addbtn);
    try
    {
    	Pursuit_creation_page_pageLog.info("Trying to locate the element for the plus icon");
    }
    catch (Exception e)
    {
    	Pursuit_creation_page_pageLog.info("Unable to locate the element for plus icon");
    }
	}

	/**
	 * Click on Account Drop down
	 */
	public void clickOnAccountDropDown() {
		clickWhenElementIsReady(driver, 30, accountsubgroup_drpdwn);
    try
    {
    	Pursuit_creation_page_pageLog.info("Trying to locate the element for account drop down");
    }
    catch (Exception e)
    {
    	Pursuit_creation_page_pageLog.info("Unable to locate the element for account drop down");
    }
	}

	/**
	 * Select the account
	 */
	public void accountSubgroupSelection() {
		clickWhenElementIsReady(driver, 20, accountsubgroup_selection);
	try
	{
		Pursuit_creation_page_pageLog.info("Trying to locate the element for Account Selection");
	}
	catch (Exception e)
	{
		Pursuit_creation_page_pageLog.info("Unable to locate the element for Account Selection");
	}
	}

	/**
	 * Sending out the pursuit Name
	 * @param pu rsuitName
	 */
	public void providePursuitName() {
		//waitForElement(pursuitName_enter, 20);
		driver.findElement(pursuitName_enter).sendKeys("Test Pursuit Selenium");
	try{
		Pursuit_creation_page_pageLog.info("Trying to locate the element for providing pursuit nam");
	}
	catch (Exception e)
	{
		Pursuit_creation_page_pageLog.info("Unable to locate the element for providing pursuit name");
	}
	}

	/**
	 * Click on pursuit Status Drop Down
	 */
	public void clickOnPursuitStatusDropDown() {
		clickWhenElementIsReady(driver, 20, pursuitstatus_drpdwn);
	try
	{
		Pursuit_creation_page_pageLog.info("Trying to locate the element for pursuit status drop down");
	}
	catch (Exception e)
	{
		Pursuit_creation_page_pageLog.info("Unable to locate the element for pursuit status drop down");
	}
	}

	/**
	 * Select the pursuit status
	 */
	public void selectPursuitStatus() {
	    clickWhenElementIsReady(driver, 20, pursuitstatus_selection);
	try{
		Pursuit_creation_page_pageLog.info("Trying to locate the element for pursuit status selection");
	}
	catch (Exception e)
	{
		Pursuit_creation_page_pageLog.info("Unable to locate the element for pursuit status selection");
	}
	}

	/**
	 * Click on pursuit type drpdown
	 */
	public void clickOnPursuitTypeDropDown() {
		clickWhenElementIsReady(driver, 20, pursuittype);
	try
	{
		Pursuit_creation_page_pageLog.info("Trying to locate the element for Pursuit typr drop down");
	}
	catch (Exception e)
	{
		Pursuit_creation_page_pageLog.info("Unable to locate the element for Pursuit type drop down");
	}
	}

	/**
	 * Select the pursuit type
	 */
	public void selectPursuitType() {
		clickWhenElementIsReady(driver, 20, pursuitype_selection);
	try
	{
		Pursuit_creation_page_pageLog.info("Trying to locate the element pursuit type selection");
	}
	catch (Exception e)
	{
		Pursuit_creation_page_pageLog.info("Unable to locate the element pursuit type selection");
		
	}
	}

	/**
	 * click on next button
	 */
	public void clickOnNextButton() {
		clickWhenElementIsReady(driver, 20, nextpress1);
	try
	{
		Pursuit_creation_page_pageLog.info("Trying to locate the element for Next button");
	}
	catch (Exception e)
	{
		Pursuit_creation_page_pageLog.info("Unable to locate the element for next button");
	}
	}

	/**
	 * click on add contact button
	 */
	public void clickOnAddContactButton() {
		clickWhenElementIsReady(driver, 20, contactaddicon);
	try
	{
		Pursuit_creation_page_pageLog.info("trying to locate the element for clicking on Add contact button");
	}
	catch (Exception e)
	{
		Pursuit_creation_page_pageLog.info("Unable to locate the element for clicking Add contact button");
	}
	}

	/**
	 * click on contact drpdown
	 */
	public void clickOnContactDropDown() {
		clickWhenElementIsReady(driver, 20, contactdrpdwn);
    try
    {
    	Pursuit_creation_page_pageLog.info("Trying to locate the element for clicking on Contact Drop down");
    }
    catch (Exception e)
    {
    	Pursuit_creation_page_pageLog.info("Unable to locate the element for clicking on Contact drop down");
    }
	}

	/**
	 * Select the COntact
	 */
	public void selectionOfContact() {
		clickWhenElementIsReady(driver, 20, contactvalue_selection);
		try
	    {
	    	Pursuit_creation_page_pageLog.info("Trying to locate the element for clicking on Contact Selection");
	    }
	    catch (Exception e)
	    {
	    	Pursuit_creation_page_pageLog.info("Unable to locate the element for clicking on Contact Selection");
	    }
	}

	/**
	 * Click on role drop down
	 */
	public void clickOnRoleDropDown() {
		clickWhenElementIsReady(driver, 20, roledropdown);
		try
	    {
	    	Pursuit_creation_page_pageLog.info("Trying to locate the element for clicking on Role Drop down");
	    }
	    catch (Exception e)
	    {
	    	Pursuit_creation_page_pageLog.info("Unable to locate the element for clicking on Role drop down");
	    }
	}

	/**
	 * select the role
	 */
	public void selectingTheRole() {
		clickWhenElementIsReady(driver, 20, roleSelection);
		try
	    {
	    	Pursuit_creation_page_pageLog.info("Trying to locate the element for selecting the role");
	    }
	    catch (Exception e)
	    {
	    	Pursuit_creation_page_pageLog.info("Unable to locate the element for selecting the role");
	    }
	}

	/**
	 * Click on Save n close
	 */
	public void saveNClose() {
		clickWhenElementIsReady(driver, 20, savenclose);
		try
	    {
	    	Pursuit_creation_page_pageLog.info("Trying to locate the element for Save N Close button");
	    }
	    catch (Exception e)
	    {
	    	Pursuit_creation_page_pageLog.info("Unable to locate the element for Save N Close button");
	    }
	}
}
