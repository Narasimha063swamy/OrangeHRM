package com.OrangeHRM.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver){
		
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	@FindBy(name="txtUsername")
	WebElement Uid;
	
	@FindBy(name="txtPassword")
	WebElement Pwd;
	
	@FindBy(name="Submit")
	WebElement btn;
	
	@FindBy(id="welcome")
	WebElement admin;
	
	@FindBy(linkText="Logout")
	WebElement logout;
	
	public void setUserName(String Uname) {
	Uid.sendKeys(Uname);
	}
	public void setPassword(String Pass) {
		Pwd.sendKeys(Pass);
	}
	public void clickSubmit() {
		btn.click();
	}
	public void Admin() {
		admin.click();
		
	}
	public void LogOut() {

		logout.click();
	}	
	
}





