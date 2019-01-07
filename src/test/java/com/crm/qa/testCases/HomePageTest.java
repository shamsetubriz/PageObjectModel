/*
 * Author: Shams E. Muhammad
 * 01/05/2018
 */
package com.crm.qa.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactPage contactPage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		homePage = loginPage.logIn(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		String hpTitle = homePage.validateHomePageTitle();
		//We can Always pass a second String argument with the testNG assertion, which I have 
		//passed here. It will only show at the time when the test case is failed.
		Assert.assertEquals(hpTitle, "CRMPRO", "Home Page title is not Matched");
	}
	
	@Test(priority = 2)
	public void verifyUsernameLabelTest() {
		testUtil.swichToMainFrame();
		Assert.assertTrue(homePage.verifyUsernameLabel());
	}
	
	@Test(priority = 3)
	public void clickOnContactLinkTest() {
		testUtil.swichToMainFrame();
		contactPage = homePage.clickOnContactLink();	
	}
		
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}	

}
