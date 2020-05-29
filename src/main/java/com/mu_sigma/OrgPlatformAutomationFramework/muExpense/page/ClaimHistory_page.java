package com.mu_sigma.OrgPlatformAutomationFramework.muExpense.page;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mu_sigma.OrgPlatformAutomationFramework.TestBase.TestBase;

public class ClaimHistory_page extends TestBase {
	By claimHistoryTab = By.xpath("//a[@href='#/myClaims']");
	By pendingTab = By.xpath("//div[@class='mat-tab-label-content' and contains(text(),'Pending')]");
	By approvedTab = By.xpath("//div[@class='mat-tab-label-content' and contains(text(),'Approved')]");
	By rejectedTab = By.xpath("//div[@class='mat-tab-label-content' and contains(text(),'Rejected')]");
	By specificClaim = By.xpath("//div[@class='claimList']//div[@class='mat-body-1' and contains(text(),'claim1')]");
	

}
