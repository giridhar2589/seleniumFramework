package com.mu_sigma.OrgPlatformAutomationFramework.muExpense.page;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;

public class Approvals_page extends TestBase{
	WebDriver driver;
	private static final Logger Approvals_pageLog = LogManager
			.getLogger(Approvals_page.class.getName());
	
	By approvalsTab = By.xpath("//a[@href='#/approvals']");
	By pendingTab = By.xpath("//div[@class='mat-tab-label-content' and contains(text(),'Processed')]");
	By approveIcon = By.xpath("//mat-icon[@class='mat-icon material-icons' and contains(text(),'check_circle')]");
	By forwardICon = By.xpath("//mat-icon[@class='mat-icon material-icons' and contains(text(),'arrow_forward')]");
	By rejectIcon = By.xpath("//mat-icon[@class='mat-icon material-icons' and contains(text(),'cancel')]");
	By commentIcon = By.xpath("//mat-icon[@class='mat-icon material-icons' and contains(text(),'comment')]");
	By approveClaimPopUp = By.xpath("//h2[@class='mat-dialog-title' and contains(text(),'Approving the claim')]");
	By commentInputBox = By.xpath("//textarea[@placeholder='Comments(Optional)']");
	By ok_btn = By.xpath("//span[text()='OK']");
	/**
	 * Method to initiate the driver
	 * 
	 * @param driver
	 */
	public Approvals_page(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickApprovalsTab(){
		clickWhenElementIsReady(driver, 10, approvalsTab);
	}
	
	public void clickOnSpecificClaim(String ClaimName){
		WebElement claim = driver.findElement(
				By.xpath("//div[@class='mat-body-1' and contains(text(),'" + ClaimName + "')]"));
		clickWhenElementIsReady(driver,10 , claim);
	}
	
	public void approveClaim(String approvedcomments) throws Exception{
		waitForElement(approveIcon, 10);
		clickWhenElementIsReady(driver, 10, approveIcon);
		if(driver.findElement(approveClaimPopUp).isDisplayed()){
			driver.findElement(commentInputBox).sendKeys(approvedcomments);
			clickWhenElementIsReady(driver, 10, ok_btn);
			Thread.sleep(5000);
		}
	}
}
