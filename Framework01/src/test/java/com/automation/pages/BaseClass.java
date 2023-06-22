package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.automation.utilities.BrowserFactory;
import com.automation.utilities.ConfigDataProvider;
import com.automation.utilities.ExcelDataProvider;
import com.automation.utilities.HelperClass;

public class BaseClass {
	
	public WebDriver driver;
	public ExcelDataProvider datap;
	public ConfigDataProvider configdatap;
	
	@BeforeSuite
	public void setUpSuite() {
		datap= new ExcelDataProvider();
		configdatap= new ConfigDataProvider();
	}
	
	@BeforeClass
	public void setUp() {
		driver=BrowserFactory.startBrowser(driver, configdatap.getBrowser(), configdatap.getURL());
	}
	
	@AfterClass
	public void tearDown() {
		BrowserFactory.quitBrowser(driver);
	}
	
	@AfterMethod
	public void tearDownSuite(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE) {
			HelperClass.captureScreenShot(driver);
			System.out.println("Screenshot captured successfully");
		}
	}
}
