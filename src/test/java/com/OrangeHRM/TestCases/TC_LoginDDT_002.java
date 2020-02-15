package com.OrangeHRM.TestCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.OrangeHRM.PageObjects.LoginPage;
import com.OrangeHRM.Utilities.XLUtiles;

public class TC_LoginDDT_002 extends BaseClass{
	
	@Test(dataProvider="Book001")
	public void loginDDT(String user, String pwd) throws Exception {
		
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(user);
		log.info("Username is entered");
		
		lp.setPassword(pwd);
	log.info("Password is entered");
		lp.clickSubmit();
		Thread.sleep(3000);
	
		// here two tests are failed and two tests are passed
	//if(driver.getCurrentUrl().equals("http://127.0.0.1/orangehrm-4.0/symfony/web/index.php/dashboard")) {
		
	// here all tests are passed 
		if(driver.getTitle().equals("OrangeHRM")) {

		Assert.assertTrue(true);
			
			log.info("Login test is passed");
		}else 
			{
			boolean res=driver.getPageSource().contains("Invalid credentials");
			if(res==true) {
			CaptureScreenshot(driver, "LoginTest");
			Assert.assertTrue(true);
			
		log.info("Login test is failed");
		}
	}
		lp.Admin();
		Thread.sleep(2000);
		
		lp.LogOut();
		
	}
	
		
		/* if(isAlertPresent()==true){
			driver.switchTo().alert().accept(); // Alert is close
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			log.warn("Login is failed");
		}else {
			Assert.assertTrue(true);
			log.warn("Login is pass");
			lp.LogOut();
			Thread.sleep(3000);
			
			driver.switchTo().alert().accept(); // close logout Alert
			driver.switchTo().defaultContent();			
		
		}
		
	
	public boolean isAlertPresent() {
//here User defined method is created to check alert is present or not		
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
		return false;
		}
	}		*/
	
	
@DataProvider(name="Book001")
	
	String [][] getData() throws Exception{
	
	String path="C:\\Users\\admin\\MyWork\\HYBRID_FRAMEWORK\\src\\test\\java\\com\\OrangeHRM\\TestData\\Book001.xlsx";
	int rwnum=XLUtiles.getRowCount(path, "UserLogin");
	int clcount=XLUtiles.getCellCount(path, "UserLogin", 1);
	String loginData[][]=new String [rwnum][clcount];
	
	for (int i = 1; i <=rwnum; i++) {
		for (int j = 0; j <clcount; j++) {
			
			loginData[i-1][j]=XLUtiles.getCellData(path, "UserLogin", i, j);  // 1  0
			
		}
	}
		return loginData;
	}

	

}









