package com.netbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	
	public ReadConfig() {
		
		File src = new File("E:\\Selenium\\netbanking\\Configurations\\config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		}
		catch(Exception e) {
			System.out.println("Exception is " +e.getMessage());
			
		}
	}
	
	public String getURL() {
		String url = pro.getProperty("url");
		return url;
	}
	
	public String getUsername() {
		String uid = pro.getProperty("uid");
		return uid;
	}
	
	public String getPassword() {
		String pwd = pro.getProperty("pwd");
		return pwd;
	}
	
	public String getChrome() {
		String chrome = pro.getProperty("chromepath");
		return chrome;
	}
	
	public String getFireFox() {
		String firefox = pro.getProperty("firefoxpath");
		return firefox;
	}
	
	public String getEdge() {
		String msedge = pro.getProperty("edgepath");
		return msedge;
	}


}
