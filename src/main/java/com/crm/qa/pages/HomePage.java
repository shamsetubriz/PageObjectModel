/*
 * Author: Shams E. Muhammad
 * 01/05/2018
 */
package com.crm.qa.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//td[contains(text(),'User: Shams Muhammad')]")
	WebElement usernameLabel;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement taxkLink;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateHomePageTitle() {
		return driver.getTitle();	
	}
	
	public boolean verifyUsernameLabel() {
		return usernameLabel.isDisplayed();	
	}
	
	public ContactPage clickOnContactLink() {
		contactsLink.click();
		return new ContactPage();
	}
	
	public DealsPage clickOnDealsLink() {
		dealsLink.click();
		return new DealsPage();	
	}
	
	public TasksPage clickOnTasksLink() {
		taxkLink.click();
		return new TasksPage();
	}	

}
