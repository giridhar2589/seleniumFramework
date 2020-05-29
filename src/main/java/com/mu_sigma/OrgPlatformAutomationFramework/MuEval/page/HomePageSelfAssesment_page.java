package com.mu_sigma.OrgPlatformAutomationFramework.MuEval.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;

public class HomePageSelfAssesment_page extends TestBase{
	
	WebDriver driver;
	//JavascriptExecutor js = (JavascriptExecutor) driver;
	
	
	private static final Logger HomePageSelfAssesment_page_pageLog = LogManager
			.getLogger(HomePageSelfAssesment_page.class.getName());
	
	By username_inputBox = By.id("username");
	
	By password_inputBox = By.id("password");
	
	By Login_btn = By.xpath("//input[@class='btn btn-submit btn-block']");
	
	By UserMenu = By.xpath("//span[@id='header-login-name']");
	
	By UserId = By.xpath("//input[@placeholder='User Id']");
	
	By Submit = By.xpath("//input[@type='submit']");

	By muEval = By.xpath("//h3[contains(text(),'muEval')]");
	
	By SelfAssessment = By.xpath("//div[contains(text(),'Self')]");
	
	By Scroll_bar=By.xpath("//*[@id='mCSB_1_scrollbar_vertical']");
	
	By self1 = By.xpath("//*[@id=\"mat-radio-2\"]/label/div[2]/img");
	
	By self2 = By.xpath("//*[@id=\"mat-radio-6\"]/label/div[2]/img");
	
	By self3 = By.xpath("//*[@id=\"mat-radio-8\"]/label/div[2]/img");
	
	By selfformsubmit = By.xpath("//div[1]/mat-card-content/div/form/div[2]/button");
	
	By userMenuArrowbtn = By.xpath("//div/mat-toolbar/button/span/i");
	
	By logout = By.xpath("//a[@class='mat-menu-item']");
	
	public HomePageSelfAssesment_page(WebDriver driver) {
		this.driver = driver;
	}
	public void fillLoginDetails(String username, String password) {
		driver.findElement(username_inputBox).sendKeys(username);
		HomePageSelfAssesment_page_pageLog.info("Filled the Username");
		driver.findElement(password_inputBox).sendKeys(password);
		HomePageSelfAssesment_page_pageLog.info("Filled the Password");
		driver.findElement(Login_btn).click();
		HomePageSelfAssesment_page_pageLog.info("Clicked on the Login button");
	}
	/*
	 * Method to Switch User
	 */
	public void SwitchUser(String Username) throws InterruptedException
	{
		try {
			clickWhenElementIsReady(driver, 20, UserMenu);
			HomePageSelfAssesment_page_pageLog.info("Clicked on UserMenu");
			driver.findElement(UserId).sendKeys(Username);
			HomePageSelfAssesment_page_pageLog.info("Userid is sent");
			clickWhenElementIsReady(driver, 20, Submit);
			HomePageSelfAssesment_page_pageLog.info("Clicked on Submit Button");
			Thread.sleep(4000);
			
			HomePageSelfAssesment_page_pageLog.info("Switch User Successfull");
			
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
	}
	
	public void Enter_muEval() throws InterruptedException {
		Thread.sleep(3000);
		//driver.findElement(Scroll_bar).click();
		//HomePageSelfAssesment_page_pageLog.info("Scrollbar moved");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		 //js.executeScript("window.scrollBy(0,100)");

		WebElement Element = driver.findElement(muEval);
		Thread.sleep(4000);
		js.executeScript("arguments[0].scrollIntoView();", Element);
		Thread.sleep(4000);
		HomePageSelfAssesment_page_pageLog.info("Scrollbar moved down upto element");
		Thread.sleep(4000);
		Element.click();
		//Thread.sleep(4000);
		//clickWhenElementIsReady(driver, 60, muEval);
		Thread.sleep(4000);
		HomePageSelfAssesment_page_pageLog.info("Clicked on mueval link");
		Thread.sleep(4000);
		switchWindow(1);
		HomePageSelfAssesment_page_pageLog.info("Switched to Child Window");
		Thread.sleep(4000);
	}
	public void SubmitSelfAssesmentform() throws InterruptedException {
		clickWhenElementIsReady(driver, 20, SelfAssessment );
		HomePageSelfAssesment_page_pageLog.info("Clicked on Self Tab");
		clickWhenElementIsReady(driver, 20, self1);
		HomePageSelfAssesment_page_pageLog.info("Selected Yes for first question");
		clickWhenElementIsReady(driver, 20, self2);
		HomePageSelfAssesment_page_pageLog.info("Selected No for first question");
		clickWhenElementIsReady(driver, 20, self3);
		HomePageSelfAssesment_page_pageLog.info("Selected Yes for third question");
		Thread.sleep(3000);
		clickWhenElementIsReady(driver, 20, selfformsubmit);
		HomePageSelfAssesment_page_pageLog.info("Clicked on Submit button Successfully");
		
		
	}
	public void logout() throws InterruptedException {
		clickWhenElementIsReady(driver, 20, userMenuArrowbtn);
		HomePageSelfAssesment_page_pageLog.info("Clicked on UserMenu arrow button");
		Thread.sleep(3000);
		clickWhenElementIsReady(driver, 20, logout);
		driver.switchTo().alert().accept();
		HomePageSelfAssesment_page_pageLog.info("User Logout Successfull");
		Thread.sleep(4000);
		driver.close();
		HomePageSelfAssesment_page_pageLog.info("Child window closed");
		switchWindow(0);
		HomePageSelfAssesment_page_pageLog.info("Switched to Parent window");
		Thread.sleep(5000);
		
	}
	
	
}
