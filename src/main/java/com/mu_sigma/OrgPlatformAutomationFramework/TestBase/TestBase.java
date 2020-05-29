package com.mu_sigma.OrgPlatformAutomationFramework.TestBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.mu_sigma.OrgPlatformAutomationFramework.ExcelReader.ExcelReader;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/**
 * 
 * @author biswajit.kundu
 *
 */
public class TestBase {
	public static WebDriver driver;
	public Properties properties;
	public Properties propetiesOverloadObj;
	public static ExtentReports extentReports;
	public static ExtentTest extentTest;
	FileInputStream fis;
	File file;
	ExcelReader excelReaderObj;

	private static final Logger testBase_pagelog = LogManager.getLogger(TestBase.class.getName());

	public void init(String applicationbURL) throws Exception {
		loadProperties();
		//loadProperties("config.properties");
		selectBroswer(properties.getProperty("Browser"));
		// listnerObj = new Listners(driver);
		getURL(properties.getProperty(applicationbURL));
	}

	// Old Extent reports html report creation code
	/*
	 * static { Calendar calendar = Calendar.getInstance(); SimpleDateFormat
	 * formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss"); extentReports =
	 * new ExtentReports( System.getProperty("user.dir") + "\\report\\test" +
	 * formater.format(calendar.getTime()) + ".html", false); }
	 */

	static {

		extentReports = new ExtentReports(System.getProperty("user.dir") + "\\report\\test" + "report" + ".html", true);
	}

