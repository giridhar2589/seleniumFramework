package com.mu_sigma.OrgPlatformAutomationFramework.muCab.page;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
/**
 * 
 * @author giridhar.kc
 *
 */


public class MuCabHome_page {
	WebDriver driver;
	public static final Logger MuCabHome_pageLog = LogManager.getLogger(MuCabHome_page.class.getName());
	
	
	
	By username_inputBox= By.id("username");
	By InputUserName = By.xpath("//input[@id='UserId']");
	By InputPassword = By.xpath("//input[@id='UserPass']");
	By  SubmitBtn = By.xpath("//button[@value='Login']");
	By   LogoMuCab= By.xpath("//label[contains(text(),'Book Your Ride')]");
	By  Logout=  By.xpath("//a[contains(text(),'Logout')]");
	By   Dropdown= By.xpath("//span[@id='dropdownuser']/span");
	By  RequestTab=  By.xpath("//a[contains(text(),'Requests')]");
	By   Source= By.xpath("(//*[@id='ddsource'])[1]");
	By  CancelBtn =  By.xpath("(//td[4]/input)[1]");
	public By  TextBob_EmpID=  By.xpath("//input[@id='txtempid']");
	public By   SearchIcon_EmpID= By.xpath("//span[@title='Enter the employee first name and search']");
	public By  Btn_AddSelected = By.xpath("//input[@value='Add Selected']");
	public By CancelPopUp_EmpID =  By.xpath("//i[@id='CancelSearch']");
	By   Checkbox_EntireBookingperiod = By.xpath("//input[@id='chkEntireperiod']");
	By   Btn_AddOrEditRequest= By.xpath("//input[@id='btnSave']");
	public By   Btn_add = By.xpath("(//input[@value='Add'])[2]");
	By   Btn_UpdateEmployeeDestination = By.xpath("//a[contains(text(),'Update Employee Destination')]");
	By  TextBoox_EnterEmpID=  By.xpath("//*[@id='adminDestination']");
	By  Btn_SearchEmpID =  By.xpath("//*[@id='AdminUpdateDestination']");
	By  TextBoox_Destination = By.xpath("//*[@id='AdminTextDestination']");
	By   btn_UpdateDestination= By.xpath("//*[@id='buttonAdminRequest']");
	By  btn_save=  By.xpath("//input[@value='Save']");
	By  Textbox_EmpID=  By.xpath("//*[@id='inputempid']");
	By  Modify_btn=  By.xpath("(//td[3]/input)[1]");
	By  Allocation_tab=  By.xpath("//a[contains(text(),'Allocation')]");
	public By   Boarding_tab=By.xpath("//a[contains(text(),'Boarding')]");
	By  Roaster_Details=  By.xpath("(//div[@class='form-group Roster']//input)[3]");
	By  Generate_Alloaction=  By.xpath("//input[@value='Generate Allocation']");
	By   btn_Move= By.xpath("//input[@id='btnMerge']");
	By  Boarding_changes =  By.xpath("(//td/h3[contains(text(),'Boarding Changes')])[2]");
	By   btn_Create_new_cab = By.xpath("//input[@value='Create']");
	public By   btn_Create_new_trip =By.xpath("//input[@value='Create New Trip']");
	By  btn_Move_cab=  By.xpath("//input[@value='Move Selected']");
	By  btn_Save_allocation = By.xpath("//input[@id='btnSaveAllocation']");
	public By  btn_Send_Notification =  By.xpath("//a[contains(text(),'SEND NOTIFICATIONS')]");
	public By  btn_DownLoad_TripSheet =  By.xpath("//a[contains(text(),'DOWNLOAD TRIP SHEET')]");
	public By   btn_Save = By.xpath("//input[@id='buttonSave']");
	By   btn_yes= By.xpath("//td/span[2]/span[1]");
	By   btn_Save_boarding_status = By.xpath("//input[@value='Save Boarding Updates']");
	////////////////////////////////////////
	//Vehical Details page xpath
	By Settings_Tab =  By.xpath("//a[text()='Settings ']");
	By   Vehical_Details_DropDown = By.xpath("//a[text()='Vehicle Details']");
	By   Add_Vehical_Btn= By.xpath("//input[@value='Add Vehicle']");
	By   Vehical_Name= By.xpath("//input[@id='txtVehicleName']");
	By   Vehical_RegistrationNumber = By.xpath("//input[@id='txtRegnNum']");
	By  Insurance_Issue_Date = By.xpath("//input[@id='txtinsissue']");
	By  Insurance_Expiry_Date = By.xpath("//input[@id='txtinsexpiry']");
	By   Emission_Test_Issue_Date = By.xpath("//input[@id='txtEmissnIssue']");
	By  Emission_Test_Expiry_Date=  By.xpath("//input[@id='txtEmissionExpiry']");
	By  Vehicle_Tax_Issue_Date =  By.xpath("//input[@id='txtVehTaxIssue']");
	By   Vehicle_Tax_Expiry_Date = By.xpath("//input[@id='txtvehTaxExpiry']");
    By   Fitness_Certificate_Issue_Date= By.xpath("//input[@id='txtfitnessIssue']");
    By  Fitness_Certificate_Expiry_Date =  By.xpath("//input[@id='txtfitnessExpiry']");
	By Permit_Issue_Date =  By.xpath("//input[@id='txtPermitIssue']");
	By Permit_Expiry_Date=  By.xpath("//input[@id='txtPermitExpiry']");
	/////////////////////////////////Driver Details Xpaths /////////////////////////////////////////////////
	By   DriverName= By.xpath("//input[@id='txtDrvName']");
	By DriverFatherName =  By.xpath("//input[@id='txtDrvFatherName']");
	By DriverDOB =  By.xpath("//input[@id='txtDrvDOB']");
	By  DriverEduDetails=  By.xpath("//input[@id='txtDrvEdnDetail']");
	By  DriverMObDetails =  By.xpath("//input[@id='txtMobNum']");
	By  TemproryAddress= By.xpath("//textarea[@name='TempAddress']");
	By   PermemanetAddress= By.xpath("//textarea[@name='PermAddress']");
	

