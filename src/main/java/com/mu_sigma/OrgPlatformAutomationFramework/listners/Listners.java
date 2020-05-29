package com.mu_sigma.OrgPlatformAutomationFramework.listners;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;

public class Listners extends TestBase implements ITestListener {
	/*WebDriver driver;

	public Listners(WebDriver driver) {
		this.driver = driver;
	}*/

	public void onFinish(ITestContext result) {
		

	}

	public void onStart(ITestContext result) {
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		

	}

	public void onTestFailure(ITestResult result) {

		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		String methodName = result.getName();

		if (!result.isSuccess()) {
			try {
				File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				String dest = new File(System.getProperty("user.dir")).getAbsolutePath() + "\\failureScreenShot\\";
				File destination = new File(
						(String) dest + methodName + "_" + format.format(calendar.getTime()) + ".png");
				FileUtils.copyFile(source, destination);
				Reporter.log("<a href='" + destination.getAbsolutePath() + "'><img src='"
						+ destination.getAbsolutePath() + "'height='100' width='100'/></a>");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public void onTestSkipped(ITestResult result) {
		Reporter.log("Test Skipped Running"+result.getMethod().getMethodName());

	}

	public void onTestStart(ITestResult result) {
		Reporter.log("Test Started Running"+result.getMethod().getMethodName());

	}

	public void onTestSuccess(ITestResult result) {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		String methodName = result.getName();

		if (result.isSuccess()) {
			try {
				File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				String dest = new File(System.getProperty("user.dir")).getAbsolutePath() + "\\SuccessScreenShot\\";
				File destination = new File(
						(String) dest + methodName + "_" + format.format(calendar.getTime()) + ".png");
				FileUtils.copyFile(source, destination);
				Reporter.log("<a href='" + destination.getAbsolutePath() + "'><img src='"
						+ destination.getAbsolutePath() + "'height='100' width='100'/></a>");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}


	}

}