	/**
	 * This method is used to select the browser
	 * 
	 * @throws InterruptedException
	 */
	public void selectBroswer(String browser) throws InterruptedException {
		testBase_pagelog.info(System.getProperty("os.name"));
		if (System.getProperty("os.name").contains("Window")) {
			if (browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + "\\drivers\\geckodriver.exe");
				driver = new FirefoxDriver();
				Thread.sleep(3000);
				testBase_pagelog.info("Firefox Driver initiated");
			} else if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
				driver = new ChromeDriver();
				driver.manage().deleteAllCookies();
				// Below code is use to instantiate the GhostDriver(phantom js)

				/*
				 * System.setProperty("phantomjs.binary.path",System.getProperty
				 * ("user.dir")+"\\phantomjSWindows64bit\\bin\\phantomjs.exe");
				 * driver= new PhantomJSDriver();
				 */

				Thread.sleep(3000);
				testBase_pagelog.info("Chrome Driver initiated");
			}
		} else if (System.getProperty("os.name").equalsIgnoreCase("ubuntu")) {
			if (browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + "\\drivers\\geckodriver.exe");
				driver = new FirefoxDriver();
				Thread.sleep(3000);
				testBase_pagelog.info("Firefox Driver initiated");
			} else if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
				driver = new ChromeDriver();
				Thread.sleep(3000);
				testBase_pagelog.info("Chrome Driver initiated");
			}
		}

	}

	public void getURL(String url) {
		driver.manage().window().maximize();
		testBase_pagelog.info("Maximize the Window");
		driver.get(url);
		testBase_pagelog.info("URL is up and running");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	/**
	 * Load Properties File
	 * 
	 * @throws IOException
	 */
	public void loadProperties() throws IOException {
		file = new File(System.getProperty("user.dir") + "\\propetiesFilerRepository\\appURL.properties");
		fis = new FileInputStream(file);
		properties = new Properties();
		properties.load(fis);
	}

	/**
	 * Load Properties file with propertiesFilename
	 * 
	 * @param propertiesFileName
	 * @throws IOException
	 */
	public void loadProperties(String propertiesFileName) throws IOException {
		file = new File(System.getProperty("user.dir") + "\\propetiesFilerRepository\\" + propertiesFileName);
		fis = new FileInputStream(file);
		propetiesOverloadObj = new Properties();
		propetiesOverloadObj.load(fis);
	}

	public String[][] getData(String excelName, String sheetname) {
		String epath = System.getProperty("user.dir")
				+ "\\src\\main\\java\\com\\mu_sigma\\OrgPlatformAutomationFramework\\data\\" + excelName;
		excelReaderObj = new ExcelReader(epath);
		String[][] data = excelReaderObj.getData(sheetname, excelName);
		return data;
	}

	public void clickWhenElementIsReady(WebDriver driver, int timeOutInSeconds, By locator) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
			// WebElement ele =
			// wait.until(ExpectedConditions.visibilityOf(element));
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			driver.findElement(locator).click();
			testBase_pagelog.info(
					"Application trying to Locate the element :" + locator + "for->" + timeOutInSeconds + "Seconds");
		} catch (Exception e) {
			testBase_pagelog.info(
					"Application unable to Locate the element :" + locator + "for->" + timeOutInSeconds + "Seconds");
			e.printStackTrace();
		}
	}

	public void clickWhenElementIsReady(WebDriver driver, int timeOutInSeconds, WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
			wait.until(ExpectedConditions.visibilityOf(element));
			element.click();
			testBase_pagelog.info(
					"Application trying to Locate the element :" + element + "for->" + timeOutInSeconds + "Seconds");
		} catch (Exception e) {
			testBase_pagelog.info(
					"Application unable to Locate the element :" + element + "for->" + timeOutInSeconds + "Seconds");
			e.printStackTrace();
		}
	}

	/**
	 * This method is used to wait for Element
	 * 
	 * @param timeOutInSeconds
	 * @param element
	 */

	public By waitForElement(By locator, int timeOutInSeconds) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			testBase_pagelog.info("Locacted the element");
			return locator;
		} catch (Exception e) {
			testBase_pagelog.info("Unable Locate the element");
		}
		return locator;
	}

	public WebElement waitForElement(WebElement element, int timeOutInSeconds) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
			wait.until(ExpectedConditions.visibilityOf(element));
			testBase_pagelog.info("Locacted the element");
			return element;
		} catch (Exception e) {
			testBase_pagelog.info("Unable Locate the element");
		}
		return element;
	}

	/**
	 * Legacy file for switching window
	 * 
	 * @return
	 */
	public Iterator<String> getAllWindows() {
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> itr = windows.iterator();
		return itr;
	}

	/**
	 * Switching the Window
	 * 
	 * @param windowNo
	 */
	public void switchWindow(int windowNo) {
		try {
			ArrayList<String> allWindowIds = new ArrayList<String>();
			Set<String> allwindows = driver.getWindowHandles();
			Iterator<String> itr = allwindows.iterator();
			while (itr.hasNext()) {
				allWindowIds.add(itr.next());
			}

			driver.switchTo().window(allWindowIds.get(windowNo));
			testBase_pagelog.info("Switch to window " + windowNo);
		} catch (Exception e) {
			testBase_pagelog.info("Unable to switch window with no" + windowNo);
			e.printStackTrace();
		}
	}

	/**
	 * This method is used Select the Drop down by index
	 * 
	 * @param element
	 * @param indexNo
	 */
	public void selectdropDownByIndex(WebElement element, int indexNo) {
		Select sel = new Select(element);
		List<WebElement> allValues = sel.getOptions();
		int sizeOfList = allValues.size();
		testBase_pagelog.info("Size of the Drop down is" + sizeOfList);
		try {
			for (int i = 0; i < sizeOfList; i++) {
				if (i == indexNo) {
					sel.selectByIndex(i);
					testBase_pagelog.info("Selecting the Drop down by Index no" + i);
					break;
				}
			}
		} catch (Exception e) {
			testBase_pagelog.info("Unable to Selecting the Drop down by Index ");
			e.printStackTrace();
		}
	}

	/**
	 * This method will describe how to select drop down by VisibleText
	 * 
	 * @param locator
	 * @param indexNo
	 */
	public void selectdropDownByVisibleText(WebElement element, String value) {
		Select sel = new Select(element);
		List<WebElement> alloption = sel.getOptions();

		try {
			for (WebElement newAlloptions : alloption) {
				if (newAlloptions.getText().equals(value)) {
					sel.selectByVisibleText(value);
					testBase_pagelog.info(
							"Application able to select the drop down By" + "  :" + value + " ->" + "vissible text");
					break;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			testBase_pagelog
					.info("Application Unable to select the drop down By" + "  :" + value + " ->" + "vissible text");
			e.printStackTrace();
		}
	}

	/**
	 * This method will describe how to select drop down by Value
	 * 
	 * @param locator
	 * @param indexNo
	 */
	public void selectdropDownByValue(WebElement element, String value) {
		Select sel = new Select(element);
		List<WebElement> alloption = sel.getOptions();

		try {
			for (WebElement newAlloptions : alloption) {
				if (newAlloptions.getText().equals(value)) {
					sel.selectByValue(value);
					testBase_pagelog
							.info("Application able to select the drop down By" + "  :" + value + " ->" + "value");
					break;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			testBase_pagelog.info("Application Unable to select the drop down By" + "  :" + value + " ->" + "value");
			e.printStackTrace();
		}
	}

	public static void highlightElement(WebDriver driver, WebElement element) throws InterruptedException {
		// Creating JavaScriptExecuter Interface
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Execute javascript
		js.executeScript("arguments[0].style.border='4px solid yellow'", element);
		Thread.sleep(3000);
		js.executeScript("arguments[0].style.border=''", element);
	}

	/**
	 * This method will capture the screenshots
	 * 
	 * @param fileName
	 * @return
	 */
	public String captureScreen(String fileName) {
		if (fileName == "") {
			fileName = "blank";
		}
		File destFile = null;
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath()
					+ "/src/main/java/com/test/automation/uiAutomation/screenshot/";
			destFile = new File(
					(String) reportDirectory + fileName + "_" + formater.format(calendar.getTime()) + ".png");
			FileUtils.copyFile(scrFile, destFile);
			// This will help us to link the screen shot in testNG report
			Reporter.log("<a href='" + destFile.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath()
					+ "' height='100' width='100'/> </a>");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return destFile.toString();
	}

	public void getResult(ITestResult result) {
		if (result.getStatus() == ITestResult.SUCCESS) {
			extentTest.log(LogStatus.PASS, result.getName() + "Test Is Pass");
		} else if (result.getStatus() == ITestResult.SKIP) {
			extentTest.log(LogStatus.SKIP,
					result.getName() + "Test is Skipped and reason is-:" + result.getThrowable());
		} else if (result.getStatus() == ITestResult.FAILURE) {
			extentTest.log(LogStatus.ERROR,
					result.getName() + "Test is Failed and Reason is: " + result.getThrowable());
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(captureScreen("")));
		} else if (result.getStatus() == ITestResult.STARTED) {
			extentTest.log(LogStatus.INFO, result.getName() + "test is started");
		}
	}
	
	/**
	 * Generic function to upload file 
	 * @param folderName
	 * @param fileName
	 * @param locator
	 */
	
	public void uploadFile(String folderName,String fileName, By locator) {

		String workingDir = System.getProperty("user.dir");
		String filepath = workingDir + "\\"+folderName+"\\" + fileName + "";
		driver.findElement(locator).sendKeys(filepath);

	}

	@BeforeMethod
	public void beforeMethod(Method result) {
		extentTest = extentReports.startTest(result.getName());
		extentTest.log(LogStatus.INFO, result.getName() + "Test Started");
	}

	@AfterMethod
	public void afterMethod(ITestResult result) {
		getResult(result);
	}

	/**
	 * This method is used close the browser and flush the extent report Object
	 */
	public void closeBrowser() {
		driver.quit();
		testBase_pagelog.info("browser closed");
		extentReports.endTest(extentTest);
		extentReports.flush();
	}

	@AfterClass(alwaysRun = true)
	public void endTest() {
		closeBrowser();
	}
}
