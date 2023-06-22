package com.automation.utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class HelperClass {
	
	public static void captureScreenShot(WebDriver driver) {
		
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try {
			FileHandler.copy(src, new File("./Screenshot/FreeCRM_"+getDateTimeStamp()+"_Login.png"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to get screenshot "+e.getMessage());
		}	
	}
	
	public static String getDateTimeStamp() {
		DateFormat customformat= new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		
		Date currentdate= new Date();
		
		return customformat.format(currentdate);
	}
}
