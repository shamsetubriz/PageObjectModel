package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//Page factory - Object Repository:
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginButton;
	
	@ FindBy(xpath="//font[contains(text(),'Sign Up')]")
	WebElement signUpBtn;
	
	@FindBy(xpath="//img[contains(@alt,'free crm logo')]")
	WebElement crmLogo;
	
	//Initialization the Page Objects:
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateCRMLogoImage() {
		return crmLogo.isDisplayed();
	}
	
	public HomePage logIn(String un, String pwd) throws InterruptedException {
		username.clear();
		username.sendKeys(un);
		password.clear();
		password.sendKeys(pwd);
		// login button
		WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", loginButton);
		Thread.sleep(2000);
		//loginButton.click();
		
		return new HomePage();
	}	
	
}
