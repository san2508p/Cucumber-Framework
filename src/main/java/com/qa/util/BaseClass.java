package com.qa.util;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.qa.util.ConfigDataProvider;


public class BaseClass {
	
	
	public static WebDriver driver;
	public static ConfigDataProvider config;
	
	public static void setup() throws IOException{
		config= new ConfigDataProvider();
		driver=BrowserFactory.startApplication(config.getBrowser(),config.getURL());
		//driver=BrowserFactory.startApplication("Chrome", "djfhjsdfhks");
		
	}
	
	public static void TearDown() throws IOException{
	driver.close();
		
	}

}
