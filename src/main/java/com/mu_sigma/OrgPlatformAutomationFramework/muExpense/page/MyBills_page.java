package com.mu_sigma.OrgPlatformAutomationFramework.muExpense.page;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;

public class MyBills_page extends TestBase {
	
	WebDriver driver;
	private static final Logger MyBill_pageLog = LogManager
			.getLogger(MyBills_page.class.getName());
	
	By selectCheckBox = By.xpath("(//div[@class='mat-checkbox-inner-container mat-checkbox-inner-container-no-side-margin'])[1]");
	By makeClaim_btn = By.xpath("//span[text()=' Make a claim (1)']");
	By claimPopUp = By.xpath("//div[@id='cdk-overlay-0']");
	By claimName_inputfield = By.xpath("//input[@placeholder='Claim Name']");
	By submitClaim_btn = By.xpath("//span[@class='mat-button-wrapper' and contains(text(),'Submit Claim')]");
	By selectAll_btn = By.xpath("//span[@class='mat-button-wrapper' and contains(text(),'Select All')]");
	By editBillIcon = By.xpath("//mat-icon[@class='mat-icon material-icons' and contains(text(),'mode_edit')]");
	
	
	//By category_dropdown = By.xpath("(//div[@class='mat-select-arrow-wrapper']//div[@class='mat-select-arrow'])[1]");
	//By subcategory_dropdown = By.xpath("(//div[@class='mat-select-arrow-wrapper']//div[@class='mat-select-arrow'])[2]");

	
	/**
	 * Method to initiate the driver
	 * 
	 * @param driver
	 */
	public MyBills_page(WebDriver driver) {
		this.driver = driver;
	}
	
	/**
	 * Method to click on specific bill
	 * @param billName
	 */
	public void clickOnSpecificBill(String billName){
		WebElement bill = driver.findElement(
				By.xpath("//span[@class='mat-body-1' and contains(text(),'" + billName + "')]"));
		clickWhenElementIsReady(driver,10 , bill);
	}
	
	public void editBill(){
		clickWhenElementIsReady(driver, 10, editBillIcon);
	}
	
	
	
	
	/*public void editDetails(String member){
		
		waitForElement(AddMember, 5);
		driver.findElement(AddMember).click();
		
	}*/
	public void selectSpecificBill() throws Exception{
		clickWhenElementIsReady(driver,10 ,selectCheckBox);
		Thread.sleep(6000);
	}
	
	public void selectAllBills() throws Exception{
		clickWhenElementIsReady(driver, 5, selectAll_btn);
		Thread.sleep(6000);
	}
	
	public void clickOnMakeAClaimButton(){
		clickWhenElementIsReady(driver, 10, makeClaim_btn);
	}
	
	public void makeAClaim(String claimName) throws Exception{
		Thread.sleep(3000);
		if (driver.findElement(claimPopUp).isDisplayed()){
			waitForElement(claimName_inputfield, 5);
			driver.findElement(claimName_inputfield).sendKeys(claimName);
			clickWhenElementIsReady(driver, 10, submitClaim_btn);
		}
	}
	

}
