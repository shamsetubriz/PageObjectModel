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

public class ContactPageTest extends TestBase{
	
	ContactPage contactPage;
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	
	public ContactPageTest() {
		super();
	}
	
	@BeforeMethod
	public void SetUp() throws InterruptedException {
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		contactPage = new ContactPage();
		homePage = loginPage.logIn(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.swichToMainFrame();
		contactPage = homePage.clickOnContactLink();
		
		}
	
	@Test(priority = 1)
	public void verifyContactLogoTest() {
		//homePage.clickOnContactLink().
		Assert.assertTrue(contactPage.verifyContactLogo(), "Contact Logo is not matched");
	}
	
	@Test(priority = 2)
	public void selectSingleContactByNameTest() {
		contactPage.selectContactByName("ayaat shams");
	}
	
	@Test(priority = 3)
	public void selectMultipleSingleContactByNameTest() throws InterruptedException {
		contactPage.selectContactByName("ayaat shams");
		contactPage.selectContactByName("qurrat shams");
		Thread.sleep(3000);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
	
	

	
	
	
	
	


