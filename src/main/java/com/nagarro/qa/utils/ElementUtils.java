package com.nagarro.qa.utils;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nagarro.qa.base.BaseTest;
import com.nagarro.qa.driverfactory.DriverFactory;

import io.netty.util.Timeout;

public class ElementUtils extends BaseTest{

	public ElementUtils()
	{
		 PageFactory.initElements(getDriver(browser),this); 
		 		
	}
	
	public void doClick( WebElement webelement)
	{
		webelement.click();
	}
	
	public void doSendkeys(WebElement webelement, String value)
	{
		webelement.sendKeys(value);
	}
	
	public void waitForElementVisible(WebElement webelement, int timeout)
	{
		WebDriverWait wait = new WebDriverWait(getDriver(browser), Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.visibilityOf(webelement));
	}
	
	public void waitForElementClickable(WebElement webelement, int timeout)
	{
		WebDriverWait wait = new WebDriverWait(getDriver(browser), Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.elementToBeClickable(webelement));
	}
	
	public void waitForElementVisiblewithFluentWait(WebElement webelement, int timeout)
	{
		Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriver(browser))
				                      .withTimeout(Duration.ofSeconds(timeout))
				                      .pollingEvery(Duration.ofSeconds(2))
				                      .ignoring(NoSuchElementException.class)
				                      .ignoring(StaleElementReferenceException.class)
				                      .withMessage("Element not found");
		wait.until(ExpectedConditions.visibilityOf(webelement));
				                       
	}
	
}
