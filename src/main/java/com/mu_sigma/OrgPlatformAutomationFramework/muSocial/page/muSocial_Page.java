package com.mu_sigma.OrgPlatformAutomationFramework.muSocial.page;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class muSocial_Page {

	WebDriver driver;
	public static WebElement Element;



	private static final Logger Login_Page = LogManager.getLogger(muSocial_Page.class.getName());
	By User_name= By.id("username");
	By Pass_word=By.id("password");
	By Submit_btn=By.name("submit");
	By muSocial_icon=By.xpath("//h3[contains(text(),'muSocial')]");
	By Arrow=By.xpath("//*[@id='arrow']");
	By Impersonate= By.xpath("//*[@id='header-login-pop1']/form/input[1]");
	By Impersonated_username=By.xpath("//span[contains(text(),'Damini Batra')]");
	By Switch_btn=By.xpath("//*[@id='header-login-pop1']/form/input[2]");
	By Scroll_bar=By.xpath("//*[@id='mCSB_1_scrollbar_vertical']");
	By muSocial_logo=By.xpath("//span[contains(text(),'muSocial')]");
	//By muSocial_icon=By.xpath("//*[@id='8']/div/a/div[2]");
	By Slider_icon=By.xpath("//div[contains(text(),'Slider')]");
	By Add_new=By.xpath("//span[contains(text(),' Add New ')]");
	By Slide_Title=By.xpath("//*[@id='mat-input-0']");
	By Slide_Description=By.xpath("//*[@id='mat-input-1']");
	By Slide_Url=By.xpath("//*[@id='mat-input-2']");
	By LoCation_dropdown=By.xpath("//span[contains(text(),'Slider Group')]");
	By Value_Offshore=By.xpath("//span[contains(text(),'Offshore')]");
	By Image_upload=By.xpath("//input[@type='file']");
	By Save_Slide=By.xpath("//span[contains(text(),'Save Slide')]");
	By Actual_message = By.xpath("//div[contains(text(),'Slide is successfully saved')]");
	By Slider = By.xpath("//div[contains(text(),'Slider')]");
	By Current_tab = By.xpath("//div[contains(text(),'Current')]");
	By Existing_slide = By.xpath("//div[contains(text(),'TestSlide1')]");
	By Edit = By.xpath("//mat-icon[contains(text(),'mode_edit')]");
	By Toggle_button=By.xpath("//span[contains(text(),'Active')]");
	By UpdateSlideStatus_InActive=By.xpath("//span[contains(text(),'OK')]");
	By Title = By.xpath("//input[@formcontrolname='title']");
	By Description = By.xpath("//input[@formcontrolname='description']");
	By Url = By.xpath("//input[@formcontrolname='url']");
	By Update_slide = By.xpath("//span[contains(text(),'Update Slide')]");
	By Ok = By.xpath("//span[contains(text(),'OK')]");
	By Actualmessage = By.xpath("//div[contains(text(),'Slide is successfully updated')]");
	By Deleting_Slide = By.xpath("//*[@id='mat-tab-content-0-0']/div/mat-nav-list/div[2]/a/mat-list-item/div/div[3]");
	By Delete_icon= By.xpath("//mat-icon[contains(text(),'delete')]");
	By Delete_ok=By.xpath("//span[contains(text(),'OK')]");
	By Act_message=By.xpath("//div[contains(text(),'Slide is successfully deleted')]");
	By Add_notifi=By.xpath("//div[contains(text(),'Notification')]");
	By Add_New_Notification=By.xpath("//span[contains(text(),'Add New')]");
	By Notification_Title=By.xpath("//input[@formcontrolname='title']");
	By Notification_descptn=By.xpath("//input[@formcontrolname='description']");
	By Dropdown=By.xpath("//*[@id='mat-select-0']/div/div[2]");
	By Value_onsite=By.xpath("//span[contains(text(),'Onsite')]");
	By invalid_Credentials=By.xpath("//span[contains(text(),'Invalid credentials.')]");
	By LogoutArrow=By.id("arrow");
	By Logout_Button=By.xpath("//div[contains(text(),'Logout')]");
	By Logout_muSocial=By.xpath("//i[contains(text(),'arrow_drop_down')]");
	By Logout_muSocialbtn=By.xpath("//span[contains(text(),'Log Out')]");
	By Logout_Message=By.xpath("//h2[contains(text(),'Logout successful')]");
	By Send_Notification=By.xpath("//span[contains(text(),'Send Notification')]");
	By NotificationSentSuccessful_message=By.xpath("//div[contains(text(),'Notification is successfully sent')]");
	By Noti_to_be_deleted=By.xpath("//div[contains(text(),'Test Notification')]");
	By Delete_Notification=By.xpath("//mat-icon[contains(text(),'delete')]");
	By Delete_noti_Ok=By.xpath("//span[contains(text(),'OK')]");
	By Notification_deleted_successfully=By.xpath("//div[contains(text(),'Notification has been deleted successfully')]");
	By Slide_moved_history=By.xpath("/html/body/div[1]");
	By History_Tab=By.xpath("//div[contains(text(),'History')]");
	By Slide_movedinHistory_afterInactivation =By.xpath("//div[contains(text(),'TestSlide1')]");
	By InActive_toggle_btn=By.xpath("//span[contains(text(),'Inactive')]");
	By Update_slideStatus_Active_Ok=By.xpath("//span[contains(text(),'OK')]");
	By Slide_moved_Current=By.xpath("/html/body/div[1]");
	By Resend_Notification=By.xpath("//mat-icon[contains(text(),'redo')]");
	By Notification_ToResend=By.xpath("//div[contains(text(),'Test Notification')]");
	By Resend_Ok=By.xpath("//span[contains(text(),'OK')]");
	By Resend_Notification_Successful=By.xpath("//div[contains(text(),'Notification has been sent successfully");
	By Notification_sent_count=By.xpath("//span[contains(text(),'Notification Sent Count')]");
	By Content_tab=By.xpath("//div[contains(text(),'Content')]");
	By Add_New_Content=By.xpath("//span[contains(text(),' Add New ')]");
	By Content_Title=By.xpath("//input[@formcontrolname='title']");
	By Content_Description=By.xpath("//input[@placeholder='Content Description']");
	By Content_Url=By.xpath("//input[@placeholder='Content Url (Format: https://www.google.com)']");
	By Facebook_url=By.xpath("//input[@placeholder='Facebook Url (Format: https://www.google.com)']");
	By Instagram_url=By.xpath("//input[@formcontrolname='instagramUrl']");
	By Twitter_url=By.xpath("//input[@formcontrolname='twitterUrl']");
	By ChooseImage=By.xpath("//label[contains(text(),'Choose a file')]");


	public muSocial_Page(WebDriver driver) {
		this.driver = driver;
	}


	/**
	 * method to login by using invalid user name and password
	 * @param InvaliduserName
	 * @param InvalidPassword
	 * @throws InterruptedException
	 */
	public void Login_Invalid_userName_Invalid_Password(String InvaliduserName, String InvalidPassword) throws InterruptedException
	{

		driver.findElement(User_name).sendKeys(InvaliduserName);
		driver.findElement(Pass_word).sendKeys(InvalidPassword);
		driver.findElement(Submit_btn).click();
		Thread.sleep(3000);

	}

	/**
	 * method to return the text of pop up which says invalid credentials after login using invalid username and password
	 * @return
	 */

	public String InvalidCredentials_message(){
		try {
			return driver.findElement(invalid_Credentials).getText();
		} catch (Exception e) {
			return null;
		}
	}
	/**
	 * method to login by using invalid username and valid password
	 * @param InvaliduserName
	 * @param Password
	 * @throws InterruptedException
	 */
	public void Login_Invalid_userName_Valid_Password(String InvaliduserName, String Password) throws InterruptedException
	{

		driver.findElement(User_name).clear();
		driver.findElement(User_name).sendKeys(InvaliduserName);
		driver.findElement(Pass_word).sendKeys(Password);
		driver.findElement(Submit_btn).click();
		Thread.sleep(3000);

	}

	/**
	 * method to return the text of the pop up which says invalid credentials after login using invalid username and valid password
	 * @return
	 */
	public String InvalidUsername_message(){
		try {
			return driver.findElement(invalid_Credentials).getText();
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 *  method to login by using valid username and Invalid password
	 * @param userName
	 * @param InvalidPassword
	 * @throws InterruptedException
	 */
	public void Login_Valid_userName_InValid_Password(String userName, String InvalidPassword) throws InterruptedException
	{
		Thread.sleep(6000);
		driver.findElement(User_name).clear();
		driver.findElement(User_name).sendKeys(userName);
		driver.findElement(Pass_word).sendKeys(InvalidPassword);
		driver.findElement(Submit_btn).click();
		Thread.sleep(6000);

	}

	/**
	 *  method to return the text of the pop up which says invalid credentials after login using valid username and Invalid password
	 * @return
	 */
	public String InvalidPassword_message(){
		try {
			return driver.findElement(invalid_Credentials).getText();
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * method to login by using valid username and valid password
	 * @param userName
	 * @param Password
	 * @throws InterruptedException
	 */
	public void Login_page(String userName, String Password) throws InterruptedException
	{

		driver.findElement(User_name).clear();
		driver.findElement(User_name).sendKeys(userName);
		driver.findElement(Pass_word).sendKeys(Password);
		driver.findElement(Submit_btn).click();
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(muSocial_icon);		
		js.executeScript("arguments[0].scrollIntoView();", Element);
	}

	/** 
	 * method to check wether the muSocial Icon is visible on tab or not
	 * @return
	 */
	public boolean isElementPresent(){
		try{
			driver.findElement(muSocial_icon);
			return true;
		}
		catch(Exception e){
			return false;
		}
	}

	/**
	 * method to logout of the Applications
	 * @throws InterruptedException
	 */
	public void Logout() throws InterruptedException {
		driver.findElement(LogoutArrow).click();
		driver.findElement(Logout_Button).click();
		Thread.sleep(3000);


	}

	/**
	 * method to return the text of logout successful message
	 * @return
	 */
	public String Logout_message(){
		try {
			return driver.findElement(Logout_Message).getText();
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * method to impersonate by using the valid person's name who has the responsibility of using this application
	 * @param EmpName
	 * @throws InterruptedException
	 */
	public void impersonation(String EmpName)throws InterruptedException{
		driver.findElement(Arrow).click();
		Thread.sleep(2000);
		driver.findElement(Impersonate).click();
		driver.findElement(Impersonate).sendKeys(EmpName);
		driver.findElement(Switch_btn).click();
		driver.findElement(Scroll_bar).click();	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(muSocial_icon);		
		js.executeScript("arguments[0].scrollIntoView();", Element);
	}

	/**
	 * method to check whether the username of the application is as the name of the impersonated person
	 * @return
	 */
	public boolean isElementpresent(){
		try{
			driver.findElement(Impersonated_username);
			return true;
		}
		catch(Exception e){
			return false;
		}
	}

	/**
	 * method to enter into the muSocial and switching from muQuest home window to muSocial Application home page
	 */
	public void Enter_Into_MuSocial()throws InterruptedException{
		driver.findElement(muSocial_icon).click();
		Thread.sleep(20000);
		List<String> browserTabs = new ArrayList<String> (driver.getWindowHandles());
		//	switch to new tab
		driver.switchTo().window(browserTabs.get(1)); 

	}

	/**
	 * method to check whether muSocial logo is present
	 * @return
	 */
	public boolean is_elementpresent(){
		try{
			driver.findElement(muSocial_logo);
			return true;
		}
		catch(Exception e){
			return false;
		}
	}



	/**
	 * method to add slide by using below parameters
	 * @param SlideName
	 * @param Description
	 * @param Url
	 * @throws InterruptedException
	 */
	public void Add_Slide_Correctly(String SlideName, String Description, String Url)throws InterruptedException
	{
		
		driver.findElement(Slider_icon).click();
		driver.findElement(Add_new).click();
		Thread.sleep(3000);
		driver.findElement(Slide_Title).sendKeys(SlideName);
		driver.findElement(Slide_Description).sendKeys(Description);
		driver.findElement(Slide_Url).sendKeys(Url);
		driver.findElement(LoCation_dropdown).click();
		driver.findElement(Value_Offshore).click();
		Thread.sleep(3000);
	}

	/**
	 * method to logout of the application
	 * @throws InterruptedException
	 */

	public void Logout_musocial() throws InterruptedException {
		driver.findElement(Logout_muSocial).click();
		driver.findElement(Logout_muSocialbtn).click();
		Thread.sleep(3000);
	}


	/**
	 * method to Attach the image by fetching the imageLocation and sending it as keys to Image_upload
	 * @param ImageLocation
	 * @throws InterruptedException
	 */
	public void attach_File1(String ImageLocation) throws InterruptedException{
		Thread.sleep(2000);
		driver.findElement(Image_upload).sendKeys(ImageLocation);
		Thread.sleep(3000);
		driver.findElement(Save_Slide).click();
		Thread.sleep(4000);

	}

	/**
	 * Method to upload the image by taking the image path from the folder
	 * @param ImageLocation
	 * @param folderName
	 * @param fileName
	 * @throws InterruptedException
	 */

	public void uploadImage(String ImageLocation, String folderName,String fileName) throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(Image_upload).sendKeys(ImageLocation);
		String workingDir = System.getProperty("user.dir");
		String filepath = workingDir + "\\"+folderName+"\\" + fileName + "";
		Thread.sleep(3000);
		driver.findElement(Save_Slide).click();
		Thread.sleep(4000);

	}

	/**
	 * method to get the text of the pop up which says slide added successfully for validation purpose
	 * @return
	 */
	public String Successfulmessage(){
		try {
			return driver.findElement(Actual_message).getText();
		} catch (Exception e) {
			return null;
		}
	} 

	/**
	 * method to update the slide by using following parameter
	 * @param Slidename
	 * @param Slide_des
	 * @param Slide_Url
	 * @throws InterruptedException
	 */
	public void update_slide( String Slidename, String Slide_des, String Slide_Url  )throws InterruptedException{
		driver.findElement(Slider).click();
		Thread.sleep(3000);
		driver.findElement(Current_tab).click();
		Thread.sleep(3000);
		driver.findElement(Existing_slide).click();
		Thread.sleep(3000);
		driver.findElement(Edit).click();
		Thread.sleep(3000);	

		driver.findElement(Title).click();
		driver.findElement(Title).clear();
		driver.findElement(Title).sendKeys(Slidename);
		driver.findElement(Description).clear();
		driver.findElement(Description).sendKeys(Slide_des);
		driver.findElement(Url).clear();
		driver.findElement(Url).sendKeys(Slide_Url);


	}

	/**
	 * method to Attach the image by fetching the imageLocation and sending it as keys to Image_upload
	 * @param Update_imageLocation
	 * @throws InterruptedException
	 */
	public void attach_File2(String Update_imageLocation) throws InterruptedException{
		Thread.sleep(2000);
		driver.findElement(Image_upload).sendKeys(Update_imageLocation);
		Thread.sleep(3000);

		driver.findElement(Update_slide).click();
		driver.findElement(Ok).click();



	}
	/**
	 * method to get the text of the pop up for validation purpose
	 * @return
	 */
	public String Successmessage(){
		try {
			return driver.findElement(Actualmessage).getText();
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * method to delete the Slide by click on the slide to be deleted and the clicking on the delete icon 
	 * @throws InterruptedException
	 */
	public void Delete_slide() throws InterruptedException{
		driver.findElement(Deleting_Slide).click();
		driver.findElement(Delete_icon).click();
		driver.findElement(Delete_ok).click();
		Thread.sleep(3000);

	}
	/**
	 * method to read the text whixh says slide deleted successfully for validation purpose
	 * @return
	 */
	public String Success_message(){
		try {
			return driver.findElement(Act_message).getText();
		} catch (Exception e) {
			return null;
		}
	}
	/**
	 * method for adding the notification by filling up below parameters
	 * @param NotificationTitle
	 * @param NotificationDescription
	 * @throws InterruptedException
	 */
	public void Add_Notification(String NotificationTitle, String NotificationDescription)throws InterruptedException{
		driver.findElement(Add_notifi).click();
		driver.findElement(Add_New_Notification).click();
		driver.findElement(Notification_Title).sendKeys(NotificationTitle);
		driver.findElement(Notification_descptn).sendKeys(NotificationDescription);
		driver.findElement(Dropdown).click();
		driver.findElement(Value_onsite).click();
		driver.findElement(Send_Notification).click();
		Thread.sleep(3000);

	}

	/**
	 * method to get the text of pop up 
	 * @return
	 */
	public String NotificationSentSuccessfulmessage(){
		try {
			return driver.findElement(NotificationSentSuccessful_message).getText();
		} catch (Exception e) {
			return null;
		} 
	}
	/**
	 * method for deleting a notification
	 * @throws InterruptedException
	 */
	public void Delete_Notification()throws InterruptedException{
		driver.findElement(Noti_to_be_deleted).click();
		driver.findElement(Delete_Notification).click();
		driver.findElement(Delete_noti_Ok).click();

		Thread.sleep(3000);

	}

	/**
	 *  method to get the text of pop up 
	 * @return
	 */
	public String NotificationDelSuccessfulmessage(){
		try {
			return driver.findElement(Notification_deleted_successfully).getText();
		} catch (Exception e) {
			return null;
		} 

	}

	/**
	 * method for Deactivating a slide
	 * @throws InterruptedException
	 */
	public void InActivate_slide()throws InterruptedException{
		driver.findElement(Slider).click();
		Thread.sleep(3000);
		driver.findElement(Current_tab).click();
		Thread.sleep(3000);
		driver.findElement(Existing_slide).click();
		Thread.sleep(3000);
		driver.findElement(Toggle_button).click();
		driver.findElement(UpdateSlideStatus_InActive).click();
		Thread.sleep(3000);
	}

	/**
	 * method to get text of the pop up which says slide ahs moved to history
	 * @return
	 */
	public String SlideMovedto_History(){
		try {
			return driver.findElement(Slide_moved_history).getText();
		} catch (Exception e) {
			return null;
		} 

	}
	/**
	 * method to check where the deactivated slide has moved to history tab
	 * @throws InterruptedException
	 */
	public void InActivate_slide_InHistoryTab() throws InterruptedException{
		driver.findElement(Slider).click();
		Thread.sleep(3000);
		driver.findElement(History_Tab).click();
		Thread.sleep(3000);
		driver.findElement(Slide_movedinHistory_afterInactivation).click();

	}

	/**
	 * method to check the deactivated slide is present in history tab or not
	 * @return
	 */
	public boolean Is_elementpresent(){
		try{
			driver.findElement(Slide_movedinHistory_afterInactivation);
			return true;
		}
		catch(Exception e){
			return false;
		}}

	/**
	 * method to Activate a slide which is deactivated and present in history tab
	 * @throws InterruptedException
	 */
	public void Slide_InHistoryTab() throws InterruptedException{
		driver.findElement(Slider).click();
		Thread.sleep(3000);
		driver.findElement(History_Tab).click();
		Thread.sleep(3000);
		driver.findElement(Slide_movedinHistory_afterInactivation).click();
		driver.findElement(InActive_toggle_btn).click();
		driver.findElement(Update_slideStatus_Active_Ok).click();
		Thread.sleep(3000);
	}

	/**
	 * method to get text of pop up says slide moved to current, for validation purpose
	 * @return
	 */
	public String SlideMovedto_Current(){
		try {
			return driver.findElement(Slide_moved_Current).getText();
		} catch (Exception e) {
			return null;
		} 
	}

	/**
	 * method to resend the Notification
	 * @throws InterruptedException
	 */
	public void ResendNotification() throws InterruptedException{
		driver.findElement(Notification_ToResend).click();
		driver.findElement(Resend_Notification).click();
		driver.findElement(Resend_Ok).click();
		Thread.sleep(3000);
		driver.findElement(Notification_ToResend).click();

	}

	/**
	 * method to fetch the notification sent count in order to validate that it has been resent
	 * @return
	 */
	public boolean Is_Elementpresent(){
		try{
			driver.findElement(Notification_sent_count);
			return true;
		}
		catch(Exception e){
			return false;
		}}

	public void Click_On_Content(String ContentTitle, String ContentDescription, String Content_URL, String Fb_URL, String Insta_Url, String Twitter_URL) throws InterruptedException{

		driver.findElement(Content_tab).click();
		driver.findElement(Add_New_Content).click();
		//driver.findElement(Content_Title).click();
		driver.findElement(Content_Title).sendKeys(ContentTitle);
		//driver.findElement(Content_Description).click();
		driver.findElement(Content_Description).sendKeys(ContentDescription);
		driver.findElement(Content_Url).sendKeys(Content_URL);
		driver.findElement(Facebook_url).sendKeys(Fb_URL);
		driver.findElement(Instagram_url).sendKeys(Insta_Url);
		driver.findElement(Twitter_url).sendKeys(Twitter_URL);
		//driver.findElement(ChooseImage).click();


	}

	public void attach_File3(String Content_image) throws InterruptedException{
		Thread.sleep(2000);
		driver.findElement(Image_upload).sendKeys(Content_image);
		Thread.sleep(3000);

		/*driver.findElement(By.xpath("//form/div[2]")).click();
 				WebElement Element1 =	driver.findElement(By.xpath("//form/div[2]/button[2]"));
		 */ 				

		/*JavascriptExecutor js = (JavascriptExecutor) driver;
		 WebElement Element2 = driver.findElement(By.xpath("//span[contains(text(),'Save Content')]"));
		 js.executeScript("arguments[0].scrollIntoView();", Element2);
		 Element2.click();*/

		driver.switchTo().activeElement().sendKeys(Keys.PAGE_DOWN);
		Thread.sleep(3000);
		driver.switchTo().activeElement().sendKeys(Keys.PAGE_DOWN);
		driver.findElement(By.xpath("//span[contains(text(),'Save Content')]")).click();

	}


public void click_save() throws InterruptedException{
	driver.switchTo().activeElement().sendKeys(Keys.PAGE_DOWN);
	Thread.sleep(3000);
	driver.switchTo().activeElement().sendKeys(Keys.PAGE_DOWN);
	driver.findElement(By.xpath("//span[contains(text(),'Save Content')]")).click();
}



}


























