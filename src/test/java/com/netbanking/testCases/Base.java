package com.netbanking.testCases;

import java.io.File;
import java.io.IOException;


import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.netbanking.utilities.ReadConfig;

public class Base {
	
	ReadConfig rc = new ReadConfig();
	
	public String url = rc.getURL();
	public String uid = rc.getUsername();
	public String pwd = rc.getPassword();
	public WebDriver driver;
	public static Logger logger;
	
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br){
		
		logger = LogManager.getLogger("Banking");
		
		if(br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",rc.getChrome());
			driver = new ChromeDriver();
			//driver.manage().window().maximize();	
		}
		else if(br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",rc.getFireFox());
			driver = new FirefoxDriver();
			//driver.manage().window().maximize();
		}
		else if(br.equals("msedge")) {
			System.setProperty("webdriver.edge.driver",rc.getEdge());
			driver = new EdgeDriver();
			//driver.manage().window().maximize();
		}
		
		
		driver.get(url);
		
	}
	
	@AfterClass
	public void cleanup() {
		driver.quit();
	}
	public void getScreenshot(WebDriver driver,String screenshotName) throws IOException
	{
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		
		//After execution, you could see a folder "Failed Test Cases ScreenShots" under src folder
		
		File target = new File (System.getProperty("user.dir") + "/Screenshots/"+ screenshotName + ".png");		
		FileUtils.copyFile(source, target);		
		System.out.println("Screenshot taken");
	}
	public String randomestring()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(8);
		return(generatedstring);
	}
	
//	public static String randomeNum() {
//		String generatedString2 = RandomStringUtils.randomNumeric(4);
//		return (generatedString2);
//	}
}
