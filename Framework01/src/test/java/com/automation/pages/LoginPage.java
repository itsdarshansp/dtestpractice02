package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	WebDriver driver;
	
	public void LoginPage(WebDriver driver) {
		this.driver= driver;
	}
	
	@FindBy(name="username") WebElement uname;
	
	@FindBy(name="password") WebElement pswd;
	
	@FindBy(xpath="//input[@value='Login']") WebElement loginBtn;
	
	public void loginToCRM(String usernameApplication,String usernamePassword) {
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		uname.sendKeys(usernameApplication);
		pswd.sendKeys(usernamePassword);
		loginBtn.click();
	}
}
