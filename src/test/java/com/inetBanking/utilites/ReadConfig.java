package com.inetBanking.utilites;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;                              // first we need to create an object for properties 
	
	public ReadConfig() {         // create a constructer inorder to read the values from config.properties file
		
		File src=new File("./Configuration/config.properties");
		
		try {
			
			FileInputStream fis = new FileInputStream(src);   // inorder to read from the file
			pro = new Properties();
			pro.load(fis);
			
		}catch(Exception e) {
			System.out.println("Exception is " +e.getMessage());
		}
	}
	
	public String getApplicationURL() {
		String urL=pro.getProperty("baseUrl");
			return urL;
	}
	
	public String getusername() {
		String username=pro.getProperty("username");
			return username;
	}
	
	public String getpassword() {
		String password=pro.getProperty("password");
			return password;
	}
	
	
	public String getchromepath() {
		String chromepath=pro.getProperty("chromepath");
			return chromepath;
	}
	
	public String getfirefoxpath() {
		String firefoxpath=pro.getProperty("firefoxpath");
			return firefoxpath;
	}
	
	public String getiepath() {
		String iepath=pro.getProperty("iepath");
			return iepath;
	}
	
	
	
	
}
