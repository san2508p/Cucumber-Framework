package com.qa.Pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.ExcelDataProvider;
import com.qa.util.BaseClass;
import com.qa.util.MyUIUtils;

public class LoginPage extends BaseClass {
	
	
	@FindBy(xpath="//input[@name='username']")
	public WebElement Login_UserName_ED;
	
	
	@FindBy(xpath="//input[@name='password']")
	public WebElement Login_Password_ED;
	
	
	@FindBy(xpath="//button[@class = 'btn btn-primary btn-block']")
	public WebElement Login_Login_BT;

	@FindBy(xpath="//div[@class='loader']")
	public WebElement Login_loader;

	
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	
	public void ValidLogin() throws IOException, InterruptedException{
		Thread.sleep(5000);
		MyUIUtils.Input(Login_UserName_ED,ExcelDataProvider.getStringData("Login",0,0));
		MyUIUtils.Input(Login_Password_ED,ExcelDataProvider.getStringData("Login",0,1));
		Login_Login_BT.click();
	}
	
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}

}