	///////////////////////////////////////////////////////Driver Details///////////////////////////
	By BadgeNumber =  By.xpath("//input[@id='txtBadgeNum']");
	By BadgeExpryDate=   By.xpath("//input[@id='txtBadgeExpiry']");
	By LicenseNumber = By.xpath("//input[@id='txtLiscNum']");
	By  LicenseExpiryDate =  By.xpath("//input[@id='txtLiscExp']");
	By JoiningDate =  By.xpath("//input[@id='txtJoinDate']");
	By  PerviousCmpyName =  By.xpath("//input[@id='txtPrevCompany']");
	By   TtlExperience = By.xpath("//input[@id='txtTotalExp']");
	By ChooseFile =  By.xpath("//input[@id='addressproof']");
	By Upload_Btn =  By.xpath("(//input[@title='Upload'])[2]");



	public MuCabHome_page(WebDriver driver) {
		this.driver = driver;

	}


	/*
	 * This function is used to Click the submit button of muCab Application
	 */


	public void Enter_Into_Application(){
		
		driver.findElement(SubmitBtn).click();
	}


	/*
	 * This function is used to Click the modify button of muCab Application
	 */


	public void Click_modifybutton(){
		driver.findElement(Modify_btn).click();
	}


	/*
	 * This function is used to Click the Save button of muCab Application
	 */
	public void Click_button_save(){
		driver.findElement(btn_save).click();
	}


	/*
	 * This function is used to Click the Cancel button of muCab Application
	 */
	public void Click_button_Cancel(){
		driver.findElement(CancelBtn).click();
	}

	/*
	 * This function is used to Click the CancelpopUP button of muCab Application
	 */
	public void Click_button_CancelpopUP(){
		driver.findElement(CancelPopUp_EmpID).click();
	}

	/*
	 * This function is used to Click the Check box button of muCab Application
	 */

	public void Checkbox_EntireBookingperiod(){
		driver.findElement(Checkbox_EntireBookingperiod).click();
	}


	/*
	 * This function is used to Click the check add or edit  button of muCab Application
	 */

	public void Btn_AddOrEditRequest(){
		driver.findElement(Btn_AddOrEditRequest).click();
	}

	/*
	 * This function is used to Click the allocation button of muCab Application
	 */

	public void EnterIntoAllcation(){
		driver.findElement(Allocation_tab).click();
	}

	/*
	 * This function is used to Click the Generateallocaiton  button of muCab Application
	 */

	public void GenerateAlloaction(){
		driver.findElement(Generate_Alloaction).click();
	}


	/*
	 * This function is used to Click the Move button of muCab Application
	 */
	public void btn_Move(){
		driver.findElement(btn_Move).click();
	}

	/*
	 * This function is used to Click the CreateNewCab button of muCab Application
	 */

	public void btn_Create_new_cab(){
		driver.findElement(btn_Create_new_cab).click();
	}

	/*
	 * This function is used to Click the Save button of muCab Application
	 */
	public void btn_save(){
		driver.findElement(btn_save).click();
	}

