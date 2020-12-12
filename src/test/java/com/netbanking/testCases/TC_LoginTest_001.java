package com.netbanking.testCases;


import java.io.IOException;

import org.testng.annotations.Test;

import com.netbanking.pageObjects.LoginPage;

import junit.framework.Assert;

public class TC_LoginTest_001 extends Base{
	
	@Test
	public void loginTest() throws IOException {		
		
		
		driver.get(url);
		
	    logger.info("Opened URL");
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(uid);
		logger.info("Entered User Name");
		lp.setPassword(pwd);
		logger.info("Entered Password");
		lp.Click();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")){
			
			Assert.assertTrue(true);
			logger.info("Login Successful");
		}
		else {
			getScreenshot(driver,"LoginTest");			
			Assert.assertTrue(false);
			logger.info("Login Failed");
		}
				
		
		
	}

}
