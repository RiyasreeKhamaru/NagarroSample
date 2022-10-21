package com.nagarro.qa.base;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.nagarro.qa.driverfactory.DriverFactory;
import com.nagarro.qa.listeners.ExtentReportsListeners;
import com.nagarro.qa.pages.AboutPage;
import com.nagarro.qa.pages.LaunchPage;
import com.nagarro.qa.utils.ElementUtils;


public class BaseTest extends DriverFactory{
	
	
	public LaunchPage launch;
	public AboutPage aboutus;
	public ElementUtils elementutil;
	
	public BaseTest() 
	  { 
		 super(); 
	  }
	 	
	 @Parameters("browser")
	 @BeforeTest
	 public void setup(String browser)
	{  
		init_prop();
		//init_driver();
		
		driver = getDriver(browser);	
	}
   
	@AfterTest
	public void tear_drown()
	{
		extentreport.flush();
		driver.quit();
	}
	
	
}
