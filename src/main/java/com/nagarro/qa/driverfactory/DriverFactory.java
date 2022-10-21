package com.nagarro.qa.driverfactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.nagarro.qa.utils.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	public static Properties prop;
	public static WebDriver driver;
	public static ExtentReports extentreport;
	public static ExtentSparkReporter report;
	public static String browser;
	
	
	/*
	 * public DriverFactory(WebDriver driver) { this.driver = driver; }
	 */
	 
	public static WebDriver getDriver(String browser)
	{
		if(driver==null)
		{
			driver = init_driver(browser);
		}
		return driver;
	}
	
	private static WebDriver init_driver(String browser)
	{
		
		//switch(prop.getProperty("browser"))
		System.out.println("Thread info..."+Thread.currentThread().getId());
		switch(browser)
		{
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
			
		case "Firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "Edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
	    default :
	    	System.out.println("Please pass the correct browser");
	   
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constants.PAGE_LOAD_TIMEOUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.DEFAULT_TIMEOUT));
		driver.get(prop.getProperty("url"));
		return driver;
	}
	
	
	
	
	
	
	public Properties init_prop()
	{
		prop = new Properties();
		try {
			FileInputStream fileIO = new FileInputStream("./src/main/java/com/nagarro/qa/config/config.properties");
			prop.load(fileIO);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return prop;
	}

	
	
	public String captureScreenshot()
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"/Screenshots/" +System.currentTimeMillis()+".png";
		try {
			FileUtils.copyFile(src, new File(path));
		} catch (IOException e) {		
			e.printStackTrace();
		}
		return path;
	}
	
	@BeforeSuite
 	public ExtentReports ExtentReportSetup()
 	{  Path path = Paths.get("./Results");
	   if(!Files.exists(path))
	   {
		   try {
			   Files.createDirectories(path);
		   }
		   catch(Exception e)
		   {
			e.printStackTrace();   
		   }
	   }
	   extentreport = new ExtentReports();
	   report = new ExtentSparkReporter(System.getProperty("user.dir")+"/Results/ExtentReport"+System.currentTimeMillis()+".png");
	   extentreport.attachReporter(report);
	   extentreport.setSystemInfo("Author", "Riyasree");
	   return extentreport;
	  }
}
