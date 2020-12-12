package com.netbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	public LoginPage(WebDriver rdriver){
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(name="uid")
	@CacheLookup
	WebElement UserName;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement Password;
	
	@FindBy(name="btnLogin")
	@CacheLookup
	WebElement loginbtn;
	
	@FindBy(xpath="//a[contains(text(),'Log out')]")
	@CacheLookup
	WebElement lnkLogout;
	
	public void setUserName(String uname) {
		UserName.sendKeys(uname);
	}
	
	public void setPassword(String pwd) {
		Password.sendKeys(pwd);
	}
	
	public void Click() {
		loginbtn.click();
	}
	
	public void clickLogout()
	{
		lnkLogout.click();
	}
}
