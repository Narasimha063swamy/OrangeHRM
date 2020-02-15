package com.OrangeHRM.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.OrangeHRM.PageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {
	
	@Test
	
	public void LoginTest() throws Exception {
		
		log.info("Url is opened");
		
		//driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		Thread.sleep(2000);
		
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		log.info("Username is entered");
		
		lp.setPassword(password);
		log.info("Password is entered");
		
		lp.clickSubmit();
		
		if(driver.getTitle().equals("OrangeHRM")) {
			Assert.assertTrue(true);
			
			log.info("Login test is passed");
		}else 
			{
			CaptureScreenshot(driver, "LoginTest");
			Assert.assertTrue(false);
		log.info("Login test is failed");
		}
		
	}
}
