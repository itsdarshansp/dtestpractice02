package com.automation.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automation.pages.BaseClass;
import com.automation.pages.LoginPage;
import com.automation.utilities.BrowserFactory;
import com.automation.utilities.ExcelDataProvider;

public class LoginTestCRM extends BaseClass {
	
	@Test
	public void loginApp() {
		
		LoginPage loginpage= PageFactory.initElements(driver, LoginPage.class);
		
		loginpage.loginToCRM(datap.getStringData("Sheet1", 0, 0), datap.getStringData("Sheet1", 0, 1));
		
	}
}
