package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactPage extends TestBase{
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement ContactLogo;
	
	@FindBy(xpath="//a[contains(text(),'ayaat shams')]/parent::td//preceding-sibling::td//input[@type='checkbox']")
	WebElement ayaatShamsCheckBox;
	
	@FindBy(xpath="/a[contains(text(),'qurrat shams')]//parent::td//preceding-sibling::td//input[@type='checkbox']")
	WebElement qurratShamsCheckBox;
	
	public ContactPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactLogo() {
		
		return ContactLogo.isDisplayed();	
	}
	
	//If I have a hundred contact, I am not going to use 100 @FindBy; 
	//instead I would hard code the locator directly to the code the following way.
	
	public void selectContactByName(String name) {
		driver.findElement(By.xpath("//a[contains(text(),'"+name+"')]/parent::td//"
				+ "preceding-sibling::td//input[@type='checkbox']")).click();
	}

}
