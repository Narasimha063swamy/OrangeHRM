package com.OrangeHRM.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddEmployee {

WebDriver ldriver;
	
	public AddEmployee(WebDriver rdriver){
		
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(linkText="PIM")
	WebElement pim;
	
	@FindBy(linkText="Add Employee")
	WebElement add;
	
	@FindBy(name="firstName")
	WebElement fst;
	
	@FindBy(name="lastName")
	WebElement lst;
	
	@FindBy(id="chkLogin")
	WebElement check;
	
	@FindBy(id="user_name")
	WebElement un;
	
	@FindBy(id="user_password")
	WebElement up;
	
	@FindBy(id="re_password")
	WebElement rp;
	
	@FindBy(id="status")
	WebElement st;
	
	
	@FindBy(id="btnSave")
	WebElement save;		

	public void pim() {
		pim.click();
	}
		public void add() {
			add.click();
		}
		public void firstName(String fstnm ) {
			fst.sendKeys(fstnm);
		}
		public void lastName(String lstnm) {
			lst.sendKeys(lstnm);
			
		}

		public void CHECK() {
			check.click();
		}

		public void Username(String usrnm) {
			un.sendKeys(usrnm);
		}

		public void Pass(String pwd) {
			up.sendKeys(pwd);
		}

		public void Rpass(String rpwd) {
			rp.sendKeys(rpwd);
		}
		public void ST(String stus) {
			st.sendKeys(stus);
						
		}
		
		public void Save() {

			save.click();
		}				
	
	
	
}