	/*
	 * This function is used to Click the Save Allocation button of muCab Application
	 */
	public void btn_Save_allocation(){
		driver.findElement(btn_Save_allocation).click();
	}

	/*
	 * This function is used to Click the TextBox button of muCab Application
	 */

	public void TextBob_EmpID() throws InterruptedException{
		Thread.sleep(2000);
		driver.findElement(TextBob_EmpID).click();
	}


	/*
	 * This function is used to Click the Yes button of muCab Application
	 */
	public void btn_yes() throws InterruptedException{
		Thread.sleep(2000);
		driver.findElement(btn_yes).click();
	}

	/*
	 * This function is used to Click the Save button of muCab Application
	 */

	public void btn_Save_boarding_status(){
		driver.findElement(btn_Save_boarding_status).click();
	}



	/*
	 * This function is used to Click the Move button of muCab Application
	 */
	public void btn_Move_cab(){
		driver.findElement(btn_Move_cab).click();
	}



	/*
	 * This function is used to login to the muCab Application
	 */


	public void fillLoginDetails(String uname, String pwd) throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(InputUserName).clear();
		driver.findElement(InputUserName).sendKeys(uname);
		MuCabHome_pageLog.info("Filled the Username");
		driver.findElement(InputPassword).clear();
		driver.findElement(InputPassword).sendKeys(pwd);
		MuCabHome_pageLog.info("Filled the Password");
		driver.findElement(SubmitBtn).click();
		MuCabHome_pageLog.info("Clicked on the Submit button");
	}



	/*
	 * This function is to check wheater the logo is present in the home page.
	 * 
	 */
	public String pass() {

		String ele = driver.findElement(LogoMuCab).getText();
		return ele;
	}

	/*
	 * This funciton is to search the employee using empID as a key in Request page. 
	 */

	public void searchEmpdId(String Emp) throws InterruptedException{
		MuCabHome_pageLog.info("In Home page");
		Thread.sleep(2000);
		driver.findElement(RequestTab).click();
		MuCabHome_pageLog.info("Enter Inside the Request Tab");
		Thread.sleep(10000);
		driver.findElement(TextBob_EmpID).click();
		MuCabHome_pageLog.info("Enter Inside the Text Box of Search EMP ID or name");
		Thread.sleep(3000);
		driver.findElement(TextBob_EmpID).sendKeys(Emp);
		Thread.sleep(3000);
		MuCabHome_pageLog.info("Employee ID has been Entred");
		driver.findElement(SearchIcon_EmpID).click();

	}


	/*
	 * This funciton is to Update the employee using empID as a key in Request page. 
	 */

	public void UpdateEmpdAddress(String Emp, String  Destination) throws InterruptedException{
		driver.findElement(Btn_UpdateEmployeeDestination).click();
		driver.findElement(TextBoox_EnterEmpID).click();
		driver.findElement(TextBoox_EnterEmpID).sendKeys(Emp);
		driver.findElement(Btn_SearchEmpID).click();
		Thread.sleep(2000);
		driver.findElement(TextBoox_Destination).click();
		driver.findElement(TextBoox_Destination).sendKeys(Destination);
		driver.findElement(btn_UpdateDestination).click();
	}

	/*
	 * This funciton is to Enter the roaster details. 
	 */

	public void EnterRoasterDetails()
	{
		driver.findElement(Roaster_Details).click();
		driver.findElement(Roaster_Details).clear();
		driver.findElement(Roaster_Details).sendKeys("30");
	}
	/*
	 * This function is to select(checks) requests present in the allocation Page  
	 */


	public void SelectRequest()throws InterruptedException{
		Thread.sleep(2000);
		for (int i=5;i<=9;i++)

			driver.findElement(By.xpath("(//*[@id='emprows']/td[7]/div/input)["+i+"]")).click();
		Thread.sleep(2000);
	}

	/*
	 * This function is to select(checks) single  requests present in the allocation Page  
	 */
	public void SelectRequest_Single()throws InterruptedException{
		Thread.sleep(2000);
		for (int i=5;i<=6;i++)
			driver.findElement(By.xpath("(//*[@id='tdMove']/div)["+i+"]")).click();
		Thread.sleep(2000);
	}

	/*
	 * This function is to select(checks) requests present in the allocation Page to move requests  
	 */
	public void SelectRequest_multiple()throws InterruptedException{
		Thread.sleep(2000);
		for (int i=5;i<=10;i++)
			driver.findElement(By.xpath("(//*[@id='tdMove']/div)["+i+"]")).click();
	}

	/*
	 * This function is to logout in the application 
	 */

	public void logout() throws InterruptedException{
		driver.findElement(Dropdown).click();
		MuCabHome_pageLog.info("clicked on dropDown");
		Thread.sleep(3000);
		driver.findElement(Logout).click();
		MuCabHome_pageLog.info("clicked on Logout Button");
	}


	public void Enter_Into_Vehical_details() throws InterruptedException{
		Thread.sleep(3000);
		driver.findElement(Settings_Tab).click();
		Thread.sleep(2000);
		driver.findElement(Vehical_Details_DropDown).click();
	}

	public void Add_vehical(){
		driver.findElement(Add_Vehical_Btn).click();
	}

	public void Enter_Vehical_Details_Vehical_Type( String VehicalName, String CarType,String RegistrationNumber, String VendorType, String Location) throws InterruptedException{

		driver.findElement(Vehical_Name).click();
		driver.findElement(Vehical_Name).sendKeys(VehicalName);
		Select  sel = new Select (driver.findElement(By.id("ddVehicleType")));
		sel.selectByVisibleText(CarType);
		driver.findElement(Vehical_RegistrationNumber).click();
		driver.findElement(Vehical_RegistrationNumber).sendKeys(RegistrationNumber);
		Select  sel1 = new Select (driver.findElement(By.id("ddvendor")));
		sel1.selectByVisibleText(VendorType);
		Thread.sleep(3000);
		Select  sel2 = new Select (driver.findElement(By.id("ddsrcloc")));
		sel2.selectByVisibleText(Location);
	}



	public void Vehicle_Document_Tenure_Details(String IIssueDate,String IExpiryDate,String EIssue,String EExpiryDate,String TIssueDate, String TExpiryDate,String FIssueDate,  String FExpiryDate, String PIssueDate, String PExpiryDate) throws InterruptedException{
		Thread.sleep(3000);
		driver.findElement(Insurance_Issue_Date).click();
		driver.findElement(By.xpath("//a[text()='3']")).click();
		//Insurance_Issue_Date.sendKeys(IIssueDate);
		Thread.sleep(3000);
		driver.findElement(Insurance_Expiry_Date).click();
		driver.findElement(Insurance_Expiry_Date).sendKeys(IExpiryDate);
		Thread.sleep(3000);
		driver.findElement(Emission_Test_Issue_Date).click();
		driver.findElement(Emission_Test_Issue_Date).sendKeys(EIssue);
		Thread.sleep(3000);
		driver.findElement(Emission_Test_Expiry_Date).click();
		driver.findElement(Emission_Test_Expiry_Date).sendKeys(EExpiryDate);
		Thread.sleep(3000);
		driver.findElement(Vehicle_Tax_Issue_Date).click();
		driver.findElement(Vehicle_Tax_Issue_Date).sendKeys(TIssueDate);
		Thread.sleep(3000);
		driver.findElement(Vehicle_Tax_Expiry_Date).click();
		driver.findElement(Vehicle_Tax_Expiry_Date).sendKeys(TExpiryDate);
		Thread.sleep(3000);
		driver.findElement(Fitness_Certificate_Issue_Date).click();
		driver.findElement(Fitness_Certificate_Issue_Date).sendKeys(FIssueDate);
		Thread.sleep(3000);
		driver.findElement(Fitness_Certificate_Expiry_Date).click();
		driver.findElement(Fitness_Certificate_Expiry_Date).sendKeys(FExpiryDate);
		Thread.sleep(3000);
		driver.findElement(Permit_Issue_Date).click();
		driver.findElement(Permit_Issue_Date).sendKeys(PIssueDate);
		Thread.sleep(3000);
		driver.findElement(Permit_Expiry_Date).click();
		driver.findElement(Permit_Expiry_Date).sendKeys(PExpiryDate);

	}


	public void Document_Tenure_Details() throws InterruptedException{
		Thread.sleep(3000);
		driver.findElement(Insurance_Issue_Date).click();
		driver.findElement(By.xpath("//a[text()='3']")).click();
		//Insurance_Issue_Date.sendKeys(IIssueDate);
		Thread.sleep(3000);
		driver.findElement(Insurance_Expiry_Date).click();
		//	Insurance_Expiry_Date.sendKeys(IExpiryDate);
		driver.findElement(By.xpath("//a[text()='5']")).click();
		Thread.sleep(3000);
		driver.findElement(Emission_Test_Issue_Date).click();
		//	Emission_Test_Issue_Date.sendKeys(EIssue);
		driver.findElement(By.xpath("//a[text()='3']")).click();
		Thread.sleep(3000);
		Thread.sleep(3000);
		driver.findElement(Emission_Test_Expiry_Date).click();
		//	Emission_Test_Expiry_Date.sendKeys(EExpiryDate);
		driver.findElement(By.xpath("//a[text()='5']")).click();
		Thread.sleep(3000);
		driver.findElement(Vehicle_Tax_Issue_Date).click();
		//	Vehicle_Tax_Issue_Date.sendKeys(TIssueDate);
		driver.findElement(By.xpath("//a[text()='3']")).click();
		Thread.sleep(3000);
		driver.findElement(Vehicle_Tax_Expiry_Date).click();
		//	Vehicle_Tax_Expiry_Date.sendKeys(TExpiryDate);
		driver.findElement(By.xpath("//a[text()='5']")).click();
		Thread.sleep(3000);
		driver.findElement(Fitness_Certificate_Issue_Date).click();
		//	Fitness_Certificate_Issue_Date.sendKeys(FIssueDate);
		driver.findElement(By.xpath("//a[text()='3']")).click();
		Thread.sleep(3000);
		driver.findElement(Fitness_Certificate_Expiry_Date).click();
		//	Fitness_Certificate_Expiry_Date.sendKeys(FExpiryDate);
		driver.findElement(By.xpath("//a[text()='5']")).click();
		Thread.sleep(3000);
		driver.findElement(Permit_Issue_Date).click();
		//	Permit_Issue_Date.sendKeys(PIssueDate);
		driver.findElement(By.xpath("//a[text()='3']")).click();
		Thread.sleep(3000);
		driver.findElement(Permit_Expiry_Date).click();
		//	Permit_Expiry_Date.sendKeys(PExpiryDate);
		driver.findElement(By.xpath("//a[text()='5']")).click();

	}

	public void Driver_details(String DriverName1, String DriverFatherName1, String EduDetails , String Status , String MobileNumber , String TAddresss, String Paddress) throws InterruptedException{

		driver.findElement(DriverName).click();
		driver.findElement(DriverName).sendKeys(DriverName1);
		driver.findElement(DriverFatherName).click();
		driver.findElement(DriverFatherName).sendKeys(DriverFatherName1);
		driver.findElement(DriverDOB).click();
		driver.findElement(By.xpath("//a[text()='5']")).click();
		Thread.sleep(3000);
		Thread.sleep(3000);
		driver.findElement(DriverEduDetails).click();
		driver.findElement(DriverEduDetails).sendKeys(EduDetails);
		Select  sel = new Select (driver.findElement(By.id("ddDrvMarStatus")));
		sel.selectByVisibleText(Status);
		driver.findElement(DriverMObDetails).click();
		driver.findElement(DriverMObDetails).sendKeys(MobileNumber);
		driver.findElement(TemproryAddress).click();
		driver.findElement(TemproryAddress).sendKeys(TAddresss);
		driver.findElement(PermemanetAddress).click();
		driver.findElement(PermemanetAddress).sendKeys(Paddress);
	}

	public void Driver_Professional_Info(String badgeNum, String LiceNum, String PerviousCmpyName1 , String TtlExperience1, String Offence, String Upload) throws InterruptedException, IOException{
		Thread.sleep(3000);
		driver.findElement(BadgeNumber).click();
		driver.findElement(BadgeNumber).sendKeys(badgeNum);
		driver.findElement(BadgeExpryDate).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='3']")).click();
		driver.findElement(LicenseNumber).click();
		driver.findElement(LicenseNumber).sendKeys(LiceNum);
		driver.findElement(LicenseExpiryDate).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='3']")).click();
		driver.findElement(JoiningDate).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='3']")).click();
		driver.findElement(PerviousCmpyName).click();
		driver.findElement(PerviousCmpyName).sendKeys(PerviousCmpyName1);
		driver.findElement(TtlExperience).click();
		driver.findElement(TtlExperience).sendKeys(TtlExperience1);
		Thread.sleep(3000);
		driver.findElement(By.id("ddPastCriminaloff")).click();
		Select  sel = new Select (driver.findElement(By.id("ddPastCriminaloff")));
		sel.selectByVisibleText(Offence);
		Thread.sleep(3000);
		driver.findElement(By.id("ddAddrPFlbl")).click();
		Select  sel1 = new Select (driver.findElement(By.id("ddAddrPFlbl")));
		sel1.selectByVisibleText(Upload);
		Thread.sleep(3000);
		driver.findElement(ChooseFile).click();
		Thread.sleep(3000);
		Runtime.getRuntime().exec(System.getProperty("user.dir") + "\\autoit\\group.exe");
		Thread.sleep(5000);
		driver.findElement(Upload_Btn).click();
		Thread.sleep(3000);
		driver.findElement(btn_save).click();

	}
}
