package com.qa.util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {
	
	public static WebDriver driver;
	
	
	public static WebDriver startApplication(String BrowserName, String appURL){
		
		if(BrowserName.equalsIgnoreCase("Chrome"))
		{
			
			System.setProperty("webdriver.chrome.driver", "Driver//chromedriver.exe");
			driver=	new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		
		else if (BrowserName.equalsIgnoreCase("Firefox")){
			System.setProperty("webdriver.gecko.driver", "Driver//geckodriver.exe");
			driver=	new FirefoxDriver();
		}
		
		else if (BrowserName.equalsIgnoreCase("IE")){
			System.setProperty("webdriver.ie.driver", "Driver//geckodriver.exe");
			driver=	new InternetExplorerDriver();
		}
		else
		{
			System.out.println(" Sorry we dnt support this browser");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(appURL);
		return driver;
	}

}
