package com.OrangeHRM.TestCases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.OrangeHRM.PageObjects.AddEmployee;
import com.OrangeHRM.PageObjects.LoginPage;

public class TC_AddEmployeeTest_003 extends BaseClass {

	@Test
	public void addemployee() throws Exception {
		
		LoginPage lp=new LoginPage(driver);
		
		Thread.sleep(3000);
		
		lp.setUserName(username);
		log.info("Username is provided");
		
		lp.setPassword(password);
		log.info("Password is provided");
		
		lp.clickSubmit();
		
		Thread.sleep(2000);
		
		AddEmployee addemp=new AddEmployee(driver);
		addemp.pim();
		
		Thread.sleep(3000);
		addemp.add();
		
		log.info("Providing the Add Employee detailes...!");
		
		Thread.sleep(2000);
		addemp.firstName("ksisuseu");
		addemp.lastName("oeudytdt");
				
		Thread.sleep(3000);
		
		JavascriptExecutor Jv=(JavascriptExecutor)driver;
		Jv.executeScript("window.scrollBy(0,200)");
		
		addemp.CHECK();
		
		log.info("Create login details is provided...!");
		
		addemp.Username("ksujsudgtedf");
		addemp.Pass("jhon2323");
		addemp.Rpass("jhon2323");
		
		Thread.sleep(3000);
		
		addemp.ST("Enabled");
		
		addemp.Save();
		
		log.info("Validation is started...!");
		
		boolean res=driver.getPageSource().contains("Personal Details");
		if(res==true) {
			
			Assert.assertTrue(true);
			log.info("Test is passed");
		}else
		{
			CaptureScreenshot(driver, "AddEmployee");
			Assert.assertTrue(false);
		log.info("Test is failed");
		
		}
	}
	
}









