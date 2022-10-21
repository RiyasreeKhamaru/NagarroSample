package com.nagarro.qa.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nagarro.qa.base.BaseTest;
import com.nagarro.qa.driverfactory.DriverFactory;
import com.nagarro.qa.utils.Constants;
import com.nagarro.qa.utils.ElementUtils;

public class LaunchPage extends BaseTest
{

	// Page object or private locator
	// private By aboutusBtn = By.xpath("//a//span[text()='About us']");
	// private By nagarrolable = By.xpath("//div[contains(@class,'mobile')]//h1");

	@FindBy(xpath = "//div[contains(@class,'mobile')]//h1")
	private WebElement nagarrolable;
	@FindBy(xpath = "//div//a[contains(@href,'/about/about-us')]/span")
	private WebElement aboutusBtn;
	@FindBy(xpath = "//div[@class='cookie-box']//a[contains(text(),'Accept all')]")
	private WebElement cookieBox;
	@FindBy(xpath="//h1[contains(text(),'Nagarro – we are shaping the company of tomorrow')]") 
	private WebElement compTomoLable;
	
	
	
	
	  public LaunchPage() {
		  PageFactory.initElements(getDriver(browser),this); 
		  elementutil = new ElementUtils();
		  }
	 			
	// Page action

	public String launchNagarroWebsiteValidation() {
		
		elementutil.doClick(cookieBox);		
		System.out.println(driver.getTitle());
		return driver.getTitle();
	}

	public String verifyNagarroLable()
	{
		System.out.println(nagarrolable.getText());		
		return nagarrolable.getText();
	}

	/*
	 * public AboutPage clickAboutUsBtn() throws InterruptedException {
	 * Thread.sleep(5000); Actions act = new Actions(driver);
	 * act.scrollToElement(aboutusBtn).click(); return new AboutPage(); }
	 */
	/*
	 * public AboutPage clickAboutUsBtn() throws InterruptedException {
	 * Thread.sleep(5000); JavascriptExecutor js=(JavascriptExecutor)driver;
	 * js.executeScript("argument[0].style.border='5px solid red'",aboutusBtn);
	 * js.executeScript("argument[0].click();",aboutusBtn ); //aboutusBtn.click();
	 * return new AboutPage(); }
	 */
	public AboutPage clickAboutUsBtn()
	{		
		
		  try { Thread.sleep(5000); } catch (InterruptedException e) {
		  e.printStackTrace(); }
		 
		Actions act = new Actions(driver);
		act.moveToElement(aboutusBtn).click().build().perform();
		return aboutus;		
	}
	
	
}
