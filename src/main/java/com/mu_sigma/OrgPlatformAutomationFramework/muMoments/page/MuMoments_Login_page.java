package com.mu_sigma.OrgPlatformAutomationFramework.muMoments.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.PageFactory;

import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;

/**
 * 
 * @author Aditya.Narayan
 *
 */
public class MuMoments_Login_page extends TestBase {

	WebDriver driver;
	private static final Logger Login_pageLog = LogManager.getLogger(MuMoments_Login_page.class.getName());
		
	By ldap_authentication=By.xpath("//span[contains(text(),'Login using credentials')]");

	By username_inputbox=By.xpath("//input[@name='username']");

	// Declared password text box
	By password_inputbox=By.xpath("//input[@name='password']");

	// Sign in button
	By signinbutton=By.xpath("//button[@type='submit']");

	public MuMoments_Login_page(WebDriver driver) {
		this.driver = driver;
	
	}

	public void lDap_auth(){
		driver.findElement(ldap_authentication).click();
	}
	/**
	 * 
	 * @param userNmae
	 */
	public void LogIn_box(String username) {
		driver.findElement(username_inputbox).sendKeys(username);
	}

	/**
	 * 
	 * @param password
	 */
	public void password_input(String password) {
		driver.findElement(password_inputbox).sendKeys(password);
	}
	
	public void clickbutton()
	{
		driver.findElement(signinbutton).click();
	}
}
