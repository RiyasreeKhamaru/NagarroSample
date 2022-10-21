package com.nagarro.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nagarro.qa.base.BaseTest;
import com.nagarro.qa.driverfactory.DriverFactory;
import com.nagarro.qa.utils.Constants;
import com.nagarro.qa.utils.ElementUtils;

public class AboutPage extends BaseTest{
	
	@FindBy(xpath="//h1[contains(text(),'Nagarro – we are shaping the company of tomorrow')]") 
	private WebElement compTomoLable;
	
	
	 public AboutPage() 
	 {
		 PageFactory.initElements(getDriver(browser), this);
		 elementutil = new ElementUtils();
	 }
	 
	 public boolean verifyNagarroAboutUsPage()
		{
			
		   elementutil.waitForElementVisible(compTomoLable, Constants.DEFAULT_TIMEOUT);
		   Actions act = new Actions(driver);
		   act.moveToElement(compTomoLable);
		   return compTomoLable.isDisplayed();
			
		}
		

}
