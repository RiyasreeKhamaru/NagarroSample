package com.nagarro.qa.listeners;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.nagarro.qa.base.BaseTest;

public class ExtentReportsListeners extends BaseTest implements ITestListener{
	
	
	/*
	 * private static ExtentReports init() { Path path = Paths.get("./Results");
	 * if(!Files.exists(path)) { try { Files.createDirectories(path); }
	 * catch(Exception e) { e.printStackTrace(); } } extentreport = new
	 * ExtentReports(); ExtentSparkReporter report = new
	 * ExtentSparkReporter(System.getProperty("user.dir")+
	 * "/Results/ExtentReport.html"); extentreport.attachReporter(report);
	 * extentreport.setSystemInfo("Author", "Riyasree"); return extentreport;
	 * 
	 * }
	 */
	
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(result.getMethod().getMethodName() + " started..");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		extentreport.createTest("Screenshot for Passed method "+result.getMethod().getMethodName())
		  .pass(MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot()).build());		  

	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		extentreport.createTest("Screenshot for failed method "+result.getMethod().getMethodName())
		  .fail(MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot()).build());		  
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+" is skipped...");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {		
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Test Suite Started.." +context.getName());
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Test Suite is finished...");
		
		
		
	}
	
	

}
