package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.qa.util.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {
		try {
			prop = new Properties();
			
			FileInputStream fi = new FileInputStream("/Users/shams/eclipse-workspace/FreeCRMTest/src/main/"
					+ "java/com/crm/qa/config/config.properties");
			prop.load(fi);
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();	
		}
	}
	public static void initialization() throws InterruptedException {
		String browserName = prop.getProperty("browser");
		
	if(browserName.equals("chrome")){
		System.setProperty("webdriver.chrome.driver", "/Users/shams/Downloads/chromedriver");
		driver = new ChromeDriver();
	}else if(browserName.equals("firefox")){
		System.setProperty("webdriver.gecko.driver", "/Users/shams/Downloads/geckodriver");
		driver = new FirefoxDriver();
	}
	//driver.manage().window().fullscreen();
	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	
	driver.get(prop.getProperty("url"));		
	}

}
